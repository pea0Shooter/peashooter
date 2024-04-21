package com.library.controller;

import com.library.domain.Register;
import com.library.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/register")
    public int Rgister(@RequestBody Register register) {
        return registerService.RegisterService(register);
    }
}
