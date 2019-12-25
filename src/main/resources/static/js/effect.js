
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

function setSelected2(obj,choice,tag){//发布项目设置选项效果
		if(choice=='radio'){
			$(obj).parent().addClass('selected');
			$(obj).parent().siblings().removeClass('selected');
			//alert($(obj).val());
			showChildBox(loadCategory(1,$(obj).val()));
		}else{
			$(obj).parent().removeClass('selected');
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
            url:basePathAPI + "orderBidding/add",
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
            url:basePathAPI + "order.action",
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
            url:basePathAPI + "order.action",
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
            url:basePathAPI + "order.action",
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
            url:basePathAPI + "order.action",
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
            url:basePathAPI + "order.action",
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
  var params=getParamValue('id')||'',searchkey=getParamValue('key')||'',page=$('body').attr('data-page');
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
			showNeedType(loadCategory(0,0));
			showProjectType(loadCategory(2,0));
			//alert("发布项目");
			// CategoryQueryParam={
			// 	"current": 1,
			// 	"keyword": "0",
			// 	"orders": [
			// 	  {
			// 		"asc": true,
			// 		"column": "createTime"
			// 	  }
			// 	],
			// 	"size": 10
			// }
				
			// 	$.ajax({
			// 		type: "POST",
			// 		url: basePathAPI +'category/getPageList',
			// 		beforeSend: function(XMLHttpRequest) {
			// 			XMLHttpRequest.setRequestHeader("token", $.cookie("token"));
			// 		},
			// 		async: false,
			// 		data:JSON.stringify({
			// 			"current": 1,
			// 			"keyword": "0", //查 categoryType = 0
			// 			"orders": [
			// 			  {
			// 				"asc": true,
			// 				"column": "createTime"
			// 			  }
			// 			],
			// 			"size": 10
			// 		}),//JSON.stringify(jsonData), //必须用JSON.stringify()方法转。
			// 		contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
			// 		cache: false,
			// 		success:function(rs) {
			// 			var code = rs.code;
			// 			if (code === 200) {
			// 				res = true;
			// 				alert("类别名称查询成功！");
			// 			}else{
			// 				alert("类别名称查询异常！错误代码：" + rs.code + " " + rs.msg);
			// 			}
			// 		},
			// 		error:function(rs){
			// 			alert("类别名称查询异常！错误代码：" + rs.status + " " + rs.statusText);
			// 		}
			// 	});
			break;
		case "pay"://付款

		    loadData('projectOrder/orderUser',{'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
		    break;				 
		case "projectList"://找项目
			//selectInt();pageid：PROJECT

			loadData('action',{'pageid':'PROJECT','type':"major"}, getMajor, null, false);
			loadData('projectOrder/getPageList',{'pageid':'PROJECT','major': "",'searchkey':params}, getProdList, null, false);
			loadData('sysUser/getPageList',{'pageid':'LIST','type':"topcompany"}, getRankList, null, false);
			loadData('sysUser/getPageList',{'pageid':'LIST','type':"topPerson"}, getRankList, null, false);
			$('.filter a').click(function(){
			      $(this).removeClass('active');
				  $(this).siblings().removeClass('active');
				  $(this).addClass('active');
				  var skey=$(this).text();
				  loadData('sysUser/getPageList',{'pageid':'LIST','searchkey':skey}, getProdList, null, false);
			});
		    break;
		case "projectInfo"://项目详情
			  //项目信息
			  loadData('projectOrder/orderUser',{'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
			  //服务商竞标信息
			  loadData('uiAct/listAll.action',{'pageid':'DETAIL','order_id':params}, getBiddingInfo, null, false);
			  //
		    break;
		case "receipt"://应邀项目
			  loadData('orderBidding/update',{'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
			  loadData('projectOrder/orderUser',{'pageid':'DETAIL','order_id':params}, getEmployer, null, false);
		      break;
		case "working"://提交项目成果
			 loadData('projectOrder/orderUser',{'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
			 loadData('uiAct/listAll.action',{'pageid':'progress','order_id':params}, getProgress, null, false);
		    break;			
		case "check"://验收
			 loadData('action',{'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
			 loadData('orderCheck/infoByOrderId',{'pageid':'progress','order_id':params}, getProgress, null, false);
		    break;						
		case "companyList"://找企业project_type
			selectInt();
			loadData('sysUser/getPageList',{'pageid':'CSERVICE','major':'','province':'','city':'','searchkey':params}, getCompanyList, null, false);
		    break;
		case "personList"://找个人
			loadData('sysUser/getPageList',{'pageid':'PSERVICE','major':'','province':'','city':'','searchkey':params}, getPersonList, null, false);
		    break;
		case "userHome"://用户介绍主页
			loadData('sysUser/getPageList',{'pageid':'SUPPLIERINFO','user_id':params}, getUserInfo, null, false);
		    break;
		case "cRegister"://企业会员注册
		$.validator.setDefaults({
			submitHandler: function () {
				$(this).attr({"value":"提交中,请稍等"});
                //1、先提交图片
				var formData = new FormData();
                formData.append('img', $('#licensePicUpload')[0].files[0]); // 固定格式
                //formData.append('token',$.cookie("token"));
				$.ajax({
                    url:basePathAPI +'upload/',														//后台接收数据地址
                    //headers:{'Content-Type':'multipart/form-data'},//加上这个报错
                    data:formData,
                    type: "POST",
                    dataType: "json",
                    cache: false,			//上传文件无需缓存
                    processData: false,		//用于对data参数进行序列化处理 这里必须false
                    contentType: false,
                    success:function(res) {
						var code = res.code;
						if (code === 200) {
							//alert("图片上传成功！" + res.data.toString());
							$(licensePic).val(res.data.toString());
							//alert("form=" + JSON.stringify($('form').serializeObject()));
							//2、提交注册form表单
							$.ajax({
								type: "POST",
								url: basePathAPI +'sysUser/register/company',
								async: false,
								data:JSON.stringify($('form').serializeObject()), //不上传文件
								contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
								cache: false,
								success: function(result) {
									console.log(result);
									if(result.code === 200) {
										alert("注册成功！");
										firstLogin();
										window.location.href=basePath+'cregister.html';
									}else{
										alert("注册失败! 错误代码：" + result.code + " " + result.msg);
									}
								},
								error: function(rs){
									alert("注册失败! 错误代码：" + rs.status + " " + rs.statusText);
								}
							});
						} else {
							alert("图片上传失败，注册未完成！");
						}
					},
					error:function(rs){
                        alert("图片上传失败，注册未完成！错误代码：" + rs.status + " " + rs.statusText);
                    }
                });
			}
		});
		$( "#companyForm" ).validate( {
				rules: {
                    username: {
						required: true,
						minlength: 4,
						maxlength:50
					},
                    password: {
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
                    phone:{
						required: true,
						minlength: 11,
						maxlength:11
					},
					email: {
						required: true,
						email: true
					},
					licenseId: {
						required: true,
						minlength: 15,
						maxlength:18
					},
					licensePicUpload: "required",
					companyname: "required"
				},
				messages: {
                    username: {
						required: "请输入账号",
						minlength: "账号最小长度为4个字符",
						maxlength:"账号最大长度为50个字符"
					},
                    password: {
						required: "请输入密码",
						minlength: "密码最小长度为6个字符",
						maxlength:"密码名最大长度为16个字符"
					},
					confirm_password: {
						required: "请再次输入确认密码",
						minlength: "密码最小长度为6个字符",
						equalTo: "两次密码不一致"
					},
					email: "请输入有效的邮箱地址",
                    phone: {
						required:"请输入有效的手机号码",
						minlength:"手机号码为11位数字",
						maxlength:"手机号码为11位数字"
						},
					licenseId: {
						required:"请输入企业营业执照注册号(统一社会信用代码)",
						minlength:"机构代码最小长度为15位字符",
						maxlength:"机构代码最小长度为最大长度为18位字符"
						},
					companyname:"请输入企业名称",
					licensePicUpload:"请上传营业执照扫描件",
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
                	$(this).attr({"value":"提交中,请稍等"});
                	//alert("idFrontUploadPath="+ $('#idFrontUploadPath').val());
					//alert("idBackUploadPath="+ $('#idBackUploadPath').val());
                    //1、先提交图片
                    var formData = new FormData();
                    formData.append('img', $('#idFrontUploadPath')[0].files[0]); // 固定格式
                    formData.append('img', $('#idBackUploadPath')[0].files[0]); // 固定格式
                    //formData.append('token',$.cookie("token"));
                    $.ajax({
                        url:basePathAPI +'upload/uploadFiles',														//后台接收数据地址
                        //headers:{'Content-Type':'multipart/form-data'},//加上这个报错
                        data:formData,
                        type: "POST",
                        dataType: "json",
                        cache: false,			//上传文件无需缓存
                        processData: false,		//用于对data参数进行序列化处理 这里必须false
                        contentType: false,
                        success:function(res) {
                            var code = res.code;
                            if (code === 200) {
                                //alert("图片上传成功！" );
                                $(idFront).val(res.data[0]);
								$(idBack).val(res.data[1]);
								//$(idBack).val(res.data[1].toString());
                                //alert("form=" + JSON.stringify($('form').serializeObject()));
                                //2、提交注册form表单
                                $.ajax({
                                    type: "POST",
                                    url: basePathAPI +'sysUser/register/personal',
                                    async: false,
                                    data:JSON.stringify($('form').serializeObject()), //不上传文件
                                    contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
                                    cache: false,
                                    success: function(result) {
                                        console.log(result);
                                        if(result.code === 200) {
                                            alert("注册成功！");
                                            firstLogin();
                                            window.location.href=basePath+'pregister.html';
                                        }else{
                                            alert("注册失败! 错误代码：" + result.code + "(" + result.msg + ")");
                                        }
                                    },
									error:function(rs){
                                    	alert("注册异常！错误代码：" + rs.status + " " + rs.statusText);
										$("#registersubmit").text("同意协议并注册");
                                    }
                                });
                            } else {
                                alert("图片上传失败，注册未完成！");
                            }
                        },
                        error:function(rs){
                            alert("图片上传失败，注册未完成！错误代码：" + rs.status + " " + rs.statusText);
                        }
                    });
                    }
            } );
            $( "#formpersonal" ).validate( {
                rules: {
					username: {
                        required: true,
                        minlength: 4,
                        maxlength:50
                    },
					password: {
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
					phone:{
                        required: true,
                        minlength: 11,
                        maxlength:11,
                    },
                    email: {
                        required: true,
                        email: true
                    },
					idNum: {
                        required: true,
                        minlength: 15,
                        maxlength:18,
                    },
					idFrontUploadPath: "required",
					idBackUploadPath: "required",
					agree: "required"
                },
                messages: {
					username: {
                        required: "请输入用户名",
                        minlength: "用户名最小长度为4个字符",
                        maxlength:"用户名最大长度为50个字符",
                    },
					password: {
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
					phone: {
                        required:"请输入有效的手机号码",
                        minlength:"手机号码为11位数字",
                        maxlength:"手机号码为11位数字"
                    },
					idNum: {
                        required:"请输入身份证号",
                        minlength:"最小长度为15位字符",
                        maxlength:"最大长度为18位字符"
                    },
					idFrontUploadPath:"请上传身份证正面",
					idBackUploadPath:"请上传身份证背面",
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
						url:basePathAPI + "verifyCode",
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
						url:basePathAPI + "verifyCode",
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
						url:basePathAPI + "setPwd",
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

function checkFloor1(){
	var rs = false;
	var hasNeedType = false;
	var hasChildType = false;
    for (var i = 0; i < $("[name='needType']").length; i++) {
        if($("[name='needType']:eq("+i+")").prop("checked") == true) {
            hasNeedType = true;
			//alert($("[name='needType']:eq(" + i + ")").val());
			for (var j = 0; j < $("[name='childType']").length; j++) {
				if($("[name='childType']:eq("+j+")").prop("checked") == true) {
					hasChildType = true;
					//alert($("[name='childType']:eq(" + j + ")").val());
				}
			}
        }
    }
    if(hasNeedType && hasChildType)
        showBox('floor2','state');
	else
	if(!hasNeedType){
		alert("请至少选择一个项目用途！");
	}else
	if(!hasChildType){
		alert("请至少选择一个需求分类！");
	}
}

function doAddCategory(){
	var res = false;
	var formData = $('form').serializeObject();
	//start 单个类别提交
	var categoryFormData = new FormData();
	categoryFormData.append('cateName', formData.childType);
	categoryFormData.append('cateParentId',0);
	categoryFormData.append('categoryType',0);
	categoryFormData.append('intro',formData.childType);
	categoryFormData.append('remark','');
	categoryFormData.append('sort',0);
	
	var jsonData = {};
	categoryFormData.forEach((value, key) => jsonData[key] = value);
	
	$.ajax({
		type: "POST",
		url: basePathAPI +'category/add',
		beforeSend: function(XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("token", $.cookie("token"));
        },
		async: false,
		data:JSON.stringify(jsonData), //必须用JSON.stringify()方法转。
		contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
		cache: false,
		success:function(rs) {
			var code = rs.code;
			if (code === 200) {
				//todo
				res = true;
				alert("类别管理保存成功！");

			}else{
				//todo
				alert("类别管理保存异常！错误代码：" + rs.code + " " + rs.msg);
			}
		},
		error:function(rs){
			alert("类别管理保存异常！错误代码：" + rs.status + " " + rs.statusText);
		}
	});
	return res;
	//end
}

function loadCategory(categoryType,cateParentId=null){
	var records = null;
	var queryParam = {
		'categoryType':categoryType,
		'cateParentId':cateParentId,
		"size": 50   //先按这个大小查。后续需新增不限size的接口
	};
	
	$.ajax({
		type: "POST",
		url: basePathAPI +'category/getPageList',
		beforeSend: function(XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("token", $.cookie("token"));
        },
		async: false,
		data:JSON.stringify(queryParam), //必须用JSON.stringify()方法转。
		contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
		cache: false,
		success:function(rs) {
			var code = rs.code;
			if (code === 200) {
				// for(i=0;i<rs.data.total;i++){
				// 	alert("类别管理内容：" + rs.data.records[i].id + " " + rs.data.records[i].cateName);
				// }
				records = rs.data.records;
				//alert("类别管理查询成功！");
			}else{
				alert("类别管理查询异常！错误代码：" + rs.code + " " + rs.msg);
			}
		},
		error:function(rs){
			alert("类别管理查询异常！错误代码：" + rs.status + " " + rs.statusText);
		}
	});
	return records;
}

function showNeedType(data){
	if(data!=null&&data!=undefined){
		var _str='<b>&nbsp;</b>';
		for(i=0;i<data.length;i++){
			_str+='<label for="needType' + i + '">' + data[i].cateName			
				+'<input type="radio" name="needType" id="needType' + i + '" value="'+ data[i].id 
				+'" onclick="setSelected2(this,\'radio\','+ i 
				+')" /></label>&nbsp;';
		}
		$('#needType').empty().append(_str);
	}
}

function showChildBox(data){
	if(data!=null&&data!=undefined){
		var _str='';
		for(i=0;i<data.length;i++){
			_str+='<label for="childType' + i + '" class="c"><input type="radio" name="childType" id="childType' 
				+ i + '" value="' + data[i].id +'"/>'			
				+ data[i].cateName + '</label>';
		}
		$('#childBox').empty().append(_str);
	}
}

function showProjectRequirement(projectTypeName,indexId,data){
	var _str = '';
	if(projectTypeName!=null&&projectTypeName!=undefined&&data!=null&&data!=undefined){
		_str='<div><b>'+projectTypeName+'：</b>';
		for(var j=0;j<data.length;j++){
			_str+='<label>'+data[j].cateName +'<input type="checkbox" contype="0" name="pro_'+indexId+'_type" id="pro_'+indexId+'_type' + j + '" value="'+ data[j].id +'" onclick="setSelected(this,\'checkbox\')"/></label>&nbsp;'
                 + '<div class="modal-dialog-box">'
                 + '<div class="modal-dialog">'
                 + '<h3>项目类型：<span>'+projectTypeName+'</span></h3>'
                 + '<div class="dd8 marA">'
                 + '<table><tr><td align="right">单体数量：</td>'
                 + '<td><input type="text" name="pro_'+indexId+'_type' + j + '_qty" value="1" /></td></tr>'
                 + '<tr><td align="right">地上总建筑面积：</td>'
                 + '<td><input type="number" name="pro_'+indexId+'_type' + j + '_area"/>平米</td></tr>'
                 + '<tr><td colspan="2" align="left">说明：</td></tr>'
                 + '<tr><td colspan="2" align="left">1、确认后，可继续选择其他项目类型 2、如有地下部分（车库、地下室等），请单独添加地下部分项目类型。注意：基础层不需要单独输入。</td></tr>'
                 + '<tr><td align="center"><a href="javascript:void(0)" onclick="showBox(\'modal-dialog-box\',\'pro_'+indexId+'_type' + j + '\',1)"class="greyButton pdLR ">关闭</a></td>'
                 + '<td align="center"><a href="javascript:void(0)" onclick="showBox(\'modal-dialog-box\',\'pro_'+indexId+'_type' + j + '\',1)"class="orangeButton pdLR">确认</a></td>'
				 + '</tr></table></div></div></div>';
		}
		_str += '</div>';
		if(data.length === 0)
			_str = '';
		//$('#projectType').empty().append(_str);
	}
	return _str;
}

function showProjectType(data){
	if(data!=null&&data!=undefined){
		var _str = '';
		for(var i=0;i<data.length;i++){
			for(var j=5;j<=22;j++){ //目前，先根据category表来的。
				_str += showProjectRequirement(data[i].cateName,i,loadCategory(j,data[i].id));
			}
		}
		$('#projectType').empty().append(_str);
	}
}

function doAddProjectRequirement(orderId){
	var res = false;
	ProjectRequirement={
		"categoryId0": 0,
		"categoryId": 0,
		"amount": 0,
		"area": 0,
		"countType": 0,
		"orderId": 0,
		"qty": 0,
		"remark": ""
	};
	var formData = $('form').serializeObject();
	var resNum = 0;
    var data = loadCategory(2,0);//项目类型
	for (var pi = 0; pi < data.length; pi++) {
		for (var i = 0; i < $("[name='pro_"+pi+"_type']").length; i++) {
			if($("[name='pro_"+pi+"_type']:eq("+i+")").prop("checked") == true) {
				ProjectRequirement.orderId = orderId;
				ProjectRequirement.categoryId0 = data[pi].id;
				ProjectRequirement.categoryId = $("[name='pro_"+pi+"_type']:eq(" + i + ")").val();
				ProjectRequirement.qty = $("[name='pro_"+pi+"_type" + i + "_qty']:eq(0)").val(); 
				ProjectRequirement.area = $("[name='pro_"+pi+"_type" + i + "_area']:eq(0)").val();
				if(projectRequirementSave(ProjectRequirement)){
					resNum ++;
				}
					
			}
		}
	}
	if(resNum > 0)
		res = true;
	return res;
	//内部通用方法
	function projectRequirementSave(PRForm) {
		var  res = false;
		$.ajax({
			type: "POST",
			url: basePathAPI + 'projectRequirement/add',
			beforeSend: function (XMLHttpRequest) {
				XMLHttpRequest.setRequestHeader("token", $.cookie("token"));
			},
			async: false,
			data: JSON.stringify(PRForm),
			contentType: "application/json",
			cache: false,
			success: function (rs) {
				var code = rs.code;
				if (code === 200) {
					res = true;
				}
				else {
					alert("项目要求保存异常！错误代码：" + rs.code + " " + rs.msg);
				}
			},
			error: function (rs) {
				alert("项目要求保存异常！错误代码：" + rs.status + " " + rs.statusText);
			}
		});
		return res;
	}
}

function doAddSource(orderId){
	var res = false;
	//start 单个文件上传
	var sourceFormData = new FormData();
	sourceFormData.append('img', $('#sourceUploadPath')[0].files[0]); 
	$.ajax({
		url:basePathAPI +'upload/',														//后台接收数据地址
		//headers:{'Content-Type':'multipart/form-data'},//加上这个报错
		data:sourceFormData,
		type: "POST",
		dataType: "json",
		cache: false,			//上传文件无需缓存
		async: false,
		processData: false,		//用于对data参数进行序列化处理 这里必须false
		contentType: false,
		success:function(rs) {
			var code = rs.code;
			if (code === 200) {
				//文件上传成功后
				$('source').val(rs.data.toString());
				var formData = $('form').serializeObject();
				//获取文件相关属性 start
				var filePath = rs.data.toString();
				var originalName = $('#sourceUploadPath')[0].files[0].name;
				var format = originalName.substr(originalName.lastIndexOf(".")).toLowerCase();
				var size = $('#sourceUploadPath')[0].files[0].size;
				// end
				var sourceData = new FormData();
				sourceData.append('originalName', originalName);
				sourceData.append('sourceName',filePath);
				sourceData.append('format',format);
				sourceData.append('size',size);
				sourceData.append('orderId',orderId);
				sourceData.append('remark','');
				
				var jsonData = {};
				sourceData.forEach((value, key) => jsonData[key] = value);
				
				$.ajax({
					type: "POST",
					url: basePathAPI +'projectSource/add',
					beforeSend: function(XMLHttpRequest) {
						XMLHttpRequest.setRequestHeader("token", $.cookie("token"));
					},
					async: false,
					data:JSON.stringify(jsonData), //必须用JSON.stringify()方法转。
					contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
					cache: false,
					success:function(rs) {
						var code = rs.code;
						if (code === 200) {
							res = true;
							//alert("项目资料保存成功！");
						}else{
							alert("项目资料保存异常！错误代码：" + rs.code + " " + rs.msg);
						}
					},
					error:function(rs){
						alert("项目资料保存异常！错误代码：" + rs.status + " " + rs.statusText);
					}
				});
			}else{
				alert("文件上传失败！错误代码：" + rs.code + " " + rs.msg);
			}
		},
		error:function(rs){
			alert("文件上传失败！错误代码：" + rs.status + " " + rs.statusText);
		}
	});
	return res;
	//end
}


function doAddProject(){
	//1、提交form表单
    projectOrder={
		"useType":0,
		"categoryId": 0,
  		"checkTime": "",
  		"createTime": "",
  		"endTime": "",
  		"examineTime": "",
  		"intro": "",
  		"major": "",
		"payTime": "",
		"amount":0,
  		"period": 0,
  		"pickTime": "",
		"province": "",
		"city": "",
		"zone":"",
  		"remark": "",
  		"softName": "",
  		"softSupplier": "",
  		"state": 0,
  		"userId": 0
	}
	var formData = $('form').serializeObject();

	projectOrder.useType = formData.needType;
	projectOrder.categoryId = formData.childType;
	projectOrder.endTime = formData.endTime;
	projectOrder.intro = formData.intro;
	//项目专业
	var _major = '';
	for(var pi=0;pi<8;pi++){//默认8个专业
		for (var i = 0; i < $("[name='major_"+pi+"_type']").length; i++) {
			if($("[name='major_"+pi+"_type']:eq("+i+")").prop("checked") == true) {
				switch(pi){
					case 0:
						_major += "土建：" + $("[name='major_"+pi+"_type']:eq(" + i + ")").val() + "|";
						break;
					case 1:
						_major += "钢构：" + $("[name='major_"+pi+"_type']:eq(" + i + ")").val() + "|";
						break;
					case 2:
						_major += "外墙装修：" + $("[name='major_"+pi+"_type']:eq(" + i + ")").val() + "|";
						break;
					case 3:
						_major += "室内装修：" + $("[name='major_"+pi+"_type']:eq(" + i + ")").val() + "|";
						break;
					case 4:
						_major += "钢筋：" + $("[name='major_"+pi+"_type']:eq(" + i + ")").val() + "|";
						break;
					case 5:
						_major += "给水排水：" + $("[name='major_"+pi+"_type']:eq(" + i + ")").val() + "|";
						break;
					case 6:
						_major += "暖通燃气：" + $("[name='major_"+pi+"_type']:eq(" + i + ")").val() + "|";
						break;
					case 7:
						_major += "电气消防：" + $("[name='major_"+pi+"_type']:eq(" + i + ")").val() + "|";
						break;
				}	
			}
		}
	}
	projectOrder.major = _major;

	projectOrder.amount = formData.amount;
	projectOrder.period = formData.period;
	projectOrder.province = formData.province;
	projectOrder.city = formData.city;
	projectOrder.zone = formData.zone;//地区，数据库暂无该字段。
	projectOrder.remark = "";
	projectOrder.softName = formData.softName;
	projectOrder.softSupplier = formData.softSupplier;
	projectOrder.state = 0;
	projectOrder.userId = $.cookie("userId");
	
	$.ajax({
		type: "POST",
		url: basePathAPI +'projectOrder/insert',
		beforeSend: function(XMLHttpRequest) {
			XMLHttpRequest.setRequestHeader("token", $.cookie("token"));
		},
		async: false,
		data:JSON.stringify(projectOrder), //必须用JSON.stringify()方法转。
		contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
		cache: false,
		success:function(rs) {
			var code = rs.code;
			if (code === 200) {
				res = rs.data.toString();//返回orderId
				var dPJRRes = doAddProjectRequirement(res);
				var ASRes = doAddSource(res);
				if(ASRes && dPJRRes)
					alert("项目发布保存成功，请等待后台审核后，再对外发布！");
				else
					alert("项目发布保存成功。但，附件上传失败！");
			}else{
				alert("项目发布保存异常！错误代码：" + rs.code + " " + rs.msg);
			}
		},
		error:function(rs){
			alert("项目发布保存异常！错误代码：" + rs.status + " " + rs.statusText);
		}
	});
}
