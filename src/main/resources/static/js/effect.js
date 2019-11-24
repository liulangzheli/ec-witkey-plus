
//设为首页
function SetHome(obj,url){
    try{
        obj.style.behavior='url(#default#homepage)';
        obj.setHomePage(url);
    }catch(e){
        if(window.netscape){
            try{
                netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
            }catch(e){
                alert("抱歉，此操作被浏览器拒绝！\n\n请在浏览器地址栏输入“about:config”并回车然后将[signed.applets.codebase_principal_support]设置为'true'");
            }
        }else{
            alert("抱歉，您所使用的浏览器无法完成此操作。\n\n您需要手动将【"+url+"】设置为首页。");
        }
    }
}
//收藏本站
function AddFavorite(title, url) {
    try {
        window.external.addFavorite(url, title);
    }
    catch (e) {
        try {
            window.sidebar.addPanel(title, url, "");
        }
        catch (e) {
            alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请使用Ctrl+D进行添加");
        }
    }
}
/* 过渡效果 */
function tagTransition(tag, text, choice) {
	$(tag).attr('disable', choice);
	$(tag).val(text);
	if (choice == true) {
		$(tag).addClass('transition');
		$(tag).addClass('notallow');
	} else {
		$(tag).removeClass('transition');
		$(tag).removeClass('notallow');
	}
}

function setSelected(obj,choice,tag){//发布项目设置选项效果
		if(choice=='radio'){
			$(obj).parent().addClass('selected');
			$(obj).parent().siblings().removeClass('selected');
			$('.childBox').hide();
			$('.childBox'+tag).fadeIn();
		}else if($(obj).is(":checked")&&choice=="checkbox"){
			$(obj).parent().addClass('selected');
			$('.childBox'+tag).fadeIn();
			$(obj).parent().next('.modal-dialog-box').fadeIn();
			$('.modal-dialog-box').height($('body').height());
			var mwidth=window.outerWidth/2-250;
			$('.modal-dialog').css('left',mwidth+'px');
		}else{
			$(obj).parent().removeClass('selected');
		}
}
function showBox(s,h,e){//显示的标签类别，h隐藏的标签类别
	switch(e){
	   case 0://modal-dialog-box弹窗
	   $('.'+s).fadeIn();
	   break;
	   case 1://modal-dialog-box隐藏
	   $('.'+s).fadeOut();
	   if($('body').attr('data-page')=='addProject'){
		   var qty=$("input[name='"+h+"_qty'").val();
		   var area=$("input[name='"+h+"_area'").val();
		    $('#'+h).attr('qty',qty);
		   if($('#'+h).attr('connt_type')==''||$('#'+h).attr('connt_type')==undefined||$('#'+h).attr('connt_type')==1){
		  	  $('#'+h).attr('area',area);
		   }else{
		      $('#'+h).attr('amount',area);
		   }
		}
	   break;	
	   case 2://按钮切换显示
	    $('.'+s).toggle();
	   break;	   
	   default://楼层切换
		   if($('body').attr('data-page')=='addProject'){
		      if($("input[name=needType]:checked").val()=='')
			     alert('请选择项目用途');
			  if( $("input[name=childType]:checked").val()=='')
				 alert('请选择需求分类');
			  if($('#projectType :checkbox[checked]')==0)
			     alert('请选择项目专业');
			  if($("input[name=major]:checked").val()=='')
			     alert('请选择项目专业');
		   }
	       if(h!='')
		    	$('.'+h).hide();
		   if(s!='')
			   $('.'+s).fadeIn();
	   break;
	}
	
}
function showDalog(title,content,tip){//弹窗提示信息
 var _title=title||'';
 var _content=content||'';
 var _tip=tip||'';
 var _str='   <div class="modal-dialog-box">'
     +'    	 <div class="modal-dialog">'
	 +'				<h3>'+_title+'</h3>'
     +'                <div class="dd8 marA">'
     +'                     <table>'
     +'                       <tr><td colspan="2" align="left">'+_content+'</td></tr>'
     +'                       <tr><td colspan="2" align="left" class="tip">'+_tip+'</td></tr>'
     +'                        <tr>'
     +'                       	<td align="center"><a href="javascript:void(0)" onclick="showBox(\'modal-dialog-box\',\'\',1)"class="greyButton dd8 pdLR ">取消</a></td>'
      +'                      	<td align="center"><a href="javascript:void(0)" onclick="beServer()"class="orangeButton dd8 pdLR">确认</a></td>'
      +'                      </tr>'
      +'                   </table>'
      +'              </div>        '                                
      +'         </div>'
      +'       </div>'
   $('body').append(_str);
   showBox('modal-dialog-box','',0);
}
function tab(wrapper,allTabs,tabMenu){//切换效果
  var $wrapper = $(wrapper),
      $allTabs = $wrapper.find(allTabs),
      $tabMenu = $wrapper.find(tabMenu);
	  $allTabs.not(':first-of-type').hide();  
	  $tabMenu.each(function(i) {
		$(this).attr('data-tab', 'tab'+i);
	  });
	  $allTabs.each(function(i) {
		$(this).attr('data-tab', 'tab'+i);
	  });
    $tabMenu.on('click', function() {
    var dataTab = $(this).data('tab'),
        $getWrapper = $(this).closest($wrapper);
    $getWrapper.find($tabMenu).removeClass('active');
    $(this).addClass('active');
    $getWrapper.find($allTabs).hide();
    $getWrapper.find($allTabs).filter('[data-tab='+dataTab+']').show();
  });
}

function bidding(id,user){//竞标
   		$.ajax({
            type: "POST",
            url:basePath + "orderBidding/add",
            contentType: false,
			processData:false,
            data: {'order_id':id,'user_id':user},
            success: function(result) {
					alert('竞标成功')			
            },
            error:function(){
			}
        });
}
function ineedu(id,user){//选标
   		$.ajax({
            type: "POST",
            url:basePath + "order.action",
            contentType: false,
			processData:false,
            data: {'order_id':id,'user_id':user},
            success: function(result) {
					alert('已选标，请等待服务商确认');			
            },
            error:function(){
			}
        });
}
function acceptPro(id,choice){//服务商应邀项目
 	$.ajax({
            type: "POST",
            url:basePath + "order.action",
            contentType: false,
			processData:false,
            data: {'order_id':id,'pageid':'acceptting','isAccept':choice},
            success: function(result) {
					alert('已提交！');			
            },
            error:function(){
			}
        });   
}
function progressCommit(){//进度提交
    var oid=getParamValue('id');
	var formdata = new FormData();
	formdata.append('order_id',oid);
	formdata.append('pageid','sourcecommit');
	formdata.append('intro',$("textarea[name=intro]").val());
	formdata.append("source", $('#file')[0]);
	$.ajax({
            type: "POST",
            url:basePath + "order.action",
            contentType: false,
			processData:false,
            data: formdata,
            success: function(result) {
					alert('已选标，请等待雇主验收！');			
            },
            error:function(){
					alert('提交失败');
			}
        });
}
function confirm(id,tag){//项目验收
  if(tag==1){//验收通过
		$.ajax({
            type: "POST",
            url:basePath + "order.action",
            contentType: false,
			processData:false,
            data: {'pageid':'checksource','check_id':id,'state':1},
            success: function(result) {
					alert('项目完成，佣金已成功打入到服务商账号！');
					window.location=basePath+"index.html";		
            },
            error:function(){
			}
        });  
		
  }else if(tag==2){//驳回
		$.ajax({
            type: "POST",
            url:basePath + "order.action",
            contentType: false,
			processData:false,
            data: {'pageid':'checksource','check_id':id,'state':2},
            success: function(result) {
					alert('已拒绝，佣金已成功打入到服务商账号！');
					window.location=basePath+"index.html";		
            },
            error:function(){
			}
        });        
  }
}
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};
$(document).ready(function() {

 //搜索框效果
  $('.searchTab>div').click(function(){
      $('.searchTab>div').removeClass('active');
	  $(this).addClass('active');
	  if($(this).text()=='项目')
	        $('.search .searchSbt').attr('onclick','transToSearchUrl(0)');
	  else
	        $('.search .searchSbt').attr('onclick','transToSearchUrl(1)');
  });
  var params=getParamValue('id'),searchkey=getParamValue('key'),page=$('body').attr('data-page');
  if(page=="mCenter"||page=="mInfo"||page=="mCrop"||page=="modifyPwd"||
  page=="mOrder"||page=="mCollect"||page=="mTeam"||page=="mTransaction"
  ||page=="mWithdraw"){//会员中心左侧数据加载
 	   $('#beserver').click(function(){//申请为服务商
          showDalog('提示','请确认将该账号申请为服务商账号','备注：服务商账号仅允许在线承接项目，若需发布项目需求，需重新申请账号');
 	   });  
	   //会员信息
       loadData('sysUser/info/'+$.cookie('uid'),{'user_id':$.cookie('uid')}, getUserInfo, null, false);
  }
	if(page=='login'||page=='pRegister'||page=='cRegister')
		checkLogin();
  switch(page) {
     	case "home"://首页
	         break;
		case "addProject"://发布项目
		     
		     break;
		case "pay"://付款
		    var params=getParamValue('id');
		    loadData('uiAct/listAll.action',{'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
		    break;				 
		case "projectList"://找项目
			//selectInt();pageid：PROJECT
			loadData('uiAct/listAll.action',{'pageid':'PROJECT','type':"major"}, getMajor, null, false);
			loadData('uiAct/listAll.action',{'pageid':'PROJECT','type': "project",'searchkey':params}, getProdList, null, false);
			loadData('uiAct/listAll.action',{'pageid':'PROJECT','type':"topcompany"}, getRankList, null, false);
			loadData('uiAct/listAll.action',{'pageid':'PROJECT','type':"topPerson"}, getRankList, null, false);
			$('.filter a').click(function(){
			      $(this).removeClass('active');
				  $(this).siblings().removeClass('active');
				  $(this).addClass('active');
				  var skey=$(this).text();
				  loadData('uiAct/listAll.action',{'pageid':'PROJECT','searchkey':skey}, getProdList, null, false);
			});
		    break;
		case "projectInfo"://项目详情
			  //服务商登录
			  loadData('uiAct/listAll.action',{'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
			  //服务商登录
			  loadData('uiAct/listAll.action',{'pageid':'DETAIL','order_id':params}, getBiddingInfo, null, false);
			  //
		    break;
		case "receipt"://应邀项目
			  loadData('uiAct/listAll.action',{'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
			  loadData('uiAct/listAll.action',{'pageid':'accepting','order_id':params}, getEmployer, null, false);
		      break;
		case "working"://提交项目成果
			var params=getParamValue('id');
			 loadData('uiAct/listAll.action',{'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
			 loadData('uiAct/listAll.action',{'pageid':'progress','order_id':params}, getProgress, null, false);
		    break;			
		case "check"://验收
			 loadData('uiAct/listAll.action',{'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
			 loadData('uiAct/listAll.action',{'pageid':'progress','order_id':params}, getProgress, null, false);
		    break;						
		case "companyList"://找企业
			selectInt();
			loadData('uiAct/listAll.action',{'pageid':'COMPANYLIST'}, getCompanyList, null, false);
		    break;
		case "personList"://找个人
			loadData('uiAct/listAll.action',{'pageid':'PERSONLIST'}, getPersonList, null, false);
		    break;
		case "userHome"://用户介绍主页
			loadData('uiAct/listAll.action',{'pageid':'USERHOME'}, getUserInfo, null, false);
		    break;
		case "cRegister"://企业会员注册
		$.validator.setDefaults( {
			submitHandler: function () {
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
			}
		} );
			$( "#companyForm" ).validate( {
				rules: {
					user_id: {
						required: true,
						minlength: 4,
						maxlength:50
					},
					pwd: {
						required: true,
						minlength: 6,
						maxlength:16
					},
					confirm_password: {
						required: true,
						minlength: 6,
						maxlength:16,
						equalTo: "#password"
					},
					tel:{
						required: true,
						minlength: 11,
						maxlength:11,
					},
					email: {
						required: true,
						email: true
					},
					licence_id: {
						required: true,
						minlength: 15,
						maxlength:18,
					},
					licence_pic: "required",
					company_name: "required"
				},
				messages: {
					user_id: {
						required: "请输入用户名",
						minlength: "用户名最小长度为4个字符",
						maxlength:"用户名最大长度为50个字符",
					},
					pwd: {
						required: "请再次输入确认密码",
						minlength: "密码最小长度为6个字符",
						maxlength:"密码名最大长度为16个字符",
					},
					confirm_password: {
						required: "请再次输入确认密码",
						minlength: "密码最小长度为6个字符",
						equalTo: "两次密码不一致"
					},
					email: "请输入有效的邮箱地址",
					tel: {
						required:"请输入有效的手机号码",
						minlength:"手机号码为11位数字",
						maxlength:"手机号码为11位数字"
						},
					licence_id: {
						required:"请输入企业营业执照注册号(统一社会信用代码)",
						minlength:"机构代码最小长度为15位字符",
						maxlength:"机构代码最小长度为最大长度为18位字符"
						},
					company_name:"请输入企业名称",
					licence_pic:"请上传营业执照扫描件",
					agree: "同意注册协议才可注册"
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					// Add `has-feedback` class to the parent div.form-group
					// in order to add icons to inputs
					element.parents( ".col-sm-5" ).addClass( "has-feedback" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}

					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
					}
				},
				success: function ( label, element ) {
					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
				}
			} );		
		    break;		  	
		case "pRegister"://个人会员信息注册
            $.validator.setDefaults( {
                submitHandler: function () {
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
                }
            } );
            $( "#formpersonal" ).validate( {
                rules: {
                    user_id: {
                        required: true,
                        minlength: 4,
                        maxlength:50
                    },
                    pwd: {
                        required: true,
                        minlength: 6,
                        maxlength:16
                    },
                    confirm_password: {
                        required: true,
                        minlength: 6,
                        maxlength:16,
                        equalTo: "#password"
                    },
                    tel:{
                        required: true,
                        minlength: 11,
                        maxlength:11,
                    },
                    email: {
                        required: true,
                        email: true
                    },
                    id_num: {
                        required: true,
                        minlength: 15,
                        maxlength:18,
                    },
                    id_front: "required",
                    id_back: "required"
                },
                messages: {
                    user_id: {
                        required: "请输入用户名",
                        minlength: "用户名最小长度为4个字符",
                        maxlength:"用户名最大长度为50个字符",
                    },
                    pwd: {
                        required: "请再次输入确认密码",
                        minlength: "密码最小长度为6个字符",
                        maxlength:"密码名最大长度为16个字符",
                    },
                    confirm_password: {
                        required: "请再次输入确认密码",
                        minlength: "密码最小长度为6个字符",
                        equalTo: "两次密码不一致"
                    },
                    email: "请输入有效的邮箱地址",
                    tel: {
                        required:"请输入有效的手机号码",
                        minlength:"手机号码为11位数字",
                        maxlength:"手机号码为11位数字"
                    },
                    id_num: {
                        required:"请输入身份证号",
                        minlength:"最小长度为15位字符",
                        maxlength:"最大长度为18位字符"
                    },
                    id_front:"请上传身份证正面",
                    id_back:"请上传身份证背面",
                    agree: "同意注册协议才可注册"
                },
                errorElement: "em",
                errorPlacement: function ( error, element ) {
                    // Add the `help-block` class to the error element
                    error.addClass( "help-block" );

                    // Add `has-feedback` class to the parent div.form-group
                    // in order to add icons to inputs
                    element.parents( ".col-sm-5" ).addClass( "has-feedback" );

                    if ( element.prop( "type" ) === "checkbox" ) {
                        error.insertAfter( element.parent( "label" ) );
                    } else {
                        error.insertAfter( element );
                    }

                    // Add the span element, if doesn't exists, and apply the icon classes to it.
                    if ( !element.next( "span" )[ 0 ] ) {
                        $( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
                    }
                },
                success: function ( label, element ) {
                    // Add the span element, if doesn't exists, and apply the icon classes to it.
                    if ( !$( element ).next( "span" )[ 0 ] ) {
                        $( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
                    }
                },
                highlight: function ( element, errorClass, validClass ) {
                    $( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
                    $( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
                },
                unhighlight: function ( element, errorClass, validClass ) {
                    $( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
                    $( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
                }
            } );

		    break;		  					
		case "forgetPwd"://找回密码
		   	$('#getCode').click(function(){
				   var user=$('input[name="username"]').val();	
				   var email=$('input[name="email"]').val();	
				    if(user==""||email=='')
					alert('用户和注册邮箱不能为空');
					else
					$.ajax({
						type: "POST",
						url:basePath + "verifyCode",
						contentType: false,
						processData:false,
						data: {'email':email,'user_id':user},
						success: function(result) {
								showBox('f3','state');	
						},
						error:function(){
							
						}
					});
			});	
			$('#checkcode').click(function(){
			    if($('input[name="code"]').val()!=''){
					var user=$('input[name="username"]').val();	
				   var email=$('input[name="email"]').val();
				   var code=$('input[name="code"]').val();	
			  		$.ajax({
						type: "POST",
						url:basePath + "verifyCode",
						contentType: false,
						processData:false,
						data: {'email':email,'user_id':user,'code':code},
						success: function(result) {
								showBox('f4','state');	
						},
						error:function(){
							
						}
					});
				}else
			     alert('验证码不能为空');
			});
			$('#setPwd').click(function(){
				 var pwd=$('input[name="newpwd"]').val();
			    if($('input[name="repeatepwd"]').val()!=pwd){
						alert('啊哦~~两次密码不一致！');
				}else {
				   var user=$('input[name="username"]').val();	
				   var email=$('input[name="email"]').val();
				   var code=$('input[name="code"]').val();	
			  		$.ajax({
						type: "POST",
						url:basePath + "setPwd",
						contentType: false,
						processData:false,
						data: {'user_id':user,'pwd':pwd},
						success: function(result) {
								alert('密码修改成功')	;
								window.location.href=basePath+'login.html';
						},
						error:function(){
							
						}
					});
				}
			     
			});
		    break;		  		
		case "mCenter"://会员中心
					
		    break;		  		
		case "mInfo"://会员信息
		    break;		  	
		case "mCrop"://头像修改
		    break;	
		case "modifyPwd"://密码修改			
		    break;		
		case "mOrder"://我的订单
		    break;		  		
		case "mCollect"://服务商收藏
		    break;		  			
		case "mTeam"://团队成员
		    break;			
		case "mTransaction"://交易明细
		    break;	
		case "mWithdraw"://提现
		    break;									  				  							
  }
 //tab切换 
   $($('.tab-wrapper').length!=0)
  		tab('.tab-wrapper','.tab-content > div','.tab-menu li'); 
});//end ready
