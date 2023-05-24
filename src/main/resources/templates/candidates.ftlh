<#import "blocks/template.ftlh" as t>
<@t.template>

    <nav class="navbar navbar-expand-lg bg-body-secondary" style="margin-bottom: 20px">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Hr_department</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <#if user.isHrSpecialist()>
                        <a class="nav-link active" aria-current="page" href="/employee/view">Сотрудники</a>
                        <a class="nav-link active" aria-current="page" href="/vacancy/view">Вакансии</a>
                        <a class="nav-link disabled">Кандидаты</a>
                    <#elseif user.isDepartmentEngineer()>
                        <a class="nav-link active" aria-current="page" href="/employee/view">Сотрудники</a>
                        <a class="nav-link active" aria-current="page" href="/department/view">Отделы кадров</a>
                    <#elseif user.isUser()>
                        <a class="nav-link active" aria-current="page" href="/employee/view">Сотрудники</a>
                        <a class="nav-link active" aria-current="page" href="/vacancy/view">Вакансии</a>
                        <a class="nav-link active" aria-current="page" href="/department/view">Отделы кадров</a>
                    <#elseif user.isChief()>
                        <a class="nav-link active" aria-current="page" href="/employee/view">Сотрудники</a>
                        <a class="nav-link active" aria-current="page" href="/vacancy/view">Вакансии</a>
                        <a class="nav-link disabled">Кандидаты</a>
                        <a class="nav-link active" aria-current="page" href="/department/view">Отделы кадров</a>
                    <#else>
                        <p>ошибка</p>
                    </#if>

                </div>
            </div>

            <#if user.login??>
                <form class="d-flex" action="/logout" method="post">
                    <span class="navbar-text" style="padding-right:5px">
                        ${user.login}
                    </span>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input class="btn btn-light my-2 my-sm-0 " type="submit" value="Выйти">
                </form>
            <#else>
                <form class="d-flex" action="/login">
                    <button class="btn btn-light my-2 my-sm-0" type="button"
                            onclick="window.location.href = '/login'">
                        войти
                    </button>
                </form>
            </#if>
        </div>

    </nav>

    <div class="container">

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
        </div>
    </div>
</@t.template>