//打开字滑入效果
window.onload = function(){
	$(".connect p").eq(0).animate({"left":"0%"}, 600);
	$(".connect p").eq(1).animate({"left":"0%"}, 400);
};
//jquery.validate表单验证
$(document).ready(function(){
	//登陆表单验证
	$("#loginForm").validate({
		rules: {
			username:{
				required:true,//必填
				minlength:6, //最少6个字符
				maxlength:16,//最多16个字符
			},
			password:{
				required:true,
				minlength:6, 
				maxlength:16,
			},
		},
		//错误信息提示
		messages:{
			username:{
				required:"必须填写用户名",
				minlength:"用户名至少为6个字符",
				maxlength:"用户名至多为16个字符",
				remote: "用户名已存在",
			},
			password:{
				required:"必须填写密码",
				minlength:"密码至少为6个字符",
				maxlength:"密码至多为16个字符",
			},
		},

	});
	//注册表单验证
	$("#registerForm").validate({
		rules:{
			username:{
				required:true,//必填
				minlength:6, //最少6个字符
				maxlength:16,//最多16个字符
			},
			password:{
				required:true,
				minlength:6, 
				maxlength:16,
			},
			email:{
				required:true,
				email:true,
			},
			confirm_password:{
				required:true,
				minlength:3,
				equalTo:'.password'
			},
			phone_number:{
				required:true,
				phone_number:true,//自定义的规则
				digits:true,//整数
			}
		},
		//错误信息提示
		messages:{
			username:{
				required:"必须填写用户名",
				minlength:"用户名至少为6个字符",
				maxlength:"用户名至多为16个字符",
				remote: "用户名已存在",
			},
			password:{
				required:"必须填写密码",
				minlength:"密码至少为6个字符",
				maxlength:"密码至多为16个字符",
			},
			email:{
				required:"请输入邮箱地址",
				email: "请输入正确的email地址"
			},
			confirm_password:{
				required: "请再次输入密码",
				minlength: "确认密码不能少于6个字符",
				equalTo: "两次输入密码不一致",//与另一个元素相同
			},
			phone_number:{
				required:"请输入手机号码",
				digits:"请输入正确的手机号码",
			},
		
		},
	});

	
	
	
$(document).ready(function(){
	$("#registerbutton").click(function(){	 
			$.ajax({
		url:"register",	
		data: $('#registerForm').serialize(),
		type:"post",
		datatype:"json",
		success:function(data){
		 if (data=="adminUser") {
			 window.location.href="adminUser";
		}
		 else if (data=="people") {
			 window.location.href="people";
		}else if (data=="error") {
			alert("用户已存在请重新输入！");
		}else if (data=="lessvalue") {
			alert("账号密码要大于等于6位数");
		}else if (data=="badvalue") {
			alert("请填写有关信息");
		}else if(data=="passwordnottrue"){
			alert("密码校验不正确");
		}else if (data=="emailisnottrue") {
			alert("邮箱校验不正确");
		}else if (data=="telisnotrue") {
			alert("电话校验不正确");
		}		 
		},
		error:function(XMLHttprequest,textStatus,errorThrow){
                alert("ajax连接异常");
                alert(textStatus);
                if(textStatus == null){alert('链接错误')}
                if(textStatus == 'timeout'){alert('链接超时')}
			}
	});
	});	
});   
	//添加自定义验证规则
	jQuery.validator.addMethod("phone_number", function(value, element) { 
		var length = value.length; 
		var phone_number =/^((13[0-9]{1})|(14[579]{1})|(15[0-3,5-9]{1})|(16[6]|17[0135678]{1})|(18[0-9]|19[89]{1}))+\d{8}$/
		return this.optional(element) || (length == 11 && phone_number.test(value)); 
	}, "手机号码格式错误"); 
});




