<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<html lang="en">
<head>
<title>Wizeebee</title>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
<link rel="stylesheet" href="style.css"/>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- <script src="http://code.jquery.com/jquery-1.10.2.js" -->
<!--     type="text/javascript"></script> -->
  
<script src="ajaxCall.js" type="text/javascript"></script>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-70332217-1', 'auto');
  ga('send', 'pageview');

</script>
</head>
<body>

	<div class="container">
		
			<img src="wizeelogo.jpg" class="" alt="WizeeLogo" width="300" height="100"></img>
		<hr/>
		<div class="row">
			<div class="col-sm-12">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
					<li><a data-toggle="tab" href="#features">What is it ?</a></li>
					<li><a data-toggle="tab" href="#howitworks">How it Works ?</a></li>
					<li><a data-toggle="tab" href="#team">Team</a></li>
				</ul>

				<div class="tab-content">
					<div id="home" class="tab-pane fade in active">
						
						<div id="formdiv">
						<br />
						<form id="searchform">
							<h3>What do you want to ask ?</h3>
<!-- 							<div class="form-group"> -->
								<input type="text"  class="form-control" id="query"	/>
<!-- 							</div> -->
<!-- 							<button type="submit" id="subbtn" class="btn btn-default">Submit</button> -->
									<br/>
								<input type="button" id="subbtn" class="btn btn-default" value="Submit"/>
						</form><hr/>
						</div>
<%-- 						<% if(request.getAttribute("answer")!=null) {	%> --%>
						<div id="loading"></div><br/>
						<div id="questionbox">
							<h5>Your Question</h5>
<%-- 							<%=request.getAttribute("asked")%> --%>
						</div>
						<br/>
						<div id="answerbox">						
							<h5>Wizeebee's answer</h5>
<%-- 							<%=request.getAttribute("answer") %> --%>
						</div>	
<%-- 						<%} %> --%>
						
					</div>
					<div id="features" class="tab-pane fade">
						<h3>What is it ?</h3>
						<p>IQP is a question-and-answer website where questions are
							asked by users but are answered, edited and organised by an
							intelligent program.</p>
						<p>It is intended to provide a fast way to get the answers of
							the queries of the users dynamically with the use of an
							intelligent program. The program will categorise the query and
							then mine the web to get the appropriate answer. Also the answer
							returned from web will be further analysed by applying text
							mining to refine it more.</p>
					</div>
					<div id="team" class="tab-pane fade">
						<br/><br/>
						<div id="team-display" class="center">
						
						<div class="row">
							<div class="col-sm-2"></div>
							<div class="col-sm-2">
							<img src="ankita.jpg" class="img-circle" alt="Ankita" width="150" height="185"></img>
							<br/><h4>The Classifier	</h4>						
							</div>
							<div class="col-sm-2">
							<img src="nitts.jpg" class="img-circle" alt="Nitish" width="150" height="185"></img>
							<br/><h4>The Web Miner	</h4>						
							</div>
							<div class="col-sm-2">
							<img src="kovid.jpg" class="img-circle" alt="Kovid" width="150" height="185"></img>	
							<br/><h4>The NLPist	</h4>					
							</div>
							<div class="col-sm-2">
							<img src="raveena.jpg" class="img-circle" alt="Raveena" width="150" height="185"></img>
							<br/><h4>The Summariser	</h4>						
							</div>
							<div class="col-sm-2"></div>
						</div>
						</div>
					</div>
					<div id="howitworks" class="tab-pane fade">
						<h3>How it works ?</h3>
							<div id="howitworks" class="center">
							<img src="dfd.jpg" class="" alt="Data Flow Diagram" width="600" height="400"></img>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
