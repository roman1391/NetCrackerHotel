/**
 * Created by Varvara on 4/29/2017.
 */
$(document).ready(function () {
    $("#myCarousel").carousel({
        interval: 2500
    });
    $(".prev-slide").click(function () {
        $("#myCarousel").carousel('prev');
    });
    $(".next-slide").click(function () {
        $("#myCarousel").carousel('next');
    });
});

