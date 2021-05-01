package com.java.hotelmanager.menu;

import com.java.hotelmanager.Controller;
import com.java.hotelmanager.booking.Booking;
import com.java.hotelmanager.hotel.Hotel;
import com.java.hotelmanager.ressources.Statics;
import com.java.hotelmanager.room.Room;
import com.java.hotelmanager.user.Role;

import java.awt.print.Book;
import java.util.Date;

/**
 * Allows the user to handle bookings
 */
public class BookingMenu implements Menu {
    @Override
    public void run() {
    if (Controller.getUser().getRole().equals(Role.CUSTOMER)){
        customer_menu();
    }
    }

    /**
     * Customer menu for booking
     */
    private void customer_menu(){
        boolean exit = false;
        do{
            System.out.println(Statics.whatwouldulike);
            System.out.println("1] Book a room\n2] Back");
            String input = Statics.getInput();
            switch (input){
                case "1":
                    book_room();
                    break;
                case "2":
                    exit = true;
                    break;
                default:
                    System.out.println(Statics.inputweird);
            }
        }while(!exit);
    }

    /**
     * Books room for customer
     */
    private void book_room(){
        Hotel.getRooms();
        System.out.println("- Select a room by room number");
        Room r = RoomMenu.get_by_number(Statics.getInput());
        if(r != null){
            try {
                System.out.println("Enter start date");
                Date start = new Date(Statics.getInput());
                System.out.println("Enter end date");
                Date end = new Date(Statics.getInput());
                Booking b = new Booking(start, end, r, Controller.getUser());
                System.out.println("That will cost you: " + b.calcPrice());
            }catch (RuntimeException e){
                System.out.println("Please enter date differently");
            }
        }else{
            System.out.println("- Room wasn't found");
        }
    }
}
