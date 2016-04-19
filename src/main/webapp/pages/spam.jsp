<%@page import="com.markliu.sunnyemail.entities.EmailSpam"%>
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
		var url = "/sunnyemail/email/emailSpam_deleteSpamEmail.action";
		var emailSpam_id = button.children().first().text();
		var args = {"emailSpam_id" : emailSpam_id};
		$.post(url, args, function(result) {
			// 动态修改邮件的图标
			if(result == "1") {
				button.remove();
				
				var sjx = $("ul li:eq(4) b"); // 垃圾箱减一
				var count2 = -1;
				if(sjx.text() != "") {
					count2 = parseInt(sjx.text());
					count2 = count2 - 1;
					if(count2 <= 0) {
						sjx.text("");
						$(".list-group").html("<div class=\"alert alert-warning\" role=\"alert\"><span style=\"color:#f39c12;\" class=\"glyphicon glyphicon-envelope\"></span>垃圾箱为空...</div>");
					} else {
						sjx.text(count2);
					}
				}
			}
		});
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
						<li><a href="<%=request.getContextPath() %>/email/emailSented_listSentedbox.action">发件箱 <s:if test="#session.totalEmailSentedCount != 0"><b id="emailSentedCount" style="color: #fff">${totalEmailSentedCount }</b></s:if></a></li>
						<li class="active"><a href="#">垃圾箱 <s:if test="#session.totalEmailSpamCount != 0"><b id="emailSpamCount" style="color: #fff">${totalEmailSpamCount }</b></s:if></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	
	<div class="container email-info" style="padding-top: 40px;">
		<a href="<%=request.getContextPath() %>/email/emailSpam_clearAll.action" class="btn btn-success btn-lg " style="width: 200px;margin: 0 0 20px 20px;">清空所有垃圾邮件</a>
		<div class="list-group">
			<s:if test="#request.emailSpams == null || #request.emailSpams.size() == 0">
				<div class="alert alert-warning" role="alert">
				<span style="color:#f39c12;" class="glyphicon glyphicon-envelope"></span>
				  垃圾箱为空...
				</div>
			</s:if>
			<s:else>
				<%
					List<EmailSpam> emailSpams = (List<EmailSpam>) request.getAttribute("emailSpams");
					for(int i=0 ; i<emailSpams.size(); i++) {
						EmailSpam emailSpam = emailSpams.get(i);
				%>
						<button id="emailinbox<%=i %>" class="list-group-item list-group-item-success" data-toggle="modal" data-target="#<%=emailSpam.getEmail().getId()%>">
							<span class="emailInboxid" style="display: none;"><%=emailSpam.getId() %></span>
							<div class="row">
								<span class="col-md-4" style="padding-left: 22px;">
										<span style="color:#f39c12;" class="glyphicon glyphicon-envelope"></span>
									<span style="padding-left: 20px;"><%=emailSpam.getEmail().getFromAddress() %></span>
								</span>
								<span class="col-md-5"><%=emailSpam.getEmail().getSubject() %></span>
								<span class="col-md-3"><%=emailSpam.getEmail().getSentDate()%></span>
							</div>
						</button>
						<div class="modal fade" id="<%=emailSpam.getEmail().getId()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						 <div class="modal-dialog" role="document" style="width: 70%">
						   <div class="modal-content">
						     <div class="modal-header">
						       <button type="button" class="close" onclick="emailread('<%=i %>')" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						        <h3 style="padding-left: 22px;">主题：<%=emailSpam.getEmail().getSubject() %></h3>
						        <h3 style="font-size: 16px;line-height: 4px;color: rgb(161, 168, 162);padding-left: 22px;"><span>发件人：</span><%=emailSpam.getEmail().getFromAddress() %></h3>
						        <h3 style="font-size: 16px;line-height: 4px;color: rgb(161, 168, 162);padding-left: 22px;"><span>收件人：</span><%=emailSpam.getEmail().getToAddress() %></h3>
						        <h3 style="font-size: 16px;line-height: 4px;color: rgb(161, 168, 162);padding-left: 22px;"><span>时间：</span><%=emailSpam.getEmail().getSentDate() %></h3>
						      </div>
						      <div class="modal-body">
						      	<div class="content">
						      		<%=emailSpam.getEmail().getContent() %>
						      	</div>
						      	<div class="att">
						      		<%
						      			if(emailSpam.getEmail().isContainsAttachments()) {
						      		%>
									      	<h3>附件</h3>
						      		<%
						      				String attachmentFiles = emailSpam.getEmail().getAttachmentFiles();
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