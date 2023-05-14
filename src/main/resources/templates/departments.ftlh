<#import "blocks/template.ftlh" as t>
<@t.template>
    <nav class="nav nav-pills nav-fill navbar-dark" style="margin-bottom:30px">
        <a class="nav-link" href="/employee/view">Сотрудники</a>
        <a class="nav-link" href="/vacancy/view">Вакансии</a>
        <a class="nav-link" href="/candidate/view">Кандидаты</a>
        <a class="nav-link active" aria-current="page" href="/department/view">Отделы</a>
    </nav>
    <h2 style="text-align: center; margin-bottom:20px">Поиск отдела</h2>
    <form class="row g-3 align-items-center" action="/department/search" method="get" style="margin-bottom: 20px">
        <div class="col-10">
            <input type="text" name="departmentName" class="form-control" placeholder="название отдела">
        </div>
        <div class="col-2">
            <button class="btn btn-primary" style="width: 100%" formaction="/department/view">Сбросить Поиск</button>
        </div>

        <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
    </form>
    <div class="cards-columns row">
        <#list departments as department>
            <div class="col-sm-3 mb-3 mb-sm-0">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">${department.departmentName}</h5>
                        <h6 class="card-subtitle mb-2 text-body-secondary">Количество
                            людей: ${department.numberOfPeople}</h6>
                        <a href="/department/view/${department.idDepartment}"
                           class="card-link link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover"><b>Подробнее</b></a>
                    </div>
                </div>
            </div>
        <#else><h6 styl="text-align: center">Отделов нет</h6>
        </#list>
    </div>
    <hr>
    <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
       data-toggle="collapse" href="#mainCollapse" role="button"
       aria-expanded="true" aria-controls="collapseExample">
        Добавить новый отдел
    </a>
    <div class="collapse mb-3" id="mainCollapse" style="margin-bottom: 10px">
        <form action="/department/create" method="post">
            <div class="form-group" style="margin-bottom: 10px">
                <label for="departmentName">Название вакансии: </label>
                <input type="text" required class="form-control" name="departmentName">
            </div>
            <div class="form-group" style="margin-bottom: 10px">
                <label for="numberOfPeople">Количество людей</label>
                <input type="number" required class="form-control" name="numberOfPeople">
            </div>
            <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
    </div>
</@t.template>