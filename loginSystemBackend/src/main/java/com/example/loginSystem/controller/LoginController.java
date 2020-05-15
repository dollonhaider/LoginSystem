package com.example.loginSystem.controller;

import com.example.loginSystem.dto.ResponseDTO;
import com.example.loginSystem.dto.UserCreateDTO;
import com.example.loginSystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public ResponseDTO register(@RequestBody UserCreateDTO input) {
        ResponseDTO result = loginService.register(input);
        return result;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseDTO login(@RequestBody UserCreateDTO input)  {
        ResponseDTO result = loginService.login(input);
        return result;
    }
}
