$(document).ready(function() {
    $('#subbtn').submit(function() {
    	alert("Ajax");
        $.ajax({
            url : 'getinput',
            data : {
                query : $('#query').val()
            },
            success : function(responseText) {
                $('#answerbox').text(responseText);
            }
        });
    });
});