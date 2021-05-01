package com.java.hotelmanager.ressources;

public class MenuNotFoundException extends RuntimeException{
    /**
     * If we try to create a weird menu, this error should never happen with factory pattern
     */
    public MenuNotFoundException() {
        super("ERROR: MENU WAS NOT FOUND ");
    }
}
