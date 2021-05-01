package com.java.hotelmanager.menu;

import com.java.hotelmanager.ressources.MenuNotFoundException;

/**
 * Menu factory, allows us to efficiently create menus
 */
public class MenuFactory {
    public static Menu getMenu(MenuType type){
        switch(type){
            case User: return new UserMenu();
            case Room: return new RoomMenu();
            case Hotel: return new HotelMenu();
            case Amenity: return new AmenityMenu();
            case Booking: return new BookingMenu();
            case Start: return new Start();
            case LogIn: return new LogIn();
            default: throw new MenuNotFoundException();
        }
    }

}
