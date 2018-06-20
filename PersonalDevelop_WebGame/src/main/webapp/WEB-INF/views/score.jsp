<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記録閲覧</title>
</head>
<body>
	<table>
		<caption>検索結果</caption>
		<thead>
			<tr>
				<th></th>
				<th>クリアタイム</th>
				<th></th>
				<th>ユーザ名</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userlist}" var="user">
				<p>${fn:escapeXml(user.rank)}</p>
				<tr>
					<td>${fn:escapeXml(user.score)}</td>
				</tr>
				<p>by</p>
				<tr>
					<td>${fn:escapeXml(user.userName)}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>