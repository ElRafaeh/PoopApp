package com.PoopApp.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @GetMapping("")
    public String getRoute() {

        return "Hola Mundo!";
    }
}
