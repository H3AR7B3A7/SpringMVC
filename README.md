# Spring web MVC
After exploring Java Enterprise, Servlets & JSPs I felt ready to return to Spring and dive deeper into what Spring MVC is all about.
I didn't start this project with the Spring initializr though, but used the Maven 'archetype-web-app' option under Maven projects.  
From what I understand, Spring hides some older project structure from the user, but in this project we will need access to the web.xml
in the "webapp > WEB-INF" - file structure. It is where we can set up and configure our connections to the 'invisible' dispatcher servlet,
the front-controller that has been doing all the hard work in our Spring projects without taking any credit.

## Dispatcher Servlet
As its name suggests, it is a central dispatcher for HTTP request handlers/controllers, e.g. for web UI controllers or HTTP-based remote service exporters.
The dispatcher servlet dispatches requests and responses to registered handlers for processing, providing convenient mapping and exception handling facilities.  
<br>
<img width="500" src="https://github.com/H3AR7B3A7/SpringMVC/blob/master/front-controller.png" alt="fc"><br>
<img width="500" src="https://github.com/H3AR7B3A7/SpringMVC/blob/master/dispatcher-servlet.png" alt="ds">

## Error handling
Because we are not using spring boot, but are rather augmenting a Java web application with Spring features we would actually need to use web.xml in this case.
There is no Java Config equivalent for:  

    <error-page>
            <location>/error</location>
    </error-page>
    
In this [example](https://www.baeldung.com/servlet-exceptions) we can see how to fetch the error message along with the status code and exception type.