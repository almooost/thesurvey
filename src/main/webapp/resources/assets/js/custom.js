/**
 * Custom javascript file
 * @author Samuel Alffano
 * @ate 26.10.2016
 * @version v0.2
 */

$(document).ready(function(){
    $('button').click(function() {
        $(this).toggleClass('expanded').siblings('div').slideToggle();
    });

    if( $.trim( $('.notification').html() ).length ) {
        console.log("NOTIFICATION");

        $('.notification-wrapper').show();
        setTimeout(function () {
            $('.notification-wrapper').fadeOut('slow');
        }, 3000);
    }
});

$(document).on('click', '.deleteItem', function(){
    var id = $(this).attr("data-id");
    var path = $(this).attr("data-path");
    console.log(path+"?action=delete&id="+id);
    $.post( path+"?action=delete&id="+id, function( data ) {
        $('.info').innerHTML(data);
    });
});

