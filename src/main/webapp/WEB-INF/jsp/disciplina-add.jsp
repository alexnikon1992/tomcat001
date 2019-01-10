<%@ page contentType="text/html; charset=UTF-8" %>
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
            Для того чтобы создать новую дисциплину заполните все поля и нажмите кнопку "Создать"
        </h3>
        <div class="display-flex">
            <div>
                <h3>
                    Название
                </h3>
                <div class="sozdat">
                    <form  method="post" action="/disciplina-create">
                        <input type="text" name="name-disciplina" size="20" maxlength="5" placeholder="имя дисциплины">
                        <div class="display-grid">
                            <input class="black-button" type="submit" value="Создать">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
