<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Vacancy</title>
</head>
<body>
    <h4>подробнее о вакансии</h4> <hr>
    <b>Название вакансии: </b>${vacancyWithRequirement.jobTitle} <br>
    <b>Зарплата: </b>${vacancyWithRequirement.salary} <br>
    <b>Дата публикации: </b>${vacancyWithRequirement.dateOfPublication} <br>
    <b>Требования к кандидату: </b>
    <#if vacancyWithRequirement.requirements??>
        ${vacancyWithRequirement.requirements}
    </#if> <br>
    <b>Описание вакансии: </b>${vacancyWithRequirement.jobDescription} <br>
    <b>Количество вакансий: </b>${vacancyWithRequirement.numberOfVacancy} <br>

    <hr>

    <h3>Удалить вакансию</h3>
    <form action="/vacancy/delete/${vacancyWithRequirement.idVacancyWithRequirements}" method="post">
        <input type="submit" value="Удалить вакансию"/>
    </form>

</body>
</html>