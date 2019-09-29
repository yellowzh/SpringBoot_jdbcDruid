package com.lnsf.dao;

import com.lnsf.bean.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    /*根据id查询用户*/
    public UserMapper getUserById(Integer uid);
    /*登录查看用户名*/
    public UserMapper getByUsernameAndPwd(UserMapper user);
    /*根据用户名查找用户*/
    public UserMapper getByUsername(UserMapper user);
    /*根据用户名模糊查找用户*/
    public List<UserMapper> getLikeUsername(UserMapper user);
    /*统计用户*/
    public int countUser();
    /*查询所有用户*/
    public List<UserMapper> getByUserList();
    /*添加用户*/
    public boolean addUser(UserMapper user);
    /*根据id删除用户*/
    public boolean deleteUser(Integer uid);

}
