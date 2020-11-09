package com.rentalcar.dao;

import java.util.List;
import com.rentalcar.entity.User;
public interface UserDao {
    int saveUser(User User);
 
    void updateUser(User User);
 
    void deleteUser(int id);
 
    User findUserById(int id);
 
    List<User> findAllUsers();
}
