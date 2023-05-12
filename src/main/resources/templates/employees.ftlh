<#import "blocks/template.ftlh" as t>
<@t.template>
    <nav class="nav nav-pills nav-fill navbar-dark" style="margin-bottom:30px">
        <a class="nav-link active" aria-current="page" href="/employee/view">Сотрудники</a>
        <a class="nav-link" href="/vacancy/view">Вакансии</a>
        <a class="nav-link" href="/candidate/view">Кандидаты</a>
        <a class="nav-link" href="/department/view">Отделы</a>
    </nav>
    <h2 style="text-align: center; margin-bottom:20px">Поиск сотрудника</h2>
    <form class="row g-3 align-items-center" action="/employee/search" method="get" style="margin-bottom: 20px">
        <div class="col-4">
            <input type="text" name="position" class="form-control" placeholder="Должность">
        </div>

        <div class="col-6">
            <input type="text" name="fio" class="form-control" placeholder="Фио">
        </div>

        <div class="col-2">
            <button  class="btn btn-primary" style="width: 100%" formaction="/employee/view">Сбросить Поиск</button>
        </div>
        <button style="width: 100%" type="submit" class="btn btn-dark" >Поиск</button>
    </form>
    <br>
    <table class="table table-bordered">
        <thead class="table-secondary">
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
        </thead>
        <tbody>
        <#list employees as employee>
            <tr>
                <td>
                    <a class="link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover"
                       href="/employee/view/${employee.idEmployee}">Подробнее</a></td>
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
            <tr><h3>Сатрудников нет</h3></tr>
        </#list>
        </tbody>
    </table>

    <#--add new employee-->

    <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
       data-toggle="collapse" href="#mainCollapse" role="button"
       aria-expanded="true" aria-controls="collapseExample">
        добавить нового Кандидата
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
                <label for="dateOfEmployment">Дата приёма на работу: </label>
                <input type="date" required class="form-control" name="dateOfEmployment"/>
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

            <div class="form-group" style="margin-bottom: 10px">
                <label for="idDepartment">Выберете отдел: </label>
                <select id="idDepartment" required name="idDepartment" class="form-control">
                    <option value="">Выберете отдел</option>
                    <#list departments as deparment>
                        <option value=${deparment.idDepartment}>${deparment.departmentName}</option>
                    </#list>
                </select>
            </div>

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
</@t.template>