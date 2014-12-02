<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsp/inc/header.jsp"%>
<%@ include file="/jsp/inc/resource.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>角色列表</title>
	<script type="text/javascript" src="<%=basePath%>js/common/role.js"></script>
</head>
	<body class="easyui-layout" style="padding: 10px">
	<table id="roles" toolbar="#tb"></table>
	<div id="tb" style="height: auto">
	<a  class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addData();">添加</a>
	<a  class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="editData();">修改</a>
	<a  class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="deleteData();">删除</a>
		<table>
			<tr>
				<td>角色名称:<input id="rolename"
					style="line-height: 20px; border: 1px solid #ccc"></td>
				<td><a class="easyui-linkbutton"
					data-options="iconCls:'icon-search'" onClick="searchs()">查询</a></td>
			</tr>
		</table>
	</div>
	
	<div id="Win" class="easyui-window"  data-options="modal:true,closed:true,iconCls:'icon-save',top:100,resizable:true" style="width:600px;height:400px;padding:10px;font-size: 16px;">
	   
		 <div id="cc" class="easyui-layout" style="width:550px;height:300px;">
	    	<div data-options="region:'west',title:'菜单栏'" style="width:200px;">
	    		<jsp:include page="/common/menuTree.jsp"/>
	    	</div>
	    	<div data-options="region:'center',title:'角色信息'" style="padding:5px;width:220px">
	    			   	
		    <form id="fm" action="" method="post">
		    	<table cellpadding="5" align="center" style="margin-top: 80px">
		    		<tr>
		    			<td>角色名称<span style="color:red">(*)</span>:</td>
		    			<td><input class="easyui-validatebox textbox valid" type="text" name="rolename" ></input></td>
		    		</tr>
		    	</table>
		    		<div style="text-align:center;padding:5px">
				    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">确认</a>
				    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#Win').window('close')">取消</a>
		   			</div>
		    </form>
	    	</div>
	    </div>
	   		
	</div>

	<script type="text/javascript">
		/* $(function() {
			
			$('#roles').datagrid({
				title : '角色信息',
				iconCls : 'icon-save',
				height : document.body.clientHeight*0.98,
				striped : true,
				url : basePath + 'n/role/list',
				idField : 'roleId',
				pagination : true,
				pageSize : 20,
				rownumbers : true,
				fitColumns : true,
				columns : [ [   {
					checkbox : true
				},{
					field : 'roleid',
					title : '角色编号',
					width : 100,
					align : 'center',
					styler: function(value,row,index){
	   					return 'font-size:12px;';
	   				}
				}, {
					field : 'rolename',
					title : '角色名称',
					width : 100,
					align : 'center',
					styler: function(value,row,index){
	   					return 'font-size:12px;';
	   				}
				}, {
					field : 'positioncode',
					title : '职位代码',
					width : 150,
					align : 'center',
					styler: function(value,row,index){
	   					return 'font-size:12px;';
	   				}
				}, {
					field : 'positionname',
					title : '职位名称',
					width : 150,
					align : 'center',
					styler: function(value,row,index){
	   					return 'font-size:12px;';
	   				}
				} ] ],
				loadMsg: "数据加载中...",
				onBeforeLoad : function(param) {
					param.roleid = $("#roleid").val();
					param.rolename = $("#rolename").val();
				}
			});
		});

		function searchs() {
			$('#roles').datagrid('load');
		} */
	</script>
</html>
