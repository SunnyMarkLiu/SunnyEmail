<%@page import="com.markliu.sunnyemail.entities.User"%>
<%@page import="com.markliu.sunnyemail.entities.EmailSented"%>
<%@page import="java.util.List"%>
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
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<link href="../css/show_emails.css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/email_ajax.js"></script>
<script type="text/javascript">
	
	function emaildelete(i){
		var button = $("#emailinbox"+i);
		var click_email_id = button.next().attr("id");
		var url = "/sunnyemail/email/emailSented_deleteEmailSented.action";
		var emailSented_id = button.children().first().text();
		console.log("emailSented_id: " + emailSented_id);
		var args = {"email_id" : click_email_id, "emailSented_id" : emailSented_id};
		$.post(url, args, function(result) {
			// 动态修改邮件的图标
			if(result == "1") {
				button.remove();
				
				var sjx = $("ul li:eq(3) b"); 
				var count2 = -1;
				if(sjx.text() != "") {
					count2 = parseInt(sjx.text());
					count2 = count2 - 1;
					if(count2 <= 0) {
						sjx.text("");
						$(".list-group").html("<div class=\"alert alert-warning\" role=\"alert\"><span style=\"color:#f39c12;\" class=\"glyphicon glyphicon-envelope\"></span>发件箱为空...</div>");
					} else {
						sjx.text(count2);
					}
				}
			}
		});
	}
	
	function add_attachments() {
		$(".add_attachments").append("<input STYLE=\"margin: 10px 0 10px 10px;\" name=\"attachments\" type=\"file\">");
	}
	
</script>
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
						<li style="font-size: 16px;"><a href="#">${user.emailAddress }</a></li>
						<li><a href="<%=request.getContextPath() %>/pages/index.jsp">Home</a></li>
						<li><a href="<%=request.getContextPath() %>/email/emailInbox_listInbox.action">收件箱 <s:if test="#session.totalEmailInboxCount != 0"><b id="emailInboxCount" style="color: #fff">${totalEmailInboxCount }</b></s:if></a></li>
						<li class="active"><a href="#">发件箱 <s:if test="#session.totalEmailSentedCount != 0"><b id="emailSentedCount" style="color: #fff">${totalEmailSentedCount }</b></s:if></a></li>
						<li><a href="<%=request.getContextPath() %>/email/emailSpam_listSpambox.action">垃圾箱 <s:if test="#session.totalEmailSpamCount != 0"><b id="emailSpamCount" style="color: #fff">${totalEmailSpamCount }</b></s:if></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	
	<div class="container email-info" style="padding-top: 40px;">
		<button class="btn btn-success btn-lg write_email" style="width: 100px;margin: 0 0 20px 20px;" data-toggle="modal" data-target="#write_email">写邮件</button>
		<div class="modal fade" id="write_email" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		 <div class="modal-dialog" role="document" style="width: 70%">
		   <div class="modal-content">
			   <form action="<%=request.getContextPath() %>/emailinfo/emailinfo_sendEmail.action" enctype="multipart/form-data" method="post">
			     <div class="modal-header">
			       <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button><br/><br/>
			        <div class="input-group input-group-lg">
					  <span class="input-group-addon" id="basic-addon1">主　题：</span>
					  <input name="subject" type="text" class="form-control subject" placeholder="subject" aria-describedby="basic-addon1">
					</div>
			        <div class="input-group input-group-lg">
					  <span class="input-group-addon" id="basic-addon1">收件人：</span>
					  <input name="toAddress" type="text" class="form-control toAddress" placeholder="Email Address" aria-describedby="basic-addon1">
					</div>
			      </div>
			      <div class="modal-body">
			      	<div>
			      		<h3>正文：</h3>
			      		<textarea id="Message" name="content" class="form-control content" style="min-height: 200px;"></textarea>
			      	</div>
			      	<div class="att">
						<h3 class="add_attachments">附件：<button type="button" class="btn btn-success btn-sm" onclick="add_attachments()">添加</button></h3>
			      	</div>
			      </div>
			      <div class="modal-footer">
			      	<input class="btn btn-success" type="submit" value="发送邮件" /></button>
			      </div>
			    </form>
		    </div>
		  </div>
		</div>
		
		<div class="list-group">
			<s:if test="#request.emailSentedbox == null || #request.emailSentedbox.size() == 0">
				<div class="alert alert-warning" role="alert">
				<span style="color:#f39c12;" class="glyphicon glyphicon-envelope"></span>
				  发件箱为空...
				</div>
			</s:if>
			<s:else>
				<%
					List<EmailSented> emailSentedboxs = (List<EmailSented>) request.getAttribute("emailSentedbox");
					for(int i=0 ; i<emailSentedboxs.size(); i++) {
						EmailSented emailSented = emailSentedboxs.get(i);
				%>
						<button id="emailinbox<%=i %>" class="list-group-item list-group-item-success" data-toggle="modal" data-target="#<%=emailSented.getEmail().getId()%>">
							<span class="emailInboxid" style="display: none;"><%=emailSented.getId() %></span>
							<div class="row">
								<span class="col-md-4" style="padding-left: 22px;">
									<span style="color:#f39c12;" class="glyphicon glyphicon-envelope"></span>
									<span style="padding-left: 20px;"><%=emailSented.getEmail().getFromAddress() %></span>
								</span>
								<span class="col-md-5"><%=emailSented.getEmail().getSubject() %></span>
								<span class="col-md-3"><%=emailSented.getEmail().getSentDate()%></span>
							</div>
						</button>
						<div class="modal fade" id="<%=emailSented.getEmail().getId()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						 <div class="modal-dialog" role="document" style="width: 70%">
						   <div class="modal-content">
						     <div class="modal-header">
						       <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						        <h3 style="padding-left: 22px;">主题：<%=emailSented.getEmail().getSubject() %></h3>
						        <h3 style="font-size: 16px;line-height: 4px;color: rgb(161, 168, 162);padding-left: 22px;"><span>发件人：</span><%=emailSented.getEmail().getFromAddress() %></h3>
						        <h3 style="font-size: 16px;line-height: 4px;color: rgb(161, 168, 162);padding-left: 22px;"><span>收件人：</span><%=emailSented.getEmail().getToAddress() %></h3>
						        <h3 style="font-size: 16px;line-height: 4px;color: rgb(161, 168, 162);padding-left: 22px;"><span>时间：</span><%=emailSented.getEmail().getSentDate() %></h3>
						      </div>
						      <div class="modal-body">
						      	<div class="content">
						      		<%=emailSented.getEmail().getContent() %>
						      	</div>
						      	<div class="att">
						      		<%
						      			if(emailSented.getEmail().isContainsAttachments()) {
						      		%>
									      	<h3>附件</h3>
						      		<%
						      				String attachmentFiles = emailSented.getEmail().getAttachmentFiles();
						      				String[] filenames = attachmentFiles.split(";");
						      				for(String filename : filenames) {
						      					filename = filename.trim();
						      					if(filename == "") continue;
						      					System.out.println("filename: " + filename);
						      					String  name = filename.substring(28);
						      		%>
						      					<h3>
						      					<a class="btn btn-success" href="<%=request.getContextPath() %>/emailinfo/fileDownload.action?fileName=<%=name %>">下载</a>
						      					<span style="margin: 0 10px 10px; 10px;"><%=name %></span>
						      					</h3>
						      		<%
						      				}
						      			}
						      		%>
						      	</div>
						      </div>
						      <div class="modal-footer">
						      	<button class="btn btn-success readed_close" data-dismiss="modal">关闭</button>
						        <button id="close_email" class="btn btn-danger" onclick="emaildelete('<%=i %>')" data-dismiss="modal">删除邮件</button>
						      </div>
						    </div>
						  </div>
						</div>
				<%
					}
				%>
			</s:else>
		</div>
	</div>
	
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
</body>
</html>