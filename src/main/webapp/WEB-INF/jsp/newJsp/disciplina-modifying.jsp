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
    <div class="logout-div"><a href="/logout" class="logout-link">Logout</a></div>
</div>
<div class="display-flex start padding-top-10">
    <div class="column-20">
        <a class="a-na-glavnuu" href="/">На главную</a>
        <a class="a-na-glavnuu" href="/">Назад</a>
    </div>
    <div class="main-title-page">
        Для того чтобы модифицировать дисциплину введите новое значение и нажмите кнопку "Применить".
    </div>
</div>
<div id="discipline-creating" class="display-flex start">
    <div class="column-20"></div>
    <div CLASS="div-for-student-modifing">
        <form action="/disciplina-modifying" method="post">
            <input type="hidden" name="idDisModHidden" value="${dis.id}">
            <div class="display-flex"><label>Название</label><input name="newDisciplinaName" type="text" value="${dis.disciplina}"></div>
            <div class="display-flex"><input type="submit" value="Применить"></div>
        </form>
    </div>
</div>
</body>
</html>