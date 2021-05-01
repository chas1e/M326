package com.java.hotelmanager.menu;

import com.java.hotelmanager.Controller;
import com.java.hotelmanager.hotel.Hotel;
import com.java.hotelmanager.ressources.Statics;
import com.java.hotelmanager.user.User;

import javax.naming.ldap.Control;
import java.util.Arrays;

public class LogIn implements Menu {

    /**
     * Basic login logic.
     */
    @Override
    public void run() {
        System.out.println("Please enter username: ");
        String username = Statics.getInput();
        System.out.println("Please enter password: ");
        String password = Statics.getInput();
        Controller.setUser(logIn(username, password));

    }

    private User logIn(String u, String p) {
        for (int i = 0; i < Hotel.users.size(); i++) {
            if (Hotel.users.get(i).getUsername().equals(u)) {
                if (Hotel.users.get(i).comparePassword(p)) {
                    return Hotel.users.get(i);
                } else {
                    System.out.println("Something went wrong :/");
                }
            }
        }
        return null;
    }
}
