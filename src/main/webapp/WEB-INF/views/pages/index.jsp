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
<br/><br/>
<div class="toCenter">
	<spring:url value="/login" var="loginLink" htmlEscape="true"></spring:url>
	<a class="btn primary-btn" href="${loginLink}">Please login</a>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready({
	
});
</script>
</body>
</html>