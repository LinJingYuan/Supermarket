<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" scope="page" var="ctx"></c:set>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>海豚超市后台管理系统</title>
       	<link rel="stylesheet" href="${ctx}/layui/css/layui.css" />
       	<script type="text/javascript" src="${ctx}/layui/layui.js" ></script>
   <style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body{
            background: url(${ctx}/layui/images/500828136.jpg) no-repeat center;
            background-size: 100%;
        }
        .rg_layout{
            width: 500px;
            height: 350px;
            border: 5px solid #EEEEEE;
            background-color: white;
            margin: auto;
            margin-top: 10%;
            text-align: center;
        }
        .rg_center{
            color: #757575;
            margin: 15px;
            float: left;
            text-align: center;
        }
        .rg_right{
            color: #757575;
            float: right;
        }
        .rg_right > p:last-child{
            margin: 15px;
            font-size: 15px;
        }
        .rg_right a{
            text-decoration: none;
            color: darkorange;
        }
        .rg_right a:hover{
            color: blue;
        }
        .td_left{
            width: 126px;
            text-align: right;
            line-height: 45px;
            padding-top: 5px;
            padding-bottom: 5px;
        }
        .td_right{
            padding-left: 15px;
        }
        #username,#password{
            width: 250px;
            height: 36px;
            border: 1px solid #cccccc;
            border-radius: 5px;
            padding-left: 10px;
        }
        .td_button{
        	width: 600px;
        }
        .td_center{
            width: 200px;
            text-align: center;
            line-height: 45px;
        }
        .title_header{
        	font-size: 45px;
        	font-family:STCaiyun;
        	color: Maroon;
        	margin-bottom: 35px;
        }
        
    </style>
	</head>
	
	<body>
	    <div class="rg_layout">
	        <div class="rg_center" >
            	<div style="height: 20px;"></div>
                <form method="post" class="layui-form">
                    <table>
                    	<tr>
                           	<p class="title_header">海豚超市后台管理系统</p>
                        </tr>
                        <tr>
                            <td class="td_left"><label for="username">用户名</label></td>
                            <td class="td_right"><input autocomplete="off" type="text" name="loginId" id="username" placeholder="请输入用户名" value="${name}"></td>
                        </tr>
                        <tr>
                            <td class="td_left"><label for="password">密码</label></td>
                            <td class="td_right"><input type="password" name="loginPwd" id="password" placeholder="请输入密码" value="${password}"></td>
                        </tr>
                        <tr>
                        	<td class="td_left"></td>
                        	<td class="td_right" style="text-align: left;">
                        		<input lay-submit lay-filter="demo1" type="submit" class="layui-btn layui-btn-normal" style="margin-right: 20px;" value="登录"/>
                        		<input type="checkbox" name="rememberMe" title="记住我" lay-skin="primary" checked>
                        	</td>
                        </tr>
                    </table>
                </form>
	        </div>
	    </div>
	<script type="text/javascript" src="${ctx}/layui/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/layui/layui.js" ></script>
	<script>
		//Demo
		layui.use(['layer', 'form'], function(){
			  var layer = layui.layer
			  ,form = layui.form;
			 
			  //监听提交
			  form.on('submit(demo1)', function(data){
			  	if (data.field.loginId==undefined||data.field.loginId=="") {
					layer.msg('用户名不能为空', {icon: 5,anim: 6});
				}else if (data.field.loginPwd==undefined||data.field.loginPwd=="") {
					layer.msg('密码不能为空', {icon: 5,anim: 6});
				}else{
					$.post("${ctx}/login/rLogin",data.field,function(data){
						console.log(data);
						if(data==1){
							layer.msg('没有此用户', {icon: 5,anim: 6});
						}else if(data==2){
							layer.msg('密码错误', {icon: 5,anim: 6});
						}else if(data==3){
							layer.msg('该用户已被禁用，需启用请联系：66668888', {icon: 5,anim: 6});
						}else if(data==4){
							window.location.href="${ctx}/view/backstage/main.jsp";
						}
						
					});
				}
				return false; 
			  });
		});
	</script>
	</body>
</html>