<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsp/inc/header.jsp"%>
<%@ include file="/jsp/inc/resource.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户修改</title>
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
	<div class="title">用户修改</div>
	<form id="editUserForm" action="<%=basePath%>userAction_editUser.action" method="post">
			<table style="margin:20px auto">
			<input type="hidden" id="userid" name="user.id" value="${user.id }" />
				<tr class="line_ku" style="line-height:38px">
					<td class="worker">用户名:</td>
					<td><input class="worker_two" type="text" id="username"
						name="user.username" value="${user.username }" /><span class="required">*</span></td>
				</tr>
				<tr class="line_ku" style="line-height:38px">
				<td class="worker">密码:</td>
					<td><input class="worker_two" type="password" id="password"
						name="user.password" value="${user.password }" /><span class="required">*</span></td>
				</tr>
				<tr class="line_ku" style="line-height:38px">
						<td class="worker">角色:</td>
                        <td>
                          <ul>
						 	<c:forEach var="role" items="${rolelist}">
                            <li>
						  	 <input type="radio" name="roleidlist" value="${role.id}"
                                     <c:forEach var="userrole" items="${userroleidList}">
                                        <c:if test="${role.id == userrole}">
                                         checked = "checked"
                                        </c:if >
                                     </c:forEach> >${role.rolename}</input>
                            </li>
						    </c:forEach>
						    <input type="hidden" id="rolenum" />
                          </ul>
						</td>
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
	$(document).ready(function(){		
		$("#username,#password").addClass("easyui-validatebox").validatebox({required: true,missingMessage: '必填'});
	});

	 // 设置ajax同步
    $.ajaxSetup({  
        async : false  
    });
	function submitForm(){
		var roleidlist= document.getElementsByName("roleidlist");
		var isSel2 =""; //判断角色项是否有选中项
		var username=$("#username").val();
		var id=$("#userid").val();
		for(var j=0;j<roleidlist.length;j++){
			if(roleidlist[j].checked==true){
				isSel2+=roleidlist[j].value+",";
				}
				}
		if(isSel2 == ""){
			$("#rolenum").val("0");
		}else{
			$("#rolenum").val("1");
		}

		$('#editUserForm').form('submit',{
			onSubmit: function(){
				var result = $(this).form('validate');
				var result1=true;
				var result2=true;

				if($("#rolenum").val()=="0"){
					$.messager.alert("提示", "请选择角色!","info");
					result1=false;
				};
				var flag;
				checkUserExist=function(username,id)
		  	    {
		  		  $.post(
		      	  	            "<%=basePath%>userAction_checkUserExist.action",
		      	  	            {username:username,id:id},
		      					function(data){
		          					flag=data;
		      					}
		      				);
		  			if(flag==0)
		  				return true;
		  			else
		  			    return false;
		        };

                if(result==true){
                	result2=checkUserExist(username,id);
                	if(result2==false)
                		$.messager.alert("提示", "您输入的用户名与系统中重复，请修改!","error");
                }
				
				if(result == true && result1==true && result2==true){
					$("#editUserForm").ajaxSubmit({
			 			success:function(){
							$.messager.alert("提示","修改成功！","info",function(){
								window.location.href="<%=basePath%>userAction_toList.action";
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
