<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Department number ${department.idDepartment}</title>
</head>
<body>
<h4>подробнее об отделе</h4> <hr>
<b>Название отдела: </b>${department.departmentName} <br>
<b>Количество людей: </b>${department.numberOfPeople} <br>
<hr>

<h3>Расформировать отдел</h3>
<form action="/department/delete/${department.idDepartment}" method="post">
    <input type="submit" value="Расформировать отдел"/>
</form>

</body>
</html>