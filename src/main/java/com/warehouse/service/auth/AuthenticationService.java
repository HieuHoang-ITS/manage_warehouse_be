package com.warehouse.service.auth;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.warehouse.exception.BadCredentialsException;
import com.warehouse.exception.RecordNotFoundException;
import com.warehouse.common.Constants;
import com.warehouse.dto.request.LoginRequest;
import com.warehouse.dto.response.ApiResponse;
import com.warehouse.dto.response.LoginResponse;
import com.warehouse.entity.User;
import com.warehouse.repository.UserRepository;
import com.warehouse.security.JwtTokenUtil;
import com.warehouse.security.UserDetailsImpl;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtUtils;

    public ApiResponse authLogin(LoginRequest request) {
        String userName = request.getUsername().trim();
        User user = userRepository.findByUsername(userName).orElseThrow(() -> new RecordNotFoundException(userName));
        Boolean passwordMatch = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if(!passwordMatch) {
            throw new BadCredentialsException(Constants.USER_NAME_OR_PASSWORD_ERROR);
            
        }
        String jwt = jwtUtils.generateJwtToken(userName);
        UserDetailsImpl userDetails = UserDetailsImpl.build(user);
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        LoginResponse loginResponse = new LoginResponse(userName, jwt, roles, jwtUtils.getExtAt(jwt).getTime());
        return ApiResponse.ApiResponseSuccess(loginResponse);
    }
}
