package com.rlws.sso.controller;

import com.rlws.sso.commons.dto.BaseResult;
import com.rlws.sso.commons.utils.CookiesUtils;
import com.rlws.sso.entity.User;
import com.rlws.sso.servies.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;


    /**
     * 登录页面(跳转)
     * requestUrl 重定向的链接
     * @return
     */
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public ModelAndView index(String requestUrl, ModelAndView modelAndView){
        System.out.println(requestUrl);
        modelAndView.setViewName("index");
        modelAndView.addObject("requestUrl",requestUrl);
        return modelAndView;
    }
    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(User user,String requestUrl){
        User reUser = userService.selectByEmail(user.getEmail(),user.getPassword());
        System.out.println(requestUrl);
        if (reUser == null){
            return "失败!";
        }
        return "redirect:"+requestUrl;
    }
}
