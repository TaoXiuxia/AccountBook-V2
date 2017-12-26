/**
 * 本js包含了公共校验方法
 */

// 校验只能是数字
function validateNumOnly(str, tip){
	str = $.trim(str);
	if(isNaN(Number(str))){  //当输入不是数字的时候，Number后返回的值是NaN;然后用isNaN判断。
        alert(tip);
        return false;
    }
	return true;
}

// 校验密码
function validatePassword(str){
	str = $.trim(str);
	if(str == null || "" == str){
		alert("请输入密码")
		return false;
	}
	var pwdReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/; 
	if (!pwdReg.test(str)) {
		alert("密码必须同时包含字母和数字，且只能包含字母和数字，6-12位");
		return false;
	}
	return true;
}

// 校验email
function validateEmail(str){
	str = $.trim(str);
	if(str == null || "" == str){
		alert("请输入邮箱")
		return false;
	}
	email = $.trim(str);
	var emailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; 
	if (!emailReg.test(str)) {
		alert("邮箱格式不正确");
		return false;
	}
	return true;
}

// 校验账户
function validateAccount(str){
	validateNotEmpty(str,"请输入帐号");
	
	str = $.trim(str);
	var accountReg = /^[A-Za-z0-9]{1,12}$/; 
	if (!accountReg.test(str)) {
		alert("账户只能包含字母和数字,1-12位");
		return false;
	}
	return true;
}

// 校验输入不能为空
function validateNotEmpty(str, tip){
	str = $.trim(str);
	if(str == null || "" == str){
		if($.trim(tip) == null || $.trim(tip) == ""){
			tip = "输入不能为空";
		}
		alert(tip)
		return false;
	}
	return true;
}

//校验字符串长度，最短-最长
function validateLength(str, shortLen, longLen, tip){
	str = $.trim(str);
	var len = str.length;
	if(len < shortLen || len > longLen){
		alert(tip)
		return false;
	}
	return true;
}
