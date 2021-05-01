package com.java.hotelmanager.menu;

import com.java.hotelmanager.Controller;
import com.java.hotelmanager.hotel.Hotel;
import com.java.hotelmanager.ressources.Statics;
import com.java.hotelmanager.user.Role;
import com.java.hotelmanager.user.User;

/**
 * Basic user menu. Handles everything around the user.
 */
public class UserMenu implements Menu{
    private static MenuFactory factory;

    /**
     * Determines what menu you get (as a customer you get a customer menu)
     */
    @Override
    public void run() {
    if(Controller.getUser() == null){
        new_user();
    } else if (Controller.getUser().getRole().equals(Role.CUSTOMER)){
        customer_menu();
    }
    }

    /**
     * Is the basic customer menu
     */
    public void customer_menu(){
        boolean exit = false;
        do{
            System.out.println(Statics.whatwouldulike);
            System.out.println("1] Hotel \n2] Rooms\n3] Book\n4] Logout");
            String input = Statics.getInput();
            switch(input){
                case "1":
                    Menu h = factory.getMenu(MenuType.Hotel);
                    h.run();
                    break;
                case "2":
                    Menu r = factory.getMenu(MenuType.Room);
                    r.run();
                    break;
                case "3":
                    Menu b = factory.getMenu(MenuType.Booking);
                    b.run();
                    break;
                case "4":
                    Controller.setUser(null);
                    exit = true;
                    break;
                default:
                    System.out.println(Statics.inputweird);
            }
        }while(!exit);
    }

    public void staff_menu(){

    }

    public void owner_menu(){

    }

    /**
     * Allows new user to register and allows the owner to create new accounts to his wish
     */
    public void new_user(){
            System.out.println("- Please enter a username");
            String username = Statics.getInput();
            if(Hotel.checkUsername(username)){
                System.out.println("- Please enter a password");
                String password = Statics.getInput();
                System.out.println("- Please enter your email address");
                String email = Statics.getInput();
                Role role = Role.CUSTOMER;
                if(Controller.getUser() != null && Controller.getUser().getRole() == Role.OWNER){
                    System.out.println("- Please choose a role \n1] Customer \n2] Staff \n3] Owner");
                    String input = Statics.getInput();
                    switch (input){
                        case "1":
                            role = Role.CUSTOMER;
                            break;
                        case "2":
                            role = Role.STAFF;
                            break;
                        case "3":
                            role = Role.OWNER;
                            break;
                            default:
                                role = Role.CUSTOMER;
                    }
                }
                User u = new User(username, password, email, role);
                Hotel.addUser(u);
            }else{
                System.out.println("[ Username already taken ]");
            }
    }
}
