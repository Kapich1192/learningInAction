<head>
<!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body class="bg-dark">
<section >
<p>========================================================</p>
<h2 class="text-light"> Step #1 </h2>
<h4 class="text-light">Лендинг, главная страница</h4>
<ul class="text-light">
    <li > 
        Добавлена страница "resources/templates/pages/login/home.html" 
    </li>
    <li> Добавлен контроллер "controllers/login/home/HomeController"
        <ul class="text-light">
            <li>GET "/" возвращает страницу "home"</li>
            <li>POST "/" слушает форму на "home"</li>
        </ul>
    </li>
</ul>
<h4 class="text-light">Справочная информация</h4>
<p class="text-light">
раз два три это лендинг
</p>
</section>
<section>
<p>========================================================</p>
<h2 class="text-light">Step #2</h2>
<h4 class="text-light">Базовая авторизация</h4>
<ul class="text-light">
    <li>Добавляем БД на Docker 3307:MySQL/8082:PhpMyAdmin</li>
    <li>Добавляем рабочую БД learning_in_action</li>
    <li>Добавляем зависимости для работы с БД в pom.xml</li>
    <li>Добавляем изменения в property.aplication</li>
    <li>Добавить модель для работы с БД User и репозиторий UserRepo</li>
    <li>Добавить в HomeController  в методе postReg регистрацию пользователя</li>
    <li>Добавить страницу Рабочая панель</li>
    <li>Сделать разбивку страниц на блоки в Thymeleth</li>
`   <li>Добавить страницу Profile</li>
    <li>Реализовать на ней Post методы обновления данных в БД</li>
</ul>
<h4 class="text-light">Справочная информация</h4>
<p class="text-light">
Раз два три Авторизация готова
</p>
</section>
<section>
<p>========================================================</p>
<h2 class="text-light">Step #3</h2>
<h4 class="text-light">Добавление тестового контента</h4>
<ul class="text-light">
    <li>Добавляем текстовый контент на главную страницу("/")</li>
    <li></li>
</ul>
<h4 class="text-light">Справочная информация</h4>
<p class="text-light">
Раз два три Авторизация готова
</p>
</section>
</body>
