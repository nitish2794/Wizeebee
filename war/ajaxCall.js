$(document).ready(function() {
    $('#query').blur(function() {
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