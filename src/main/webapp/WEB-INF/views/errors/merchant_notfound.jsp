<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/generalize.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/utility.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/color.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/font.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/layout.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/fancybox/jquery.fancybox.css" />" rel="stylesheet" type="text/css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<c:set var="principalName"><sec:authentication property="principal.username"/></c:set>
<title>Catalog - ${principalName }</title>

</head>
<body>
<jsp:include page="../navigation/header_navigation.jsp"></jsp:include>

<div class="main-content-11 ph40">
	<div class="blk-red">
		<h3 class="fnor">Sorry, it looks like that you haven't register to become our merchant</h3>	
		<p>Click <a class="hot" href="${pageContext.request.contextPath}/shop">here</a> to go back to main page.
	</div>
</div>

</body>
</html>