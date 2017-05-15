<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 4/18/2017
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<form style="margin: 50px">
    <c:if test="${not empty hotel.photos}">
        <div class="row">
            <c:forEach var="photo" items="${hotel.photos}">
                <div class="col-md-2">
                    <div class="thumbnail">
                        <a href="${photo}">
                            <img src="${photo}" style="width:100%">
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
    <c:if test="${not empty message}">
        <div class="row">${message}</div>
    </c:if>
</form>
<form style="margin: 20px" action="${path}" method="post"
      enctype="multipart/form-data" id="selectPhoto">
    <div class="form-group">
        <input type="file" name="files" multiple accept="image/*">
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">${button}</button>
    </div>
</form>

