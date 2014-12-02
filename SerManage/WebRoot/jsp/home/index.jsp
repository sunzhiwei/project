<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<title>国美服务器管理系统</title>
<link href="<%=basePath %>images/skin.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript">
if ( window.top != window.self ) {
	window.top.location.href = "${pageContext.request.contextPath}/index.jsp";
}
    function check(){
        
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		if(username==""){
			   alert("请输入用户名！");
			   return false;
			   } 
	        if(password==""){
			   alert("请输入密码！");
			   return false;
			   }
	return true; 
        }
    </script>
</head>
<body class="body">
	<div class="login-box">
		<span class="login_txt_bt"></span>
		<form name="myform" action="<%=basePath %>userAction_login.action"
			onsubmit="return check();" method="post" id="J_StaticForm">
			<div class="field username-field">
				<input class="login-text J_UserName" id="username" name="username"
					value="${username }" size="20"> <span
					id="J_NickX1385020956995" class="nickx" href="javascript:void(0)"
					style="display: none;"></span>
			</div>
			<div class="field pwd-field">
				<input class="login-text J_Pwd" id="password" type="password"
					value="${password }" size="20" name="password"> <span
					class="error">${msg } </span>
			</div>
			<input name="Submit" type="submit" class="button" id="Submit"
				value="">
		</form>
	</div>
	<div class="login_footer">
		<span class="login-buttom-txt">Copyright &copy; 2014 国美电器 版权所有</span>
	</div>

</body>
</html>
