package com.cifp.Ejercicio1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControllers {
    @GetMapping("/")
    public String saluda(Model model){
        model.addAttribute("saludo","Hola mi gente!");
        return "index";
    }
    @GetMapping("/despedida")
    public String despedir(){
        return "despedida";
    }
    @GetMapping("/despedida")
    public String felicita(){
        return "despedida";
    }

}
