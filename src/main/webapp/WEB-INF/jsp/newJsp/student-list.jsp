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
    <div class="student-list-div">
        <div class="display-flex mobile-div">
            <div><input class="black-button big-button" type="submit"
                        value="Просмотреть успеваемость выбранных студентов" onclick="viewStudentPrograss()"></div>
            <div>
<c:if test="${role=='1'}">
                <form method="get" action="/student-create">
                    <input type="submit" class="black-button small-button" value="Создать студента">
                </form>
</c:if>
            </div>
        </div>
<c:if test="${role=='1'}">
        <div class="display-flex mobile-div">
            <div><input type="submit" class="black-button big-button" value="Модифицировать выбранного студента" onclick="studentModify()"></div>
            <div><input type="submit" class="black-button small-button" value="Удалить выбранных студентов" onclick="deleteStudents()"></div>
        </div>
</c:if>
    </div>
</div>
<div class="display-flex start">
    <div class="column-20"></div>
    <div class="student-list-page">
        Список студентов
    </div>
</div>
<div class="display-flex start">
    <div class="column-20"></div>
    <div class="column-100">
        <table class="table-main-info">
            <tr>
                <th></th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Группа</th>
                <th>Дата поступления</th>
            </tr>
            <c:forEach items="${studentlist}" var="st">
                <tr>
                    <td><input type="checkbox" id="${st.id}"></td>
                    <td>${st.surname}</td>
                    <td>${st.name}</td>
                    <td>${st.group}</td>
                    <td>${st.date}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<form id="deleteStudentForm" method="post" action="/student-delete">
    <input type="hidden" id = "idsDeleteStudentHidden" name="idsDeleteStudentHidden">
</form>
<form id="viewStudetnProgress" method="get" action="/student-progress">
    <input type="hidden" id = "idsViewPrograssHidden" name="idsViewPrograssHidden" value="ddfd">
</form>
<form id="modifyStudent" method="get" action="/studet-modify">
    <input type="hidden" id="idsModifyStudentHidden" name="idsModifyStudentHidden">
</form>

</body>
</html>
