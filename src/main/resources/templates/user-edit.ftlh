<!DOCTYPE html>
<html>
<head>
    <title>CAFE</title>
</head>
<body>
<a href="/">Вернуться на главную</a>
<hr>
<h3>Редактирование аккаунта</h3>
<form action="/user/editing/${user.id}" method="post" enctype="multipart/form-data">
    Логин: <input type="text" value="${user.login}" name="login"/><br><br>
    <h4>Для изменения пароля подтвердите текущий пароль</h4>
    Старый пароль: <input type="password" name="oldPassword"/><br><br>
    Новый пароль: <input type="password" name="password"/><br><br>
    <input type="submit" value="Изменить информацию"/>
</form>
<form action="/user/delete/${user.id}" method="post" enctype="multipart/form-data">
    <h4>Для удаления аккаунта подтвердите пароль</h4>
    Пароль: <input type="password" name="password"/><br><br>
    <input type="submit" value="Удалить"/>
</form>
</body>
</html>