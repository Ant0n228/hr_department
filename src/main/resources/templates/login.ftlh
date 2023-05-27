<#import "blocks/template.ftlh" as t>
<@t.template>
    <div class="container py-5 h-100" style="margin-bottom: 15px">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-secondary text-white" style="border-radius: 1rem;">
                    <form action="/login" method="post">
                        <div class="card-body p-5 text-center">

                            <div class="mb-md-5 mt-md-4 pb-5">

                                <h2 class="fw-bold mb-2 text-uppercase">Авторизация</h2>
                                <p class="text-white-50 mb-5">Пожалуйста введите ваш логин и пароль</p>

                                <div class="form-outline form-white mb-4">
                                    <input type="text" class="form-control form-control-lg"
                                           name="username" required/>
                                    <label class="form-label">Логин</label>
                                </div>

                                <div class="form-outline form-white mb-4">
                                    <input type="password" id="typePasswordX" class="form-control form-control-lg"
                                           name="password" required/>
                                    <label class="form-label">Пароль</label>
                                </div>
                                <button class="btn btn-outline-light btn-lg px-5" type="submit">Вход</button>
                            </div>

                            <div>
                                <p class="mb-0">У вас нет аккаунта? <a href="/registration"
                                                                       class="text-white-50 fw-bold">
                                        Зарегистрироваться
                                    </a>
                                </p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@t.template>