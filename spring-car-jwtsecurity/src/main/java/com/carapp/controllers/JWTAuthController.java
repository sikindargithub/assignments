package com.carapp.controllers;

import com.carapp.model.JWTUser;
import com.carapp.service.JWTUserServiceImpl;
import com.carapp.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTAuthController {


    private PasswordEncoder passwordEncoder;
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    private JWTUserServiceImpl jwtUserService;
    @Autowired
    public void setJwtUserService(JWTUserServiceImpl jwtUserService) {
        this.jwtUserService = jwtUserService;
    }
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }
    private AuthenticationManager authenticationManager;
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<String> request(@RequestBody JWTUser user){
        String username = user.getUsername();
        String password = passwordEncoder.encode(user.getPassword());
        JWTUser jwtUser = new JWTUser(username,password);

        // save in db
        jwtUserService.addUser(jwtUser);
        return ResponseEntity.ok("added");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody JWTUser user){
        // specify the type of authentication provider
        authenticate(user.getUsername(),user.getPassword());
        // check if username is in db
        UserDetails userDetails = jwtUserService.loadUserByUsername(user.getUsername());

        // generate the token with the userdata received from db
        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        // return the token in the response
        return ResponseEntity.ok(jwtToken);
    }
    // to specify the type of authentication
    private void authenticate(String username,String password){
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(username, password);
            authenticationManager.authenticate(authenticationToken);
        }catch(BadCredentialsException e){
            System.out.println("Invalid credentials");
        }catch (DisabledException e){
            System.out.println("disabled");
        }
    }

    @GetMapping("/greet")
    public String greet(){
        return "welcome to acheron";


    }
}
