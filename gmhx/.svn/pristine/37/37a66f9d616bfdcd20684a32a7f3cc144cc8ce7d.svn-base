<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<script type="text/javascript">
	
	$(function() {
		parent.$.messager.progress('close');
	});
	
	function save(){
		$.post("${ctx}/installReceipt/updateInstallReceipt", 
				$("#form").serialize(),
				function(msg){
					if($.parseJSON(msg).flag == "success"){
						$.messager.alert('','修改成功!',null,function(){
							window.location.href="${ctx}/installReceipt/installReceiptView/${map.service_id}";
						});
					}else{
						$.messager.alert('','修改失败!');
					}
				}
			); 
	}
	
	function goBack(){
		window.location.href="${ctx}/installReceipt/installReceiptView";	
	}
	
	function fillForm(rec){
		$("#gomeCode").combobox('setValue',rec.gomeCode); 
		$("#brand").combobox('setValue',rec.brand); 
	}
	
	function fillCombo(rec){
	    $("#saleMarket").combobox('reload','${ctx}/installReceipt/getStore?center=' + rec.value);
	    $("#saleMarket").combobox('clear');
	}

</script>
<form id="form" method="post">
<input name="serviceCustomer.customerId" type="hidden" value="${map.customer_id }"/>
<input name="serviceProduct.productId" type="hidden" value="${map.product_id }"/>
<input name="serviceProduct.customerId" type="hidden" value="${map.customer_id }"/>
<input name="serviceTicket.serviceId" type="hidden" value="${map.service_id }"/>
<input name="serviceTicket.productId" type="hidden" value="${map.product_id }"/>
<input name="serviceTicket.customerId" type="hidden" value="${map.customer_id }"/>
<div style="background-color:#95b8e7; text-align:left; color:#fff; font-weight:bold; border-bottom: 1px solid #000;">客户信息</div>
<table border=1 style="cellSpacing:1;cellPadding:3;width:100%;background-color:#eff5ff;border-collapse:collapse">
	<tr>
		<td width="20%">客户姓名<font color="red">*</font></td>
		<td width="30%"><input name="serviceCustomer.customerName" type="text"   class="easyui-validatebox span2" value="${map.customer_name}" data-options="required:true"></td>
		<td width="20%">客户类别<font color="red">*</font></td>
		<td width="30%">
			<input class="easyui-combobox" name="serviceCustomer.customerType" data-options="url:'${ctx}/hxCode/getCombobox/khlb?value=${map.customer_type}',panelHeight:'auto', editable:false"/>
		</td>
	</tr>
	<tr>
		<td>性别</td>
		<td>
			<input name="serviceCustomer.customerSex" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/xb?value=${map.customer_sex}',panelHeight:'auto', editable:false"/>
		</td>
		<td>会员卡号</td>
		<td><input name="serviceCustomer.memberNum"  type="text"  class="easyui-validatebox span2" value="${map.member_num }"></td>
	</tr>
	<tr>
		<td>省份<font color="red">*</font></td>
		<td><input name="serviceCustomer.province" type="text"  class="easyui-validatebox span2" value="${map.province }" data-options="required:true"></td>
		<td>区号</td>
		<td><input name="serviceCustomer.areaCode" type="text"  class="easyui-validatebox span2" value="${map.area_code }"></td>
	</tr>
	<tr>
		<td>手机</td>
		<td><input name="serviceCustomer.phone" type="text"   class="easyui-validatebox span2" value="${map.phone }"></td>
		<td>固定电话</td>
		<td><input name="serviceCustomer.telephone" type="text"   class="easyui-validatebox span2" value="${map.telephone }"></td>
	</tr>
	<tr>
		<td>E-MAIL</td>
		<td><input name="serviceCustomer.eMail" type="text" data-options="validType:'email'"  class="easyui-validatebox span2" value="${map.e_mail }"></td>
		<td>邮编</td>
		<td><input name="serviceCustomer.postcode" type="text"   class="easyui-validatebox span2" value="${map.postcode }"></td>
	</tr>
	<tr>
		<td>联系地址<font color="red">*</font></td>
		<td colspan="3"><textarea name="serviceCustomer.address" rows="2"  cols="80" class="easyui-validatebox span2" data-options="required:true">${map.address }</textarea></td>
	</tr>
	<tr>
		<td>备注</td>
		<td colspan="3"><textarea name="serviceCustomer.note"  rows="2" cols="80" class="easyui-validatebox span2" >${map.note }</textarea></td>
	</tr>
</table> 
<div style="background-color:#95b8e7; text-align:left; color:#fff; font-weight:bold; border-bottom: 1px solid #000;">产品信息</div>
<table border=1 style="cellSpacing:1;cellPadding:3;width:100%;background-color:#eff5ff;border-collapse:collapse">
	<tr>
		<td width="20%">机型<font color="red">*</font></td>
		<td width="30%"><input name="machineType" class="easyui-combobox" data-options="valueField:'value',textField:'text',url:'${ctx}/installReceipt/getModel',onSelect: function(rec){fillForm(rec)},panelHeight:'auto'"/></td>
		<td width="20%">国美代码</td>
		<td width="30%"><input id="gomeCode" class="easyui-combobox" name="gomeCode" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/gmdm',panelHeight:'auto', editable:false" /></td>
	</tr>
	<tr>
		<td>品牌</td>
		<td><input id="brand" name="brand" class="easyui-combobox" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/pp',panelHeight:'auto', editable:false"/></td>
		<td>内机条码1<font color="red">*</font></td>
		<td><input name="serviceProduct.internalMachineCode1" type="text" data-options="required:true" value="${map.internal_machine_code1 }" class="easyui-validatebox span2"></td>
	</tr>
	<tr>
		<td>内机条码2</td>
		<td><input name="serviceProduct.internalMachineCode2" type="text" value="${map.internal_machine_code2 }"  class="easyui-validatebox span2"></td>
		<td>外机条码<font color="red">*</font></td>
		<td><input name="serviceProduct.externalMachineCode" type="text" value="${map.external_machine_code }" data-options="required:true" class="easyui-validatebox span2"></td>
	</tr>
	<tr>
		<td>提货单号<font color="red">*</font></td>
		<td><input name="serviceProduct.deliveryOrderNum" type="text" data-options="required:true" value="${map.delivery_order_num }" class="easyui-validatebox span2"></td>
		<td>安装卡号</td>
		<td><input name="serviceProduct.installCardNum" type="text" value="${map.install_card_num }" class="easyui-numberbox" class="easyui-validatebox span2"></td>
	</tr>
	<tr>
		<td>单据序号</td>
		<td><input name="serviceProduct.ticketNum" type="text" value="${map.ticket_num }" class="easyui-numberbox" class="easyui-validatebox span2"></td>
		<td>发票号码<font color="red">*</font></td>
		<td><input name="serviceProduct.invoiceNum" type="text" data-options="required:true" value="${map.invoice_num }" class="easyui-validatebox span2"></td>
	</tr>
	<tr>
		<td>购买者姓名<font color="red">*</font></td>
		<td><input name="serviceProduct.buyer" type="text" data-options="required:true" value="${map.buyer }" class="easyui-validatebox span2"></td>
		<td>购机日期<font color="red">*</font></td>
		<td>
			<input id="buyDate" name="serviceProduct.buyDate" type="text" readonly="readonly"  data-options="required:true" value="<fmt:formatDate value='${map.buy_date }' pattern='yyyy-MM-dd'/>" class="easyui-validatebox span2">
			<img onclick="WdatePicker({el:'buyDate'})" src="${ctx}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
		</td>
	</tr>
	<tr>
		<td>安装日期<font color="red">*</font></td>
		<td>
			<input id="installDate" name="serviceProduct.installDate" type="text" readonly="readonly"  data-options="required:true" value="<fmt:formatDate value='${map.install_date }' pattern='yyyy-MM-dd'/>" class="easyui-validatebox span2">
			<img onclick="WdatePicker({el:'installDate'})" src="${ctx}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
		</td>
		<td>安装单位<font color="red">*</font></td>
		<td><input name="serviceProduct.installUnit" type="text" class="easyui-combobox" data-options="url:'${ctx}/installReceipt/getServices',required:true" value="${map.install_unit }"></td>
	</tr>
	<tr>
		<td>销售分部<font color="red">*</font></td>
		<td><input name="serviceProduct.saleCenter" type="text" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/jg',required:true,onSelect:function(rec){fillCombo(rec)}" value="${map.sale_center }"></td>
		<td>销售门店<font color="red">*</font></td>
		<td><input id="saleMarket" name="serviceProduct.saleMarket" type="text" class="easyui-combobox" data-options="required:true" value="${map.sale_market }"></td>
	</tr>
	<tr>
		<td>销售价格</td>
		<td><input name="serviceProduct.salePrice" type="text" value="${map.sale_price }"  class="easyui-validatebox span2"></td>
		<td>安装省份<font color="red">*</font> </td>
		<td><input name="serviceProduct.installProvince" type="text" data-options="required:true" value="${map.install_province }" class="easyui-validatebox span2"></td>
	</tr>
	<tr>
		<td>安装详细地址<font color="red">*</font></td>
		<td colspan="3"><textarea name="serviceProduct.installDetailAddress" data-options="required:true" rows="2" cols="80">${map.install_detail_address }</textarea></td>
	</tr>
	<tr>
		<td>备注</td>
		<td colspan="3"><textarea name="serviceProduct.productNote" rows="2" cols="80">${map.product_note }</textarea></td>
	</tr>
</table> 
<div style="background-color:#95b8e7; text-align:left; color:#fff; font-weight:bold; border-bottom: 1px solid #000;">安装单信息</div>
<table border=1 style="cellSpacing:1;cellPadding:3;width:100%;background-color:#eff5ff;border-collapse:collapse">
	<tr>
		<td width="20%">远程申请单号</td>
		<td width="30%"><input name="serviceTicket.distanceApplyNum" type="text" value="${map.distance_apply_num }"  class="easyui-validatebox span2"></td>
		<td width="20%">服务证号</td>
		<td width="30%"><input name="serviceTicket.serviceCardNum" type="text" value="${map.service_card_num }"  class="easyui-validatebox span2"></td>
	</tr>
	<tr>
		<td>安装工<font color="red">*</font></td>
		<td><input name="serviceTicket.serviceMan" type="text"  data-options="required:true" value="${map.service_man }" class="easyui-validatebox span2"></td>
		<td>产品外观满意度<font color="red">*</font></td>
		<td>
			<input name="serviceTicket.productExteriorSatisfaction" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/myd?value=${map.product_exterior_satisfaction}',panelHeight:'auto', editable:false"/>
		</td>
	</tr>
	<tr>
		<td>产品外观重要性<font color="red">*</font></td>
		<td>
			<input name="serviceTicket.productExteriorSignificance" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/zyx?value=${map.product_exterior_significance}',panelHeight:'auto', editable:false"/>
		</td>
		<td>价格满意度<font color="red">*</font></td>
		<td>
			<input name="serviceTicket.priceSatisfaction" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/myd?value=${map.price_satisfaction}',panelHeight:'auto', editable:false"/> 
		</td>
	</tr>
	<tr>
		<td>价格重要性<font color="red">*</font></td>
		<td>
			<input name="serviceTicket.priceSignificance" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/zyx?value=${map.price_significance}',panelHeight:'auto', editable:false"/>
		</td>
		<td>服务满意度<font color="red">*</font></td>
		<td>
			<input name="serviceTicket.serviceSatisfaction" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/myd?value=${map.service_satisfaction}',panelHeight:'auto', editable:false"/>
		</td>
	</tr>
	<tr>
		<td>服务重要性<font color="red">*</font></td>
		<td>
			<input name="serviceTicket.serviceSignificance" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/zyx?value=${map.service_significance}',panelHeight:'auto', editable:false"/>	
		</td>
		<td>生理感受满意度<font color="red">*</font></td>
		<td>
			<input name="serviceTicket.physiologySatisfaction" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/myd?value=${map.physiology_satisfaction}',panelHeight:'auto', editable:false"/>
		</td>
	</tr>
	<tr>
		<td>生理感受重要性<font color="red">*</font></td>
		<td>
			<input name="serviceTicket.physiologySignificance" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/zyx?value=${map.physiology_significance}',panelHeight:'auto', editable:false"/>	
		</td>
		<td>是否二次安装<font color="red">*</font></td>
		<td>
			<input name="serviceTicket.isDoubleInstall" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/sf?value=${map.is_double_install}',panelHeight:'auto', editable:false"/>
		</td>
	</tr>
	<tr>
		<td>保修政策<font color="red">*</font></td>
		<td colspan="3">
			<input name="serviceTicket.warrantyPolicy" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/bxzc?value=${map.warranty_policy}',panelHeight:'auto', editable:false"/>
		</td>
	</tr>
	<tr>
		<td>备注</td>
		<td colspan="3"><textarea name="serviceTicket.commentS" rows="2" cols="80">${map.comment_s }</textarea></td>
	</tr>
</table> 
</form>
<div style="text-align:right;padding:5px">
    	<a href="#" class="easyui-linkbutton"  onclick="save();">保存</a>
    	<a href="#" class="easyui-linkbutton"  onclick="goBack();">返回</a>
</div>
