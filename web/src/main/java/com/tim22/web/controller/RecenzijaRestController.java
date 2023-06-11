package com.tim22.web.controller;

import com.tim22.web.service.RecenzijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecenzijaRestController {
    @Autowired
    private RecenzijaService recenzijaService;
}
