//会员中心代码
function getUserInfo(data,args){//获取用户信息	
	  if(data!=undefined &&data!=null&&data.data.recCnt!=0){
		data=data.data.dataInfo;
		$("#userName").empty().append(data[0].loginName+'['+data[0].expValue+']');		
	  }
}
function getUserCrop(data,args){//获取用户头像  
  if(data!=undefined &&data!=null&&data.data.recCnt!=0){	  
	    data=data.data.dataInfo;
		var picurl=basePath + "images/member/head/" +data[0].picUrl;
		$('#userCrop img').attr('src',picurl);
	}		
}
function getOrderList(data,args){//订单列表
	if(data!=undefined&&data!=null){	

	}
}

function cancelOrder(message,args){//关闭交易
	var _proid =args.orderNo;
	if(progId=="ORDERLIST"){//订单列表取消订单	
		$('.oHeader').each(function(){			
			if($(this).attr('orderid')==_proid){
				$(this).find('.oState').text('交易关闭');
				$(this).find('.btnState').html('<a  class="redBtn" href="javascript:void(0)" status="buy">再次购买</a>');
			}
		});
	}else{//订单详情取消订单
		$('.oState').text('交易关闭');
		$('.btnState').attr('pid',_proid).html('<a  class="redBtn" href="javascript:void(0)" status="buy">再次购买</a>');
	}
}
function pickService(args){//选标
}
function signOrder(args){//接受邀约
}
function resultCommit(args){//提交项目成果
}
function checkResult(args){//验证成果
}

function orderService(orderId) {//申请维权
		
}
function modifyUserPwd() {
	try {
		$.cookie.json = "true";
		var memberInfo = $.cookie("USERINFO");
		var args = new Object();
		args.oldPassword = $(".ipt").val();
		args.newPassword = $("#newPassword").val();
		args.loginName = memberInfo.loginName;
		$
				.ajax({
					url : basePath + "updatePwd.action",
					async : false, // true:异动 false：同步
					data : args,
					cache : false,
					success : function(text) {
						if (text != undefined || text != null)
							text = text.Message;
						var msg = new Object;
						if (text.message != undefined || text.message != null)
							msg = text.message[0];
						else
							msg = null;
						if (msg != null && msg.messageCode == 100000) {
							var content = '';
							$('.login').remove();
							content += '<div class="success"><div>'
									+ '<h1><s></s><span>修改密码成功！</span> </h1>'
									+ '<p><span class="countTime">2</span>秒后自动跳转到登录页面&nbsp;&nbsp;<a href="javascript:void(0)" onclick="backToLogin(0)">点击立即重新登入！</a></p>'
									+ '</div></div>';
							$('.uinleft').append(content);
							backToLogin(2);
							$.cookie("ISLOGIN", null, {
								path : '/'
							});
							$.cookie("USERINFO", null, {
								path : '/'
							});
							changeHei($('.mr.fl'));
						} else {
							args.self = $('ul.login .ordersbt2');
							showMessageBox(Resx[200011], Resx[211501], '',
									args, 1);
						}
					},
					error : function(text) {
						// showMessage($('ul.login
						// .ordersbt2'),'修改密码',Resx[text.retCode],'');
					}
				});
	} finally {
		$.cookie.json = null;
	}
}

function previewImage(file){ //修改会员头像，图片预览
	 $('.choiceBox').hide();
     $('.previewBox').show();
	  var MAXWIDTH  = $(window).width();  
	  var MAXHEIGHT = $(window).height();  
	  var div = document.getElementById('dragDiv');  
	  if (file.files && file.files[0])  {  
		var imgSize = parseInt(file.files[0].size)/1024/1024;
	    div.innerHTML = '<img id=imghead>';  
	    var img = document.getElementById('imghead');  
	    img.onload = function(){  
	      var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);  
	      img.width = rect.width;  
	      img.height = rect.height;  
	      img.style.marginLeft = 0+'px';  
	      img.style.marginTop = rect.top+'px';
	  
	    }; 
	    var reader = new FileReader();  
	    reader.onload = function(evt){
	       img.src = evt.target.result;		
		   img.setAttribute('w',img.naturalWidth);
		   img.setAttribute('h',img.naturalHeight);		
	    };  
	    reader.readAsDataURL(file.files[0]);  
	  }  
	  else {  
	    var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="'; 
	    file.select();  
	    var src = document.selection.createRange().text;  
	    div.innerHTML = '<img id=imghead>';  
	    var img = document.getElementById('imghead');  
	    img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src; 
	    var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
	    status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);  
	    div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;margin-left:"+rect.left+"px;"+sFilter+src+"\"'></div>";  
	  }  
	  $('#dragDiv img').css('max-width',MAXWIDTH)
}  
function clacImgZoomParam( maxWidth, maxHeight, width, height ){//会员头像裁剪  
    var param = {top:0, left:0, width:width, height:height};  
    if( width>maxWidth || height>maxHeight ) {  
        rateWidth = width / maxWidth;  
        rateHeight = height / maxHeight;           
        if( rateWidth > rateHeight ){  
            param.width =  maxWidth;  
            param.height = Math.round(height / rateWidth);  
        }else{  
            param.width = Math.round(width / rateHeight);  
            param.height = maxHeight;  
        }  
    }       
    param.left = Math.round((maxWidth - param.width) / 2);  
    param.top = Math.round((maxHeight - param.height) / 2);  
    var jcrop_api, boundx, boundy;
	$("#imghead").Jcrop({
		onChange:showPreview,
		onSelect:showPreview,
		aspectRatio:1
	},function(){
        // Use the API to get the real image size
        var bounds = this.getBounds();
        boundx = bounds[0];
        boundy = bounds[1];
        // Store the API in the jcrop_api variable
        jcrop_api = this;
      });	
    return param;  
}  
function showPreview(coords){//会员头像裁剪上传
	if(parseInt(coords.w) > 0){
		var realImagePercentW= parseFloat($("#imghead").attr('w')) /$("#imghead").width();  
		var realImagePercentH = parseFloat($$("#imghead").attr('h')) /$("#imghead").height();  
		$('input[name="x1"]').val(Math.round(realImagePercentW * coords.x));
		$('input[name="y1"]').val(Math.round(realImagePercentH * coords.y));
		$('input[name="x2"]').val(parseInt(Math.round(realImagePercentW * coords.x2)));
		$('input[name="y2"]').val(parseInt(Math.round(realImagePercentH * coords.y2)));
		$('input[name="width"]').val(Math.round(coords.w * realImagePercentW));
		$('input[name="height"]').val(Math.round(coords.w * realImagePercentH));
	}
}
$(document).ready(function() {
  switch($('body').attr('data-page')) {
    case "MPWD":
	    
	break;
  }
});