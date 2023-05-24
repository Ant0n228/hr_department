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
                        <a class="nav-link active" aria-current="page" href="/candidate/view">Кандидаты</a>
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
        <div class="row" style="margin-bottom: 40px">
            <a href="javascript:history.back()" class="nav-link col-2 position-relative"
               style="font-size:40px; padding-top:6px">&#8249;</a>
            <h2 style="text-align: center; padding: 19px" class="col-8 position-relative">Подробнее об вакансии</h2>
        </div>
        <div class="row">
            <div class="col-6">
                <h3 style="text-align: center; padding-bottom: 20px">Основная информация</h3>
                <dl class="row" style="padding-bottom:0">
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Название вакансии:</dt>
                            <dd class="col-sm-7">${vacancy.jobTitle}</dd>
                        </dl>
                    </dd>
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Зарплата:</dt>
                            <dd class="col-sm-7">${vacancy.salary}</dd>
                        </dl>
                    </dd>
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Дата публикации:</dt>
                            <dd class="col-sm-7">${vacancy.dateOfPublication}</dd>
                        </dl>
                    </dd>
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Требования к кандидату:</dt>
                            <dd class="col-sm-7">${vacancy.requirements.requirements}</dd>
                        </dl>
                    </dd>
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Описание вакансии:</dt>
                            <dd class="col-sm-7">${vacancy.requirements.jobDescription}</dd>
                        </dl>
                    </dd>
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Количество вакансий:</dt>
                            <dd class="col-sm-7">${vacancy.numberOfVacancy}</dd>
                        </dl>
                    </dd>
                </dl>
            </div>

            <div class="col-6">

                <div class="col-12 collapse" id="multiCollapseExample1"
                     style="padding-bottom: 20px">
                    <#if candidates?size != 0>
                        <h3 style="text-align: center; padding-bottom: 20px">Подробнее об кандидатах</h3>
                        <table class="table table-bordered">
                            <thead class="table-secondary">
                            <tr>
                                <th scope="col">Id кандидата</th>
                                <th scope="col">Фио</th>
                                <th scope="col">Email</th>
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
                    <#else> <h3 style="text-align: center; padding-bottom: 20px">Кандидатов нет</h3>
                    </#if>
                </div>


                <div class="col-12 collapse" id="multiCollapseExample2"
                     style="padding-bottom: 20px">
                    <#if employees?size != 0>
                        <h3 style="text-align: center; padding-bottom: 20px">Подробнее об сотрудниках</h3>
                        <table class="table table-bordered">
                            <thead class="table-secondary">
                            <tr>
                                <th>Id</th>
                                <th>Фио</th>
                                <th>Должность</th>
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
                                        <#if employee.education??>
                                            Присутствует
                                        <#else> Отсутствует
                                        </#if>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    <#else> <h3 style="text-align: center; padding-bottom: 20px">Сотрудников нет</h3>
                    </#if>
                </div>

            </div>
        </div>

        <div class="row">
            <#if candidates?size != 0>
                <a class="btn btn-dark mt-3 mb-3 col-2" style="text-align: center; margin-right:14px"
                   data-toggle="collapse" href="#multiCollapseExample1" role="button"
                   aria-expanded="true" aria-controls="collapseExample">
                    Показать кандидатов
                </a>
            </#if>
            <#if employees?size != 0>
                <a class="btn btn-dark mt-3 mb-3 col-2" style="text-align: center"
                   data-toggle="collapse" href="#multiCollapseExample2" role="button"
                   aria-expanded="true" aria-controls="collapseExample">
                    Показать сотрудников
                </a>
            </#if>
            <#if !user.isUser()>
                <form class="align-items-center mt-3 md-3 col-2"
                      action="/vacancy/delete/${vacancy.idVacancy}"
                      method="post">
                    <button style="width: 100%" type="submit" class="btn btn-danger">
                        Убрать вакансию
                    </button>
                </form>
            </#if>
        </div>
    </div>

</@t.template>