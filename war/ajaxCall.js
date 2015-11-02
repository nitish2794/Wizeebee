$(document).ready(function() {
    $('#subbtn').click(function() {
    	
        $.ajax({
            url : 'getinput',
            data : {
                query : $('#query').val()
            },
            success : function(responseText) {
                $('#answerbox').text(responseText);
                $('#questionbox').text($('#query').val()).css("font-weight","Bold").css("font-size","24px");
            }
        });
    });
});