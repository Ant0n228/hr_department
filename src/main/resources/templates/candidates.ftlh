<#import "blocks/template.ftlh" as t>
<@t.template>
    <nav class="nav nav-pills nav-fill navbar-dark" style="margin-bottom:30px">
        <a class="nav-link" href="/employee/view">Сотрудники</a>
        <a class="nav-link" href="/vacancy/view">Вакансии</a>
        <a class="nav-link active" aria-current="page" href="/candidate/view">Кандидаты</a>
        <a class="nav-link" href="/department/view">Отделы</a>
    </nav>
    <h2 style="text-align: center; margin-bottom:20px">Поиск кандидата</h2>
    <form class="row g-3 align-items-center" action="/candidate/search" method="get" style="margin-bottom: 20px">
        <div class="col-10">
            <input type="text" name="fio" class="form-control" placeholder="Фио">
        </div>

        <div class="col-2">
            <button class="btn btn-primary" style="width: 100%" formaction="/candidate/view">Сбросить Поиск</button>
        </div>
        <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
    </form>
    <#if candidates?size != 0>
        <table class="table table-bordered">
            <thead class="table-secondary">
            <tr>
                <th scope="col">Id кандидата</th>
                <th scope="col">Фио</th>
                <th scope="col">Email</th>
                <th scope="col">Дата отклика</th>
                <th scope="col">Статус кандидата</th>
                <th scope="col">Иностранный язык</th>
                <th scope="col">Наличие образования</th>
            </tr>
            </thead>
            <tbody>
            <#list candidates as candidate>
                <tr>
                    <th scope="row">
                        <a class="link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover"
                           href="/candidate/view/${candidate.idCandidate}">Подробнее</a></th>
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
                    <td>
                        <#if candidate.education??>
                            Присутствует
                        <#else> Отсутствует
                        </#if>
                    </td>

                </tr>

            </#list>
            </tbody>
        </table>
    <#else>
        <tr><h3>Кандидатов нет</h3></tr>
    </#if>

    <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
       data-toggle="collapse" href="#mainCollapse" role="button"
       aria-expanded="true" aria-controls="collapseExample">
        Добавить нового кандидата
    </a>
    <div class="collapse mb-3" id="mainCollapse" style="margin-bottom: 10px">
    <form action="/candidate/create" method="post">
        <div class="form-group" style="margin-bottom: 10px">
            <label for="fio">Фио: </label>
            <input type="text" required class="form-control" name="fio">
        </div>
        <div class="form-group" style="margin-bottom: 10px">
            <label for="email">Email: </label>
            <input type="text" required class="form-control" name="email">
        </div>
        <div class="form-group" style="margin-bottom: 10px">
            <label for="dateOfSubmission">Дата Отклика: </label>
            <input type="date" required class="form-control" name="dateOfSubmission">
        </div>
        <div class="form-group" style="margin-bottom: 10px">
            <label for="foreignLanguage">Иностранный язык: </label>
            <input type="text" required class="form-control" name="foreignLanguage">
        </div>

        <#--Education-->
        <div class="form-group" style="margin-bottom: 10px">
            <label for="education.educationalInstitution">Учебное заведение: </label>
            <input type="text" required class="form-control" name="education.educationalInstitution"/>
        </div>
        <div class="form-group" style="margin-bottom: 10px">
            <label for="education.faculty">Факультет: </label>
            <input type="text" required class="form-control" name="education.faculty"/>
        </div>
        <div class="form-group" style="margin-bottom: 10px">
            <label for="education.specialization">Специализация: </label>
            <input type="text" required class="form-control" name="education.specialization"/>
        </div>
        <div class="form-group" style="margin-bottom: 10px">
            <label for="education.dateOfAdmission">Дата поступления: </label>
            <input type="date" required class="form-control" name="education.dateOfAdmission"/>
        </div>
        <div class="form-group" style="margin-bottom: 10px">
            <label for="education.dateOfGraduation">Дата выпуска (отчисления): </label>
            <input type="date" required class="form-control" name="education.dateOfGraduation"/>
        </div>
        <#--vacancy-->
        <div class="form-group" style="padding-bottom: 10px">
            <label for="idVacancy">Выберете вакансию: </label>
            <select id="idVacancy" required name="idVacancy" class="form-control">
                <option value="">Выберете вакансию</option>
                <#list vacancies as vacancy>
                    <option value=${vacancy.idVacancy}>${vacancy.jobTitle}</option>
                </#list>
            </select>
        </div>

        <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
    </form>

</@t.template>