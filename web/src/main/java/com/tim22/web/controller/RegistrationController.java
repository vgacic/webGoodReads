package com.tim22.web.controller;

import org.springframework.ui.Model;
import com.tim22.web.dto.KorisnikDto;
import com.tim22.web.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import
@Controller
public class RegistrationController {
    @Autowired
    private KorisnikService korisnikService;



    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("korisnik", new KorisnikDto());
        return "registration";
    }


    @PostMapping("/register")
    public String registerKorisnik(@ModelAttribute("user") KorisnikDto korisnikDto, BindingResult bindingResult, @RequestParam("profilePicture")MultipartFile profilePicture)
    {
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        return null;
    }

}
