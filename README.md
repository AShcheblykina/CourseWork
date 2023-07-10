# Курсовой проект по модулю «Автоматизация тестирования» для профессии «Инженер по тестированию»

Курсовой проект — автоматизация тестирования комплексного сервиса, взаимодействующего с СУБД и API банка.

## Описание приложения

### Бизнес-часть

Приложение — это веб-сервис, который предлагает купить тур по определённой цене двумя способами:
1. Обычная оплата по дебетовой карте.
2. Уникальная технология: выдача кредита по данным банковской карты.

![](pic/service.png)

Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:
* сервису платежей, далее Payment Gate;
* кредитному сервису, далее Credit Gate.

Приложение в собственной СУБД должно сохранять информацию о том, успешно ли был совершён платёж и каким способом**. Данные карт сохранять не допускается.

*Важно. В реальной жизни приложение не должно пропускать через себя данные карт, если у него нет PCI DSS, но мы сделали именно так ;)*

### Техническая часть

Приложение расположено в файле [`aqa-shop.jar`](aqa-shop.jar) и запускается стандартным способом `java -jar aqa-shop.jar` на порту 8080.

В файле [`application.properties`](application.properties) дан ряд типовых настроек:
* учётные данные и URL для подключения к СУБД, которые нужно заполнить самостоятельно;
* URL-адреса банковских сервисов, которые уже заполнены.

### СУБД

Вы можете подключить к приложению любую из двух баз данных:
* MySQL;
* PostgreSQL.

Учётные данные и URL для подключения задаются в файле [`application.properties`](application.properties).

### Банковские сервисы

Симулятор банковских сервисов запущен по адресу `185.119.57.197:9999`. Этот адрес уже указан в файле [`application.properties`](application.properties).

Все запросы симулятора логируются, логи можно посмотреть здесь — `185.119.57.197:9998` (**student**/**logviewer**). На левой панели выберите контейнер с сервисами (он там один) и откройте для просмотра логов. Этот сервис — общий для всех студентов, поэтому логов может быть очень много и в них будет тяжело ориентироваться. Для упрощения работы к логам привязывается IP, с которого пришёл запрос в сервис. Вам нужно нажать комбинацию **CTRL + F** (**CMD + F** для MacOS) в окне с логами и ввести свой IP в строку поиска. Тогда вы будете видеть только свои логи в реальном времени. Узнать свой IP легко — используйте любой сервис для этого.

Сервис обрабатывает только специальные номера карт, которые даны для тестирования:
* APPROVED карта — `1111 2222 3333 4444`;
* DECLINED карта — `5555 6666 7777 8888`. 
Остальные данные карт могут быть любыми, но учитывайте, что год не должен быть прошлым, CVC состоит из трёх цифр и т. д.

Обратите внимание, разработчики сделали один сервис, симулирующий и Payment Gate, и Credit Gate.

## Задача

Ваша задача — автоматизировать позитивные и негативные сценарии покупки тура.

Задача разбита на 4 этапа:
1. Планировании автоматизации тестирования.
2. Тестирование сервиса покупки тура. Тестируйте обе формы, баги оформляйте в issues.
3. Автоматизация. Тесты пишите для **ОДНОЙ** формы, выбирайте любую.
4. Подготовка отчётных документов по итогам тестирования.
5. Подготовка отчётных документов по итогам автоматизации.

Все материалы — документы, автотесты, открытые issue, отчёты и другие — должны быть размещены в одном публичном репозитории. Ссылку на него вы будете отправлять наставнику.

### Планирование

После начала работы над проектом в течение трёх рабочих дней вы должны сдать наставнику план автоматизации с информацией:
* перечень автоматизируемых сценариев;
* перечень используемых инструментов с обоснованием выбора;
* перечень и описание возможных рисков при автоматизации;
* интервальная оценка с учётом рисков в часах;
* план сдачи работ: когда будут проведены автотесты, результаты их проведения и отчёт по автоматизации.

Отчёт оформляется в виде файла с именем `Plan.md` и загружается в репозиторий вашего проекта.

### Автоматизация

На этом этапе вы пишете автотесты и прогоняете их. Требования по подключению CI нет, но есть требования к тестам. Обязательно должны быть:
* UI-тесты;
* репорты — Gradle, Allure, Report Portal;
* запросы в базу, проверяющие корректность внесения информации приложением.

#### Дополнительные пункты автоматизации (необязательные)

* Автоматизировать тесты для двух форм покупки тура.
* Автоматизировать API-тесты для приложения. Автоматизировать нужно именно запросы, которые отправляются из браузера после заполнения формы, а не те, которые приложение отправляет в банковский сервис. Банковский сервис — это не ваша ответственность, но у вас есть доступ к логам.
* Запустить в контейнерах две базы данных — Mysql и Postgres — и параметризировать запуск приложения и тестов, передавая в параметрах разные конфигурации для подключения к любой из запущенных баз данных.

Код автотестов загружается в репозиторий вашего проекта вместе с отчётными документами, файлами и конфигурациями, необходимыми для запуска.

В файле `README.md` должна быть описана процедура запуска автотестов. Если для запуска нужно заранее установить, настроить, запустить какое-то ПО, то это тоже должно быть описано.

**Важно: если после `git clone` и выполнения шагов, описанных в `README.md`, авто-тесты не запускаются, то диплом отправляется на доработку.**

### Отчётные документы по итогам тестирования

В качестве отчётных документов прикладываются issue со скриншотами и описанием багов, формируется документ `Report.md`, в котором содержится отчёт о проведённом тестировании:
* краткое описание;
* количество тест-кейсов;
* процент успешных и не успешных тест-кейсов;
* общие рекомендации.

Кроме документа в систему автоматизации должны быть интегрированы отчёты: Gradle, Allure или Report Portal.

### Отчётные документы по итогам автоматизации

В качестве отчётных документов формируется документ `Summary.md`, в котором содержится отчёт о проведённой автоматизации:
* что было запланировано и что реализовано;
* причины, по которым что-то не было реализовано;
* сработавшие риски;
* общий итог по времени: сколько запланировали и сколько потратили с обоснованием расхождения.

## О документах

Когда мы просим вас подготовить документы разного формата, достаточно составить текст объёмом не больше страницы A4.

## О требованиях

Во время работы над дипломом важно прислушиваться к дипломному руководителю и его рекомендациям. Он будет ставить задачи, которые нужно выполнять для достижения лучших результатов обучения. В его интересах также ваше успешное прохождеие курса и получение диплома о его завершении.

## Expert Level

*Важно. Выполнение или не выполнение этого раздела не влияет на получение диплома.*

Если вы чувствуете в себе силы, мы предлагаем вам попробовать интегрировать всю систему с Appveyor CI, GitHub Actions или любой другой CI.

#### Полезная информация

1. На большинстве CI есть Docker и, возможно, даже Docker Compose.
2. На большинстве CI либо предустановлены Node.js, MySQL, PostgreSQL, либо их можно установить.
3. Вы можете вставлять простейшие `sleep` прямо в сценариях командной строки, чтобы дать «подняться» СУБД, SUT или симулятору. Хотя есть техники получше. Если вы это сделаете, не забудьте выставить бейджик сборки.

#### Подсказки

> Не читайте этот раздел сразу. Попытайтесь сначала решить задачу самостоятельно :)

<details>

<summary>На что обратить внимание.</summary>

 1. Приложение усыпано багами: от безобидных до очень критичных. Если вы не нашли ни одного, значит, попробуйте ещё раз :)
 2. Если есть баги, то тесты не должны быть зелёными.
 3. Если есть баги, то должны быть баг-репорты в issue.
 4. Обращайте внимание на все баги. Особенно внимательно смотрите на обработку платежей и их фиксацию.
</details>

## Как задавать вопросы руководителю по дипломной работе

1. Если у вас возник вопрос, попробуйте сначала самостоятельно найти ответ в интернете. Навык поиска информации пригодится вам в любой профессиональной деятельности. Если ответ не нашёлся, можно уточнить у руководителя по дипломной работе.
2. Если у вас набирается несколько вопросов, присылайте их в виде нумерованного списка. Так дипломному руководителю будет проще отвечать на каждый из них.
3. Для лучшего понимания контекста прикрепите к вопросу скриншоты и стрелкой укажите, что именно вызывает вопрос. Программу для создания скриншотов можно скачать [по ссылке](https://app.prntscr.com/ru/).
4. По возможности задавайте вопросы в комментариях к коду.
5. Формулируйте свои вопросы чётко, дополняя их деталями. На сообщения «Ничего не работает», «Всё сломалось» дипломный руководитель не сможет дать комментарии без дополнительных уточнений. Это затянет процесс получения ответа. 
6. Постарайтесь набраться терпения в ожидании ответа на свои вопросы. Дипломные руководители Нетологии – практикующие разработчики, поэтому они не всегда могут отвечать моментально. Зато их практика даёт возможность делиться с вами не только теорией, но и ценным прикладным опытом.  

Рекомендации по работе над дипломом:

1. Не откладывайте надолго начало работы над дипломом. В таком случае у вас останется больше времени на получение рекомендаций от руководителя и доработку диплома.
2. Разбейте работу над дипломом на части и выполняйте их поочерёдно. Вы будете успевать учитывать комментарии от руководителя и не терять мотивацию на полпути. 

