package com.apidian.apix.domain.service;




import java.util.Map;

import com.apidian.apix.persistence.dto.UserDto;

public interface LoginSevice {
    
    UserDto loginUser(String username, String password);
    UserDto registerUser(String username, String password);
    Map<String,Object> validateTokeN(String token);
    
}
