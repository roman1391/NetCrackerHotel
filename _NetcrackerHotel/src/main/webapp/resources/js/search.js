$("#startDate").datepicker({
    inline: true,
    dateFormat: 'mm/dd/yy',
    minDate: new Date(),
    maxDate: '+2y',
    onSelect: function (date) {
        var selectedDate = new Date(date);
        var msecsInADay = 86400000;
        var endDate = new Date(selectedDate.getTime() + msecsInADay);
        $("#endDate").datepicker("option", "minDate", endDate);
        $("#endDate").datepicker("option", "maxDate", '+2y');

    }
});

$("#endDate").datepicker({
    inline: true,
    dateFormat: 'mm/dd/yy',
    minDate: new Date(),
    onSelect: function (date) {
        var selectedDate = new Date(date);
        var msecsInADay = 86400000;
        var endDate = new Date(selectedDate.getTime() - msecsInADay);
        $("#startDate").datepicker("option", "maxDate", endDate);

    }
});


$(document).ready(function () {
    $("#selectPlace").select2({
        placeholder: 'Enter country, city or hotel name',
        minimumInputLength: 1,
        maximumSelectionLength: 5,
        tags: true
    });
});

$(document).ready(function () {
    $("#selectUser").select2({
        placeholder: 'Username',
        minimumInputLength: 1,
        maximumSelectionLength: 1,
        tags: true
    });
});

$(document).ready(function () {
    $("#selectHotel").select2({
        placeholder: 'Hotel',
        minimumInputLength: 1,
        maximumSelectionLength: 1,
        tags: true
    });
});