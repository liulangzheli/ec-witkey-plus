function doLogin() {
	var loginName = $("#username").val();
	var password = $("#password").val();
  if(loginName===''&&password!==''){
		 $(".error").text('用户名不能为空');
  }
  else if(password===''&&loginName!==''){
		 $(".error").text('密码不能为空');
  }else if(password===''&&loginName===''){
		 $(".error").text('用户名及密码不能为空');
  }else{
	  //tagTransition('#btnLogin','登录中',true);
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
			  $.cookie('adminUserId', text.data.loginSysUserVo.id,{expires:7,path: '/'});
			  $.cookie('adminUserName', text.data.loginSysUserVo.username,{expires:7,path: '/'});
			  $.cookie('adminRoleName',text.data.loginSysUserVo.roleName,{expires:7,path: '/'});
			  $.cookie("ISAdminLOGIN",true,{expires:7,path: '/'});
			  $.cookie("PermissionCodes", text.data.loginSysUserVo.permissionCodes,{expires:7,path: '/'});
			  $.cookie("adminToken", text.data.token,{expires:7,path: '/'});
			  window.location.href = basePath+'sys/sysUser.html';
			  }else{
			  $(".error").text("用户名或者密码错误");
					$.cookie("ISAdminLOGIN", false);
					//tagTransition('#btnLogin','登录',false);
			  }
			  
		  },
		  error: function(text) {
			  alert('登录失败：'+text.code);
			  $.cookie("ISAdminLOGIN", false);
			  //tagTransition('#btnLogin','登录',false)				
			  
		  }
	  });
  }
}

