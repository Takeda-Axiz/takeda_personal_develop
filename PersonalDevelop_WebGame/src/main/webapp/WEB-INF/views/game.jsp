<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ゲーム画面</title>
</head>
<body>
	<p>ストップウォッチ動作中…<br>止める場合はストップを押してください</p>
	<form:form action="gameResult" method="post">
		<input type="submit" name="button" value="ストップ">
	</form:form>
</body>
</html>
