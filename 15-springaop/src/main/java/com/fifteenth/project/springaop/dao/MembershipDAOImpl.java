package com.fifteenth.project.springaop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    private String memberName;
    private int memberId;

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

    @Override
    public boolean isActive() {
        
        // Placeholder for Membership activation status
        boolean isActive = true;
        System.out.println(getClass()+" doing my DB work and Membership status is ["+isActive+"]\n");
        return isActive;

    }

    // Getters and Setters
    @Override
    public String getMemberName() {
        System.out.println(getClass()+" it is a getter method for Member name\n");
        return memberName;
    }
    @Override
    public void setMemberName(String memberName) {
        System.out.println(getClass()+" it is a setter method for Member name\n");
        this.memberName = memberName;
    }
    @Override
    public int getMemberId() {
        System.out.println(getClass()+" it is a getter method for Member ID\n");
        return memberId;
    }
    @Override
    public void setMemberId(int memberId) {
        System.out.println(getClass()+" it is a setter method for Member ID\n");
        this.memberId = memberId;
    }
    

}
