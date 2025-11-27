package com.example.filmes.controller;

import com.example.filmes.service.FilmeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    public HomeController(){
    }

    @GetMapping
    public String home(){
        return "redirect:/filmes";
    }
}
