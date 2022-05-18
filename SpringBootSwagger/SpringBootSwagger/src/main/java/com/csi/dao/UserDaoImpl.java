package com.csi.dao;

import com.csi.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDaoImpl implements UserDao{

    static SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public void signUp(User user) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(user);
        transaction.commit();

    }

    @Override
    public boolean signIn(String userEmailId, String userPassword) {
boolean flag=false;
        Session session=sessionFactory.openSession();
        List<User> users=session.createQuery("from User").list();
      for(User user:users){
          if(user.getUserEmailId().equals(userEmailId) && user.getUserPassword().equals(userPassword)){
              flag=true;
          }
      }
        return flag;
    }

    @Override
    public void saveBulOfData(List<User> users) {
        Session session=sessionFactory.openSession();
        for (User user:users){
            Transaction transaction=session.beginTransaction();
            session.save(user);
            transaction.commit();
        }

    }

    @Override
    public User getDataById(int userId) {
        Session session=sessionFactory.openSession();
        User user= (User) session.get(User.class,userId);
        return user;
    }

    @Override
    public User getDataByEmail(String userEmailId) {
        Session session=sessionFactory.openSession();
        User usernew=new User();
        List<User> users=session.createQuery("from User").list();
for (User user:users){
    if(user.getUserEmailId().equals(userEmailId)){
        usernew.setUserName(user.getUserName());
        usernew.setUserDOB(user.getUserDOB());
        usernew.setUserEmailId(user.getUserEmailId());
        usernew.setUserSalary(user.getUserSalary());
        usernew.setUserPassword(user.getUserPassword());
        usernew.setUserContactNo(user.getUserContactNo());
    }
}
        return usernew;
    }

    @Override
    public User getDataByContactNumber(long userContactNumber) {
        Session session=sessionFactory.openSession();
        List<User> users=session.createQuery("from User").list();
        return null;
    }

    @Override
    public List<User> getAllData() {
        Session session=sessionFactory.openSession();
        List<User> users=session.createQuery("from User").list();
        return users;
    }

    @Override
    public List<User> filterData(double userSalary) {
        Session session=sessionFactory.openSession();
        List<User> users=session.createQuery("from User").list();

        return users.stream().filter(use->use.getUserSalary()>=userSalary).collect(Collectors.toList());
    }

    @Override
    public void updateData(int userId, User user) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        User usernew= (User) session.get(User.class,userId);
        usernew.setUserName(user.getUserName());
        usernew.setUserDOB(user.getUserDOB());
        usernew.setUserEmailId(user.getUserEmailId());
        usernew.setUserSalary(user.getUserSalary());
        usernew.setUserPassword(user.getUserPassword());
        usernew.setUserContactNo(user.getUserContactNo());
        session.update(usernew);
        transaction.commit();
    }

    @Override
    public void deleteDataById(int userId) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        User user= (User) session.get(User.class,userId);
        session.delete(user);
        transaction.commit();
    }

    @Override
    public void deleteAllData() {
        Session session=sessionFactory.openSession();
        List<User> users=session.createQuery("from User").list();
for (User user:users){
    Transaction transaction=session.beginTransaction();
    session.delete(user);
    transaction.commit();
}
    }
}
