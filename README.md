# OSMTest
Первая работа по дисциплине "Геоинформацинные системы", ИТАС, ПНИПУ.

В настоящее время реализован простой wrapper для доступа к объектам OSM в заданной прямоугольной области.

В качестве примера тянутся объекты, находящиеся в центре г.Пермь (в области от компроса до Пермь-1).

Затем из данных объектов выбираются те, которые являются достопримечательностями и выводятся в стандартный поток.

Структура:
+ Пакет firstwork - функционал для получения данных с OSM, также здесь находится класс с методом main().
+ Пакет common - общие классы, которые, возможно, будут использованы далее (моделирование предметной области и загрузчик данных).

При разработке используется JAVA 8, но возможно, запустится и на JAVA 7 [не проверено], т.к. пока никаких новых фич не использовано.

