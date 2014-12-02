<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<script type="text/javascript">
	$(function(){
		$('#projectGrid').datagrid({
			url : "${ctx}/installProject/getProjects/${map.service_id}",
			title : "工程机安装信息",
			striped : true,
			collapsible : true,
			autoRowHeight : false,
			remoteSort : false,
			rownumbers : true,
			fitColumns : true,
			columns : [ [ {
				width : 10 , checkbox : true
			}, {field : 'machineType',title : '＊机型',align:'center',editor:'text',width : 30,requre:true,
			}, {field : 'internalMachineCode1',title : '＊内机条码1',align:'center',editor:'text',width : 30
			}, {field : 'internalMachineCode2',title : '内机条码2',align:'center',editor:'text',width : 30
			}, {field : 'externalMachineCode',title : '＊外机条码',align:'center',editor:'text',width : 30
			}, {field : 'installCardNum',title : '安装卡号',align:'center',editor:'text',width : 30
			}, {field : 'installDate',title : '＊安装日期',align:'center',width : 30,
				editor: {
					type : 'datebox',
					options : {
						editable:false 
					}
				} 
			}, {field : 'installer',title : '＊安装工',align:'center',editor:'text',width : 30
			}, {field : 'isDoubleInstall',title : '＊是否二次安装',align:'center',width : 30,
				editor: {
					type : 'combobox',
					options : {
						editable:true ,
						valueField: 'value',
						textField: 'text',
						panelHeight:'auto',
						url:'${ctx}/hxCode/getCombobox/sf'
					}
				},
				formatter : function(value, row, index) {
					if(value){
						return 'true';
			  		}else{
			  			return 'false';
			  		}
			  	}
			}, {field : 'warrantyPolicy',title : '＊保修政策',align:'center',editor:'text',width : 30,
				editor: {
					type : 'combobox',
					options : {
						editable:false ,
						valueField: 'value',
						textField: 'text',
						panelHeight:'auto',
						url:'${ctx}/hxCode/getCombobox/bxzc'
					}
				},
				formatter : function(value, row, index) {
					if(value == "01"){
						return "3";
					}else if(value == "02"){
						return "2";
					}else if(value == "03"){
						return "1";
					}else if(value == "04"){
						return "4";
					}else if(value == "05"){
						return "5";
					}else if(value == "06"){
						return "6";
					}
			  	}
			}, {field : 'delayFee',title : '延管费',align:'center',editor:'text',width : 30
			}, {field : 'otherFee',title : '其它费',align:'center',editor:'text',width : 30
			}, {field : 'commentP',title : '备注',align:'center',editor:'text',width : 30
			} ] ],
			toolbar : '#toolbarForProject',
			onLoadSuccess : function(data){
				indexProject = data.total;
				for(var i = 0; i < indexProject; i++){
					$('#projectGrid').datagrid('beginEdit', i);
				}
			}
		});
		$("div.easyui-layout").css("height", "auto");
	});
	

	var indexProject = 0;
	
	function addForProject(){
		var count = $("#numberForProject").val();
		for(var i = 0; i < count; i++){
			$('#projectGrid').datagrid('appendRow',{});
			$('#projectGrid').datagrid('beginEdit', indexProject);
			indexProject ++;
		}
	}
	
	function deleteForProject(){
		var checkedData = $('#projectGrid').datagrid('getRowNum');
		indexProject = indexProject - checkedData.length;
		$.each(checkedData, function(){
			$('#projectGrid').datagrid('deleteRow', checkedData.pop() - 1);
		});
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
	
	function validate(){
		var flag = true;
		/* if($("input[name=customerName]").val() == ""){alert("请输入客户姓名！");return false;};
		if($("input[name=province]").val() == ""){alert("请输入客户省份！");return false;};
		if($("input[name=address]").val() == ""){alert("请输入客户联系地址！");return false;};
		if($("input[name=machineType]").val() == ""){alert("请输入产品机型！");return false;};
		if($("input[name=internalMachineCode1]").val() == ""){alert("请输入产品内机条码1！");return false;};
		if($("input[name=externalMachineCode]").val() == ""){alert("请输入产品外机条码！");return false;};
		if($("input[name=deliveryOrderNum]").val() == ""){alert("请输入产品提货单号！");return false;};
		if($("input[name=invoiceNum]").val() == ""){alert("请输入产品发票号码！");return false;};
		if($("input[name=buyer]").val() == ""){alert("请输入产品购买者姓名！");return false;};
		if($("input[name=buyDate]").val() == ""){alert("请输入产品购机日期！");return false;};
		if($("input[name=installDate]").val() == ""){alert("请输入产品安装日期！");return false;};
		if($("input[name=installUnit]").val() == ""){alert("请输入产品 安装单位！");return false;};
		if($("input[name=saleMarket]").val() == ""){alert("请输入产品 销售分部！");return false;};
		if($("input[name=saleMarket]").val() == ""){alert("请输入产品销售门店！");return false;};
		if($("input[name=installProvince]").val() == ""){alert("请输入产品安装省份！");return false;};
		if($("input[name=installDetailAddress]").val() == ""){alert("请输入产品安装详细地址！");return false;};
		if($("input[name=informRepaireDate]").val() == ""){alert("请输入维修单报修日期！");return false;};
		if($("input[name=repairer]").val() == ""){alert("请输入维修单维修工！");return false;};
		if($("input[name=repairDate]").val() == ""){alert("请输入维修单维修日期！");return false;}; */
		return flag;
	}
	
	function update(){
		if($("#formCustomer").form('validate')&&
			$("#formProduct").form('validate')&&
			$("#formTicket").form('validate')){
			$('#projectGrid').datagrid('acceptChanges');
			var projects = $("#projectGrid").datagrid('getRows');
			for(var i = projects.length - 1; i >= 0; i--){
				if($.trim(projects[i].machineType) == ""){
					if($.trim(projects[i].machineType) == ""){
						projects.splice(i, 1);
					}else if($.trim(projects[i].machineType) == ""){
						$.messager.alert('','机型必须输入!');
						$('#projectGrid').datagrid("reload");
						return;
					}else if($.trim(projects[i].internalMachineCode1) == ""){
						$.messager.alert('','内机条码1必须输入!');
						$('#projectGrid').datagrid("reload");
						return;
					}else if($.trim(projects[i].externalMachineCode) == ""){
						$.messager.alert('','外机条码必须输入!');
						$('#projectGrid').datagrid("reload");
						return;
					}else if($.trim(projects[i].installDate) == ""){
						$.messager.alert('','安装日期必须输入!');
						$('#projectGrid').datagrid("reload");
						return;
					}else if($.trim(projects[i].installer) == ""){
						$.messager.alert('','安装工必须输入!');
						$('#projectGrid').datagrid("reload");
						return;
					}else if($.trim(projects[i].isDoubleInstall) == ""){
						$.messager.alert('','是否二次安装必须输入!');
						$('#projectGrid').datagrid("reload");
						return;
					}else if($.trim(projects[i].warrantyPolicy) == ""){
						$.messager.alert('','保修政策必须输入!');
						$('#projectGrid').datagrid("reload");
						return;
					}
				}
			}
			if(projects.length==0){
				$.messager.alert('','请至少输入一条工程机!');
			}else{
				var serviceTicketVO = {};
				serviceTicketVO.serviceCustomer =  $.serializeObject($('#formCustomer'));
				serviceTicketVO.serviceProduct = $.serializeObject($('#formProduct'));
				serviceTicketVO.serviceTicket = $.serializeObject($('#formTicket'));
				serviceTicketVO.serviceProjects = projects;
				$.ajax({
		            type:"POST", 
		            url:"${ctx}/installProject/installProjectUpdate", 
		            dataType:"json",
		            contentType:"application/json",
		            data:JSON.stringify(serviceTicketVO), 
		            success:function(data){
		            	if(data.flag == "success"){
		            		$.messager.alert('', '保存成功!',null,function(){
		            			//window.location.href="${ctx}/installProject/installProjectShow/"+data.serviceId;
		            		});
		            	}else{
		            		$.messager.alert('','新增失败!');
		            	}
		            } 
		        });
			}
		}
	}
	
	function goBack(){
		window.location.href="${ctx}/installProject/installProjectView";	
	}
</script>
<form id="formCustomer" method="post">
	<div style="background-color:#95b8e7; text-align:left; color:#fff; font-weight:bold; border-bottom: 1px solid #000;">客户信息</div>
	<input name="customerId" type="hidden" value="${map.customer_id }"/>
	 <table border=1 style="cellSpacing:1;cellPadding:3;width:100%;background-color:#eff5ff;border-collapse:collapse">
		<tr>
			<td width="20%">客户姓名<font color="red">*</font></td>
			<td width="30%"><input name="customerName" type="text" class="easyui-validatebox span2" value="${map.customer_name}" data-options="required:true"></td>
			<td width="20%">客户类别<font color="red">*</font></td>
			<td width="30%">
				<input class="easyui-combobox" name="customerType" data-options="url:'${ctx}/hxCode/getCombobox/khlb?value=${map.customer_type}',panelHeight:'auto',editable:false,required:true"/>
			</td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<input name="customerSex" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/xb?value=${map.customer_sex}',panelHeight:'auto',editable:false"/>
			</td>
			<td>会员卡号</td>
			<td><input name="memberNum"  type="text"  class="easyui-validatebox span2" value="${map.member_num }"></td>
		</tr>
		<tr>
			<td>省份<font color="red">*</font></td>
			<td><input name="province" type="text" value="${map.province}" class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/csf',panelHeight:'100',editable:true,required:true"></td>
			<td>区号</td>
			<td><input name="areaCode" type="text"  class="easyui-validatebox span2" value="${map.area_code }"></td>
		</tr>
		<tr>
			<td>手机</td>
			<td><input name="phone" type="text"   class="easyui-validatebox span2" value="${map.phone }"></td>
			<td>固定电话</td>
			<td><input name="telephone" type="text"   class="easyui-validatebox span2" value="${map.telephone }"></td>
		</tr>
		<tr>
			<td>E-MAIL</td>
			<td><input name="email" type="text" data-options="validType:'email'"  class="easyui-validatebox span2" value="${map.e_mail }"></td>
			<td>邮编</td>
			<td><input name="postcode" type="text"   class="easyui-validatebox span2" value="${map.postcode }"></td>
		</tr>
		<tr>
			<td>联系地址<font color="red">*</font></td>
			<td colspan="3"><textarea name="address" rows="2"  cols="80" class="easyui-validatebox span2" data-options="required:true">${map.address }</textarea></td>
		</tr>
		<tr>
			<td>备注</td>
			<td colspan="3"><textarea name="note"  rows="2" cols="80" class="easyui-validatebox span2" >${map.note }</textarea></td>
		</tr>
	</table> 
</form>
<form id="formProduct" method="post">
	<div style="background-color:#95b8e7; text-align:left; color:#fff; font-weight:bold; border-bottom: 1px solid #000;">产品信息</div>
	<input name="productId" type="hidden" value="${map.product_id }"/>
	<input name="customerId" type="hidden" value="${map.customer_id}"/>
	<table border=1 style="cellSpacing:1;cellPadding:3;width:100%;background-color:#eff5ff;border-collapse:collapse">
		<tr>
			<td>购机日期<font color="red">*</font></td>
			<td>
				<input id="buyDate" name="buyDate" type="text" data-options="required:true" readonly="readonly"  value="<fmt:formatDate value='${map.buy_date}' pattern='yyyy-MM-dd' />" class="easyui-validatebox span2">
				<img onclick="WdatePicker({el:'buyDate'})" src="${ctx}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
			</td>
			<td>安装单位<font color="red">*</font></td>
			<td><input name="installUnit" type="text" value="${map.install_unit}" class="easyui-combobox" data-options="url:'${ctx}/installReceipt/getServices',required:true"></td>
		</tr>
		<tr>
			<td>销售门店<font color="red">*</font></td>
			<td><input name="saleMarket" type="text" value='${map.sale_market}' class="easyui-combobox" data-options="url:'${ctx}/installReceipt/getStore',required:true"></td>
			<td>安装省份<font color="red">*</font> </td>
			<td><input name="installProvince" type="text" value='${map.province}' class="easyui-combobox" data-options="url:'${ctx}/hxCode/getCombobox/csf',panelHeight:'100',editable:true,required:true"></td>
		</tr>
		<tr>
			<td>安装详细地址<font color="red">*</font></td>
			<td colspan="3"><textarea name="installDetailAddress" data-options="required:true" rows="2" cols="80">${map.install_detail_address }</textarea></td>
		</tr>
		<tr>
			<td>工程名称<font color="red">*</font></td>
			<td><input name="projectName" type="text" data-options="required:true" value="${map.project_name }" class="easyui-validatebox span2"></td>
			<td>合同编码<font color="red">*</font></td>
			<td><input name="bargainCode" type="text" data-options="required:true" value="${map.bargain_code }" class="easyui-validatebox span2"></td>
		</tr>
	</table>
</form>
<form id="formTicket" method="post">
	<div style="background-color:#95b8e7; text-align:left; color:#fff; font-weight:bold; border-bottom: 1px solid #000;">客户评价</div>
	<input name="serviceId" type="hidden" value="${map.service_id }"/>
	<table border=1 style="cellSpacing:1;cellPadding:3;width:100%;background-color:#eff5ff;border-collapse:collapse">
		<tr>
			<td>产品外观满意度<font color="red">*</font></td>
			<td>
				<input id="productExteriorSatisfaction" name="productExteriorSatisfaction" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/myd?value=${map.product_exterior_satisfaction }',panelHeight:'auto',editable:false,required:true">
			</td>
			<td>产品外观重要性<font color="red">*</font></td>
			<td><input id="productExteriorSignificance" name="productExteriorSignificance" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/zyx?value=${map.product_exterior_significance }',panelHeight:'auto',editable:false,required:true"></td>
		</tr>
		<tr>
			<td>产品质量满意度<font color="red">*</font></td>
			<td>
				<input id="qualitySatisfaction" name="qualitySatisfaction" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/myd?value=${map.quality_satisfaction }',panelHeight:'auto',editable:false,required:true">
			</td>
			<td>产品质量重要性<font color="red">*</font></td>
			<td>
				<input id="qualitySignificance" name="qualitySignificance" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/zyx?value=${map.quality_significance }',panelHeight:'auto',editable:false,required:true">
			</td>
		</tr>
		<tr>
			<td>价格满意度<font color="red">*</font></td>
			<td><input id="priceSatisfaction" name="priceSatisfaction" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/myd?value=${map.price_satisfaction }',panelHeight:'auto',editable:false,required:true"></td>
			<td>价格重要性<font color="red">*</font></td>
			<td><input id="priceSignificance" name="priceSignificance" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/zyx?value=${map.price_significance }',panelHeight:'auto',editable:false,required:true"></td>
		</tr>
		<tr>
			<td>服务满意度<font color="red">*</font></td>
			<td><input id="serviceSatisfaction" name="serviceSatisfaction" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/myd?value=${map.service_satisfaction }',panelHeight:'auto',editable:false,required:true"></td>
			<td>服务重要性<font color="red">*</font></td>
			<td><input id="serviceSignificance" name="serviceSignificance" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/zyx?value=${map.service_significance }',panelHeight:'auto',editable:false,required:true"></td>
		</tr>
		<tr>
			<td>生理感受满意度<font color="red">*</font></td>
			<td><input id="physiologySatisfaction" name="physiologySatisfaction" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/myd?value=${map.physiology_satisfaction }',panelHeight:'auto',editable:false,required:true"></td>
			<td>生理感受重要性<font color="red">*</font></td>
			<td><input id="physiologySignificance" name="physiologySignificance" class="easyui-combobox"  data-options="url:'${ctx}/hxCode/getCombobox/zyx?value=${map.physiology_significance }',panelHeight:'auto',editable:false,required:true"></td>
		</tr>
		<tr>
			<td>备注</td>
			<td colspan="3"><textarea id="commentS" rows="2" cols="80">${map.comment_s}</textarea></td>
		</tr>
	</table>
	<br/>
	<div style="padding:0 15px 0 0">
		<div class="easyui-layout" data-options="fit : true,border : false">
			<table id="projectGrid"></table>
		</div>
	</div>
</form>
<div id="toolbarForProject" style="display: none;">
	<input type="text" id="numberForProject" style="width: 20px;" value="1">
	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addForProject();">增加</a>
	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteForProject();">删除</a>
</div>
<div style="text-align:right;padding:5px">
   	<a href="#" class="easyui-linkbutton"  onclick="update();">保存</a>
   	<a href="#" class="easyui-linkbutton"  onclick="goBack();">返回</a>
</div>