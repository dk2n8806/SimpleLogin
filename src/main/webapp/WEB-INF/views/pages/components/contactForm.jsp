
<div class="blk-b" style="width: 500px; margin: auto;">
	<div class="blk-header">
		<h3>Contact form</h3>
	</div>
	<div class="blk-content modal-content">
		<spring:url value="/user/send-contact" var="contactLink" htmlEscape="true"></spring:url>
		<form id="contactForm" action="${contactLink }" method="POST">
		<table>
			<tr>
				<td>
					<p><label for="name"><strong>Name</strong></label></p>
					<input id="name" type="text" name="name">
				</td>
			</tr>
			<tr>
				<td>
					<p><label for="email"><strong>Email</strong></label></p>
					<input id="email" type="text" name="email">
				</td>
			</tr>
			<tr>
				<td>
					<p><label for="message"><strong>Message</strong></label></p>
					<textarea id="message" name="message" rows="" cols=""></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit" class="btn primary-btn">Send</button>
				</td>
			</tr>
		</table>
		</form>
	</div>
</div>