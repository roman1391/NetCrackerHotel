<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form style="margin: 50px">
    <c:if test="${not empty hotels}">

        <c:forEach var="listValue" items="${hotels}">
            <a class="row list-group-item" href = "hotel/${listValue.hotelID}">
                <div class="col-4">
                    <img src="<c:url value="/resources/img/${listValue.imagePath}"/>" class="rounded"
                         alt="${listValue.name}"
                         width="200">
                </div>
                <div class="col-8">
                    <p>
                            ${listValue.country},
                            ${listValue.city}
                    </p>
                    <p>
                            ${listValue.address}
                    </p>
                    <p>
                            ${listValue.name}
                            ${listValue.typeOfService}
                    </p>
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
</form>