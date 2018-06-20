<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ゲーム結果画面</title>
</head>
<body>
	<div>
		<p>Time:${fn:escapeXml(user.rank)}</p>
		<p>name:${fn:escapeXml(user.rank)}</p>
	</div>
	<form action="menu">
		<input type="submit" name="button" value="リトライ" onclick="location.href='game'; return false;">
		<input type="submit" name="button" value="タイトルに戻る">
	</form>
</body>
</html>