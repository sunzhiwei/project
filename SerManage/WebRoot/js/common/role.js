
	function submitForm(){
	     var flag = true;
	      $(".valid").each(function(i, n) {
	          if ("" == n.value) {
	              flag = false;
	          }
	      });

	      if (!flag) {
	    	  $.messager.alert('消息提示',"表单数值不能为空",'error'); 
	      } else {
	    	  parent.showProgressing();
				var data = $("#fm").serialize();
				
				var nodes = $('#tt').tree('getChecked', ['checked','indeterminate']);
				$.each(nodes,function(i,node){
					data+="&menuIds="+node.id;
				});
				
				$.ajax({
		            type: "POST",
		            data : data,
		            url: basePath + "n/role/inOrUp",
					error : function(request) {
						parent.closeProgressing();
						$.messager.alert('消息提示',"发送请求错误!",'error');
					},
					success : function(data) {
						parent.closeProgressing();
						$.messager.alert('消息提示',data,'info');
						$('#Win').window('close');
						searchs();
					}
				});
	      };
	}


function addData(){
	  $('#Win').dialog('open').dialog('setTitle','添加角色');
	  $('#fm').form('clear');
	  celarNodes();
	  $('#tt').tree({
		  cascadeCheck : true
	  });
}

function celarNodes(){
	var nodes = $('#tt').tree('getChecked', ['checked','indeterminate']);
	$.each(nodes,function(i,node){
		$('#tt').tree('uncheck',node.target);
	});
}


function editData(){
	var selectRows = $("#roles").datagrid('getChecked');
	if(selectRows.length == 0){
		$.messager.alert('提示','请选择您要修改的行!','info');
	}else if(selectRows.length > 1){
		$.messager.alert('提示','一次只能编辑一条数据!','info');
	}else{
		celarNodes();
		  $('#tt').tree({
			  cascadeCheck : false
		  });
		$('#Win').dialog('open').dialog('setTitle','修改角色');
		$('#fm').form('clear');
		var roleid = selectRows[0].roleid;
		$('#fm').find("input[name='roleid']").val(roleid);
		$('#fm').find("input[name='rolename']").val(selectRows[0].rolename);
		$('#fm').find("input[name='positioncode']").val(selectRows[0].positioncode);
		$('#fm').find("input[name='positionname']").val(selectRows[0].positionname);
		$.post(basePath + "n/roleResource/menusById", {roleid:roleid}, function(data){
			data = jQuery.parseJSON(data);
			$.each(data,function(i,n){
				var node = $('#tt').tree('find', n.resourceId);
				 $('#tt').tree('check',node.target);
			});

		});
	}
}

function deleteData(){
	var selectRows = $("#roles").datagrid('getChecked');
	if(selectRows.length == 0){
		$.messager.alert('提示','请选择您要删除的行!','info');
	}else{
		$.messager.confirm('确认', '您确认删除所选数据吗？', function(r){
			if (r){
				var roleIds = [];
				for(var i=0;i<selectRows.length;i++){
					roleIds.push(selectRows[i].roleid);
				}
				$.post(basePath + "n/role/del", {roleIds:roleIds.join(",")}, function(data){
					$.messager.alert('消息提示',data,'info');

					searchs();
				});
			}
		});
	}
}