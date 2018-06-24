<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>
		今ログインしているユーザーの情報を削除します<br>よろしいですか？
	</p>

	<form:form action="deleteConfirm" method="post">
		<input type="submit" value="確認">
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>