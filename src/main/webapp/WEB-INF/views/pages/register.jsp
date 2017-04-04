<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="<c:url value="/resources/css/generalize.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/utility.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/color.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/font.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/layout.css" />" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>
<body>

<jsp:include page="../navigation/header_navigation.jsp"></jsp:include>
<jsp:include page="../form/account/registerform.jsp"></jsp:include>
<script type="text/javascript">
$(document).ready(function() {
	/* Cache btn */
	//var $btn = $("form input[type='submit']");
	var $form = $("#registerForm");
	$form.on("submit", function(event) {
		var $this = $(this);
		var $username 	= $($this.find("input[name=username]"));
		var $email 		= $($this.find("input[name=email]"));
		var $password 	= $($this.find("input[name=password]"));
		
		if(($form.length == 1) ||($username.length == 1) 
				||($email.length == 1) ||($password.length == 1)) {
			
			var username = $username.val();
			var email = $email.val();
			var password = $password.val();
			
			var isE = setFlag($email, isEmail(email));
			var isU = setFlag($username, isStr(username, 3, 15));
			var isP = setFlag($password, isStr(password, 8, 32));
			
			if(isE && isU && isP) {
				$this.submit();
			}
		} 
		event.preventDefault();
	}); 
	function setFlag($c, t) {
		var e = "#" + $c.attr("id");
		var $e = $(e + "-err");
		if(t===true) {
			$c.removeClass("error");
			$e.hide();
			return true;
		} else {
			$c.addClass("error");
			$e.show();	
			return false;
		}
	};
	
	function isUsername(v) {
		var flag = false;
		var len = v.length;
		if(typeof v === "string" && (len >= 8) && (len <= 32)) {
			var reg = /[^a-zA-Z0-9]+/;
			flag = reg.test(v);
			
		} else {
			flag = false;
		}
		return flag;
	}
	
	function isEmail(v) {
		var flag = false;
		var len = v.length;
		var MIN_LEN = 7;
		var MAX_LEN = 32;
		if((typeof v === "string") && (len >= MIN_LEN) && (len <= MAX_LEN)) {
			var reg = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			flag = reg.test(v);
		} else {
			flag = false;
		}
		return flag;
	};
	function isStr(v, min, max) {
		var flag = false;
		var len = v.length;
		if((typeof v === "string") && (len >= min) && (len <= max))  {
			/* var reg = /[^a-zA-Z0-9]+$/;
			flag = reg.test(v);
			alert(flag + " " +v); */
			flag = true;
		} else {
			flag = false;
		}
		 return flag;
	}
});


</script>
</body>
</html>