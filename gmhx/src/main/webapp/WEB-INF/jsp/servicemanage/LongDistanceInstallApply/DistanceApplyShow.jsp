<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<script type="text/javascript">

	$(function(){
		$("#button1").hide();
		$("#button2").hide();
		if("${distanceApply.status}"=="S1"){
			$("#button1").show();
		}else{
			$("#button2").show();
		}
	})

	function update(){
		window.location.href="${ctx}/longDistanceInstallApply/updateDistanceApplyView/${distanceApply.applyId}";
	}
	
	function send(){
		$.post("${ctx}/longDistanceInstallApply/sendDistanceApply",{
			applyId : "${distanceApply.applyId}",
		},function(msg){
			if(msg == "success"){
				parent.$.messager.alert('','报批成功!');
				window.location.href = "${ctx}/longDistanceInstallApply/distanceApplyView/${distanceApply.applyId}";
			}else{
				parent.$.messager.alert('','报批失败!');
			}
		});
	}
	
	function goBack(){
		window.location.href="${ctx}/longDistanceInstallApply/longDistanceInstallApplyView";
	}
</script>
<div style="background-color:#95b8e7; text-align:left; color:#fff; font-weight:bold; border-bottom: 1px solid #000;">远程安装申请详细信息</div>
<input id="service_id" type="hidden" value="${map.service_id }"/>
<table border=1 style="cellSpacing:1;cellPadding:3;width:100%;background-color:#eff5ff;border-collapse:collapse">
	<tr>
		<td width="25%" align="center">申请单号</td><td width="25%" ><label>${distanceApply.applyId}</label></td>
		<td width="25%" align="center">申请单位</td>
		<td width="25%" >
			<input disabled="disabled" class="easyui-combobox" value="${distanceApply.applyUnit}" data-options="url:'${ctx}/hxCode/getWebsiteCombobox',panelHeight:'100',required:true,editable:true"/>
		</td>
	</tr>
	<tr>
		<td width="25%" align="center">里程数</td><td width="25%" ><label>${distanceApply.mileage}</label></td>
		<td width="25%" align="center">其它费</td><td width="25%" ><label>${distanceApply.otherFee}</label></td>
	</tr>
	<tr>
		<td width="25%" align="center">用户姓名</td><td width="25%" ><label>${distanceApply.customerName}</label></td>
		<td width="25%" align="center">用户电话</td><td width="25%" ><label>${distanceApply.customerPhone}</label></td>
	</tr>
	<tr>
		<td width="25%" align="center">用户地址</td><td width="25%" ><label>${distanceApply.customerAddress}</label></td>
		<td width="25%" align="center"></td><td width="25%" ><label></label></td>
	</tr>
	<tr>
		<td width="25%" align="center">机型</td><td width="25%" ><label>${distanceApply.machineType}</label></td>
		<td width="25%" align="center">国美代码</td>
		<td width="25%" >
			<input class="easyui-combobox" value="${distanceApply.gomeCode}" disabled="disabled" data-options="url:'${ctx}/hxCode/getCombobox/gmdm',panelHeight:'auto', editable:false" />
		</td>
	</tr>
	<tr>
		<td width="25%" align="center">品牌</td><td width="25%" ><label>${distanceApply.brand}</label></td>
		<td width="25%" align="center">机器条码</td><td width="25%" ><label>${distanceApply.machineCode}</label></td>
	</tr>
	<tr>
		<td width="25%" align="center">购机日期</td><td width="25%" ><label><fmt:formatDate value='${distanceApply.buyDate}' pattern='yyyy-MM-dd'/></label></td>
		<td width="25%" align="center">安装工</td><td width="25%" ><label>${distanceApply.installMan}</label></td>
	</tr>
	<tr>
		<td width="25%" align="center">安装日期</td><td width="25%" ><label><fmt:formatDate value='${distanceApply.installDate}' pattern='yyyy-MM-dd'/></label></td>
		<td width="25%" align="center"></td><td width="25%" ><label></label></td>
	</tr>
	<tr>
		<td width="25%" align="center">状态</td><td width="25%" ><label>${distanceApply.status}</label></td>
		<td width="25%" align="center">分部是否同意</td><td width="25%" ><label>${distanceApply.isCenterCheckAgree}</label></td>
	</tr>
	<tr>
		<td width="25%" align="center">分部意见</td><td width="25%" ><label>${distanceApply.centerCheckComment}</label></td>
		<td width="25%" align="center"></td><td width="25%" ><label></label></td>
	</tr>
	<tr>
		<td width="25%" align="center">分部审批人</td><td width="25%" ><label>${distanceApply.centerCheckMan}</label></td>
		<td width="25%" align="center">分部审批日期</td><td width="25%" ><label><fmt:formatDate value='${distanceApply.centerCheckDate}' pattern='yyyy-MM-dd'/></label></td>
	</tr>
	<tr>
		<td width="25%" align="center">总部是否同意</td><td width="25%" ><label>${distanceApply.isHeadquartersCheckAgree}</label></td>
		<td width="25%" align="center"></td><td width="25%" ><label></label></td>
	</tr>
	<tr>
		<td width="25%" align="center">总部意见</td><td width="25%" ><label>${distanceApply.headquartersCheckComment}</label></td>
		<td width="25%" align="center"></td><td width="25%" ><label></label></td>
	</tr>
	<tr>
		<td width="25%" align="center">总部审批人</td><td width="25%" ><label>${distanceApply.headquartersCheckMan}</label></td>
		<td width="25%" align="center">总部审批日期</td><td width="25%" ><label><fmt:formatDate value='${distanceApply.headquartersCheckDate}' pattern='yyyy-MM-dd'/></label></td>
	</tr>
	<tr>
		<td width="25%" align="center">备注</td><td width="25%" ><label>${distanceApply.comment}</label></td>
		<td width="25%" align="center"></td><td width="25%" ><label></label></td>
	</tr>
	<tr>
		<td width="25%" align="center">创建人</td><td width="25%" ><label>${distanceApply.createManS}</label></td>
		<td width="25%" align="center">创建机构</td><td width="25%" ><label>${distanceApply.createOrganizationS}</label></td>
	</tr>
	<tr>
		<td width="25%" align="center">创建时间</td><td width="25%" ><label><fmt:formatDate value='${distanceApply.createTimeS}' pattern='yyyy-MM-dd HH:mm:ss'/></label></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td width="25%" align="center">修改人</td><td width="25%" ><label>${distanceApply.alterManS}</label></td>
		<td width="25%" align="center">修改机构</td><td width="25%" ><label>${distanceApply.alterOrganizationS}</label></td>
	</tr>
	<tr>
		<td width="25%" align="center">修改时间</td><td width="25%" ><label><fmt:formatDate value='${distanceApply.alterTimeS}' pattern='yyyy-MM-dd HH:mm:ss'/></label></td>
		<td></td>
		<td></td>
	</tr>
</table>
<div id=button1 style="text-align:right;padding:5px">
   	<a href="#" class="easyui-linkbutton"  onclick="update();">修改</a>
   	<a href="#" class="easyui-linkbutton"  onclick="send();">发送</a>
   	<a href="#" class="easyui-linkbutton"  onclick="goBack();">返回</a>
</div>
<div id=button2 style="text-align:right;padding:5px">
   	<a href="#" class="easyui-linkbutton"  onclick="goBack();">返回</a>
</div>
   	
   	
   	
   	
   	