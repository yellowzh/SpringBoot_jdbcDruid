package com.lnsf.Controller;

import com.lnsf.bean.UserMapper;
import com.lnsf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    /*第二种自定义起页*/
    /*@RequestMapping(value = {"/","/index","/index.html"})
    public String fristpage(){
        return "index";
    }*/
    @RequestMapping("login")
    public String getByUsernameAndPwd(String username,String password, Map<String,Object> map){
        if(username==null||username.equals("")){
            map.put("msg","用户名不能为空");
            return "index";
        }else {
            UserMapper userMapper = new UserMapper();
            userMapper.setUsername(username);
            userMapper.setPassword(password);
            try {
                userMapper = userService.getByUsernameAndPwd(userMapper);
            }catch (Exception e){
                map.put("msg","系统繁忙");
                return "index";
            }
            if (userMapper==null){
                map.put("msg","用户名或者密码错误");
                return "index";
            }
            else {
                map.put("user",userMapper);
                return "aindex";
            }
        }
    }
}
