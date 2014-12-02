<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
		var dataGrid;
		$(function(){
			onStart(document.body.clientHeight - 185);
			$('#dataGrid').datagrid('cancelCellTip');
			$('#dataGrid').datagrid('doCellTip',{'max-width':'300px'});
		});
		
		function clos(){
			onStart(document.body.clientHeight - 28);
			$('#dataGrid').datagrid('cancelCellTip');
			$('#dataGrid').datagrid('doCellTip',{'max-width':'300px'});
		}
		
		function ope(){
			onStart(document.body.clientHeight - 185);
			$('#dataGrid').datagrid('cancelCellTip');
			$('#dataGrid').datagrid('doCellTip',{'max-width':'300px'});
		}
		
		function onStart(heigh){
		 	dataGrid = $('#dataGrid').datagrid({
				title : "安装服务单",
				url : "${ctx}/installReceipt/getInstallReceiptPageList",
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
				columns : [ [ 
				   {field : 'service_id',title : '安装单号', width : 10 ,align:'center'
				}, {field : 'machine_type',title : '机型', width : 10,align:'center'
				}, {field : 'gome_code',title : '国美代码', width : 10,align:'center'
				}, {field : 'brand',title : '品牌', width : 10,align:'center'
				}, {field : 'machine_code',title : '机器条码', width : 10,align:'center'
				}, {field : 'internal_machine_code1',title : '内机条码(空调)', width : 10,align:'center'
				}, {field : 'delivery_order_num',title : '提货单号', width : 10,align:'center'
				}, {field : 'ticket_num',title : '单据序号', width : 10,align:'center'
				}, {field : 'customer_name',title : '客户姓名', width : 10,align:'center'
				}, {field : 'service_status',title : '状态',align:'center'
				}, {field : 'create_organization',title : '创建机构', width : 10,align:'center'
				}, {field : 'create_time',title : '创建时间', width : 10,align:'center'
				}, {field : 'install_unit',title : '安装单位', width : 20,align:'center'
				}, {field : 'install_date',title : '安装日期', width : 16,align:'center'
				}, {field : 'action',title : '操作', width : 13,align:'center',
					formatter : function(value, row, index) {
						if(row.service_status=="S1"){
							return '<a href="#" onclick="checkTicket(\'' + row.service_id + '\');">查看</a>|<a href="#" onclick="updateTicket(\'' 
							+ row.service_id + '\');">修改</a>|<a href="#" onclick="del(\'' + row.service_id + '\');">删除</a>';
						}else{
							return '<a href="#" onclick="checkTicket(\'' + row.service_id + '\');">查看</a>';
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
				pageSize: 20,         
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
	
		function checkTicket(serviceId){
			window.location.href="${ctx}/installReceipt/installReceiptView/"+ serviceId ;
		}
		
		function updateTicket(installNum){
			var Id = $("#Id").val();
			window.location.href="${ctx}/installReceipt/updateInstallReceiptView/"+ installNum;
		}
		
		function del(serviceId){
			parent.$.messager.confirm('提示', '确认要删除么？', function(r){
				if (r){
					$.post("${ctx}/installReceipt/deleteInstallReceipt/"+serviceId,
						function(msg){
						if($.parseJSON(msg).flag == "success"){
							$.messager.alert('提示:','删除成功!');
							$('#dataGrid').datagrid("reload");
						}else{
							$.messager.alert('提示:','删除失败!');
						}
					});
				}
			});
		}
		
		function refreshDataGrid() {
			$('#dataGrid').datagrid("reload");
			parent.$.modalDialog.handler.dialog('close');	
		}	
		
		function add(){
			window.location.href = "${ctx}/installReceipt/addview";
		}
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,border:false">
		<div data-options="region:'north',title:'查询条件',border:false,collapsible:true,onBeforeCollapse:function(){clos();},onBeforeOpen:function(){ope();}"  style="height: 185px; overflow: hidden;">
			<form id="searchForm">
				<table class="table table-hover table-condensed" width="100%;" style="padding:10px 10px 10px 10px">
					<tr>
						<td width="5%">安装单号</td>
						<td width="15%"><input name="serviceTicket.serviceId" placeholder="请输入查询条件" class="span2" ></td>
						<td width="5%">机型</td>
						<td width="15%"><input name="serviceProduct.machineType" placeholder="请输入查询条件" class="span2" ></td>
						<td width="5%">国美代码</td>
						<td width="15%"><input name="serviceProduct.gomeCode"  placeholder="请输入查询条件" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/gmdm',panelHeight:'auto',editable:false "></td>
						<td width="5%">品牌</td>
						<td width="15%"><input name="serviceProduct.brand"  placeholder="请输入查询条件" class="easyui-combobox" class="span2" data-options="url:'${ctx}/hxCode/getCombobox/pp',panelHeight:'auto',editable:false "></td>
						<td width="5%">提货单号</td>
						<td width="15%"><input name="serviceProduct.deliveryOrderNum"  placeholder="请输入查询条件" class="span2" ></td>
					</tr>
					<tr>
						<td>单据序号</td>
						<td><input name="serviceProduct.ticketNum"  placeholder="请输入查询条件" class="span2" ></td>
						<td>外机条码(空调)</td>
						<td><input name="serviceProduct.externalMachineCode"  placeholder="请输入查询条件" class="span2" ></td>
						<td>内机条码1(空调)</td>
						<td><input name="serviceProduct.internalMachineCode1"  placeholder="请输入查询条件" class="span2" ></td>
						<td>内机条码2(空调)</td>
						<td><input name="serviceProduct.internalMachineCode2"  placeholder="请输入查询条件" class="span2" ></td>
						<td>机器条码</td>
						<td><input name="serviceProduct.machineCode"  placeholder="请输入查询条件" class="span2" ></td>
				    </tr>
					<tr>
						<td>客户姓名</td>
						<td><input name="serviceCustomer.customerName"  placeholder="请输入查询条件" class="span2" ></td>
						<td>客户电话</td>
						<td><input name="serviceCustomer.phone"  placeholder="请输入查询条件" class="span2" ></td>
						<td>状态</td>
						<td width="20%"><input name="serviceTicket.serviceStatus"  placeholder="请输入查询条件" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/hzzt',panelHeight:'auto',editable:false "></td>
						<td>创建人</td>
						<td><input name="serviceTicket.createManS"  placeholder="请输入查询条件" class="span2" ></td>
						<td>创建机构</td>
						<td><input name="serviceTicket.createOrganizationS"  placeholder="请输入查询条件" class="span2" ></td>
					</tr>
					<tr>
						<td>机型分类</td>
						<td><input id="serviceProduct.machineType"  placeholder="请输入查询条件" class="span2" ></td>
						<td>安装单位</td>
						<td><input name="serviceProduct.installUnit"  placeholder="请输入查询条件" class="span2" ></td>
						<td>创建时间</td>
						<td>
							<input id="ksrq" placeholder="选择起始日期" class="Wdate" name="mod_createTime_st" type="text" readonly="readonly"  onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'jsrq\')}'})"/><br/>
							<input id="jsrq" placeholder="选择结束日期" class="Wdate" name="mod_createTime_end" type="text" readonly="readonly"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'ksrq\')}'})"/> 
						</td>
						<td>安装日期</td>
						<td>
							<input id="iksrq" placeholder="选择起始日期" class="Wdate" name="mod_installDate_st" type="text" readonly="readonly"  onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'ijsrq\')}'})"/><br/>
							<input id="ijsrq" placeholder="选择结束日期" class="Wdate" name="mod_installDate_end" type="text" readonly="readonly"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'iksrq\')}'})"/> 
						</td>
						<td></td>
						<td align="center"><a href="#" id="query" class="easyui-linkbutton">查询</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="easyui-layout" data-options="fit:true,border:false">
			<div id="toolbar" style="display: "";">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="add();">增加</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-excel',plain:true" onclick="exportExcel();">导出</a>
			</div>
		</div>
		<div data-options="region:'center',border:false">
			<table id="dataGrid"></table>
		</div>
	</div>
</body>
</html>