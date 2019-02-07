<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <a class="a-na-glavnuu" href="/">Назад</a>
    </div>
    <div class="main-title-page">
        Для входа заполните все поля и нажмите кнопку "Войти".
    </div>
</div>
<div class="display-flex start">
    <div class="column-20"></div>
    <form method="post" action="/login">
    <div CLASS="div-for-student-modifing div-class-for-button-error">
        <div class="display-flex"><label>Логин</label><input name="login" type="text"></div>
        <div class="display-flex"><label>Пароль</label><input name="pass" type="text"></div>
        <div class="div-student-select-role display-flex">
            <label>Выбрать роль</label>
            <div class="select">
                <select name="role" class="select-style">
                    <option value="3">студент</option>
                    <option value="1">администратор</option>
                </select>
            </div>
        </div>
        <div class="display-flex"><input type="submit" value="Войти"></div>
        <div class="display-flex start">


        </div>
        <div class="display-flex start">
            <div class="column-20">
            </div>
            <c:if test="${message == 1}">
                <div class="error-lable">
                    Пользователь не найден
                </div>
            </c:if>
        </div>
    </div>
    </form>
</div>
</body>
</html>