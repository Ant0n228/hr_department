<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Education number ${education.idEducation}</title>
</head>
<body>
<h4>подробнее об образовании</h4> <hr>
<b>Учебное заведение: </b>${education.educationalInstitution} <br>
<b>Факультет: </b>${education.faculty} <br>
<b>Специализцация: </b> ${education.specialization} <br>
<b>Дата поступления в университет: </b> ${education.dateOfAdmission} <br>
<b>Дата Выпуска(отчисления): </b>
<#if education.dateOfGraduation??>
    ${education.dateOfGraduation}
    <#else> ещё учится
</#if> <br>
<hr>

<h3>Удалить образование</h3>
<form action="/education/delete/${education.idEducation}" method="post">
    <input type="submit" value="удалить образование"/>
</form>

</body>
</html>