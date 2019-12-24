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
$(document).ready(function() {
	// 执行代码
	if ($.cookie('adminUserId') !== null && $.cookie('adminUserId') !== undefined
	&& $.cookie('adminUserId') !== ''){
		var username = $.cookie('adminUserName');
		var rolename = $.cookie('adminRoleName');
		$("#topUser").text('[' + username + '|'+ rolename + ']');
		$("#topUser").attr('href','javascript:void(this)');//mcenter.html');
		$("#topLog").text('[退出]');
		$("#topLog").attr('href','javascript:void(this)');
		$("#topLog").attr('onclick','doLoginOut()');
	} else
		clearToLogin();
});

function clearToLogin() {
	$.removeCookie("ISAdminLOGIN");
	$.removeCookie("adminUserId");
	// $("#topUser").text('登录');
	// $("#topUser").attr('href','login.html');
	window.location.href=basePath+'sys/login.html';
}

function doLoginOut() {//退出	
	$.ajax({
		url : basePathAPI + "logout",
		beforeSend: function(XMLHttpRequest) {
			XMLHttpRequest.setRequestHeader("token", $.cookie("adminToken"));
		},
		type : "POST",
		cache : false,
		async: false, // true:异动 false：同步
		success : function(rs) {
			if(rs.code === 200){
				$.cookie("ISAdminLOGIN", null);
				$.cookie('adminUserId', null);
				$.cookie('adminUserName', null);
				$.cookie('adminRoleName',null);
				$.cookie('adminToken',null);
				$.removeCookie("adminUserId",{domain:'localhost',path:'/'});
				// $("#topUser").text('登录');
				// $("#topUser").attr('href','login.html');
				window.location.href=basePath+'sys/login.html';
			}else{
				alert("退出异常，错误代码：" + rs.code +" "+ rs.msg);
			}
		},
		error : function(rs) {
			alert("退出异常，异常信息："  + rs.status + " " + rs.statusText);
		}
	});
}

function loadCategory(cateId){
	var records = null;	
	$.ajax({
		type: "GET",
		url: basePathAPI +'category/info/'+cateId,
		beforeSend: function(XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("token", $.cookie("adminToken"));
        },
		async: false,
		//data:JSON.stringify(queryParam), //必须用JSON.stringify()方法转。
		contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
		cache: false,
		success:function(rs) {
			var code = rs.code;
			if (code === 200) {
				records = rs.data;
				//alert("类别管理查询成功！" + rs.data.records);
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

function loadProjectOrderData(state){
	var records = null;
	var projectOrderQueryParam = {
		"current": 1,
		"state": state,
		"size": 10
	};
	
	$.ajax({
		type: "POST",
		url: basePathAPI +'projectOrder/getPageList',
		beforeSend: function(XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("token", $.cookie("adminToken"));
        },
		async: false,
		data:JSON.stringify(projectOrderQueryParam), //必须用JSON.stringify()方法转。
		contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
		cache: false,
		success:function(rs) {
			var code = rs.code;
			if (code === 200) {
				records = rs.data.records;
				showData(records,state);
			}else{
				alert("项目订单查询异常！错误代码：" + rs.code + " " + rs.msg);
			}
		},
		error:function(rs){
			alert("项目订单查询异常！错误代码：" + rs.status + " " + rs.statusText);
		}
	});
	return records;
}

function getProjectUserByUserId(userId){
	var records = null;
	// var QueryParam = {
	// 	"id": id,
	// };
	
	$.ajax({
		type: "GET",
		url: basePathAPI +'sysUser/info/'+userId,
		beforeSend: function(XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("token", $.cookie("adminToken"));
        },
		async: false,
		//data:JSON.stringify(QueryParam), //必须用JSON.stringify()方法转。
		contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
		cache: false,
		success:function(rs) {
			var code = rs.code;
			if (code === 200) {
				records = rs.data;
			}else{
				alert("项目订单查询异常！错误代码：" + rs.code + " " + rs.msg);
			}
		},
		error:function(rs){
			alert("项目订单查询异常！错误代码：" + rs.status + " " + rs.statusText);
		}
	});
	return records;
}

function getProjectSourceByOrderId(orderId){
	var records = null;
	// var QueryParam = {
	// 	"orderId": orderId,
	// };
	
	$.ajax({
		type: "GET",
		url: basePathAPI +'projectSource/infoByOrderId/'+orderId,
		beforeSend: function(XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("token", $.cookie("adminToken"));
        },
		async: false,
		//data:JSON.stringify(QueryParam), //必须用JSON.stringify()方法转。
		contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
		cache: false,
		success:function(rs) {
			var code = rs.code;
			if (code === 200) {
				records = rs.data;
			}else{
				alert("项目资料查询异常！错误代码：" + rs.code + " " + rs.msg);
			}
		},
		error:function(rs){
			alert("项目资料查询异常！错误代码：" + rs.status + " " + rs.statusText);
		}
	});
	return records;
}

function showData(data,state){
   if(data!=null&&data!=undefined){
		var _str='';
		if(state == 0){
			_str += '<div class="dataList dd9 marA10 bdA">'
			+ '<dl><h2 class="pdL">待审核项目</h2></dl>';
		}else if(state === 1){
			_str += '<div class="dataList dd9 marA10 bdA">'
			+ '<dl><h2 class="pdL">已审核项目</h2></dl>';
		}else{
			_str += '<div class="dataList dd9 marA10 bdA">'
			+ '<dl><h2 class="pdL">未知项目</h2></dl>';
		}
		_str += '<dl>'
				+ '<dt class="dd101" txAC>选择</dt>' //1  5%
				+ '<dt class="dd15">项目编号</dt>'//2  15%
				+ '<dt class="dd35">项目名称</dt>'//3  35%
		 		+ '<dt class="dd1">项目金额</dt>'//4  10%
				+ '<dt class="dd1 txAC">付款时间</dt>'//5   10%
				+ '<dt class="dd1 txAC">付款状态</dt>'//6  10%
		        + '<dt class="dd15 txAC">操作</dt>'//7 15%
				+ '</dl>';
		for(i=0;i<data.length;i++){
			var sourceName = '';
			var originalName = '';
			var sourseRecord = getProjectSourceByOrderId(data[i].id);
			if(sourseRecord != null){
				sourceName = sourseRecord.sourceName;
				originalName = sourseRecord.originalName;
			}
			_str += '<dl><dd class="dd101 txAC"><input type="checkbox"/></dd>'//1
			+ '<dd class="dd15">'+ data[i].id +'</dd>'//2
			+ '<dd class="dd35 pname"><a href="javascript:void(0)" onclick="showBox(\'m1111\',0)">'+loadCategory(data[i].useType).cateName+" "+loadCategory(data[i].categoryId).cateName+" "+data[i].softName+'</a></dd>'//3
			+ '<dd class="dd1 txAR">'+(data[i].amount != null?"data[i].amount 元":" - ")+'</dd>'//4
			+ '<dd class="dd1 time txAC">'+(data[i].payTime != null?"data[i].payTime":" - ")+'</dd>'//5
			+ '<dd class="dd1 txAC">'+(data[i].payTime != null?"已付款":"<a href=\"javascript:void(0)\" class=\"greenButton pdLR\" onclick=\"confirmPay(this)\">确认付款</a>")+'</dd>'//6
			+ '<dd class="dd15 txAC"><a href="editPro.html" class="greenButton pdLR marR">编辑</a><a href="javascript:void(0)" onclick="showBox(\'m1111\',0)" class="greenButton pdLR">审核</a></dd>'//7
			+ '<div class="modal-dialog-box m1111">'
			+ '<div class="modal-dialog"><h3>项目信息</h3>'
			+ '<p class="tip txAC fc9"> 项目编号：'+data[i].id+'   用户：'+getProjectUserByUserId(data[i].userId).username+'</p>'
			+ '<div class="dd9 marA"><table width="100%" class="marA10" border="0" cellspacing="0" cellpadding="0"><tr>'
			+ '<th align="center">项目用途</th>'
			+ '<th align="center">需求分类</th>'
			+ '<th align="center">项目类型</th>'
			+ '<th align="center">项目专业</th>'
			+ '<th align="center">所在地</th>'
			+ '<th align="center">预算费用</th>'
			+ '<th align="center">交付周期</th>'
			+ '<th align="center">图纸资料</th>'
			+ '</tr><tr>'
			+ '<td>'+loadCategory(data[i].useType).cateName+'</td>'
			+ '<td>'+loadCategory(data[i].categoryId).cateName+'</td>'    
			+ '<td>多层住宅（7层以下），独栋别墅</td>'  
			+ '<td>土建-主体结构，钢构-挖土方</td>'  
			+ '<td><span>'+data[i].province+'</span>-<span>'+data[i].city+'</span>-<span>'+data[i].zone+'</span></td>'  
			+ '<td align="center"><span>'+data[i].amount+'</span>元</td>'  
			+ '<td align="center"><span>'+data[i].period+'</span>天</td>'  
			+ '<td><a href="'+sourceName+'">'+sourceName+'</a></td>'  
			+ '</tr><tr>'  
			+ '<td>详细描述11</td>'  
			+ '<td colspan="7">&nbsp;</td>'  
			+ '</tr></table></div>'     
			+ '<div class="marA10 txAC">'
			+ '<a href="javascript:void(0)" onclick="showBox(\'m1111\',1)" class="greyButton dd2 pdLR ">关闭</a>'
			+ '<a href="javascript:void(0)" onclick="showBox(\'m1111\',1)" class="greenButton dd2 pdLR marL ">确认项目信息</a></div>'
			+ '</div></div></dl>';
		}
		$('#rightSide').empty().append(_str);
	}
}

function confirmPay(tag){//确认付款
   $(tag).parent().empty().text('已付款');
}

