package com.java.hotelmanager.user;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class User {
    private String username;
    private byte[] password;
    private String email;
    private Role role;

    public User(String username, String password, String email, Role role) {
        this.username = username;
        this.setPassword(password);
        this.email = email;
        this.role = role;
    }
    public void setPassword(String input){
        this.password = encrypt(input);
    }

    /**
     * Compares given password with user password
     * @param input
     * @return
     */
    public boolean comparePassword(String input){
        if(Arrays.equals(this.getPassword(), encrypt(input))){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Encrypts strings with sha-256
     * @param input
     * @return
     */
    private byte[] encrypt(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return hash;
        } catch(NoSuchAlgorithmException e){
            System.out.println("[[Sha-256 instance failed, please try again later]]");
        }
        return null;
    }

    public byte[] getPassword() {
        return password;
    }

    public String getUsername(){
        return this.username;
    }

    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }

    public String getInfo(){
        return "[ " + getUsername() + " ] is part of group " + getRole().toString().toLowerCase();
    }
}


