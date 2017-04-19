<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row list-group-item">
	<div class="col-4">
		<img src="<c:url value="${hotel.photoURL}"/>" class="rounded"
			alt="${hotel.name}" width="200">
	</div>
	<div class="col-8">
		<p>${hotel.country}, ${hotel.city}</p>
		<p>${hotel.address}</p>
		<p>${hotel.name} ${hotel.typeOfService}</p>
		<form:form method="post" id="hotelpage" action="hotel_page" modelAttribute="choosenHotel" >
			<form:input path="id" type="hidden" name="id" value="${hotel.id}"></form:input>
			<form:button type="submit">See hotel</form:button>
		</form:form>
	</div>
</div>