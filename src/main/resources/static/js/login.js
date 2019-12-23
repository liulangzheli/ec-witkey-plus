function doLogin() {
    var loginName = $("#username").val();
    var password = $("#password").val();
	var isKeep=$("#keep").is(":checked");//判断是否被选中
	if(loginName===''&&password!==''){
	     $(".error").text('用户名不能为空');
	}
	else if(password===''&&loginName!==''){
	     $(".error").text('密码不能为空');
	}else if(password===''&&loginName===''){
	     $(".error").text('用户名及密码不能为空');
	}else{
		tagTransition('#btnLogin','登录中',true);
 		$.ajax({
			type: "POST",
			url: basePathAPI + "login",
			async: false, // true:异动 false：同步
			data: JSON.stringify({
            "username": loginName,
            "password": password
    	    }),
			contentType:"application/json",
			cache: false,
			success: function(text) {
				if(text.code===200){
				$.cookie('userId', text.data.loginSysUserVo.id,{expires:7,path: '/'});
				$.cookie('userName', text.data.loginSysUserVo.username,{expires:7,path: '/'});
				$.cookie('roleName',text.data.loginSysUserVo.roleName,{expires:7,path: '/'});
				$.cookie("ISLOGIN",true,{expires:7,path: '/'});
				$.cookie("PermissionCodes", text.data.loginSysUserVo.permissionCodes,{expires:7,path: '/'});
				$.cookie("token", text.data.token,{expires:7,path: '/'});
				window.location.href=basePath+'index.html';
				//if (window.lastAction != undefined || window.lastAction != null){
//					doLastAction(window.lastAction);
//					delete window.lastAction;
//				}
				}else{
				$(".error").text("用户名或者密码错误");
				    $.cookie("ISLOGIN", false);
				    tagTransition('#btnLogin','登录',false);
				}
				
			},
			error: function(text) {
				alert('登录失败：'+text.code);
				$.cookie("ISLOGIN", false);
				tagTransition('#btnLogin','登录',false)				
				
			}
		});
	}
}
function firstLogin(args){
		$.ajax({
			url: basePath + "uiAct/handle.action",
			async: false, // true:异步 false：同步
			data: {
				"loginName": $("#username").val(),
				"loginPassword": $("#pwd").val()
			},
			cache: false,
			success: function(text) {
				getcommLoginInfo(text.data);
			},
			error: function(text) {
			}
		});
}
// JavaScript Document
function doLoginOut() {//退出
	$.ajax({
		url : basePathAPI + "logout",
		type : "POST",
		cache : false,
		success : function(data) {
			$.cookie("ISLOGIN", null);
			//$.cookie("USERINFO", null);
            $.cookie('userId', null);
            $.cookie('userName', null);
            $.cookie('roleName',null);
			$.cookie('token',null);
			// $("#topUser").text('登录');
			// $("#topUser").attr('href','login.html');
			// $("#topLog").text('注册');
			// $("#topLog").attr('href','register.html');
			window.location.href=basePath+'login.html';
		},
		error : function(text) {
			 alert(text);
		}
	});
}
function getKeepInfo(data,args){//获取keepId://{"keepId":"4fc831b080a84c259ff1c0f63d620a0a"}

	if (data != undefined) {
		data=data.NData;
		data=data[0].dataInfo;
		var keepId=data;
	$.cookie("keepId",keepId);
	//下一步：下次打开商城时判断缓存中是否有keepId，如果有则调用uiAct/login.action自动登录且再次提交keepId及缓存新的keepId
}
}
function changeValidateCode(self) {
	var timenow = new Date().getTime();
	self.src = basePath + "vcAct/vc.action?d=" + timenow;
}

/*function formatData(data) {
	data = data.NData;
	data = data[0].dataInfo;
	return data[0];
}

function formatDataEx(data, index) {
	data = data.Message;
	data = data.message;
	return data;
}*/

// 执行上次动作
function doLastAction(self) {
	$(self).trigger('click');
}
function checkLogin(e) {
	if (e !== undefined)
		window.lastAction = e.target;
		if ($.cookie("ISLOGIN") === null || $.cookie("ISLOGIN") === undefined
				|| $.cookie("ISLOGIN") === "false" || !$.cookie("ISLOGIN")) {
			return false;
		} else {
			if ($.cookie('userId') !== null && $.cookie('userId') !== undefined
				&& $.cookie('userId') !== '')
				return true;
		}
}
//提交订单检查是否登录并提交数据
function validateLogin(self, event) {
	if (checkLogin(event)) {		
		var formdata = new FormData();
		formdata.append('user_id',$.cookie('userId'));
		formdata.append('use_type',$("input[name=needType]:checked").val());
		formdata.append('cate_id',$("input[name=childType]:checked").val());
		formdata.append('province',$("select[name=province]:checked").val());
		formdata.append('city',$("select[name=city]:checked").val());
		formdata.append('zone',$("select[name=zone]:checked").val());
		formdata.append('period',$("input[name=period]").val());
		formdata.append('soft_supplier',$("input[name=soft_supplier]").val());
		formdata.append('soft_name',$("input[name=soft_name]").val());
		formdata.append('intro',$("textarea[name=intro]").val());
		formdata.append('amount',$("input[name=amount]").val());
		var proType = new Array();
		$('#projectType :checkbox[checked]').each(function(i){			
	        var cate_id=$(this).attr('name'),qty=$(this).attr('qty'),connt_type=$(this).attr('contype'),
			area=$(this).attr('area'),amount=$(this).attr('amount');
			arr[i]={'cate_id':cate_id,'qty':qty,'connt_type':connt_type,'area':area,'amount':amount};
		});
		formdata.append('projectType',proType);
		var major = new Array();
		$('#major :checkbox[checked]').each(function(i){
			 major[i]=$(this).val();
		});
		formdata.append('major',major);
		formdata.append("source",$("input[name=source]:checked")[0]);
		$.ajax({
            type: "POST",
            url:basePath + "projectOrder/add",
            contentType: false,
			processData:false,
            data: formdata,
            success: function(result) {
					window.location.href=basePath+"pay.html?id="+result.orderId;				
            },
            error:function(){
			}
        });
	}
}

// 登入超时
function clearToLogin() {
	$.removeCookie("ISLOGIN");
	$.removeCookie("userId");
}

function getcommLoginInfo(data) {
	if (data !== undefined && !$.isEmptyObject(data)) {
		var loginInfo = '';
		var homeData = data;
		if (data.loginSysUserVo !== undefined) {
			if (data.loginSysUserVo.length === 0) {
				clearToLogin();
				return;
			}
			loginInfo = data.loginSysUserVo;
		} else if (data.data.loginSysUserVo !== undefined) {
			loginInfo = data.loginSysUserVo;
		} else
			loginInfo = data.loginSysUserVo;
			$("#topUser").text(loginInfo.loginName);
			$("#topUser").attr('href','mcenter.html');
			$("#topLog").text('[退出]');
			$("#topLog").attr('href','javascript:void(0)');
			$("#topLog").attr('onclick','doLoginOut()');
		switch ($('body').attr('data-page')) {
		case "mhome":
			$("#URName").text(loginInfo.loginName);
			getAccountScore(homeData);
			break;
		case "userHome":

			break;
		}
		saveUInfotoCookie(loginInfo);
	} else
		clearToLogin();
}

//index.html 页面是否已登录状态检查
$(document).ready(function(){
    // 执行代码
    if ($.cookie('userId') !== null && $.cookie('userId') !== undefined
        && $.cookie('userId') !== ''){
        var username = $.cookie('userName');
        var rolename = $.cookie('roleName');
        $("#topUser").text('[' + username + '|'+ rolename + ']');
        $("#topUser").attr('href','mcenter.html');
        $("#topLog").text('[退出]');
        $("#topLog").attr('href','javascript:void(this)');
        $("#topLog").attr('onclick','doLoginOut()');
    } else
        clearToLogin();
});
function checkLoginInfo() {
    if ($.cookie('userId') !== null && $.cookie('userId') !== undefined
        && $.cookie('userId') !== ''){
        var username = $.cookie('userName');
        var rolename = $.cookie('roleName');
        $("#topUser").text('[' + username + '|'+ rolename + ']');
        $("#topUser").attr('href','mcenter.html');
        $("#topLog").text('[退出]');
        $("#topLog").attr('href','javascript:void(0)');
        $("#topLog").attr('onclick','doLoginOut()');
    } else
        clearToLogin();
}



function transToSearchUrl() {
	var searchValue = encodeURIComponent($("#searchText").val());
	window.location.href = basePath + "ss.html?id=" + searchValue;
}
