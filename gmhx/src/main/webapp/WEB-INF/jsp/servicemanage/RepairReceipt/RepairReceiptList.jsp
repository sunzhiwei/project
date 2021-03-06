<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	var dataGrid;
	$(function(){
		onStart(document.body.clientHeight - 175);
		$('#dataGrid').datagrid('cancelCellTip');
		$('#dataGrid').datagrid('doCellTip',{'max-width':'300px'});
	});
	
	function clos(){
		onStart(document.body.clientHeight - 28);
		$('#dataGrid').datagrid('cancelCellTip');
		$('#dataGrid').datagrid('doCellTip',{'max-width':'300px'});
	}
	
	function ope(){
		onStart(document.body.clientHeight - 175);
		$('#dataGrid').datagrid('cancelCellTip');
		$('#dataGrid').datagrid('doCellTip',{'max-width':'300px'});
	}
	
	function onStart(heigh){
		dataGrid = $('#dataGrid').datagrid({
			title : "维修服务单",
			url : "${ctx}/repairReceipt/getRepairReceiptPageList",
			striped : true,
            height : heigh,
            collapsible : true,
            autoRowHeight : false,
            remoteSort : false,
            idField : 'service_id',
            rownumbers : true,
            fitColumns : true,
            nowrap : true,
            pagination : true,
            checkOnSelect : false,
            selectOnCheck : false,
            queryParams : {
                currentPage : 1,
                pageCount : 10
            },
			columns : [ [ {
				field : 'service_id',
				title : '维修单号',
				width : 10,
				align:'center',
			}, {
				field : 'gome_code',
				title : '国美代码',
				width : 10,
				align:'center',
				sortable : true
			} , {
				field : 'brand',
				title : '品牌',
				width : 10,
				align:'center',
				sortable : true
			},{
				field : 'internal_machine_code1',
				title : '内机条码1',
				width : 10,
				align:'center',
				sortable : true
			} , {
				field : 'internal_machine_code2',
				title : '内机条码2',
				width : 10,
				align:'center',
				sortable : true
			} , {
				field : 'external_machine_code',
				title : '外机条码',
				width : 10,
				align:'center',
				sortable : true
			} , {
				field : 'manul_num',
				title : '手工单号',
				width : 10,
				align:'center',
				sortable : true
			} , {
				field : 'customer_name',
				title : '客户姓名',
				width : 10,
				align:'center',
				sortable : true
			}  ,{
				field : 'service_status',
				title : '状态',
				width : 10,
				align:'center',
				sortable : true
			}  ,{
				field : 'create_organization_s',
				title : '创建机构',
				width : 10,
				align:'center',
				sortable : true
			}  ,{
				field : 'create_time_s',
				title : '创建时间',
				width : 10,
				align:'center',
				sortable : true
			}  ,{
				field : 'service_date',
				title : '维修日期',
				width : 10,
				align:'center',
				sortable : true
			}  ,{
				field : 'action',
				title : '操作',
				width : 10,
				align:'center',
				formatter : function(value, row, index) {     
					if(row.service_status=="S1"){
						return '<a href="#" onclick="show(\'' + row.service_id + '\');">查看</a> | <a href="#" onclick="update(\'' 
								+ row.service_id + '\');">修改</a> | <a href="#" onclick="deleteTicket(\'' + row.service_id + '\');">删除</a>';
					}else{
						return '<a href="#" onclick="show(\'' + row.service_id + '\');">查看</a>';
					}
				}
			} ] ],
			toolbar : '#toolbar',
			onLoadSuccess : function() {
				$('#searchForm table').show();
				parent.$.messager.progress('close');
			}
		});
		$('.datagrid-pager').pagination({
			  onSelectPage : function(pageNumber, pageSize) {
					$(this).pagination('loading');
					var queryParams = $.serializeObject($('#searchForm'));
					queryParams.currentPage = pageNumber;
					queryParams.pageCount = pageSize;
					$('#dataGrid').datagrid("options").queryParams = queryParams;
					$('#dataGrid').datagrid("reload");
					$(this).pagination('loaded');
				}
		});
		$("#query").on("click", function() {
			dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
		});
	};
	
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
		
	function update(serviceId){
		window.location.href = "${ctx}/repairReceipt/updateRepairReceiptView/"+serviceId;
	}
	
	function show(serviceId){
		window.location.href = "${ctx}/repairReceipt/repairReceiptView/"+serviceId;  
	}
	
	function add(){
		window.location.href = "${ctx}/repairReceipt/addview";
	}
	
    function deleteTicket(serviceId){
    	$.messager.confirm("", "您确定要删除吗？", function (data) {
    		if(data){
    			$.post("${ctx}/repairReceipt/deleteServiceTicket/"+ serviceId, 
        				function(msg){
        					if($.parseJSON(msg).flag == "success"){
        						$.messager.alert('','删除成功!');
        						$('#dataGrid').datagrid("reload");
        					}else{
        						$.messager.alert('','删除失败!');
        					}
        				}
        			);
    		}
    	});
    }
</script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',title:'查询条件',border:false,collapsible:true,onBeforeCollapse:function(){clos();},onBeforeOpen:function(){ope();}"  style="height: 175px; overflow: hidden;">
		<form id="searchForm" method="post">
			<table class="table table-hover table-condensed" width="100%;" style="width:100%; padding: 10px 10px 10px 10px">
				<tr>
					<td width="5%">维修单号</td>
					<td width="15%"><input name="serviceTicket.serviceId" type="text" placeholder="请输入查询条件" class="easyui-validatebox span2" value=""></td>
					<td width="5%">机型</td>
					<td width="15%"><input name="serviceProduct.machineType" type="text" placeholder="请输入查询条件" class="easyui-validatebox span2" value=""></td>
					<td width="5%">国美代码</td>
					<td width="15%"><input name="serviceProduct.gomeCode"  placeholder="请输入查询条件" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/gmdm',panelHeight:'auto',editable:false "></td>
					<td width="5%">品牌</td>
					<td width="15%"><input name="serviceProduct.brand" type="text" placeholder="请输入查询条件" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/pp',panelHeight:'auto',editable:false "></td>
					<td width="5%">客户姓名</td>
					<td width="15%"><input name="serviceCustomer.customerName" type="text" placeholder="请输入查询条件" class="easyui-validatebox span2" value=""></td>
				</tr>
				<tr>
					<td>机器条码</td>
					<td><input name="serviceProduct.machineCode" type="text" placeholder="请输入查询条件" class="easyui-validatebox span2" value=""></td>
					<td>外机条码</td>
					<td><input name="serviceProduct.externalMachineCode" type="text" placeholder="请输入查询条件" class="easyui-validatebox span2" value=""></td>
					<td>内机条码1</td>
					<td><input name="serviceProduct.internalMachineCode1" type="text" placeholder="请输入查询条件" class="easyui-validatebox span2" value=""></td>
					<td>内机条码2</td>
					<td><input name="serviceProduct.internalMachineCode2" type="text" placeholder="请输入查询条件" class="easyui-validatebox span2" value=""></td>
					<td>手工单号</td>
					<td><input name="serviceTicket.manulNum" type="text" placeholder="请输入查询条件" class="easyui-validatebox span2" value=""></td>
				</tr>
				<tr>
					<td>客户电话</td>
					<td><input name="serviceCustomer.phone" type="text" placeholder="请输入查询条件" class="easyui-validatebox span2" value=""></td>
					<td>状态</td>
					<td><input id="serviceTicket.serviceStatus" type="text" placeholder="请输入查询条件" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/hzzt',panelHeight:'auto',editable:false "></td>
					<td>创建人</td>
					<td><input name="serviceTicket.createManS" type="text" placeholder="请输入查询条件" class="easyui-validatebox span2" value=""></td>
					<td>创建机构</td>
					<td><input name="serviceTicket.createOrganizationS" type="text" placeholder="请输入查询条件" class="easyui-validatebox span2" value=""></td>
					<td>机型分类</td>
					<td><input name="serviceProduct.machineType" type="text" placeholder="请输入查询条件" class="easyui-validatebox span2" value=""></td>
				</tr>
				<tr>
					<td>是否更换配件</td>
					<td><input name="serviceTicket.isReplaceParts" type="text" placeholder="请输入查询条件" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/sf',panelHeight:'auto',editable:false "></td>
					<td>故障代码</td>
					<td><input name="troubleCode" type="text" placeholder="请输入查询条件" class="easyui-validatebox span2" value=""></td>
					<td>维修日期</td>
					<td>
						<input size=20 placeholder="选择起始日期" class="Wdate" name="mod_serviceDate_st" type="text" readonly="readonly"  onFocus="WdatePicker({aa:'#F{$dp.$D(\'jsrq\')}'})"/><br/>
						<input size=20 placeholder="选择结束日期" class="Wdate" name="mod_serviceDate_end" type="text" readonly="readonly"  onFocus="WdatePicker({aa:'#F{$dp.$D(\'ksrq\')}'})"/> 
					</td>
					<td>创建时间</td>
					<td>
						<input size=20 placeholder="选择起始日期" class="Wdate" name="mod_createTime_st" type="text" readonly="readonly"  onFocus="WdatePicker({aa:'#F{$dp.$D(\'jsrq\')}'})"/><br/>
						<input size=20 placeholder="选择结束日期" class="Wdate" name="mod_createTime_end" type="text" readonly="readonly"  onFocus="WdatePicker({aa:'#F{$dp.$D(\'ksrq\')}'})"/> 
					</td>
					<td></td>
					<td align="center"><a href="#" id="query" class="easyui-linkbutton">查询</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="toolbar" style="display: none;">
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="add();">增加</a>
	</div>
	<div data-options="region:'center',border:false">
		<table id="dataGrid"></table>
	</div>
</div>
</body>
</html>