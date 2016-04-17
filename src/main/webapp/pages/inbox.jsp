<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<link href="../css/main.css" rel="stylesheet">
<link href="../css/responsive.css" rel="stylesheet">
<link href="../css/owl.theme.css" rel="stylesheet">
<link
	href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700,800'
	rel='stylesheet' type='text/css'>
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<link href="../css/show_emails.css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/email_ajax.js"></script>
</head>
	<%
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
						<li><a href="<%=request.getContextPath()%>/pages/index.jsp">Home</a></li>
						<li class="active"><a href="#">收件箱 <s:if test="#session.totalEmailInboxCount != 0"><b id="emailInboxCount" style="color: #fff">${totalEmailInboxCount }</b></s:if></a></li>
						<li><a href="sent.jsp">发件箱 <s:if test="#session.totalEmailSentedCount != 0"><b id="emailSentedCount" style="color: #fff">${totalEmailSentedCount }</b></s:if></a></li>
						<li><a href="deleted.jsp">回收站 <s:if test="#session.totalEmailDeletedCount != 0"><b id="emailDeletedCount" style="color: #fff">${totalEmailDeletedCount }</b></s:if></a></li>
						<li><a href="spam.jsp">垃圾箱 <s:if test="#session.totalEmailSpamCount != 0"><b id="emailSpamCount" style="color: #fff">${totalEmailSpamCount }</b></s:if></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	
	<div class="container email-info">
		<div class="email-info-head" style="font-size: 18px;padding-left: 20px;">
			<p>1份邮件未读 <button type="button" class="btn btn-link" style="font-size: 18px;text-decoration:none;"> 全部标记已读</button></p>
		</div>
		
		<div class="list-group">
			<s:if test="#request.emailInboxs == null || #request.emailInboxs.size() == 0">
				<div class="alert alert-warning" role="alert">
				<span style="color:#f39c12;" class="glyphicon glyphicon-envelope"></span>
				  收件箱为空...
				</div>
			</s:if>
			<s:else>
				<s:iterator value="#request.emailInboxs" var="emailInbox">
					<button class="list-group-item list-group-item-success">
						<div class="row">
							<span class="col-md-4" style="padding-left: 22px;">
								<s:if test="emailInbox.email.isReaded">
									<span style="color:#c8c6c3;" class="glyphicon glyphicon-envelope"></span>
								</s:if>
								<s:else>
									<span style="color:#f39c12;" class="glyphicon glyphicon-envelope"></span>
								</s:else>
								<span style="padding-left: 20px;">${emailInbox.email.fromAddress }</span>
							</span>
							<span class="col-md-5">${emailInbox.email.subject }</span>
							<span class="col-md-3">${emailInbox.email.sentDate }</span>
						</div>
					</button>
				</s:iterator>
			</s:else>
		</div>
		
	</div>
	
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/jquery.isotope.min.js"></script>
	<script type="text/javascript" src="../js/main.js"></script>
</body>
</html>