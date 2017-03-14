<div class="main-content mx500">
	<div class="blk-b">
	<div class="blk-content modal-content">
		<h1 class="flead">Register</h1>
		<c:if test="${not empty errorMsg }">		
			<div id="error" class="blk-red">
				<p>Email has already taken.</p>
			</div>
		</c:if>
		<spring:url value="/register" var="register" htmlEscape="true" />
		<form:form id="registerForm" method="post" action="${register}" modelAttribute="newUser">
			<table class="p10">
				<tr>
					<td>
						<label for="reg-e"><strong>Enter your username</strong></label>
						<form:input path="username" autocomplete="off" id="reg-u" type="text"/>
						<p id="reg-u-err" class="error hide"><i class="fa fa-exclamation-triangle txtr"></i> &nbsp;<span class="txtr">Username is required!</span></p>
					</td>
				</tr>
				<tr>
					<td>
						<label for="reg-e"><strong>Enter your email</strong></label>
						<form:input path="email" autocomplete="off" id="reg-e" type="text"/>
						<p id="reg-e-err" class="error hide"><i class="fa fa-exclamation-triangle txtr"></i> &nbsp;<span class="txtr">Email is required!</span></p>
					</td>
				</tr>
				<tr>
					<td>
						<label for="reg-p"><strong>Create a password</strong></label>
						<input name="password" autocomplete="off" id="reg-p" type="password"/>
						<p id="reg-p-err" class="error hide"><i class="fa fa-exclamation-triangle txtr"></i> &nbsp;<span class="txtr">Password is required!</span></p>
					</td>
				</tr>
				<tr class="hide">
					<td>
						<input class="toLeft" type="checkbox" checked />
						<span class="tip">&nbsp;Remember me!</span>
					</td>
				</tr>
				<tr>
					<td>	
					
						<input class="btn toRight primary-btn" type="submit" value="Register" />
						<p class="tip">By creating an ccount, you agree to Mingo's  <a class="link" href="#">Terms of Service</a> and <a class="link" href="#">Privacy Policy.</a></p>
					</td>
				</tr>
			</table>
		</form:form>
		
		</div>
	</div>
	
		<div class="p40">	
			<spring:url value="/login" var="loginLink" htmlEscape="true" />
			<p class="toCenter fimp">Already have an account?
				<a class="link" href="${loginLink}">&nbsp;Sign in.</a>
			</p>
					
		</div>
</div>

