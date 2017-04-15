/**
 * Created by Varvara on 4/15/2017.
 */
function getExtension(filename) {
    var parts = filename.split('.');
    return parts[parts.length - 1];
}

function isImage(filename) {
    var ext = getExtension(filename);
    switch (ext.toLowerCase()) {
        case 'jpg':
        case 'gif':
        case 'bmp':
        case 'png':
            return true;
    }
    return false;
}


$(function() {
    $("#selectPhoto").submit(function() {
        function failValidation(msg) {
            alert(msg);
            return false;
        }

        var file = $('#file');
        if (!isImage(file.val())) {
            return failValidation('Please select a valid image');
        }

        return true;
    });

});