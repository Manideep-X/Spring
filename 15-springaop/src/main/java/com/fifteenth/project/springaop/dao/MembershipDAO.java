package com.fifteenth.project.springaop.dao;

public interface MembershipDAO {

    void addAccount();

    int addProfile();

    boolean isActive();

    // getters and setters
    public String getMemberName();
    public void setMemberName(String memberName);
    public int getMemberId();
    public void setMemberId(int memberId);

}
