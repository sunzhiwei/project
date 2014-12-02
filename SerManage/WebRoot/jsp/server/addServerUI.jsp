<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/inc/header.jsp"%>
<%@ include file="/jsp/inc/resource.inc"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>服务器添加</title>
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
	<div class="tableForm">
	<div class="title">服务器添加</div>
	<form id="addForm" action="<%=basePath%>serverAction_add.action" method="post">
			<table style="margin:20px auto">
				<tr class="line_ku" style="line-height:38px">
					<td class="worker">系统环境:</td>
					<td><select style="width:280px;" id="environment"
						name="server.environment">
							<option value="" selected="selected">--请选择--</option>
							<option value="生产环境">生产环境</option>
							<option value="MOCK环境">MOCK环境</option>
							<option value="测试环境">测试环境</option>
							<option value="开发环境">开发环境</option>
					</select><span class="required">*</span></td>
					<td class="worker">系统名称:</td>
					<td>
					<input style="width:280px;" id="systemname" name="server.systemname"><span class="required">*</span>
					</td>
				</tr>
				<tr class="line_ku" style="line-height:38px">
					<td class="worker">机器名称:</td>
					<td><input class="worker_two" type="text" id="pcname"
						name="server.pcname" value="" /><span class="required">*</span></td>
					<td class="worker">IP地址:</td>
					<td><input class="worker_two" type="text" id="ipurl"
						name="server.ipurl" value="" /><span class="required">*</span></td>
				</tr>
				<tr class="line_ku" style="line-height:38px">
					<td class="worker">OS:</td>
					<td><input class="worker_two" type="text" id="os"
						name="server.os" value="" /><span class="required">*</span></td>
					<td class="worker">CPU:</td>
					<td><input class="worker_two" type="text" id="cpu"
						name="server.cpu" value="" /><span class="required">*</span></td>
				</tr>
				<tr class="line_ku" style="line-height:38px">
					<td class="worker">MEM:</td>
					<td><input class="worker_two" type="text" id="mem"
						name="server.mem" value="" /><span class="required">*</span></td>
					<td class="worker">DISK:</td>
					<td><input class="worker_two" type="text" id="disk"
						name="server.disk" value="" /><span class="required">*</span></td>
				</tr>
				<tr class="line_ku" style="line-height:38px">
					<td class="worker">应用类型:</td>
					<td><select style="width:280px;" id="apptype"
						name="server.apptype">
							<option value="" selected="selected">--请选择--</option>
							<option value="0">数据库服务器</option>
							<option value="1">应用服务器</option>
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
							name="server.f5deploy" rows="10" cols="30"></textarea><span class="required">*</span>
					</td>
					<td class="worker">应用描叙:</td>
					<td><textarea style="width: 256px; height:90px"
							name="server.appdescription" rows="10" cols="30"></textarea></td>
				</tr>
			</table>
			<div class="t-but" style="text-align: center;">
		    	<a style="margin-right:12px;" href="javascript:void(0)" class="but-change" onclick="submitForm();" plain="true">添加</a>
				<a href="javascript:void(0)" class="but-cancel" onclick="closeTab()" plain="true">取消</a>
            </div>
</form>
	</div>
	</body>
	<script type="text/javascript">
	
	     $(function(){
		      $("#environment,#apptype,#administrator,#pcname,#ipurl,#os,#cpu,#mem,#disk,#f5deploy").addClass("easyui-validatebox").validatebox({required: true,missingMessage: '必填'});
	     
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
				
				$('#systemname').combobox('setValue', ''); 
	     });
	    //初始化select的值
        function selectOption(typeArray)
        {
          var adminHtmls="<option value=''>--请选择--</option>";
          for(var i=0;i<typeArray.length;i++){
        	  adminHtmls+='<option value="'+typeArray[i]+'" >'+typeArray[i]+'</option>';
          }
          return adminHtmls;
        };
        var administrators=$("#administrators").val();
        var str=new Array();
        if(administrators!="")
           str=administrators.split(",");
        $('#administrator').html(selectOption(str)); 
        
        // 设置ajax同步
        $.ajaxSetup({  
            async : false  
        });
        
        // 验证机器所在ip地址是否重复
        var flag;
  	    isrepeatIP=function(ipurl)
  	    {
  		  $.post(
      	  	            "<%=basePath%>serverAction_ifServerHasExists.action",
      	  	            {ipurl:ipurl},
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
        	$('#addForm').form('submit',{
        		onSubmit: function(){
        			var result = $(this).form('validate');
        			var systemname=$('#systemname').combobox('getValue');
        			if(result == true){
        				if(systemname==""){
            				$.messager.alert("提示", "系统名称不能为空，请选择！");
            	  		    return false;
            			}
        				var exp=/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
            			var ipurl=$("#ipurl").val();
            			if(exp.test(ipurl)==false){
            				$.messager.alert("提示", "您输入的IP地址格式不正确，请修改！");
            	  		    return false;
            			}
            			if(isrepeatIP(ipurl) == true){
            	  		      $.messager.alert("提示", "您输入的机器所在IP地址与数据库中有重复，一台服务器只能在一台机器上，请修改！");
            	  		      return false;
            	  		}
        				$("#addForm").ajaxSubmit({
        		 			success:function(){
        						$.messager.alert("提示","添加成功！","info",function(){
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
