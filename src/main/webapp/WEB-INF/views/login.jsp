<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Вход - Арена Героев</title>
    <style>
        body { font-family: sans-serif; background-color: #2c3e50; color: white; text-align: center; padding: 50px; }
        form { background: #34495e; padding: 20px; display: inline-block; border-radius: 8px; }
        input { padding: 10px; margin: 10px 0; width: 200px; }
        button { padding: 10px 20px; background: #e74c3c; color: white; border: none; cursor: pointer; }
        button:hover { background: #c0392b; }
        a { color: #bdc3c7; text-decoration: none; }
    </style>
</head>
<body>
<h1>⚔️ Арена Героев ⚔️</h1>
<p>Ввойти в своего персонажа</p>

<form action="/login" method="post">
    <input type="text" name="username" placeholder="Логин" value="${requestScope.user.username}" required><br>
    <input type="password" name="password" placeholder="Пароль" value="${requestScope.user.password}" required><br>
    <button type="submit">Войти в игру</button>
</form>
<h2 style="color: #c0392b">${requestScope.errorMessage}</h2>

<br><br>
<a href="/">На главную</a>
</body>
</html>