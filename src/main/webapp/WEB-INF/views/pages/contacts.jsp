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
	
	<jsp:include page="components/contactMessageList.jsp"></jsp:include>
	
	<br/>
	<div class="toCenter">
		<spring:url value="/user/contact-form" var="contacformlink" htmlEscape="true"></spring:url>
		<a class="primary-btn btn" href="${contacformlink }">New message</a>
	</div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready({
	
});
</script>
</body>
</html>