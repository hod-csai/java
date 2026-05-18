package com.example;

public class UserBean {
    private String name;
    
    public UserBean() {} 
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public static void main(String[] args) {
        UserBean user = new UserBean();
        user.setName("Test User");
        System.out.println("Hello, " + user.getName() + "!");
    }
}
