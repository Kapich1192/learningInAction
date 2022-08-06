<body>
<section>
<p>========================================================</p>
<h2> Step #1 </h2>
<h4>Лендинг, главная страница</h4>
<ul>
    <li> 
        Добавлена страница "resources/templates/pages/login/home.html" 
    </li>
    <li> Добавлен контроллер "controllers/login/home/HomeController"
        <ul>
            <li>GET "/" возвращает страницу "home"</li>
            <li>POST "/" слушает форму на "home"</li>
        </ul>
    </li>
</ul>
<h4>Справочная информация</h4>
<p>
раз два три это лендинг
</p>
</section>
<section>
<p>========================================================</p>
<h2>Step #2</h2>
<h4>Базовая авторизация</h4>
<ul>
    <li>Добавляем БД на Docker 3307:MySQL/PhpMyAdmin</li>
    <li>Добавляем рабочую БД learning_in_action</li>
    <li>Добавляем зависимости для работы с БД в pom.xml</li>
    <li>Добавляем изменения в property.aplication</li>
    <li>Добавить модель для работы с БД User и репозиторий UserRepo</li>
    <li>Добавить в HomeController  в методе postReg регистрацию пользователя</li>
    <li></li>
</ul>
<h4>Справочная информация</h4>
<p>
Раз два три Авторизация готова
</p>
</section>
</body>
