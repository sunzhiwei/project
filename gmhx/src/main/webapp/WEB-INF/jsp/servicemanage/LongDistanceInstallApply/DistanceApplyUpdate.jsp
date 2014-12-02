<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<script type="text/javascript">
	$.extend($.fn.validatebox.defaults.rules, {
		 intOrFloat: {// 验证整数或小数
             validator: function (value) {
                 return /^\d+(\.\d+)?$/i.test(value);
             },
             message: '请输入数字，并确保格式正确'
		 }
	})
		
		
	$(function() {
		parent.$.messager.progress('close');
	});
	
	function save(){
		if($("#longDistanceForm").form('validate')){
			var hxServiceLongDistance = $.serializeObject($('#longDistanceForm'));
			$.ajax({
	            type:"POST",
	            url:"${ctx}/longDistanceInstallApply/updateLongDistance",
	            dataType:"json",
	            contentType:"application/json",
	            data:JSON.stringify(hxServiceLongDistance),
	            success:function(data){
	            	if(data.flag == "success"){
	            		$.messager.alert('', '保存成功!',null,function(){
	            			window.location.href="${ctx}/longDistanceInstallApply/distanceApplyView/"+ $("#applyId").val() ;
	            		});
	            	}else{
	            		$.messager.alert('','新增失败!');
	            	}
	            }
	        });
		}
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
		window.location.href="${ctx}/longDistanceInstallApply/longDistanceInstallApplyView";	
	}
	
	function fillForm(rec){
		$("#gomeCode").combobox('setValue',rec.gomeCode); 
		$("#brand").combobox('setValue',rec.brand); 
	}

</script>
<form id="longDistanceForm" method="post">
<div style="background-color:#95b8e7; text-align:left; color:#fff; font-weight:bold; border-bottom: 1px solid #000;">远程安装申请信息</div>
<input id="applyId" name="applyId" type="hidden" value="${distanceApply.applyId}">
<table border=1 style="cellSpacing:1;cellPadding:3;width:100%;background-color:#eff5ff;border-collapse:collapse">
	<tr>
		<td width="20%">申请单号<font color="red">*</font></td>
		<td width="30%"><label>${distanceApply.applyId}</label></td>
		<td width="20%">申请单位<font color="red">*</font></td>
		<td width="30%"><input class="easyui-combobox" name="applyUnit" value="${distanceApply.applyUnit}" data-options="url:'${ctx}/installReceipt/getWD',panelHeight:'100',required:true,editable:true"/></td>
	</tr>
	<tr>
		<td width="20%">里程数<font color="red">*</font></td>
		<td width="30%"><input name="mileage" type="text"  class="easyui-validatebox span2" data-options="required:true,validType:'intOrFloat'" value="${distanceApply.mileage }"></td>
		<td>其它费</td>
		<td width="30%"><input name="otherFee" type="text"  class="easyui-validatebox span2" data-options="validType:'intOrFloat'" value="${distanceApply.otherFee }"></td>
	</tr>
	<tr>
		<td>用户姓名<font color="red">*</font></td>
		<td width="30%"><input name="customerName" type="text"  class="easyui-validatebox span2" data-options="required:true" value="${distanceApply.customerName }"></td>
		<td>用户电话 <font color="red">*</font></td>
		<td><input name="customerPhone" type="text"  class="easyui-validatebox span2" data-options="required:true,validType:'number'" value="${distanceApply.customerPhone }"></td>
	</tr>
	<tr>
		<td>用户地址<font color="red">*</font></td>
		<td colspan="3"><textarea name="customerAddress" rows="2"  cols="80" class="easyui-validatebox span2" data-options="required:true">${distanceApply.customerAddress }</textarea></td>
	</tr>
	<tr>
		<td>机型<font color="red">*</font></td>
		<td><input name="machineType" class="easyui-combobox" data-options="url:'${ctx}/installReceipt/getModel',onSelect: function(rec){fillForm(rec)},panelHeight:'auto'" value="${distanceApply.machineType}"/></td>
		<td>国美代码</td>
		<td width="30%"><input id="gomeCode" class="easyui-combobox" name="gomeCode" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/gmdm?value=${distanceApply.gomeCode }',panelHeight:'auto', editable:false" /></td>
	</tr>
	<tr>
		<td>品牌</td>
		<td><input id="brand" name="brand" class="easyui-combobox" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/pp?value=${distanceApply.brand }',panelHeight:'auto', editable:false"/></td>
		<td>内机条码1</td>
		<td><input name="internalMachineCode1" type="text"   class="easyui-validatebox span2" value="${distanceApply.internalMachineCode1 }"></td>
	</tr>
	<tr>
		<td>内机条码2<font color="red">*</font></td>
		<td><input name="internalMachineCode2" type="text"  class="easyui-validatebox span2" value="${distanceApply.internalMachineCode2 }" data-options="required:true"></td>
		<td>外机条码</td>
		<td><input name="externalMachineCode" type="text"  class="easyui-validatebox span2" value="${distanceApply.externalMachineCode }"></td>
	</tr>
	<tr>
		<td>购机日期<font color="red">*</font></td>
		<td><input id="buyDate" name="buyDate" type="text" data-options="required:true" readonly="readonly" value="<fmt:formatDate value='${distanceApply.buyDate }' pattern='yyyy-MM-dd'/>" class="easyui-validatebox span2">
			<img onclick="WdatePicker({el:'buyDate'})" src="${ctx}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
		</td>
		<td>安装工</td>
		<td><input name="installMan" type="text"  class="easyui-validatebox span2" value="${distanceApply.installMan }"></td>
	</tr>
	<tr>
		<td>安装日期</td>
		<td><input id="installDate" name="installDate" type="text" readonly="readonly" value="<fmt:formatDate value='${distanceApply.installDate }' pattern='yyyy-MM-dd'/>" class="easyui-validatebox span2">
			<img onclick="WdatePicker({el:'installDate'})" src="${ctx}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
		</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td>备注</td>
		<td colspan="3"><textarea name="comment" rows="2"  cols="80" class="easyui-validatebox span2">${distanceApply.comment }</textarea></td>
	</tr>
</table> 
</form>
<div style="text-align:right;padding:5px">
    	<a href="#" class="easyui-linkbutton"  onclick="save();">保存</a>
    	<a href="#" class="easyui-linkbutton"  onclick="goBack();">返回</a>
</div>
