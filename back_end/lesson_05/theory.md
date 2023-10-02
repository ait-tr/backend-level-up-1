# Web в Java

* `Сервлет` - класс, который способен обрабатывать HTTP-запросы. Это единственный класс, который может в Java их обрабатывать.
* `Tomcat` - специальное приложение, называемое "контейнером сервлетов". Внутри него запускаются сервлеты и обрабатывают запросы.
* В `Spring Boot` `Tomcat` - встроенный, и его настройки можно задавать через `application.properties`

## DispatcherServlet

* Главный сервлет, который реализован в `Spring Web`
* Является обработчиком всех запросов, поступающих в ваше приложение.
* У него есть поле:
    * `handlerMappings` - оно содержит все ваши обработчики запросов (т.е. методы контроллеров, которые будут их обрабатывать)
    * Метод `doService()` получает первоначальный запрос и отдает обработку методу `doDispatch()`
        * Метод `doDispatch()` подбирает нужный обработчик для вашего запроса с помощью метода `getHandler()`
            * У выбранного обработчика вызывается метод `handle()`, который как раз вызывает метод контроллера.
            * Ответ уходит обратно в DispatcherServlet (после конвертации в JSON) и затем клиенту.

## Spring Boot

* Какие задачи берет на себя?

1. Автоматическая настройка HikariCP
2. Автоматическая настройка и запуск Tomcat
3. Автоматическое размещение в Tomcat `DispatcherServlet`
4. Возможность настройки всех компонентов через `application.properties
5.
6.
7. Стандарты в Java:

- JDBC - стандарт работы с базами данных (набор интерфейсов и классов и т.д.) для нативной работы с базами данных
- JPA - стандарт работы с базами данных через ORM (аннотации OneToMany, ManyToOne и т.д.)
- Java Servlet API - стандарт работы с HTTP (очень низкоуровневый)

- Tomcat - стороннее приложение, которое в свою очередь, запускает ваши Java-приложения

`jar` - Java Archive
`war` - Web Archive