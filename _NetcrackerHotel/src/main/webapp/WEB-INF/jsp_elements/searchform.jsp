<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form style="margin: 50px" method="post" action="find-hotels" modelAttribute="searchFilter">
    <div class="row list-group-item align-items-start">
        <div class="col">
            <div class="form-group">
                <form:label path="place">Enter country, city or hotel name:</form:label>
                <form:select path="place" class="form-control" id="selectPlace" multiple="multiple">
                    <c:forEach var="place" items="${search}">
                        <form:option selected="selected" value="${place}"/>
                    </c:forEach>
                    <form:options items="${places}"/>
                </form:select>
            </div>
            <div class="form-group">
                <form:label path="startDate">Start date</form:label>
                <form:input class="form-control" path="startDate" placeholder="check-in" id="startDate"
                            readonly="true"/>
                <form:label path="endDate">End date </form:label>
                <form:input class="form-control" path="endDate" placeholder="check-out" id="endDate" readonly="true"/>
            </div>
        </div>
        <div class="col">
            <div class="form-group">
                <p>Cost for night:</p>
                <div id="cost" class="row">
                    <div class="col d-inline-block">
                        <form:input class="form-control" path="minCost" placeholder="from" id="minCost"></form:input>
                    </div>
                    <div class="col d-inline-block">
                        <form:input class="form-control" path="maxCost" placeholder="to" id="maxCost"></form:input>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <form:label path="capacity">Capacity <i class="fa fa-male"></i></form:label>
                <form:input class="form-control" path="capacity" placeholder="capacity" id="capacity"></form:input>
            </div>
        </div>

        <div class="col">
            <div>
                <p>Stars:</p>
                <div class="checkbox">
                    <label><form:checkbox value="1" path="stars"/>
                        <i class="fa fa-star"></i>
                    </label>
                </div>
                <div class="checkbox">
                    <label><form:checkbox value="2" path="stars"/>
                        <i class="fa fa-star"></i><i class="fa fa-star"></i>
                    </label>
                </div>
                <div class="checkbox">
                    <label><form:checkbox value="3" path="stars"/>
                        <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>
                    </label>
                </div>
                <div class="checkbox">
                    <label><form:checkbox value="4" path="stars"/>
                        <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                class="fa fa-star"></i>
                    </label>
                </div>
                <div class="checkbox">
                    <label><form:checkbox value="5" path="stars"/>
                        <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                class="fa fa-star"></i><i class="fa fa-star"></i>
                    </label>
                </div>
            </div>
        </div>
    </div>
    <div style="margin-top: 15px;" class="btn-group pull-right">
        <button type="submit" class="btn btn-primary ">Search</button>
    </div>
    <div class="clearfix"></div>
</form:form>
