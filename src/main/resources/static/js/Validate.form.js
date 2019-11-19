
//默认下用户名框获得焦点
/*setTimeout(function() {
    $("#username").get(0).focus();
}, 0);*/
//用户名验证
$("#username").jdValidate(validatePrompt.username, validateFunction.username);
//密码验证
$("#pwd").bind("keyup",function(){
	validateFunction.pwdstrength();
}).jdValidate(validatePrompt.pwd, validateFunction.pwd);
//二次密码验证
$("#pwd2").jdValidate(validatePrompt.pwd2, validateFunction.pwd2);
//电话验证
$("#tel").jdValidate(validatePrompt.tel, validateFunction.tel);

//邮箱验证
$("#email").jdValidate(validatePrompt.mail, validateFunction.mail);
/*$("#qq").jdValidate(validatePrompt.qq, validateFunction.qq);*/

//$("#companyname").jdValidate(validatePrompt.companyname,validateFunction.companyname);

 
//表单提交验证和服务器请求
$("#registersubmit").click(function() {
   //var flag = validateFunction.FORM_validate();
	var flag=true;
   var actionUrl='';
		var formdata = new FormData(document.querySelector("form"));
		formdata.append('pageid','personReg');
	if(	$('body').attr('data-page')=='pRegister'){
  		// formdata.append("id_front", $('#idFront')[0].files[0]);
		// formdata.append("id_back",$('#idBack')[0].files[0]);
		actionUrl='sysUser/register/personal';
	}else{
  		// formdata.append("licencePic", $('#licencePic')[0].files[0]);
		actionUrl='sysUser/register/company';
	}
    if (flag) {
        $(this).attr({"value":"提交中,请稍等"});
        $.ajax({
            type: "POST",
            url: basePath+actionUrl,
			processData:false,
			//contentType: false,
			//data: formdata,
			data:JSON.stringify($('form').serializeObject()),//不上传文件
			contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
            success: function(result) {
            	console.log(result)
            	switch(result.retCode){
				case 100000:
					firstLogin();					
				break;
				}

            },
            error:function(text){
				console.log(text);
				alert("提交失败")
			    $("#registersubmit").text("同意协议并注册");
			}
        });
    }
});


function addMailAddress(self){
	try{
		$.cookie.json = "true";
		var memberInfo = $.cookie("USERINFO");
		memberInfo.loginName = memberInfo.loginName;
		memberInfo.email = $("#email").val();
		$.ajax({
			url : basePath + "memberInfoAct/update.action",
			async : false, // true:异动 false：同步
			type : 'POST',
			data : {
				data : encodeURIComponent(JSON.stringify([ memberInfo ]))
			},
			cache : false,
			success : function(text) {
				if(text.retCode != undefined || text.retCode != null){
					$.cookie("USERINFO",memberInfo);
					var args = {};
					args.self = "#tipbox";
					args.aName="false";
					showMessageBox('ok',Resx[240015], ['btnBuy'],args,0);
				}
				else
					alert(Resx[210008]);
			},
			error : function(text) {
			//alert(Resx[210008]);
			}
		});
	}finally{
		$.cookie.json = null;
	}
}
function checkMail(self){
   	var telReg =  /^\w+([-\.]\w+)*@\w+([\.-]\w+)*\.\w{2,4}$/;
	var mail= $("#email").val();
	if(!telReg.test(mail))
	   $(self).next().text('邮箱输入错误');
	else{
	  try{
		$.cookie.json = "true";
		var memberInfo = $.cookie("USERINFO");
	    var args=new Object();
	    args.progId="CM";
		args.loginName = memberInfo.loginName;
		args.email = $("#email").val();
		args.aName="false";
	    loadByActionEx('uiAct/mAct.action',checkMailUnique,args,false)
	  }finally{
		  $.cookie.json = null;
	  }
	}
}
function checkMailUnique(data,args){
	if(data!=undefined){
	  data=data.Message;
	  data=data.message[0];
	  if(data.messageCode==100013)
        addMailAddress();
	  else
	   $('#email').next().next().text('该邮箱已被使用');
	}
}

