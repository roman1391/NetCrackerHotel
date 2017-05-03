<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div style="margin: 50px">
    <c:if test="${not empty hotels}">

        <c:forEach var="hotel" items="${hotels}">
            <a href="hotel_page/${hotel.key.id}">

                <div class="row list-group-item">
                    <div class="col-4">
                        <img src="<c:url value="${hotel.key.mainPhoto}"/>" class="rounded"
                             alt="${hotel.key.name}" width="200">
                    </div>
                    <div class="col-8">
                        <h3>${hotel.key.name}
                            <c:forEach var="i" begin="1" end="${hotel.key.typeOfService}">
                                <i class="fa fa-star"></i>
                            </c:forEach>
                        </h3>
                        <p>${hotel.key.country}, ${hotel.key.city}</p>
                        <p>${hotel.key.address}</p>

                        <c:if test="${not empty hotel.value}">
                            <p>
                            Available rooms:
                            <c:forEach var="room" items="${hotel.value}">
                               ${room.capacity}
                                <c:forEach var="i" begin="1" end="${room.capacity}">
                                    <i class="fa fa-male"></i>
                                </c:forEach>
                                &nbsp &nbsp &nbsp
                            </c:forEach>
                            </p>
                        </c:if>
                        <c:if test="${empty hotel.value}">
                                <h5 style="color: rebeccapurple">There are no available rooms on your dates.</h5>
                        </c:if>

                    </div>
                </div>
            </a>
        </c:forEach>

    </c:if>
    <c:if test="${empty hotels}">
    <div class="form-group">
        <p>
            ${message}
        </p>
    </div>
    </c:if>
</div>