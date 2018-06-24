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
			<c:if test="${not empty playlist}">
				<c:forEach items="${playlist}" var="playing">
					<tr>
						<td>${fn:escapeXml(playing.rank)}</td>
						<td>${fn:escapeXml(playing.score)}</td>
						<td>by</td>
						<td>${fn:escapeXml(playing.userName)}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<div>
		<a href="menu">タイトルに戻る</a>
	</div>
</body>
</html>