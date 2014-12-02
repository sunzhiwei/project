<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<html>
<head>
<script type="text/javascript">
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			title : "网点信息",
			url : "${ctx}/Network/getNetWorkPageList",
			nowrap : false,
			striped : true,
			height : document.body.clientHeight - 70,
			collapsible : true,
			autoRowHeight : false,
			remoteSort : false,
			idField : 'id',
			rownumbers : true,
			fitColumns : true,
			pagination : true,
			checkOnSelect : false,
			singleSelect : true,
			selectOnCheck : false,
			queryParams : {
				currentPage : 1,
				pageCount : 10
			},
			columns : [ [ {
				field : 'wdmc',
				title : '网点名称',
				width : 25,
				align:'center',
				formatter:function(value, row, index){ 
					return '<a href="#" onclick="show(\'' + row.id + '\');">'+row.wdmc+'</a>';
                }  
			}, {
				field : 'gsxx01',
				title : '上级机构',
				width : 25,
				align:'center'
			},
			{
				field : 'id',
				title : '网点ID',
				width : 25,
				align:'center'
			},
			{
				field : 'action',
				title : '操作',
				width : 20,
				align:'center',
				formatter : function(value, row, index) {
// 					return '<a href="#" onclick="update(\'' + row.azwd01 + '\');">修改</a> <a href="#" onclick="show(\'' + row.azwd01 + '\');">查看</a>';
				}
			} ] ],
			toolbar : '#toolbar',
			onLoadSuccess : function() {
				$('#searchForm table').show();
				$(this).datagrid('doCellTip',{'max-width':'300px','delay':500});
				parent.$.messager.progress('close');
			}
		});
		$('.datagrid-pager').pagination({
			pageSize: 20,//每页显示的记录条数，默认为10   
			onSelectPage : function(pageNumber, pageSize) {
				$(this).pagination('loading');
				$('#dataGrid').datagrid("options").queryParams = {
					currentPage : pageNumber,
					pageCount : pageSize
				};
				$('#dataGrid').datagrid("reload");
				$(this).pagination('loaded');
			}
		});
		$("#query").on("click", function() {
			dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
		});
	});
	
	$.serializeObject = function(form) {
		var o = {
			currentPage : 1,
			pageCount : 10
		};
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
	
	function show(id){
		window.location.href="${ctx}/Network/showView/" + id;
	}
</script>
</head>
<body>
   <div class="easyui-layout" data-options="fit:true,border:false">
	 <div data-options="region:'north',title:'查询条件',border:false,collapsible:false" style="height: 120px; overflow: hidden;">
	   <form id="searchForm">
	     <table class="table table-hover table-condensed" style="width:100%; padding: 7px 80px 0px 80px">
	               <tr>
						<td width="15%">网点名称:</td>
						<td width="5%"><input  class="easyui-combobox" name="wdmc" placeholder="输入查询条件" class="span2" data-options="url:'${ctx}/hxCode/getCombobox/wd'"/></td> 
						<td width="5%"></td>
						<td width="15%">上级机构:</td>
						<td width="5%"><input  class="easyui-combobox" name="gsxx01" placeholder="输入查询条件" class="span2" data-options="url:'${ctx}/hxCode/getCombobox/jg'"/></td> 
						<td width="5%"></td>
						<td width="15%">网点ID:</td>
						<td width="5%"><input   name="id" class="easyui-validatebox span2"  data-options="required:false" /></td>
						<td width="5%"></td>
						<td width="5%"></td>
						<td width="35%" align="right"><a href="#" id="query" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false">
			<table id="dataGrid"></table>
		</div>
	</div>
</body>
</html>
