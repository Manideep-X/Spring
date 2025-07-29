package com.fifteenth.project.springaop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fifteenth.project.springaop.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount() {
    
        // just a placeholder for add account functionality using JPA/Hibernate.
        System.out.println(getClass()+" doing my DB work to add new account\n");
        
    }
    
    @Override
    public void addAccount(Account account) {

        // just a placeholder for add account functionality using JPA/Hibernate with object as a parameter.
        System.out.println(getClass()+": New account :"+account.toString()+"\n");
        
    }
    
    @Override
    public void addAccount(Account account, String theLevel) {

        // just a placeholder for add account functionality using JPA/Hibernate with object as a parameter.
        account.setName("John");
        account.setLevel(theLevel);
        System.out.println(getClass()+": New account :"+account.toString()+"\n");
        
    }

    @Override
    public String status(String upStatus) {
        
        // Placeholder for account status
        upStatus = "Active";
        System.out.println(getClass()+" doing my DB work with a/c status as ["+upStatus+"]\n");
        return upStatus;

    }

    @Override
    public List<Account> findAccounts() {
        
        return findAccounts(false);

    }

    @Override
    public List<Account> findAccounts(boolean isException) throws RuntimeException {

        if (isException) {
            throw new RuntimeException("Exception occured while retriving Accounts!");
        }
        
        List<Account> list = new ArrayList<>();

        // Add some dummy data to the list and return it.
        list.add(new Account());
        list.add(new Account("Mathew","Employee"));
        list.add(new Account("David","Manager"));
        list.add(new Account("Susan","Admin"));

        return list;
        
    }

}
