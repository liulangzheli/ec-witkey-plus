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

Date.prototype.pattern = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
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

function loadProjectOrderData(state,curPage=1,pageSize=10){
	var records = null;
	var projectOrderQueryParam = {
		"current": curPage,
		"state": state,
		"size": pageSize
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
				loadProjectsPage(curPage,state,rs.data.total);
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
				+ '<dt class="dd15 txAC">项目编号</dt>'//2  15%
				+ '<dt class="dd35 txAC">项目名称</dt>'//3  35%
		 		+ '<dt class="dd1 txAC">项目金额</dt>'//4  10%
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
			var amount = " - ";
			if(data[i].amount != null){
				var amount = data[i].amount + " 元";
			}
			var payTime = " - ";
			if(data[i].payTime != null){
				var payTime = data[i].payTime;
			}
			var payState = "";
			if(data[i].payTime != null){
				payState = "已付款";
			}else{
				payState = "<a href=\"javascript:void(0)\" class=\"greenButton pdLR\" onclick=\"confirmPay(this,\'" + data[i].id +"\',"+state+")\">请确认付款</a>";
			}

			var proStateStr = "-";
			if(data[i].state != null && data[i].state == 0){
				proStateStr = "<a href=\"javascript:void(0)\" onclick=\"showBox(\'m"+i+"\',0)\" class=\"greenButton pdLR\">审核</a>";
			}

			_str += '<dl><dd class="dd101 txAC"><input type="checkbox"/></dd>'//1
			+ '<dd class="dd15">'+ data[i].id +'</dd>'//2
			+ '<dd class="dd35 pname"><a href="javascript:void(0)" onclick="showBox(\'m'+i+'\',0)">'+loadCategory(data[i].useType).cateName+" "+loadCategory(data[i].categoryId).cateName+" "+data[i].softName+'</a></dd>'//3
			+ '<dd class="dd1 txAR">'+ amount +'</dd>'//4
			+ '<dd class="dd1 time txAC">'+payTime+'</dd>'//5
			+ '<dd class="dd1 txAC">'+payState+'</dd>'//6
			+ '<dd class="dd15 txAC">'+proStateStr+'</dd>'//7
			+ '<div class="modal-dialog-box m'+i+'">'
			+ '<div class="modal-dialog"><h3>项目信息</h3>'
			+ '<p class="tip txAC fc9"> 项目编号：'+data[i].id+'   雇主：'+getProjectUserByUserId(data[i].userId).username+'</p>'
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
			+ '<td align="center"><span>'+amount+'</span></td>'  
			+ '<td align="center"><span>'+data[i].period+'</span>天</td>'  
			+ '<td><a href="'+sourceName+'">'+originalName+'</a></td>'  
			+ '</tr><tr>'  
			+ '<td>详细描述</td>'  
			+ '<td colspan="7">' + data[i].intro + '</td>'  
			+ '</tr></table></div>'     
			+ '<div class="marA10 txAC">'
			+ '<a href="javascript:void(0)" onclick="showBox(\'m'+i+'\',1)" class="greyButton dd2 pdLR ">关闭</a>'
			+ '<a href="javascript:void(0)" onclick="confirmProject(\'m'+i+'\',1,\''+data[i].id+'\')" class="greenButton dd2 pdLR marL ">确认项目信息</a></div>'
			+ '</div></div></dl>';
		}
		// _str += '<dl><dd class="dd10"><label><input type="checkbox"/>全选</label>'
		//       + '&nbsp;<a href="">删除</a>&nbsp;<a href="">审核</a></dd></dl>';
		_str += '</div><div id="pagination" class="pagination"></div></div>';
		$('#rightSide').empty().append(_str);
	}
}

//项目审核分页功能
function loadProjectsPage(curPage,proState,records=0) {
	var pageSize = 10;
	// var pageAmount = 3;
	var pageTotal = 0;
	var dataTotal = 0;
	var pState = 0;
	if(proState!=null&&proState!=undefined){
		if(records!=null&&records!=undefined){
			dataTotal = records;//总记录数
			pageTotal = Math.ceil(dataTotal/pageSize);
			if(pageTotal === 0)
			 	pageTotal = 1;
		}
		pState = proState;
	}
	 new Page({
		 id: 'pagination',
		 pageTotal: pageTotal, //必填,总页数
		 pageAmount: pageSize,  //每页多少条
		 dataTotal: dataTotal, //总共多少条数据
		 curPage:curPage, //初始页码,不填默认为1
		 pageSize: pageSize, //每页多少条,不填默认为10
		 showPageTotalFlag:true, //是否显示数据统计,不填默认不显示
		 showSkipInputFlag:true, //是否支持跳转,不填默认不显示
		 getPage: function (page) {
			//获取当前页数
			//alert("curPage="+page + " pageSize=" + pageSize);
			loadProjectOrderData(pState,page,pageSize);
		 }
	 })
 }

function getProjectOrderByOrderId(orderId){
	var record = null;
	$.ajax({
		type: "GET",
		url: basePathAPI +'projectOrder/info/' + orderId,
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
				record = rs.data;
			}else{
				alert("项目资料查询异常！错误代码：" + rs.code + " " + rs.msg);
			}
		},
		error:function(rs){
			alert("项目资料查询异常！错误代码：" + rs.status + " " + rs.statusText);
		}
	});
	return record;
}

function updateProjectOrder(infoData){
	var res = false;
	var queryParam = infoData;
	$.ajax({
		type: "POST",
		url: basePathAPI +'projectOrder/update/',
		beforeSend: function(XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("token", $.cookie("adminToken"));
        },
		async: false,
		data:JSON.stringify(queryParam), //必须用JSON.stringify()方法转。
		contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
		cache: false,
		success:function(rs) {
			var code = rs.code;
			if (code === 200) {
				res = true;
			}else{
				alert("项目资料更新异常！错误代码：" + rs.code + " " + rs.msg);
			}
		},
		error:function(rs){
			alert("项目资料更新异常！错误代码：" + rs.status + " " + rs.statusText);
		}
	});
	return res;
}

//确认付款
function confirmPay(tag,orderId,state){
	//$(tag).parent().empty().text('已付款');
   var record = getProjectOrderByOrderId(orderId);
   if(record != null){
		record.payTime = new Date().pattern("yyyy-MM-dd hh:mm:ss");
		var res = updateProjectOrder(record);
		if(res)
			//$(tag).parent().empty().text('已付款');
			loadProjectOrderData(state);
		else
			alert("确认付款失败！");
   }else
   alert("确认付款失败！");
}
//确认项目信息
function confirmProject(tag,state,orderId){
	var windowW=window.screen.width,dialogW=$('.'+tag).children().width()||windowW/2;
	var left=(windowW-dialogW)/2;
	$('.'+tag).children().css('left',left+'px');
	var record = getProjectOrderByOrderId(orderId);
	if(record != null){
			record.state = state;
			var res = updateProjectOrder(record);
			if(res){
				$('.'+tag).fadeOut();
				loadProjectOrderData(0);
			}else
				alert("确认付款失败！");
	}else
			alert("确认付款失败！");
 }

 //会员审核
 function showUsersData(data,state){
	if(data!=null&&data!=undefined){
		 var _str='';
		 if(state == 0){
			 _str += '<div class="dataList dd9 marA10 bdA">'
			 + '<dl> <h2 class="pdL">待审核服务商</h2></dl>';
		 }else if(state == -1){
			 _str += '<div class="dataList dd9 marA10 bdA">'
			 + '<dl><h2 class="pdL">所有会员</h2></dl>';
		 }else{
			 _str += '<div class="dataList dd9 marA10 bdA">'
			 + '<dl><h2 class="pdL">未知</h2></dl>';
		 }
		 _str += '<dl>'
				 + '<dt class="dd101" txAC>选择</dt>' //1  5%
				 + '<dt class="dd15 txAC">账号</dt>'//2  15%
				 + '<dt class="dd1 txAC">用户类型</dt>'//3  10%
				  + '<dt class="dd35 txAC">账号信息</dt>'//4  35%
				 + '<dt class="dd2 txAC">图片资料</dt>'//5   20%
				 + '<dt class="dd15 txAC">操作</dt>'//6 15%
				 + '</dl>';
		 for(i=0;i<data.length;i++){
			 var userName = data[i].username;
			 var sourceName = "";
			 var userInfo = "";//账号信息
			 var user_type = "";//0：个人/团队，1：企业

			 var teamName = "未填";
			 if(data[i].teamName!=null&&data[i].teamName!=undefined)
			 	teamName = data[i].teamname;
 
			 switch(data[i].userType){
				 case 0:
					user_type = "个人/团队";
					sourceName = "<a href=\""+data[i].idFront+"\"><img alt=\"身份证正面\" height=\"40\" width=\"40\" src=\""+data[i].idFront+"\"/></a>"
			 + "&nbsp;&nbsp;<a href=\""+data[i].idBack+"\"><img alt=\"身份证反面\" height=\"40\" width=\"40\" src=\""+data[i].idBack+"\"/></a>";
					userInfo = "<p>联系电话：<span class=\"marR\">"+data[i].phone+"</span>&nbsp;所在地：<span>"+data[i].province+data[i].city+data[i].zone+"</span></p>"
					+ "<p>公司/团队名称：<span>"+teamName+"</span></p>"
					+ "<p>身份证：<span>"+data[i].idNum+"</span></p>";
					break;
				 case 1:
					user_type = "企业";
					sourceName = "<a href=\""+data[i].licensePic+"\"><img alt=\"营业执照\" height=\"40\" width=\"40\" src=\""+data[i].licensePic+"\"/></a>";
					userInfo = "<p>联系电话：<span class=\"marR\">"+data[i].phone+"</span>&nbsp;所在地：<span>"+data[i].province+data[i].city+data[i].zone+"</span></p>"
					+ "<p>公司/团队名称：<span>"+teamName+"</span></p>"
					+ "<p>企业机构代码：<span>"+data[i].licenseId+"</span></p>";
					break;
				 default:
				 	user_type = "未知";
			 }
			var pState = "";
			if(data[i].state != null&&data[i].state==0)
				pState = '<a href="javascript:void(0)" onclick="showBox(\'m'+i+'\',0)" class="greenButton pdLR">审核</a>';
			
			_str += '<dl><dd class="dd101 txAC"><input type="checkbox"/></dd>'//1
			//  + '<dd class="dd15">'+ data[i].id +'</dd>'//2
			 + '<dd class="dd15 pname"><a href="javascript:void(0)" onclick="">'+userName+'</a></dd>'//2
			 + '<dd class="dd1 txAR">'+ user_type +'</dd>'//3
			 + '<dd class="dd35 txAC">'+userInfo+'</dd>'//4
			 + '<dd class="dd2">'+sourceName+'</dd>'//5
			 + '<dd class="dd15 txAC">'+pState+'</dd>'
             + '<div class="modal-dialog-box m'+i+'">'
             + '<div class="modal-dialog tipdialog">'
             + '<h3>服务商资料审核</h3>'
             + '<div class="tip dd9 txAC">确认审核通过并允许用户(账号：<span>'+userName+'</span>)接单？</div>'
             + '<div class="marA10 txAC"><a href="javascript:void(0)" onclick="showBox(\'m'+i+'\',1)" class="greyButton dd2 pdLR ">关闭</a><a href="javascript:void(0)" onclick="confirmUser(\'m'+i+'\',1,\''+data[i].id+'\')" class="greenButton dd2 pdLR marL ">确认</a></div>'                                                          
             + '</div></div></dl>';
		 }
		 _str += '<dl><dd class="dd10"><label><input type="checkbox"/>全选</label>'
		       + '&nbsp;&nbsp;<a href="javascript:void(0)">删除</a>&nbsp;<a href="javascript:void(0)">审核</a></dd></dl>';
		 _str += '</div><div id="pagination" class="pagination"></div></div>';
		 $('#rightSide').empty().append(_str);
	 }
 }
 
 //会员审核分页功能
 function loadUsersPage(curPage,proState,records) {
	 var pageSize = 10;
	 var pageTotal = 0;
	 var dataTotal = 0;
	 var pState = 0;
	 if(proState!=null&&proState!=undefined){
		 if(records!=null&&records!=undefined){
			 dataTotal = records;//总记录数
			 pageTotal = Math.ceil(dataTotal/pageSize);
			 if(pageTotal === 0)
			 	pageTotal = 1;
		 }
		 pState = proState;
	 }
	  new Page({
		  id: 'pagination',
		  pageTotal: pageTotal, //必填,总页数
		  pageAmount: pageSize,  //每页多少条
		  dataTotal: dataTotal, //总共多少条数据
		  curPage:curPage, //初始页码,不填默认为1
		  pageSize: pageSize, //每页多少条,不填默认为10
		  showPageTotalFlag:true, //是否显示数据统计,不填默认不显示
		  showSkipInputFlag:true, //是否支持跳转,不填默认不显示
		  getPage: function (page) {
			 //获取当前页数
			 //alert("curPage="+page + " pageSize=" + pageSize);
			 loadUsersData(pState,page,pageSize);
		  }
	  })
}

function loadUsersData(state=-1,curPage=1,pageSize=10){
	var records = null;
	if(state >= 0){
		var projectOrderQueryParam = {
			"current": curPage,
			"state": state,
			"size": pageSize
		};
	}else{
		var projectOrderQueryParam = {
			"current": curPage,
			"size": pageSize
		};
	}
	
	$.ajax({
		type: "POST",
		url: basePathAPI +'sysUser/getPageList',
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
				showUsersData(records,state);
				loadUsersPage(curPage,state,rs.data.total);
			}else{
				alert("用户信息查询异常！错误代码：" + rs.code + " " + rs.msg);
			}
		},
		error:function(rs){
			alert("用户信息查询异常！错误代码：" + rs.status + " " + rs.statusText);
		}
	});
	return records;
}

//确认用户资格
function confirmUser(tag,state,usreId){
	var windowW=window.screen.width,dialogW=$('.'+tag).children().width()||windowW/2;
	var left=(windowW-dialogW)/2;
	$('.'+tag).children().css('left',left+'px');
	var record = getUserById(usreId);
	if(record != null){
			record.state = state;
			var res = updateUser(record);
			if(res){
				$('.'+tag).fadeOut();
				loadUsersData(0);
			}else
				alert("用户审核失败！");
	}else
		alert("用户审核失败！");
}

function getUserById(userId){
	var record = null;
	$.ajax({
		type: "GET",
		url: basePathAPI +'sysUser/info/' + userId,
		beforeSend: function(XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("token", $.cookie("adminToken"));
        },
		async: false,
		contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
		cache: false,
		success:function(rs) {
			var code = rs.code;
			if (code === 200) {
				record = rs.data;
			}else{
				alert("用户信息查询异常！错误代码：" + rs.code + " " + rs.msg);
			}
		},
		error:function(rs){
			alert("用户信息查询异常！错误代码：" + rs.status + " " + rs.statusText);
		}
	});
	return record;
}

function updateUser(infoData){
	var res = false;
	var queryParam = infoData;
	$.ajax({
		type: "POST",
		url: basePathAPI +'sysUser/update/',
		beforeSend: function(XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("token", $.cookie("adminToken"));
        },
		async: false,
		data:JSON.stringify(queryParam), //必须用JSON.stringify()方法转。
		contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
		cache: false,
		success:function(rs) {
			var code = rs.code;
			if (code === 200) {
				res = true;
			}else{
				alert("用户信息更新异常！错误代码：" + rs.code + " " + rs.msg);
			}
		},
		error:function(rs){
			alert("用户信息更新异常！错误代码：" + rs.status + " " + rs.statusText);
		}
	});
	return res;
}



