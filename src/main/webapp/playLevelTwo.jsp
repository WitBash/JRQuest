<%--
  Created by IntelliJ IDEA.
  User: Vitali
  Date: 19.07.2023
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LevelTwo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<form class="form-horizontal" action="${pageContext.request.contextPath}/play">
    <fieldset>

        <!-- Form Name -->
        <legend>Space Quest</legend>
        <h2>Ты принял вызов. Поднимаешься на мостик к капитану?</h2>
        <!-- Multiple Radios -->
        <div class="form-group">
            <div class="col-md-4">
                <div class="radio">
                    <label for="radios-0">
                        <input type="radio" name="answer" id="radios-0" value="Подняться на мостик" checked="checked">
                        Подняться на мостик
                    </label>
                </div>
                <div class="radio">
                    <label for="radios-1">
                        <input type="radio" name="answer" id="radios-1" value="Отказаться подниматься на мостик">
                        Отказаться подниматься на мостик
                    </label>
                </div>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" class="btn btn-primary">Ответить
                </button>
            </div>
            <div>
                <p>Имя: ${name}</p>
                <p>Игра: ${count}</p>
            </div>
        </div>

    </fieldset>
</form>
</body>
</html>
