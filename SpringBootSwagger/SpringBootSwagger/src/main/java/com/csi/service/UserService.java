package com.csi.service;

import com.csi.model.User;

import java.util.List;

public interface UserService {
    public void signUp(User user);
    public boolean signIn(String userId, String userPassword);
    public void saveBulOfData(List<User> users);
    public User getDataById(int userId);
    public User getDataByEmail(String userEmailId);
    public User getDataByContactNumber(long userContactNumber);
    public List<User> getAllData();
    public List<User> filterData(double userSalary);
    public void updateData(int userId, User user);
    public void deleteDataById(int userId);
    public void deleteAllData();
}
