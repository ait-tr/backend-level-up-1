## Философия

* Интерфейс - что же это такое?
* Вообще, это что-то, что может предоставить вам определенный функционал и вот этот функционал мы назваем интерфейсом
  * Интерфейс бывает пользовательский (UI) - т.е. это кнопки, окошки, вкладки
  * Есть интерфейс библиотеки - это весь набор функций, которые можно вызывать у этой библиотеки
  * Глобально - это доступный набор команд

## Hibernate

* Центральное понятие - `Сессия`/`Session`, представляет собой `сеанс соединения с базой данных`, аналог `Connection` в `JDBC`
* Настраивается через `XML`-файлы (есть возможность и Java, но там не сильно большая разница)
* Требует для сохранения связей (`many-to-many`, `one-to-many`) транзакций

* Hibernate - это не аннотации `OneToMany`, `ManyToMany` и т.д.!!!

## Транзакции

* `Транзакция` - последовательность действий, которая выполняется либо полностью, либо не выполняется вообще
  * Например `перевод денег`
    * На счете A уменьшить сумму на 10
    * На счете B увеличить сумма на 10
* В контексте баз данных, транзакция - последовательность SQL запросов.
* Как транзакция работает в SQL?
  * Сначала вы отправляете команду `BEGIN`
  * Когда заканчиваете транзакцию, отправляете `COMMIT`

## JPA

* Это как раз набор аннотаций, которые может использовать `Hibernate`
* JPA - стандарт ORM, а Hibernate - это реализация
* `EntityManager` - это менеджер сущностей, используется везде. Это интерфейс, который содержит методы для работы с объектами и базой данных
* Реализацию этого интерфейса предоставляет Hibernate
* Использование JPA и EntityManager обязывает использовать транзакции для любого сохранения