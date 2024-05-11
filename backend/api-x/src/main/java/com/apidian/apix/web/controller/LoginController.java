package com.apidian.apix.web.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.apidian.apix.domain.service.LoginSevice;
import com.apidian.apix.persistence.dto.UserDto;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "bearerAuth")
public class LoginController {

    @Autowired
    private LoginSevice loginSevice;

    @PostMapping("login")
    public ResponseEntity<?> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        UserDto userDTO = loginSevice.loginUser(username, password);

        if(userDTO == null){
            throw new UsernameNotFoundException("No existe");
        }
        return ResponseEntity.ok().body(userDTO);   
    }

    @PostMapping("registerUser")
    public ResponseEntity<?> registerUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        UserDto userDTO = loginSevice.registerUser(username, password);
        if(userDTO == null){
            throw new UsernameNotFoundException("No se creo");
        }
        return ResponseEntity.ok().body(userDTO);
    }
    
    @PostMapping("validateToken")
    public ResponseEntity<?> validateToken(@RequestParam("token") String token) {
        Map<String,Object> tokenMap = loginSevice.validateTokeN(token);
        return ResponseEntity.ok().body(tokenMap);
    }
    

    
}

