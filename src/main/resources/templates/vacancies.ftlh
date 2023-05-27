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
                        <a class="nav-link disabled">Вакансии</a>
                        <a class="nav-link active" aria-current="page" href="/candidate/view">Кандидаты</a>
                    <#elseif user.isDepartmentEngineer()>
                        <a class="nav-link active" aria-current="page" href="/employee/view">Сотрудники</a>
                        <a class="nav-link active" aria-current="page" href="/department/view">Отделы кадров</a>
                    <#elseif user.isUser()>
                        <a class="nav-link active" aria-current="page" href="/employee/view">Сотрудники</a>
                        <a class="nav-link disabled">Вакансии</a>
                        <a class="nav-link active" aria-current="page" href="/department/view">Отделы кадров</a>
                    <#elseif user.isChief()>
                        <a class="nav-link active" aria-current="page" href="/employee/view">Сотрудники</a>
                        <a class="nav-link disabled">Вакансии</a>
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

        <h2 style="text-align: center; margin-bottom:20px">Поиск вакансии</h2>
        <form class="row g-3 align-items-center" action="/vacancy/search" method="get" style="margin-bottom: 20px">
            <div class="col-10">
                <input type="text" name="jobTitle" class="form-control" placeholder="название вакансии">
            </div>
            <div class="col-2">
                <button class="btn btn-primary" style="width: 100%" formaction="/vacancy/view">Сбросить Поиск</button>
            </div>

            <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
        </form>
        <div class="cards-columns row">
            <#list vacancies as vacancy>
                <div class="col-sm-3 mb-3 mb-sm-0">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">${vacancy.jobTitle}</h5>
                            <h6 class="card-subtitle mb-2 text-body-secondary">Зарплата: ${vacancy.salary}</h6>
                            <h6 class="card-subtitle mb-2 text-body-secondary">Требуемое количество
                                людей: ${vacancy.numberOfVacancy}</h6>
                            <a href="/vacancy/view/${vacancy.idVacancy}"
                               class="card-link link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover"><b>Подробнее</b></a>
                        </div>
                    </div>
                </div>
            <#else><h6 styl="text-align: center">Вакансий нет</h6>
            </#list>
        </div>

        <#if !user.isUser()>
            <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
               data-toggle="collapse" href="#mainCollapse" role="button"
               aria-expanded="true" aria-controls="collapseExample">
                Добавить новую вакансию
            </a>
            <div class="collapse mb-3" id="mainCollapse" style="margin-bottom: 10px">
                <form action="/vacancy/create" method="post">
                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="jobTitle">Название вакансии: </label>
                        <input type="text" required class="form-control" name="jobTitle">
                    </div>
                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="salary">Зарплата: </label>
                        <input type="number" required class="form-control" name="salary">
                    </div>
                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="requirements.requirements">Требования к кандидату: </label>
                        <input type="text" required class="form-control" name="requirements.requirements">
                    </div>
                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="requirements.jobDescription">Описание вакансии: </label>
                        <input type="text" required class="form-control" name="requirements.jobDescription">
                    </div>
                    <div class="form-group" style="margin-bottom: 10px">
                        <label for="numberOfVacancy">Требуемое количество людей: </label>
                        <input type="number" required class="form-control" name="numberOfVacancy">
                    </div>

                    <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
                </form>
            </div>
        </#if>
    </div>

</@t.template>