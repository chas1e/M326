package com.java.hotelmanager;

import com.java.hotelmanager.menu.Menu;
import com.java.hotelmanager.menu.MenuFactory;
import com.java.hotelmanager.menu.MenuType;
import com.java.hotelmanager.ressources.Statics;
import com.java.hotelmanager.user.User;

/**
 * Controls everything, makes things look tidy.
 */
public class Controller {
    private static User loggedIn = null;

    public static void run(){
        System.out.println(Statics.message1 + Statics.message2);
        Menu m = MenuFactory.getMenu(MenuType.Start);
        m.run();
        System.out.println("Thank you!");
    }

    public static void setUser(User user){
        loggedIn = user;
    }
    public static User getUser(){
        return loggedIn;
    }


}
