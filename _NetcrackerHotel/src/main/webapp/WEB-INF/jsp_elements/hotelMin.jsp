<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 4/15/2017
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="row list-group-item">
    <div class="col-4">
        <img src="<c:url value="${photo}"/>" class="rounded" alt="${hotel.name}"
             width="200">
    </div>
    <div class="col-8">
        <p>
            ${hotel.country},
            ${hotel.city}
        </p>
        <p>
            ${hotel.address}
        </p>
        <p>
            ${hotel.name}
            ${hotel.typeOfService}
        </p>
    </div>
</div>