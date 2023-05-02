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
    <h4>все наши ваканисии</h4> <hr>
    <form action="/vacancy/search" method="get">
        <p>Поиск вакансий по названию: <label>
                <input type="text" name="jobTitle">
            </label><br></p>
        <input type="submit" value="Поиск"/>
    </form>
    <#list vacancies as vacancy>
        <div>
            <p>
                <a href ="/vacancy/view/${vacancy.idVacancy}">Подробнее</a>
                | <b>${vacancy.jobTitle}</b>
                | <b>${vacancy.dateOfPublication}</b>
                | <b>${vacancy.salary} руб.</b>
                | <b>${vacancy.numberOfVacancy}</b>
            </p>
        </div>
        <#else>
        <h3>Вакансий нет</h3>
    </#list>
    <hr>
    <h3>Создать новую вакансию</h3>
    <form action="/vacancy/create" method="post">
        <p>Название вакансии: </p><input type="text" name="jobTitle"/><br><br>
        <p>Зарплата: </p><input type="number" name="salary"/><br><br>
        <p>Требования к кандидату: </p><input type="text" name="requirements"/><br><br>
        <p>Описание вакансии: </p><input type="text" name="jobDescription"/><br><br>
        <p>Количесво вакансий: </p><input type="number" name="numberOfVacancy"/><br><br>
        <input type="submit" value="Добавить вакансию"/>
    </form>
</body>
</html>