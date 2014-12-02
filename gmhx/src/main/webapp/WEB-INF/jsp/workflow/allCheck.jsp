<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<%@ include file="../inc/resource.inc"%>
<%
    // 其他生成的动态页面共享ctx项目名称
	request.setAttribute("ctx", request.getContextPath());

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	function submitForm(orderType) {
		var checkAgree = $("input[name='approveComment']:checked").val();
		var comment = $("#comment").val();
		$.post(ctx + "/hxWorkFlow/updateJbpmWorkEntity", {
			workEntityId : '${order.listNumber}',
			checkAgree : checkAgree,
			approveComment : comment,
			orderType : orderType
		}, function(data) {
			$.messager.alert("操作提示", data, "info", function() {
				window.location.href = "${ctx}/hxWorkFlow/list";
			});
		});
	}

	function goBack() {
		window.location.href = "${ctx}/hxWorkFlow/list";
	}
</script>
</head>
<body>
	<jsp:include page="${processInstanceToView }"></jsp:include>
	<%@ include file="workProcessTour.jsp"%>
	<jsp:include page="${processInstanceToCheck }"></jsp:include>
	<jsp:include page="${processInstanceToSave }"></jsp:include>
</body>
</html>
