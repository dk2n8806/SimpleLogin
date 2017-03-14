<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="<c:url value="/resources/css/generalize.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/icons-style.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/item-layout.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/utility.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/color.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/font.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/layout.css" />" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reset Password | Mingo</title>
</head>
<body>
<div class="main-content-5">
	<section id="reset-request">
	<div class="blk modal-inline">
		<div class="separator"></div>
		<div class="modal-content p40">
			<div class="flead">
				<h2>Reset Password</h2>
			</div>
			
			<c:if test="${not empty errorMsg }">	
				<div class="blk-red">
					<p class="tip">The email is not register yet. Make sure you enter your registered email.</p>
				</div>
			</c:if>
			<spring:url var="forgetpassword" value="/help/reset-password" htmlEscape="true" />
			<form id="reset-form" action="${forgetpassword}" method="POST">
				<table>
					<tr>
						<td>
							<label><strong>Registered email address</strong></label>
							<input id="reset-email" name="username" type="text" placeHolder="Registered Email"/>
							<p id="reset-email-err" class="error hide"><i class="fa fa-exclamation-triangle txtr"></i> &nbsp;<span class="txtr">Email is required!</span></p>
						
						</td>
					</tr>
					<tr>
						<td><p class="tip">To reset your account password, enter the email address you registered with and we'' send your instructions on their way.</p></td>
					</tr>
					<tr>
						<td>
							<input id="reset" class="btn primary-btn" type="submit" value="Reset Account" />
						</td>
					</tr>
					<tr>
						<td>
						</td>
					</tr>
				</table>
			</form>
			<div class="p40">	
				<spring:url value="/register" var="register" htmlEscape="true" />
				<p class="toCenter fimp">Don't have an account? 
					<a class="link" href="${register}">Sign up</a> today
				</p>		
			</div>
		</div>
	</div>
	</section>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src='<c:url value="/resources/js/object.js"/>' ></script>


<script type="text/javascript">


$(document).ready(function() {
	
	var $btn = $("#reset");
	
	$btn.on("click", function(event) {
		event.preventDefault();
		var accInst = new AccountUser();
		
		var email = ("#reset-email"),
			emailVal = $(email).val()
		;
		
		var isEmail = accInst.isEmail(emailVal);
		setFlag(email, isEmail);
		
		if(isEmail) {
			alert("asda");
			$.ajax({
		        url: $("#reset-form").attr( "action"),
		        //url: "/help/reset-password",
		        data: JSON.stringify(json),
		        type: "POST",
		         
		        beforeSend: function(xhr) {
		            xhr.setRequestHeader("Accept", "application/json");
		            xhr.setRequestHeader("Content-Type", "application/json");
		        },
		        success: function(response) {
		        	alert(response);
		        }
		    });
			
		}

		
	});

});

function setFlag(c, t) {
	if(t===true) {
		$(c).removeClass("error");
		$(c+"-err").hide();
	} else {
		$(c).addClass("error");
		$(c+"-err").show();	
	}
};

</script>
</body>


</html>