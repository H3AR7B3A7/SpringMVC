# Spring web MVC
After exploring Java Enterprise, Servlets & JSPs I felt ready to return to Spring and dive deeper into what Spring MVC is all about.
I didn't start this project with the Spring initializr though, but used the Maven 'archetype-web-app' option under Maven projects.  
From what I understand, Spring hides some older project structure from the user, but in this project we will need access to the web.xml
in the "webapp > WEB-INF" - file structure. It is where we can set up and configure our connections to the 'invisible' dispatcher servlet,
the front-controller that has been doing all the hard work in our Spring projects without taking any credit.

## Dispatcher Servlet
As its name suggests, it is a central dispatcher for HTTP request handlers/controllers, e.g. for web UI controllers or HTTP-based remote service exporters.
The dispatcher servlet dispatches requests and responses to registered handlers for processing, providing convenient mapping and exception handling facilities.  
<img width="600" src="https://docs.spring.io/spring-framework/docs/3.0.0.RC2/spring-framework-reference/html/images/mvc.png.pagespeed.ce.tmIzOTr1gg.png" alt="fc"><br>
<img width="600" src="https://www.tutorialspoint.com/spring/images/spring_dispatcherservlet.png" alt="ds">
