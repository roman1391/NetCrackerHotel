<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row list-group-item">
    <div class="col-4">
        <img src="<c:url value="${hotel.mainPhoto}"/>" class="rounded"
             alt="${hotel.name}" width="200">
    </div>
    <div class="col-8">
        <h3>${hotel.name}
            <c:forEach var="i" begin="1" end="${hotel.typeOfService}">
                <i class="fa fa-star"></i>
            </c:forEach>
        </h3>
        <p>${hotel.country}, ${hotel.city}</p>
        <p>${hotel.address}</p>
    </div>
</div>