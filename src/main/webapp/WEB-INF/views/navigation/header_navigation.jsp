

<div class="header-wrapper prefix-clear">
	<div class="main-content">
		<div class="account-wrapper toRight">
			<c:choose>
				<c:when test="${not empty pageContext.request.userPrincipal }">
					<jsp:include page="modules/header_with_active_user.jsp"></jsp:include>
				</c:when>
				<c:otherwise>
					<jsp:include page="modules/header_no_active_user.jsp"></jsp:include>
				</c:otherwise>
			</c:choose>
		</div>
		<spring:url value="/" var="browseLink" htmlEscape="true" />
		<h1 class="toLeft" id="logo"><a href="${browseLink }">SimpleLogin</a></h1>
	</div>
</div>
