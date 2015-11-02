/**
 * This js file contains the ajax function
 */
$(document).ready(function() {
	$("#query").blur(function() {
        alert('Ajax called');
		$.ajax({
            url : 'getinput',
            data : {
                alert('in data');
            	query : $('#query').val();
            },
            success : function(responseText) {
            	alert('in success');
                $('#answerbox').text(responseText);
            }
        });
    });
});