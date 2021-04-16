package com.csw.controller;

import com.csw.entity.User;
import com.csw.service.UserService;
import com.csw.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by HIAPAD on 2019/10/30.
 */
@Controller
@RequestMapping("u")
public class UserController {
    @Autowired
    private UserService userService;

    /* user.setSalt(MD5Utils.getSalt());
         user.setPassword(MD5Utils.getPassword(user.getPassword()
                 + user.getSalt()));*/
    @RequestMapping("regist")
    public String regist(User user, String captchaCode, HttpServletRequest request) {
        System.out.println("user//:" + user);
        String salt = MD5Utils.getSalt();
        user.setSalt(salt);
        user.setPassword(MD5Utils.getPassword(user.getPassword() + salt));
        /**
         *
         */
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("securityCode");
        User user2 = userService.queryUsername(user.getUsername());
        if (user2 == null && code.equalsIgnoreCase(captchaCode)) {
            System.out.println("user//:" + user);
            userService.regist(user);
            return "redirect:/user/login.jsp";
        } else {
            return "redirect:/user/regist.jsp?erroMsg=regist error,please try again!!!";
        }
    }

    @RequestMapping("login")
    public String login(User user, HttpServletRequest request) throws UnsupportedEncodingException {
        System.out.println("*******************");
        HttpSession session = request.getSession();
        User user2 = userService.queryUsername(user.getUsername());
        if (user2 != null && user2.getPassword().equals(MD5Utils.getPassword(user.getPassword() + user2.getSalt()))) {
            session.setAttribute("user", user2);
            System.out.println("next");
            return "redirect:/d/showAll";
        } else {
            System.out.println("ftjy vjy ");
            return "redirect:/user/login.jsp?erroMsg=" + URLEncoder.encode("drth6ryj", "UTF-8");
        }
    }

}
