<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:if test="${empty user}">
	<c:redirect url="/index" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>Welcome to ${fn:escapeXml(user.userName)}!</p>

	<div class="tbl">
		<table>
			<tr>
				<td><a href="update">ユーザ更新</a></td>
				<td><a href="delete">ユーザ削除</a></td>
				<td><a href="game">ゲーム</a></td>
				<td><a href="score">ハイスコア</a></td>
				<td><a href="logout">ログアウト</a></td>
			</tr>
		</table>
	</div>
</body>
</html>
