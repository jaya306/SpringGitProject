package com.csi.service;

import com.csi.dao.UserDao;
import com.csi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDaoImpl;
    @Override
    public void signUp(User user) {
        userDaoImpl.signUp(user);
    }

    @Override
    public boolean signIn(String userId, String userPassword) {
        return userDaoImpl.signIn(userId,userPassword);
    }

    @Override
    public void saveBulOfData(List<User> users) {
        userDaoImpl.saveBulOfData(users);
    }

    @Override
    public User getDataById(int userId) {
        return userDaoImpl.getDataById(userId);
    }

    @Override
    public User getDataByEmail(String userEmailId) {
        return userDaoImpl.getDataByEmail(userEmailId);
    }

    @Override
    public User getDataByContactNumber(long userContactNumber) {
        return userDaoImpl.getDataByContactNumber(userContactNumber);
    }

    @Override
    public List<User> getAllData() {
        return userDaoImpl.getAllData();
    }

    @Override
    public List<User> filterData(double userSalary) {
        return userDaoImpl.filterData(userSalary);
    }

    @Override
    public void updateData(int userId, User user) {
        userDaoImpl.updateData(userId,user);
    }

    @Override
    public void deleteDataById(int userId) {
        userDaoImpl.deleteDataById(userId);
    }

    @Override
    public void deleteAllData() {
        userDaoImpl.deleteAllData();
    }
}
