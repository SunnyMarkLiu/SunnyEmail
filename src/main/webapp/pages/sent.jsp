<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>收件箱</title>
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
<body>
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
						<li><a href="index.jsp">Home</a></li>
						<li><a href="indox.jsp">收件箱 <span>1</span></a></li>
						<li class="active"><a href="sent.jsp">发件箱 <span>1</span></a></li>
						<li><a href="portfolio.html">垃圾箱 <span>1</span></a></li>
						<li><a href="pricing.html">垃圾邮件 <span>1</span></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
</body>
</html>