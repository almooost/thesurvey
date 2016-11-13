/**
 * Custom javascript file
 * @author Samuel Alffano
 * @ate 26.10.2016
 * @version v0.1
 */

$(document).ready(function(){
    //alert("Hello world!");
});

$(document).on('click', '.deleteItem', function(){
    var id = $(this).attr("data-id");
    var path = $(this).attr("data-path");
    console.log(path+"?action=delete&id="+id);
    $.post( path+"?action=delete&id="+id, function( data ) {
        $('.info').innerHTML(data);
    });
});
