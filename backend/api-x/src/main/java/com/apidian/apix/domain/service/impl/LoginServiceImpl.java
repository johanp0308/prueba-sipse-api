package com.apidian.apix.domain.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apidian.apix.domain.repositories.UserRepository;
import com.apidian.apix.domain.security.JWTAuthorizationFilter;
import com.apidian.apix.domain.security.JWTAuthtenticationConfig;
import com.apidian.apix.domain.service.LoginSevice;
import com.apidian.apix.persistence.dto.UserDto;
import com.apidian.apix.persistence.entities.UserEntity;

@Service
public class LoginServiceImpl implements LoginSevice{
    
    private final UserRepository userRepository;
    
    @Autowired
    public LoginServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTAuthorizationFilter jwtAuthorizationFilter;
    
    @Autowired
    private JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @Override
    public UserDto loginUser(String username, String password) {
        UserEntity oUser = userRepository.findByUsername(username).orElse(null);
        if (oUser != null) {
            UserEntity userEntity = oUser;
            if(passwordEncoder.matches(password, userEntity.getPassword())){
                String token = jwtAuthtenticationConfig.getJWTToken(userEntity.getUsername());
                UserDto userDTO = new UserDto();
                userDTO.setUsername(userEntity.getUsername());
                userDTO.setToken(token);
                return userDTO;
            }
        }
        return null;
    }

    @Override
    public UserDto registerUser(String username, String password) {
        UserEntity oUser = userRepository.findByUsername(username).orElse(null);
        if(oUser == null){
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(username);
            userEntity.setPassword(passwordEncoder.encode(password));
            UserEntity response = userRepository.save(userEntity); 
            if (response != null) {
                UserDto userDTO = new UserDto();
                userDTO.setUsername(username);
                userDTO.setToken(jwtAuthtenticationConfig.getJWTToken(response.getUsername()));
                return userDTO;
            }
        }
        return null;
    }

    @Override
    public Map<String, Object> validateTokeN(String token) {
        boolean valid = false;
        Boolean isJWTValid = jwtAuthorizationFilter.isJWTValid(token);
        if (isJWTValid) {
            String username = jwtAuthorizationFilter.getClaims(token).getSubject();
            UserEntity userEntity = userRepository.findByUsername(username).orElse(null);
            if (userEntity != null) {
                valid = true;
            }

        }
        Map<String,Object> repsonse = new HashMap<>();
        repsonse.put("is_token_valid", valid);
        return repsonse;
    }

}

