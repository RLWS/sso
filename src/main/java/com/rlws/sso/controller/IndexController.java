package com.rlws.sso.controller;

import com.rlws.sso.commons.dto.BaseResult;
import com.rlws.sso.commons.utils.CookiesUtils;
import com.rlws.sso.commons.utils.RedisUtils;
import com.rlws.sso.commons.utils.TokenUtils;
import com.rlws.sso.entity.User;
import com.rlws.sso.servies.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 登录页面(跳转)
     * requestUrl 重定向的链接
     *
     * @return 返回首页
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index(String requestUrl, String condition, ModelAndView modelAndView) {
        System.out.println(requestUrl);
        modelAndView.setViewName("index");
        modelAndView.addObject("requestUrl", requestUrl);
        modelAndView.addObject("condition", condition);
        return modelAndView;
    }

    /**
     * 登录页面
     *
     * @return 返回首页
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, String requestUrl, String condition) {
        User reUser = userService.selectByEmail(user.getEmail(), user.getPassword());
        String token;
        if (reUser == null) {
            return "error";
        } else {
            token = TokenUtils.getToken();
            addUserDataToRedis(reUser, token);
        }
        if (StringUtils.isEmpty(condition)) {
            return "redirect:" + requestUrl + "?token=" + token;
        } else {
            String redirectURL = getRedirectURL(requestUrl, condition, token);
            return "redirect:" + redirectURL;
        }
    }

    /**
     * 将域名和条件重新拼接
     *
     * @param requestUrl 域名
     * @param condition  条件(以"xx=aa|yy=bb|")方式拼接
     * @return 返回完整的链接
     */
    private String getRedirectURL(String requestUrl, String condition, String token) {
        StringBuilder sb = new StringBuilder();
        String[] split = condition.split("\\|");
        for (String str : split) {
            String[] splitStr = str.split("=");
            if (splitStr.length == 2) {
                sb.append(splitStr[0]).append("=").append(splitStr[1]).append("&");
            }
        }
        if (requestUrl.endsWith("/")) {
            requestUrl = requestUrl.substring(0, requestUrl.length() - 1);
        }
        return requestUrl + "?" + sb;
    }

    /**
     * 登录信息存储
     *
     * @param user  将用户数据存入Redis
     * @param token 需要保存的token
     */
    private void addUserDataToRedis(User user, String token) {
        //存放用户ID+密码
        redisUtils.stringSet(user.getId() + "", user.getPassword(), 200);
        //存放用户ID_email+email
        redisUtils.stringSet(user.getId() + "_email", user.getEmail(), 200);
        //存放用户ID_token+token
        redisUtils.stringSet(user.getId() + "_token", token, 200);
    }
}
