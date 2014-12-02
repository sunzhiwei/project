<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<script type="text/javascript">
	
$(function() {
	parent.$.messager.progress('close');
});

function update(){
	var roleId = $("#roleId").val();
	window.location.href="${ctx}/hxRole/updateView/"+roleId;
}

function goBack(){
	window.location.href="${ctx}/hxRole/roleView";
}

function authority(){
	var roleId = $("#roleId").val();
	window.location.href="${ctx}/hxRoleMenu/roleMenuView/"+ roleId;
}
</script>
<div class="easyui-panel" title="用户角色详细信息" style="width:auto">
	<div style="padding:10px 0 10px 60px">
		<form id="form" method="post">
			<input id="roleId" type="hidden" value="${role.roleId}"/>
			<table class="table table-hover table-condensed" width="100%">
				<tr>
					<td>角色名称</td>
					<td><label>${role.roleName}</label></td>
				</tr>
				<tr>
					<td>角色类型</td>
					<td><label>${role.codeValue}</label></td>
				</tr>
				<tr>
					<td>角色描述</td>
					<td><label>${role.roleDesc}</label></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="text-align:center;padding:5px">
	    	<a href="#" class="easyui-linkbutton"  onclick="update();">修改</a>
	    	<a href="#" class="easyui-linkbutton"  onclick="authority();">权限设置</a>
	    	<a href="#" class="easyui-linkbutton"  onclick="goBack();">返回</a>
	</div>
</div>