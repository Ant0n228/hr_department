<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Employees</title>
</head>
<body>
<h4>все работники</h4> <hr>
<form action="/employee/search/fio" method="get">
    <p>Поиск работника по фио: <input type="text" name="fio"><br></p>
    <input type="submit" value="Поиск"/>
</form>
<form action="/employee/search/position" method="get">
    <p>Поиск работников по позиции: <input type="text" name="position"><br></p>
    <input type="submit" value="Поиск"/>
</form>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Фио</th>
        <th>Позиция</th>
        <th>Зарплата</th>
        <th>Дата найма</th>
        <th>Email</th>
        <th>Дата увольнения</th>
        <th>Id Образования</th>
        <th>Id Отдела</th>
    </tr>
    <#list employees as employee>
        <tr>
            <td><a href ="/employee/view/${employee.idEmployee}">Подробнее</a></td>
            <td>${employee.fio}</td>
            <td>${employee.position}</td>
            <td>${employee.salary} руб.</td>
            <td>${employee.dateOfEmployment}</td>
            <td>${employee.email}</td>
            <td><#if employee.dateOfDismissal??>
                    ${employee.dateOfDismissal}
                <#else> Увольнению не подлежит
            </#if></td>
        <td>${employee.idEducation}</td>
        <td>${employee.idDepartment}</td>
        </tr>
    <#else>
        <tr><h3>Работников нет</h3></tr>
    </#list>
</table>

<hr>
<h3>Добавить нового работника</h3>
<form action="/employee/create" method="post">
    <p>ФИО: </p><input type="text" name="fio"/><br>
    <p>Позиция: </p><input type="text" name="position"/><br>
    <p>Зарплата: </p><input type="number" name="salary"/><br>
    <p>Дата приёма на работу: </p><input type="date" name="dateOfEmployment"/><br>
    <p>email: </p><input type="text" name="email"/><br>
    <p>Id образования: </p><input type="number" name="idEducation"/><br>
    <p>Id отдела: </p><input type="number" name="idDepartment"/><br>
    <input type="submit" value="Добавить нового работника"/>
</form>
</body>
</html>