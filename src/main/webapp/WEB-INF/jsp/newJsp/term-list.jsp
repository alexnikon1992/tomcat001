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
    </div>

    <div class="div-student-progress-select-semestr">
        <div class="display-flex start">
            <form action="/term-list" method="post">
                <label>Выбрать семестр</label>
                <div class="select">
                    <select name="selectedTerm">
                        <c:forEach items="${termlist}" var="currentterm">
                            <c:choose>
                                <c:when test="${currentterm.id == selectedterm.id}">
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
            </form>
        </div>
        <label>Длительность семестра: ${selectedterm.duration}</label>
    </div>

</div>
<div class="display-flex start" id="div-title-page">
    <div class="column-20">
    </div>
    <div class="main-title-page">
        Список дисциплин семестра
    </div>
</div>
<div id="disciplina-list" class="display-flex start for-mobile-display-block">
    <div class="column-20"></div>
    <div>
        <table class="table-main-info table-student-progress">
            <tr>
                <th>Наименование дисциплины</th>
            </tr>
            <c:forEach items="${disciplines}" var="currentdiscip">
                <tr>
                    <td>${currentdiscip.disciplina}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
<c:if test="${role=='1'}">
    <div class="div-student-progress-select-semestr">
        <div class=" mobile-div">
            <form action="/term-create" method="get">
                <div><input class="big-big-button" type="submit" value="Создать семестр..."></div>
            </form>
            <form action="/term-list-modify" method="get"> <input type="hidden" value="${selectedterm.id}" name="idTermModify">
            <div><input type="submit" class="big-big-button" value="Модифицировать выбранный семестр..."></div>
            </form>
            <form action="/term-list-delete" method="post"><input type="hidden" value="${selectedterm.id}"
                                                                  name="idTermDelete">
                <div><input class="big-big-button" type="submit" value="Удалить выбранный семестр..."></div>
            </form>
        </div>
    </div>
</c:if>
</div>
</body>
</html>
