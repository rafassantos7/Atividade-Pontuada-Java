package com.senai.atividadepontuada.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Welcome {

    @GetMapping
    public String oi(){
        return "Seja bem vindo";
    }

    @GetMapping("/dev")
    public String dev(){
        return "Rafael Vitor";
    }
}
