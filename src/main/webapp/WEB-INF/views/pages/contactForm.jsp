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
</head>
<body>
<jsp:include page="../navigation/header_navigation.jsp"></jsp:include>
<div style="width: 1000px; margin: auto;">
	<div>
		<c:if test="${not empty jsonMessage}">
			<h2>${jsonMessage.result }</h2>
		</c:if>
	</div>
	<div style="text-align: center">
		<jsp:include page="components/contactForm.jsp"></jsp:include>
	</div>
		
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#contactForm").on("submit", function(event) {
	 	var $this = $(this);
		var $name = $this.find("input[name=name]");
		var $email = $this.find("input[name=email]");
		var $msg = $this.find("textarea[name=message]");

		var flag1 = setFlag($name, $name.val().length > 0);
		var flag2 = setFlag($email, isEmail($email.val()));
		var flag3 = setFlag($msg, $msg.val().length > 0);
		
		if(flag1 && flag2 && flag3) {
			$this.submit();
		}
	});

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

	function setFlag($c, t) {
		if(t===true) {
			$c.removeClass("error");
			return true;
		} else {
			$c.addClass("error");
			return false;
		}
	};
});
</script>
</body>
</html>