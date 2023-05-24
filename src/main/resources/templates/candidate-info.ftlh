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
            <h2 style="text-align: center; padding: 19px" class="col-8 position-relative">Подробнее об кандидате</h2>
        </div>
        <div class="row">
            <div class="col-6">
                <h3 style="text-align: center; padding-bottom: 20px">Основная информация</h3>
                <dl class="row" style="padding-bottom:0">
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Фио:</dt>
                            <dd class="col-sm-5">${candidate.fio}</dd>
                        </dl>
                    </dd>
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Email:</dt>
                            <dd class="col-sm-5">${candidate.email}</dd>
                        </dl>
                    </dd>
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Иностранный язык:</dt>
                            <dd class="col-sm-5">
                                <#if candidate.foreignLanguage??>
                                    не знает иностранных языков
                                <#else> ${candidate.foreignLanguage}
                                </#if>
                            </dd>
                        </dl>
                    </dd>
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Дата отклика:</dt>
                            <dd class="col-sm-5">${candidate.dateOfSubmission}</dd>
                        </dl>
                    </dd>
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Затус заявки:</dt>
                            <dd class="col-sm-5">
                                <#if candidate.applicationStatus>
                                    ещё не принят
                                <#else> принят
                                </#if>
                            </dd>
                        </dl>
                    </dd>
                </dl>
            </div>
            <#if candidate.education??>
                <div class="collapse col-6" id="mainCollapse">
                    <h3 style="text-align: center; padding-bottom: 20px">Информация об образовании</h3>
                    <dl class="row" style="padding-bottom:0">
                        <dd class="col-sm-9">
                            <dl class="row">
                                <dt class="col-sm-5">Учебное заведение:</dt>
                                <dd class="col-sm-5">${candidate.education.educationalInstitution}</dd>
                            </dl>
                        </dd>
                        <dd class="col-sm-9">
                            <dl class="row">
                                <dt class="col-sm-5">Факультет:</dt>
                                <dd class="col-sm-5">${candidate.education.faculty}</dd>
                            </dl>
                        </dd>
                        <dd class="col-sm-9">
                            <dl class="row">
                                <dt class="col-sm-5">Специализцация:</dt>
                                <dd class="col-sm-5">${candidate.education.specialization}</dd>
                            </dl>
                        </dd>
                        <dd class="col-sm-9">
                            <dl class="row">
                                <dt class="col-sm-5">Дата поступления в университет:</dt>
                                <dd class="col-sm-5">${candidate.education.dateOfGraduation}</dd>
                            </dl>
                        </dd>
                        <dd class="col-sm-9">
                            <dl class="row">
                                <dt class="col-sm-5">Дата Выпуска(отчисления):</dt>
                                <dd class="col-sm-5">
                                    <#if candidate.education.dateOfGraduation??>
                                        ${candidate.education.dateOfGraduation}
                                    <#else> ещё учится
                                    </#if>
                                </dd>
                            </dl>
                        </dd>
                    </dl>
                </div>
            </#if>
        </div>

        <div class="row">
            <#if candidate.education??>
                <a class="btn btn-dark mt-3 mb-3 col-2" style="text-align: center"
                   data-toggle="collapse" href="#mainCollapse" role="button"
                   aria-expanded="true" aria-controls="collapseExample">
                    Посмотреть образование
                </a>
            </#if>

            <form class="align-items-center mt-3 md-3 col-2"
                  action="/candidate/delete/${candidate.idCandidate}"
                  method="post">
                <button style="width: 100%" type="submit" class="btn btn-danger">
                    Убрать кандидата
                </button>
            </form>
        </div>
    </div>
</@t.template>