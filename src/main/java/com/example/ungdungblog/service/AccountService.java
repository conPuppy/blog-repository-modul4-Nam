package com.example.ungdungblog.service;

import com.example.ungdungblog.model.Account;
import com.example.ungdungblog.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    IAccountRepo iAccountRepo;
    public Account checkLogin(String username, String password) {
        return iAccountRepo.checkLogin(username, password);
    }
    public Account checkAccount(String username) {
        return iAccountRepo.checkAccount(username);
    }
    public void save(Account account) {
        iAccountRepo.save(account);
    }
}
