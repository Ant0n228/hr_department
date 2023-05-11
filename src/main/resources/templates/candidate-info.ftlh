<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Candidate number ${candidate.idCandidate}</title>
</head>
<body>
<h4>подробнее об кандидате</h4>
<b>Фио</b> ${candidate.fio} <hr>
<b>Email </b>${candidate.email} <br>
<b>Дата отклика </b>${candidate.dateOfSubmission} <br>
<b>Статус кандидата</b>
<#if candidate.applicationStatus>
    ещё не принят
<#else> принят
</#if> <br>

<b>Иностраный язык: </b>
<#if candidate.foreignLanguage??>
    не знает иностранных языков
<#else> ${candidate.foreignLanguage}
</#if> <br>

<h4>подробнее об образовании работника</h4> <hr>
<b>Учебное заведение: </b>${candidate.education.educationalInstitution} <br>
<b>Факультет: </b>${candidate.education.faculty} <br>
<b>Специализцация: </b> ${candidate.education.specialization} <br>
<b>Дата поступления в университет: </b> ${candidate.education.dateOfAdmission} <br>
<b>Дата Выпуска(отчисления): </b>
<#if candidate.education.dateOfGraduation??>
    ${candidate.education.dateOfGraduation}
<#else> ещё учится
</#if> <br>
<hr>

<h3>Удалить кандидата</h3>
<form action="/candidate/delete/${candidate.idCandidate}" method="post">
    <input type="submit" value="удалить кандидата"/>
</form>

</body>
</html>