
<c:set var="principalName"><sec:authentication property="principal.username"/></c:set>
<div class="account-wrapper">
	<ul class="account-container">
		<li class="account-notify">
			<a class="" href="#"><i class="fa fa-bell"></i></a>
		</li>
		<li class="account-profile menu-wrapper">
			<span class="account-avatar">
				<c:choose>
					<c:when test="${not empty principalImg} || ${fn:length(principalImg) > 0 }">
						<img src="<c:out value="${principalImg}" />"/>
						${principalImg }
					</c:when>
					<c:otherwise>
						<i class="fa fa-user"></i>
					</c:otherwise>
				</c:choose>
			</span>
			 <div class="menu">
				<div class="menu-content">
					<ul>
						
						<li>
							<spring:url value="/user/dashboard" var="dashboardLink" htmlEscape="true" />
							<a href="${dashboardLink }">Dashboard</a></li>
						<li id="logout-btn">
							<form action="${pageContext.request.contextPath}/logout" method="post">
								<input type="submit" value="Logout"/>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
							</form>
						</li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
</div>