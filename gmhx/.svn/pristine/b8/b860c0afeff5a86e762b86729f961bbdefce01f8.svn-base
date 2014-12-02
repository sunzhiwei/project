<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link rel="stylesheet" href="${ctx}/css/zTreeStyle/zTreeStyle.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">
	var setting = {
		async: {
			enable: true,
			url:"${ctx}/repairReceipt/getHxMaintenanceTree/01"
		},
		view: {
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick : onClick,
			onExpand  : false
		}
	};

	$(function() {
		$.fn.zTree.init($("#treeG"), setting);
		//parent.$.messager.progress('close');
	});

	function onClick(event, treeId, treeNode){
		if(treeNode.chose=='是'){
			$("#classifyCode").val(treeNode.id);
			$("#classifyName").val(treeNode.name);
		}else{
			return;
		}
	}
	
	function confirm(){
		if($("#classifyCode").val()==''){
			$.messager.alert('','请选择一项故障原因!');
		}else{
			window.returnValue =$("#classifyCode").val() + "/" + $("#classifyName").val();
			window.close();
		}
	}
</script>
<input id="classifyCode" type="hidden">
<input id="classifyName" type="hidden">
<ul id="treeG" class="ztree" style="background-color: #eff5ff"></ul>
<br/>
<div align="center">
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="confirm()">确认</a>
</div>
