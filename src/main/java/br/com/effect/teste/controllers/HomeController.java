package br.com.effect.teste.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{

    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @GetMapping("/error")
    public String error()
    {
        return "index";
    }
}