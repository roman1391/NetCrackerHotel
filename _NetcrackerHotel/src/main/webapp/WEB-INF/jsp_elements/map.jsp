<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 4/30/2017
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<a href="#myMapModal" class="btn" data-toggle="modal" style="font-style: italic">${choosenHotel.country }, ${choosenHotel.city}, ${choosenHotel.address }</a>

<div class="modal fade" id="myMapModal">
    <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-body">
                <div class="container">
                    <div class="row">
                        <div id="map-canvas" class=""></div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script>
    var map;

    function initialize() {
        var geocoder = new google.maps.Geocoder();
        var address = '${choosenHotel.country} ${choosenHotel.city} ${choosenHotel.address} ${choosenHotel.name}';
        geocoder.geocode({'address': address}, function(results, status) {
            if (status === 'OK') {
                map.setCenter(results[0].geometry.location);
                var marker = new google.maps.Marker({
                    map: map,
                    position: results[0].geometry.location
                });
            }
            else {
                var address = '${choosenHotel.name}';
                geocoder.geocode({'address': address}, function(results, status) {
                    if (status === 'OK') {
                        map.setCenter(results[0].geometry.location);
                        var marker = new google.maps.Marker({
                            map: map,
                            position: results[0].geometry.location
                        });
                    }
                });
            }
        });
        var mapProp = {
            zoom: 15,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };

        map = new google.maps.Map(document.getElementById("map-canvas"), mapProp);
        marker.setMap(map);

        google.maps.event.addListener(marker, 'click', function () {

            infowindow.setContent(contentString);
            infowindow.open(map, marker);

        });

    };
    google.maps.event.addDomListener(window, 'load', initialize);

    google.maps.event.addDomListener(window, "resize", resizingMap());

    $('#myMapModal').on('show.bs.modal', function () {
        resizeMap();
    })

    function resizeMap() {
        if (typeof map == "undefined") return;
        setTimeout(function () {
            resizingMap();
        }, 400);
    }

    function resizingMap() {
        if (typeof map == "undefined") return;
        var center = map.getCenter();
        google.maps.event.trigger(map, "resize");
        map.setCenter(center);
    }
</script>