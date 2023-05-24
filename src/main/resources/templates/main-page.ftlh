<#import "blocks/template.ftlh" as t>
<#import "blocks/navbar.ftlh" as nav>

<@t.template>
    <nav class="navbar navbar-expand-lg bg-body-secondary" style="margin-bottom: 20px">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Hr_department</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

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
        <h2 style="text-align: center; margin-top:20px">Приветствие</h2>
        <p>
            Добро пожаловать на сайт отдела кадров!
            Мы являемся сердцем нашей компании, занимаясь наймом,
            развитием и управлением нашими талантливыми сотрудниками.
            Здесь вы найдете полезную информацию о наших кадровых процессах,
            бенефитах, карьерных возможностях и многом другом.
        </p>


        <#if user.login??>
            <h2 style="text-align: center; margin-bottom:20px">Переход по таблицам</h2>
            <div class="cards-columns row">
                <#if user.isHrSpecialist()>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card mb-3" style="max-width: 18rem;">
                            <div class="card-header">Сотрудники</div>
                            <div class="card-body">
                                <p class="card-text">
                                    Наша ценнейшая активность.
                                    Наша команда талантливых профессионалов,
                                    вносящих свой вклад в успех нашей компании.
                                </p>
                                <a href="/employee/view"
                                   class="card-link link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover">
                                    <b>Подробнее</b>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card mb-3" style="max-width: 18rem;">
                            <div class="card-header">Вакансии</div>
                            <div class="card-body">
                                <p class="card-text">
                                    Открытые позиции,
                                    которые предлагают возможность присоединиться к нашей команде.
                                    Уникальные возможности для роста и развития в нашей компании.
                                </p>
                                <a href="/vacancy/view"
                                   class="card-link link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover">
                                    <b>Подробнее</b>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card mb-3" style="max-width: 18rem;">
                            <div class="card-header">Кандидаты</div>
                            <div class="card-body">
                                <p class="card-text">
                                    Талантливые претенденты,
                                    стремящиеся присоединиться к нам.
                                    Тщательный отбор, ценности компании и постоянный поиск новых талантов.
                                </p>
                                <a href="/candidate/view"
                                   class="card-link link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover">
                                    <b>Подробнее</b>
                                </a>
                            </div>
                        </div>
                    </div>

                <#elseif user.isDepartmentEngineer()>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card mb-3" style="max-width: 18rem;">
                            <div class="card-header">Сотрудники</div>
                            <div class="card-body">
                                <p class="card-text">
                                    Наша ценнейшая активность.
                                    Наша команда талантливых профессионалов,
                                    вносящих свой вклад в успех нашей компании.
                                </p>
                                <a href="/employee/view"
                                   class="card-link link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover">
                                    <b>Подробнее</b>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card mb-3" style="max-width: 18rem;">
                            <div class="card-header">Отделы кадров</div>
                            <div class="card-body">
                                <p class="card-text">
                                    Разнообразные подразделения,
                                    составляющие нашу компанию.
                                    Каждый отдел играет важную роль в достижении наших целей.
                                </p>
                                <a href="/department/view"
                                   class="card-link link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover">
                                    <b>Подробнее</b>
                                </a>
                            </div>
                        </div>
                    </div>

                <#elseif user.isUser()>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card mb-3" style="max-width: 18rem;">
                            <div class="card-header">Сотрудники</div>
                            <div class="card-body">
                                <p class="card-text">
                                    Наша ценнейшая активность.
                                    Наша команда талантливых профессионалов,
                                    вносящих свой вклад в успех нашей компании.
                                </p>
                                <a href="/employee/view"
                                   class="card-link link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover">
                                    <b>Подробнее</b>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card mb-3" style="max-width: 18rem;">
                            <div class="card-header">Вакансии</div>
                            <div class="card-body">
                                <p class="card-text">
                                    Открытые позиции,
                                    которые предлагают возможность присоединиться к нашей команде.
                                    Уникальные возможности для роста и развития в нашей компании.
                                </p>
                                <a href="/vacancy/view"
                                   class="card-link link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover">
                                    <b>Подробнее</b>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card mb-3" style="max-width: 18rem;">
                            <div class="card-header">Отделы кадров</div>
                            <div class="card-body">
                                <p class="card-text">
                                    Разнообразные подразделения,
                                    составляющие нашу компанию.
                                    Каждый отдел играет важную роль в достижении наших целей.
                                </p>
                                <a href="/department/view"
                                   class="card-link link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover">
                                    <b>Подробнее</b>
                                </a>
                            </div>
                        </div>
                    </div>
                <#elseif user.isChief()>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card mb-3" style="max-width: 18rem;">
                            <div class="card-header">Сотрудники</div>
                            <div class="card-body">
                                <p class="card-text">
                                    Наша ценнейшая активность.
                                    Наша команда талантливых профессионалов,
                                    вносящих свой вклад в успех нашей компании.
                                </p>
                                <a href="/employee/view"
                                   class="card-link link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover">
                                    <b>Подробнее</b>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card mb-3" style="max-width: 18rem;">
                            <div class="card-header">Вакансии</div>
                            <div class="card-body">
                                <p class="card-text">
                                    Открытые позиции,
                                    которые предлагают возможность присоединиться к нашей команде.
                                    Уникальные возможности для роста и развития в нашей компании.
                                </p>
                                <a href="/vacancy/view"
                                   class="card-link link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover">
                                    <b>Подробнее</b>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card mb-3" style="max-width: 18rem;">
                            <div class="card-header">Кандидаты</div>
                            <div class="card-body">
                                <p class="card-text">
                                    Талантливые претенденты,
                                    стремящиеся присоединиться к нам.
                                    Тщательный отбор, ценности компании и постоянный поиск новых талантов.
                                </p>
                                <a href="/candidate/view"
                                   class="card-link link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover">
                                    <b>Подробнее</b>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card mb-3" style="max-width: 18rem;">
                            <div class="card-header">Отделы кадров</div>
                            <div class="card-body">
                                <p class="card-text">
                                    Разнообразные подразделения,
                                    составляющие нашу компанию.
                                    Каждый отдел играет важную роль в достижении наших целей.
                                </p>
                                <a href="/department/view"
                                   class="card-link link-secondary link-offset-2 link-underline link-underline-opacity-0 link-opacity-10-hover">
                                    <b>Подробнее</b>
                                </a>
                            </div>
                        </div>
                    </div>

                <#else>
                    <p>ошибка</p>
                </#if>
            </div>
        </#if>
        <h2 style="text-align: center; margin-top:20px">О нас</h2>
        <p>
            Отдел кадров является ключевым элементом успешного функционирования нашей компании.
            Мы посвящены поиску, привлечению и развитию выдающихся профессионалов,
            которые помогут нам достигнуть наших целей и реализовать нашу миссию.
            Наша команда стремится создать поддерживающую и вдохновляющую рабочую среду,
            где каждый сотрудник может раскрыть свой потенциал.
        </p>
        <h2 style="text-align: center; margin-top:20px">Что мы предлагаем</h2>
        <ul>
            <li>
                Найм и отбор: Мы проводим тщательный процесс подбора,
                чтобы найти лучших кандидатов, отвечающих нашим требованиям и ценностям компании.
            </li>
            <li>
                Развитие и обучение: Мы предлагаем разнообразные программы обучения и развития для наших сотрудников,
                чтобы помочь им расти профессионально и достигать новых вершин.
            </li>
            <li>
                Карьерные возможности: Мы стремимся поддерживать и поощрять рост наших сотрудников,
                предоставляя возможности для продвижения и развития карьеры внутри компании.
            </li>
            <li>
                Бенефиты и компенсация:
                Мы ценим наших сотрудников и предлагаем конкурентоспособные бенефиты и справедливую компенсацию,
                чтобы обеспечить их благополучие и удовлетворенность.
            </li>
        </ul>
        <p>
            Спасибо, что посетили наш сайт! Мы надеемся,
            что вы найдете здесь всю необходимую информацию
            о нашем отделе кадров и возможности присоединиться к нашей команде.
        </p>
    </div>
</@t.template>