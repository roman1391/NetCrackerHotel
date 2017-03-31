$( "#startDate" ).datepicker({
    inline: true,
    minDate: new Date (),
    maxDate: '+2y',
    onSelect: function(date){

        var selectedDate = new Date(date);
        var msecsInADay = 86400000;
        var endDate = new Date(selectedDate.getTime() + msecsInADay);

        $("#endDate").datepicker( "option", "minDate", endDate );
        $("#endDate").datepicker( "option", "maxDate", '+2y' );

    }
});

$( "#endDate" ).datepicker({
    inline: true,
    minDate: new Date (),
    onSelect: function(date){

        var selectedDate = new Date(date);
        var msecsInADay = 86400000;
        var endDate = new Date(selectedDate.getTime() - msecsInADay);

        $("#startDate").datepicker( "option", "maxDate", endDate );

    }
});