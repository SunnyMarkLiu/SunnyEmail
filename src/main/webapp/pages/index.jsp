<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sunny Email</title>
<meta name="description" content="">

<!-- core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/font-awesome.min.css" rel="stylesheet">
<link href="../css/prettyPhoto.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<link href="../css/responsive.css" rel="stylesheet">
<link href="../css/owl.carousel.css" rel="stylesheet">
<link href="../css/owl.theme.css" rel="stylesheet">
<link
	href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700,800'
	rel='stylesheet' type='text/css'>
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
	<%
		System.out.println("user: " + session.getAttribute("user"));
		if(session.getAttribute("user") == null) {
			response.sendRedirect("../login.jsp");
		}
	%> 
<body class="homepage">
	<header id="header">
		<nav class="navbar navbar-inverse" role="banner">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">
					<i class="fa fa-sun-o"></i> Sunny Email</a>
				</div>
				<div class="collapse navbar-collapse navbar-right" style="font-size: 20px;">
					<ul class="nav navbar-nav">
						<li style="font-size: 16px;"><a href="about.html">${user.emailAddress }</a></li>
						<li class="active"><a href="index.jsp">Home</a></li>
						<li><a href="about.html">收件箱</a></li>
						<li><a href="services.html">发件箱</a></li>
						<li><a href="portfolio.html">垃圾箱</a></li>
						<li><a href="pricing.html">垃圾邮件</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<div id="main-slide" class="carousel slide" data-ride="carousel">
		<div class="item active">
			<img class="img-responsive" src="../images/slider/bg1.jpg"
				alt="slider">
			<div class="slider-content">
				<div class="col-md-12 text-center">
					<h2>
						Welcome to <span class="logo">Sunny Email</span>
					</h2>
					<h3>Your intelligent email processor</h3>
					<p>
						<a href="about.html" class="slider btn">Read More</a>
					</p>
				</div>
			</div>
		</div>
	</div>

	<section id="feature">
		<div class="container">
			<div class="center">
				<h2 style="font-size: 40px;">Featured Services</h2>
				<hr>
				<p class="lead">
					Intelligent mail processing based on Machine Learning !
				</p>
			</div>
			<div class="row">
				<div class="features">
					<div class="col-md-4 col-sm-6">
						<div class="feature-wrap">
							<i class="fa fa-code"></i>
							<h2>Web Design</h2>
							<h3>Based on Struts2 + Hibernate4 + Spring4 + Bootstrap, Responsive layout, More beautiful</h3>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="feature-wrap">
							<i class="fa fa-laptop"></i>
							<h2>Less Spam</h2>
							<h3>Running Adaboost on Naive Bayes algorithm makes it more accuracy to filter spam email (ER = 0.5%)</h3>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="feature-wrap">
							<i class="fa fa-bullhorn"></i>
							<h2 style="font-size: 40px;">Using Priority</h2>
							<h3>Giveing emails some priorities created by learning algorithm, you can't miss some importent email !</h3>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section id="middle" style="text-align: center">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<h2>Want to discuss with me?</h2>
					<hr>
					<p style="color: #71B37B;font-size: 18px;">
						This project is OpenSource, you can fork this project on Github. Welcome to fork and pull some requests.
					</p>
					<a target="_blank" href="https://github.com/SunnyMarkLiu/SunnyEmail" class="btn btn-primary">Fork me on Github</a>
				</div>
			</div>
		</div>
	</section>
	<footer id="footer">
		<div class="container">
			<div class="row">
				<div class="col-sm-6" style="font-size: 18px;">
					Copyright &copy; 2016 <a target="_blank" href="https://github.com/SunnyMarkLiu">SunnyMarkLiu</a>. All rights reserved.
				</div>
				<div class="col-sm-6">
					<div class="follow-us">
						<a href="https://github.com/SunnyMarkLiu" class="fa">
							<img src="../images/github.png" style="width: 50px;">
						</a>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/jquery.prettyPhoto.js"></script>
	<script type="text/javascript" src="../js/jquery.isotope.min.js"></script>
	<script type="text/javascript" src="../js/owl.carousel.js"></script>
	<script type="text/javascript" src="../js/main.js"></script>
</body>
</html>