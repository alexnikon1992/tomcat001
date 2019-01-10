<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Список всех студентов</title>
    <link rel="stylesheet" href="../../resources/css/style.css">
</head>
<body>
<div class="display-flex centre">
    <div></div>
    <div><h1>Система управления студентами и их успеваемостью</h1></div>
    <div class="logout-div"><a href="/logout" class="logout-link">Logout</a></div>
</div>
<div id="div-title-link">
    <div class="title-page">
        <a href="/studets">Студенты</a>
        <a href="/disciplina-list-cont">Дисциплины</a>
        <a href="/term-list">Семестры</a>
    </div>
</div>

</body>
</html>