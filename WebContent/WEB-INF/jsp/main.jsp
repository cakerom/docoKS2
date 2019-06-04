<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Login"%>
<%@ page import="model.GetMutterListLogic" %>
<%@ page import="model.Mutter"%>
<%@ page import="java.util.List"%>

<%
//セッションスコープに保存されたユーザー情報を取得
Login loginUser = (Login) session.getAttribute("login");

GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
List<Mutter> mutterList = getMutterListLogic.execute();

//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>docoKS2</title>
</head>
<body>
<h1>docoKS2メイン</h1>

<p>
<%= loginUser.getUserId() %>さん。ログイン中
<a href="/docoKS2/LogoutServlet">ログアウト</a>
</p>
<p><a href="/docoKS2/Main">更新</a></p>

<form action="/docoKS2/Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>

<% if(errorMsg != null) { %>
<p><%= errorMsg %></p>
<% } %>

<% for(Mutter mutter : mutterList) { %>
<p><%= mutter.getUserName() %>:<%= mutter.getText() %></p>
<% } %>
</body>
</html>