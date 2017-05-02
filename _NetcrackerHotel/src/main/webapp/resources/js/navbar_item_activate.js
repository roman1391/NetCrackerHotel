/**
 * Created by slava on 03.05.17.
 */
var url = window.location;
$('ul.nav a').filter(function() {
    return this.href == url;
  }).parent().addClass('active');