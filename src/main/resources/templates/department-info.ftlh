<#import "blocks/template.ftlh" as t>
<@t.template>
    <div class="row" style="margin-bottom: 40px">
        <a href="javascript:history.back()" class="nav-link col-2 position-relative"
           style="font-size:40px; padding-top:6px">&#8249;</a>
        <h2 style="text-align: center; padding: 19px" class="col-8 position-relative">Подробнее об отделе</h2>
    </div>
    <div class="row">
        <div class="col-6">
            <h3 style="text-align: center; padding-bottom: 20px">Основная информация</h3>
            <dl class="row" style="padding-bottom:0">
                <dd class="col-sm-9">
                    <dl class="row">
                        <dt class="col-sm-5">Название отдела:</dt>
                        <dd class="col-sm-7">${department.departmentName}</dd>
                    </dl>
                </dd>
                <dd class="col-sm-9">
                    <dl class="row">
                        <dt class="col-sm-5">Количество людей:</dt>
                        <dd class="col-sm-7">${department.numberOfPeople}</dd>
                    </dl>
                </dd>
            </dl>
        </div>

        <div class="col-6 collapse" id="mainCollapse">
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
    <div class="row">
        <#if employees?size != 0>
            <a class="btn btn-dark mt-3 mb-3 col-2" style="text-align: center"
               data-toggle="collapse" href="#mainCollapse" role="button"
               aria-expanded="true" aria-controls="collapseExample">
                Посмотреть сотрудников
            </a>
        </#if>

        <form class="align-items-center mt-3 md-3 col-2" action="/department/delete/${department.idDepartment}"
              method="post">
            <button style="width: 100%" type="submit" class="btn btn-danger">Удалить отдел</button>
        </form>
    </div>

</@t.template>