<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="inc/header.jsp"%>
<%@ include file="inc/resource.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>国美恒信售后系统</title>
<script src="${ctx}/js/placeholder.js"></script>
<link rel="stylesheet" type="text/css" href="css/backstagelogin.css">
</head>

<body>
	<div style="background-image: url(images/user/background.jpg)" class="pagebg"></div>
	<div class="loginbtn">
		<a></a>
	</div>
	<div class="login" style="display: none;">
		<div class="logindiv">
			<form id="baseForm" name="baseForm" method="post">
				<input type="hidden" name="indexRandomCode" class="textbox" value="3456"></input>
				<input type="hidden" name="needRandomCode" class="textbox" value="0"></input>
				<div class="loginbox">
					<ul>
						<li><input id="indexLoginId" name="indexLoginId" type="text" class="inputbox inputTxtByName" placeholder="用户名" onChange="queryPositions(this);"/></li>
						<li>
							<input id="pwd" name="pwd" type="text" class="inputbox inputTxtByPwd" placeholder="密码" />
							<input id="indexLoginPwd" name="indexLoginPwd" type="password" class="inputbox inputTxtByPwd" placeholder="密码" style="display:none;"/>
						</li>
						<!--  
						<li>
							<select id="indexLoginType" name="indexLoginType" style="width:300px;height:40px;" editable="false" class="easyui-combobox" >
								<option value="01" selected>国美用户</option>
								<option value="02">第三方网点用户</option>
								<option value="03">系统自建用户</option>
							</select>
						</li>
						-->
						<li><input id="positionId" name="positionId" type="text" editable="true" class="easyui-combobox" value="" data-options=""></li>
						<li><input id="indexVerificationcode" name="indexVerificationcode" type="text" maxlength="4" class="inputbox inputTxtByName" placeholder="验证码" style="width:174px;"/>&nbsp;<img align= "absmiddle" src="${ctx}/GoogleImage" id="authImage" style="cursor:hand; height:38px;" onclick="changeImage();return false;"; title="看不清,换一张" /></li>
						<li><input type="button" value="立即登录" class="loginsubmit" onclick="loginSubmit();" /></li>
					</ul>
				</div>
			</form>
		</div>
	</div>

	<div class="footer">
		<label>国美电器股份有限公司</label>
	</div>
	
	<div style="display: none; height: 0px;">
		<a id="baseHref" href="" target="hiddenFrame"></a>
		<iframe name="hiddenFrame" id="hiddenFrame" style="display: none;"/></iframe>
	</div>
</body>
</html>


<script type="text/javascript">
    var animation = {//动画部分 从jQuery剥离
        "swing": function (p) {
            return 0.5 - Math.cos(p * Math.PI) / 2;
        },
        "chang": 200,
        "rate": 25
    };
    
    var flag = 1;
   
    
    $(".login").bind("click", function (event) {
        if (window.event) {
            window.event.cancelBubble = true;
        } else {
            event.stopPropagation();
        }
    });
    $(".loginbtn").bind("click", function (event) {
    	if (flag == -1)$(".pagebg").click();
    	
        if (flag == 1) {
            flag = 0;
            if (window.event) {
                window.event.cancelBubble = true;
            } else {
                event.stopPropagation();
            }
            event.stopPropagation();
            var _conts = 141;
            var h = $(this).height();
            var t = $(this).position().top;
            var ml = $(this).css("margin-top").replace("px", "") * 1;
            var _logTop = t + ml + h + 60;
            $(".login").css("top", _logTop);
            var _logHeight = $(window).height() - _logTop + _conts;
            $(".login").height(0);
            $(".login").css("display", "");
            $(".login").css("overflow", "hidden");
            var end = animation.chang;
            var start = 0;
            var cur = 0;
            var step = animation.rate;
            //$(".login").fadeIn(step);
            var timer = setInterval(function () {
                cur += step;
                var ant = animation.swing(cur / (end - start)) * _conts;
                var anh = animation.swing(cur / (end - start)) * _logHeight;
                var __top = t - ant;
                var __logTop = _logTop - ant;
                $(".loginbtn").css("top", __top + "px");
                $(".login").css("top", __logTop + "px");
                $(".login").height(anh);
                if (cur == end) {
                    clearInterval(timer);
                    $(".login").css("overflow", "");
                    $(".login").css("top", "");
                    flag = -1;
                }
            }, step);
        }
    });
    
    $(function() {
    	//特殊处理type是password的情况，以支持placeholder属性
		var pwd = $("#pwd");
		var password = $("#indexLoginPwd");
		pwd.focus(function() {
			pwd.hide();
			password.show().focus();
		});
		password.focusout(function() {
			if (password.val() == "") {
				password.hide();
				pwd.show();
			}
		});

		$(".combo-text").css("width", "266px");
		$(".combo").css("width", "300px");
		$(".combo-arrow").css("width", "35px");
		//初始宽度和高度
		$('#positionId').combobox({
			width : 300,
			height : 40
		});
	});

	function loginSubmit() {
		var browserFlag = false;
		var userAgent = navigator.userAgent.toLowerCase(), s, o = {};
		var browser = {
			version : (userAgent
					.match(/(?:firefox|opera|safari|chrome|msie)[\/: ]([\d.]+)/))[1],
			safari : /version.+safari/.test(userAgent),
			chrome : /chrome/.test(userAgent),
			firefox : /firefox/.test(userAgent),
			ie : /msie/.test(userAgent),
			opera : /opera/.test(userAgent)
		} /* 获得浏览器的名称及版本信息 */

		if (browser.safari) {
		} /* 判断是否为safari */
		if (browser.firefox) {
		} /* 判断是否为firefox */
		if (browser.chrome) {
		} /* 判断是否为chrome */
		if (browser.opera) {
		} /* 判断是否为opera */
		if (browser.ie) {/* 判断是否为IE */
			if (browser.ie && browser.version < 8) {
				alert("您使用的IE浏览器版本是： " + browser.version
						+ ",浏览器版本过低会导致系统存在兼容性问题,建议您升级浏览器，或者使用firefox浏览器。");
				if (window.confirm('您确定要使用firefox浏览器吗？')) {
					window.location.href = "http://download.firefox.com.cn/releases/stub/official/zh-CN/Firefox-latest.exe";
				}
			} else {
				browserFlag = true;
			}
		} else {
			browserFlag = true;
		}
		if (browserFlag) {
			//默认把提示短语提交的校验
			if($("#indexLoginId").val()=='用户名'){
				$("#indexLoginId").val("");
			}
			if($("#indexVerificationcode").val()=='验证码'){
				$("#indexVerificationcode").val("");
			}
			$.post("${ctx}/login", $('#baseForm').serialize(), function(msg) {
				if ($.parseJSON(msg).flag == "loginIdNull") {
					$.messager.alert('提示:', '用户名为空!');
				} else if ($.parseJSON(msg).flag == "loginPwdNull") {
					$.messager.alert('提示:', '密码为空!');
				} else if ($.parseJSON(msg).flag == "positionNull") {
					$.messager.alert('提示:', '岗位为空!');
				} else if ($.parseJSON(msg).flag == "verificationcodeNull") {
					$.messager.alert('提示:', '验证码为空!');
				} else if ($.parseJSON(msg).flag == "userNull") {
					$.messager.alert('提示:', '用户名不存在!');
				} else if ($.parseJSON(msg).flag == "loginPwdError") {
					$.messager.alert('提示:', '密码输入错误!');
					changeImage();
				} else if ($.parseJSON(msg).flag == "verificationcodeError") {
					$.messager.alert('提示:', '验证码输入错误!');
					changeImage();
				} else if ($.parseJSON(msg).flag == "loginDimission") {
					$.messager.alert('提示:', '该用户已离职!');
					changeImage();
				} else if ($.parseJSON(msg).flag == "loginLock") {
					$.messager.alert('提示:', '账户被锁定,无法登陆系统,请先解锁!');
					changeImage();
				} else if ($.parseJSON(msg).flag == "success") {
					window.location.href = "${ctx}/toValidateAuth";
				}
			});
		}
	}

	if (window.top != window) {
		if (window.top.opener) {
			window.top.opener.document.location.href = window.location.href;
		} else {
			window.top.location = window.location;
		}
	}

	document.onkeydown = function(evt) {
		var evt = window.event ? window.event : evt;
		if (evt.keyCode == 13) {
			loginSubmit();
		}
	}

	$(".pagebg").bind("click", function() {
		if (flag == -1) {
			flag = 0;
			var _conts = 141;
			var h = $(".loginbtn").height();
			var t = $(".loginbtn").position().top;
			var ml = $(".loginbtn").css("margin-top").replace("px", "") * 1;
			var _logTop = t + ml + h + 60;
			$(".login").css("top", _logTop);
			var _logHeight = $(".login").height();
			$(".login").css("display", "");
			$(".login").css("overflow", "hidden");
			var end = animation.chang;
			var start = 0;
			var cur = 0;
			var step = animation.rate;
			var timer = setInterval(function() {
				cur += step;
				var ant = animation.swing(cur / (end - start)) * _conts;
				var anh = animation.swing(cur / (end - start)) * _logHeight;
				var __top = t + ant;
				var __logTop = _logTop + ant;
				$(".loginbtn").css("top", __top + "px");
				$(".login").css("top", __logTop + "px");
				$(".login").height(_logHeight - anh);
				if (cur == end) {
					clearInterval(timer);
					$(".login").css("height", "");
					$(".login").css("display", "none");
					$(".login").css("overflow", "");
					$(".login").css("top", "");
					flag = 1;
				}
			}, step);
		}
	});

	function changeImage() {
		$("#authImage")
				.attr("src", "${ctx}/GoogleImage?currtime=" + new Date());
	}

	function queryPositions(obj) {
		var userAccount = obj.value;
		$('#positionId').combobox({
			url : '${ctx}/hxCode/getPositions?userAccount=' + userAccount,
			width : 300,
			height : 40,
			onLoadSuccess : function(data) {
				if (data) {
					//增加非空判断
					if(data[1] != null){
						var positionTemp = data[1].value;
						if(positionTemp != null&& positionTemp != ''){
							$('#positionId').combobox('setValue', data[1].value);
						}
					}
				}
			}
		});
	}
</script>