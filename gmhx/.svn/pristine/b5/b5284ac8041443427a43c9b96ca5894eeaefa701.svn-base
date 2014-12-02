<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			title:'查询配件出入库历史',
			type: 'POST',
			url: '${ctx}/hxInoutStock/getInoutSotckHistoryPageList',
			nowrap : false,
			striped : true,
			height : document.documentElement.clientHeight * 0.98,
			collapsible : true,
			autoRowHeight : false,
			remoteSort : false,
			rownumbers : true,
			fitColumns : true,
			pagination : true,
			checkOnSelect : false,
			singleSelect : true,
			selectOnCheck : false,
			toolbar : '#toolbar',
			queryParams : {
				pageNo : 1,
				pageCount : 10
			},
			columns:[[
		         {
					field : 'action',
					title : '操作',
					align:'center',
					width : 50,
					formatter : function(value, row, index) {
						return '<a href="#" onclick="view(\'' + row.list_number + '\');">查看</a>';
					}
				},{
					field : 'list_number',
					title : '申请单号',
					align:'center',
					width : 50
				}, {
					field : 'send_company',
					title : '单位名称',
					align:'center',
					width : 50
				}, {
					field : 'receive_company',
					title : '关联仓库',
					align:'center',
					width : 50
				},{
					field : 'type',
					title : '科目',
					align:'center',
					width : 50
				}, {
					field : 'fitting_code',
					title : '物料编码',
					align:'center',
					width : 50
				}, {
					field : 'fitting_name',
					title : '物料名称',
					align:'center',
					width : 50
				}, {
					field : 'count',
					title : '数量',
					align:'center',
					width : 50
				}, {
					field : 'price',
					title : '单价',
					hidden:true
				}, {
					field : '金额',
					title : '状态',
					align:'center',
					width : 50,
					formatter : function(value, row, index) {
						return row.count * row.price;
					}
				}, {
					field : 'status',
					title : '状态',
					align:'center',
					width : 50
				},{
					field : 'update_time',
					title : '操作日期',
					align:'center',
					width : 50
				}]],
			loadMsg : "数据加载中...",
			onBeforeLoad : function(param) {
				$.serializeObject($('#searchForm'), param);
				param.fittingPositionType =  $("#fittingPositionType").combobox("getValue");
				param.inout =  $("#inout").combobox("getValue");
				param.isNew =  $("#isNew").combobox("getValue");

				param.currentPage = param.page;
				param.pageCount = param.rows;
			}
		});
	});
	
	$.serializeObject = function(form) {
		var o = {};
		$.each(form.serializeArray(), function(index) {
			if (o[this['name']]) {
				o[this['name']] = o[this['name']] + "," + this['value'];
			} else {
				o[this['name']] = this['value'];
			}
		});
		return o;
	};
	function refreshDataGrid() {
		$('#dataGrid').datagrid("reload");
		parent.$.modalDialog.handler.dialog('close');	
	}	
	
	function show(listNumber){
		window.location.href="${ctx}/hxInoutStock/viewInoutSotock/"+ listNumber;
	}
	function fetch() {
		dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
	};
</script>
</head>
<body>
   <div class="easyui-layout" data-options="fit:true,border:false">
	 <div data-options="region:'north',title:'查询条件',border:false,collapsible:false" style="height: 160px; overflow: hidden;">
	   <form id="searchForm">
	   	<input type="hidden" id="ptype" name="ptype" value="${sessionScope.ptype}">
	     <table class="table table-hover table-condensed" style="width:100%; padding: 7px 80px 0px 80px">
		     <tr>
		     	<td width="5%">申请单号</td>
				<td width="5%"><input name="listNumber" type="text" placeholder="请输入申请单号" class="span2"></td>
				<td width="5%"></td>
				<td width="5%">单位名称</td>
				<td width="5%"><input class="easyui-combobox" name="sendCompany"  id="sendCompany" data-options="url:'${ctx}/hxCode/getOrgCombobox'"/></td>
					<td width="5%"></td>
				<td width="5%">关联仓库</td>
				<td width="5%"><input name="receiveCompany" type="text" placeholder="请输入关联仓库" class="span2"></td>
				<td width="5%"></td>
				<td width="45%"></td>
			</tr>
			<tr>
				<td width="5%">科目</td>
				<td width="5%"><input name="type" class="easy-combobox" placeholder="请输入配件名称"  data-options="url:'${ctx}/hxCode/getCombobox/fitting_type'"></td> 
				<td width="5%"></td>
				<td width="5%">适应机型</td>
				<td width="5%"><input name="suitModel" type="text" placeholder="请输入配件名称" class="span2"></td> 
				<td width="5%"></td>
				<td width="5%">配件分类</td>
				<td width="5%"><input name="fittingType" class="easy-combobox" placeholder="请输入配件分类"  data-options="url:'${ctx}/hxCode/getCombobox/pjfl'"></td>
				<td width="5%"></td>
				<td width="45%"></td>
			</tr>
			<tr>
		     	<td width="5%">物料编码</td>
				<td width="5%"><input name="fittingCode" type="text" placeholder="请输入物料编码" class="span2"></td>
				<td width="5%"></td>
				<td width="5%">部品号</td>
				<td width="5%"><input name="partsCode" type="text" placeholder="请输入部品号" class="span2"></td>
				<td width="5%"></td>
				<td width="5%">操作日期</td>
				<td width="25%">
							<input id="ksrq" placeholder="选择起始日期" class="Wdate" name="ksrq" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'jsrq\')}'})"/>至
							<input id="jsrq" placeholder="选择结束日期" class="Wdate" name="jsrq" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'ksrq\')}'})"/> 
				</td>
				<td width="5%"></td>
				<td width="45%"></td>
			</tr>			<tr>
				<td width="7%">当前库存位置:</td>
				<c:if test="${ptype == 1}">
				<td width="5%">
					<select id="fittingPositionType" name="fittingPositionType" class="easyui-combobox" width="100%">   
					    <option value="0" selected="selected">总部仓库</option>   
					    <option value="1">分部仓库</option>   
					    <option value="2">网点仓库</option>   
					</select>  
				</td>
				</c:if> 
				<c:if test="${ptype == 2}">
				<td width="5%">
					<select id="fittingPositionType" name="fittingPositionType" class="easyui-combobox" width="100%">
					    <option value="1" selected="selected">分部仓库</option>   
					    <option value="2">网点仓库</option>   
					</select>  
				</td>
				</c:if>
				<c:if test="${ptype == 3}">
				<td width="5%">
					<select id="fittingPositionType" name="fittingPositionType" class="easyui-combobox" width="100%">   
					    <option value="2" selected="selected">网点仓库</option>   
					</select> 
				</td>
				</c:if> 
				<td width="5%"/>
				<td width="8%">出入/入库信息</td>
				<td width="5%">
					<select id="inout" name="inout" class="easyui-combobox" width="100%">
					    <option value="1" selected="selected">出库</option>   
					    <option value="2">入库</option>   
					</select>  
				</td>
				<td width="5%"/>
				<td width="8%">配件新料/旧料:</td>
				<td width="5%">
					<select id="isNew" name="isNew" class="easyui-combobox" width="100%">
					    <option value="1" selected="selected">新料</option>   
					    <option value="0">旧料</option>   
					</select>  
				</td>
				<td width="5%"></td>
				<td width="35%" align="left"><a href="#" id="query" class="easyui-linkbutton" iconCls="icon-search" onclick="fetch()">查询</a></td>
			</tr>
		</table>
	  </form>
	</div>
	<div id="toolbar" style="display: none;">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-excel',plain:true" onclick="importStocks();">导入</a>
		<a href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-excel',plain:true" onclick="exportExcel();">导出</a>
	</div>
	<div data-options="region:'center',border:false">
		<table id="dataGrid"></table>
	</div>
	</div>
</body>
</html>
