$(document).ready(function() {
	$('#subbtn').click(function() {
		$("#loading").append('<img src="ajax-loader.gif">');
		//var originalText = $("#loading").text(),
		i  = 0;
		var intervalID = setInterval(function() {
		if(i==0)
		{
		$("#loading").text("Query Received");			
		}
		if(i==1 )
		{
		$("#loading").text("Categorizing");	
		}
		if(i==2)
		{
		$("#loading").text("Searching the Web");		
		}
		if(i == 3)
		{
		$("#loading").text("Getting result");		
		}
//		if(i == 4)
//		{
//		return;
//		}
		i++;

		}, 800);


		$.ajax({
			url : 'getinput',
			data : {
				query : $('#query').val()
			},
			success : function(responseText) {
				var answer = responseText.toString().trim();
				if(!answer)
				{
					$('#questionbox').text($('#query').val()).css("font-weight","Bold").css("font-size","24px");
					$("#answerbox").text("Sorry. I don't know this.");
					$("#loading").empty();
					clearInterval(intervalID);
				}
				else{
					$('#answerbox').text(responseText);
					$('#questionbox').text($('#query').val()).css("font-weight","Bold").css("font-size","24px");
					$("#loading").empty();
					clearInterval(intervalID);
				}
			}
		});
	});
});