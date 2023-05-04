<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Department</title>
</head>
<body>
<h4>Все отделы кадров</h4> <hr>
<form action="/department/search" method="get">
    <p>Поиск отделов кадров по названию: <input type="text" name="departmentName"><br></p>
    <input type="submit" value="Поиск"/>
</form>
<table border="1">
    <tr>
        <th>id отдела</th>
        <th>Название отдела</th>
        <th>Количество людей</th>

    </tr>
    <#list departments as department>
        <tr>
            <td><a href ="/department/view/${department.idDepartment}">Подробнее</a></td>
            <td>${department.departmentName}</td>
            <td>${department.numberOfPeople}</td>
        </tr>
    <#else>
        <tr><h3>отделов нет</h3></tr>
    </#list>
</table>
<hr>
<h3>Добавить новый отдел</h3>
<form action="/department/create" method="post">
    <p>Назвиние отдела: </p><input type="text" name="departmentName"/><br>
    <p>Количество людей: </p><input type="number" name="numberOfPeople"/><br>
    <input type="submit" value="Создать новый отдел"/>
</form>
</body>
</html>