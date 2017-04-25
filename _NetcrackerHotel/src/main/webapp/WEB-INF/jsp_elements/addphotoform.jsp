<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 4/18/2017
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>

<form style="margin: 50px">
    <c:if test="${not empty photos}">
        <div class="row">
            <c:forEach var="photo" items="${photos}">
                <div class="col-md-4">
                    <div class="thumbnail">
                        <a href="${photo}">
                            <img src="${photo}" style="width:100%">
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</form>
<form style="margin: 20px" action="/hotel/photo/${id}" method="post"
      enctype="multipart/form-data" id="selectPhoto">
    <div class="form-group">
        <input type="file" name="files" multiple accept="image/*">
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Add photo</button>
    </div>
</form>
<form style="margin: 20px">
    <div class="form-group">
        <input class="btn btn-primary" type="button" onclick="location.href='/hotel/${id}/room'" value=" Add rooms"/>
    </div>
</form>
