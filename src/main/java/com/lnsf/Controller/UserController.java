package com.lnsf.Controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lnsf.bean.UserMapper;
import com.lnsf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Configuration
public class UserController {
    @Autowired
    private UserService userService;
    /*根据id查看用户*/
    @RequestMapping("getUserById")
    public String getUserById(Integer uid, Map<String,Object> map){
       UserMapper user = userService.getUserById(uid);
       map.put("user1",user);
        return "success";
    }

/*插件分页查看所有用户*/
@RequestMapping("userList")
public String getUserList(Map<String,Object> map,Integer page){
    if (page==null)
    {
        page=1;
    }
    PageHelper.startPage(page,5);
    List<UserMapper> list = userService.getByUserList();
    map=maps(list,map);
    map.put("userList","userList");
    return "userList";
}
public Map<String,Object> maps(List<UserMapper> list,Map<String,Object> map ){
    PageInfo<UserMapper> pageInfo = new PageInfo<UserMapper>(list);
    map.put("users",pageInfo.getList());
    map.put("totalPage",pageInfo.getPages());
    map.put("indexPage",pageInfo.getPageNum());
    return map;
}
private String name;
    /*模糊查看所有用户*/
    @RequestMapping("getLikeUsername")
    public String getLikeUsername(Map<String,Object> map,UserMapper user,Integer page){
        if (page==null)
        {
            page=1;
        }
        if (user.getUsername()==null){
            user.setUsername(name);
        }else {
            name=user.getUsername();
        }
        PageHelper.startPage(page,5);
        List<UserMapper> list = userService.getLikeUsername(user);
        map=maps(list,map);
        map.put("userList","getLikeUsername");
        return "userList";
    }
    /*添加用户*/
    @RequestMapping("addUser")
    public String addUser(UserMapper user ,Map<String,Object> map){
            user.setPower(1);
            System.out.println("异步启用2");
            boolean falg = userService.addUser(user);
            return "redirect:/userList";
    }
    /*删除当个用户*/
    @RequestMapping("deleteUser")
    public String deleteUser(Integer uid,Map<String,Object> map){
        boolean falg = userService.deleteUser(uid);
        return "redirect:/userList";
    }
    /*删除当个用户*/
    @RequestMapping("deleteUsers")
    public String deleteUsers(String checkedID,Map<String,Object> map){
       String[] strs=checkedID.split(",");
        for (String str:strs) {
            boolean falg = userService.deleteUser(Integer.parseInt(str));
        }
        return "redirect:/userList";
    }
    /*更新跳转更新页面*/
    @RequestMapping("updateUser")
    public String updateUser(Integer uid,Map<String,Object> map){
        System.out.println("用户更新"+uid);
        UserMapper user1 = userService.getUserById(uid);
        map.put("user",user1);
      return "pass";
    }
    @ResponseBody
    @RequestMapping("stu-exist")
    public String stuIsExist(String username){

        UserMapper userMapper = new UserMapper();
        userMapper.setUsername(username);
        Boolean stuIsExist = userService.stuIsExist(userMapper);
        System.out.println(stuIsExist);
        if (stuIsExist==true){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * @Description //验证账号是否存在
     **/
    /*@PostMapping("stu-exist")*/
    /*@ResponseBody
    @RequestMapping("stu-exist")
    public Map<String,Boolean> stuIsExist(String username){
        System.out.println("jingrucontroerllluufhuygfysgdgo");
        UserMapper userMapper = new UserMapper();
        userMapper.setUsername(username);
        Boolean stuIsExist = userService.stuIsExist(userMapper);
        Map<String,Boolean> map = new HashMap<String,Boolean>();
        if (stuIsExist){
            map.put("valid",true);
        }else {
            map.put("valid",false);
        }
        System.out.println(username+map);
        return map;
    }*/

}
