<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 4/18/2017
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<c:if test="${not empty hotel.photos}">
    <form style="margin: 20px;" action="${pathDelete}" method="post" enctype="multipart/form-data">
        <div class="row">
            <input type="checkbox" name="photoToDelete" value="0" checked="checked" style="opacity:0;
            position:absolute; left:9999px;"/>
            <c:forEach var="photo" items="${hotel.photos}">
                <div class="col-md-2">
                    <div class="thumbnail">
                        <label>
                            <input type="checkbox" name="photoToDelete" value=${photo}/>
                            <a href="${photo}">
                                <img src="${photo}" style="width:100%">
                            </a>
                        </label>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Delete photo</button>
        </div>
    </form>
</c:if>
<c:if test="${not empty message}">
    <form>
        <div style="margin: 20px" class="row">${message}</div>
    </form>
</c:if>
<form style="margin: 20px" action="${path}" method="post"
      enctype="multipart/form-data" id="selectPhoto">
    <div class="form-group">
        <input type="file" name="files" multiple accept="image/*">
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">${button}</button>
    </div>
</form>

