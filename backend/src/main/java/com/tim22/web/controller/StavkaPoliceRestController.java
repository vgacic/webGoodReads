package com.tim22.web.controller;

import com.tim22.web.service.StavkaPoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StavkaPoliceRestController {
    @Autowired
    private StavkaPoliceService stavkaPoliceService;


}
