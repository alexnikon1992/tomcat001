<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Система управления студентами и их успеваемостью</title>
    <meta name="descripcion" content="Эта система поможет вам управлять онлайн университетом">
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<div id="div-for-header">
    <div class="div-for-main-title">
        <h1>
            Система управления студентами и их успеваемостью
        </h1>

    </div>
    <a href="/logout">
        logout
    </a>
</div>
<div id="div-main-info">
    <div id="div-for-naglavnuu">
        <a href="/">
            На главную
        </a>
    </div>
    <form action="/terms" method="post">
        <div>
            <h3>
                Выбрать семестр
            </h3>
            <div id=1>
                <div id=2></div>
            </div>
            <select name="id-selected-term">
                <c:forEach items="${terms}" var="term">
                    <c:choose>
                        <c:when test="${term.id eq selectedTerm.id}">
                            <option value="${term.id}" selected>${term.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${term.id}">${term.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>

        </div>
        <div>
            <input class="black-button" type="submit" value="Выбрать">
        </div>
    </form>


    <h3>
        Длительность семестра: ${selectedTerm.duration}
    </h3>
    <h3>
        Список дисциплин семестра
    </h3>
    <div class="display-flex">
        <div>
            <table class="table-main-info">
                <tr>

                    <th>
                        Название дисциплины
                    </th>
                </tr>
                <c:forEach items="${disciplinasFromSelTerm}" var="d">
                    <tr>
                        <td>
                                ${d.disciplina}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="display-grid">
            <form action="/terms-create" method="get">
                <input class="black-button" type="submit" value="Создать семестр...">
            </form>

            <form action="/term-modifi" method="get">

                <input type="hidden" name="idSelectedTerm" value="${selectedTerm.id}">
                <input class="black-button" type="submit" value="Модифицировать выбранный семестр...">
            </form>
            <input class="black-button" type="submit" value="Удалить выбранный семестр...">

        </div>
    </div>
</div>
</div>


</div>

</body>
</html>