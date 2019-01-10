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
        Для создания семестра заполните следующие данные и нажмите кнопку "Создать".
    </div>
</div>
<form action="/term-create" method="post">
<div id="discipline-creating" class="display-flex start">
    <div class="column-20"></div>
    <div CLASS="div-for-student-modifing div-for-student-page-new div-class-for-button-error">
        <div class="display-flex"><label>Длительность (в неделях)</label><input name="duration" type="text" value="24"></div>
        <div class="display-flex"><label>Выберите дисциплину</label><select name="selectdiscipline" multiple size="8">
            <c:forEach items="${disciplina}" var="currentdiscipline">
                <option value="${currentdiscipline.id}">${currentdiscipline.disciplina}</option>
            </c:forEach>
        </select>
        </div>

        <div class="display-flex" id="button-create-term">
            <input type="submit" value="Создать">
        </div>
    </div>
</div>
</form>

<div class="display-flex start padding-top-10">
    <div class="column-20">
    </div>
    <div class="error-lable">
        Поля не должны быть пустыми!
    </div>
</div>
</body>
</html>
