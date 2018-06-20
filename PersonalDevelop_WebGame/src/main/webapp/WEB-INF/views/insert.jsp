<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>
		登録情報を入力してください<br> <span class="required"></span>は必須です
	</p>

	<c:if test="${not empty errmsg}">
		<p class="error">${fn:escapeXml(errmsg)}</p>
	</c:if>

	<form:form action="insertResult" modelAttribute="InsertForm"
		method="post">
		<fieldset class="label-110">
			<div>
				<label class="required">名前</label>
				<form:input path="nameVal"
					value="${fn:escapeXml(registerUser.userName)}" />
			</div>
			<div>
				<label class="required">PASS</label>
				<form:password path="passVal"
					value="${fn:escapeXml(registerUser.password)}" />
			</div>
			<div>
				<label class="required">PASS（再入力）</label>
				<form:password path="rePassVal"
					value="${fn:escapeXml(registerUser.rePassword)}" />
			</div>
		</fieldset>
		<input type="submit" value="確認">
	</form:form>
	<div>
		<a href="menu">タイトルに戻る</a>
	</div>
</body>
</html>
