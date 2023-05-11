<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Vacancy number ${vacancy.idVacancy}</title>
</head>
<body>
    <h4>подробнее о вакансии</h4> <hr>
    <b>Название вакансии: </b>${vacancy.jobTitle} <br>
    <b>Зарплата: </b>${vacancy.salary} <br>
    <b>Дата публикации: </b>${vacancy.dateOfPublication} <br>
    <b>Требования к кандидату: </b>
    <#if vacancy.requirements.requirements??>
        ${vacancy.requirements.requirements}
    </#if> <br>
    <b>Описание вакансии: </b>${vacancy.requirements.jobDescription} <br>
    <b>Количество вакансий: </b>${vacancy.numberOfVacancy} <br>

    <hr>
    <h4>Работники работающие по этой вакансии</h4>
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
    <h4>Кандидаты вакансии</h4>
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

    <h3>Удалить вакансию</h3>
    <form action="/vacancy/delete/${vacancy.idVacancy}" method="post">
        <input type="submit" value="Удалить вакансию"/>
    </form>

</body>
</html>