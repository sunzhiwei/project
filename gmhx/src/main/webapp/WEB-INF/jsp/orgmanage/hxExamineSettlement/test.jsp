<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	function ddd(){
		//window.location.href = "${ctx}/hxExamineSettlement/test";
		$.post("${ctx}/hxExamineSettlement/test",
				$('#Iform').serialize(),
				function(msg){
					$.messager.alert('提示:',$.parseJSON(msg).flag);
				});
	}
	

</script>
</head>
<body>
	<form id="Iform" method="post">
		<table align="center">
			<tr>
				<td>安装日期<font color="red">*</font></td>
				<td>
					<input id="date" type="text" data-options="required:true" readonly="readonly"  class="easyui-validatebox span2">
					<img onclick="WdatePicker({el:'date'})" src="${ctx}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
				</td>
			</tr>
			<tr>
				<td>机型</td>
				<td>
					<input name="mode">
				</td>
			</tr>
			<tr>
				<td>编码码</td>
				<td>
					<input name="code" >
				</td>
			</tr>
			<tr>
				<td>
					<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="ddd();">测试</a>
				</td>
			</tr>
		</table>
	</form>	
</body>
</html>
