package com.fifteenth.project.springaop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount() {
    
        // just a placeholder for add account functionality using JPA/Hibernate.
        System.out.println(getClass()+" doing my DB work to add new account\n");

    }

}
