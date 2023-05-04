<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Employees number ${employee.idEmployee}</title>
</head>
<body>
<h4>подробнее о работнике</h4> <hr>
<b>Фио: </b>${employee.fio} <br>
<b>Позиция: </b>${employee.position} <br>
<b>Зарплата: </b> ${employee.salary} <br>
<b>Дата приёма на работу: </b>
    <#if employee.dateOfEmployment??>
        ${employee.dateOfEmployment}
    </#if> <br>
<b>Email: </b>${employee.email} <br>
<b>Дата увольнения: </b>
    <#if employee.dateOfDismissal??>
        ${employee.dateOfDismissal}
        <#else> Увольнению не подлежит
    </#if> <br>
<b>Id образования: </b> ${employee.idEducation} <br>
<b>Id отдела: </b> ${employee.idDepartment} <br>
<hr>

<h3>Уволить работника</h3>
<form action="/employee/delete/${employee.idEmployee}" method="post">
    <input type="submit" value="Уволить работника"/>
</form>

</body>
</html>