# Students Api Service
Cервис предоставляет информацию о студентах курса. Информация доступна только для авторизованных пользователей с ролью USER.
Предусмотрен дефолтный администратор сервиса admin:pass. Только для администратора с ролью ADMIN доступно добавление пользователей.


## Стек технологий
- ![Java 17](https://img.shields.io/badge/Java-17-blue)
- ![Spring 3.2.4](https://img.shields.io/badge/Spring%20Boot%203.2.4-white?style=flat&logo=Spring)
- ![Liquibase 4.24.0](https://img.shields.io/badge/Liquibase_4.24.0-white?style=flat&logo=Liquibase&logoColor=blue
  )
- ![PostgreSQL 42.6.2](https://img.shields.io/badge/PostgreSQL_42.3.8-white?style=flat&logo=PostgreSQL&logoColor=blue
  )
- ![Maven 4.0.0](https://img.shields.io/badge/Maven%204.0.0-white?style=flat&logo=Apache%20Maven&logoColor=red
  )
- ![Lombok 1.18.32](https://img.shields.io/badge/Lombok%201.18.26-white?style=flat
  )

## Окружение
- Java 17
- PostgreSQL 16
- Apache Maven 4.0.0

## Запуск проекта
1. Скачать архив проекта или клонировать.
2. Создать локальную базу данных base, используя интерфейс PostgreSQL 16 или команду:

   ```create database base```

3. В файл конфигурации application.properties внести логин и пароль пользователя для доступа к базе данных base.
4. Для запуска на локальной машине скомпилировать и запустить проект в командной строке

   ```mvn spring-boot:run```

   или после сборки проекта с использованием maven выполнить в командной строке

   ``` java -jar target/task4-0.0.1-SNAPSHOT.jar```

## Описание CODE API

### GET /swagger-ui/index.html - Swagger. Доступно без авторизации.

### GET /v3/api-docs - описание API для Swagger. Доступно без авторизации.

### POST /login - авторизация по логину и паролю. 

структура запроса:
```
{
    "username" : "admin",
    "password" : "pass"
}
```

ответ с заголовком:<br>
Authorization: "*JWT токен*"

### POST /account/new - добавление нового пользователя. Авторизация по JWT токену.

структура запроса:
```
{
  "name": "string",
  "password": "string",
  "roles": "string"
}
```
структура ответа:
```
{
  "name": "string",
  "roles": "string"
}
```

### GET /students/{number} - получение информации о студенте. Авторизация по JWT токену.

структура ответа:
```
{
  "testBookNumber": 0,
  "faculty": "string",
  "firstName": "string",
  "lastName": "string",
  "middleName": "string"
}
```

### GET /students - получение информации о всех студентах. Авторизация по JWT токену.

структура ответа:
```
[
  {
    "testBookNumber": 0,
    "faculty": "string",
    "firstName": "string",
    "lastName": "string",
    "middleName": "string"
  }
]
```

## Контакты

email: gretskih@mail.ru <br/>
telegram: @Anatolij_gr