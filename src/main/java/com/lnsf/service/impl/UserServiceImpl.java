package com.lnsf.service.impl;

import com.lnsf.bean.UserMapper;
import com.lnsf.dao.UserDao;
import com.lnsf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
        private UserDao userDao;
        public UserMapper getUserById(Integer uid) {
            return userDao.getUserById(uid);
        }
        public UserMapper getByUsernameAndPwd(UserMapper user){
            return userDao.getByUsernameAndPwd(user);
        }

    @Override
    public UserMapper getByUsername(UserMapper user) {
        return userDao.getByUsername(user);
    }
    /*根据用户名模糊查找用户*/
    public List<UserMapper> getLikeUsername(UserMapper user){
        return userDao.getLikeUsername(user);
    }

    public List<UserMapper> getByUserList(){
        return userDao.getByUserList();
        }

    public boolean deleteUser(Integer uid){
            return userDao.deleteUser(uid);
    }
    //@Async
    public boolean addUser(UserMapper user) {
        //System.out.println("异步启用3");
        return userDao.addUser(user);
    }
    public int countUser(){
            return userDao.countUser();
    }
    /**
     * @Description //验证账号是否存在
     **/
    public Boolean stuIsExist(UserMapper username) {
        UserMapper user = userDao.getByUsername(username);
        if (user!=null) {
            return true;
        } else {
            return false;
        }

    }
}
