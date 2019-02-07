<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Список всех студентов</title>
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<div class="display-flex centre">
    <div></div>
    <div><h1>Система управления студентами и их успеваемостью</h1></div>
    <c:choose>
        <c:when test="${isLogin=='true'}">
            <div class="logout-div"><a href="/logout" class="logout-link">Logout</a></div>
        </c:when>
        <c:otherwise>
            <div class="logout-div"><a href="/login" class="logout-link">Login</a></div>
        </c:otherwise>
    </c:choose>
</div>
<div class="display-flex start padding-top-10">
    <div class="column-20">
        <a class="a-na-glavnuu" href="/">На главную</a>
        <a class="a-na-glavnuu" href="/studets">Назад</a>
    </div>
    <div class="main-title-page">
        Для модификации, введите новые значения и нажмите кнопку "Применить".
    </div>
</div>
<div class="display-flex start">
    <div class="column-20"></div>
    <form action="/studet-modify" method="post" >
    <div CLASS="div-for-student-modifing">
        <input type="hidden" name="id" value="${studentselect.id}">
        <div class="display-flex"><label>Фамилия</label><input type="text" name="surname" value="${studentselect.surname}"></div>
        <div class="display-flex"><label>Имя</label><input type="text" name="name" value="${studentselect.name}"></div>
        <div class="display-flex"><label>Группа</label><input type="text" name="group" value="${studentselect.group}"></div>
        <div CLASS="display-flex"><label>Дата поступления</label><input name="date" type="text" value="${studentselect.date}"></div>
        <div class="display-flex"><input type="submit" value="Применить"></div>
    </div>
    </form>
</div>
</body>
</html>