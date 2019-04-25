package com.rlws.sso.controller;

import com.rlws.sso.commons.dto.BaseResult;
import com.rlws.sso.entity.User;
import com.rlws.sso.servies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = {"","index"},method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult login(User user){
        User reUser = userService.selectByEmail(user.getEmail(),user.getPassword());
        if (reUser == null){
            return BaseResult.fail("账号密码匹配失败!");
        }
        return BaseResult.success("账号密码匹配成功!",reUser);
    }
}
