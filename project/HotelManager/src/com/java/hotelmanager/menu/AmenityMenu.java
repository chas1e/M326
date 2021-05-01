package com.java.hotelmanager.menu;

import com.java.hotelmanager.Controller;
import com.java.hotelmanager.amenties.Amenity;
import com.java.hotelmanager.hotel.Hotel;
import com.java.hotelmanager.ressources.Statics;
import com.java.hotelmanager.room.Room;
import com.java.hotelmanager.user.Role;

/**
 * Allows owners and staff to add amenities to rooms or to the hotel
 */
public class AmenityMenu implements Menu{

    /**
     * Basic Run method, here only a small menu for staff and owner as a demonstration.
     */
    @Override
    public void run() {
        boolean exit = false;
        do{
            if(Controller.getUser().getRole() == Role.OWNER || Controller.getUser().getRole() == Role.STAFF){
                System.out.println("[[ Adding Amenities ]]");
                System.out.println(Statics.whatwouldulike);
                System.out.println("1] Add amenity to hotel\n2] Add amenity to specific room\n3] Leave");
                String input = Statics.getInput();
                switch (input){
                    case "1":
                        toHotel();
                        break;
                    case "2":
                        toRoom();
                        break;
                    case "3":
                        exit = true;
                        break;
                    default:
                        System.out.println(Statics.inputweird);
                }
            }else{
                exit = true;
            }
        }while(!exit);
    }

    /**
     * Allows owner/staff to add amenities to a specific room
     */
    private void toRoom(){
        Hotel.getRooms();
        System.out.println("- Enter Room Number");
        String input = Statics.getInput();
        Room r = RoomMenu.get_by_number(input);
        if(r != null){
            System.out.println("- Enter amenity title: ");
            String title = Statics.getInput();
            System.out.println("- Enter amenity description: ");
            String description = Statics.getInput();
            Amenity m = new Amenity(title, description);
            r.addAmenity(m);
        }else{
            System.out.println("- Room couldn't be found");
        }

    }

    /**
     * Allows the owner/staff to add amenities to the hotel
     */
    private void toHotel(){
            System.out.println("- Enter amenity title: ");
            String title = Statics.getInput();
            System.out.println("- Enter amenity description: ");
            String description = Statics.getInput();
            Amenity m = new Amenity(title, description);
            Hotel.addAmenity(m);
    }

}
