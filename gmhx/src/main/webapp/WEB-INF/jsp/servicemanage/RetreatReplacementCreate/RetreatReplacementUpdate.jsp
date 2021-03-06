<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<script type="text/javascript">
	$(function(){
		var oldBrand = "${sr.oldBrand}";
		var brand = "${sr.brand}";
		
		if(brand.indexOf("空调")>-1){
			$(".kongtiao").show();
			$(".reshuiqi").hide();
			$('#machineCode').validatebox({required: false});  
			$('#innerCode1').validatebox({required: true});  
			$('#outerCode').validatebox({required: true}); 
			
		}else if(brand.indexOf("热水器")>-1){
			$(".kongtiao").hide();
			$(".reshuiqi").show();
			$('#innerCode1').validatebox({required: false});  
			$('#outerCode').validatebox({required: false});  
			$('#machineCode').validatebox({required: true});  
		}
		
		if(oldBrand.indexOf("空调")>-1){
			$(".olkongtiao").show();
			$(".olreshuiqi").hide();
			$('#oldMachineCode').validatebox({required: false});  
			$('#oldInnerCode1').validatebox({required: true});  
			$('#oldOuterCode').validatebox({required: true}); 
			
		}else if(oldBrand.indexOf("热水器")>-1){
			$(".olkongtiao").hide();
			$(".olreshuiqi").show();
			$('#oldInnerCode1').validatebox({required: false});  
			$('#oldOuterCode').validatebox({required: false});  
			$('#olMachineCode').validatebox({required: true});  
		}
		
		if(oldBrand.indexOf("空调")>-1){
			$(".olkongtiao").show();
			$(".olreshuiqi").hide();
		}
		if(brand.indexOf("空调")>-1){
			$(".kongtiao").show();
			$(".reshuiqi").hide();
		}
		
		var falutCode = $("#faultCode");
		 falutCode.focus(function(){
			 var obj = Object();
				var str = window.showModalDialog("${ctx}/repairReceipt/selectTroubleView",obj,"dialogWidth=600px;dialogHeight=400px;dialogLeft=700px;dialogTop=300px");
				 if(str.length!=0) {
					    len=str.indexOf("/")
					    code = str.substring(0,len)
					    name= str.substring(len+1)
					    $("#faultCode").val(code);
					    $("#faultReason").val(name);
				 }
		 });
	});

	function save(){
		if($("#form").form('validate')){
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
	
	function fillCombo(rec){
	    $("#sellStore").combobox('reload','${ctx}/hxCode/getStoreCombobox?center=' + rec.value);
	    $("#sellStore").combobox('clear');
	}
	
	function fillForm(rec){
		$("#gomeCode").combobox('setValue',rec.gomeCode); 
		$("#brand").combobox('setValue',rec.brand); 
		
		if(rec.brand.indexOf("空调")>-1){
			$(".kongtiao").show();
			$(".reshuiqi").hide();
			$("#machineCode").val("");
			$('#machineCode').validatebox({required: false});  
			$('#innerCode1').validatebox({required: true});  
			$('#outerCode').validatebox({required: true}); 
			
		}else if(rec.brand.indexOf("热水器")>-1){
			$(".kongtiao").hide();
			$(".reshuiqi").show();
			$("#innerCode1").val("");
			$("#innerCode2").val("");
			$("#outerCode").val("");
			$('#innerCode1').validatebox({required: false});  
			$('#outerCode').validatebox({required: false});  
			$('#machineCode').validatebox({required: true});  
		}
	}
	
	function fillForm2(rec){
		$("#oldGomeCode").combobox('setValue',rec.gomeCode); 
		$("#oldBrand").combobox('setValue',rec.brand); 
		
		if(rec.brand.indexOf("空调")>-1){
			$(".olkongtiao").show();
			$(".olreshuiqi").hide();
			$("#oldMachineCode").val("");
			$('#oldMachineCode').validatebox({required: false});  
			$('#oldInnerCode1').validatebox({required: true});  
			$('#oldOuterCode').validatebox({required: true}); 
			
		}else if(rec.brand.indexOf("热水器")>-1){
			$(".olkongtiao").hide();
			$(".olreshuiqi").show();
			$("#oldInnerCode1").val("");
			$("#oldInnerCode2").val("");
			$("#oldOuterCode").val("");
			$('#oldInnerCode1').validatebox({required: false});  
			$('#oldOuterCode').validatebox({required: false});  
			$('#olMachineCode').validatebox({required: true});  
		}
	}
	
	function goBack(){
		window.location.href = "${ctx}/retreatReplacementCreate/retreatReplacementCreateView";
	}
</script>
<form id="form" method="post">
	<div style="background-color:#95b8e7; text-align:center; color:#fff; font-weight:bold; border-bottom: 1px solid #000;">修改空调退换机申请信息</div>
	<input name="applyId" type="hidden" value="${sr.applyId}"/>
	<table border=1 style="cellSpacing:1;cellPadding:3;width:100%;background-color:#eff5ff;border-collapse:collapse">
		<tr>
			<td width="25%" align="center">申请单位<font color="red">*</font></td>
			<td width="25%"><input name="applyUnit" value="${sr.applyUnit}" type="text" placeholder="请输入申请单位" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getWebsiteCombobox',panelHeight:'100',required:true,editable:true"/></td>
			<td width="25%" align="center">销售分部<font color="red">*</font></td>
			<td width="25%"><input name="sellSubsection" value="${sr.sellSubsection }" type="text" placeholder="请输入销售分部" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getECCombobox/',required:true,onSelect:function(rec){fillCombo(rec)}"/></td>
		</tr>
		<tr>
			<td align="center">销售门店<font color="red">*</font></td>
			<td><input name="sellStore" value="${sr.sellStore}" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getStoreCombobox',required:true"/></td>
			<td align="center">是否售前机<font color="red">*</font></td>
			<td><input class="easyui-combobox" name="isPresale" value="${sr.isPresale }" data-options="url:'${ctx}/hxCode/getCombobox/sf',panelHeight:'auto',editable:false,required:true"/></td>
		</tr>
		<tr>
			<td align="center">是否上墙<font color="red">*</font></td>
			<td><input class="easyui-combobox" name="isOnwall" value="${sr.isOnwall }" data-options="url:'${ctx}/hxCode/getCombobox/sf',panelHeight:'auto',editable:false,required:true"/></td>
			<td align="center">用户名称</td>
			<td><input  name="customerName" value="${sr.customerName }" type="text" placeholder="请输入用户名称" class="easyui-validatebox span2" /></td>
		</tr>
		<tr>
			<td align="center">用户电话</td>
			<td><input  name="customerPhone" value="${sr.customerPhone }" type="text" placeholder="请输入用户电话" class="easyui-validatebox span2"/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td align="center">用户地址</td>
			<td colspan="3"><textarea name="customerAddress" placeholder="请输入用户地址" rows="1" cols="110">${sr.customerAddress }</textarea></td>
		</tr>
		<tr>
			<td align="center">购机日期</td>
			<td><input placeholder="选择购机日期" class="Wdate" name="buyDate" value="<fmt:formatDate value='${sr.buyDate}' pattern='yyyy-MM-dd'/>" readonly="readonly" type="text" onFocus="WdatePicker()"/></td>
			<td align="center">故障日期</td>
			<td><input placeholder="选择故障日期" class="Wdate" value="<fmt:formatDate value='${sr.faultDate}' pattern='yyyy-MM-dd'/>"  readonly="readonly" type="text" onFocus="WdatePicker()"/></td>
		</tr>
		<tr>
			<td align="center">退换机<font color="red">*</font></td>
			<td><input class="easyui-combobox" name="retreatReplacement" value="${sr.retreatReplacement }" data-options="url:'${ctx}/hxCode/getCombobox/thj',panelHeight:'auto',editable:false,required:true"/></td>
			<td align="center">退换模式<font color="red">*</font></td>
			<td><input class="easyui-combobox" name="rrMode" value="${sr.rrMode }" data-options="url:'${ctx}/hxCode/getCombobox/thms',panelHeight:'auto',editable:false,required:true"/></td>
		</tr>
		<tr>
			<td align="center">故障代码<font color="red">*</font></td>
			<td><input id="faultCode" name="faultCode" value="${sr.faultCode }" type="text" placeholder="请选择故障代码" class="easyui-validatebox span2" data-options="required:false" onkeyup="showFaultMenu()"/></td>
			<td align="center">故障原因<font color="red">*</font></td>
			<td><input  name="faultReason" value="${sr.faultReason }" type="text" placeholder="故障原因" class="easyui-validatebox span2" data-options="required:false"/></td>
		</tr>
		<tr>
			<td align="center">故障原因详细描述<font color="red">*</font></td>
			<td colspan="3"><textarea name="faultReasonDetail" placeholder="请输入故障原因详细描述" data-options="required:true" rows="1" cols="110">${sr.faultReasonDetail }</textarea></td>
		</tr>
		<tr>
			<td align="center">安装单位<font color="red">*</font></td>
			<td><input  name="installUnit" value="${sr.installUnit }" type="text" placeholder="请输入安装单位" class="easyui-validatebox span2" data-options="required:true"/></td>
			<td align="center">安装日期</td>
			<td><input  name="installDate" value="<fmt:formatDate value='${sr.installDate}' pattern='yyyy-MM-dd'/>" placeholder="选择安装日期" readonly="readonly" class="Wdate" type="text" onFocus="WdatePicker()"/></td>
		</tr>
		<tr>
			<td align="center">安装人员<font color="red">*</font></td>
			<td><input  name="intaller" value="${sr.intaller }" type="text" placeholder="请输入安装人员" class="easyui-validatebox span2" data-options="required:true"/></td>
			<td align="center">原提货单号<font color="red">*</font></td>
			<td><input name="deliveryOrderNum" value="${sr.deliveryOrderNum }" type="text" placeholder="请输入原提货单号" class="easyui-validatebox span2" data-options="required:true"/></td>
		</tr>
		<tr>
			<td align="center">原机型<font color="red">*</font></td>
			<td><input name="oldMachineType" value="${sr.oldMachineType }" class="easyui-combobox" data-options="valueField:'value',textField:'text',url:'${ctx}/hxCode/getModelCombobox',onSelect: function(rec){fillForm2(rec)},panelHeight:'auto'"/></td>
			<td align="center">国美代码(原)<font color="red">*</font></td>
			<td><input id="oldGomeCode" value="${sr.oldGomeCode }" class="easyui-combobox" name="oldGomeCode" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/gmdm',panelHeight:'auto', editable:false" /></td>
		</tr>
		<tr>
			<td align="center">品牌(原)</td>
			<td><input id="oldBrand" name="oldBrand" value="${sr.oldBrand }" class="easyui-combobox" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/pp',panelHeight:'auto', editable:false"/></td>
			<td class="olreshuiqi" align="center">原机器条码</td>
			<td class="olreshuiqi"><input id="oldMachineCode" value="${sr.oldMachineCode }" name="oldMachineCode" type="text" placeholder="请输入原机器条码" class="easyui-validatebox span2"/></td>
			<td class="olkongtiao" align="center">原内机条码1</td>
			<td class="olkongtiao"><input id="oldInnerCode1" value="${sr.oldInnerCode1 }" name="oldInnerCode1" type="text" placeholder="请输入原内机条码1" class="easyui-validatebox span2"/></td>
		</tr>
		<tr class="olkongtiao">
			<td align="center">原内机条码2</td>
			<td><input id="oldInnerCode2" name="oldInnerCode2" value="${sr.oldInnerCode2 }" type="text" placeholder="请输入原内机条码2" class="easyui-validatebox span2"/></td>
			<td align="center">原外机条码</td>
			<td><input id="oldOuterCode" name="oldOuterCode" type="text" value="${sr.oldOuterCode }" placeholder="请输入原外机条码" class="easyui-validatebox span2"/></td>
		</tr>
		<tr>
			<td align="center">现机型<font color="red">*</font></td>
			<td><input name="machineType" class="easyui-combobox" value="${sr.machineType }" data-options="valueField:'value',textField:'text',url:'${ctx}/hxCode/getModelCombobox',onSelect: function(rec){fillForm(rec)},panelHeight:'auto'"/></td>
			<td align="center">国美代码(新)<font color="red">*</font></td>
			<td><input id="gomeCode" class="easyui-combobox" name="gomeCode" value="${sr.gomeCode }" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/gmdm',panelHeight:'auto', editable:false" /></td>
		</tr>
		<tr>
			<td align="center">品牌(新)</td>
			<td><input id="brand" name="brand" class="easyui-combobox" value="${sr.brand }" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/pp',panelHeight:'auto', editable:false"/></td>
			<td class="reshuiqi" align="center">现机器条码</td>
			<td class="reshuiqi"><input id="machineCode" value="${sr.machineCode }" name="machineCode" type="text" placeholder="请输入原机器条码" class="easyui-validatebox span2"/></td>
			<td class="kongtiao" align="center">现内机条码1</td>
			<td class="kongtiao"><input id="innerCode1" value="${sr.innerCode1 }" name="innerCode1" type="text" placeholder="请输入原内机条码1" class="easyui-validatebox span2"/></td>
		</tr>
		<tr class="kongtiao">
			<td align="center">现内机条码2</td>
			<td><input id="innerCode2" name="innerCode2" value="${sr.innerCode2 }" type="text" placeholder="请输入原内机条码2" class="easyui-validatebox span2"/></td>
			<td align="center">现外机条码</td>
			<td><input id="outerCode" name="outerCode" value="${sr.outerCode }" type="text" placeholder="请输入原外机条码" class="easyui-validatebox span2"/></td>
		</tr>
		<tr>
			<td align="center">退换日期</td>
			<td><input  placeholder="选择退换日期" class="Wdate" name="rrDate" value="<fmt:formatDate value='${sr.rrDate}' pattern='yyyy-MM-dd'/>" readonly="readonly" type="text" onFocus="WdatePicker()"/></td>
			<td align="center">鉴定人<font color="red">*</font></td>
			<td><input name="appraiser" value="${sr.appraiser }" type="text" placeholder="请输入鉴定人" class="easyui-validatebox span2" data-options="required:true"/></td>
		</tr>
		<tr>
			<td align="center">备注</td>
			<td colspan="3"><textarea name="comment" placeholder="请输入备注" rows="1" cols="110">${sr.comment }</textarea></td>
		</tr>
	</table>
</form>
<div align="right" style="padding:5px;">
	<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g1',iconCls:'icon-save'" onclick="save();">保存</a>
	<a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',iconCls:'icon-back'" onclick="goBack();">返回</a>
</div>