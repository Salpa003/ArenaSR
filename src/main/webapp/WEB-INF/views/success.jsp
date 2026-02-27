<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Успех! - Арена Героев</title>
    <style>
        body { font-family: sans-serif; background-color: #27ae60; color: white; text-align: center; padding: 50px; }
        .box { background: #2ecc71; padding: 30px; display: inline-block; border-radius: 8px; }
        h1 { margin: 0 0 20px 0; }
        a { color: white; text-decoration: underline; }
    </style>
</head>
<body>
<div class="box">
    <h1>✅ Добро пожаловать на Арену!</h1>
    <p>Пользователь <b>${username}</b> успешно зарегистрирован</p>
    <p>На твой счет зачислено <b>100 золота</b> </p>
    <br>
    <a href="/register">Зарегистрировать еще одного</a>
</div>
</body>
</html>