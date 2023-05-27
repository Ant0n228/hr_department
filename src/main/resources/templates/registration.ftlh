<#import "blocks/template.ftlh" as t>
<@t.template>
    <div class="container py-5 h-100" style="margin-bottom: 20px">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-secondary text-white" style="border-radius: 1rem;">
                    <form action="/login" method="post">
                        <div class="card-body p-5 text-center">

                            <div class="mb-md-5 mt-md-4 pb-5">

                                <h2 class="fw-bold mb-2 text-uppercase">Регистрация</h2>
                                <p class="text-white-50 mb-5">Пожалуйста введите ваш email, логин и пароль</p>

                                <div class="form-outline form-white mb-4">
                                    <input type="email" class="form-control form-control-tg"
                                           name="email" required>
                                    <label class="form-label">Email</label>
                                </div>

                                <div class="form-outline form-white mb-4">
                                    <input type="text" class="form-control form-control-lg"
                                           name="login" required/>
                                    <label class="form-label">Логин</label>
                                </div>

                                <div class="form-outline form-white mb-4">
                                    <input type="password" id="typePasswordX" class="form-control form-control-lg"
                                           name="password" required/>
                                    <label class="form-label">Пароль</label>
                                </div>
                                <button class="btn btn-outline-light btn-lg px-5" type="submit">Зарегистрироваться
                                </button>
                            </div>

                            <div>
                                <p class="mb-0">У вас есть аккаунт? <a href="/login" class="text-white-50 fw-bold">
                                        Авторизоваться
                                    </a>
                                </p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
<#--    <h1>hr_department</h1>
    <hr>
    <h4>Регистрация</h4>
    <form action="/registration" method="post">
        Электронная почта <input type="email" required name="email"><br><br>
        Логин: <input type="text" required name="login"><br><br>
        Пароль: <input type="password" required name="password"><br><br>
        <input type="submit" value="Зарегистрироваться"/>

    </form>-->
</@t.template>