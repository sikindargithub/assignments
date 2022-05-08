package com.carapp.service;

import com.carapp.model.AppUser;

public interface IAppUserService {

    void addUser(AppUser user);
    void updateUser(AppUser user);
    void deleteUser(int userId);
}
