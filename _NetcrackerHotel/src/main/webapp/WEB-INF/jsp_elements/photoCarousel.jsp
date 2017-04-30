<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 4/29/2017
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<div>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner" role="listbox" style=" width:100%; height: 300px; background-color: black">
        <div class="carousel-item active">
            <img class="d-block img-fluid" style="margin: auto" src="${choosenHotel.mainPhoto}" alt="${choosenHotel.name}">
        </div>
        <c:forEach var="photo"  items="${choosenHotel.photos}">
            <div class="carousel-item">
                <img class="d-block img-fluid" style="margin: auto" src="${photo}">
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
</div>