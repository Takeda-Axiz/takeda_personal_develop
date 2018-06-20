<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>１箇所以上の項目を変更してください</p>

	<c:if test="${not empty errmsg}">
		<p class="error">${fn:escapeXml(errmsg)}</p>
	</c:if>

	<form:form action="update" modelAttribute="UpdateForm"
		method="post">
		<fieldset>
			<div>
				<label>名前</label>
				<form:input path="nameVal" value="${fn:escapeXml(user.userName)}" />
			</div>
			<div>
				<label>PASS</label>
				<form:password path="passVal" value="${fn:escapeXml(user.password)}" />
			</div>
			<div>
				<label>PASS（再入力）</label>
				<form:password path="rePassVal" value="" />
			</div>
		</fieldset>
		<div>
			<input type="submit" name="button" value="確認">
		</div>
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>
