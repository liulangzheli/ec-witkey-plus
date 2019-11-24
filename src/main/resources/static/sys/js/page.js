/*
通用的方法

*/
function showBox(tag,e){//显示的标签类别，h隐藏的标签类别
   var windowW=window.screen.width,dialogW=$('.'+tag).children().width()||windowW/2;
   var left=(windowW-dialogW)/2;
   $('.'+tag).children().css('left',left+'px');
	switch(e){
	   case 0://modal-dialog-box弹窗
	   $('.'+tag).fadeIn();
	   break;
	   case 1://modal-dialog-box隐藏
	   $('.'+tag).fadeOut();
	   break;	
	   case 2://按钮切换显示
	    $('.'+tag).toggle();
	   break;	   
	}
}
function confirmPay(tag){//确认付款
   $(tag).parent().empty().text('已付款');
}
$(document).ready(function() {
  
});



