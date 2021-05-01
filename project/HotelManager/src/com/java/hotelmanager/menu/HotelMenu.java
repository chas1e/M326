package com.java.hotelmanager.menu;

import com.java.hotelmanager.Controller;
import com.java.hotelmanager.hotel.Hotel;
import com.java.hotelmanager.ressources.Statics;
import com.java.hotelmanager.user.Role;

/**
 * Lets user manage hotel
 */
public class HotelMenu implements Menu{

    @Override
    public void run() {
        if (Controller.getUser().getRole().equals(Role.CUSTOMER)){
            customer_menu();
        }
    }

    /**
     * Customer menu for hotel
     */
    public void customer_menu(){
        boolean exit = false;
        do{
            System.out.println(Statics.whatwouldulike);
            System.out.println("1] Hotel Information\n2] Amenities in Hotel\n3] Back");
            String input = Statics.getInput();
            switch (input){
                case "1":
                    Hotel.getInfo();
                    break;
                case "2":
                    Hotel.getAmenities();
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    System.out.println(Statics.inputweird);
            }
        }while(!exit);
    }
}
