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
function confirm(id,tag){
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
  var params=getParamValue('id'),searchkey=getParamValue('key');
  switch($('body').attr('data-page')) {
     	case "home"://首页
	         break;
		case "addProject"://发布项目
		     
		     break;
		case "pay"://付款
		    var params=getParamValue('id');
		    loadData({'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
		    break;				 
		case "projectList"://找项目
			//selectInt();pageid：PROJECT
			var params=getParamValue('key');
			loadData({'pageid':'PROJECT','type':"major"}, getMajor, null, false);
			loadData({'pageid':'PROJECT','type': "project",'searchkey':params}, getProdList, null, false);
			loadData({'pageid':'PROJECT','type':"topcompany"}, getRankList, null, false);
			loadData({'pageid':'PROJECT','type':"topPerson"}, getRankList, null, false);
			$('.filter a').click(function(){
			      $(this).removeClass('active');
				  $(this).siblings().removeClass('active');
				  $(this).addClass('active');
				  var skey=$(this).text();
				  loadData({'pageid':'PROJECT','searchkey':skey}, getProdList, null, false);
			});
		    break;
		case "projectInfo"://项目详情
			  //服务商登录
			  loadData({'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
			  //服务商登录
			  loadData({'pageid':'DETAIL','order_id':params}, getBiddingInfo, null, false);
			  //
		    break;
		case "receipt"://应邀项目
			  loadData({'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
			  loadData({'pageid':'accepting','order_id':params}, getEmployer, null, false);
		      break;
		case "working"://提交项目成果
			var params=getParamValue('id');
			 loadData({'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
			 loadData({'pageid':'progress','order_id':params}, getProgress, null, false);
		    break;			
		case "check"://验收
			 loadData({'pageid':'DETAIL','order_id':params}, getProInfo, null, false);
			 loadData({'pageid':'progress','order_id':params}, getProgress, null, false);
		    break;						
		case "companyList"://找企业
			selectInt();
			loadData({'pageid':'COMPANYLIST'}, getCompanyList, null, false);
		    break;
		case "personList"://找个人
			loadData({'pageid':'PERSONLIST'}, getPersonList, null, false);
		    break;
		case "userHome"://用户介绍主页
		     var params=getParams();
			loadData({'pageid':'USERHOME'}, getUserInfo, null, false);
		    break;
		case "search"://搜索页
		    break;	
		case "login"://搜索页
		    break;				
		case "register"://会员信息注册			
		    break;		  
		case "cRegister"://企业会员注册
		    break;		  	
		case "pRegister"://个人会员信息注册
		    break;		  					
		case "forgetPwd"://忘记密码			
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