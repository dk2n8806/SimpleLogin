<%-- <a class="account-btn" href="${pageContext.request.contextPath}/register"><strong>Account</strong></a>
 --%>

<ul class="account-container">
	<spring:url value="/register" var="registerLink" htmlEscape="true"/>
	<spring:url value="/login" var="loginLink" htmlEscape="true"/>
	<li><a class="account-btn" href="${registerLink}"><strong>Register</strong></a></li>
	<li><a class="account-btn" href="${loginLink}"><strong>Login</strong></a></li>
</ul>