<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<script type="text/javascript">
	$(function() {
		$('#dataGridForSuit').datagrid({
			title : "适用机型配置",
			url : "${ctx}/hxFitting/getHxFittingModel/${hxFitting.fittingCode}",
			striped : true,
			collapsible : true,
			autoRowHeight : false,
			singleSelect : true,
			remoteSort : false,
			rownumbers : true,
			fitColumns : true,
			columns : [ [ {
				field : 'suitModel',
				title : '适用机型',
				align:'center',
				width : 300
			}, {
				field : 'comment',
				title : '备注',
				align:'center',
				width : 300
			} ] ]
		});
		
		$('#dataGridForProvider').datagrid({
			title : "供应商配置",
			url : "${ctx}/hxFitting/getHxFittingProvider/${hxFitting.fittingCode}",
			striped : true,
			collapsible : true,
			autoRowHeight : false,
			singleSelect : true,
			remoteSort : false,
			rownumbers : true,
			fitColumns : true,
			columns : [ [ {
				field : 'provider',
				title : '供应商',
				align:'center',
				width : 300
			}, {
				field : 'comment',
				title : '备注',
				align:'center',
				width : 300
			} ] ]
		});
		
		$("div.easyui-layout").css("height", "auto");
	});
	
	function back(){
		window.location.href = "${ctx}/hxFitting/hxFittingView";
	}
	
	function update(){
		window.location.href = "${ctx}/hxFitting/updateView/${hxFitting.fittingCode}";
	}
</script>
<form id="form" method="post">
	<div style="background-color:#95b8e7; text-align:center; color:#fff; font-weight:bold; border-bottom: 1px solid #000;">
		新建配件资料
	</div>
	<table border=1 style="cellSpacing:1;cellPadding:3;width:100%;background-color:#eff5ff;border-collapse:collapse">
		<tr>
			<td width="25%" align="center">配件编码<font color="red">*</font></td>
			<td width="25%">${hxFitting.fittingCode}</td>
			<td width="25%" align="center">配件分类<font color="red">*</font></td>
			<td width="25%"><input class="easyui-combobox" disabled="disabled" name="fittingType" data-options="url:'${ctx}/hxCode/getCombobox/pjfl?value=${hxFitting.fittingType}', editable:false"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">配件名称<font color="red">*</font></td>
			<td width="25%">${hxFitting.fittingName}</td>
			<td width="25%" align="center">部品号</td>
			<td width="25%">${hxFitting.partsCode}</td>
		</tr>
		<tr>
			<td width="25%" align="center">规格</td>
			<td width="25%">${hxFitting.spec}</td>
			<td width="25%" align="center">生产类型</td>
			<td width="25%"><input class="easyui-combobox" disabled="disabled" name="produceType" data-options="url:'${ctx}/hxCode/getCombobox/sclx?value=${hxFitting.produceType}', editable:false"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">配件级别</td>
			<td width="25%"><input class="easyui-combobox" disabled="disabled" name="fittingLevel" data-options="url:'${ctx}/hxCode/getCombobox/pjjb?value=${hxFitting.fittingLevel}', editable:false"/></td>
			<td width="25%" align="center">国美代码<font color="red">*</font></td>
			<td width="25%"><input class="easyui-combobox" disabled="disabled" name="gomeCode" data-options="url:'${ctx}/hxCode/getCombobox/gmdm?value=${hxFitting.gomeCode}', editable:false"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">成本价格<font color="red">*</font></td>
			<td width="25%">${hxFitting.cost}</td>
			<td width="25%" align="center">分部价格<font color="red">*</font></td>
			<td width="25%">${hxFitting.branchPrice}</td>
		</tr>
		<tr>
			<td width="25%" align="center">网点价格<font color="red">*</font></td>
			<td width="25%">${hxFitting.networkPrice}</td>
			<td width="25%" align="center">用户价格<font color="red">*</font></td>
			<td width="25%">${hxFitting.userPrice}</td>
		</tr>
		<tr>
			<td width="25%" align="center">是否回收</td>
			<td width="25%"><input class="easyui-combobox" disabled="disabled" name="isRetrieve" data-options="url:'${ctx}/hxCode/getCombobox/sf?value=${hxFitting.isRetrieve}', editable:false"/></td>
			<td width="25%" align="center">是否停用</td>
			<td width="25%"><input class="easyui-combobox" disabled="disabled" name="isStop" data-options="url:'${ctx}/hxCode/getCombobox/sf?value=${hxFitting.isStop}', editable:false"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">保修期限</td>
			<td width="25%">${hxFitting.term}</td>
		</tr>
		<tr>
			<td width="25%" align="center">备注</td>
			<td width="25%" colspan="3"><textarea name="comment" disabled="disabled" rows="3" cols="52"></textarea></td>
		</tr>
	</table>
</form>
<div>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<table id="dataGridForSuit"></table>
	</div>
	
	<div class="easyui-layout" data-options="fit : true,border : false">
		<table id="dataGridForProvider"></table>
	</div>
</div>
<div align="right" style="padding:5px;">
	<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g1',iconCls:'icon-edit'" onclick="update();">修改</a>
	<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g1',iconCls:'icon-back'" onclick="back();">返回</a>
</div>
