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
        <title>超市前台收银系统</title>
        <link rel="stylesheet" href="../../layui/css/layui.css" />
    </head>
    <style>
        body{
        	background: #92B8B1;
        }
        .rg_layout{
            width: 1100px;
            border: 5px solid #EEEEEE;
            background-color: white;
            margin: auto;
            margin-top: 1%;
            text-align: center;
        }
        .rg_center{
            color: #757575;
            margin: 15px;
            text-align: center;
        }
        .layui-form-label{
        	width: 70px;
        }
        .coles{
        	color: red;
        }
        .boder_div{
        	margin: 15px;
        }
        .layui-table{
        	margin-top: 0px;
        }
        .layui-form-mid{
        	float: right;
        	display: inline-block;
        	margin-right: 0px;
        }
        .layui-form-item .layui-input-inline{
        	margin-right:0px;
        }
    </style>
    <body>
    	<div class="rg_layout">
	        <div class="rg_center" >
                <div style="height: 500px;border: 1px solid #ccc;">
                	<form action="" method="post" class="layui-form">
	                    <table class="layui-table">
						  
						  <thead>
						    <tr>
						      <th>序号</th>
						      <th>商品编号</th>
						      <th>商品名称</th>
						      <th>单价</th>
						      <th>折扣</th>
						      <th>数量</th>
						      <th>金额小计</th>
						      <th>操作</th>
						    </tr> 
						  </thead>
						  <tbody id="tables">
						    
						  </tbody>
						</table>
                	</form>
                </div>
                <hr />
                <div class="boder_div">
                	<div class="layui-row" style="margin-bottom: 10px;">
					    <div class="layui-col-lg4">
					      	<label class="layui-form-label">商品编号：</label>
						    <div class="layui-input-block">
						      <input type="text" class="layui-input" id="spNumber">
						    </div>
					    </div>
					    <div class="layui-col-lg3">
					      	<label class="layui-form-label">数量：</label>
						    <div class="layui-input-block">
						      <input type="text" id="anoumt" class="layui-input" value="1">
						    </div>
					    </div>
					    <div class="layui-col-lg3">
					      	<label class="layui-form-label">销售单价：</label>
						    <div class="layui-input-block">
						      <input type="text" name="price_min" class="layui-input" value="0.00">
						    </div>
					    </div>
					    <div class="layui-col-lg2">
					      	<label class="layui-form-label">折扣：</label>
						    <div class="layui-input-block">
						      <input type="text" name="price_min" class="layui-input" value="0">
						    </div>
					    </div>
					</div>
					<div class="layui-row">
					    <div class="layui-col-lg4">
					      	<label class="layui-form-label">流水账号：</label>
						    <div class="layui-input-block">
						      <input type="text" class="layui-input" id="serialNum" disabled>
						    </div>
					    </div>
					    <div class="layui-col-lg3">
					      	<label class="layui-form-label">应付：</label>
						    <div class="layui-input-block">
						      <input type="text" id="dealWith" class="layui-input coles" value="0">
						    </div>
					    </div>
					    <div class="layui-col-lg3">
					      	<label class="layui-form-label">实收金额：</label>
						    <div class="layui-input-block">
						      <input type="text" id="practicalMoney" class="layui-input" style="color: blue;" value="0">
						    </div>
					    </div>
					    <div class="layui-col-lg2">
					      	<label class="layui-form-label">找零：</label>
						    <div class="layui-input-block">
						      <input type="text" id="addChange" class="layui-input coles" value="0">
						    </div>
					    </div>
					</div>
                </div>
                <hr />
                <div class="boder_div">
                	<div class="layui-row layui-col-space10" style="text-align: left;">
					    <div class="layui-col-lg4">
					      	[超市前台收银系统]&nbsp;&nbsp;&nbsp;&nbsp;V1.0&nbsp;版权所有：海豚超市
					    </div>
					    <div class="layui-col-lg4">
					    	<p style="color: Maroon;">[提示]：按F7键可进入结算&nbsp;&nbsp;&nbsp;按F10退出系统</p>
					    </div>
					    <div class="layui-col-lg2" style="text-align: center;">
					      	收银员：<span>${salespersons.spname}</span>
					    </div>
					    <input value="${salespersons.salesPersonId}" style="display: none" id="salesPersonId">
					</div>
                	
                </div>
                
	        </div>
	    </div>
		<script type="text/javascript" src="../../layui/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="../../layui/layui.js"></script>
		<script>
			//表格内容
			var countText;
			//序号
			var idx = 0;
			function delectHtml(t){
				var rmoney=0;//应付
			  	$(t).parents(".tabletr").remove();
			  	var idValues=$("#tables").find("tr");
			  	for(var i = 0; i < idValues.length; i++){
			  		$(idValues[i]).find("td[name='idxName']").text(i+1);
			  		var addmoneys2=$(idValues[i]).find("td[name='addmoneys']").text();
					rmoney=addmoneys2*1+rmoney;
			  	}
			  	countText=$("#tables").html();
			  	$("#dealWith").val(rmoney);
			  	idx=idValues.length;
			}
			//实收金额 -->找零
			$("#practicalMoney").change(function(){
				var practicalMoney =$("#practicalMoney").val();//实收金额
				var dW =$("#dealWith").val();//应付金额
				$("#addChange").val((practicalMoney*100-dW*100)/100);
				$("#spNumber").val("");
				
			});
			
			
			layui.use(['layer', 'form'], function(){
			  	var layer = layui.layer
			  	,form = layui.form;
			  
			  	layer.msg('欢迎进入海豚前台收银系统');
				//数量
				var anoumt=$("#anoumt").val();
				//生成流水账号	
				var myDate = new Date();
				$("#serialNum").val(myDate.getTime());
				//商品编号改变事件
				$("#spNumber").change(function(){
					$("#anoumt").val(1);
					var number = $("#spNumber").val();
					if(number.trim()!=""){
						$.post("${ctx}/receptionLogin/selectProductId?productId="+number,function(data){
							//商品编码相同数量加一
							var idValue=$("#tables").find("tr");
							var record=-1;
						  	for(var i = 0; i < idValue.length; i++){
						  		var productIds=$(idValue[i]).find("td[name='productIds']").text();
						  		if(productIds==data.productId){
						  			record=i;
						  		}
						  	}
						  	if(record!=-1){
						  		var anoumts= $(idValue[record]).find("td[name='anoumts']").text();
						  		$(idValue[record]).find("td[name='anoumts']").text(anoumts*1+1);
						  		var addmoney1=data.unitPrice*(anoumts*1+1);
						  		if(data.discount!=0){
						  			addmoney1=data.unitPrice*1*data.discount*(anoumts*1+1)/10;
						  		}
						  		$(idValue[record]).find("td[name='addmoneys']").text(addmoney1);
						  		countText=$("#tables").html();
						  	}else{
							  	var addmoney=data.unitPrice;
								if(data!=null){
									idx++;
								}
								if(data.discount!=0){
									addmoney=data.unitPrice*1*data.discount/10;
								}
								countText+='<tr class="tabletr">'
										      +'<td name="idxName">'+ idx +'</td>'
										      +'<td name="productIds">'+data.productId+'</td>'
										      +'<td name="productNames">'+data.productName+'</td>'
										      +'<td name="unitPrices">'+data.unitPrice+'</td>'
										      +'<td name="discounts">'+data.discount+'</td>'
										      +'<td name="anoumts">'+1+'</td>'
										      +'<td name="addmoneys">'+addmoney.toFixed(2)+'</td>'
										      +'<td><a class="layui-btn layui-btn-danger layui-btn-xs" onclick="delectHtml(this)">移除</a></td>'
										    +'</tr>';
								$("#tables").html(countText);
						  	}
						  	var trlength=$("#tables").find("tr");
							var addM = 0;
						  	for(var i = 0; i < trlength.length; i++){
						  		var addmoneys=$(trlength[i]).find("td[name='addmoneys']").text();
						  		addM=addmoneys*1+addM;
						  	}
						  	$("#dealWith").val(addM);
						});
					}
					
				});
				//数量改变事件
				$("#anoumt").change(function(){
					var bhId = $("#spNumber").val().trim();//商品编号
				  	var numbers = $("#anoumt").val().trim();//数量
				  	var rsMoney = 0; //应付
				  	var idValues=$("#tables").find("tr");
				  	for(var i = 0; i < idValues.length; i++){
				  		var productIds= $(idValues[i]).find("td[name='productIds']").text();
				  		if(bhId==productIds){
				  			$(idValues[i]).find("td[name='anoumts']").text(numbers);//数量
				  			var discounts2 = $(idValues[i]).find("td[name='discounts']").text().trim();//折扣
				  			var unitPrices2 = $(idValues[i]).find("td[name='unitPrices']").text().trim()*100;//单价
				  			var addmoney2=unitPrices2*numbers/100;
					  		if(discounts2!=0){
					  			addmoney2=unitPrices2*discounts2*numbers/10;
					  		}
					  		$(idValues[i]).find("td[name='addmoneys']").text(addmoney2.toFixed(2));
				  		}
				  		var addmoneys3=$(idValues[i]).find("td[name='addmoneys']").text();
						rsMoney=addmoneys3*1+rsMoney;
				  	}
				  	$("#dealWith").val(rsMoney);
				  	countText=$("#tables").html();
				});
				
				
				//键盘按下执行事件
			  	document.onkeydown=function(event){
				  	var e = event || window.event || arguments.callee.caller.arguments[0];
				  	if(e && e.keyCode==118){//113 按F2键 --118 F7
				    	layer.open({
				    	  type:1,
				    	  id: 'layerDemo', //防止重复弹出
						  title: '结算[按Enter键结算]',
						  content: '<form class="layui-form layui-form-pane" style="margin:23px"><div class="layui-form-item">'+
									    '<label class="layui-form-label">应收款：</label>'+
									    '<div class="layui-input-inline">'+
									      '<input type="text" placeholder="￥" style="color: Maroon;" class="layui-input" id="ysk">'+
									    '</div>'+
									    '<div class="layui-form-mid layui-word-aux">元</div>'+
									'</div>'+
									'<div class="layui-form-item">'+
									    '<label class="layui-form-label">实收款：</label>'+
									    '<div class="layui-input-inline">'+
									      '<input type="text" placeholder="￥" class="layui-input" id="ssk">'+
									    '</div>'+
									    '<div class="layui-form-mid layui-word-aux">元</div>'+
									'</div>'+
									'<hr />'+
									'<div class="layui-form-item">'+
									    '<label class="layui-form-label">会员号：</label>'+
									    '<div class="layui-input-inline">'+
									      '<input type="text" class="layui-input" id="member">'+
									    '</div>'+
									'</div></form>'
						});
						$("#ysk").val($("#dealWith").val().trim());
						$("#ssk").val($("#practicalMoney").val().trim());
						
				  }
				  if(e && e.keyCode==121){//按F10键
				  	if(confirm("确定要退出？")) {
						var logId = $("#logId").val();
						window.location.href = "${ctx}/receptionLogin/toLogin";
					}
				  }
				  if(e && e.keyCode==13){//Enter键
				  		var member =$("#member").val();//会员号
				  		var serialNum=$("#serialNum").val();//流水账号
				  		var ysk =$("#ysk").val();//应付金额
				  		var ssk =$("#ssk").val();//实收金额
				  		var addChange=$("#addChange").val();//找零
				  		var salesPersonId=$("#salesPersonId").val();//售货员id
				  		
				  		
				  		//获取需要传输的数据
						var idValues=$("#tables").find("tr");
						//声明一个成功返回的条数
					    var ReturnLength = 0;
					    if (idValues.length==0) {
							layer.alert("没有需要结算的商品！", { title: '提示', icon: 0, offset: "100px;" });
						}else{
						    for (var i = 0; i < idValues.length; i++) {
								if (idValues.length > 0) {
						       		//for循环输出传递每个idValue的值//$(idValue[i]).val();
						       		for ( var i = 0; i < idValues.length; i++) {
								    	$.ajax({
								    		url:"${ctx}/receptionLogin/insertSS?memberId="+ member
								    		+"&totalMoney=" + ysk 
								    		+ "&realReceive=" + ssk
								    		+ "&returnMoney="+ addChange 
								    		+ "&salesPersonId=" + salesPersonId 
								    		+ "&serialNum=" + serialNum
								    		+ "&productId=" + $(idValues[i]).find("td[name='productIds']").text()
								    		+ "&productName="+$(idValues[i]).find("td[name='productNames']").text()
								    		+ "&unitPrice=" +$(idValues[i]).find("td[name='unitPrices']").text()
								    		+ "&discount=" + $(idValues[i]).find("td[name='discounts']").text()
								    		+ "&quantity="+ $(idValues[i]).find("td[name='anoumts']").text() 
								    		+ "&subTotalMoney=" + $(idValues[i]).find("td[name='addmoneys']").text(),
								    		type: "get",
						                    async: false,
						                    dataType: "json",
						                    success:function (data) {
						                    //通过Json返回拿到json传回来值data
								    		if (data==1) {
												ReturnLength++;
											} else {
								                layer.alert("结算失败，请检查商品是否合格", { icon: 0, title: '提示', offset: "100px" });
								            }
								          }
								    	});
									}if (ReturnLength == idValues.length) {
									     layer.alert("结算成功", { icon: 1, title: '提示', offset: "100px;" }, function (layerIndex) {
									         layer.close(layerIndex);//关闭提示框
									         location.reload();//刷新页面
									     });
								     };
							    }
							}
						}
				  }
			  	};
			  	
			  	
			});
			 
		</script>
 	</body>
</html>