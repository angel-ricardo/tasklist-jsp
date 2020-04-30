# CRUD JSP Aplication

This project was made to learn how [JavaServer Pages] works.
The web application consist into a user to-do list where users can create tasks, edit them or delete them.

## About
We are the team N.5 in web programming class.
Our goal is to show classmates an example of a CRUD application using MVC pattern.

## Tech
* [Apache NetBeans] - IDE to work
* [GlassFish] - Web Server compatible with Servlets
* [XAMPP] - package that contains MySQl/MariaDB

## Setup
* Setup GlassFish Server
* Create a Web Project in Apache NetBeans ``Java with Ant -> Java Web -> Web Application``
If you're using Netbeans 8.2 or bellow use ``Java Web -> Web Application`` to create your project
* Add [jdbc:mysql] to project libraries
* Delete `index.html`
* Copy repository content into main project folder
* Start MySQL Service in XAMPP
* Load `tasklist_database.sql` into your DBMS

Then Run Project
Verify the deployment by navigating to your server address
```sh
localhost:8080/context-path/
```

License
----

MIT

[JavaServer Pages]: <https://en.wikipedia.org/wiki/JavaServer_Pages>
[Apache NetBeans]: <https://netbeans.apache.org/>
[GlassFish]: <https://javaee.github.io/glassfish/download>
[XAMPP]: <https://www.apachefriends.org/es/index.html>
[jdbc:mysql]: <https://dev.mysql.com/downloads/connector/j/>