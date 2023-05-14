<#import "blocks/template.ftlh" as t>
<@t.template>
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

</@t.template>