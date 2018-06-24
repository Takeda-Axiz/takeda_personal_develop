<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<title>ゲーム画面</title>
<meta name="description" content="${description}" />
<script
	src="http://cdn.rawgit.com/phi-jp/phina.js/v0.1.0/build/phina.js"></script>
<script src="js/gameSample.js"></script>
<script>
	${script}
</script>
</head>
<body>
	<p>
		ルール：プレイヤー周辺の画面をクリックするとゲームスタート
		<br>
		　　　　ゲームがスタートすると、常にマウスカーソルの下にプレイヤーがいます
		<br>
		　　　　画面の白い部分を通って、画面右端まで行くことができたらゲームクリアです
		<br>
		　　　　ただし、画面の黒い部分(壁)に一度でも触れると、ゲームオーバーです
		<br>
		プレイヤーアイコン：<img style="vertical-align: middle;" alt="player" src="img/PlayerBlock.png" width=20, height=20>
	</p>
</body>
</html>
