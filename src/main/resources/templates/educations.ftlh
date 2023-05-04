<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Education</title>
</head>
<body>
<h4>Образоваиня всех работников и кандидатов</h4> <hr>
<form action="/education/search" method="get">
    <p>Поиск вакансии по специализации: <input type="text" name="specialization"><br></p>
    <input type="submit" value="Поиск"/>
</form>
<table border="1">
    <tr>
        <th>Id образования</th>
        <th>Учебное заведение</th>
        <th>Факультет</th>
        <th>Специализация</th>
        <th>Дата поступления</th>
        <th>Дата выпуска</th>
    </tr>
    <#list educations as education>
        <tr>
            <td><a href ="/education/view/${education.idEducation}">Подробнее</a></td>
            <td>${education.educationalInstitution}</td>
            <td>${education.faculty}</td>
            <td>${education.specialization}</td>
            <td>${education.dateOfAdmission}</td>
            <td>${education.dateOfGraduation}</td>
        </tr>
    <#else>
        <tr><h3>образований нет</h3></tr>
    </#list>
</table>
<hr>
<h3>Добавить новое образование</h3>
<form action="/education/create" method="post">
    <p>Учебное заведение: </p><input type="text" name="educationalInstitution"/><br>
    <p>Факультет: </p><input type="text" name="faculty"/><br>
    <p>Специализация: </p><input type="text" name="specialization"/><br>
    <p>Дата поступления: </p><input type="date" name="dateOfAdmission"/><br>
    <p>Дата выпуска(отчисления): </p><input type="date" name="dateOfGraduation"/><br>
    <input type="submit" value="Создать новое образование"/>
</form>
</body>
</html>