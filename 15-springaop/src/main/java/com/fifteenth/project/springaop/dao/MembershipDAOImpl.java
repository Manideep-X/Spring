package com.fifteenth.project.springaop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addAccount() {
    
        // just a placeholder for add account functionality using JPA/Hibernate.
        System.out.println(getClass()+" doing my DB work to add new Membership\n");
        
    }
    
    @Override
    public int addProfile() {

        // just a placeholder for add Membership Profile using JPA/Hibernate.
        System.out.println(getClass()+" doing my DB work to add new Membership Profile\n");

        return getClass().toString().length();
        
    }

}
