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
			
			//初始化select的值
	        function selectOption(typeArray)
	        {
	          var adminHtmls="<option value=''>--全部--</option>";
	          for(var i=0;i<typeArray.length;i++){
	        	  adminHtmls+='<option value="'+typeArray[i]+'" >'+typeArray[i]+'</option>';
	          }
	          return adminHtmls;
	        };
	        
	        var operators;
			$.post(
      	  	            "<%=basePath%>serverAction_getOperators.action",
      					function(data){
      	  	            operators=data;
      	  	            var str=new Array();
      		            if(operators!="")
      		                str=operators.split(",");
      		             $('#administrator').html(selectOption(str));
      					}
      			 );
	        
	        // 根据当前用户权限判断是否显示“新增”按钮
			$.post(
      	  	            "<%=basePath%>userAction_checkSuperadmin.action",
      					function(data){
      					     if(data!=1){
      						  $("#toolbar").hide();
          					            }
      					}
      			 );
			
   			$("#queryBtn").click(function(){
				$('#tt').datagrid('load',{  // 向服务器传递的参数
				  pcname:$('#pcname').val(),
				  environment:$('#environment').val(),
				  systemname:$("#systemname").combobox('getValue'),
				  apptype:$("#apptype").val(),
				  startupdatetime:$("#startupdatetime").val(),
				  endupdatetime:$("#endupdatetime").val(),
				  administrator:$("#administrator").val()
			        }); 
			})
			
			$("#resetBtn").click(function(){
			$('#pcname').val("");
			$("#environment").val("");
			$('#systemname').combobox('setValue', '');
			$("#apptype").val("");
			$("#startupdatetime").val("");
			$("#endupdatetime").val("");
			$("#administrator").val("");
			})
			
			$('#tt').datagrid({
				//下面是 datagrid的基本 配置信息 
				url:'<%=basePath%>serverAction_queryPageJson.action',
				height: 'auto',
				nowrap: false,  //  是否在一行显示数据
				striped: true,   //  是否 显示 斑马线  
				collapsible: true,   // 是否 有滑动效果 
				columnOption: true,
				rownumbers: true,
				loadMsg: '数据连接中.....',  //加载页面时候的提示消息
				remoteSort: false,    // 是否使用本地 排序，注意 选择 本地 排序后，其他自定义排序都将失去效果 
				//sortOrder: 'desc',    // 排序 方法 
				singleSelect:false, 
				columns: [[
                      {checkbox : true},
					  {field:'environment',title:'开发环境',resizable:true,sortable:true,width:100},
					  {field:'systemname',title:'系统名称',resizable:true,sortable:true,width:100},
					  {field:'pcname',title:'机器名称',resizable:true,sortable:true,width:100},
					  {field:'ipurl',title:'IP地址',resizable:true,sortable:true,width:150},
					  {field:'os',title:'OS',resizable:true,sortable:true,width:100},
					  {field:'cpu',title:'CPU',resizable:true,sortable:true,width:100},
					  {field:'mem',title:'MEM',resizable:true,sortable:true,width:100},
					  {field:'disk',title:'DISK',resizable:true,sortable:true,width:100},
					  {field:'apptype',title:'应用类型',resizable:true,sortable:true,width:100},
					  {field:'appdescription',title:'应用描叙',resizable:true,sortable:true,width:100},
					  {field:'f5deploy',title:'F5配置',resizable:true,sortable:true,width:250},
					  {field:'administrator',title:'管理员',resizable:true,sortable:true,width:100},
					  {field:'updatetime',title:'更新时间',resizable:true,sortable:true,width:150},
					  {field:'operation',title:'操作',width:fixColumnWidth(0.10),
						   formatter: function(val,node) {
							   return "<span><a class=\"operation-a\" id=\"operation\" href='javascript:void(0)' onclick='openTab(this,\"服务器\",\"edit\","
			   		           +node.id+")' >编辑</a>&nbsp;"
			   		           +"&nbsp;<a class=\"operation-a\" href='javascript:void(0)' onclick='deleteRecord("+node.id+")' >删除</a>";
						   }
			   		  }
				]],
				//下面 定义 分页配置 ：
				pageSize:15,
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
		  <td>机器名称</td>
            <td>
            	<input class="t-text" id="pcname" type="text" value="">
            </td>
		  	<td>系统环境</td>
            <td>
            	<select id="environment">
				 <option value="">--全部--</option>
	             <option value="生产环境">生产环境</option>
	             <option value="MOCK环境">MOCK环境</option>
	             <option value="测试环境">测试环境</option>
	             <option value="开发环境">开发环境</option>
            	</select>
            </td>
		  </tr>
		  <tr>
		   <td>系统名称</td>
            <td>
            <input id="systemname" class="easyui-combobox"> 
            </td>
		   <td>应用类型</td>
             <td>
             	<select id="apptype">
	             <option value="">--全部--</option>
	             <option value="0">数据库服务器</option>
	             <option value="1">应用服务器</option>
            	</select>
           	 </td>
		  </tr>
		  <tr>
		  <td>更新时间段</td>
             <td>
             	<input class="t-text" id="startupdatetime" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text" value="">
            	—
            	<input class="t-text" id="endupdatetime" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  type="text" value="">
            </td>
            <td>管理员</td>
			<td>
			<select id="administrator"></select>
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
        	<span class="list-title">服务器列表</span>
            <table id="tt" toolbar="#toolbar"></table></div>
		<input type="hidden" id="editURL" value="<%=request.getContextPath()%>/serverAction_editServerUI.action?server.id="/>
		<input type="hidden" id="deleteURL" value="<%=request.getContextPath()%>/serverAction_deleteServer.action?server.id="/>
		<div id="iframeWin" class="easyui-window" title="信息" modal="true" closed="true"
			iconCls="icon-save" style="width:900px;height:400px;padding:10px;">
			<iframe id="iframeSource" name="iframeSource" frameborder="0" width="100%" height="100%"></iframe>
		</div>
		<div id="toolbar">
		<a href='<%=basePath%>serverAction_addServerUI.action' class='easyui-linkbutton' iconCls='icon-add' plain='true'>新增</a>
		</div>
	</body>
</html>
