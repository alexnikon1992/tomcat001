<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>

<table class="all-width-template">
    <tr>
        <td class="column-20" colspan="2"></td>
        <td class="column-60" colspan="2"><h1>Система управления студентами и их успеваемостью</h1></td>
        <td class="column-20 logout-link"><a href="/logout">Logout</a></td>
    </tr>
    <tr>
        <td class="column-7"><a href="/">На главную</a></td>
        <td class="column-13"><a href="/ress">Назад</a></td>
        <td class="column-60 main-title-page" colspan="2">Для модифицирования семестра отредактируйте следующие данные и нажмите
            кнопку модифицировать
        </td>
        <td class="column-20"></td>
    </tr>
    <tr>
        <form action="/terms-create" method="post">
            <td class="column-7"></td>
            <td class="column-13"></td>
            <td class="column-15 line-heigth-50">Длительность (в неделях)</td>
            <td class="column-45"><input type="text" name="duration" value=""></td>
            <td class="column-20"></td>
    </tr>
    <tr>
        <td class="column-7"></td>
        <td class="column-13"></td>
        <td class="column-15 vertical-align-top">Дисциплины в семестре</td>
        <td class="column-45"><select name="idSelectedDisciplines" multiple size="8">
            <c:forEach items="${disciplines}" var="dis">
                <option value="${dis.id}">${dis.disciplina}</option>
            </c:forEach>
        </select></td>
        <td class="column-20"></td>
    </tr>
    <tr>
        <td class="column-7"></td>
        <td class="column-13"></td>
        <td class="column-15"></td>

        <td class="column-45 line-heigth-50"><input type="submit" value="Модифицировать"></td>
        <td class="column-20"></td>
        </form>
    </tr>
</table>

</body>
</html>