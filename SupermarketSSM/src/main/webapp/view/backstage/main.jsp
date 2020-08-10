<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set  value="${pageContext.request.contextPath}"  scope="page"  var="ctx"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>超市后台管理系统</title>
		<link rel="stylesheet" href="../../layui/css/layui.css" />
		<link rel="stylesheet" href="../../layui/timePlug-in/jquery.flipcountdown.css" />
	</head>
	<style>
		.layui-layout {
			border: 1px solid #ccc;
		}
		
		.layui-header {
			box-shadow: 0px 0px 5px 0px #000;
		}
		
		.row_box {
			text-align: center;
			margin: 25px;
		}
		
		.functions {
			margin-top: 25px;
		}
		
		.imgs {
			width: 100%;
			height: 640px;
			/*border:1px solid #333;
    		box-shadow:inset 0 0 5px 5px #ccc;*/
    		
		}
		
		.mgesop {
			box-shadow: inset 0 0 5px #0c0c0c;
			border-bottom: 1px solid #666;
			border-left: 1px solid #2b2b2b;
			background: #1d1d1d;
		}
		
		.iuser_css{
			margin: 15px 15px 15px 0px;
		}
		.iuser_css_bottom{
			margin-bottom: 15px;
		}
		.selectsop{
			height: 38px;
		    line-height: 1.3;
		    line-height: 38px\9;
		    width: 134;
		    border-width: 1px;
		    border-style: solid;
		    background-color: #fff;
		    border-radius: 2px;
		    border: 1px solid #e6e6e6;
		}
		
		.margin_R{
			margin-right: 15px;
		}
	</style>

	<body>
		<div class="box1">
			<div class="box2"></div>
		</div>
		<div class="layui-layout layui-layout-admin">
			<div class="layui-header">
				<ul class="layui-nav layui-bg-blue ">
					<li class="layui-nav-item">
						<a href="javascript:;">系统</a>
						<dl class="layui-nav-child">
							<c:if test="${sysadmins.roleId == '1'}">
								<dd>
									<a href="javascript:;" id="userMenageMent"><i class="layui-icon layui-icon-group"></i>用户管理</a>
								</dd>
							</c:if>
							<dd>
								<a href="javascript:;" id="updatePassword1"><i class="layui-icon layui-icon-edit"></i>修改密码</a>
							</dd>
							<dd>
								<a href="javascript:;" id="logSelect1"><i class="layui-icon layui-icon-note"></i>日记查询</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="GetOut()"><i class="layui-icon layui-icon-close-fill"></i>退出系统</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">商品管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" id="insertCom3"><i class="layui-icon layui-icon-add-1"></i>添加商品</a>
							</dd>
							<dd>
								<a href="javascript:;" id="SPstorage3"><i class="layui-icon layui-icon-right"></i>商品入库</a>
							</dd>
							<dd>
								<a href="javascript:;" id="goodsMaintenance1"><i class="layui-icon layui-icon-util"></i>商品维护</a>
							</dd>
							<dd>
								<a href="javascript:;" id="PstorageManage2"><i class="layui-icon layui-icon-layouts"></i>库存管理</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">销售管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" id="salesStatistics1"><i class="layui-icon layui-icon-survey"></i>销售统计</a>
							</dd>
						</dl>
					</li>
				</ul>
				<ul class="layui-nav layui-layout-right">
					<li class="layui-nav-item">
						<a id="times" style="position: relative;left: 0px;height: 60px;top:12px"></a>
					</li>
					<li class="layui-nav-item">
						<a>【超市管理系统】&nbsp;&nbsp;V1.0</a>
					</li>
					<li class="layui-nav-item">
						<a>【管理员】：${sysadmins.adminName}</a>
						<input type="hidden" id="userid" value="${sysadmins.loginId}">
						<input type="hidden" id="user" value="${sysadmins.adminName}">
					</li>
				</ul>
			</div>
			<div class="layui-box">
				<div class="layui-row row_box">
					<div class="layui-col-sm3">
						<div class="site-demo-laydate layui-col-sm12">
							<div class="layui-inline" id="test-n1"></div>
						</div>
						<!--<span id="testView"></span>-->
						<div class="layui-col-sm12 functions">
							<button type="button" class="layui-btn layui-btn-normal" id="insertCom2">
								<i class="layui-icon layui-icon-add-1"></i>新增商品
							</button>
							<button type="button" class="layui-btn layui-btn-normal" id="SPstorage2">
								<i class="layui-icon layui-icon-right"></i>商品入库
							</button>
						</div>
						<div class="layui-col-sm12 functions">
							<button type="button" class="layui-btn layui-btn-normal" id="PstorageManage1"><i class="layui-icon layui-icon-layouts"></i>库存管理</button>
							<button type="button" class="layui-btn layui-btn-normal" id="goodsMaintenance2"><i class="layui-icon layui-icon-util"></i>商品维护</button>
						</div>
						<div class="layui-col-sm12 functions">
							<button type="button" class="layui-btn layui-btn-normal" id="salesStatistics2"><i class="layui-icon layui-icon-survey"></i>销售统计</button>
							<button type="button" class="layui-btn layui-btn-normal" id="logSelect2"><i class="layui-icon layui-icon-note"></i>日记查询</button>
						</div>
						<div class="layui-col-sm12 functions" style="margin-top: 50px;">
							<button type="button" class="layui-btn layui-btn-normal" id="updatePassword2"><i class="layui-icon layui-icon-edit"></i>修改密码</button>
							<button type="button" class="layui-btn layui-btn-normal" onclick="GetOut()"><i class="layui-icon layui-icon-close-fill"></i>退出系统</button>
						</div>
					</div>
					<div class="layui-col-sm9 mgesop">
						<img class="imgs" src="../../layui/images/15f45857b0084675163a3e7bbe7a1a2d.jpg" />
					</div>
					<input id="tests" value="1" style="display:none ;">
					<!--测试-->
					<input id="logId" value="${logId}" style="display:none ;">
				
					
					
				</div>
			</div>
		</div>
		<script type="text/javascript" src="../../layui/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="../../layui/layui.js"></script>
		<script type="text/javascript" src="../../layui/timePlug-in/jquery.flipcountdown.js"></script>

		<script>
			
			//---- 代表第一级 ----//  //代表下级     ////代表下下级   --》以此类推
			//---- 退出登录 ----//
			function GetOut() {
				if(confirm("确定要退出？")) {
					var logId = $("#logId").val();
					window.location.href = "${ctx}/login/removeSession?logId=" + logId;
				}
			};
			//---- 时间插件 ----//
			$("#times").flipcountdown();
			
			
			//---- 加载layui ----//
			layui.use(['layer', 'form', 'element', 'laydate', 'table'], function() {
				var layer = layui.layer,
					form = layui.form,
					element = layui.element,
					laydate = layui.laydate,
					table = layui.table;
				//---- 监听导航点击 ----//
				element.on('nav(demo)', function(elem) {
					//console.log(elem)
					layer.msg(elem.text());
				});
				//---- 日期组件 ----//
				laydate.render({
					elem: '#test-n1',
					position: 'static',
					change: function(value, date) { //监听日期被切换
						lay('#testView').html(value);
					}
				});
				
				//---- 用户管理 ----//
				$("#userMenageMent").click(function() {
					var UManagements = layer.open({
						type: 1,
						area: ['800px', '500px'],
						id: 'layerDemo3', //防止重复弹出
						title: '用户管理',
						content: '<div class="layui-row" style="margin:10px;text-align: center;">' +
							'<button class="layui-btn layui-btn-normal" id="insertM"><i class="layui-icon layui-icon-add-1"></i>添加</button>' +
							'<button class="layui-btn layui-btn-normal" id="updateM"><i class="layui-icon layui-icon-edit"></i>修改</button>' +
							'<button class="layui-btn layui-btn-danger" id="forbidden"><i class="layui-icon layui-icon-close"></i>禁用</button>' +
							'<button class="layui-btn" id="startUsing"><i class="layui-icon layui-icon-ok"></i>启用</button>' +
							'<button class="layui-btn layui-btn-normal" id="cougn"><i class="layui-icon layui-icon-close-fill"></i>关闭</button></div>' +
							'<table class="layui-hide" id="uManagement" lay-filter="test1"></table>'

					});
					//关闭
					$("#cougn").click(function() {
						layer.close(UManagements);
					});
					////添加
					$("#insertM").click(function() {
						$.post("${ctx}/userManage/selectLoginId",function(data){
							$("#loginId9").val(data+1);
						});
						insertAndUpdate('添加新用户');
					});
					////添加修改窗体
					function insertAndUpdate(titleVal){
						var iManagement = layer.open({
							type: 1,
							area: ['450px', '290px'],
							id: 'layerDemon2',//防止重复弹出
							title: titleVal,
							content: '<div class="layui-row layui-col-space10" style="margin:10px;text-align: center;">'
										+'<div class="layui-col-xs8">'
											+'<fieldset class="layui-elem-field site-demo-button ">'
												+'<legend>用户信息</legend>'
												+'<form action="" method="post" ><div class="iuser_css">'
													+'<div class="layui-col-xs12 iuser_css_bottom">'
														+'<label class="layui-form-label">登录账号：</label>'
														+'<div class="layui-input-block">'
															+'<input type="text" id="loginId9" class="layui-input" style="color: blue;" disabled>'
														+'</div>'
													+'</div>'
													+'<div class="layui-col-xs12 iuser_css_bottom">'
														+'<label class="layui-form-label">用户名称：</label>'
														+'<div class="layui-input-block">'
															+'<input type="text" id="loginName8" class="layui-input" style="color: blue;">'
														+'</div>'
													+'</div>'
													+'<div class="layui-col-xs12" style="text-align: left;">'
														+'<div class="layui-form-item">'
														    +'<label class="layui-form-label">用户类型：</label>'
														    +'<div class="layui-input-block">'
														      +'<select class="selectsop" id="roleIds">'
														        +'<option value="0" selected="">-- 请选择 --</option>'
														        +'<option value="1">超级管理员</option>'
														        +'<option value="2">普通管理员</option>'
														      +'</select>'
														    +'</div>'
														+'</div>'
													+'</div>'
												+'</div></form>'
											+'</fieldset>'
										+'</div>'
										+'<div class="layui-col-xs2" style="margin-top:15px">'
											+'<div class="layui-col-xs12" id="updateBtns" style="display:none">'
												+'<button type="button" class="layui-btn layui-btn-normal" id="updateUser"><i class="layui-icon layui-icon-edit"></i>修改用户</button>'
											+'</div>'
											+'<div class="layui-col-xs12" id="insertBtn">'
												+'<button type="button" class="layui-btn layui-btn-normal" id="insertUser"><i class="layui-icon layui-icon-add-1"></i>添加用户</button>'
											+'</div>'
											+'<div class="layui-col-xs12" style="height:110px"></div>'
											+'<div class="layui-col-xs12">'
												+'<button type="button" id="closeIUser" class="layui-btn layui-btn-normal"><i class="layui-icon layui-icon-close-fill"></i>关闭窗口</button>'
											+'</div>'
										+'</div>'
									+'</div>'

						});
						////添加用户
						$("#insertUser").click(function(){
							var loginName8 = $("#loginName8").val();
							var roleIds = $("#roleIds").val();
							$.post("${ctx}/userManage/insertSysadmins?loginname="+ loginName8 + "&roleid=" + roleIds,function(data){
								if(data==1){
									var closeR= layer.alert('新增成功,登录密码默认为：123456', {icon: 1},function(){
										layer.close(iManagement);
										layer.close(closeR);
										table.reload('uManagement');
									});
								}else{
									layer.msg('新增失败，请检查网络', {icon: 5,anim: 6});
								}
							});
						});
						////修改用户
						$("#updateUser").click(function(){
							var loginName8 = $("#loginName8").val();
							var roleIds = $("#roleIds").val();
							var loginid9 = $("#loginId9").val();
							$.post("${ctx}/userManage/updateSysadmins?loginname="+ loginName8 + "&roleid=" + roleIds+"&loginId="+loginid9,function(data){
								if(data==1){
									var closeR= layer.alert('修改成功', {icon: 1},function(){
										layer.close(iManagement);
										layer.close(closeR);
										table.reload('uManagement');
									});
								}else{
									layer.msg('修改失败，请检查网络', {icon: 5,anim: 6});
								}
							});
						});
						////关闭
						$("#closeIUser").click(function() {
							layer.close(iManagement);
						});
					}
					
					//查询表格
					table.render({
						elem: '#uManagement',
						height: 387,
						url: "${ctx}/userManage/selectUManage", //数据接口
						/*where: {
							type: "selectAboo"
						},*/
						page: true, //开启分页
						request: {
							pageName: 'curPage', //页码的参数名称，默认：page
							limitName: 'pageSize' //每页数据量的参数名，默认：limit
						},
						response: {
							statusName: 'success', //规定数据状态的字段名称，默认：code
							statusCode: true, //规定成功的状态码，默认：0
							countName: 'totalRows', //规定数据总数的字段名称，默认：count
							dataName: 'data' //规定数据列表的字段名称，默认：data
						},
						cols: [
							[ //表头
								{type: 'checkbox', fixed: 'left'},
								{
									type: 'numbers',
									title: '序号',
									width: '10%',
									align: 'center'
								}, {
									field: 'loginId',
									title: '登录账号',
									width: '23%',
									align: 'center'
								}, {
									field: 'adminName',
									title: '用户名称',
									width: '23%',
									align: 'center'
								}, {
									field: 'roleId',
									title: '用户类型',
									width: '24%',
									align: 'center',
									templet: function(d) {
										if(d.roleId == 1) {
											return '<span style="color: red;">超级管理员</span>'
										} else if(d.roleId == 2) {
											return '<span >普通管理员</span>'
										}
									}
								}, {
									field: 'adminStatus',
									title: '当前状态',
									width: '14%',
									align: 'center',
									templet: function(d) {
										if(d.adminStatus == 0) {
											return '<span style="color: red;">禁用</span>'
										} else if(d.adminStatus == 1) {
											return '<span style="color: #009688;">启用</span>'
										}
									}
								}
							]
						]
					});
					//修改
					$("#updateM").click(function() {
					
						var checkStatus = table.checkStatus('uManagement'); 
						if(checkStatus.data.length==1){
							insertAndUpdate('修改用户');
							$("#updateBtns").css("display","block");
							$("#insertBtn").css("display","none");
							$("#loginId9").val(checkStatus.data[0].loginId);
							$("#loginName8").val(checkStatus.data[0].adminName);
							$("#roleIds").val(checkStatus.data[0].roleId);
						}else if(checkStatus.data.length<1){
							layer.msg('请选择一条需要修改的用户信息', {icon: 0,anim: 6});
						}else if(checkStatus.data.length>1){
							layer.msg('只能选择一条用户信息进行修改', {icon: 0,anim: 6});
						}
					});
					//禁用
					$("#forbidden").click(function() {
						staicFunction("禁用","0");
					});
					//启用
					$("#startUsing").click(function() {
						staicFunction("启用","1");
					});
					//禁用启用共用方法
					function staicFunction(sizes,state){
						var checkStatus = table.checkStatus('uManagement'); 
						var ReturnLength = 0;
						if(checkStatus.data.length>=1){
							for ( var i = 0; i < checkStatus.data.length; i++) {
								if (checkStatus.data.length > 0) {
							       layer.confirm("确定要"+ sizes +"吗？",{
							           icon: 3,
							           btn: ['确定', '取消'],
							           offset: "200px"
							       },function(layerIndex){
							       		for ( var i = 0; i < checkStatus.data.length; i++) {
							       			//使用ajax提交到servlet
									    	$.ajax({
									    		url:"${ctx}/userManage/updataState?loginId=" + checkStatus.data[i].loginId+"&roleid="+state,
									    		type: "get",
							                    async: false,
							                    dataType: "json",
							                    success:function (data) {
								                    //通过Json返回拿到json传回来值data
										    		if (data==1) {
														ReturnLength++;
													} else {
										                layer.alert("用户"+sizes+"失败", { icon: 0, title: '提示', offset: "100px" });
										            }
										        }
									    	});
									    	//判断返回的数据与传输的数据是否相等ReturnLength == idValue.length
										}if (ReturnLength == checkStatus.data.length) {
										     layer.alert("用户"+ sizes +"成功", { icon: 1, title: '提示', offset: "100px;" }, function (layerIndex) {
										         layer.close(layerIndex);//关闭提示框
										         table.reload('uManagement');
										     });
									     };
							       })
							    }
							}
						}else if(checkStatus.data.length<1){
							layer.msg("请选择需要"+sizes+"用户信息", {icon: 0,anim: 6});
						}
					}
				});
				
				//---- 修改登录密码 ----//
				$("#updatePassword1").click(function(){
					updatePassword();
				});
				$("#updatePassword2").click(function(){
					updatePassword();
				});
				function updatePassword(){
					var UPassword = layer.open({
						type: 1,
						area: ['450px', '290px'],
						id: 'layerDemom1', //防止重复弹出
						title: '修改登录密码',
						content: '<div class="layui-row layui-col-space10" style="margin:10px;text-align: center;">'
									+'<form method="post" class="layui-form" >'
										+'<div class="layui-col-xs8">'
											+'<fieldset class="layui-elem-field site-demo-button ">'
												+'<legend>修改密码</legend>'
												+'<div class="iuser_css">'
													+'<div class="layui-col-xs12 iuser_css_bottom">'
														+'<label class="layui-form-label">原密码：</label>'
														+'<div class="layui-input-block">'
															+'<input type="hidden" name="userid" value="${sysadmins.loginId}">'
															+'<input type="password" name="ypassword" class="layui-input" >'
														+'</div>'
													+'</div>'
													+'<div class="layui-col-xs12 iuser_css_bottom">'
														+'<label class="layui-form-label">新密码：</label>'
														+'<div class="layui-input-block">'
															+'<input type="password" name="npassword" class="layui-input" >'
														+'</div>'
													+'</div>'
													+'<div class="layui-col-xs12 iuser_css_bottom">'
														+'<label class="layui-form-label">确认密码：</label>'
														+'<div class="layui-input-block">'
															+'<input type="password" name="qpassword" class="layui-input" >'
														+'</div>'
													+'</div>'
												+'</div>'
											+'</fieldset>'
										+'</div>'
										+'<div class="layui-col-xs2" style="margin-top:15px">'
											+'<div class="layui-col-xs12" id="">'
												+'<button  lay-submit lay-filter="demo9" type="submit" class="layui-btn layui-btn-normal" id="updateBtn"><i class="layui-icon layui-icon-edit"></i>提交修改</button>'
											+'</div>'
											+'<div class="layui-col-xs12" style="height:110px"></div>'
											+'<div class="layui-col-xs12">'
												+'<button type="button" id="closeIUPassword" class="layui-btn layui-btn-normal"><i class="layui-icon layui-icon-close-fill"></i>关闭窗口</button>'
											+'</div>'
										+'</div>'
									+'</form>'
								+'</div>'

					});
					//提交修改
					$("#updateBtn").click(function(){
						form.on('submit(demo9)', function(data){
							if(data.field.ypassword!=data.field.npassword){
								if(data.field.npassword==data.field.qpassword){
									$.post("${ctx}/login/updatePassword",data.field,function(data){
										if(data==1){
											var closeR= layer.alert('修改成功,请重新登录', {icon: 1},function(){
												window.location.href = "${ctx}/login/toLogin";
											});
										}else if(data==2){
											layer.msg('原密码错误', {icon: 5,anim: 6});
										}else{
											layer.msg('修改失败，请检查网络', {icon: 5,anim: 6});
										}
									});
								}else{
									layer.msg('前后密码不一致', {icon: 0,anim: 6});
								}
							}else{
								layer.msg('新密码不能与原密码一致', {icon: 0,anim: 6});
							}
							return false; 
						});
					});
					//关闭
					$("#closeIUPassword").click(function() {
						layer.close(UPassword);
					});
				}
				
				//----- 登录日志 ----//
				$("#logSelect1").click(function(){
					logSelect();
				});
				$("#logSelect2").click(function(){
					logSelect();
				});
				function logSelect(){
					layer.open({
						type: 1,
						area: ['1200px', '500px'],
						id: 'layerDemonl1', //防止重复弹出
						title: '登录日志查询',
						content: '<div class="layui-inline" style="margin-top:10px;">&nbsp;&nbsp;&nbsp;&nbsp;查询区间:&nbsp;&nbsp;<div class="layui-input-inline">' 
						    + '<input type="date" class="layui-input" id="logintimes"></div>&nbsp;&nbsp'
						    + '至&nbsp;&nbsp;<div class="layui-input-inline"><input type="date" class="layui-input" id="eixttimes"></div>' 
						    + '&nbsp;&nbsp;&nbsp;&nbsp;<button class="layui-btn" id="selectLL"><i class="layui-icon layui-icon-search"></i>查询</button></div>'
						    + '<table class="layui-hide" id="loginLogTable" lay-filter="test2"></table>'
	
					});
					//查询表格
					table.render({
						elem: '#loginLogTable',
						height: 387,
						url: "${ctx}/findInformation/selectLoginlogs", //数据接口
						/*where: {
							type: "selectAboo"
						},*/
						page: true, //开启分页
						request: {
							pageName: 'curPage', //页码的参数名称，默认：page
							limitName: 'pageSize' //每页数据量的参数名，默认：limit
						},
						response: {
							statusName: 'success', //规定数据状态的字段名称，默认：code
							statusCode: true, //规定成功的状态码，默认：0
							countName: 'totalRows', //规定数据总数的字段名称，默认：count
							dataName: 'data' //规定数据列表的字段名称，默认：data
						},
						cols: [
							[ //表头
								{
									type: 'numbers',
									title: '序号',
									width: '5.2%',
									align: 'center'
								}, {
									field: 'loginId',
									title: '登录账号',
									width: '20%',
									align: 'center'
								}, {
									field: 'spname',
									title: '用户名称',
									width: '21%',
									align: 'center'
								}, {
									field: 'serverName',
									title: '登录服务器',
									width: '18%',
									align: 'center'
								}, {
									field: 'loginTime',
									title: '登录时间',
									width: '18%',
									align: 'center'
								}, {
									field: 'exitTime',
									title: '退出时间',
									width: '18%',
									align: 'center'
								}
							]
						]
					});
					//点击查询
					$("#selectLL").click(function(){
						var logintime = $("#logintimes").val();
						var eixttime = $("#eixttimes").val();
						if(logintime == "" || logintime == undefined){
					    	logintime = "";
					    }
					    if(eixttime == "" || eixttime == undefined){
					    	eixttime = "";
					    }
					    table.reload('loginLogTable', {
						    where: {begintime:logintime,endtime:eixttime}
						    ,page: {
							    curr: 1 //重新从第 1 页开始
							 }
				        });
					});
					
				}
				
				
				//----- 销售统计 ----//
				$("#salesStatistics1").click(function(){
					salesStatistics();
				});
				$("#salesStatistics2").click(function(){
					salesStatistics();
				});
				function salesStatistics(){
					layer.open({
						type: 1,
						area: ['900px', '500px'],
						id: 'layerDemons1', //防止重复弹出
						title: '商品销售统计',
						content: '<div class="layui-inline" style="margin-top:10px;">&nbsp;&nbsp;&nbsp;&nbsp;统计区间 :&nbsp;&nbsp;<div class="layui-input-inline">' 
						    + '<input type="date" id="rends" class="layui-input"></div>&nbsp;&nbsp'
						    + '至&nbsp;&nbsp;<div class="layui-input-inline"><input type="date" id="endss" class="layui-input"></div>' 
						    + '&nbsp;&nbsp;&nbsp;&nbsp;<button class="layui-btn" id="kstj">开始统计</button></div>'
						    + '<table class="layui-hide" id="loginLogTable" lay-filter="test3"></table>'
	
					});
					//查询表格
					table.render({
						elem: '#loginLogTable',
						height: 387,
						url: "${ctx}/findInformation/selectSaleslist", //数据接口
						/*where: {
							type: "selectAboo"
						},*/
						page: true, //开启分页
						request: {
							pageName: 'curPage', //页码的参数名称，默认：page
							limitName: 'pageSize' //每页数据量的参数名，默认：limit
						},
						response: {
							statusName: 'success', //规定数据状态的字段名称，默认：code
							statusCode: true, //规定成功的状态码，默认：0
							countName: 'totalRows', //规定数据总数的字段名称，默认：count
							dataName: 'data' //规定数据列表的字段名称，默认：data
						},cols: [
							[   //表头
								{
									type: 'numbers',
									title: '序号',
									width: '7%',
									align: 'center'
								}, {
									field: 'productId',
									title: '商品编号',
									width: '23%',
									align: 'center'
								}, {
									field: 'productName',
									title: '商品名称',
									width: '23%',
									align: 'center'
								}, {
									field: 'categoryName',
									title: '商品分类',
									width: '23%',
									align: 'center'
								}, {
									field: 'unit',
									title: '计量单位',
									width: '12%',
									align: 'center'
								}, {
									field: 'quantity',
									title: '销售总量',
									width: '12%',
									align: 'center'
								}
							]
						]
						
					});
					//点击查询
					$("#kstj").click(function(){
						var rends = $("#rends").val();
						var endss = $("#endss").val();
						if(rends == "" || rends == undefined){
					    	rends = "";
					    }
					    if(endss == "" || endss == undefined){
					    	endss = "";
					    }
					    table.reload('loginLogTable', {
						    where: {begintime:rends,endtime:endss}
						    ,page: {
							    curr: 1 //重新从第 1 页开始
							 }
				        });
					});
					
				}
				
				
				//---- 商品维护 ----//
				$("#goodsMaintenance1").click(function(){
					goodsMaintenance();
					
				});
				$("#goodsMaintenance2").click(function(){
					goodsMaintenance();
					
				});
				function goodsMaintenance(){
					layer.open({
						type: 1,
						area: ['1200px', '550px'],
						id: 'layerDemong1', //防止重复弹出
						title: '商品信息维护',
						content: '<div class="layui-inline" style="margin-top:10px;">&nbsp;&nbsp;&nbsp;&nbsp;商品编码 :&nbsp;&nbsp;<div class="layui-input-inline">' 
						    + '<input type="text" id="sEncode" class="layui-input"></div>&nbsp;&nbsp'
						    + '商品名称 ：<div class="layui-input-inline"><input type="text" id="sName" class="layui-input"></div>'
						    +'<div class="layui-input-inline">'
							+'&nbsp;&nbsp商品分类 ：<select class="selectsop" style="margin-right:10px;" id="fenlei1" name="categoryId" lay-ignore>'
								+'<option value="0" selected="">-- 请选择 --</option>'
								+'<c:forEach items="${listCategory}" var="category">'
		    						+'<option value="${category.categoryId}">${category.categoryName}</option>'
		    					+'</c:forEach>'
							+'</select>'
							+'</div>'
						    + '&nbsp;&nbsp;&nbsp;&nbsp;<button class="layui-btn" id="selectSP"><i class="layui-icon layui-icon-search"></i>查询</button></div>'
						    + '<table class="layui-hide" id="sPresereve" lay-filter="test3"></table>'+
						    '<div class="layui-row" style="margin:10px;text-align: lefte;">' +
							'<button class="layui-btn layui-btn-normal" id="SPstorage1"><i class="layui-icon layui-icon-right"></i>商品入库</button>' +
							'<button class="layui-btn layui-btn-normal" id="insertCom1"><i class="layui-icon layui-icon-add-1"></i>添加</button>' +
							'<button class="layui-btn layui-btn-normal" id="updateCom"><i class="layui-icon layui-icon-edit"></i>修改</button>' +
							'<button class="layui-btn layui-btn-danger" id="deleteCom"><i class="layui-icon layui-icon-close"></i>删除</button>' +
							'&nbsp;&nbsp商品折扣 ：<div class="layui-input-inline"><input type="text" class="layui-input" style="width:60px" id="discountse" ></div>'+
							'&nbsp;&nbsp<button class="layui-btn layui-btn-normal" id="discount"><i class="layui-icon layui-icon-edit"></i>更新折扣</button></div>'

					});
					//查询表格
					table.render({
						elem: '#sPresereve',
						height: 387,
						url: "${ctx}/goodsMaintenance/selectSPData", //数据接口
						page: true, //开启分页
						request: {
							pageName: 'curPage', //页码的参数名称，默认：page
							limitName: 'pageSize' //每页数据量的参数名，默认：limit
						},
						response: {
							statusName: 'success', //规定数据状态的字段名称，默认：code
							statusCode: true, //规定成功的状态码，默认：0
							countName: 'totalRows', //规定数据总数的字段名称，默认：count
							dataName: 'data' //规定数据列表的字段名称，默认：data
						},
						cols: [
							[ //表头
								{   field: 'categoryId', title: 'ID',hide:true, align:'center'},
								{type: 'checkbox', fixed: 'left'},
								{
									type: 'numbers',
									title: '序号',
									width: '5.2%',
									align: 'center'
								}, {
									field: 'productId',
									title: '商品编号',
									width: '20%',
									align: 'center'
								}, {
									field: 'productName',
									title: '商品名称',
									width: '23%',
									align: 'center'
								}, {
									field: 'unit',
									title: '计量单位',
									width: '8%',
									align: 'center'
								}, {
									field: 'unitPrice',
									title: '单价',
									width: '7%',
									align: 'center'
								}, {
									field: 'discount',
									title: '当前折扣',
									width: '8%',
									align: 'center'
								}, {
									field: 'totalCount',
									title: '当前库存',
									width: '8%',
									align: 'center'
								}, {
									field: 'categoryName',
									title: '商品分类',
									width: '17%',
									align: 'center'
								}
							]
						]
					});
					//模糊查询
					$("#selectSP").click(function(){
						var sEncode = $("#sEncode").val();
					    var sName = $("#sName").val();
					    var fenlei1 = $("#fenlei1").val();
					    if(sEncode == ""|| sEncode == undefined){
					    	sEncode = "";
					    }
					    if(sName == ""|| sName == undefined){
					    	sName = "";
					    }
					    table.reload('sPresereve', {
						    where: {productId:sEncode,productName:sName,categoryId:fenlei1}
						    ,page: {
							    curr: 1 //重新从第 1 页开始
							 }
				        });
					});
					//添加
					$("#insertCom1").click(function(){
						insertCom();
					});
					//修改信息商品
					$("#updateCom").click(function(){
						var checkStatus = table.checkStatus('sPresereve'); 
						if(checkStatus.data.length==1){
							updateCom();
							$("#categoryId1").val(checkStatus.data[0].categoryId);
							$("#unit1").val(checkStatus.data[0].unit);
							$("#productId1").val(checkStatus.data[0].productId);
							$("#productName1").val(checkStatus.data[0].productName);
							$("#unitPrice1").val(checkStatus.data[0].unitPrice);
						}else if(checkStatus.data.length<1){
							layer.msg('请选择一条需要修改的商品信息', {icon: 0,anim: 6});
						}else if(checkStatus.data.length>1){
							layer.msg('只能选择一条商品信息进行修改', {icon: 0,anim: 6});
						}
					});
					function updateCom(){
						var closeUC = layer.open({
							type: 1,
							area: ['800px', '340px'],
							id: 'layerDemonUC1', //防止重复弹出
							title: '修改商品信息',
							content: '<div class="layui-row layui-col-space10" style="margin:10px;text-align: left;">'
										+'<form method="post" class="layui-form">'
											+'<div class="layui-col-xs12">'
												+'<fieldset class="layui-elem-field site-demo-button ">'
													+'<legend>商品信息</legend>'
													+'<div class="layui-col-xs7">'
														+'<div class="iuser_css">'
															+'<div class="layui-col-xs12 iuser_css_bottom">'
																+'<label class="layui-form-label">商品分类：</label>'
																+'<div class="layui-input-block">'
																	+'<select class="selectsop" style="margin-right:10px;" id="categoryId1" name="categoryId" lay-ignore>'
																		+'<option value="0" selected="">-- 请选择 --</option>'
																		+'<c:forEach items="${listCategory}" var="category">'
												    						+'<option value="${category.categoryId}">${category.categoryName}</option>'
												    					+'</c:forEach>'
																	+'</select>'
																+'</div>'
															+'</div>'
															+'<div class="layui-col-xs12 iuser_css_bottom">'
																+'<label class="layui-form-label">商品编码：</label>'
																+'<div class="layui-input-block">'
																	+'<input type="text" id="productId1" name="productId" class="layui-input" >'
																+'</div>'
															+'</div>'
															+'<div class="layui-col-xs12 iuser_css_bottom">'
																+'<label class="layui-form-label">商品名称：</label>'
																+'<div class="layui-input-block">'
																	+'<input type="text" id="productName1" name="productName" class="layui-input" >'
																+'</div>'
															+'</div>'
														+'</div>'
													+'</div>'
													+'<div class="layui-col-xs5" style="margin-top:15px">'
														+'<div class="layui-col-xs12" id="">'
															+'<label class="layui-form-label">计量单位：</label>'
															+'<div class="layui-input-block">'
																+'<select class="selectsop" id="unit1" name="unit" lay-ignore>'
																	+'<option value="0" selected="">-- 请选择 --</option>'
																	+'<c:forEach items="${listUnit}" var="un">'
											    						+'<option value="${un.unit}">${un.unit}</option>'
											    					+'</c:forEach>'
																+'</select>'
															+'</div>'
														+'</div>'
														+'<div class="layui-col-xs12" style="height:70px"></div>'
														+'<div class="layui-col-xs12">'
															+'<div class="layui-col-xs8">'
																+'<label class="layui-form-label">销售单价：</label>'
																+'<div class="layui-input-block">'
																	+'<input type="text" id="unitPrice1" name="unitPrice" class="layui-input" >'
																+'</div>'
															+'</div>'
														+'</div>'
													+'</div>'
												+'</fieldset>'
											+'</div>'
											+'<div class="layui-col-xs12" style="text-align: right;">'
												+'<button lay-submit lay-filter="demo3" type="submit" class="layui-btn layui-btn-normal" id="spUpdate" ><i class="layui-icon layui-icon-edit"></i>提交</button>'
												+'<button class="layui-btn layui-btn-normal" id="closeUC" type="button"><i class="layui-icon layui-icon-close"></i>关闭</button>'
											+'</div>'
										+'</form>'
									+'</div>'
		
						});
						////提交修改商品
						$("#spUpdate").click(function(){
							form.on('submit(demo3)', function(data){
								$.post("${ctx}/goodsMaintenance/updateSP",data.field,function(data){
									if(data==1){
										var closeR= layer.alert('修改成功', {icon: 1},function(){
											layer.close(closeUC);
											layer.close(closeR);
											table.reload('sPresereve');
										});
									}else{
										layer.msg('修改失败，请检查网络', {icon: 5,anim: 6});
									}
								});
								return false; 
							});
						});
						
						////关闭修改商品
						$("#closeUC").click(function(){
							layer.close(closeUC);
						});
						
					}
					
					//商品入库
					$("#SPstorage1").click(function(){
						SPstorage();
					});
					
					//删除商品
					$("#deleteCom").click(function(){
						var checkStatus = table.checkStatus('sPresereve'); 
						var ReturnLength = 0;
						if(checkStatus.data.length>=1){
							for ( var i = 0; i < checkStatus.data.length; i++) {
								if (checkStatus.data.length > 0) {
							       layer.confirm("删除的数据找不回，确定要删除吗？",{
							           icon: 3,
							           btn: ['确定', '取消'],
							           offset: "200px"
							       },function(layerIndex){
							       		for ( var i = 0; i < checkStatus.data.length; i++) {
							       			//使用ajax提交到servlet
									    	$.ajax({
									    		url:"${ctx}/goodsMaintenance/deleteProduct?productId=" + checkStatus.data[i].productId,
									    		type: "get",
							                    async: false,
							                    dataType: "json",
							                    success:function (data) {
								                    //通过Json返回拿到json传回来值data
										    		if (data==1) {
														ReturnLength++;
													} else {
										                layer.alert("删除失败", { icon: 0, title: '提示', offset: "100px" });
										            }
										        }
									    	});
									    	//判断返回的数据与传输的数据是否相等ReturnLength == idValue.length
										}if (ReturnLength == checkStatus.data.length) {
										     layer.alert("商品删除成功", { icon: 1, title: '提示', offset: "100px;" }, function (layerIndex) {
										         layer.close(layerIndex);//关闭提示框
										         table.reload('sPresereve');
										     });
									     };
							       })
							    }
							}
						}else if(checkStatus.data.length<1){
							layer.msg('请选择需要删除的商品信息', {icon: 0,anim: 6});
						}
						if(checkStatus.isAll==true){
							for ( var i = 0; i < checkStatus.data.length; i++) {
								if (checkStatus.data.length > 0) {
							       layer.confirm("您确定要删除所有查询到的数据？删除的数据找不回来，确定要删除吗？",{
							           icon: 3,
							           btn: ['确定', '取消'],
							           offset: "200px"
							       },function(layerIndex){
							       		//for循环输出传递每个idValue的值//$(idValue[i]).val()
							       		for ( var i = 0; i < checkStatus.data.length; i++) {
							       			//使用ajax提交到servlet
									    	$.ajax({
									    		url:"${ctx}/goodsMaintenance/deleteProduct?productId=" + checkStatus.data[i].productId,
									    		type: "get",
							                    async: false,
							                    dataType: "json",
							                    success:function (data) {
								                    //通过Json返回拿到json传回来值data
										    		if (data==1) {
														ReturnLength++;
													} else {
										                layer.alert("删除失败", { icon: 0, title: '提示', offset: "100px" });
										            }
										        }
									    	});
									    	//判断返回的数据与传输的数据是否相等ReturnLength == idValue.length
										}if (ReturnLength == checkStatus.data.length) {
										     layer.alert("商品删除成功", { icon: 1, title: '提示', offset: "100px;" }, function (layerIndex) {
										         layer.close(layerIndex);//关闭提示框
										         table.reload('sPresereve');
										     });
									    };
							       })
							    }
							}
						}
					});
					//更新商品折扣
					$("#discount").click(function(){
						var checkStatus = table.checkStatus('sPresereve'); 
						var discount = $("#discountse").val();
						var ReturnLength = 0;
						if(checkStatus.data.length>=1){
							for ( var i = 0; i < checkStatus.data.length; i++) {
								if (checkStatus.data.length > 0) {
							       layer.confirm("确定要把当前选中的所有商品折扣改为 " + discount +" 折",{
							           icon: 3,
							           btn: ['确定', '取消'],
							           offset: "200px"
							       },function(layerIndex){
							       		for ( var i = 0; i < checkStatus.data.length; i++) {
							       			//使用ajax提交到servlet
									    	$.ajax({
									    		url:"${ctx}/goodsMaintenance/updateDiscount?productId=" + checkStatus.data[i].productId + "&discount=" + discount,
									    		type: "get",
							                    async: false,
							                    dataType: "json",
							                    success:function (data) {
								                    //通过Json返回拿到json传回来值data
										    		if (data==1) {
														ReturnLength++;
													} else {
										                layer.alert("修改失败", { icon: 0, title: '提示', offset: "100px" });
										            }
										        }
									    	});
									    	//判断返回的数据与传输的数据是否相等ReturnLength == idValue.length
										}if (ReturnLength == checkStatus.data.length) {
										     layer.alert("商品折扣修改成功", { icon: 1, title: '提示', offset: "100px;" }, function (layerIndex) {
										         layer.close(layerIndex);//关闭提示框
										         table.reload('sPresereve');
										     });
									     };
							       })
							    }
							}
						}else if(checkStatus.data.length<1){
							layer.msg('请选择需要修改的商品折扣', {icon: 0,anim: 6});
						}
						if(checkStatus.isAll==true){
							for ( var i = 0; i < checkStatus.data.length; i++) {
								if (checkStatus.data.length > 0) {
							       layer.confirm("确定要把当前的所有商品折扣改为 " + discount +" 折",{
							           icon: 3,
							           btn: ['确定', '取消'],
							           offset: "200px"
							       },function(layerIndex){
							       		for ( var i = 0; i < checkStatus.data.length; i++) {
							       			//使用ajax提交到servlet
									    	$.ajax({
									    		url:"${ctx}/goodsMaintenance/updateDiscount?productId=" + checkStatus.data[i].productId + "&discount=" + discount,
									    		type: "get",
							                    async: false,
							                    dataType: "json",
							                    success:function (data) {
								                    //通过Json返回拿到json传回来值data
										    		if (data==1) {
														ReturnLength++;
													} else {
										                layer.alert("修改失败", { icon: 0, title: '提示', offset: "100px" });
										            }
										        }
									    	});
									    	//判断返回的数据与传输的数据是否相等ReturnLength == idValue.length
										}if (ReturnLength == checkStatus.data.length) {
										     layer.alert("商品折扣修改成功", { icon: 1, title: '提示', offset: "100px;" }, function (layerIndex) {
										         layer.close(layerIndex);//关闭提示框
										         table.reload('sPresereve');
										     });
									     };
							       })
							    }
							}
						}
						
					});
				}
				
				//---- 添加新商品 ----//
				$("#insertCom2").click(function(){
					
					insertCom();
				});
				$("#insertCom3").click(function(){
					insertCom();
				});
				function insertCom(){
					var closeIS = layer.open({
						type: 1,
						area: ['800px', '450px'],
						id: 'layerDemoni1', //防止重复弹出
						title: '添加新商品',
						content: '<div class="layui-row layui-col-space10" style="margin:10px;text-align: left;">'
									+'<form method="post" class="layui-form" id="iPsert">'
										+'<div class="layui-col-xs12">'
											+'<fieldset class="layui-elem-field site-demo-button ">'
												+'<legend>商品信息</legend>'
												+'<div class="layui-col-xs7">'
													+'<div class="iuser_css">'
														+'<div class="layui-col-xs12 iuser_css_bottom">'
															+'<label class="layui-form-label">商品分类：</label>'
															+'<div class="layui-input-block">'
																+'<select class="selectsop" style="margin-right:10px;" id="fenlei" name="categoryId" lay-ignore>'
																	+'<option value="0" selected="">-- 请选择 --</option>'
																	+'<c:forEach items="${listCategory}" var="category">'
											    						+'<option value="${category.categoryId}">${category.categoryName}</option>'
											    					+'</c:forEach>'
																+'</select>'
																+'<button class="layui-btn layui-btn-normal" id="suoding" type="button"><i class="layui-icon layui-icon-password"></i><span id="suodings">锁定</span></button>'
															+'</div>'
														+'</div>'
														+'<div class="layui-col-xs12 iuser_css_bottom">'
															+'<label class="layui-form-label">商品编码：</label>'
															+'<div class="layui-input-block">'
																+'<input type="text" name="productId" class="layui-input" >'
															+'</div>'
														+'</div>'
														+'<div class="layui-col-xs12 iuser_css_bottom">'
															+'<label class="layui-form-label">商品名称：</label>'
															+'<div class="layui-input-block">'
																+'<input type="text" name="productName" class="layui-input" >'
															+'</div>'
														+'</div>'
													+'</div>'
												+'</div>'
												+'<div class="layui-col-xs5" style="margin-top:15px">'
													+'<div class="layui-col-xs12" id="">'
														+'<label class="layui-form-label">计量单位：</label>'
														+'<div class="layui-input-block">'
															+'<select class="selectsop" id="jiliang" name="unit" lay-ignore>'
																+'<option value="0" selected="">-- 请选择 --</option>'
																+'<c:forEach items="${listUnit}" var="un">'
										    						+'<option value="${un.unit}">${un.unit}</option>'
										    					+'</c:forEach>'
															+'</select>'
														+'</div>'
													+'</div>'
													+'<div class="layui-col-xs12" style="height:70px"></div>'
													+'<div class="layui-col-xs12">'
														+'<div class="layui-col-xs8">'
															+'<label class="layui-form-label">销售单价：</label>'
															+'<div class="layui-input-block">'
																+'<input type="text" name="unitPrice" class="layui-input" >'
															+'</div>'
														+'</div>'
														/* +'<div class="layui-col-xs4">'
															+'<label class="layui-form-label" style="padding:9px 0px;color: brown;">只能是小数</label>'
														+'</div>' */
													+'</div>'
												+'</div>'
											+'</fieldset>'
										+'</div>'
										+'<div class="layui-col-xs12">'
											+'<fieldset class="layui-elem-field site-demo-button ">'
												+'<legend>库存预设</legend>'
													+'<div class="layui-col-xs7">'
														+'<div class="iuser_css">'
															+'<div class="layui-col-xs12 iuser_css_bottom">'
																+'<div class="layui-col-xs8">'
																	+'<label class="layui-form-label">最大库存：</label>'
																	+'<div class="layui-input-block">'
																	+'	<input type="text" name="maxCount" class="layui-input" >'
																	+'</div>'
																+'</div>'
															+'</div>'
														+'</div>'
													+'</div>'
													+'<div class="layui-col-xs5" style="margin-top:15px">'
													+'	<div class="layui-col-xs10">'
													+'		<label class="layui-form-label">最小库存：</label>'
													+'		<div class="layui-input-block">'
													+'			<input type="text" name="minCount" class="layui-input" >'
													+'		</div>'
													+'	</div>'
													+'</div>'
											+'</fieldset>'
										+'</div>'
										+'<div class="layui-col-xs12" style="text-align: right;">'
											+'<button lay-submit lay-filter="demo1" type="submit" class="layui-btn layui-btn-normal" id="insertProduct"><i class="layui-icon layui-icon-add-1"></i>添加</button>'
											+'<button class="layui-btn layui-btn-normal" id="closeIS" type="button"><i class="layui-icon layui-icon-close"></i>关闭</button>'
										+'</div>'
									+'</form>'
								+'</div>'
								
					});
					////锁定
					$("#suoding").click(function(){
						var testsVal= $("#tests").val();
						if(testsVal==1){
							$("#fenlei").attr('disabled',"");
							$("#jiliang").attr('disabled',"");
							$("#suodings").text('解锁');
							$("#tests").val(0);
						}else if(testsVal==0){
							$("#fenlei").removeAttr('disabled');
							$("#jiliang").removeAttr('disabled');
							$("#suodings").text('锁定');
							$("#tests").val(1);
						}
					});
					//添加商品按钮
					$("#insertProduct").click(function(){
						
						form.on('submit(demo1)', function(data){
							$.post("${ctx}/goodsMaintenance/insertProduct",data.field,function(data){
								if(data==1){
									var iust =  layer.confirm('添加成功，是否继续添加', {
									  btn: ['确定', '取消']
									}, function(index, layero){
									  document.getElementById("iPsert").reset();
									  layer.close(iust);
									  table.reload('sPresereve');
									}, function(index){
									  layer.close(closeIS);
									});
								}else{
									layer.msg('添加商品失败', {icon: 5,anim: 6});
								}
							});
							return false; 
						});
						 
						 
					});
										
					////关闭添加商品
					$("#closeIS").click(function(){
						layer.close(closeIS);
					});
					
				}
				//---- 商品入库 ----//
				$("#SPstorage2").click(function(){
					SPstorage();
				});
				$("#SPstorage3").click(function(){
					SPstorage();
				});
				function SPstorage(){
					var closeRK = layer.open({
						type: 1,
						area: ['800px', '290px'],
						id: 'layerDemonUC1', //防止重复弹出
						title: '到货商品入库',
						content: '<div class="layui-row layui-col-space10" style="margin:10px;text-align: left;">'
									+'<div class="layui-col-xs12">'
										+'<fieldset class="layui-elem-field site-demo-button ">'
											+'<legend>商品数据</legend>'
											+'<form method="post" class="layui-form" id="storage">'
												+'<div class="layui-col-xs12">'
													+'<div class="layui-col-xs7">'
														+'<div class="iuser_css">'
															+'<div class="layui-col-xs12 iuser_css_bottom">'
																+'<label class="layui-form-label">商品编码：</label>'
																+'<div class="layui-input-block">'
																	+'<input type="text" name="productId" class="layui-input" id="rSPEncod">'
																+'</div>'
															+'</div>'
															+'<div class="layui-col-xs12 iuser_css_bottom">'
																+'<label class="layui-form-label">商品名称：</label>'
																+'<div class="layui-input-block">'
																	+'<input type="text" name="productName" id="spMC" class="layui-input" disabled>'
																+'</div>'
															+'</div>'
														+'</div>'
													+'</div>'
													+'<div class="layui-col-xs5" style="margin-top:15px;text-align:center;">'
														+'<div class="layui-col-xs12" id="">'
															+'<button lay-submit lay-filter="demo2" type="submit" class="layui-btn layui-btn-normal" id="rkAffirm" ><i class="layui-icon layui-icon-right"></i>入库确认</button>'
														+'</div>'
													+'</div>'
												+'</div>'
												+'<div class="layui-col-xs12" style="margin-bottom:20px">'
													+'<div class="layui-col-xs4">'
														+'<label class="layui-form-label">入库数量：</label>'
														+'<div class="layui-input-block">'
															+'<input type="text" name="totalCount" class="layui-input" >'
														+'</div>'
													+'</div>'
													+'<div class="layui-col-xs2">'
														+'<label class="layui-form-label" style="padding:9px 0px;color: brown;">必须是整数</label>'
													+'</div>'
													+'<div class="layui-col-xs4">'
														+'<label class="layui-form-label" style="padding:9px 0px;color: green;width:250px">如果是退货，则将入库数量改为负数。</label>'
													+'</div>'
												+'</div>'
											+'</form>'
										+'</fieldset>'
									+'</div>'
								+'</div>'
	
					});
					////当商品编码改变是查找商品名称
			        $("#rSPEncod").change(function(){
						var rSPEncod = $("#rSPEncod").val();
						if(rSPEncod.trim()!=""){
							$.post("${ctx}/goodsMaintenance/selectsName?productId="+rSPEncod,function(data){
								$("#spMC").val(data);
							});
						}
			        });
					////商品入库确认
					$("#rkAffirm").click(function(){
						form.on('submit(demo2)', function(data){
							$.post("${ctx}/goodsMaintenance/commodityStorage",data.field,function(data){
								if(data==1){
									var iust =  layer.confirm('商品入库成功，是否继续入库', {
									  btn: ['确定', '取消']
									}, function(index, layero){
									  document.getElementById("storage").reset();
									  layer.close(iust);
									  table.reload('sPresereve');
									}, function(index){
									  layer.close(closeRK);
									});
								}else{
									layer.msg('商品入库失败，请检查网络', {icon: 5,anim: 6});
								}
							});
							return false; 
						});
					});
				}
				////
				
				
				//---- 库存管理 ----//
				$("#PstorageManage1").click(function(){
					PstorageManage();
				});
				$("#PstorageManage2").click(function(){
					PstorageManage();
				});
				function PstorageManage(){
					var closeKC = layer.open({
						type: 1,
						area: ['1300px', '690px'],
						id: 'layerDemonUC1', //防止重复弹出
						title: '商品库存管理',
						content: '<div class="layui-row layui-col-space10" style="margin:10px;text-align: left;">'
									+'<div class="layui-col-xs12">'
										+'<fieldset class="layui-elem-field site-demo-button ">'
											+'<legend>商品库存查询</legend>'
											+'<form method="post" class="layui-form" >'
												+'<div class="layui-col-xs12">'
													+'<div class="layui-col-xs9">'
														+'<div class="iuser_css">'
															+'<div class="layui-col-xs4 iuser_css_bottom">'
																+'<label class="layui-form-label">商品编码：</label>'
																+'<div class="layui-input-block">'
																	+'<input type="text" class="layui-input" id="sEncode2" name="encode">'
																+'</div>'
															+'</div>'
															+'<div class="layui-col-xs4 iuser_css_bottom">'
																+'<label class="layui-form-label">商品名称：</label>'
																+'<div class="layui-input-block">'
																	+'<input type="text" class="layui-input" id="sName2" name="name">'
																+'</div>'
															+'</div>'
															+'<div class="layui-col-xs3">'
																+'<div class="layui-form-item">'
																    +'<label class="layui-form-label" style="padding:9px 0px;">商品分类:</label>'
																    +'<div class="layui-input-block">'
																	     +'<select class="selectsop" style="margin-right:10px;" id="categoryId2" name="categoryId" lay-ignore>'
																			+'<option value="0" selected="">-- 请选择 --</option>'
																			+'<c:forEach items="${listCategory}" var="category">'
													    						+'<option value="${category.categoryId}">${category.categoryName}</option>'
													    					+'</c:forEach>'
																		+'</select>'
																    +'</div>'
																+'</div>'
															+'</div>'
														+'</div>'
													+'</div>'
													+'<div class="layui-col-xs3" style="margin-top:15px;text-align:center;">'
														+'<div class="layui-col-xs12" id="">'
															+'<button lay-submit lay-filter="demo4" type="submit" class="layui-btn layui-btn-normal" id="selectSp1" ><i class="layui-icon layui-icon-search"></i>查询</button>'
														+'</div>'
													+'</div>'
												+'</div>'
											+'</form>'
										+'</fieldset>'
									+'</div>'
									+'<div class="layui-col-xs12">'
										+'<fieldset class="layui-elem-field site-demo-button ">'
											+'<legend>库存预警信息</legend>'/* &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;" style="color: cadetblue;">【刷新库存预警信息 】</a> */
											+'<div class="layui-col-xs12">'
												+'<form action="" method="post" class="layui-form" id="demo5s1">'
													+'<div class="layui-col-xs8">'
														+'<div class="iuser_css">'
															/* +'<div class="layui-col-xs4 iuser_css_bottom">'
																+'<label class="layui-form-label">预警总数：</label>'
																+'<div class="layui-input-block">'
																	+'<input type="text" name="counts1" class="layui-input" >'
																+'</div>'
															+'</div>' */
															+'<div class="layui-col-xs4 iuser_css_bottom">'
																+'<label class="layui-form-label" style="width: 100px;">超出库存上限：</label>'
																+'<div class="layui-input-block">'
																	+'<input type="text" name="upperX" class="layui-input" style="width: 130px;">'
																+'</div>'
															+'</div>'
															+'<div class="layui-col-xs3">'
																+'<button lay-submit lay-filter="demo5" type="submit" class="layui-btn layui-btn-normal" id="selectUpper" ><i class="layui-icon layui-icon-search"></i>显示超库存</button>'
															+'</div>'
													 	+'</div>'
													 +'</div>'
											 	+'</form>'
											 	+'<form action="" method="post" class="layui-form" id="demo6s1">'
													+'<div class="layui-col-xs4" style="margin-top:15px;text-align:center;">'
														+'<div class="layui-col-xs12" id="">'
															+'<div class="layui-col-xs8 iuser_css_bottom">'
																+'<label class="layui-form-label" style="width: 100px;">超出库存下限：</label>'
																+'<div class="layui-input-block">'
																	+'<input type="text" name="floorValue" class="layui-input" style="width: 130px;">'
																+'</div>'
															+'</div>'
															+'<div class="layui-col-xs4">'
																+'<button lay-submit lay-filter="demo6" type="submit" class="layui-btn layui-btn-normal" id="selectFloor" ><i class="layui-icon layui-icon-search"></i>显示低库存</button>'
															+'</div>'
														+'</div>'
													+'</div>'
												+'</form>'
											+'</div>'
										+'</fieldset>'
									+'</div>'
									+'<div class="layui-col-xs12">'
										+'<table class="layui-hide" id="KCManagement" lay-filter="test4"></table>'
									+'</div>'
									+'<div class="layui-col-xs12">'
										+'<div class="layui-col-xs7">'
											+'<fieldset class="layui-elem-field site-demo-button ">'
												+'<legend>库存预警设置</legend>'
												+'<form action="" method="post" >'
													+'<div class="layui-col-xs12">'
														+'<div class="iuser_css">'
															+'<div class="layui-col-xs5 iuser_css_bottom">'
																+'<label class="layui-form-label">最大库存：</label>'
																+'<div class="layui-input-block">'
																	+'<input type="text" id="maxCounts" class="layui-input" >'
																+'</div>'
															+'</div>'
															+'<div class="layui-col-xs4 iuser_css_bottom margin_R">'
																+'<label class="layui-form-label">最小库存：</label>'
																+'<div class="layui-input-block">'
																	+'<input type="text" id="minCounts" class="layui-input">'
																+'</div>'
															+'</div>'
															+'<div class="layui-col-xs2">'
																+'<button type="button" class="layui-btn layui-btn-normal" id="updateSZ" ><i class="layui-icon layui-icon-edit"></i>更新设置</button>'
															+'</div>'
														+'</div>'
													+'</div>'
												+'</form>'
											+'</fieldset>'
										+'</div>'
										+'<div class="layui-col-xs4">'
											+'<fieldset class="layui-elem-field site-demo-button ">'
												+'<legend>调整商品库存</legend>'
												+'<form action="" method="post" >'
													+'<div class="layui-col-xs12">'
														+'<div class="iuser_css">'
															+'<div class="layui-col-xs7 iuser_css_bottom margin_R">'
																+'<label class="layui-form-label">当前库存：</label>'
																+'<div class="layui-input-block">'
																	+'<input type="text" id="totalCounts" class="layui-input" >'
																+'</div>'
															+'</div>'
															+'<div class="layui-col-xs4">'
																+'<button type="button" class="layui-btn layui-btn-normal" id="updateKC" ><i class="layui-icon layui-icon-edit"></i>修改库存</button>'
															+'</div>'
														+'</div>'
													+'</div>'
												+'</form>'
											+'</fieldset>'
										+'</div>'
										+'<div class="layui-col-xs1" style="text-align: right;">'
											+'<button class="layui-btn layui-btn-normal" id="closeKC" style="margin-top:40px;" ><i class="layui-icon layui-icon-close"></i>关闭</button>'
										+'</div>'
									+'</div>'
								+'</div>'
	
					});
					
					//商品库存查询表格
					table.render({
						elem: '#KCManagement',
						height: 387,
						url: "${ctx}/commodityInventory/selectProductinventory", //数据接口
						/*where: {
							type: "selectAboo"
						},*/
						page: true, //开启分页
						request: {
							pageName: 'curPage', //页码的参数名称，默认：page
							limitName: 'pageSize' //每页数据量的参数名，默认：limit
						},
						response: {
							statusName: 'success', //规定数据状态的字段名称，默认：code
							statusCode: true, //规定成功的状态码，默认：0
							countName: 'totalRows', //规定数据总数的字段名称，默认：count
							dataName: 'data' //规定数据列表的字段名称，默认：data
						},
						cols: [
							[ //表头
								{type: 'checkbox', fixed: 'left'},
								{
									type: 'numbers',
									title: '序号',
									width: '6%',
									align: 'center'
								}, {
									field: 'productId',
									title: '商品编号',
									width: '20%',
									align: 'center'
								}, {
									field: 'productName',
									title: '商品名称',
									width: '22%',
									align: 'center'
								}, {
									field: 'unit',
									title: '计量单位',
									width: '8%',
									align: 'center'
								}, {
									field: 'maxCount',
									title: '最大库存',
									width: '10%',
									align: 'center'
								}, {
									field: 'totalCount',
									title: '当前库存',
									width: '10%',
									align: 'center'
								}, {
									field: 'minCount',
									title: '最小库存',
									width: '10%',
									align: 'center'
								}, {
									field: 'statusId',
									title: '库存状态',
									width: '10%',
									align: 'center',
									templet: function(d) {
										if(d.statusId == 1) {
											return '<span style="color: #22B14C;">正常</span>'
										} else if(d.statusId == -1) {
											return '<span style="color: red;">需填仓</span>'
										} else if(d.statusId == 2) {
											return '<span style="color: #FFC90E;">高于库存</span>'
										} else if(d.statusId == -2) {
											return '<span style="color: #ccc;">已清仓</span>'
										}
									}
								}
							]
						]
					});
					////查询
					$("#selectSp1").click(function(){
						form.on('submit(demo4)', function(data){
							table.reload('KCManagement', {
							    where: {productId:data.field.encode,productName:data.field.name,categoryId:data.field.categoryId}
							    ,page: {
								    curr: 1 //重新从第 1 页开始
								 }
					        });
							return false; 
						});
					});
					////显示超库存
					$("#selectUpper").click(function(){
						document.getElementById("demo6s1").reset();
						form.on('submit(demo5)', function(data){
							table.reload('KCManagement', {
							    where: {warningCount:data.field.counts1,upperLimit:data.field.upperX,floor:null}
							    ,page: {
								    curr: 1 //重新从第 1 页开始
								 }
					        });
							return false; 
						});
					});
					////显示低库存
					$("#selectFloor").click(function(){
						document.getElementById("demo5s1").reset();
						form.on('submit(demo6)', function(data){
							table.reload('KCManagement', {
							    where: {floor:data.field.floorValue,upperLimit:null}
							    ,page: {
								    curr: 1 //重新从第 1 页开始
								 }
					        });
							return false; 
						});
					});
					////更新设置
					$("#updateSZ").click(function(){
						var checkStatus = table.checkStatus('KCManagement'); 
						var maxCounts = $("#maxCounts").val();
						var minCounts = $("#minCounts").val();
						var ReturnLength = 0;
						if(checkStatus.data.length>=1){
							for ( var i = 0; i < checkStatus.data.length; i++) {
								if (checkStatus.data.length > 0) {
							       layer.confirm("确定修改当前所选的库存信息？",{
							           icon: 3,
							           btn: ['确定', '取消'],
							           offset: "200px"
							       },function(layerIndex){
							       		for ( var i = 0; i < checkStatus.data.length; i++) {
							       			//使用ajax提交到servlet
									    	$.ajax({
									    		url:"${ctx}/commodityInventory/updateInventory?productId=" + checkStatus.data[i].productId + "&maxCount=" + maxCounts + "&minCount="+minCounts,
									    		type: "get",
							                    async: false,
							                    dataType: "json",
							                    success:function (data) {
								                    //通过Json返回拿到json传回来值data
										    		if (data==1) {
														ReturnLength++;
													} else {
										                layer.alert("修改失败", { icon: 0, title: '提示', offset: "100px" });
										            }
										        }
									    	});
									    	//判断返回的数据与传输的数据是否相等ReturnLength == idValue.length
										}if (ReturnLength == checkStatus.data.length) {
										     layer.alert("库存信息更新成功", { icon: 1, title: '提示', offset: "100px;" }, function (layerIndex) {
										         layer.close(layerIndex);//关闭提示框
										         table.reload('KCManagement');
										     });
									     };
							       })
							    }
							}
						}else if(checkStatus.data.length<1){
							layer.msg('请选择需要修改的库存信息', {icon: 0,anim: 6});
						}
						if(checkStatus.isAll==true){
							for ( var i = 0; i < checkStatus.data.length; i++) {
								if (checkStatus.data.length > 0) {
							       layer.confirm("确定要修改所有的库存信息？修改了之后以前所有的信息都会改为当前修改的信息，请谨慎使用",{
							           icon: 3,
							           btn: ['确定', '取消'],
							           offset: "200px"
							       },function(layerIndex){
							       		for ( var i = 0; i < checkStatus.data.length; i++) {
							       			//使用ajax提交到servlet
									    	$.ajax({
									    		url:"${ctx}/commodityInventory/updateInventory?productId=" + checkStatus.data[i].productId + "&maxCount=" + maxCounts + "&minCount="+minCounts,
									    		type: "get",
							                    async: false,
							                    dataType: "json",
							                    success:function (data) {
								                    //通过Json返回拿到json传回来值data
										    		if (data==1) {
														ReturnLength++;
													} else {
										                layer.alert("修改失败", { icon: 0, title: '提示', offset: "100px" });
										            }
										        }
									    	});
									    	//判断返回的数据与传输的数据是否相等ReturnLength == idValue.length
										}if (ReturnLength == checkStatus.data.length) {
										     layer.alert("库存信息更新成功", { icon: 1, title: '提示', offset: "100px;" }, function (layerIndex) {
										         layer.close(layerIndex);//关闭提示框
										         table.reload('KCManagement');
										     });
									     };
							       })
							    }
							}
						}
					});
					////修改库存
					$("#updateKC").click(function(){
						var checkStatus = table.checkStatus('KCManagement'); 
						var totalCounts = $("#totalCounts").val();
						var ReturnLength = 0;
						if(checkStatus.data.length>=1){
							for ( var i = 0; i < checkStatus.data.length; i++) {
								if (checkStatus.data.length > 0) {
							       layer.confirm("确定修改当前所选的库存信息？",{
							           icon: 3,
							           btn: ['确定', '取消'],
							           offset: "200px"
							       },function(layerIndex){
							       		for ( var i = 0; i < checkStatus.data.length; i++) {
							       			//使用ajax提交到servlet
									    	$.ajax({
									    		url:"${ctx}/commodityInventory/updateICount?productId=" + checkStatus.data[i].productId + "&totalCount=" + totalCounts,
									    		type: "get",
							                    async: false,
							                    dataType: "json",
							                    success:function (data) {
								                    //通过Json返回拿到json传回来值data
										    		if (data==1) {
														ReturnLength++;
													} else {
										                layer.alert("修改失败", { icon: 0, title: '提示', offset: "100px" });
										            }
										        }
									    	});
									    	//判断返回的数据与传输的数据是否相等ReturnLength == idValue.length
										}if (ReturnLength == checkStatus.data.length) {
										     layer.alert("库存信息修改成功", { icon: 1, title: '提示', offset: "100px;" }, function (layerIndex) {
										         layer.close(layerIndex);//关闭提示框
										         table.reload('KCManagement');
										     });
									     };
							       })
							    }
							}
						}else if(checkStatus.data.length<1){
							layer.msg('请选择需要修改的库存信息', {icon: 0,anim: 6});
						}
						if(checkStatus.isAll==true){
							for ( var i = 0; i < checkStatus.data.length; i++) {
								if (checkStatus.data.length > 0) {
							       layer.confirm("确定要修改所有的库存信息？修改了之后以前所有的信息都会改为当前修改的信息，请谨慎使用",{
							           icon: 3,
							           btn: ['确定', '取消'],
							           offset: "200px"
							       },function(layerIndex){
							       		for ( var i = 0; i < checkStatus.data.length; i++) {
							       			//使用ajax提交到servlet
									    	$.ajax({
									    		url:"${ctx}/commodityInventory/updateICount?productId=" + checkStatus.data[i].productId + "&totalCount=" + totalCounts,
									    		type: "get",
							                    async: false,
							                    dataType: "json",
							                    success:function (data) {
								                    //通过Json返回拿到json传回来值data
										    		if (data==1) {
														ReturnLength++;
													} else {
										                layer.alert("修改失败", { icon: 0, title: '提示', offset: "100px" });
										            }
										        }
									    	});
									    	//判断返回的数据与传输的数据是否相等ReturnLength == idValue.length
										}if (ReturnLength == checkStatus.data.length) {
										     layer.alert("库存信息修改成功", { icon: 1, title: '提示', offset: "100px;" }, function (layerIndex) {
										         layer.close(layerIndex);//关闭提示框
										         table.reload('KCManagement');
										     });
									     };
							       })
							    }
							}
						}
					});
					////关闭商品库存管理
					$("#closeKC").click(function(){
						layer.close(closeKC);
					});
				}
				
			});
		</script>
	</body>

</html>