
function loadPage(amount,len){//调用分页函数
    var   pageNum=Math.round(len/amount);
	pageNum=pageNum>1||1;
    new Page({
        id: 'pagination',
        pageTotal: pageNum, //必填,总页数
        pageAmount: amount,  //每页多少条
        dataTotal: len, //总共多少条数据
        curPage:1, //初始页码,不填默认为1
        pageSize: 5, //分页个数,不填默认为5
        showPageTotalFlag:true, //是否显示数据统计,不填默认不显示
        showSkipInputFlag:true, //是否支持跳转,不填默认不显示
        getPage: function (page) {
            //获取当前页数
           console.log(page);
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
function getMajor(data){//获取项目专业类别
  if(data!=null&&data!=undefined){
     var _str='',_childStr='',_nodeStr='';
      $.each(data,function(key,item){
		    if(item.cateParentId==0||item.cateParentId==''){
				var pid=item.id,pname=item.cateName;
				$.each(data,function(i,citem){
				     if(citem.id==pid){
					   _childStr+='<label>'+citem.cateName+'<input type="checkbox" contype="'+citem.contType+'" name="'+citem.id+'" id="'+citem.id+i+'" value="'+pname+'|'+citem.cateName+'" onclick="setSelected(this,\'checkbox\')"/> '         
								+'</label>';
					   var nodePid=citem.id,nodeName=citem.cateName;
					   $.each(data,function(j,node){
						   	_nodeStr='<label for="m'+node.id+'" class="c"><input type="checkbox" name="m'+node.id+key+'"id="m'+node.id+'" value="'+pname+'|'+nodeName+'|'+node.cateName+'" onclick="setSelected(this,\'checkbox\')"/>主体结构钢筋</label>'    
					   });
					 }
				});
				 _str='<div><b>'+item.cateName+'：</b>'+_childStr;
			}
	  });
	  $('#majorType').empty().append(_str);  }
}
function getProdList(data){//获取项目列表
  if(data!=null&&data!=undefined){
     var _str='',_time='',_state='';
	 $.each(data,function(key,item){
		 _time='</span>预计交付时间：<span class="time">2019-11-10</span>';
		 _state='<span  class="orangeButton dd8">'+item.qty+'人已报名</span>';
	     _str+='<div class="li pdTB  clear ofHide ">'
			 +'	<div class="dd9 fl">'
			 +'  <p><a href="pinfo.html">'+item.title+'</a>'
			 +'		<label class="pdLR fc9">'+item.city+'</label>'
			 +'  </p>'
			 +'	  <p class="lifo"><span class="price">'+item.price+_time+'</p>'
			 +'</div>'
			 +' <div class="dd1 fl">'
			 +'  <p>'+_state+'</p>'
			 +'  <p class="fc9"><span>56</span>人已看</p>'
			 +' </div>'
			 +'</div><!--end li-->'
	 });
	 $('#proList').empty().append(_str);
	 loadPage(10,data.length)	
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
function getProInfo(data){//获取项目信息
  if(data!=null&&data!=undefined){
     var _str='',_detail="",_state='',_endtime='';
	 
			_str='<p><b>项目类型：</b> 厂房 <b>单体数量：</b> '+data.qty+'<b>地上总建筑面积：</b>'+data.area+'</p>'
     			 +'   <p><b>专业类型：</b>'+data.marjor+'</p>'
				+'	  <p><b>项目周期：</b>'+data.period+'</p>'
				+'	  <p><b>雇主报价：</b>'+data.amount+'</p>';
		   _detail=data.detail;
		   
		   if(data.order_state==1){//进行中
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
			  $('#proState').empty().html(_state);
		   }
	   
     $('#proTitle').empty(data.title);
	 $('#pIntro').empty().html(_str);
	 $('#proDetail').empty().html(_detail);
	 if($('body').attr('data-page')=='receipt'){
		 if(data.user_type==0)
		  $('#employer').empty().html(' <p><span>甲   方：</span>'+data.nick_name+'</b> <span>机构代码：</span><b>'+data.id_num+'</b></p>');
	     else
		 $('#employer').empty().html(' <p><span>甲   方：</span>'+data.company_name+'</b> <span>机构代码：</span><b>'+data.licence_id+'</b></p>');
        var oid=getParamValue('id');
		$('#isAccept').empty().html('<a class="orangeButton dd25 marA10" href="javascript:void(0)" onclick="acceptFun('+oid+',1)">接受邀约并工作</a><a class="greyButton dd1 marL" href="javascript:void(0)" onclick="acceptFun('+oid+',2)" >放弃</a>')
	     
	  }
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
			    _state='<a href="javascript:void(0)" onclick="bidding('+data.order_id+','+item.user_id+')"  class="orangeButton dd8">投标</a>';
			    _str='  <p class="marA10"><span>已有<b>'+data.info.length+'</b>个服务商投标</span></p>'
        			+'  <p class="marA10"><a href="javascript:void(0)" onclick="bidding('+data.order_id+','+$.cookie('uid')+')"  class="orangeButton dd1">投标</a></p>';
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
function getCompanyList(data){//获取企业服务商列表
  if(data!=null&&data!=undefined){
     var _str='',_ctype='',cpercent=100;
	 $.each(data,function(key,item){
		 if(item.companyType!=null&&item.companyType!=undefined)
		 _ctype='公司类型：<span class=" fcO">'+item.companyType+'</span>';
		 if(item.percent!=null&&item.percent!=undefined)
		 cpercent=item.percent*100;
	     _str+='<div class="li pdTB  clear ofHide ">'
			+'	<div class="dd1 fl t"><a href="userHome.html?mid='+item.id+'"><img src="'+item.thumb+'"width="100%"/></a></div>'
			+'	<div class="dd7 fl">'
			+'	  <p><a href="userHome.html?mid='+item.id+'">'+item.companyName+'</a></p>'
			+'	  <p class="lifo">'+item.intro+'</p>'
			+'	  <p class="lifo"><label class="pdLR fc9">'+item.city+'</label></p>'
			+'	</div>'
			+'	<div class="dd2 fl y">'
			+'	  <p>近期完成：'+item.proQty+'</p>'
			+'	  <p>按时交付率<span>'+cpercent+'%</span></p>'
			+'	</div>'
			+'  </div><!--end li-->'
	 });
	 $('#companyList').empty().append(_str);
	 loadPage(10,data.length);	 
}
}
function getCompanyList(data){//获取个人服务商列表
  if(data!=null&&data!=undefined){
     var _str='',_ctype='',cpercent=100;
	 $.each(data,function(key,item){
		 
		 if(item.percent!=null&&item.percent!=undefined)
		 cpercent=item.percent*100;
	     _str+='  <div class="li pdTB  clear ofHide ">'
			+'		<div class="dd1 fl t"><a href="userHome.html?mid='+item.id+'"></a></div>'
			+'		<div class="dd7 fl">'
			+'		  <p><a href="userHome.html?mid='+item.id+'">'+item.teamname+'</a><label class="pdLR fc9">'+item.city+'</label></p>'
			+'		  <p class="lifo">项目类型： 住宅×33        教育建筑×26              办公建筑×11 </p>'
			+'		  <p class="lifo">项目专业： 钢筋×28        土建(不含钢筋)×27     电气消防×23</p>'
			+'		  <p class="lifo">工作经历：</p>'
			+'		</div>'
			+'		<div class="dd2 fl y">'
			+'	  <p>近期完成：'+item.proqty+'</p>'
			+'	  <p>按时交付率<span>'+cpercent+'%</span></p>'
			+'		</div>'
			+'	  </div><!--end li-->'
	 });
	 $('#personList').empty().append(_str);
	 loadPage(10,data.length)	 ;
}
}
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



