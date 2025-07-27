package com.fifteenth.project.springaop.dao;

import com.fifteenth.project.springaop.model.Account;

public interface AccountDAO {

    void addAccount();

    void addAccount(Account account);
    
    void addAccount(Account account, String theLevel);

    String status(String upStatus);

}
