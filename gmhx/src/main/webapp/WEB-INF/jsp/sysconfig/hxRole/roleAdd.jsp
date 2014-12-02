<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		
		$('#form').form({
			url : '${ctx}/hxRole/addRole',
			onSubmit : function(param) {
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
					$.messager.alert('提示:','保存成功!');
					var continueToAddFlag = $("#continueToAddFlag").val();
					if(continueToAddFlag=="1"){//如果是继续添加则会执行页面跳转
						window.location.href="${ctx}/hxRole/addView";
					}
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
	
	function continueToAdd(){
		//继续添加标志位置1
		$("#continueToAddFlag").val("1");
		var f = $("#form");
		f.submit();
	}
</script>
<div class="easyui-panel" title="新建用户角色" style="width:auto">
		<div style="padding:10px 0 10px 60px">
		<input type="hidden" id="continueToAddFlag" title="继续添加标志位" value="0">
		<form id="form" method="post">
			<table class="table table-hover table-condensed" width="100%">
				<tr>
					<td width="20%">角色名称</td>
					<td width="80%"><input id="roleName" type="text" placeholder="请输入角色名称" class="easyui-validatebox span2" data-options="required:true" value=""></td>
				</tr>
				<tr>
					<td>角色类型</td>
					<td><input id="roleType" type="text" placeholder="请选择角色类型" editable="false" class="easyui-combobox" class="span2" value="" data-options="url:'${ctx}/hxCode/getCombobox/jslx'"  ></td>
				</tr>
				<tr>
					<td>角色描述</td>
					<td><textarea id="roleDesc" cols="80" rows="1" placeholder="请输入角色描述" class="easyui-validatebox span2" data-options="required:false" ></textarea></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="text-align:center;padding:5px">
	    	<a href="#" class="easyui-linkbutton"  onclick="submitForm();">保存</a>
	    	<a href="#" class="easyui-linkbutton"  onclick="continueToAdd();">继续添加</a>
	    	<a href="#" class="easyui-linkbutton"  onclick="goBack();">返回</a>
	</div>
</div>