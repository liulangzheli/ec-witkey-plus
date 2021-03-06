//通用分页方法
function loadPage(url,conditions,records=0,callbackName) {
	var pageSize = 10;
	var pageTotal = 0;
	var dataTotal = 0;
	//var pState = 0;
	var curPage = 1;
	if(conditions != null){// && conditions.state!=null&&conditions.state!=undefined){
		//pState = conditions.state;
		curPage = conditions.current;
		pageSize = conditions.size;
		if(records!=null&&records!=undefined){
			dataTotal = records;//总记录数
			pageTotal = Math.ceil(dataTotal/pageSize);
			if(pageTotal === 0)
			 	pageTotal = 1;
		}
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
			conditions.current = page;
			loadData(url,conditions, callbackName, null, false);
		 }
	 })
 }

function getProType(data){//发布需求-项目类别
  if(data!=null&&data!=undefined){ 
     var _str='',_childStr='';
      $.each(data,function(key,item){
		    if(item.cateParentId==0||item.cateParentId==''){
				var pid=item.id;
				$.each(data,function(key,item){
				     if(item.id==pid)
					   _childStr+='<label>'+item.cateName+'<input type="checkbox" contype="'+item.contType+'" name="'+item.id+'" id="'+item.id+key+'" value="'+item.cateName+'" onclick="setSelected(this,\'checkbox\')"/> '         
								+'</label>'
								+'          <div class="modal-dialog-box">'
								+'         	 <div class="modal-dialog">'
								+'					<h3>项目类型：<span>'+item.cateName+'</span></h3>'
								+'                    <div class="dd8 marA">'
								+'                         <table>'
								+'                            <tr>'
								+'                               <td align="right">单体数量：</td>'
								+'                               <td><input type="text" name="'+item.id+key+'_qty" value="1" /></td>'
								+'                            </tr>'
								+'                            <tr>'
								+'                               <td align="right">地上总建筑面积：</td>'
								+'                               <td><input type="number" name="'+item.id+key+'_area"/>平米</td>'
								+'                            </tr>'
								+'                            <tr><td colspan="2" align="left">说明：</td></tr>'
								+'                            <tr><td colspan="2" align="left">1、确认后，可继续选择其他项目类型 2、如有地下部分（车库、地下室等），请单独添加地下部分项目类型。注意：基础层不需要单独输入。</td></tr>'
								+'                            <tr>'
								+'                            	<td align="center"><a href="javascript:void(0)" onclick="showBox(\'modal-dialog-box\',"'+item.id+key+'",1)"class="greyButton pdLR dd8 ">关闭</a></td>'
								+'                            	<td align="center"><a href="javascript:void(0)" onclick="showBox(\'modal-dialog-box\',"'+item.id+key+'",1)"class="orangeButton pdLR dd8">确认</a></td>'
								+'                            </tr>'
								+'                         </table>'
								+'                    </div>        '     				

				});
				 _str='<div><b>'+item.cateName+'：</b>'+_childStr;
			}
	  });
	  $('#projectType').empty().append(_str);
  }
}

function getMajorList(action,conditions,rs){//获取项目专业类别
    if(rs!=null&&rs!=undefined&& rs.data!=null && rs.data != undefined){
		var _str='';
		_str+='<a href="javascript:void(0);" '+(conditions.major == ""?"class=\'active\'":"")+'>不限</a>';
		$.each(rs.data.records,function(key,item){
			_str += '<a href="javascript:void(0);" '+(conditions.major == item.cateName?"class=\'active\'":"")+'>'+item.cateName+'</a>';
		});
		_str +='<input id="major" type="hidden" />';
	    $('#majorList').empty().append(_str);  
	}
}
function getProdList(action,conditions,rs){//获取项目列表
  if(rs!=null&&rs!=undefined&& rs.data!=null && rs.data != undefined){
	 var _str='',_time='',_state='';
	 if(rs.data.records.length == 0){
		_str+='<div class="li pdTB  clear ofHide ">'
		+'	<div class="dd9 fl">无数据</div></div>'
	 }
	 $.each(rs.data.records,function(key,item){
		 var readNum = 0;
		 readNum = Math.floor(Math.random()*100 + 0);//暂时先用随机数0-100
		 let bidCount = getBiddingCount(item.id);
		 var endTime = '未限制';
		 if(item.endTime != null)
		 	endTime = item.endTime;
		 _time='</span>预计交付时间：<span class="time">'+endTime+'</span>';
		 _state='<span  class="orangeButton dd8">'+bidCount+'人已报名</span>';
	     _str+='<div class="li pdTB  clear ofHide ">'
			 +'	<div class="dd9 fl">'
			 //+'  <p><a href="pinfo.html?id='+item.id+'&conditions='+conditions+'\">'+getCategory(item.useType).cateName+"|"+getCategory(item.categoryId).cateName+"|"+item.softName+'</a>'
			 +'  <p><a href="pinfo.html?id='+item.id+'&current='+conditions.current+'\">'+item.id+"|"+getCategory(item.useType).cateName+"|"+getCategory(item.categoryId).cateName+"|"+item.softName+'</a>'
			 +'		<label class="pdLR fc9">'+item.city+'</label>'
			 +'  </p>'
			 +'	  <p class="lifo"><span class="price">￥'+item.amount+_time+'</p>'
			 +'</div>'
			 +' <div class="dd1 fl">'
			 +'  <p>'+_state+'</p>'
			 +'  <p class="fc9"><span>'+readNum+'</span>人已看</p>'
			 +' </div>'
			 +'</div>';
	 });
	 _str += '<div id="pagination" class="pagination"></div>';
	 $('#proList').empty().append(_str);
	 $("#searchProjText").val(conditions.keyword);
	 loadPage(action,conditions,rs.data.total,getProdList);	
  }
}
function getRankList(data){//排行榜
  if(data!=null&&data!=undefined){
	 var_str='',i=0,m=0,_str2='';
	 $.each(data,function(key,item){
		 if(i<10&&item.type=='company'){//显示前10名
		 i=key+1;
		 _str=' <li>'
              +'  <div class="r"><span class="g">'+i+'</span></div>'
              +'  <div class="t"><a href="userHome.html?cid='+item.id+'"></a></div>'
              +'  <div class="i">'
              +'    <p><a href="userHome.html">'+item.thumb+'</a></p>'
              +'    <p class="fc9">'+item.city+'</p>'
              +'    <p class="fc9">近期收入：<span class="price">'+item.amount+'</span></p>'
              +'  </div>'
              +'</li>';
		 }
		 else if(m<10&&item.type=='person'){//显示前10名
		 m=key+1;
		 _str2=' <li>'
              +'  <div class="r"><span class="g">'+i+'</span></div>'
              +'  <div class="t"><a href="userHome.html?cid='+item.id+'"></a></div>'
              +'  <div class="i">'
              +'    <p><a href="userHome.html">'+item.thumb+'</a></p>'
              +'    <p class="fc9">'+item.city+'</p>'
              +'    <p class="fc9">近期收入：<span class="price">'+item.amount+'</span></p>'
              +'  </div>'
              +'</li>';
		 }
	 });
	 $('#companyRank').empty().append(_str);
	 $('#personRank').empty().append(_str2);
  }
}

function getProjectRequirementList(action){
	var prjReqList = null;
	$.ajax({
		type: "GET",
		url : basePathAPI + action,
		beforeSend: function(XMLHttpRequest) {
			XMLHttpRequest.setRequestHeader("token", $.cookie("token"));
		},
		async : false, // true:异步 false：同步
		contentType:"application/json",
		cache : false,
		success : function(rs) {
			var code = rs.code;
			if (code === 200) {
				if(rs.data != null)
					prjReqList = rs.data;
			}
		},
		error : function(rs) {
			alert("加载异常：错误代码：" + rs.status + " " + rs.statusText);
		}
	});
	return prjReqList;
}
    
function getProInfo(action,conditions,rs){//获取项目信息
	if(rs!=null&&rs!=undefined&& rs.data!=null && rs.data != undefined){
		var _title='',_proStatus='',_str='',_detail="",_state='',_endtime='';
		if(rs.data.endTime != null){
			_endtime = rs.data.endTime;
		}
		var prjReqList = getProjectRequirementList('projectRequirement/infos/'+rs.data.id);
		//_str +='<p><b>项目类型：</b></p>';
		$.each(prjReqList,function(key,item){
			_str +='<p><b>项目类型：</b>'+getCategory(item.categoryId0).cateName+'：'+getCategory(item.categoryId).cateName+' <b>单体数量：</b>'+item.qty+' <b>地上总建筑面积：</b>'+item.area+'平方米</p>';
		});
		_str +='<p><b>专业类型：</b>'+rs.data.major+'</p>'
			  +'<p><b>项目周期：</b>'+rs.data.period+'天</p>'
			  +'<p><b>雇主报价：</b>'+rs.data.amount+'元</p>';
		_detail = rs.data.intro;
		/*
		if(rs.data.state==1){//进行中
			  if(data.order_state!=3&&data.pay_state==1&&data.bidding_state==0){//投标中
				 _state+='  <div class="ok"><span><b>1</b>'
						+'	<label>发布需求</label>'
						+'	<label>'+data.create_time+'</label>'
						+'	</span><span class="line ok"></span></div>'
						+'  <div class="active"><span><b>2</b>'
						+'	<label>托管佣金</label>'
						+'	</span><span class="line doing"><b></b></span><p>投标中</p></div>'
						+'  <div><span><b>3</b>'
						+'	<label>选择服务商并签约</label>'
						+'	</span><span class="line"></span></div>'
						+'  <div><span><b>4</b>'
						+'	<label>成果交付</label>'
						+'	<label>预计'+_endTime+'</label>'
						+'	</span><span class="line"></span></div>'
						+'  <div><span><b>5</b>'
						+'	<label>解冻佣金</label>'
						+'	<label class="price">'+data.amount+'</label>'
						+'	</span></div>';
			  }
			  else if(data.order_state!=3&&data.pay_state==1&&data.bidding_state==2&&data.check_state==0){//工作中
				  _state+='  <div class="ok"><span><b>1</b>'
							+'	<label>发布需求</label>'
							+'	<label>'+data.create_time+'</label>'
							+'	</span><span class="line ok"></span></div>'
							+'  <div class="active"><span><b>2</b>'
							+'	<label>托管佣金</label>'
							+'	</span><span class="line ok"></span></div>'
							+'  <div class="active"><span><b>3</b>'
							+'	<label>选择服务商并签约</label>'
							+'	</span><span class="line"></span></div>'
							+'  <div><span><b>4</b>'
							+'	<label>成果交付</label>'
							+'	<label>预计'+_endTime+'</label>'
							+'	</span><span class="line"></span></div>'
							+'  <div><span><b>5</b>'
							+'	<label>解冻佣金</label>'
							+'	<label class="price">'+data.amount+'</label>'
							+'	</span></div>';
			  }
			 else if(data.order_state==3){//项目完成
 					 _state+='  <div class="ok"><span><b>1</b>'
							+'	<label>发布需求</label>'
							+'	<label>'+data.create_time+'</label>'
							+'	</span><span class="line ok"></span></div>'
							+'  <div class="active"><span><b>2</b>'
							+'	<label>托管佣金</label>'
							+'	</span><span class="line ok"></span></div>'
							+'  <div class="active"><span><b>3</b>'
							+'	<label>选择服务商并签约</label>'
							+'	</span><span class="line ok"></span></div>'
							+'  <div><span><b>4</b>'
							+'	<label>成果交付</label>'
							+'	<label>'+_endTime+'交付</label>'
							+'	</span><span class="line ok"></span></div>'
							+'  <div><span><b>5</b>'
							+'	<label>解冻佣金</label>'
							+'	<label class="price">'+data.amount+'</label>'
							+'	</span></div>';			  
			  }
		*/
		//订单状态 0：待审核  1：发布 2：进行中 3：完成 4：关闭
		_proStatus +='<div class="ok"><span><b>1</b>'
			+ '<label>发布需求</label>'
			+'<label>'+rs.data.createTime+'</label>'
			+'</span><span '+(rs.data.state<=4?'class="line ok"':'class="line"')+'></span></div>'
			+'<div '+(rs.data.state<=4?'class="ok"':'')+'><span><b>2</b>'
			+'<label>托管佣金</label>'
			+'</span><span '+(rs.data.state<=4?'class="line ok"':'class="line"')+'></span><p>'+(rs.data.state<3?'投标中':'')+'</p></div>'
			+'<div '+(rs.data.state>=3?'class="ok"':'')+'><span><b>3</b>'
			+'<label>选择服务商<br\>并签约</label>'
			+'</span><span '+(rs.data.state>=3?'class="line ok"':'class="line"')+'></span><p>'+(rs.data.state<3?'':'定标中')+'</p></div>'
			+'<div '+(rs.data.state>=3?'class="ok"':'')+'><span><b>4</b>'
			+'<label>成果交付</label>'
			+'<label>预计'+_endtime+'</label>'
			+'</span><span '+(rs.data.state>=3?'class="line ok"':'class="line"')+'></span><p>'+(rs.data.state<4?'':'结算中')+'</p></div>'
			+'<div '+(rs.data.state>=3?'class="ok"':'')+'><span><b>5</b>'
			+'<label>解冻佣金</label>'
			+'<label class="price">￥'+rs.data.amount+'</label>'
			+'</span></div></div>';
		$('#proTitle').empty().append(_title);
		$('#proStatus').empty().append(_proStatus);
		$('#pIntro').empty().append(_str);
		$('#proDetail').empty().append(_detail);

		let _proFile = '无附件。';
		let proFileQueryParam={
			'id':rs.data.id
		}
        loadData('projectSource/infoByOrderId/'+rs.data.id,proFileQueryParam,getproFile,null,false);
		function getproFile(action,conditions,res){//获取项目附件
			if(res!=null&&res!=undefined&& res.data!=null && res.data != undefined){
				_proFile = '<a href="'+res.data.sourceName+'" download="'+res.data.originalName+'">'+res.data.originalName+'</a>';
				
			}
		};
		$('#proFile').empty().append(_proFile);
		
		//竞标  后续要根据userId，获取用户类别
		let _bidding = '';
		if($.cookie('roleId')==3 && !checkBidding($.cookie('userId'),rs.data.id)){ //3:服务商 且没有投过标的
			let bidCount = 0;
			bidCount = getBiddingCount(rs.data.id);
			_bidding = '<div class="pdA bdA">温馨提示：项目周期较短，请算客合理把握时间，确认能够按时完成再进行投标。</div>';
			_bidding +='<h3 class="pdA">服务商投标</h3><p class="marA10 txAC"><span>已有<b id="bidCount">'+bidCount+'</b>个服务商投标</span></p>'
			+'<div class="pdTB bdA txAC" id="biddingButton"><p class="marA10"><a href="javascript:void(0);" onclick="if(doBidding(\''+rs.data.id+'\')){$(\'#biddingButton\').empty();$(\'#bidCount\').empty().append(\''+(bidCount+1)+'\');}" class="orangeButton dd1">投标</a></p></div>';
			$('#bidding').empty().append(_bidding);
		}else
		if($.cookie('roleId')==2){ //2:雇主
			let userQueryParam={
				'current':'1',
				'size':"50",//最多50个投标人
				//'orderStates':"0-0",//'orderStates':"1,2,3,4",
				'type':"POST",
				'major': '',
				'keyword':'',
				'orderId':rs.data.id,
				'ownerId':$.cookie('userId') //找属于自己的项目的投标者列表
			}
			var statesList = new Array(); 
				statesList.push("1"); 
				statesList.push("2");
				statesList.push("3");
				statesList.push("4");
			userQueryParam.orderStatesList = statesList;
			loadData('/orderBidding/getPageListByUserIdAndOrderId',userQueryParam,getOrderBiddingList,null,false);
		}else
		{
			_bidding +='<h3 class="pdA">服务商投标</h3><p class="marA10 txAC"><span>已有<b>'+getBiddingCount(rs.data.id)+'</b>个服务商投标</span></p>';
			$('#bidding').empty().append(_bidding);
		}
		
		let _pageBack = '';
		_pageBack = '<a href="javascript:void(0)" onclick="window.location.href=\'findProd.html?current='+conditions.current+'\'" class="orangeButton dd1">返回</a>';
		$('#pageBack').empty().append(_pageBack);
	 	// if($('body').attr('data-page')=='receipt'){
		// 	if(data.user_type==0)
		// 	$('#employer').empty().html(' <p><span>甲   方：</span>'+data.nick_name+'</b> <span>机构代码：</span><b>'+data.id_num+'</b></p>');
		// 	else
		// 	$('#employer').empty().html(' <p><span>甲   方：</span>'+data.company_name+'</b> <span>机构代码：</span><b>'+data.licence_id+'</b></p>');
		// 	var oid=getParamValue('id');
		// 	$('#isAccept').empty().html('<a class="orangeButton dd25 marA10" href="javascript:void(0)" onclick="acceptFun('+oid+',1)">接受邀约并工作</a><a class="greyButton dd1 marL" href="javascript:void(0)" onclick="acceptFun('+oid+',2)" >放弃</a>')
	  	// }
  	}
}
function getBiddingInfo(data){//竞标
  if(data!=null&&data!=undefined){
     var _str='',_detail="",_state='未中标';
	 if($.cookie('uid')==data.owner_id){
			if(data.order_state!=3&&data.pay_state==1&&data.bidding_state==0){//投标中
			    _state='<a href="javascript:void(0)" onclick="ineedu('+data.order_id+','+item.user_id+')"  class="orangeButton dd8">选标</a>';
				$.each(data.info,function(key,item){
					_str=' <div class="li pdTB  clear ofHide "> '
						+'          <div class="dd1 fl"><div class="thumb"><img src="'+item.thumb+'"width="100%"/></div></div>'
						+'          <div class="dd8 fl"><p><b>'+item.nickname+'</b><label class="pdLR fc9">'+city+'</label></p><p>'+item.message+'</p></div>'
						+'          <div class="dd1 fl">'+_state+'</div>'
						+'       </div><!--end li-->';
					_state='';
				 });			
			} else if(data.order_state!=3&&data.pay_state==1&&data.bidding_state==2&&data.check_state==0){//工作
					$.each(data.info,function(key,item){
						 if(item.state==2)
							_state='已中标'			 
						_str=' <div class="li pdTB  clear ofHide "> '
							+'          <div class="dd1 fl"><div class="thumb"><img src="'+item.thumb+'"width="100%"/></div></div>'
							+'          <div class="dd8 fl"><p><b>'+item.nickname+'</b><label class="pdLR fc9">'+city+'</label></p><p>'+item.message+'</p></div>'
							+'          <div class="dd1 fl">'+_state+'</div>'
							+'       </div><!--end li-->';
						_state='未中标';
					 });			
			}else if(data.order_state==3){//项目完成
			   _str='<p class="marA10"><span>项目已完成</span></p>';
			}		 
	 }else{//项目浏览者浏览
			if(data.order_state!=3&&data.pay_state==1&&data.bidding_state==0){//投标中
			    _state='<a href="javascript:void(0)" onclick="doBidding('+data.order_id+','+item.user_id+')"  class="orangeButton dd8">投标</a>';
			    _str='  <p class="marA10"><span>已有<b>'+data.info.length+'</b>个服务商投标</span></p>'
        			+'  <p class="marA10"><a href="javascript:void(0)" onclick="doBidding('+data.order_id+','+$.cookie('uid')+')"  class="orangeButton dd1">投标</a></p>';
			} else if(data.order_state!=3&&data.pay_state==1&&data.bidding_state==2&&data.check_state==0){//工作
			   _str='<p class="marA10"><span>服务商工作中...</span></p>';
			}else if(data.order_state==3){//项目完成
			  _str='<p class="marA10"><span>项目已完成</span></p>';
			}	 
	     
	 }
	 $('#bidding').empty().html(_str);
  }  	
}

function getProgress(data){//获取项目提交信息
   if(data!=null&&data!=undefined&&data.length!=0){
	     var _str='<tr>'
				+'<th class="dd1">日期</th>'
				+'<th class="dd2">资料</th>'
				+'<th class="dd7">备注说明</th>'
			  	+'</tr>';
		  var _checkStr='';
		  var oid=getParamValue('id');
       $.each(data,function(key,item){
		   if(item.state==2)
	     	   _str+='<tr>'
					+'	<td>'+item.create_time+'</td>'
					+'	<td><a href="">'+item.source_name+'</a></td>'
					+'	<td>'+item.intro+'</td>'
        			+' </tr>'
		   if(item.state==0)
		      _checkStr='<div class="pdA marL"><b>查看图纸资料：</b><a href="">'+item.source_name+'</a></div>'
						+'   <div class="pdA marL docInfo"><b class="pdetail">&emsp;&emsp;&emsp;&emsp;说明：</b><div>'+item.intro+'</div></div>'
						+'   <div class="pdA"><a class="orangeButton dd2" style="margin-left:110px;"  onclick="confirm('+oid+',1)">确认</a>'
						+'   <a class=" greyButton dd2 marL" href="confirm('+oid+',2)">拒绝</a>'
						+'   <a class="marL"  onclick="showBox(\'infoBox\',\'\',2)">查看项目信息</a></div>'
	   });
	  $('#progressBox').empty().html(_str);
   }else{
        $('#progressBox').parentsUntil('section').hide();
   }
}
// function getCompanyList(data){//获取企业服务商列表
//   if(data!=null&&data!=undefined){
//      var _str='',_ctype='',cpercent=100;
// 	 $.each(data,function(key,item){
// 		 if(item.companyType!=null&&item.companyType!=undefined)
// 		 _ctype='公司类型：<span class=" fcO">'+item.companyType+'</span>';
// 		 if(item.percent!=null&&item.percent!=undefined)
// 		 cpercent=item.percent*100;
// 	     _str+='<div class="li pdTB  clear ofHide ">'
// 			+'	<div class="dd1 fl t"><a href="userHome.html?mid='+item.id+'"><img src="'+item.thumb+'"width="100%"/></a></div>'
// 			+'	<div class="dd7 fl">'
// 			+'	  <p><a href="userHome.html?mid='+item.id+'">'+item.companyName+'</a></p>'
// 			+'	  <p class="lifo">'+item.intro+'</p>'
// 			+'	  <p class="lifo"><label class="pdLR fc9">'+item.city+'</label></p>'
// 			+'	</div>'
// 			+'	<div class="dd2 fl y">'
// 			+'	  <p>近期完成：'+item.proQty+'</p>'
// 			+'	  <p>按时交付率<span>'+cpercent+'%</span></p>'
// 			+'	</div>'
// 			+'  </div><!--end li-->'
// 	 });
// 	 $('#companyList').empty().append(_str);
// 	 loadPage(10,data.length);	 
// }
// }
// function getCompanyList(data){//获取个人服务商列表
//   if(data!=null&&data!=undefined){
//      var _str='',_ctype='',cpercent=100;
// 	 $.each(data,function(key,item){
		 
// 		 if(item.percent!=null&&item.percent!=undefined)
// 		 cpercent=item.percent*100;
// 	     _str+='  <div class="li pdTB  clear ofHide ">'
// 			+'		<div class="dd1 fl t"><a href="userHome.html?mid='+item.id+'"></a></div>'
// 			+'		<div class="dd7 fl">'
// 			+'		  <p><a href="userHome.html?mid='+item.id+'">'+item.teamname+'</a><label class="pdLR fc9">'+item.city+'</label></p>'
// 			+'		  <p class="lifo">项目类型： 住宅×33        教育建筑×26              办公建筑×11 </p>'
// 			+'		  <p class="lifo">项目专业： 钢筋×28        土建(不含钢筋)×27     电气消防×23</p>'
// 			+'		  <p class="lifo">工作经历：</p>'
// 			+'		</div>'
// 			+'		<div class="dd2 fl y">'
// 			+'	  <p>近期完成：'+item.proqty+'</p>'
// 			+'	  <p>按时交付率<span>'+cpercent+'%</span></p>'
// 			+'		</div>'
// 			+'	  </div><!--end li-->'
// 	 });
// 	 $('#personList').empty().append(_str);
// 	 loadPage(10,data.length)	 ;
// }
// }
function getUserInfo(data){//获取用户展示信息
  if(data!=null&&data!=undefined){
     var _str='',_str2='',_str3='',_str4='',_tempName='',_intro='';
	 var infoData=data[0],teamData=data[1],caseData=data[2];
	 $.each(infoData,function(key,item){
		 _intro=item.intro;
		 if(item.user_type==0)
		 	_tempName=item.username;
		else
		 	_tempName=item.companyName;
	     _str+='   <div class="u1">'
			+'		<div class="t"><a href="userHome.html?mid='+item.user_id+'"><img src="'+item.head+'" width="100%"/></a></div>'
			+'		<div class="i">'
			+'		  <p><a href="userHome.html?id='+item.user_id+'">'+_tempName+'</a></p>'
			+'		  <p>工号：'+item.user_id+'</p>'
			+'		  <p>工作经验：'+item.jobtime+'</p>'
			+'		  <p>所在地：'+item.city+' </p>'
			+'		</div><!--end i-->'
			+'		</div><!--end u1-->'        
			+'		<div class="u1 txAC">'
			+'		   <div class="dd45 fl bdR"><p>近期完成</p><p><b class="fcO">'+item.city+'</b></p></div>'
			+'		   <div class="dd5 fl"><p>近三个月收入</p><p><b class="fcO">'+item.amount+'</b></p></div>'
			+'		</div><!--end u1--> '
			+'		<div class="u2 bdB">'
			+'		   <h3>项目类型</h3>'
			+'		   <div><span>住宅x<b>5</b></span><span>住宅x<b>5</b></span><span>工业建筑x<b>5</b></span><span>办公建筑x<b>5</b></span></div>'
			+'		   <h3>项目专业</h3>'
			+'		   <div><span>钢筋x<b>5</b></span><span>室内装修x<b>5</b></span><span>外墙装修x<b>5</b></span><span>土建x<b>5</b></span></div>'
			+'		</div><!--end u1--> '
			+'		 <div class="u1 txAC">'
			+'			 <a href="sign.html?mid='+item.id+'" class="orangeButton dd8 marB">雇佣</a><br/>'
			+'			 <a href="javascript:void(0)" class="greyButton dd8 marB">收藏</a>'
			+'		  </div><!--end u1-->'
	 });
	 
	 $.each(teamData,function(key,item){
         _str2+='<p><span>'+item.tname+'</span><label>['+item.major+']</label><span>'+item.jobtime+'年经验</span></p>'
	 });
	  $.each(caseData,function(key,item){
		  if(item.type==0)//线上订单
         _str3+=' <div class="li pdA  clear ofHide ">'
              +'              <h3>'+item.casename+'<label class="pdLR fc9">'+item.city+'</label></h3>'
              +'              <p>承接日期：<span>'+item.starttime+'</span>周期：<span>'+item.period+'天</span>'
			  +'项目规模：<span>'+item.square+'平米</span>项目佣金：<span class="price">￥'+item.amount+'</span></p>'
              +'             </div>';
		 else //线下订单
         _str3+=' <div class="li pdA  clear ofHide ">'
              +'              <h3>'+item.casename+'<label class="pdLR fc9">'+item.city+'</label></h3>'
              +'              <p>承接日期：<span>'+item.starttime+'</span>周期：<span>'+item.period+'天</span>'
			  +'项目规模：<span>'+item.square+'平米</span>项目佣金：<span class="price">￥'+item.amount+'</span></p>'
              +'             </div>';

	 });
	 $('.leftBox .box').eq(0).empty().append(_str);
	 $('.leftBox .box').eq(1).find('h3').children('b').text(teamData.length);
	 $('#teamList').empty().append(_str2);
	 $('#introBox').empty().append(_intro);
	 $('#onlineCase').empty().append(_str3);
	 $('#offlineCase').empty().append(_str4);
	}
}
function getMyOrderList(action,conditions,rs){//获取我的项目列表
	if(rs!=null&&rs!=undefined&& rs.data!=null && rs.data != undefined){
	    let _str='<div class="dataList">';
	    _str +='<dl class="dt">'
                +'<dt class="dd15 txAC">订单编号</dt>'
                +'<dt class="dd35 txAC">需求标题</dt>'
                +'<dt class="dd1 txAC">项目佣金</dt>'
                +'<dt class="dd1 txAC">雇主</dt>'
				+'<dt class="dd1 txAC">截止时间</dt>'
				+'<dt class="dd1 txAC">订单状态</dt>'  
				+'<dt class="dd1 txAC">是否中标</dt>'                                 
				+'</dl>';
		let records = null;
		
		if(rs.data.records != null){
			records = rs.data.records;
		}
		
		if(records.length == 0){
		  _str+='<dl class="dt txAC">无数据</dl></div>';
	    }
	    $.each(records,function(key,item){
			let _strId = '',endTime = '-',title = '-',amount = '-',ownerName= '',state ='';
			if(conditions.isFromProjOrderTable){
				_strId = item.id;
				//title = item.projTypeName+"|"+item.cateName+((item.softName!=null&&item.softName!="")?"|"+item.softName:"");	
			}else{
			    _strId = item.orderId;
			}
			title = item.projTypeName+"|"+item.cateName+((item.softName!=null&&item.softName!="")?"|"+item.softName:"");
		    if(item.amount!=null){
			   amount = "¥" + item.amount;
			}
			let orderState = 0;
			if(conditions.isFromProjOrderTable){
				if(item.username != null){
					ownerName = item.username;
				}
				if(item.state!=null){
					orderState = item.state;
				}
			}else{
				if(item.ownerName!=null){
					ownerName = item.ownerName;
				}
				if(item.orderState!=null){
					orderState = item.orderState;
				}
			}  
			
		    if(item.endTime != null)
			   endTime = item.endTime;
				//订单状态 0：待审核  1：发布 2：进行中 3：完成 4：关闭
			switch(orderState){
					case 0:
						//todo
						state = '待审核';
						break;
					case 1:
						//todo
						state = '发布';
						break;
					case 2:
						//todo
						state = '进行中';
						break;
					case 3:
						//todo
						state = '完成';
						break;
					case 4:
						//todo
						state = '关闭';
						break;
			}

			//是否中标 中标状态，0：等待选标 1：超时 2：选中 3、未中标
			let bidStateStr = "未中标";
			if(item.state != null){
				switch(item.state){
					case 0:
						//todo
						bidStateStr = '等待选标';
						break;
					case 1:
						//todo
						bidStateStr = '超时';
						break;
					case 2:
						//todo
						bidStateStr = '选中';
						break;
					case 3:
						//todo
						bidStateStr = '未中标';
						break;
				}
			}
		       
		   _str+='<dl><dd class="dd15 txAC">'+_strId+'</dd>'
		   		+'<dd class="dd35 txAL">'+title+'</dd>'
                +'<dd class="dd1 txAR">'+amount+'</dd>'
                +'<dd class="dd1 txAC">'+ownerName+'</dd>'
                +'<dd class="dd1 txAC">'+endTime+'</dd>'
				+'<dd class="dd1 txAC">'+state+'</dd>'  
				+'<dd class="dd1 txAC">'+bidStateStr+'</dd>'                                 
                +'</dl>'; 
	   });
	   _str += '</div><div id="pagination" class="pagination txAC"></div>';
	   $('#content1').empty().append(_str);
	   loadPage(action,conditions,rs.data.total,getMyOrderList);	
	}
}

//已投标算客列表
function getOrderBiddingList(action,conditions,rs){//获取已投标算客列表
	if(rs!=null&&rs!=undefined&& rs.data!=null && rs.data != undefined){
	   let _str='<h3 class="pdA">投标算客</h3><div class="dataList">';
	   _str +='<dl class="dt">'
                +'<dt class="dd2 txAC">头像</dt>'
				+'<dt class="dd4 txAC">账号信息</dt>'
				+'<dt class="dd1 txAC">是否中标</dt>' 
				+'<dt class="dd3 txAC">操作</dt>'                                   
                +'</dl>';
	   if(rs.data.records.length == 0){
		  _str+='<dl class="dt txAC">无数据</dl></div>';
	   }
	   $.each(rs.data.records,function(key,item){
			let _headPicSrc = '',_userInfo = '-',_bidState = '';
			_headPicSrc = item.head;
			if(item.intro != null){
				_userInfo = item.username+'   '+item.city + '<p>'+item.intro+'</p>';
			}else{
				_userInfo = item.username+'   '+item.city;
			}
			
			if(item.state!=null){
				//中标状态，0：等待选标 1：超时 2：选中 3、未中标
				switch(item.state){
					case 0:
						_bidState = '等待选标';
						break;
					case 1:
						_bidState = '超时';
						break;
					case 2:
						_bidState = '选中';
						break;
					case 3:
						_bidState = '未中标';
						break;
				}
			}
		       
		   _str+='<dl><dd class="dd2 txAC"><img class="head" alt="头像" height=50px width=50px src="'+_headPicSrc+'"/></dd>'
		   		+'<dd class="dd4 txAL">'+_userInfo+'</dd>'
				+'<dd class="dd1 txAC">'+_bidState+'</dd>' 
				+'<dd class="dd3 txAC">';
			if(item.state != 2){
				_str += '<div class="marT30 txAC"><a href="javascript:void(0);" onclick="selectedBidding(\''+item.id+'\',\''+item.orderId+'\',\'2\')" class="orangeButton dd25 txAC">定 标&nbsp;</a></div>';  
			}else{
				_str += '<div class="marT30 txAC"><a href="javascript:void(0);" onclick="selectedBidding(\''+item.id+'\',\''+item.orderId+'\',\'0\')" class="orangeButton dd25 txAC">取 消&nbsp;</a></div>'; 
			}
			_str +='</dd></dl>'; 
	   });
	   //_str += '</div><div id="pagination" class="pagination txAC"></div>';
	   $('#bidding').empty().append(_str);
	   loadPage(action,conditions,rs.data.total,getOrderBiddingList);	
	}
}



