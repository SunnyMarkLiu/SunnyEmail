/**
 * ajax 异步获取邮件数据
 */

$(document).ready(function() {
	console.log("ajax")
	// ajax 异步调用 action
	var url = "http://127.0.0.1:8080/sunnyemail/user/user_ajaxListInfo.action";
	setInterval(function() {
		var args = {
			"time" : new Date()
		}
		$.post(url, args, function(result) {
			var result = jQuery.parseJSON(result); // 解析json数据
			$("#emailInboxCount").text(result.emailInboxCount);
			$("#emailSentedCount").text(result.emailSentedCount);
			$("#emailDeletedCount").text(result.emailDeletedCount);
			$("#emailSpamCount").text(result.emailSpamCount);
		});
	}, 1000 * 2); // 一分钟后重新 ajax 获取数据，如果有更新，刷新页面

});