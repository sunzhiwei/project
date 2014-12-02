<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsp/inc/header.jsp"%>
<%@ include file="/jsp/inc/resource.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>服务器修改</title>
	<style type="text/css">
	.worker{ text-align:right;}
	.worker_two{border: #d1deea solid 1px; height: 30px; line-height: 30px; width: 258px; padding: 0 8px;}
	.shouji_button {cursor:pointer; background: #FCECAB; border: 1px solid #F2C409; text-align: center; color: #333333; width:46px; height:28px; line-height:28px; float:left;}
	.zm_button{cursor:pointer; background: #ACDEFF; border: 1px solid #6AC4FF; line-height:30px; text-align: center; color: #333333; width:46px; height:30px; float:left;}
	.line_ku td{border:1px dotted #C7D3E3; padding:10px; background:#F5F8FD;}
	</style>
	</head>
	<body>
	<input type="hidden" id="administrators" value="${administrators }"/>
	<input type="hidden" id="administrator_select" value="${server.administrator }"/>
	<div class="tableForm">
	<div class="title">服务器添加</div>
	<form id="editForm" action="<%=basePath%>serverAction_edit.action"  method="post">
			<table style="margin:20px auto">
			<input type="hidden" id="serverid" value="${server.id }" name="server.id"/>
				<tr class="line_ku" style="line-height:38px">
					<td class="worker">系统环境:</td>
					<td><select style="width:280px;" id="environment"
						name="server.environment">
						<option value="生产环境" <c:if test="${server.environment=='生产环境'}">selected="selected"</c:if>>生产环境</option>
						<option value="MOCK环境" <c:if test="${server.environment=='MOCK环境'}">selected="selected"</c:if>>MOCK环境</option>
						<option value="测试环境" <c:if test="${server.environment=='测试环境'}">selected="selected"</c:if>>测试环境</option>
						<option value="开发环境" <c:if test="${server.environment=='开发环境'}">selected="selected"</c:if>>开发环境</option>
					</select><span class="required">*</span></td>
					<td class="worker">系统名称:</td>
					<td>
					<input style="width:280px;" id="systemname" name="server.systemname"><span class="required">*</span>
					
					<%-- <select style="width:280px;" id="systemname"
						name="server.systemname">
						<option value="金立系统" <c:if test="${server.environment=='金立系统'}">selected="selected"</c:if>>金立系统</option>
						<option value="TMS系统" <c:if test="${server.environment=='TMS系统'}">selected="selected"</c:if>>TMS系统</option>
						<option value="ECP系统" <c:if test="${server.environment=='ECP系统'}">selected="selected"</c:if>>ECP系统</option>
						<option value="EMP系统" <c:if test="${server.environment=='EMP系统'}">selected="selected"</c:if>>EMP系统</option>
					</select><span class="required">*</span> --%></td>
				</tr>
				<tr class="line_ku" style="line-height:38px">
					<td class="worker">机器名称:</td>
					<td><input class="worker_two" type="text" id="pcname"
						name="server.pcname" value="${server.pcname }" /><span class="required">*</span></td>
					<td class="worker">IP地址:</td>
					<td><input class="worker_two" type="text" id="ipurl"
						name="server.ipurl" value="${server.ipurl }" /><span class="required">*</span></td>
				</tr>
				<tr class="line_ku" style="line-height:38px">
					<td class="worker">OS:</td>
					<td><input class="worker_two" type="text" id="os"
						name="server.os" value="${server.os }" /><span class="required">*</span></td>
					<td class="worker">CPU:</td>
					<td><input class="worker_two" type="text" id="cpu"
						name="server.cpu" value="${server.cpu }" /><span class="required">*</span></td>
				</tr>
				<tr class="line_ku" style="line-height:38px">
					<td class="worker">MEM:</td>
					<td><input class="worker_two" type="text" id="mem"
						name="server.mem" value="${server.mem }" /><span class="required">*</span></td>
					<td class="worker">DISK:</td>
					<td><input class="worker_two" type="text" id="disk"
						name="server.disk" value="${server.disk }" /><span class="required">*</span></td>
				</tr>
				<tr class="line_ku" style="line-height:38px">
					<td class="worker">应用类型:</td>
					<td><select style="width:280px;" id="apptype"
						name="server.apptype">
						<option value="0" <c:if test="${server.apptype==0}">selected="selected"</c:if>>数据库服务器</option>
						<option value="1" <c:if test="${server.apptype==1}">selected="selected"</c:if>>应用服务器</option>
					</select><span class="required">*</span></td>
					<td class="worker">管理员:</td>
					<td><select style="width:280px;" id="administrator"
						name="server.administrator">
					</select><span class="required">*</span></td>
				</tr>
				<tr class="line_ku" style="line-height:38px">
					<td class="worker">F5配置:</td>
					<td>
						<textarea style="width: 256px; height:90px" id="f5deploy"
							name="server.f5deploy" rows="10" cols="30">${server.f5deploy }</textarea><span class="required">*</span>
					</td>
					<td class="worker">应用描叙:</td>
					<td><textarea style="width: 256px; height:90px"
							name="server.appdescription" rows="10" cols="30">${server.appdescription }</textarea></td>
				</tr>
			</table>
			<div class="t-but" style="text-align: center;">
		    	<a style="margin-right:12px;" href="javascript:void(0)" class="but-change" onclick="submitForm();" plain="true">修改</a>
				<a href="javascript:void(0)" class="but-cancel" onclick="closeTab()" plain="true">取消</a>
            </div>
</form>
	</div>
	</body>
	<script type="text/javascript">
	
	     $(function(){
		      $("#environment,#apptype,#administrator,#pcname,#ipurl,#os,#cpu,#mem,#disk,#f5deploy").validatebox({required: true,missingMessage: '必填'});
		      
		        // 系统环境初始化
	   			$('#systemname').combobox({
			        url: '<%=request.getContextPath() %>/json/os_name.json',
			        valueField:'id',
			        textField:'text',
			        loadFilter : function(rows) {
			        	var row = {
			        		id : '',
			        		text : '全部'
			        	};
						rows.unshift(row);
						return rows;
					}
			        });
				
				$('#systemname').combobox('setValue', '${server.systemname}'); 
	     });
	    //初始化select的值
		function selectOption(typeArray, administrator_select) {
			var adminHtmls = "<option value=''>--请选择--</option>";
			for ( var i = 0; i < typeArray.length; i++) {
				if (typeArray[i] == administrator_select)
					adminHtmls += '<option value="'+typeArray[i]+'" selected="selected">'
							+ typeArray[i] + '</option>';
				else
					adminHtmls += '<option value="'+typeArray[i]+'">'
							+ typeArray[i] + '</option>';
			}
			return adminHtmls;
		};
		
		var administrators = $("#administrators").val();
		var administrator_select = $("#administrator_select").val();
		var str = new Array();
		if (administrators != "")
			str = administrators.split(",");
		$('#administrator').html(selectOption(str,administrator_select));

		// 设置ajax同步
		$.ajaxSetup({
			async : false
		});
		
		// 验证机器所造ip地址是否重复
        var flag;
        isrepeatIP=function(ipurl,id)
  	    {
  		  $.post(
      	  	            "<%=basePath%>serverAction_ifServerHasExists.action",
      	  	            {ipurl:ipurl,id:id},
      					function(data){
          					flag=data;
      					}
      				);
  		if(flag==0)
				return false;
			else
			    return true;
        };
        
        function submitForm(){
        	$('#editForm').form('submit',{
        		onSubmit: function(){
        			var result = $(this).form('validate');
        			var id=$("#serverid").val();
        			if(result == true){
        				var exp=/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
            			var ipurl=$("#ipurl").val();
            			if(exp.test(ipurl)==false){
            				$.messager.alert("提示", "您输入的IP地址格式不正确，请修改！");
            	  		    return false;
            			}
            			if(isrepeatIP(ipurl,id) == true){
            	  		      $.messager.alert("提示", "您输入的机器所在IP地址与数据库中有重复，一台服务器只能在一台机器上，请修改！");
            	  		      return false;
            	  		}
        				$("#editForm").ajaxSubmit({
        		 			success:function(){
        						$.messager.alert("提示","更新成功！","info",function(){
        							window.location.href="<%=basePath%>serverAction_toList.action";
        						})
        		 			}
        		 		});	
        			}
        			return false;
        		}
        	})
        }
         
	</script>
</html>
