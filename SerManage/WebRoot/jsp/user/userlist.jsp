<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsp/inc/header.jsp"%>
<%@ include file="/jsp/inc/resource.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Server列表</title>
	<script type="text/javascript">
   		$(function() {
			
   			$("#queryBtn").click(function(){
				$('#tt').datagrid('load',{  // 向服务器传递的参数
				  username:$('#username').val()
			        }); 
			})
			
			$("#resetBtn").click(function(){
			$('#username').val("");
			})
			
			$('#tt').datagrid({
				//下面是 datagrid的基本 配置信息 
				url:'<%=basePath%>userAction_queryPageJson.action',
				width: ($(window).width()-30),
				height: 'auto',
				nowrap: false,  //  是否在一行显示数据
				striped: true,   //  是否 显示 斑马线  
				fitColumns: true,  // 自动填充 列 宽
				collapsible: true,   // 是否 有滑动效果 
				columnOption: true,
				rownumbers: true,
				loadMsg: '数据连接中.....',  //加载页面时候的提示消息
				remoteSort: false,    // 是否使用本地 排序，注意 选择 本地 排序后，其他自定义排序都将失去效果 
				//sortOrder: 'desc',    // 排序 方法 
				singleSelect:false, 
				columns: [[
                      {checkbox : true},
					  {field:'username',title:'用户名',resizable:true,sortable:true,width:fixColumnWidth(0.20)},
					  {field:'operation',title:'操作',width:fixColumnWidth(0.30),
						   formatter: function(val,node) {
							   return "<span><a class=\"operation-a\" id=\"operation\" href='javascript:void(0)' onclick='openTab(this,\"用户\",\"edit\","
			   		           +node.id+")' >编辑</a>&nbsp;"
			   		           +"&nbsp;<a class=\"operation-a\" href='javascript:void(0)' onclick='deleteRecord("+node.id+")' >删除</a>";
						   }
			   		  }
				]],
				//下面 定义 分页配置 ：
				pageSize:10,
				pageList:[5,10,15,20],
				pagination:true,   // 是否 要分页 
				pageNumber:1,//设置初始页为1
				onLoadSuccess: omitLong()
			});
			//下面这个方法 用于 配置  分页的信息 
			displayMsg($('#tt'));
		});
   </script>
</head>
	<body>
	<div class="search">
    	<table onKeyUp="bindQuery();">
		  <tr>
		  <td>用户名</td>
            <td>
            	<input class="t-text" id="username" type="text" value="">
            </td>
             <td>
                <a href="javascript:void(0)" id="queryBtn" class="but-search"></a>
            </td>
            <td>
		      	<a href="javascript:void(0)" id="resetBtn" class="but-remove">清空</a>
		    </td>
		  </tr>
	 </table>
  </div>
		<div class="search-list">
        	<span class="list-title">用户列表</span>
            <table id="tt" toolbar="#toolbar"></table></div>
		<input type="hidden" id="editURL" value="<%=request.getContextPath()%>/userAction_editUserUI.action?user.id="/>
		<input type="hidden" id="deleteURL" value="<%=request.getContextPath()%>/userAction_deleteUser.action?user.id="/>
		<div id="iframeWin" class="easyui-window" title="信息" modal="true" closed="true"
			iconCls="icon-save" style="width:900px;height:400px;padding:10px;">
			<iframe id="iframeSource" name="iframeSource" frameborder="0" width="100%" height="100%"></iframe>
		</div>
		<div id="toolbar">
		<a href='<%=basePath%>userAction_addUserUI.action' class='easyui-linkbutton' iconCls='icon-add' plain='true'>新增</a>
		</div>
	</body>
</html>
