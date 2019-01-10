<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Список всех студентов</title>
    <link rel="stylesheet" href="../resources/css/style.css">
    <script src="../resources/js/buttonFunction.js"></script>
    <script src="../resources/js/jquery.min.js"></script>
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
    </div>
    <div class="main-title-page">
        Список дисциплин
    </div>
</div>

<div id="disciplina-list" class="display-flex start for-mobile-display-block">
    <div class="column-20"></div>
    <div>
        <table class="table-main-info table-student-progress">
            <tr>
                <th></th>
                <th>Наименование дисциплины</th>
            </tr>
            <c:forEach items="${disciplinalist}" var="currentDist">
                <tr>
                    <td><input type="checkbox" id="${currentDist.id}"></td>
                    <td>${currentDist.disciplina}</td>

                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="div-student-progress-select-semestr">
        <div class=" mobile-div">
            <div>
                <form action="/disciplina-creating" method="get">
                    <input class="big-big-button" type="submit" value="Создать дисциплину...">
                </form>
            </div>
            <div>
                <input onclick="modifiDisciplines()" type="submit" class="big-big-button"
                        value="Модифицировать выбранную дисциплину..."></div>

                <input type="hidden" name="isDeleteDis" id="isDeleteDis">

            <div><input class="big-big-button" type="submit" value="Удалить выбранную дисциплину..." onclick="deleteDisciplines()"></div>
        </div>
    </div>
</div>

<form id="disciplina-modyfying-form" method="get" action="/disciplina-modifying">
    <input type="hidden" id="idModifyingDisciplineHidden" name="idModifyingDisciplineHidden">
</form>

<form id="disciplina-remove-form" method="post" action="/disciplina-list-cont">
    <input type="hidden" id="idRemoveDisciplineHidden" name="idRemoveDisciplineHidden">
</form>
</body>
</html>
