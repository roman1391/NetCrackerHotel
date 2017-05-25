<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 4/29/2017
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<script src="<c:url value= "/resources/tether-1.3.3/dist/js/tether.min.js" />" >
</script>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <div id="carousel-inner" class="carousel-inner" role="listbox" >
        <div class="carousel-item active">
            <object class="d-block img-responsive photo" data="${choosenHotel.mainPhoto}" type="image/jpg">
                <img class="d-block img-responsive photo"
                     src="/resources/sorry-image-not-available.png" alt="${choosenHotel.name}" height="300">
            </object>
        </div>
        <c:forEach var="photo"  items="${choosenHotel.photos}">
            <div class="carousel-item">
                <object class="d-block img-responsive photo" data="<c:url value="${photo}"/>" type="image/jpg">
                    <img class="d-block img-responsive photo"
                         src="/resources/sorry-image-not-available.png" height="300">
                </object>
            </div>
        </c:forEach>
    </div>
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>