<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		
		$('#form').form({
			url : '${ctx}/hxRole/updateRole',
			onSubmit : function(param) {
				param.roleId = $("#roleId").val();
				param.roleName = $("#roleName").val();
				//combobox取值
				var roleType = $('#roleType').combobox('getValues');
				param.roleType = roleType;
				param.roleDesc = $("#roleDesc").val();
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				var isValid = $(this).form('validate');
				if(roleType==null||roleType==''){
					isValid = false;
					alert("角色类型位必填项");
				}
				if (!isValid) {
					parent.$.messager.progress('close');
				}
				return isValid;
			},
			success : function(msg) {
				parent.$.messager.progress('close');
				if($.parseJSON(msg).flag == "success"){
					$.messager.alert('提示:','修改成功!');
				}
			}
		});
	});
	
	function submitForm(){
		var f = $("#form");
		f.submit();
	}
	
	function goBack(){
		window.location.href="${ctx}/hxRole/roleView";
	}
	
</script>
<div class="easyui-panel" title="修改用户角色" style="width:auto">
		<div style="padding:10px 0 10px 60px">
		<form id="form" method="post">
			<table class="table table-hover table-condensed" width="100%">
				<tr>
					<td width="20%">角色名称</td>
					<td width="80%"><input id="roleId" type="hidden" value="${role.roleId}"><input id="roleName" type="text" placeholder="请输入角色名称" class="easyui-validatebox span2" data-options="required:true" value="${role.roleName}"></td>
				</tr>
				<tr>
					<td>角色类型</td>
					<td><input id="roleType" type="text" placeholder="请选择角色类型" editable="false" class="easyui-combobox" class="span2" data-options="url:'${ctx}/hxCode/getCombobox/jslx'" value="${role.roleType}"></td>
				</tr>
				<tr>
					<td>角色描述</td>
					<td><textarea id="roleDesc"  cols="80" rows="1" placeholder="请输入角色描述" class="easyui-validatebox span2" data-options="required:false" >${role.roleDesc}</textarea></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="text-align:center;padding:5px">
	    	<a href="#" class="easyui-linkbutton"  onclick="submitForm();">保存</a>
	    	<a href="#" class="easyui-linkbutton"  onclick="goBack();">返回</a>
	</div>
</div>