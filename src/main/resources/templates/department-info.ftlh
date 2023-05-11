<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Department number ${department.idDepartment}</title>
</head>
<body>
<h4>подробнее об отделе</h4> <hr>
<b>Название отдела: </b>${department.departmentName} <br>
<b>Количество людей: </b>${department.numberOfPeople} <br>
<hr>

<h4>Работники Работающие в этом отделе</h4>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Фио</th>
        <th>Позиция</th>
        <th>Зарплата</th>
        <th>Дата найма</th>
        <th>Email</th>
        <th>Дата увольнения</th>
        <th>Наличие образования</th>
    </tr>
    <#list employees as employee>
        <tr>
            <td><a href ="/employee/view/${employee.idEmployee}">Подробнее</a></td>
            <td>${employee.fio}</td>
            <td>${employee.position}</td>
            <td><#if employee.salary < 30>
                    Крошки от хлеба
                <#else> ${employee.salary}
                </#if></td>
            <td>${employee.dateOfEmployment}</td>
            <td>${employee.email}</td>
            <td><#if employee.dateOfDismissal??>
                    ${employee.dateOfDismissal}
                <#else> Увольнению не подлежит
                </#if></td>
            <td><#if employee.education??>
                    Присутствует
                <#else> Отсутствует
                </#if></td>

        </tr>
    <#else>
        <tr><h3>Работников нет</h3></tr>
    </#list>
</table>

<h3>Расформировать отдел</h3>
<form action="/department/delete/${department.idDepartment}" method="post">
    <input type="submit" value="Расформировать отдел"/>
</form>

</body>
</html>