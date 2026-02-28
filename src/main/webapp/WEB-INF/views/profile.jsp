<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Профиль - Арена Героев</title>
    <style>
        body { font-family: sans-serif; background-color: #2c3e50; color: white; padding: 30px; }
        .profile { max-width: 600px; margin: 0 auto; background: #34495e; padding: 30px; border-radius: 10px; }
        .stat { display: flex; justify-content: space-between; padding: 10px 0; border-bottom: 1px solid #7f8c8d; }
        .gold { color: #f1c40f; font-weight: bold; }
        .btn { display: inline-block; margin: 10px 5px; padding: 10px 20px; background: #e74c3c; color: white; text-decoration: none; border-radius: 5px; }
        .btn:hover { background: #c0392b; }
        .btn-secondary { background: #3498db; }
        .btn-secondary:hover { background: #2980b9; }
    </style>
</head>
<body>
<div class="profile">
    <h1>👤 Профиль: ${requestScope.user.username}</h1>

    <div class="stat">
        <span>Золото:</span>
        <span class="gold">${requestScope.user.gold} 💰</span>
    </div>
    <div class="stat">
        <span>Побед:</span>
        <span>${requestScope.user.wins} ⚔️</span>
    </div>
    <div class="stat">
        <span>Поражений:</span>
        <span>${requestScope.user.losses} 💀</span>
    </div>

    <br>
    <a href="/arena" class="btn">⚔️ На Арену</a>
    <a href="/shop" class="btn btn-secondary">🛒 Магазин</a>
    <a href="/logout" class="btn" style="background: #7f8c8d;">🚪 Выйти</a>
</div>
</body>
</html>