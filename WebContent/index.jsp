<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>docoKS2</title>
</head>
<body>
<h1>docoKS2トップ画面</h1>

<form action="/docoKS2/LoginServlet" method="post">
ユーザー名:<input type="text" name="userId"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="ログイン">

</form>
</body>
</html>