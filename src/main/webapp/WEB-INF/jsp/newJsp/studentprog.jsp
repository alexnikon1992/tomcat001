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
        <a class="a-na-glavnuu" href="/studets">Назад</a>
    </div>
    <div class="main-title-page">
        Отображена успеваемость для следующего студента:
    </div>
</div>
<div class="display-flex start">
    <div class="column-20"></div>
    <div class="column-100">
        <table class="table-main-info table-one-student">
            <tr>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Группа</th>
                <th>Дата поступления</th>
            </tr>
            <tr>
                <td>${progressStudent.surname}</td>
                <td>${progressStudent.name}</td>
                <td>${progressStudent.group}</td>
                <td>${progressStudent.date}</td>
            </tr>

        </table>
    </div>
</div>
<div class="display-flex start for-mobile-display-block">
    <div class="column-20"></div>
    <div>
        <table class="table-main-info table-student-progress">
            <tr>
                <th>Дисциплина</th>
                <th>Оценка</th>
            </tr>
            <c:forEach items="${marks}" var="mark">
                <tr>
                    <td>${mark.disciplina.disciplina}</td>
                    <td>${mark.mark}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <form action="/student-progress" method="post" >
        <input type="hidden" name="idStudent" value="${progressStudent.id}">
    <div class="div-student-progress-select-semestr">
        <div class="display-flex start">
            <label>Выбрать семестр</label>
            <div class="select">
                <select name="selectTerm">
                    <c:forEach items="${termsAll}" var="currentterm">
                        <c:choose>
                            <c:when test="${currentterm.id == selecteTerm.id}">
                                <option selected value="${currentterm.id}">${currentterm.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${currentterm.id}">${currentterm.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>

            <input type="submit" value="Выбрать">
        </div>
        <label>Средняя оценка за семестр: ${srednee}</label>
    </div>
    </form>
</div>
</body>
</html>


