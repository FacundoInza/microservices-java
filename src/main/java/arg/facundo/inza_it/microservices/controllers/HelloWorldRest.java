package arg.facundo.inza_it.microservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRest {
    @GetMapping
    public String helloWString(){
        return "<h1>Hello world</h1>" +
                "<p>Microservices with Spring Boot</p>" +
                "<p>Facundo Inza</p>";
    }
}
