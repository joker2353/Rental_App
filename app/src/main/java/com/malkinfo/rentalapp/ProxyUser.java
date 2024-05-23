package com.malkinfo.rentalapp;

public class ProxyUser {
   public static UserClass appUser;

   public ProxyUser() {
      // Private constructor to prevent instantiation
   }
   public static UserClass getAppUser(){
      return appUser;
   }
   public static void setAppUser(String name,String username,String email,String password){
            appUser.setName(name);
            appUser.setUsername(username);
            appUser.setEmail(email);
            appUser.setPassword(password);
   }
}
