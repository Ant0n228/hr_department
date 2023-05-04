<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Candidate</title>
</head>
<body>
<h4>Все кандидаты</h4> <hr>
<form action="/candidate/search" method="get">
    <p>Поиск вакансии по специализации: <input type="text" name="fio"><br></p>
    <input type="submit" value="Поиск по фио"/>
</form>
<table border="1">
    <tr>
        <th>Id кандидата</th>
        <th>Фио</th>
        <th>email</th>
        <th>Дата Отклика</th>
        <th>Статус Кандидата</th>
        <th>иностранный язык</th>
        <th>id вакансии</th>
        <th>id образования</th>
    </tr>
    <#list candidates as candidate>
        <tr>
            <td><a href ="/candidate/view/${candidate.idCandidate}">Подробнее</a></td>
            <td>${candidate.fio}</td>
            <td>${candidate.email}</td>
            <td>${candidate.dateOfSubmission}</td>
            <td>
                <#if !candidate.applicationStatus>
                    ещё не принят
                    <#else> принят
                </#if>
            </td>
            <td>
                <#if candidate.foreignLanguage??>
                    не знает иностранных языков
                    <#else> ${candidate.foreignLanguage}
                </#if>
            </td>
            <td>${candidate.idVacancy}</td>
            <td>${candidate.idEducation}</td>
        </tr>
    <#else>
        <tr><h3>Кандидатов нет</h3></tr>
    </#list>
</table>
<hr>
<h3>Добавить нового кандидата</h3>
<form action="/candidate/create" method="post">
    <p>Фио: </p><input type="text" name="fio"/><br>
    <p>Email: </p><input type="text" name="email"/><br>
    <p>Дата отклика: </p><input type="date" name="dateOfSubmission"/><br>
    <p>Иностраный язык: </p><input type="text" name="foreignLanguage"/><br>
    <p>Id Вакансии: </p><input type="number" name="idVacancy"/><br>
    <p>Id Образования: </p><input type="number" name="idEducation"/><br>
    <input type="submit" value="Создать нового кандидата"/>
</form>
</body>
</html>