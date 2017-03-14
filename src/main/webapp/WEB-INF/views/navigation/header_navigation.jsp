

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
		<h1 class="toLeft" id="logo"><a href="${browseLink }">Mingo</a></h1>
		<div class="header-nav">
			<ul>
				<li class="menu-wrapper"><a href="#">Browse&nbsp;&nbsp;<i class="fa fa-sort-desc"></i></a>
					<!-- <div class="menu mn200">
						<div class="menu-content">
							<ul>
								<li><a href="#">Account Setting</a></li>
								<li><a href="#">Billing &#38; Payment</a></li>
								<li><a href="#">Account Setting</a></li>
								<li><a href="#">Logout</a></li>
							</ul>
						</div>
					</div> -->
				</li>
			</ul>
		</div>
	</div>
</div>
