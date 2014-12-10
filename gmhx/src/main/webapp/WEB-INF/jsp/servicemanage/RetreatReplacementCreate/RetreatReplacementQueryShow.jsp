<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<script type="text/javascript">
	
	$(function(){
		parent.$.messager.progress('close');
		var s = "${sr.status}";
		if(s!="S1"){
			$("#send").hide();
			$("#update").hide();
			$("#updateAccessory").hide();
		}
	});
	
	function goBack(){
		window.location.href = "${ctx}/retreatReplacementCreate/retreatReplacementQueryView";
	}
	
	function print(){
		if("${sr.isPassCheck}"=="false"){
			var iWidth=850; //弹出窗口的宽度;
			var iHeight=850; //弹出窗口的高度;
			var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
			var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
			window.open('${ctx }/HxJasperReport/print?applyId=${sr.applyId}',"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft+"toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no"); 
		}else{
			$.messager.alert('提示:','该退换机未审批通过无法打印,请确认退换机审批通过!');
		}
		
	}
	
</script>
<input id="applyId" type="hidden" value="${sr.applyId }"/>
<div style="background-color:#95b8e7; text-align:center; color:#fff; font-weight:bold; border-bottom: 1px solid #000;">空调退换机申请详细资料</div>
<table border=1 style="cellSpacing:1;cellPadding:3;width:100%;background-color:#eff5ff;border-collapse:collapse">
	<tr>
		<td width="25%" align="center">申请单号</td><td width="25%" ><label>${sr.applyId}</label></td>
		<td width="25%" align="center">申请单位</td>
		<td width="25%" >
			<input class="easyui-combobox" disabled="disabled" value="${sr.applyUnit}" data-options="url:'${ctx}/hxCode/getWebsiteCombobox',panelHeight:'100',required:true,editable:true"/>
		</td>
	</tr>
	<tr>	
		<td width="25%" align="center">销售分部</td>
		<td width="25%" >
			<input disabled="disabled" value="${sr.sellSubsection}" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getECCombobox/',required:true">
		</td>
		<td width="25%" align="center">销售门店</td>
		<td width="25%" >
			<input value="${sr.sellStore}" disabled="disabled" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getStoreCombobox',required:true">
		</td>
	</tr>
	<tr>
		<td width="25%" align="center">是否售前机</td><td width="25%"><input class="easyui-combobox" name="isPresale" value="${sr.isPresale}" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/sf',panelHeight:'auto',required:true,editable:false"/></td>
		<td width="25%" align="center">是否上墙</td><td width="25%"><input class="easyui-combobox" name="isOnwall" value="${sr.isOnwall}" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/sf',panelHeight:'auto',required:true,editable:false"/></td>
	</tr>
	<tr>	
		<td width="25%" align="center">用户姓名</td><td width="25%" ><label>${sr.customerName}</label></td>
		<td width="25%" align="center">用户电话</td><td width="25%" ><label>${sr.customerPhone}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">用户地址</td><td width="25%" ><label>${sr.customerAddress}</label></td>
		<td width="25%" align="center">购机日期</td><td width="25%" ><label><fmt:formatDate value='${sr.buyDate}' pattern='yyyy-MM-dd' /></label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">故障日期</td><td width="25%" ><label><fmt:formatDate value='${sr.faultDate}' pattern='yyyy-MM-dd' /></label></td>
		<td width="25%" align="center">退换机</td><td width="25%"><input class="easyui-combobox" name="retreatReplacement" value="${sr.retreatReplacement}" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/thj',panelHeight:'auto',required:true,editable:false"/></td>
	</tr>
	<tr>	
		<td width="25%" align="center">退换模式</td><td width="25%"><input class="easyui-combobox" name="rrMode" value="${sr.rrMode}" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/thms',panelHeight:'auto',required:true,editable:false"/></td>
		<td width="25%" align="center">故障代码</td><td width="25%" ><label>${sr.faultCode}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">故障原因</td><td width="25%" ><label>${sr.faultReason}</label></td>
		<td width="25%" align="center">故障原因详细描述</td><td width="25%" ><label>${sr.faultReasonDetail}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">安装单位</td>
		<td width="25%" ><label>${sr.installUnit}</label></td>
		<td width="25%" align="center">安装日期</td><td width="25%" ><label><fmt:formatDate value='${sr.installDate}' pattern='yyyy-MM-dd' /></label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">安装人员</td><td width="25%" ><label>${sr.intaller}</label></td>
		<td width="25%" align="center">原提货单号</td><td width="25%" ><label>${sr.deliveryOrderNum}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">原机型</td><td width="25%" ><label>${sr.oldMachineType}</label></td>
		<td width="25%" align="center">国美代码(原)</td><td width="25%"><input class="easyui-combobox" name="oldGomeCode" value="${sr.oldGomeCode}" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/gmdm',panelHeight:'auto',required:true,editable:false"/></td>
	</tr>
	<tr>	
		<td width="25%" align="center">品牌(原)</td><td width="25%"><input class="easyui-combobox" name="oldBrand" value="${sr.oldBrand}" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/pp',panelHeight:'auto',editable:false"/></td>
		<td width="25%" align="center">原机器条码(非空)</td><td width="25%" ><label>${sr.oldMachineCode}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">原内机条码1</td><td width="25%" ><label>${sr.oldInnerCode1}</label></td>
		<td width="25%" align="center">原内机条码2</td><td width="25%" ><label>${sr.oldInnerCode2}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">原外机条码</td><td width="25%" ><label>${sr.oldOuterCode}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">现机型</td><td width="25%" ><label>${sr.machineType}</label></td>
		<td width="25%" align="center">国美代码(新)</td><td width="25%"><input class="easyui-combobox" name="gomeCode" value="${sr.gomeCode}" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/gmdm',panelHeight:'auto',editable:false"/></td>
	</tr> 
	<tr>
		<td width="25%" align="center">品牌(新)</td><td width="25%"><input class="easyui-combobox" name="brand" value="${sr.brand}" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/pp',panelHeight:'auto',editable:false"/></td>
		<td width="25%" align="center">现机器条码(非空)</td><td width="25%" ><label>${sr.machineCode}</label></td>
	</tr> 
	<tr>	
		<td width="25%" align="center">现内机条码1</td><td width="25%" ><label>${sr.innerCode1}</label></td>
		<td width="25%" align="center">现内机条码2</td><td width="25%" ><label>${sr.innerCode2}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">现外机条码</td><td width="25%" ><label>${sr.outerCode}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">退换日期</td><td width="25%" ><label><fmt:formatDate value='${sr.rrDate}' pattern='yyyy-MM-dd' /></label></td>
		<td width="25%" align="center">安装卡是否退回</td><td width="25%" ><label>${sr.isIcBack}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">录单时间</td><td width="25%" ><label>${sr.recordTime}</label></td>
		<td width="25%" align="center">状态</td><td width="25%" ><label>${sr.status}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">是否已退库</td><td width="25%" ><label>${sr.isStored}</label></td>
		<td width="25%" align="center">鉴定人</td><td width="25%" ><label>${sr.appraiser}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">机审通过</td><td width="25%" ><label>${sr.checkResult}</label></td>
		<td width="25%" align="center">机审错误原因</td><td width="25%" ><label>${sr.machineCheckFaultReason}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">分部是否同意</td><td width="25%" ><label>${sr.centerCheckResult}</label></td>
		<td width="25%" align="center">分部意见</td><td width="25%" ><label>${sr.centerCheckComment}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">分部审批人</td><td width="25%" ><label>${sr.centerCheckMan}</label></td>
		<td width="25%" align="center">分部审批日期</td><td width="25%" ><label>${sr.centerCheckTime}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">总部是否同意</td><td width="25%" ><label>${sr.headquartersCheckResult}</label></td>
		<td width="25%" align="center">总部意见</td><td width="25%" ><label>${sr.headquartersCheckComment}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">总部审批人</td><td width="25%" ><label>${sr.headquartersCheckMan}</label></td>
		<td width="25%" align="center">总部审批日期</td><td width="25%" ><label>${sr.headquartersCheckTime}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">备注</td><td width="25%" ><label>${sr.comment}</label></td>
		<td width="25%" align="center">附件</td><td width="25%" ><label>${sr.accessory}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">创建人</td><td width="25%" ><label>${sr.createMan}</label></td>
		<td width="25%" align="center">创建机构</td><td width="25%" ><label>${sr.createOrganization}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">创建时间</td><td width="25%" ><label><fmt:formatDate value='${sr.createTime}' pattern='yyyy-MM-dd HH:mm:ss' /></label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">修改人</td><td width="25%" ><label>${sr.alterMan}</label></td>
		<td width="25%" align="center">修改机构</td><td width="25%" ><label>${sr.alterOrganization}</label></td>
	</tr>
	<tr>	
		<td width="25%" align="center">修改时间</td><td width="25%" ><label><fmt:formatDate value='${sr.alterTime}' pattern='yyyy-MM-dd HH:mm:ss' /></label></td>
	</tr>
</table>

<div align="right" style="padding:5px;">
	<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',iconCls:'icon-back'" onclick="goBack();">返回</a>
	<a id="print" href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g1',iconCls:'icon-save'"  onclick="print();">打印</a>
</div>