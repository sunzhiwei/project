<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>
<%@ include file="../../inc/resource.inc"%>
<link rel="stylesheet" href="${ctx}/css/zTreeStyle/zTreeStyle.css"
	type="text/css" />
<script type="text/javascript"
	src="${ctx}/js/jquery.ztree.all-3.5.min.js"></script>
<SCRIPT type="text/javascript">
	var settingMenu = {
		data : {
			simpleData : {
				enable : true
			}
		},
		check : {
			enable : true,
			chkStyle : "checkbox",
			chkboxType : {
				"Y" : "ps",
				"N" : "ps"
			}

		},
		callback : {
			onCheck : onMenuCheck
		}
	};

	var zNodes;

	var menuUrl = "${ctx}/hxRoleMenu/getMenuTree?cs=" + Math.random();
	$.getJSON(menuUrl, function(data) {
		if (data) {
			zNodes = data;
			$.fn.zTree.init($("#menuTreeDemo"), settingMenu, zNodes);
		}
	});

	function onMenuCheck(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("menuTreeDemo");
		nodes = zTree.getCheckedNodes(true);
		v = "";
		for (var i = 0, l = nodes.length; i < l; i++) {
			v += nodes[i].id + ",";
		}
		if (v.length > 0)
			v = v.substring(0, v.length - 1);
		var resu = $("#menuId");
		resu.attr("value", v);
	}

	function initMenuZtree() {
		//从新载入menutree
		var zTree;
		$.getJSON(menuUrl, function(data) {
			if (data) {
				zNodes = data;
				$.fn.zTree.init($("#menuTreeDemo"), settingMenu, zNodes);
				zTree = $.fn.zTree.getZTreeObj("menuTreeDemo");
				var roleId = $("#roleId").val();
				var url = "${ctx}/hxRoleMenu/getMenuTreeData/" + roleId;
				$.getJSON(url, function(data) {
					if (data) {
						if (data != "" && data != null) {
							//选中用户时，同时将该用户的roleid放到隐藏域中
							var resu = $("#menuId");
							var roleIdTemp = "";
							for(var i=0; i<data.length; i++)  
							{  
								roleIdTemp += data[i].id +",";
								var node = zTree.getNodeByParam("id", data[i].id,
										null);
								if (node != null) {
									zTree.selectNode(node, true);//选中节点
									node.checked = true;
									zTree.updateNode(node);//复选框勾选
								}
							}  
							resu.attr("value", roleIdTemp);
						}
					}
				});
			}
		});

	}

	$(function() {
		//初始化菜单树
		initMenuZtree();
		parent.$.messager.progress('close');

		$('#form').form({
			url : '${ctx}/hxRoleMenu/addRoleMenu',
			onSubmit : function(param) {
				param.roleId = $("#roleId").val();
				param.menuId = $("#menuId").val();
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				var isValid = $(this).form('validate');
				if (!isValid) {
					parent.$.messager.progress('close');
				}
				return isValid;
			},
			success : function(msg) {
				parent.$.messager.progress('close');
				if ($.parseJSON(msg).flag == "success") {
					$.messager.alert('提示:', '保存成功!');
				}
			}
		});
	});
	
	function submitForm(){
		var f = $("#form");
		f.submit();
	}
	
	function goBack(){
		var roleId = $("#roleId").val();
		window.location.href="${ctx}/hxRole/showView/"+ roleId;
	}
	
</SCRIPT>
<div class="easyui-panel" title="配置角色所使用的菜单" style="width:auto">
		<div style="padding:10px 0 10px 60px">
		<form id="form" method="post">
			<table class="table table-hover table-condensed" width="100%">
				<tr>
					<td width="20%">角色名称</td>
					<td width="30%"><label>${role.roleName} </label></td>
				</tr>
				<tr>
					<td colspan="2">
						<div
							style="width: 300px; height: 500px; overflow-x: hidden; overflow-y: auto; border:solid 1px #E6E2E2;text-align:left;padding-left:1.2em;padding-right:1.2em;border-style:solid;margin-top:0.25em;margin-bottom:0.25em;">
							<ul id="menuTreeDemo" class="ztree"></ul>
						</div> <input type="hidden" id="roleId" value="${role.roleId}"/> <input type="hidden"
						id="menuId" />
					</td>

				</tr>
			</table>
		</form>
	</div>
	<div style="text-align:center;padding:5px">
	    	<a href="#" class="easyui-linkbutton"  onclick="submitForm();">保存</a>
	    	<a href="#" class="easyui-linkbutton"  onclick="goBack();">返回</a>
	</div>
</div>
