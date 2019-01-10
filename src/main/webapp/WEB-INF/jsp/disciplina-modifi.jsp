<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
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
    <div id="div-for-main-title">
        <h1>
            Система управления студентами и их успеваемостью
        </h1>

    </div>
    <a href="/logout">
        logout
    </a>
</div>
</div>
<div class="div-main-info">
    <div class="div-for-naglavnuu">
        <a href="/">
            На главную
        </a>
    </div>
</div>
<div class="div-main-info">
    <div class="div-for-naglavnuu">
        <a href="/">
            Новая
        </a>
    </div>


    <div>
        <h3>
            Для того чтобы модифицировать дисциплину ввдедите новое значение поля и нажмите кнопку "Применить"
        </h3>
        <div class="display-flex">
            <div>
                <h3>
                    Название
                </h3>
                <div class="sozdat">
                    <input type="text" name="login" value="           " size="20" maxlength="5">
                    <div class="display-grid">
                        <input class="black-button" type="submit" value="Применить">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
