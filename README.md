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

## XML or JavaConfig
We started off with a full XML-based configuration of the web application and the dispatcher servlet. Then we discarded the 'web.xml'
and switched to using the annotated class 'MyWebInitializer'. After that we also changed out the -servlet.xml for the 'MyConfig' class.  
[Here](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/WebApplicationInitializer.html)
we can find more information on how to set up either an XML-based configuration, a code-based one or even a hybrid.

### View Resolver
Because all requests go through our dispatcher servlet we can also add a prefix and suffix to our views here.
If we ever change the view layer we would just need to change the suffix in one location.  
Java Config:

    @Bean
        public InternalResourceViewResolver viewResolver(){
    
            InternalResourceViewResolver vr = new InternalResourceViewResolver();
            vr.setPrefix("/WEB-INF/");
            vr.setSuffix(".jsp");
    
            return vr;
        }
        
Xml:

    <bean id="viewResolver"
          class="org.springframework.web.servlet.view.UrlBasedViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>

It is also possible to mix or chain, more on this [here](https://docs.spring.io/spring-framework/docs/3.0.0.M3/spring-framework-reference/html/ch16s05.html).

## Error handling
Because we are not using spring boot, but are rather augmenting a Java web application with Spring features we would actually need web.xml in this case.
There is no Java Config equivalent for:  

    <error-page>
            <location>/error</location>
    </error-page>
    
In this [example](https://www.baeldung.com/servlet-exceptions) we can see how to fetch the error message along with the status code and exception type.