package com.carapp.service;

import com.carapp.model.AppUser;
import com.carapp.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AppUserServiceImpl implements UserDetailsService,IAppUserService {

    private IAppUserRepository appUserRepository;

    @Autowired
    public void setAppUserRepository(IAppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }


    @Override
    public void addUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public void updateUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public void deleteUser(int userId) {
        appUserRepository.deleteById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // get the user from the database
        AppUser appUser = appUserRepository.findByUsername(username);
        if(appUser == null)
            throw new UsernameNotFoundException("Invalid username");
        String nusername = appUser.getUsername();
        String password = appUser.getPassword();
        // Set Roles for the user
        GrantedAuthority authority1 = new SimpleGrantedAuthority("USER");
        GrantedAuthority authority2 = new SimpleGrantedAuthority("ADMIN");
        // create a new user object using UserDetails interface
        UserDetails user = new User(nusername,password, Arrays.asList(authority1,authority2));
        return user;
    }
}
