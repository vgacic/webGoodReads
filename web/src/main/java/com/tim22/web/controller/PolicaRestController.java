package com.tim22.web.controller;

import com.tim22.web.service.PolicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicaRestController {
    @Autowired
    private PolicaService policaService;


}
