<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Sunny Email Login</title>

<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="keywords" content="email spam filter" />

<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/login.css" rel="stylesheet" type="text/css" media="all"/>
<style type="text/css">
	body {
		background-image:
			url(images/background.jpg);
		background-attachment: fixed;
		background-repeat: no-repeat;
		background-size: cover;
		-moz-background-size: cover;
		-webkit-background-size: cover;
	}
</style>
</head>
<body >
	<div class="newsletter">
		<div class="newsletter-main">
			<div class="stamp">
				<img src="images/stamp.png" alt="">
			</div>
			<h1><b>Sunny Email</b></h1>
			<div class="design">
				<img src="images/design.png">
			</div>
			<p>Intelligent mail processing based on Machine Learning !</p>
			<a href="#" class="signup">Sign up right now!</a>
			<form action="/sunnyemail/user/user_login.action" method="post">
				<input name="emailAddress" type="text"
					value="Enter Your email address" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Enter Your email address';}">
				<input name="password" type="text" value="Enter Your email password"
					onfocus="this.value = '';this.type='password';"
					onblur="if (this.value == '') {this.type='text';this.value = 'Enter Your email password';}">
				<input type="submit" value="Login Now">
			</form>
			<div class="design">
				<img src="images/design.png">
			</div>
			<p>WHUT Graduation Design</p>
		</div>
	</div>
	<div class="copy-right">
		<p>
			Copyright &copy; 2016. <img src="images/github.png" style="width: 2%;">
			<a target="_blank" href="https://github.com/SunnyMarkLiu">SunnyMarkLiu</a> All rights
			reserved.
		</p>
	</div>
</body>
</html>