<#import "blocks/template.ftlh" as t>
<@t.template>
    <nav class="nav nav-pills nav-fill navbar-dark" style="margin-bottom:30px">
        <a class="nav-link" href="/employee/view">Сотрудники</a>
        <a class="nav-link active" aria-current="page" href="/vacancy/view">Вакансии</a>
        <a class="nav-link" href="/candidate/view">Кандидаты</a>
        <a class="nav-link" href="/department/view">Отделы</a>
    </nav>
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

    <hr>
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
            <div clas="form-group" style="margin-bottom:10px">
                <label for="dateOfPublication">Дата публикации: </label>
                <input type="date" required class="form-control" name="dateOfPublication">
            </div>
            <div class="form-group" style="margin-bottom: 10px">
                <label for="numberOfVacancy">Требуемое количество людей: </label>
                <input type="number" required class="form-control" name="numberOfVacancy">
            </div>

            <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
    </div>
</@t.template>