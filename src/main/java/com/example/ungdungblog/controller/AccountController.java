package com.example.ungdungblog.controller;

import com.example.ungdungblog.model.Account;
import com.example.ungdungblog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    HttpSession httpSession;
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Account account = accountService.checkLogin(username, password);
        ModelAndView modelAndView;
        if(account!=null) {
            modelAndView = new ModelAndView("redirect:/blogs");
            httpSession.setAttribute("account",account);
        } else {
            modelAndView = new ModelAndView("redirect:/login");
        }
        return modelAndView;
    }
    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }
    @PostMapping("/register")
    public ModelAndView register(Account account, @RequestParam("username") String username, @RequestParam MultipartFile upAvatar) {
        Account oldAccount = accountService.checkAccount(username);
        String nameFile = upAvatar.getOriginalFilename();
        try {
            FileCopyUtils.copy(upAvatar.getBytes(),new File("/Users/taphuonglinh/Desktop/ungdungblog/src/main/webapp/WEB-INF/avatar"+nameFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView;
        if(oldAccount==null) {
            modelAndView = new ModelAndView("redirect:/login");
            account.setAvatar("/avatar/"+nameFile);
            accountService.save(account);
        } else {
            modelAndView = new ModelAndView("redirect:/register");
        }
        return modelAndView;
    }
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
