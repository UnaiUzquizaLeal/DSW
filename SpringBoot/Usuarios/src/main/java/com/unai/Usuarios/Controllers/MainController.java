package com.unai.Usuarios.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(){

        return "index";
    }
    /*
    @GetMapping("/discos")
    public String discos(){

        return "discos";
    }

    @GetMapping("/artistas")
    public String Artistas(){

        return "artistas";
    }

     */

    @GetMapping("/login")
    public String login(){

        return "login";
    }
}
