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

<b>Id Вакансии: </b> ${candidate.idVacancy} <br>
<b>Id Образования: </b> ${candidate.idEducation}<br>
<hr>

<h3>Удалить кандидата</h3>
<form action="/candidate/delete/${candidate.idCandidate}" method="post">
    <input type="submit" value="удалить кандидата"/>
</form>

</body>
</html>