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
	<c:if test="${not empty missmsg}">
		<p class="error">${fn:escapeXml(missmsg)}</p>
	</c:if>
	<form:form action="game" modelAttribute="GameResultForm" method="post">
		<fieldset class="label-110">
			<div>
				<label class="required">Time:</label>
				<form:input path="timeVal" value="${fn:escapeXml(resultTime)}"
					readonly="true" />
			</div>
			<div>
				<label class="required">name:</label>
				<form:input path="nameVal" value="${fn:escapeXml(user.userName)}"
					readonly="true" />
			</div>
		</fieldset>
	</form:form>

	<form action="menu">
		<input type="submit" name="button" value="リトライ"
			onclick="location.href='game'; return false;"> <input
			type="submit" name="button" value="タイトルに戻る">
	</form>
</body>
</html>
