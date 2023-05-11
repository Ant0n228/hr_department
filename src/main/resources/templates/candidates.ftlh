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
        <th>Иностранный язык</th>
        <th>Наличие образования</th>

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
            <td><#if candidate.education??>
                    Присутствует
                <#else> Отсутствует
                </#if></td>

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

    <#--образовние-->
    <label>Учебное заведение: </label><input type="text" name="education.educationalInstitution"/><br><br>
    <label>Факультет: </label><input type="text" name="education.faculty"/><br><br>
    <label>Специализация: </label><input type="text" name="education.specialization"/><br><br>
    <label>Дата поступления: </label><input type="date" name="education.dateOfAdmission"/><br><br>
    <label>Дата выпуска(отчисления): </label><input type="date" name="education.dateOfGraduation"/><br><br>

    <#--вакансия-->
    <label for="idVacancy">Выберете вакансию: </label>
    <select id="idVacancy" name="idVacancy">
        <option value="">Выберете вакансию</option>
        <#list vacancies as vacancy>
            <option value=${vacancy.idVacancy}>${vacancy.jobTitle}</option>
        </#list>
    </select> <br><br>

    <input type="submit" value="Создать нового кандидата"/>
</form>
</body>
</html>