package com.tim22.web.controller;

import com.tim22.web.service.ZanrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZanrRestController {
    @Autowired
    private ZanrService zanrService;
}