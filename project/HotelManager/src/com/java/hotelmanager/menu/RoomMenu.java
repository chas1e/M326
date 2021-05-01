package com.java.hotelmanager.menu;

import com.java.hotelmanager.Controller;
import com.java.hotelmanager.hotel.Hotel;
import com.java.hotelmanager.ressources.Statics;
import com.java.hotelmanager.room.Room;
import com.java.hotelmanager.user.Role;

/**
 * Allows user to interact with rooms
 */
public class RoomMenu implements Menu {
    @Override
    public void run() {
        if(Controller.getUser().getRole().equals(Role.CUSTOMER)){
            customer_menu();
        }
    }

    /**
     * Customer menu for rooms and room
     */
    private void customer_menu(){
        boolean exit = false;
        do{
            System.out.println(Statics.whatwouldulike);
            System.out.println("1] Show All Rooms\n2] Select Room\n3] Back");
            String input = Statics.getInput();
            switch (input){
                case "1":
                    Hotel.getRooms();
                    break;
                case "2":
                    select_room();
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    System.out.println(Statics.inputweird);
            }
        }while(!exit);
    }

    private void select_room(){
        Hotel.getRooms();
        System.out.println("- Please enter Room-Number");
        String number = Statics.getInput();
        if(get_by_number(number) != null){
            get_by_number(number).getDetailInfo();
        }
    }

    public static Room get_by_number(String number){
        for(int i = 0; i < Hotel.rooms.size(); i++){
            if(number.equals(Hotel.rooms.get(i).getRoomNumber())){
                return Hotel.rooms.get(i);
            }
        }
        return null;
    }
}
