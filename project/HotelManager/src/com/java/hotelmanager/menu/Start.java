package com.java.hotelmanager.menu;

import com.java.hotelmanager.Controller;
import com.java.hotelmanager.ressources.Statics;

/**
 * Starting point in our application, first menu
 */
public class Start implements Menu{

    /**
     * Lets existing users log-in and new users can register.
     */
    @Override
    public void run() {
        boolean exit = false;
        do{
            System.out.println(Statics.whatwouldulike);
            System.out.println(" 1] Log-In \n 2] Register \n 3] Leave");
            switch (Statics.getInput()){
                case "1":
                    Menu login = MenuFactory.getMenu(MenuType.LogIn);
                    login.run();
                    if(Controller.getUser() != null){
                        System.out.println("Success");
                        Menu usermenu = MenuFactory.getMenu(MenuType.User);
                        usermenu.run();
                    }else{
                        System.out.println("Something went wrong :/");
                    }
                    break;
                case "2":
                    Menu register = MenuFactory.getMenu(MenuType.User);
                    register.run();
                    break;
                case "3":
                    exit = true;;
                    break;
                default:
                    System.out.println(Statics.inputweird);
            }
        }while(!exit);
    }
}
