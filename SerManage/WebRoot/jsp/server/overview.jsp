<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsp/inc/header.jsp"%>
<%@ include file="/jsp/inc/resource.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Server列表</title>
	<style> 
.table-b table td{
height:10px;
border:1px solid #000;
} 
/* css注释：只对table td标签设置红色边框样式 */ 
</style> 
<script type="text/javascript">
  function check(value){
	     window.location.href="<%=basePath%>serverAction_overview.action?environment="+value;
  };

</script>
</head>
	<body>
	<div id="search"  style="height:100px;border:1px solid #ccc;padding:10px;"  align="center">
	 <table border="0" cellspacing="0" cellpadding="0" bordercolor="#000000">
             <tr>
             <td>系统环境</td>
             <td>
             <select id="environment" onchange=check(this.value)>
	             <option value="生产环境" <c:if test="${environment=='生产环境'}">selected="selected"</c:if>>生产环境</option>
	             <option value="MOCK环境" <c:if test="${environment=='MOCK环境'}">selected="selected"</c:if>>MOCK环境</option>
	             <option value="测试环境" <c:if test="${environment=='测试环境'}">selected="selected"</c:if>>测试环境</option>
	             <option value="开发环境" <c:if test="${environment=='开发环境'}">selected="selected"</c:if>>开发环境</option>
            	</select>
            </td>
            </tr>
             <tr>
             <td>数量</td>
             <td>
             ${total }&nbsp;&nbsp;台
            </td>
             </tr>	
             <tr>
             <td>最后更新时间</td>
             <td>
             ${lastupdatetime }
            </td>
             </tr>		 
	 </table>
	</div>
	<div id="main" style="height:250px;border:1px solid #ccc;padding:10px;"></div>
	<div class="search-list">
        	<span class="list-title">服务器分布列表</span>
            <table id="tt" toolbar="#toolbar"></table></div>
		<div id="iframeWin" class="easyui-window" title="信息" modal="true" closed="true"
			iconCls="icon-save" style="width:900px;height:400px;padding:10px;">
			<iframe id="iframeSource" name="iframeSource" frameborder="0" width="100%" height="100%"></iframe>
		</div>
	
	</body>
	<script src="<%=request.getContextPath() %>/js/echarts-plain-map.js"></script>
	<script type="text/javascript">

	$(function() {
		
	$('#tt').datagrid({
		//下面是 datagrid的基本 配置信息 
		url:'<%=basePath%>serverAction_queryServerDistributePageJson.action',
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
		sortOrder: 'desc',    // 排序 方法 
		singleSelect:false, 
		columns: [[ 
			  {field:'systemname',title:'系统名称',resizable:true,sortable:true,width:fixColumnWidth(0.20)},
			  {field:'dbservercount',title:'数据库服务器',resizable:true,sortable:true,width:fixColumnWidth(0.20)},
			  {field:'appservercount',title:'应用服务器',resizable:true,sortable:true,width:fixColumnWidth(0.20)},
		]],
		queryParams: {//传递参数
			environment: $("#environment").val()
		},
		//下面 定义 分页配置 ：
		pageSize:30,
		pageList:[10,15,20,25,30],
		pagination:true,   // 是否 要分页 
		pageNumber:1,//设置初始页为1
		onLoadSuccess: omitLong()
	});
	//下面这个方法 用于 配置  分页的信息 
	displayMsg($('#tt'));
});
	
	
    var myChart = echarts.init(document.getElementById('main'));
    var db; // 数据库服务器数量集
    var app; // 应用服务器数量集
    var column; // X轴列
    
    $.ajax({
		type:"post",
		url:"serverAction_getDBServers.action",
		data: {environment:$("#environment").val()},
		async: false,
		dataType:"json",//设置需要返回的数据类型
		success:function(data){
			var d = eval("("+data+")");//将数据转换成json类型
			db=d;
		},
		error:function(){
			 $.messager.alert("提示", "该系统环境下无任何系统的数据库服务器！");
		}
	});

    $.ajax({
		type:"post",
		url:"serverAction_getAPPServers.action",
		data: {environment:$("#environment").val()},
		async: false,
		dataType:"json",
		success:function(data){
			var d = eval("("+data+")");
			app=d;
		},
		error:function(){
			$.messager.alert("提示", "该系统环境下无任何系统的应用服务器！");
		}
	});

     $.ajax({
		type:"post",
		url:"serverAction_getSystemColumn.action",
		data: {environment:$("#environment").val()},
		async: false,
		dataType:"json",
		success:function(data){
			var d = eval("("+data+")");
			column=d;
		},
		error:function(){
			$.messager.alert("提示", "该系统环境下无任何系统的服务器！");
		}
	}); 

    myChart.setOption({
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['数据库服务器','应用服务器']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar','stack', 'tiled']},  // 动态类型切换,支持直角系下的折线图、柱状图、堆叠、平铺转换
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                axisLabel : 
                {
                	rotate:-30,
                	textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        color: '#333',
                        fontSize:14,
                        fontWeight:'bolder'
                    }
                },
                data :  column //['ECP系统','EMP系统','TMS系统','金立系统']
            }
        ],
        yAxis : [
            {
                type : 'value',
                splitArea : {show : true}
            }
        ],
        series : [
            {
                name:'数据库服务器',
                type:'bar',
                smooth:true,
                itemStyle: {normal: {areaStyle: {type: 'default'}}},
                data:db
            },
            {
                name:'应用服务器',
                type:'bar',
                smooth:true,
                itemStyle: {normal: {areaStyle: {type: 'default'}}},
                data:app
            }
        ]
    });

    </script>
</html>
