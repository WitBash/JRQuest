<%--
  Created by IntelliJ IDEA.
  User: Vitali
  Date: 20.07.2023
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You Lost</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<!-- Game Title -->
<h3>Space Quest</h3>

<h1>${result}</h1>
<h1><b>Поражение!</b></h1>

<form action="${pageContext.request.contextPath}/playReturn">
    <!-- Button -->
    <div class="form-group">
        <label class="col-md-4 control-label" for="returnButton"></label>
        <div class="col-md-4">
            <button id="returnButton" name="returnButton" class="btn btn-primary">Вернуться в игру</button>
        </div>
    </div>
</form>
<form action="${pageContext.request.contextPath}/playQuit">
    <!-- Button -->
    <div class="form-group">
        <label class="col-md-4 control-label" for="quitButton"></label>
        <div class="col-md-4">
            <button id="quitButton" name="quitButton" class="btn btn-primary">Выйти из игры</button>
        </div>
    </div>
</form>
<div>
    <p>Имя: ${name}</p>
    <p>Игра: ${count}</p>
</div>
</body>
</html>
