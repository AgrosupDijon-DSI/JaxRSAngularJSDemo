JaxRSAngularJSDemo
=================

Basic demo of REST client-server using Java JaxRS and AngularJS.
Used in a course on REST Web Services for beginners.

Requirements :
* JDK >= 7,
* Eclipse IDE for Java EE Devs (Kepler),
* Glassfish 4.0,
* Recent web browser.

Setup :
1. Start Eclipse, install eGit, restart Eclipse
2. Setup Glassfish4 server in Eclipse
3. Import > Git > Projects from Git. Choose *Clone URI*, Copy/Paste this repository clone URL, and follow default choices.
4. Project Properties (right click project) : choose *Project Facet*
5. Tick *Java (1.7)*, *Dynamic Web Module (3.0)* and *Javascript (1.0)* and verify facet versions.
6. Right click Glassfish Server in Servers tab and choose *Add and remove...*
7. Add *Directory* project to Glassfish server.
8. Right click Glassfish Server and choose *Start*
9. Start your web browser and go to *http://localhost:8080/Directory/*
10. You can also go to Glassfish Console from *http://localhost:4848/* and check your deployed Application.

To do :
* Better handling of returned values (int in plain text),
* Better handling of exceptions,
* Better comments,
* Check for better import from git.
