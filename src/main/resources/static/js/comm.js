/*
通用的方法

*/

function getBasePath() {
    var url = window.document.location;
	return url.protocol + "//"+url.host+"/";
	
/*	var curWwwPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	var localhostPath = curWwwPath.substring(0, pos);
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1)
			+ "/";
	return (localhostPath + projectName);*/
}
var basePath = getBasePath();

var basePathAPI = getBasePath();//"http://localhost:8888/"; // 临时调试用的 by zhangzy 20191215

var imgBasePath = "";

function getUrlParams() {
	var search = window.location.search;
	// 写入数据字典
	var tmparray = search.substr(1, search.length).split("&");
	var paramsArray = new Array;
	if (tmparray != null) {
		for (var i = 0; i < tmparray.length; i++) {
			var reg = /[=|^==]/; // 用=进行拆分，但不包括==
			var set1 = tmparray[i].replace(reg, '&');
			var tmpStr2 = set1.split('&');
			var array = new Array;
			array[tmpStr2[0]] = tmpStr2[1];
			paramsArray.push(array);
		}
	}
	// 将参数数组进行返回
	return paramsArray;
}


function getStaticParam(){
	var retValue = "";
	var search = document.location.href;
	var tmparray = search.substr(1, search.length).split("/"); 
	if(tmparray != null){
		var reg = /[.]/; // 用.进行拆分，但不包括.
		var set1 = tmparray[tmparray.length-1].replace(reg, '&');  
		var tmpStr2 = set1.split('&');
		retValue = tmpStr2[0];
	}
	return retValue;
} 

// 根据参数名称获取参数值
function getParamValue(name) {
	getStaticParam();
	var paramsArray = getUrlParams();
	if (paramsArray != null) {
		for (var i = 0; i < paramsArray.length; i++) {
			for ( var j in paramsArray[i]) {
				if (j == name) {
					return paramsArray[i][j];
				}
			}
		}
	}
	return null;
}
function getParams() { //获取URL地址参数
   var url = location.search; //获取url中"?"符后的字串  
   var theRequest = new Object();  
   if (url.indexOf("?") != -1) {  
      var str = url.substr(1);  
      strs = str.split("&");  
      for(var i = 0; i < strs.length; i ++) {  
         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);  
      }  
   }  
   return theRequest;  
} 
// 增加会员信息复制给cookie
function saveUInfotoCookie(args) {
	try {
		$.cookie.json = true;
		$.cookie("ISLOGIN", true);
		$.cookie("USERINFO", args);
	} finally {
		$.cookie.json = false;
	}
	return $.cookie("USERINFO");
}

function loadData(action,conditions, callback, args, async) {//数据加载
	var type = 'GET';//默认为GET
	if(conditions.type != null)
		type = conditions.type;
	if(type == 'GET'){
		$.ajax({
			type: type, //GET
			url : basePathAPI + action,
			beforeSend: function(XMLHttpRequest) {
				XMLHttpRequest.setRequestHeader("token", $.cookie("token"));
			},
			async : async, // true:异步 false：同步
			contentType:"application/json",
			cache : false,
			success : function(rs) {
				var code = rs.code;
				if (code === 200) {
					return callback(action,conditions,rs);
				}else
				if(code === 401){
					alert("登陆信息已失效，请重新登陆！");
					window.location.href=basePath+'login.html';
				}
			},
			error : function(rs) {
				if(rs.status === 401){
					alert("登陆信息已失效，请重新登陆！");
					window.location.href=basePath+'login.html';
				}else
					alert("加载异常：错误代码：" + rs.status + " " + rs.statusText);
			}
		});
	}else
	if(type == 'POST'){
		$.ajax({
			type: type, //POST
			url : basePathAPI + action,
			beforeSend: function(XMLHttpRequest) {
				XMLHttpRequest.setRequestHeader("token", $.cookie("token"));
			},
			async : async, // true:异动 false：同步
			data : JSON.stringify(conditions),
			contentType:"application/json",
			cache : false,
			success : function(rs) {
				var code = rs.code;
				if (code === 200) {
					return callback(action,conditions,rs);
				}
			},
			error : function(rs) {
				if(rs.status === 401){
					alert("登陆信息已失效，请重新登陆！");
					window.location.href=basePath+'login.html';
				}else
					alert("加载异常：错误代码：" + rs.status + " " + rs.statusText);
			}
		});
	}
}
function loadByActionEx(action, callback, args, async) {
	$.ajax({
		url : basePath + action,
		async : async, // true:异动 false：同步
		data : args,
		cache : false,
		success : function(text) {
			if (args == null || args == undefined)
				args = new Object();
			args.text = text;
			if(callback != undefined)
				return callback(text, args);
		}
	});
}

function transToSearchUrl(i) {
	var searchValue = encodeURIComponent($("#searchText").val());
	if(i==0)
		window.location.href = basePath + "findProd.html?key=" + searchValue;
	else	
		window.location.href = basePath + "findCompany.html?key=" + searchValue;
}
Object.prototype.toString = function(obj) {
	var strType = typeof (obj);
	switch (strType) {
	case '[object Array]':
		return 'array';
	case '[object Date]':
		return 'date';
	case '[object Boolean]':
		return 'boolean';
	case '[object Number]':
		return 'number';
	case '[object Function]':
		return 'function';
	case '[object RegExp]':
		return 'regexp';
	case '[object Object]':
		if (undefined !== value.nodeType) {
			if (3 == value.nodeType) {
				return (/\S/).test(value.nodeValue) ? 'textnode' : 'whitespace';
			} else {
				return 'element';
			}
		} else {
			return 'object';
		}
	default:
		return 'unknow';
	}
},
String.prototype.format = function(args) {
	if (arguments.length > 0) {
		var result = this;
		if (arguments.length == 1 && typeof (args) == "object") {
			for ( var key in args) {
				var reg = new RegExp("({" + key + "})", "g");
				result = result.replace(reg, args[key]);
			}
		} else {
			for (var i = 0; i < arguments.length; i++) {
				if (arguments[i] == undefined) {
					return "";
				} else {
					var reg = new RegExp("\{("+i+"d*)\}","g") 
					result = result.replace(reg, arguments[i]);
				}
			}
		}
		return result;
	} else {
		return this;
	}
};


function formatDateString(value) {
	value = value.toString();
	year = value.substr(0, 4);
	month = value.substr(4, 2);
	day = value.substr(6, 2);
	return year + "-" + month + "-" + day;
}
// cookie操作
(function($, document, undefined) {

	var pluses = /\+/g;

	function raw(s) {
		return s;
	}

	function decoded(s) {
		return unRfc2068(decodeURIComponent(s.replace(pluses, ' ')));
	}

	function unRfc2068(value) {
		if (value.indexOf('"') === 0) {
			// This is a quoted cookie as according to RFC2068, unescape
			value = value.slice(1, -1).replace(/\\"/g, '"').replace(/\\\\/g,
					'\\');
		}
		return value;
	}

	var config = $.cookie = function(key, value, options) {

		// write
		if (value !== undefined) {
			options = $.extend({}, config.defaults, options);

			if (value === null) {
				options.expires = -1;
			}

			if (typeof options.expires === 'number') {
				var days = options.expires, t = options.expires = new Date();
				t.setDate(t.getDate() + days);
			}

			value = config.json ? JSON.stringify(value) : String(value);

			return (document.cookie = [
					encodeURIComponent(key),
					'=',
					config.raw ? value : encodeURIComponent(value),
					options.expires ? '; expires='
							+ options.expires.toUTCString() : '', // use
					// expires
					// attribute,
					// max-age
					// is not
					// supported
					// by IE
					options.path ? '; path=' + options.path : '',
					options.domain ? '; domain=' + options.domain : '',
					options.secure ? '; secure' : '' ].join(''));
		}

		// read
		var decode = config.raw ? raw : decoded;
		var cookies = document.cookie.split('; ');
		var result = key ? null : {};
		for (var i = 0, l = cookies.length; i < l; i++) {
			var parts = cookies[i].split('=');
			var name = decode(parts.shift());
			var cookie = decode(parts.join('='));

			if (key && key === name) {
				result = fromJSON(cookie);
				break;
			}

			if (!key) {
				result[name] = fromJSON(cookie);
			}
		}

		return result;
	};

	function fromJSON(value) {
		return config.json ? JSON.parse(value) : value;
	}

	config.defaults = {};
	config.setting = {
		groupfix : '_',
		childfix : '-',
		itemfix : '.'
	};

	$.removeCookie = function(key, options) {
		if ($.cookie(key) !== null) {
			$.cookie(key, null, options);
			return true;
		}
		return false;
	};

	$.stringify = function(obj) {
		var t = this, groups = [], isArray = function(ar) {
			return Object.prototype.toString.call(ar) === '[object Array]';
		}, o, items;
		if (isArray(obj)) {
			groups = obj;
		} else {
			for (o in obj) {
				if (obj.hasOwnProperty(o)) {
					items = obj[o];
					if (isArray(obj[o])) {
						items = items.join(t.setting.itemfix);
					}
					groups.push(o + t.setting.childfix + items);
				}
			}
		}
		return groups.join(t.setting.groupfix);
	};

	$.parse = function(str) {
		var t = this, groups = str.split(t.setting.groupfix), o, c, i, obj = false;
		if (str.indexOf(t.setting.childfix) !== -1) {
			obj = {};
		} else {
			obj = [];
		}
		for (o in groups) {
			c = groups[o].split(t.setting.childfix);
			if (c[1] === undefined) {
				obj.push(c[0]);
			} else {
				i = c[1].split(t.setting.itemfix);
				obj[c[0]] = i.length === 1 ? i[0] : i;
			}
		}
		return obj;
	};

})(jQuery, document);


//处理客户端存储数据
(function() {
    window.localData = {
        hname: location.hostname ? location.hostname : 'localStatus',
        isLocalStorage: window.localStorage ? true : false,
        dataDom: null,
        initDom: function() {
            if (!this.dataDom) {
                try {
                    this.dataDom = document.createElement('input');
                    this.dataDom.type = 'hidden';
                    this.dataDom.style.display = "none";
                    this.dataDom.addBehavior('#default#userData');
                    document.body.appendChild(this.dataDom);
                    var exDate = new Date();
                    exDate = exDate.getDate() + 30;
                    this.dataDom.expires = exDate.toUTCString();
                } catch (ex) {
                    return false;
                }
            }
            return true;
        },
        set: function(key, value) {
            if (this.isLocalStorage) {
            	try{
            		window.localStorage.setItem(key, value);
            	}catch(e){
            		try{
            			window.localStorage[key] = value;
            		}catch(e){}
            	}
            } else {
                if (this.initDom()) {
                    this.dataDom.load(this.hname);
                    this.dataDom.setAttribute(key, value);
                    this.dataDom.save(this.hname);
                }
            }
        },
        get: function(key) {
            if (this.isLocalStorage) {
                return window.localStorage.getItem(key);
            } else {
                if (this.initDom()) {
                    this.dataDom.load(this.hname);
                    return this.dataDom.getAttribute(key);
                }
            }
        },
        remove: function(key) {
            if (this.isLocalStorage) {
                localStorage.removeItem(key);
            } else {
                if (this.initDom()) {
                    this.dataDom.load(this.hname);
                    this.dataDom.removeAttribute(key);
                    this.dataDom.save(this.hname);
                }
            }
        },
        regRemove : function(key){
        	var reg = eval("/^"+key+"/");//动态创建正则匹配项
        	if(this.isLocalStorage) {
        		$.each(localStorage ,function(ind, val){
        			if(reg.test(ind))
        				localStorage.removeItem(ind);
        		});
        	} else{
        		if (this.initDom()){
        			this.dataDom.load(this.hname);
        			this.dataDom.clear();
        			this.dataDom.save(this.hname);
        		}
        	}
        },
        
        ValidateTime : function(t ,et){
        	var nowT = new Date().getTime();
        	if(this.isLocalStorage){
        		var beginT = this.get(t) || '';
        		var expirse = this.get(et) || '';
        		if(beginT != '' && expirse != ''){
        			beginT = parseInt(beginT);
        			expirse = parseInt(expirse);
        			if(expirse >=1 && expirse <= 31)
        				expirse = expirse * 24 *60 * 60 *1000;
        			else if(expirse < 1000)
        				expirse = 1000;
        			expirse += beginT;
        			if(nowT >= expirse || nowT <= beginT)
        				localStorage.clear();
        		}
        	}else{
        		if (this.initDom()){
        			this.dataDom.load(this.hname);
        			this.dataDom.clear();
        			this.dataDom.save(this.hname);
        		}
        	}
        }
        
    };
})();

/**
    * 判断 token 是否有效  该方法待验证 by zhangzy 2020-01-03
*/
function checkTokenActive(token){
	let aliveModel = null;
    // 先判断 key 是否存在
    let tokenIsExist = stringRedisTemplate.boundHashOps("roulette_alive").hasKey(token);
    //如果 key  存在 检查是否过期
    if(tokenIsExist){
 		//检查当前key 有效时间
            let jsonActive = stringRedisTemplate.opsForHash().get("roulette_alive", token);
            aliveModel = JSON.parseObject(jsonActive, AliveModel.class);

            let time = aliveModel.getTime();
            let aliveTime =  (new Date().getTime() - time.getTime())/1000;
            //超时时间
            if(aliveTime>15000){
             	stringRedisTemplate.opsForHash().delete("roulette_alive",token);//超时删除redis
                return null;
            }
    }
	return aliveModel;
}


