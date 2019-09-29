package com.lnsf.service;

import com.lnsf.bean.UserMapper;

import java.util.List;


public interface UserService {
        /*根据id查找用户*/
        public UserMapper getUserById(Integer uid);
        /*登录验证用户名和密码*/
        public UserMapper getByUsernameAndPwd(UserMapper user);
        /*根据用户名查找用户*/
        public UserMapper getByUsername(UserMapper user);
        /*根据用户名模糊查找用户*/
        public List<UserMapper> getLikeUsername(UserMapper user);
        /*统计用户数*/
        public int countUser();
        /*获取所有用户*/
        public List<UserMapper> getByUserList();
        /*添加用户*/
        public boolean addUser(UserMapper user);
        /*删除用户*/
        public boolean deleteUser(Integer uid);
        /*验证用户名是否存在*/
        Boolean stuIsExist(UserMapper username);

}
