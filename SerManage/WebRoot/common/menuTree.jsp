<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/inc/header.jsp"%>
<%@ include file="/jsp/inc/resource.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
asdsada

	<ul id="tt" class="easyui-tree" data-options="animate:true,dnd:true" checkbox="true" ></ul>
	<script type="text/javascript">
		$('#tt').tree({
			url :  "<%=basePath%>menuAction_list?show=all",
			loadFilter : function(rows) {
				return convert(rows);
			},
			onCheck : function(node, checked){
				var isLeaf = $('#tt').tree("isLeaf", node.target);
				if(isLeaf){//叶子节点
					if(checked){//已被选中
						var parent = $('#tt').tree("getParent", node.target);
						$('#tt').tree("check", parent.target);
					}
				}else{//父节点
					if(!checked){//取消选中则取消子节点的选中
						var children = $('#tt').tree("getChildren", node.target);
						for(var i=0;i<children.length;i++){
							var no = children[i];
							$('#tt').tree("uncheck", no.target);
						}
					}
				}
			}
		});

		function convert(rows) {
			/* rows = jQuery.parseJSON(rows); */
			function exists(rows, pid) {
				for (var i = 0; i < rows.length; i++) {
					if (rows[i].id == pid)
						return true;
				}
				return false;
			}

			var nodes = [];
			// 得到顶层节点  
			for (var i = 0; i < rows.length; i++) {
				var row = rows[i];
				if (!exists(rows, row.pid)) {
					nodes.push({
						id : row.id,
						text : row.name
					});
				}
			}

			var toDo = [];
			for (var i = 0; i < nodes.length; i++) {
				toDo.push(nodes[i]);
			}
			while (toDo.length) {
				var node = toDo.shift(); // 父节点   
				// 得到子节点   
				for (var i = 0; i < rows.length; i++) {
					var row = rows[i];
					if (row.pid == node.id) {
						if (row.url) {
							var child = {
								id : row.id,
								text : row.name,
								attributes : {
									url : row.url
								}
							};
						} else {
							var child = {
								id : row.id,
								text : row.name
							};
						}
						if (node.children) {
							node.children.push(child);
						} else {
							node.children = [ child ];
						}
						toDo.push(child);
					}
				}
			}
			return nodes;
		}
	</script>

</body>
</html>