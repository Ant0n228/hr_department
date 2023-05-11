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

<hr>
<h3>Добавить нового работника</h3>
<form action="/employee/create" method="post">
    <#--основная информация-->
    <label>ФИО: </label><input type="text" name="fio"/><br><br>
    <label>Позиция: </label><input type="text" name="position"/><br><br>
    <label>Зарплата: </label><input type="number" name="salary"/><br><br>
    <label>Дата приёма на работу: </label><input type="date" name="dateOfEmployment"/><br><br>
    <label>email: </label><input type="text" name="email"/><br><br>

    <#--образование-->
    <label>Учебное заведение: </label><input type="text" name="education.educationalInstitution"/><br><br>
    <label>Факультет: </label><input type="text" name="education.faculty"/><br><br>
    <label>Специализация: </label><input type="text" name="education.specialization"/><br><br>
    <label>Дата поступления: </label><input type="date" name="education.dateOfAdmission"/><br><br>
    <label>Дата выпуска(отчисления): </label><input type="date" name="education.dateOfGraduation"/><br><br>

    <#--добавление отдела-->
    <label for="idDepartment">Выберете отдел: </label>
    <select id="idDepartment" name="idDepartment">
        <option value="">Выберете отдел</option>
        <#list departments as department>
            <option value=${department.idDepartment}>${department.departmentName}</option>
        </#list>
    </select> <br><br>

    <#--добавление вакансии-->
    <label for="idVacancy">Выберете вакансию: </label>
    <select id="idVacancy" name="idVacancy">
        <option value="">Выберете вакансию</option>
        <#list vacancies as vacancy>
            <option value=${vacancy.idVacancy}>${vacancy.jobTitle}</option>
        </#list>
    </select> <br><br>

    <input type="submit" value="Добавить нового работника"/>
</form>
</body>
</html>