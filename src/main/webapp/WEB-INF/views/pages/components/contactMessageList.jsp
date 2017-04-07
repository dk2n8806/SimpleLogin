
	<div class="blk-b">
		<div class="blk-content modal-content">
			<table class="style">
				<tr>
					<th class="c-20"><strong>Email</strong></th>
					<th class="c-50"><strong>Message</strong></th>
					<th class="c-10"><strong>Status</strong></th>
					<th class="c-20"><strong>Created On</strong></th>
				</tr>
				
				<c:forEach items="${messages }" var="m">
					<c:set var="email" value="${m.email }" />
					<c:set var="name" value="${m.name }" />
					<c:set var="message" value="${m.message }" />
					<c:set var="createdOn" value="${m.createdOn }"/>
					<c:set var="status" value="${m.status}"/>
					
				<tr>
					<td>${email }</td>
					<td>
						<p><strong>${name}</strong></p>
						<div>${message }</div>
					</td>
					<td>${status }</td>
					<td>${createdOn }</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
