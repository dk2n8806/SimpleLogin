<div class="main-content mx500">
	<div class="blk-b">
	<div class="blk-content modal-content">
		<h1 class="flead">Login</h1>
		<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null }">
			<div class="blk-red">
				<p>	Please enter a correct email and password.</p>
			</div>
		</c:if>
		<form:form id="loginForm" method="post" modelAttribute="newUser">
			<table class="p10">
				<tr>
					<td>
						<label for="log-e"><strong>Email</strong></label>
						<form:input path="email" id="log-e"  type="text"/>
						<p id="log-e-err" class="error hide"><i class="fa fa-exclamation-triangle txtr"></i> &nbsp;<span class="txtr">Email is required!</span></p>
					</td>
				</tr>
				<tr>
					<td>
						<label for="log-p"><strong>Password</strong></label>
						<form:input path="password" id="log-p" type="password"/>
						<p id="log-p-err" class="error hide"><i class="fa fa-exclamation-triangle txtr"></i> &nbsp;<span class="txtr">Password is required!</span></p>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="hidden" name="${_csr.parameterName}" value="${_csrf.token}" />
						<input class="toRight btn primary-btn" type="submit" value="Login" />
					</td>
				</tr>
			</table>
		</form:form>
	</div>
	
</div>

		<div class="p40 toCenter">
			<spring:url var="registerLink" value="/register" htmlEscape="true" />
			<p class="fimp">Don't have an account? <a class="link" href="${registerLink}">Sign up</a></p>
				
		</div>
</div>


