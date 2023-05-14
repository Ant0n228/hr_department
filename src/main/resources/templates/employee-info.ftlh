<#import "blocks/template.ftlh" as t>
<@t.template>
    <div class="row" style="margin-bottom: 40px">
        <a href="javascript:history.back()" class="nav-link col-2 position-relative"
           style="font-size:40px; padding-top:6px">&#8249;</a>
        <h2 style="text-align: center; padding: 19px" class="col-8 position-relative">Подробнее об сотруднике</h2>
    </div>

    <div class="row">
        <div class="col-6">
            <h3 style="text-align: center; padding-bottom: 20px">Основная информация</h3>
            <dl class="row" style="padding-bottom:0">
                <dd class="col-sm-9">
                    <dl class="row">
                        <dt class="col-sm-5">Фио:</dt>
                        <dd class="col-sm-5">${employee.fio}</dd>
                    </dl>
                </dd>

                <dd class="col-sm-9">
                    <dl class="row">
                        <dt class="col-sm-5">Должность:</dt>
                        <dd class="col-sm-5">${employee.position}</dd>
                    </dl>
                </dd>

                <dd class="col-sm-9">
                    <dl class="row">
                        <dt class="col-sm-5">Зарплата:</dt>
                        <dd class="col-sm-5">${employee.salary} руб.</dd>
                    </dl>
                </dd>
                <dd class="col-sm-9">
                    <dl class="row">
                        <dt class="col-sm-5">Дата приема на работу:</dt>
                        <dd class="col-sm-5">${employee.dateOfEmployment}</dd>
                    </dl>
                </dd>
                <dd class="col-sm-9">
                    <dl class="row">
                        <dt class="col-sm-5">Email:</dt>
                        <dd class="col-sm-5">${employee.email}</dd>
                    </dl>
                </dd>
                <dd class="col-sm-9">
                    <dl class="row">
                        <dt class="col-sm-5">Иностранный язык</dt>
                        <dd class="col-sm-5">
                            <#if employee.foreignLanguage??>
                                ${employee.foreignLanguage}
                            <#else> Не знает иностранных языков
                            </#if>
                        </dd>
                    </dl>
                </dd>
                <dd class="col-sm-9">
                    <dl class="row">
                        <dt class="col-sm-5">Дата увольнения:</dt>
                        <dd class="col-sm-5">
                            <#if employee.dateOfDismissal??>
                                ${employee.dateOfDismissal}
                            <#else> Увольнению не подлежит
                            </#if>
                        </dd>
                    </dl>
                </dd>
            </dl>
        </div>
        <#if employee.education??>
            <div class="collapse col-6" id="mainCollapse">
                <h3 style="text-align: center; padding-bottom: 20px">Информация об образовании</h3>
                <dl class="row" style="padding-bottom:0">
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Учебное заведение:</dt>
                            <dd class="col-sm-5">${employee.education.educationalInstitution}</dd>
                        </dl>
                    </dd>
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Факультет:</dt>
                            <dd class="col-sm-5">${employee.education.faculty}</dd>
                        </dl>
                    </dd>
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Специализцация:</dt>
                            <dd class="col-sm-5">${employee.education.specialization}</dd>
                        </dl>
                    </dd>
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Дата поступления в университет:</dt>
                            <dd class="col-sm-5">${employee.education.dateOfGraduation}</dd>
                        </dl>
                    </dd>
                    <dd class="col-sm-9">
                        <dl class="row">
                            <dt class="col-sm-5">Дата Выпуска(отчисления):</dt>
                            <dd class="col-sm-5">
                                <#if employee.education.dateOfGraduation??>
                                    ${employee.education.dateOfGraduation}
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
        <#if employee.education??>
            <a class="btn btn-dark mt-3 mb-3 col-2" style="text-align: center"
               data-toggle="collapse" href="#mainCollapse" role="button"
               aria-expanded="true" aria-controls="collapseExample">
                Посмотреть образование
            </a>
        </#if>

        <form class="align-items-center mt-3 md-3 col-2" action="/employee/delete/${employee.idEmployee}"
              method="post">
            <button style="width: 100%" type="submit" class="btn btn-danger">Уволить сотрудника</button>
        </form>
    </div>
</@t.template>