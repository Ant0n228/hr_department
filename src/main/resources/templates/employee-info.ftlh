<#import "blocks/template.ftlh" as t>
<@t.template>
    <h4>подробнее о работнике</h4>
    <hr>
    <b>Фио: </b>${employee.fio} <br>
    <b>Позиция: </b>${employee.position} <br>
    <b>Зарплата: </b> ${employee.salary} <br>
    <b>Дата приёма на работу: </b>
    <#if employee.dateOfEmployment??>
        ${employee.dateOfEmployment}
    </#if> <br>
    <b>Email: </b>${employee.email} <br>
    <b>Дата увольнения: </b>
    <#if employee.dateOfDismissal??>
        ${employee.dateOfDismissal}
    <#else> Увольнению не подлежит
    </#if> <br>

    <h4>подробнее об образовании работника</h4>
    <hr>
    <b>Учебное заведение: </b>${employee.education.educationalInstitution} <br>
    <b>Факультет: </b>${employee.education.faculty} <br>
    <b>Специализцация: </b> ${employee.education.specialization} <br>
    <b>Дата поступления в университет: </b> ${employee.education.dateOfAdmission} <br>
    <b>Дата Выпуска(отчисления): </b>
    <#if employee.education.dateOfGraduation??>
        ${employee.education.dateOfGraduation}
    <#else> ещё учится
    </#if> <br>

    <hr>

    <h3>Уволить работника</h3>
    <form action="/employee/delete/${employee.idEmployee}" method="post">
        <input type="submit" value="Уволить работника"/>
    </form>
</@t.template>