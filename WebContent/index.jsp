<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="./css/reset.css" type="text/css" />
<link rel="stylesheet" href="./css/basic.css" type="text/css" />
<style type="text/css">
div#header {
	margin-bottom: 15px;
}

dd {
	padding: 0 0 40px 0;
}

p.page {
	float: left;
	padding: 0 10px 0 0;
}

div.body {
	width: 800px;
	padding: 0 0 0 90px;
}

div.body dl {
	width: 200px;
	float: left;
}

div.search {
	padding-left: 600px;
}

div.main {
	padding-top: 25px;
}

div.pager {
	clear: both;
}

div.page {
	clear: both;
}
</style>
<title>ゲーム選択画面</title>
</head>
<body>
	<s:form cssClass="form-horizontal">
		<p>
			<s:submit method="blackJack" value="ブラックジャック" />
		</p>
		<p>
			<s:submit method="poker" value="ポーカー" />
		</p>
	</s:form>
</body>
</html>