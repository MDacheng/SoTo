package com.mdc.web;

import com.mdc.domain.Background;
import com.mdc.domain.User;
import com.mdc.service.BackgroundService;

import com.mdc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by mengdacheng on 2017/1/13.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private BackgroundService backgroundService;

    @RequestMapping(value = "/index.html")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand, ModelMap modelMap){

        boolean isVaildUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        if(!isVaildUser) return new ModelAndView("login", "error", "用户名或密码错误");
        else{
            request.getSession().setAttribute("group", 1);

            List<Background> backgrounds = backgroundService.getBackground();
            User user = userService.findUserByName(loginCommand.getUserName());
            user.setLastIp(request.getRemoteAddr());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("keyword", "");
            modelMap.addAttribute("backgrounds", backgrounds);
        }
        return new ModelAndView("main");
    }
}
