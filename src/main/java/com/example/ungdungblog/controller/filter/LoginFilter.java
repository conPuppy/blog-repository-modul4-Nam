package com.example.ungdungblog.controller.filter;

import com.example.ungdungblog.model.Account;
import com.example.ungdungblog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter({"/blogs", "/create","/edit"})
public class LoginFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();
        Account account = (Account) httpSession.getAttribute("account");
        if (account == null) {
            res.sendRedirect("/login");
        } else chain.doFilter(req, res);
    }
}
