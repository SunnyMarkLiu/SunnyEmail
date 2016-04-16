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
		<ol class="carousel-indicators">
			<li data-target="#main-slide" data-slide-to="0" class="active"></li>
			<li data-target="#main-slide" data-slide-to="1"></li>
			<li data-target="#main-slide" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<img class="img-responsive" src="../images/slider/bg1.jpg" alt="slider">
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
			<div class="item">
				<img class="img-responsive" src="../images/slider/bg2.jpg" alt="slider">
				<div class="slider-content">
					<div class="col-md-12 text-center">
						<h2>
							<strong>Responsive</strong> Design
						</h2>
						<h3>Responsive, Easy to Customize and Ready for Your Business</h3>
						<p>
							<a href="portfolio.html" class="slider btn">View Portfolio</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="img-responsive" src="../images/slider/bg3.jpg" alt="slider">
				<div class="slider-content">
					<div class="col-md-12 text-center">
						<h2>
							<strong>Easy</strong> to Customize
						</h2>
						<h3>Responsive, Easy to Customize and Ready for Your Business</h3>
						<p>
							<a href="portfolio.html" class="slider btn">View Portfolio</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#main-slide" data-slide="prev">
			<span><i class="fa fa-angle-left"></i></span>
		</a> <a class="right carousel-control" href="#main-slide"
			data-slide="next"> <span><i class="fa fa-angle-right"></i></span>
		</a>
	</div>
	<section id="feature">
		<div class="container">
			<div class="center">
				<h2>Featured Services</h2>
				<hr>
				<p class="lead">
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin non
					odio sed eros tristique bibendum. Nunc quis semper sem.<br>
					Morbi libero elit elementum quis faucibus ac, condimentum quis
					nibh. <a href="services.html">View all Services →</a>
				</p>
			</div>
			<div class="row">
				<div class="features">
					<div class="col-md-4 col-sm-6">
						<div class="feature-wrap">
							<i class="fa fa-laptop"></i>
							<h2>Web Design</h2>
							<h3>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Proin non odio sed eros tristique.</h3>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="feature-wrap">
							<i class="fa fa-code"></i>
							<h2>Development</h2>
							<h3>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Proin non odio sed eros tristique.</h3>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="feature-wrap">
							<i class="fa fa-bullhorn"></i>
							<h2>Marketing</h2>
							<h3>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Proin non odio sed eros tristique.</h3>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section id="recent-works">
		<div class="container">
			<div class="center">
				<h2>Recent Works</h2>
				<hr>
				<p class="lead">
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin non
					odio sed eros tristique bibendum. Nunc quis semper sem.<br>
					Morbi libero elit elementum quis faucibus ac, condimentum quis
					nibh. <a href="portfolio.html" class="readmore">View all Works
						→</a>
				</p>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-4 col-md-4">
					<div class="recent-work-wrap">
						<img class="img-responsive" src="images/portfolio/small/item1.jpg"
							alt="">
						<div class="overlay">
							<div class="recent-work-inner">
								<h3>
									<a href="#">Project Title</a>
								</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Proin non odio sed eros tristique bibendum.</p>
								<a class="preview" href="images/portfolio/full/item1.jpg"
									rel="prettyPhoto" title=""><i class="fa fa-search"></i>
									View</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-4">
					<div class="recent-work-wrap">
						<img class="img-responsive" src="images/portfolio/small/item2.jpg"
							alt="">
						<div class="overlay">
							<div class="recent-work-inner">
								<h3>
									<a href="#">Project Title</a>
								</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Proin non odio sed eros tristique bibendum.</p>
								<a class="preview" href="images/portfolio/full/item2.jpg"
									rel="prettyPhoto"><i class="fa fa-search"></i> View</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-4">
					<div class="recent-work-wrap">
						<img class="img-responsive" src="images/portfolio/small/item3.jpg"
							alt="">
						<div class="overlay">
							<div class="recent-work-inner">
								<h3>
									<a href="#">Project Title</a>
								</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Proin non odio sed eros tristique bibendum.</p>
								<a class="preview" href="images/portfolio/full/item3.jpg"
									rel="prettyPhoto"><i class="fa fa-search"></i> View</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-4">
					<div class="recent-work-wrap">
						<img class="img-responsive" src="images/portfolio/small/item4.jpg"
							alt="">
						<div class="overlay">
							<div class="recent-work-inner">
								<h3>
									<a href="#">Project Title</a>
								</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Proin non odio sed eros tristique bibendum.</p>
								<a class="preview" href="images/portfolio/full/item4.jpg"
									rel="prettyPhoto"><i class="fa fa-search"></i> View</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-4">
					<div class="recent-work-wrap">
						<img class="img-responsive" src="images/portfolio/small/item5.jpg"
							alt="">
						<div class="overlay">
							<div class="recent-work-inner">
								<h3>
									<a href="#">Project Title</a>
								</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Proin non odio sed eros tristique bibendum.</p>
								<a class="preview" href="images/portfolio/full/item5.jpg"
									rel="prettyPhoto"><i class="fa fa-search"></i> View</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-4">
					<div class="recent-work-wrap">
						<img class="img-responsive" src="images/portfolio/small/item6.jpg"
							alt="">
						<div class="overlay">
							<div class="recent-work-inner">
								<h3>
									<a href="#">Project Title</a>
								</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Proin non odio sed eros tristique bibendum.</p>
								<a class="preview" href="images/portfolio/full/item6.jpg"
									rel="prettyPhoto"><i class="fa fa-search"></i> View</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<div class="copyrights">
		Collect from <a href="http://www.cssmoban.com/">网页模板</a>
	</div>
	<section id="testimonials" class="text-center">
		<div class="container">
			<div class="center">
				<h2>What Our Clients Say</h2>
				<hr>
			</div>
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<div id="testimonial" class="owl-carousel owl-theme">
						<div class="item">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Duis sed dapibus leo nec ornare diam. Sed commodo nibh ante
								facilisis bibendum dolor feugiat at duis sed dapibus leo nec
								ornare diam.</p>
							<p>
								<strong>John DOE</strong>, CEO, Company.
							</p>
						</div>
						<div class="item">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Duis sed dapibus leo nec ornare diam. Sed commodo nibh ante
								facilisis bibendum dolor feugiat at duis sed dapibus leo nec
								ornare diam.</p>
							<p>
								<strong>Jenny DOE</strong>, CEO, Company.
							</p>
						</div>
						<div class="item">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Duis sed dapibus leo nec ornare diam. Sed commodo nibh ante
								facilisis bibendum dolor feugiat at duis sed dapibus leo nec
								ornare diam.</p>
							<p>
								<strong>John DOE</strong>, CEO, Company.
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section id="middle">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<h3>Some Facts About Us</h3>
					<br>
					<div class="media">
						<i class="fa fa-smile-o pull-left fa-3x"></i>
						<div class="media-body">
							<h3 class="media-heading">120+ Happy Clients</h3>
							Etiam eget nisl vel justo suscipit ullamcorper sed at lacus.
						</div>
					</div>
					<br>
					<div class="media">
						<i class="fa fa-check-square-o pull-left fa-3x"></i>
						<div class="media-body">
							<h3 class="media-heading">600+ Projects Completed</h3>
							Sed scelerisque nunc quis est efficitur dictum vivamus commodo.
						</div>
					</div>
					<br>
					<div class="media">
						<i class="fa fa-trophy pull-left fa-3x"></i>
						<div class="media-body">
							<h3 class="media-heading">25 Awards Won</h3>
							Pellentesque hendrerit arcu luctus facilisis erat consectetur.
						</div>
					</div>
					<a href="about.html" class="readmore">Read More →</a>
				</div>
				<div class="col-sm-6">
					<div class="accordion">
						<h3>Questions & Answers</h3>
						<br>
						<div class="panel-group" id="accordion1">
							<div class="panel panel-default">
								<div class="panel-heading active">
									<h3 class="panel-title">
										<a class="accordion-toggle" data-toggle="collapse"
											data-parent="#accordion1" href="#collapseOne1"> Vivamus
											commodo nisi risus? <i class="fa fa-angle-right pull-right"></i>
										</a>
									</h3>
								</div>
								<div id="collapseOne1" class="panel-collapse collapse in">
									<div class="panel-body">
										<div class="media accordion-inner">
											<div class="media-body">Lorem ipsum dolor sit amet,
												consectetur adipiscing elit. Etiam eget nisl vel justo
												suscipit ullamcorper sed at lacus. Aliquam euismod nunc id
												eros sollicitudin interdum. Integer eget sem nec nulla
												dictum dictum.</div>
										</div>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">
										<a class="accordion-toggle" data-toggle="collapse"
											data-parent="#accordion1" href="#collapseTwo1"> Etiam
											eget vel justo suscipit ullamcorpe? <i
											class="fa fa-angle-right pull-right"></i>
										</a>
									</h3>
								</div>
								<div id="collapseTwo1" class="panel-collapse collapse">
									<div class="panel-body">Lorem ipsum dolor sit amet,
										consectetur adipiscing elit. Etiam eget nisl vel justo
										suscipit ullamcorper sed at lacus. Aliquam euismod nunc id
										eros sollicitudin interdum. Integer eget sem nec nulla dictum
										dictum.</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">
										<a class="accordion-toggle" data-toggle="collapse"
											data-parent="#accordion1" href="#collapseThree1"> Integer
											eget sem nec nulla dictum dictum? <i
											class="fa fa-angle-right pull-right"></i>
										</a>
									</h3>
								</div>
								<div id="collapseThree1" class="panel-collapse collapse">
									<div class="panel-body">Lorem ipsum dolor sit amet,
										consectetur adipiscing elit. Etiam eget nisl vel justo
										suscipit ullamcorper sed at lacus. Aliquam euismod nunc id
										eros sollicitudin interdum. Integer eget sem nec nulla dictum
										dictum.</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">
										<a class="accordion-toggle" data-toggle="collapse"
											data-parent="#accordion1" href="#collapseFour1"> Maecenas
											tincidunt venenatis tempus? <i
											class="fa fa-angle-right pull-right"></i>
										</a>
									</h3>
								</div>
								<div id="collapseFour1" class="panel-collapse collapse">
									<div class="panel-body">Lorem ipsum dolor sit amet,
										consectetur adipiscing elit. Etiam eget nisl vel justo
										suscipit ullamcorper sed at lacus. Aliquam euismod nunc id
										eros sollicitudin interdum. Integer eget sem nec nulla dictum
										dictum.</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section id="get-started">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<h2>Want to discuss a project?</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam
						eget nisl vel justo suscipit ullamcorper sed at lacus.<br>
						Aliquam euismod nunc id eros sollicitudin interdum.
					</p>
					<a href="contact.html" class="btn btn-primary">Contact us</a>
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