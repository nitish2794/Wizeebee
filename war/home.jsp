<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<html lang="en">
<head>
<title>Wizee</title>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet"
			href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
			<link rel="stylesheet" href="style.css">
				<script
					src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
				<script
					src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
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
						<br />
						<form action="getinput" role="form" id="searchform">
							<h3>What do you want to ask ?</h3>
							<div class="form-group">
								<input type="text" name="query" class="form-control" id="query">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form><hr/>
						<% if(request.getAttribute("answer")!=null) {%>
						<div id="answerbox">
							<h3>Wizee answer</h3>
							<%=request.getAttribute("answer") %>
						</div>
						<%} %>
					</div>
					<div id="features" class="tab-pane fade">
						<h3>What is it ?</h3>
						<p>IQP is a question-and-answer website where questions are
							asked by users but are answered, edited and organized by an
							intelligent program.</p>
						<p>It is intended to provide a fast way to get the answers of
							the queries of the users dynamically with the use of an
							intelligent program. The program will categorize the query and
							then mine the web to get the appropriate answer. Also the answer
							returned from web will be further analyzed by applying text
							mining to refine it more.</p>
					</div>
					<div id="team" class="tab-pane fade">
						<br/><br/>
						<div id="team-display" class="center">
						
						<div class="row">
							<div class="col-sm-2"></div>
							<div class="col-sm-2">
							<img src="kovid.jpg" class="img-circle" alt="Ankita" width="150" height="185"></img>
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
							<img src="nitts.jpg" class="img-circle" alt="Raveena" width="150" height="185"></img>
							<br/><h4>The Summariser	</h4>						
							</div>
							<div class="col-sm-2"></div>
						</div>
						</div>
					</div>
					<div id="howitworks" class="tab-pane fade">
						<h3>How it works ?</h3>
							<div id="howitworks" class="center">
							<img src="dfd.jpg" class="" alt="Nitish" width="600" height="400"></img>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
