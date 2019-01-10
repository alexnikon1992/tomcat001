<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Система управления студентами и их успеваемостью</title>
    <meta name="descripcion" content="Эта система поможет вам управлять онлайн университетом">
    <link rel="stylesheet" href="../../resources/css/style.css">
</head>
<body>
<div id="div-for-header">
    <div id="div-for-main-title">
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

    <div>
        <h3>
            Список дисциплин
        </h3>
        <div class="display-flex">
            <div>
                <table class="table-main-info">

                    <tr>
                        <th>

                        </th>
                        <th>
                            Название дисциплины
                        </th>
                    </tr>
                    <c:forEach items="${disciplines}" var="dis">
                        <tr>
                            <td>
                                <input type="checkbox">
                            </td>
                            <td>
                                ${dis.disciplina}
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="display-grid">
                <form action="/disciplina-create" method="get">
                    <input class="black-button" type="submit" value="Создать дисциплину...">
                </form>
                <form action="/disciplines-modifi" method="get">
                    <input class="black-button" type="submit" value="Модифицировать выбранную дисциплину...">
                </form>

                <input class="black-button" type="submit" value="Удалить выбранную дисциплину...">

            </div>
        </div>
    </div>


</div>

</body>
</html>