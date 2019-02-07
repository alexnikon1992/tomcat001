<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <link rel="stylesheet" href="../../../resources/colorpicker/css/colorpicker.css" type="text/css" />
    <script type="text/javascript" src="../../../resources/colorpicker/js/jquery.js"></script>
    <script type="text/javascript" src="../../../resources/colorpicker/js/colorpicker.js"></script>
    <script type="text/javascript" src="../../../resources/colorpicker/js/eye.js"></script>
    <script type="text/javascript" src="../../../resources/colorpicker/js/utils.js"></script>
    <script type="text/javascript" src="../../../resources/colorpicker/js/layout.js?ver=1.0.2"></script>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <meta charset="UTF-8">
    <title>Список всех студентов</title>
    <link rel="stylesheet" href="../resources/css/style.css">
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>
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
        Для создания студента заполните все поля и нажмите кнопку "Создать".
    </div>
</div>
<div class="display-flex start">
    <div class="column-20"></div>
    <form action="student-create" method="post">
        <div CLASS="div-for-student-modifing div-class-for-button-error">
            <div class="display-flex"><label>Фамилия</label><input name="surname" type="text"></div>
            <div class="display-flex"><label>Имя</label><input name="name" type="text"></div>
            <div class="display-flex"><label>Группа</label><input name="group" type="text"></div>
            <div CLASS="display-flex"><label>Дата поступления</label><input name="date" type="text" id="datepicker"></div>
            <div class="display-flex"><input type="submit" value="Создать"></div>
        </div>
    </form>
</div>
<div class="display-flex start padding-top-10">
    <div class="column-20">
    </div>
    <c:if test="${message == 1}">
        <div class="error-lable">
            Поля не должны быть пустыми!
        </div>
    </c:if>
</div>
</body>
</html>