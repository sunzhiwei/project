<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<script type="text/javascript">
	function save(){
		if(validate()){
			var retreatReplacement = $.serializeObject($('#form'));
			$.ajax({
	            type:"POST", 
	            url:"${ctx}/retreatReplacementCreate/retreatReplacementUpdate", 
	            dataType:"json",
	            contentType:"application/json",
	            data:JSON.stringify(retreatReplacement), 
	            success:function(data){
	            	if(data.flag == "success"){
	            		$.messager.alert('', '保存成功!',null,function(){
	 						window.location.href="${ctx}/retreatReplacementCreate/retreatReplacementView/"+ data.applyId;
	            		});
	            	}else{
	            		$.messager.alert('','新增失败!');
	            	}
	            } 
	        });
		}
	}
	
	function validate(){
		var flag = true;
		if($("input[name=applyUnit]").val() == ""){alert("请输入申请单位！");return false;};
		if($("input[name=sellSubsection]").val() == ""){alert("请输入销售分部！");return false;};
		if($("input[name=sellStore]").val() == ""){alert("请输入销售门店！");return false;};
		if($("input[name=isPresale]").val() == ""){alert("请输入是否售前机！");return false;};
		if($("input[name=isOnwall]").val() == ""){alert("请输入是否上墙！");return false;};
		if($("input[name=retreatReplacement]").val() == ""){alert("请输入退换机");return false;};
		if($("input[name=rrMode]").val() == ""){alert("请输入产退换模式");return false;};
		if($("input[name=faultCode]").val() == ""){alert("请输入故障代码！");return false;};
		if($("input[name=faultReason]").val() == ""){alert("请输入故障原因！");return false;};
		if($("input[name=faultReasonDetail]").val() == ""){alert("请输入故障详细信息！");return false;};
		if($("input[name=installUnit]").val() == ""){alert("请输入安装单位！");return false;};
		if($("input[name=intaller]").val() == ""){alert("请输入安装工！");return false;};
		if($("input[name=deliveryOrderNum]").val() == ""){alert("请输入提货单号！");return false;};
		if($("input[name=oldMachineType]").val() == ""){alert("请输入原机型！");return false;};
		return flag;
	}
	
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
	
	function goBack(){
		window.location.href = "${ctx}/retreatReplacementCreate/retreatReplacementCreateView";
	}
</script>
<form id="form" method="post">
	<div style="background-color:#95b8e7; text-align:center; color:#fff; font-weight:bold; border-bottom: 1px solid #000;">修改空调退换机申请信息</div>
	<input name="applyId" type="hidden" value="${sr.applyId}"/>
	<table border=1 style="cellSpacing:1;cellPadding:3;width:100%;background-color:#eff5ff;border-collapse:collapse">
		<tr>
			<td width="25%" align="center">退换机商品类型<font color="red">*</font></td>
			<td width="25%"><input class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/thjlx',panelHeight:'auto',editable:false,required:true"/></td>
			<td width="25%"></td>
			<td width="25%"></td>
		</tr>
		<tr>
			<td width="25%" align="center">申请单位<font color="red">*</font></td>
			<td width="25%"><input name="applyUnit" value="${sr.applyUnit }" type="text" placeholder="请输入申请单位" class="easyui-validatebox span2" data-options="required:true"/></td>
			<td width="25%" align="center">销售分部<font color="red">*</font></td>
			<td width="25%"><input name="sellSubsection" value="${sr.sellSubsection }" type="text" placeholder="请输入销售分部" class="easyui-validatebox span2" data-options="required:true"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">销售门店<font color="red">*</font></td>
			<td width="25%"><input  name="sellStore" value="${sr.sellStore }" type="text" placeholder="请输入销售门店" class="easyui-validatebox span2" data-options="required:true"/></td>
			<td width="25%" align="center">是否售前机<font color="red">*</font></td>
			<td width="25%"><input class="easyui-combobox" name="isPresale" value="${sr.isPresale }" data-options="url:'${ctx}/hxCode/getCombobox/sf',panelHeight:'auto',editable:false,required:true"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">是否上墙<font color="red">*</font></td>
			<td width="25%"><input class="easyui-combobox" name="isOnwall" value="${sr.isOnwall }" data-options="url:'${ctx}/hxCode/getCombobox/sf',panelHeight:'auto',editable:false,required:true"/></td>
			<td width="25%" align="center">用户名称</td>
			<td width="25%"><input  name="customerName" value="${sr.customerName }" type="text" placeholder="请输入用户名称" class="easyui-validatebox span2" /></td>
		</tr>
		<tr>
			<td width="25%" align="center">用户电话</td>
			<td width="25%"><input  name="customerPhone" value="${sr.customerPhone }" type="text" placeholder="请输入用户电话" class="easyui-validatebox span2"/></td>
			<td width="25%"></td>
			<td width="25%"></td>
		</tr>
		<tr>
			<td width="25%" align="center">用户地址</td>
			<td width="25%" colspan="3"><textarea name="customerAddress" placeholder="请输入用户地址" rows="3" cols="52">${sr.customerAddress }</textarea></td>
		</tr>
		<tr>
			<td width="25%" align="center">购机日期</td>
			<td width="25%"><input placeholder="选择购机日期" class="Wdate" name="buyDate" value="<fmt:formatDate value='${sr.buyDate}' pattern='yyyy-MM-dd'/>" readonly="readonly" type="text" onFocus="WdatePicker()"/></td>
			<td width="25%" align="center">故障日期</td>
			<td width="25%"><input placeholder="选择故障日期" class="Wdate" value="<fmt:formatDate value='${sr.faultDate}' pattern='yyyy-MM-dd'/>"  readonly="readonly" type="text" onFocus="WdatePicker()"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">退换机<font color="red">*</font></td>
			<td width="25%"><input class="easyui-combobox" name="retreatReplacement" value="${sr.retreatReplacement }" data-options="url:'${ctx}/hxCode/getCombobox/thj',panelHeight:'auto',editable:false,required:true"/></td>
			<td width="25%" align="center">退换模式<font color="red">*</font></td>
			<td width="25%"><input class="easyui-combobox" name="rrMode" value="${sr.rrMode }" data-options="url:'${ctx}/hxCode/getCombobox/thms',panelHeight:'auto',editable:false,required:true"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">故障代码<font color="red">*</font></td>
			<td width="25%"><input name="faultCode" value="${sr.faultCode }" type="text" placeholder="请选择故障代码" class="easyui-validatebox span2" data-options="required:true" onkeyup="showFaultMenu()"/></td>
			<td width="25%" align="center">故障原因<font color="red">*</font></td>
			<td width="25%"><input  name="faultReason" value="${sr.faultReason }" type="text" placeholder="故障原因" class="easyui-validatebox span2" data-options="required:true"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">故障原因详细描述<font color="red">*</font></td>
			<td width="25%" colspan="3"><textarea name="faultReasonDetail" placeholder="请输入故障原因详细描述" data-options="required:true" rows="3" cols="52">${sr.faultReasonDetail }</textarea></td>
		</tr>
		<tr>
			<td width="25%" align="center">安装单位<font color="red">*</font></td>
			<td width="25%"><input  name="installUnit" value="${sr.installUnit }" type="text" placeholder="请输入安装单位" class="easyui-validatebox span2" data-options="required:true"/></td>
			<td width="25%" align="center">安装日期</td>
			<td width="25%"><input  name="installDate" value="<fmt:formatDate value='${sr.installDate}' pattern='yyyy-MM-dd'/>" placeholder="选择安装日期" readonly="readonly" class="Wdate" type="text" onFocus="WdatePicker()"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">安装人员<font color="red">*</font></td>
			<td width="25%"><input  name="intaller" value="${sr.intaller }" type="text" placeholder="请输入安装人员" class="easyui-validatebox span2" data-options="required:true"/></td>
			<td width="25%" align="center">原提货单号<font color="red">*</font></td>
			<td width="25%"><input name="deliveryOrderNum" value="${sr.deliveryOrderNum }" type="text" placeholder="请输入原提货单号" class="easyui-validatebox span2" data-options="required:true"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">原机型</td>
			<td width="25%"><input name="oldMachineType" value="${sr.oldMachineType }" type="text" placeholder="请输入原机型" class="easyui-validatebox span2" /></td>
			<td width="25%" align="center">国美代码(原)<font color="red">*</font></td>
			<td width="25%"><input class="easyui-combobox" value="${sr.oldGomeCode }" name="oldGomeCode" data-options="url:'${ctx}/hxCode/getCombobox/gmdm',panelHeight:'auto',editable:false,required:true"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">品牌(原)</td>
			<td width="25%"><input class="easyui-combobox" value="${sr.oldBrand }" name="oldBrand" data-options="url:'${ctx}/hxCode/getCombobox/pp',panelHeight:'auto',editable:false"/></td>
			<td width="25%" align="center">原机器条码</td>
			<td width="25%"><input name="oldMachineCode" value="${sr.oldMachineCode }" type="text" placeholder="请输入原机器条码" class="easyui-validatebox span2"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">原内机条码1</td>
			<td width="25%"><input name="oldInnerCode1" value="${sr.oldInnerCode1 }" type="text" placeholder="请输入原内机条码1" class="easyui-validatebox span2"/></td>
			<td width="25%" align="center">原内机条码2</td>
			<td width="25%"><input name="oldInnerCode2" value="${sr.oldInnerCode2 }" type="text" placeholder="请输入原内机条码2" class="easyui-validatebox span2"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">原外机条码</td>
			<td width="25%"><input name="oldOuterCode" value="${sr.oldOuterCode }" type="text" placeholder="请输入原外机条码" class="easyui-validatebox span2"/></td>
			<td width="25%" align="center">现机型</td>
			<td width="25%"><input name="machineType" value="${sr.machineType }" type="text" placeholder="请输入现机型" class="easyui-validatebox span2"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">国美代码(新)</td>
			<td width="25%"><input class="easyui-combobox" name="gomeCode" value="${sr.gomeCode }" data-options="url:'${ctx}/hxCode/getCombobox/gmdm',panelHeight:'auto',editable:false"/></td>
			<td width="25%" align="center">品牌(新)</td>
			<td width="25%"><input class="easyui-combobox" name="brand" value="${sr.brand }" data-options="url:'${ctx}/hxCode/getCombobox/pp',panelHeight:'auto',editable:false"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">现机器条码</td>
			<td width="25%"><input name="machineCode" value="${sr.machineCode }" type="text" placeholder="请输入现机器条码" class="easyui-validatebox span2"/></td>
			<td width="25%" align="center">现内机条码1</td>
			<td width="25%"><input  name="innerCode1" value="${sr.innerCode1 }" type="text" placeholder="请输入现内机条码1" class="easyui-validatebox span2" /></td>
		</tr>
		<tr>
			<td width="25%" align="center">现内机条码2</td>
			<td width="25%"><input  name="innerCode2" value="${sr.innerCode2 }" type="text" placeholder="请输入现内机条码2" class="easyui-validatebox span2"/></td>
			<td width="25%" align="center">现外机条码</td>
			<td width="25%"><input name="outerCode" value="${sr.outerCode }" type="text" placeholder="请输入现外机条码" class="easyui-validatebox span2"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">退换日期</td>
			<td width="25%"><input  placeholder="选择退换日期" class="Wdate" name="rrDate" value="<fmt:formatDate value='${sr.rrDate}' pattern='yyyy-MM-dd'/>" readonly="readonly" type="text" onFocus="WdatePicker()"/></td>
			<td width="25%" align="center">鉴定人<font color="red">*</font></td>
			<td width="25%"><input name="appraiser" value="${sr.appraiser }" type="text" placeholder="请输入鉴定人" class="easyui-validatebox span2" data-options="required:true"/></td>
		</tr>
		<tr>
			<td width="25%" align="center">备注</td>
			<td width="25%" colspan="3"><textarea name="comment" placeholder="请输入备注" rows="3" cols="52">${sr.comment }</textarea></td>
		</tr>
	</table>
</form>
<div align="right" style="padding:5px;">
	<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g1',iconCls:'icon-save'" onclick="save();">保存</a>
	<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',iconCls:'icon-back'" onclick="goBack();">返回</a>
</div>