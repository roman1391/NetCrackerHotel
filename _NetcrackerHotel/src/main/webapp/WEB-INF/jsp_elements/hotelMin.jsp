<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row list-group-item">
    <div class="col-4">
        <object class="rounded" data="<c:url value="${hotel.mainPhoto}"/>" type="image/jpg"
                height="200" width="200">
            <img src="/resources/sorry-image-not-available.png" class="rounded"
                 alt="${hotel.name}" height="200" width="200">
        </object>
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