package com.carapp.controllers;

import com.carapp.model.AppUser;
import com.carapp.model.Car;
import com.carapp.service.IAppUserService;
import com.carapp.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("appuser-api")
public class AppUserController {

    private IAppUserService appUserService;
    @Autowired
    public void setAppUserService(IAppUserService appUserService) {
        this.appUserService = appUserService;
    }
    private PasswordEncoder passwordEncoder;
    @Autowired
    public AppUserController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    ICarService iCarService;
    @Autowired
    public void setiCarService(ICarService iCarService) {
        this.iCarService = iCarService;
    }

    @PostMapping("/admin/add/user")
    public void addUser(@RequestBody AppUser appUser){
        String username = appUser.getUsername();
        String password = appUser.getPassword();
        // encode the password before saving it to db
        String encodedPassword = passwordEncoder.encode(password);
        AppUser user = new AppUser(username,encodedPassword);
        appUserService.addUser(user);

    }
    @PutMapping("/admin/update/user")
    public void updateUser(@RequestBody AppUser appUser){
        String username = appUser.getUsername();
        String password = appUser.getPassword();
        // encode the password before saving it to db
        String encodedPassword = passwordEncoder.encode(password);
        AppUser user = new AppUser(username,encodedPassword);
        appUserService.updateUser(user);

    }
    @PutMapping("/admin/delete/user/userId/{userId}")
    public void deleteUser(@PathVariable("userId") int userId){

        appUserService.deleteUser(userId);

    }

}
