package com.java.hotelmanager.menu;

/**
 * Allows us to specify what kind of menu we want. Personal preference for factory pattern, I like it more than
 * getMenu("amenity-menu");
 */
public enum MenuType {
    Amenity,
    Booking,
    Hotel,
    Room,
    User,
    LogIn,
    Start,
}
