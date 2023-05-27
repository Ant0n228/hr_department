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
                        <a class="nav-link disabled">Сотрудники</a>
                        <a class="nav-link active" aria-current="page" href="/vacancy/view">Вакансии</a>
                        <a class="nav-link active" aria-current="page" href="/candidate/view">Кандидаты</a>
                    <#elseif user.isDepartmentEngineer()>
                        <a class="nav-link disabled">Сотрудники</a>
                        <a class="nav-link active" aria-current="page" href="/department/view">Отделы кадров</a>
                    <#elseif user.isUser()>
                        <a class="nav-link disabled">Сотрудники</a>
                        <a class="nav-link active" aria-current="page" href="/vacancy/view">Вакансии</a>
                        <a class="nav-link active" aria-current="page" href="/department/view">Отделы кадров</a>
                    <#elseif user.isChief()>
                        <a class="nav-link disabled">Сотрудники</a>
                        <a class="nav-link active" aria-current="page" href="/vacancy/view">Вакансии</a>
                        <a class="nav-link active" aria-current="page" href="/candidate/view">Кандидаты</a>
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
        <h2 style="text-align: center; margin-bottom:20px">Поиск сотрудника</h2>
        <form class="row g-3 align-items-center" action="/employee/search" method="get" style="margin-bottom: 20px">
            <div class="col-10">
                <input type="text" name="fio" class="form-control" placeholder="Фио">
            </div>

            <div class="col-2">
                <button class="btn btn-primary" style="width: 100%" formaction="/employee/view">Сбросить Поиск</button>
            </div>
            <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
        </form>
        <#if employees?size != 0>
            <table class="table table-bordered">
                <thead class="table-secondary">
                <tr>
                    <th>Id</th>
                    <th>Фио</th>
                    <th>Должность</th>
                    <th>Зарплата</th>
                    <th>Дата найма</th>
                    <th>Email</th>
                    <th>Дата увольнения</th>
                    <th>Наличие образования</th>
                </tr>
                </thead>
                <tbody>
                <#list employees as employee>
                    <tr>
                        <th scope="row">
                            <a class="link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover"
                               href="/employee/view/${employee.idEmployee}">Подробнее</a></th>
                        <td>${employee.fio}</td>
                        <td>${employee.position}</td>
                        <td>
                            <#if employee.salary < 30>
                                Крошки от хлеба
                            <#else> ${employee.salary} руб.
                            </#if>
                        </td>
                        <td>${employee.dateOfEmployment}</td>
                        <td>${employee.email}</td>
                        <td>
                            <#if employee.dateOfDismissal??>
                                ${employee.dateOfDismissal}
                            <#else> Увольнению не подлежит
                            </#if>
                        </td>
                        <td>
                            <#if employee.education??>
                                Присутствует
                            <#else> Отсутствует
                            </#if>
                        </td>
                    </tr>

                </#list>
                </tbody>
            </table>
        <#else>
            <tr><h3>Сатрудников нет</h3></tr>
        </#if>

        <#--add new employee-->
        <#if !user.isUser()>
            <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
               data-toggle="collapse" href="#mainCollapse" role="button"
               aria-expanded="true" aria-controls="collapseExample">
                Добавить нового сотрудника
            </a>
        <#-- required id?-->
            <div class="collapse mb-3" id="mainCollapse" style="margin-bottom: 10px">
                <form action="/employee/create" method="post">
                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="fio">Фио: </label>
                        <input type="text" required class="form-control" name="fio">
                    </div>
                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="position">Должность: </label>
                        <input type="text" required class="form-control" name="position">
                    </div>
                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="salary">Зарплата: </label>
                        <div class="input-group mb-3">
                            <input type="number" required class="form-control" name="salary">
                            <div class="input-group-append">
                                <span class="input-group-text">₽</span>
                            </div>
                        </div>
                    </div>

                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="email">Email: </label>
                        <input type="text" required class="form-control" name="email"/>
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

                    <!-- department-->
                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="idDepartment">Выберете отдел: </label>
                        <select id="idDepartment" required name="idDepartment" class="form-control">
                            <option value="">Выберете отдел</option>
                            <#list departments as deparment>
                                <option value=${deparment.idDepartment}>${deparment.departmentName}</option>
                            </#list>
                        </select>
                    </div>

                    <!-- vacancy -->
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
        </#if>
    </div>
</@t.template>