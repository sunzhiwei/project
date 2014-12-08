<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	var dataGrid;
	$(function(){
		onStart(document.body.clientHeight - 270);
		$('#dataGrid').datagrid('cancelCellTip');
		$('#dataGrid').datagrid('doCellTip',{'max-width':'300px'});
	});
	
	function clos(){
		onStart(document.body.clientHeight - 28);
		$('#dataGrid').datagrid('cancelCellTip');
		$('#dataGrid').datagrid('doCellTip',{'max-width':'300px'});
	}
	
	function ope(){
		onStart(document.body.clientHeight - 270);
		$('#dataGrid').datagrid('cancelCellTip');
		$('#dataGrid').datagrid('doCellTip',{'max-width':'300px'});
	}
	
	function onStart(heigh){
		 dataGrid = $('#dataGrid').datagrid({
	            title : "退换机服务单",
	            url : "${ctx}/retreatReplacementCreate/getRetreatReplacementCreateList",
	            striped : true,
	            height : heigh,
	            collapsible : true,
	            autoRowHeight : false,
	            remoteSort : false,
	            idField : 'apply_id',
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
	              {field : 'apply_id', title:'申请单号',width : 30, align:'center'
	            },{field : 'apply_unit', title:'申请<br/>单位',width : 15, align:'center'
	            },{field : 'sell_subsection', title:'销售<br/>分部',width : 15, align:'center'
	            },{field : 'sell_store', title:'销售<br/>门店',width : 15, align:'center'
	            },{field : 'customer_name', title:'用户<br/>名称',width : 15, align:'center'
	            },{field : 'customer_phone', title:'用户<br/>电话',width : 15, align:'center'
	            },{field : 'buy_date', title:'购机<br/>日期',width : 15, align:'center'
	            },{field : 'retreat_replacement', title:'退换<br/>机',width : 15, align:'center'
	            },{field : 'rr_mode', title:'退换<br/>模式',width : 15, align:'center'
	            },{field : 'fault_phenomenon', title:'故障<br/>现象',width : 15, align:'center'
	            },{field : 'fault_trunk_reason', title:'故障<br/>总原因',width : 15, align:'center'
	            },{field : 'fault_branch_reason', title:'故障<br/>分原因',width : 15, align:'center'
	            },{field : 'fault_reason_detail', title:'故障原因<br/>详细描述',width : 22, align:'center'
	            },{field : 'delivery_order_num', title:'原提<br/>货单号',width : 15, align:'center'
	            },{field : 'old_machine_type', title:'原机<br/>型',width : 15, align:'center'
	            },{field : 'old_gome_code', title:'国美<br/>代码(原)',width : 20, align:'center'
	            },{field : 'old_brand', title:'品牌<br/>(原)',width : 15, align:'center'
	            },{field : 'old_machine_code', title:'原机<br/>器条码',width : 15, align:'center'
	            },{field : 'old_inner_code1', title:'原内机<br/>条码1',width : 15, align:'center'
	            },{field : 'old_inner_code2', title:'原内机<br/>条码2',width : 15, align:'center'
	            },{field : 'old_outer_code', title:'原外<br/>机条码',width : 15, align:'center'
	            },{field : 'machine_type', title:'现机<br/>型',width : 15, align:'center'
	            },{field : 'gome_code', title:'国美代<br/>码(新)',width : 15, align:'center'
	            },{field : 'brand', title:'品牌<br/>(新)',width : 15, align:'center'
	            },{field : 'machine_code', title:'现机器<br/>条码',width : 15, align:'center'
	            },{field : 'inner_code1', title:'现内机<br/>条码1',width : 15, align:'center'
	            },{field : 'inner_code2', title:'现内机<br/>条码2',width : 15, align:'center'
	            },{field : 'outer_code', title:'现外机<br/>条码',width : 15, align:'center'
	            },{field : 'status', title:'状<br/>态',width : 8, align:'center'
	            },{field : 'check_result', title:'机审<br/>通过',width : 15, align:'center'
	            },{field : 'machine_check_fault_reason', title:'机审错<br/>误原因',width : 15, align:'center'
	            },{field : 'center_check_result', title:'分部是否<br/>通过审批',width : 15, align:'center'
	            },{field : 'headquarters_check_result', title:'总部是否<br/>通过审批',width : 15, align:'center'
	            },{field : 'create_time', title:'申请<br/>日期',width : 15, align:'center'
	            },{field : 'center', title:'接收<br/>分部',width : 15, align:'center'
	            },{field : 'install_date', title:'安装<br/>日期',width : 15, align:'center'
	            },{field : 'action',title : '操作',width :40,align:'center',
					formatter : function(value, row, index) {    
						return '<a href="#" onclick="show(\'' + row.apply_id + '\');">查看</a>';
					}
				}] ],
	            toolbar : '#toolbar',
	            onLoadSuccess : function() {
	                $('#searchForm table').show();
	                $(this).datagrid('doCellTip',{'max-width':'300px','delay':500});
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
			pageNo : 1,
			pageCount : 20
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
	
	function show(applyId){
		window.location.href = "${ctx}/retreatReplacementCreate/retreatReplacementQueryShow/"+applyId;
	}

	function exportExcel(){
			var opts = dataGrid.datagrid('getColumnFields');
			var fieldArray = new Array();
			var titleArray = new Array();
			for(var i = 0; i < opts.length - 1 ;i++){
				var column = dataGrid.datagrid('getColumnOption', opts[i]);
				fieldArray.push(column.field);
				titleArray.push(column.title);
			}
			window.location.href = "${ctx}/retreatReplacementCreate/exportExcel?" + encodeURI($('#searchForm').serialize()) + "&tableField=" + fieldArray.join("|") + "&tableHeader=" + encodeURI(encodeURI(titleArray.join("|")));
	    }
</script>
</head>
<body>
    <div class="easyui-layout" data-options="fit:true,border:false">
        <div data-options="region:'north', title:'查询条件',border:false,collapsible:true,onBeforeCollapse:function(){clos();},onBeforeOpen:function(){ope();}"  style="height: 270px; overflow: hidden;">
		<form id="searchForm">
			<table style="width:100%; padding: 10px 10px 10px 10px;">
				<tr>
					<td width="5%">申请单号</td>
					<td width="15%"><input name="applyId" type="text" placeholder="请输入申请单号" class="easyui-validatebox span2" value=""/></td>
					<td width="5%">申请单位</td>
					<td width="15%"><input name="applyUnit" type="text" placeholder="请输入申请单位" class="easyui-validatebox span2" value=""/></td>
					<td width="5%">销售分部</td>
					<td width="15%"><input name="sellSubsection" type="text" placeholder="请输入销售分部" class="easyui-validatebox span2" value=""/></td>
					<td width="5%">销售门店</td>
					<td width="15%"><input  name="sellStore" type="text" placeholder="请输入销售门店" class="easyui-validatebox span2" value=""/></td>
					<td width="5%">是否售前机</td>
					<td width="15%"><input class="easyui-combobox" name="isPresale" data-options="url:'${ctx}/hxCode/getCombobox/sf',panelHeight:'auto',editable:false "/></td>
				</tr>
				<tr>
					<td>是否上墙</td>
					<td><input class="easyui-combobox" name="isOnwall" data-options="url:'${ctx}/hxCode/getCombobox/sf',panelHeight:'auto',editable:false "/></td>
					<td>用户名称</td>
					<td><input  name="customerName" type="text" placeholder="请输入用户名称" class="easyui-validatebox span2" value=""/></td>
					<td>用户电话</td>
					<td><input  name="customerPhone" type="text" placeholder="请输入用户电话" class="easyui-validatebox span2" value=""/></td>
					<td>退换机</td>
					<td><input class="easyui-combobox" name="retreatReplacement" data-options="url:'${ctx}/hxCode/getCombobox/thj',panelHeight:'auto',editable:false "/></td>
					<td>退换模式</td>
					<td><input class="easyui-combobox" name="rrMode" data-options="url:'${ctx}/hxCode/getCombobox/thms',panelHeight:'auto',editable:false "/></td>
				</tr>
				<tr>
					<td>故障现象</td>
					<td><input  id="faultPhenomenon" type="text" placeholder="请输入故障现象" class="easyui-validatebox span2" value=""/></td>
					<td>故障原因</td>
					<td><input  name="faultReason" type="text" placeholder="请输入故障总原因" class="easyui-validatebox span2" value=""/></td>
					<td>故障原因详细描述</td>
					<td><input  name="faultReasonDetail" type="text" placeholder="请输入故障原因详细描述" class="easyui-validatebox span2" value=""/></td>
					<td>原提货单号</td>
					<td><input name="deliveryOrderNum" type="text" placeholder="请输入原提货单号" class="easyui-validatebox span2" value=""/></td>
					<td>原机型</td>
					<td><input name="oldMachineType" type="text" placeholder="请输入原机型" class="easyui-validatebox span2" value=""/></td>
				</tr>
				<tr>
					<td>国美代码(原)</td>
					<td><input class="easyui-combobox" name="oldGomeCode" data-options="url:'${ctx}/hxCode/getCombobox/gmdm',panelHeight:'auto',editable:false "/></td>
					<td>品牌(原)</td>
					<td><input class="easyui-combobox" name="oldBrand" data-options="url:'${ctx}/hxCode/getCombobox/pp',panelHeight:'auto',editable:false "/></td>
					<td>原机器条码</td>
					<td><input name="oldMachineCode" type="text" placeholder="请输入原机器条码" class="easyui-validatebox span2" value=""/></td>
					<td>原内机条码1</td>
					<td><input name="oldInnerCode1" type="text" placeholder="请输入原内机条码1" class="easyui-validatebox span2" value=""/></td>
					<td>原内机条码2</td>
					<td><input name="oldInnerCode2" type="text" placeholder="请输入原内机条码2" class="easyui-validatebox span2" value=""/></td>
				</tr>
				<tr>
					<td>原外机条码</td>
					<td><input name="oldOuterCode" type="text" placeholder="请输入原外机条码" class="easyui-validatebox span2" value=""/></td>
					<td>现机型</td>
					<td><input name="machineType" type="text" placeholder="请输入现机型" class="easyui-validatebox span2" value=""/></td>
					<td>国美代码(新)</td>
					<td><input class="easyui-combobox" name="gomeCode" data-options="url:'${ctx}/hxCode/getCombobox/gmdm',panelHeight:'auto',editable:false "/></td>
					<td>品牌(新)</td>
					<td><input class="easyui-combobox" name="brand" data-options="url:'${ctx}/hxCode/getCombobox/pp',panelHeight:'auto',editable:false "/></td>
					<td>现机器条码</td>
					<td><input name="machineCode" type="text" placeholder="请输入现机器条码" class="easyui-validatebox span2" value=""/></td>
				</tr>
				<tr>
					<td>现内机条码1</td>
					<td><input  name="innerCode1" type="text" placeholder="请输入现内机条码1" class="easyui-validatebox span2" value=""/></td>
					<td>现内机条码2</td>
					<td><input  name="innerCode2" type="text" placeholder="请输入现内机条码2" class="easyui-validatebox span2" value=""/></td>
					<td>现外机条码</td>
					<td><input name="outerCode" type="text" placeholder="请输入现外机条码" class="easyui-validatebox span2" value=""/></td>
					<td>状态</td>
					<td><input class="easyui-combobox" name="status" data-options="url:'${ctx}/hxCode/getCombobox/thjzt',panelHeight:'auto',editable:false "/></td>
					<td>机审通过</td>
					<td><input class="easyui-combobox" name="checkResult" data-options="url:'${ctx}/hxCode/getCombobox/sf',panelHeight:'auto',editable:false "/></td>
				</tr>
				<tr>
					<td>机审错误原因</td>
					<td><input name="machineCheckFaultReason" type="text" placeholder="请输入机审错误原因" class="easyui-validatebox span2" value=""/></td>
					<td>分部是否通过审批</td>
					<td><input class="easyui-combobox" name="centerCheckResult" data-options="url:'${ctx}/hxCode/getCombobox/sf',panelHeight:'auto',editable:false "/></td>
					<td>总部是否通过审批</td>
					<td><input class="easyui-combobox" name="headquartersCheckResult" data-options="url:'${ctx}/hxCode/getCombobox/sf',panelHeight:'auto',editable:false "/></td>
					<td>接收分部</td>
					<td><input id="receiveCenter" type="text" placeholder="请输入接收分部" class="easyui-validatebox span2" value=""/></td>
				</tr>
				<tr>
					<td>购机日期</td>
					<td>
						<input size="12" id="buyDateStartTime" placeholder="选择起始日期" class="Wdate" name="buyDateStartTime" type="text" readonly="readonly"  onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'buyDateEndTime\')}'})"/>
						<input size="12" id="buyDateEndTime" placeholder="选择结束日期" class="Wdate" name="buyDateEndTime" type="text" readonly="readonly"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'buyDateStartTime\')}'})"/> 
					</td>
					<td>申请日期</td>
					<td>
						<input size="12" id="applyDateStartTime" placeholder="选择起始日期" class="Wdate" name="applyDateStartTime" type="text" readonly="readonly"  onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'applyDateEndTime\')}'})"/>
						<input size="12" id="applyDateEndTime" placeholder="选择结束日期" class="Wdate" name="applyDateEndTime" type="text" readonly="readonly"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'applyDateStartTime\')}'})"/> 
					</td>
					<td>安装日期</td>
					<td>
						<input size="12" id="installDateStartTime" placeholder="选择起始日期" class="Wdate" name="installDateStartTime" type="text" readonly="readonly"  onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'installDateEndTime\')}'})"/>
						<input size="12" id="installDateEndTime" placeholder="选择结束日期" class="Wdate" name="installDateEndTime" type="text" readonly="readonly"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'installDateStartTime\')}'})"/> 
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td align="center"><a href="#" id="query" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="toolbar" style="display: none;">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="exportExcel();">导出</a>
	</div>
	<div data-options="region:'center',border:false">
            <table id="dataGrid"></table>
    </div>
</div>
</body>
</html>