package com.java.hotelmanager.ressources;

import java.util.Scanner;

/**
 * Constants and statics of hotel manager software
 */
public class Statics {
    public final static String message1 = "  _    _       _       _                                             \n" +
            " | |  | |     | |     | |                                            \n" +
            " | |__| | ___ | |_ ___| |_ __ ___   __ _ _ __   __ _  __ _  ___ _ __ \n" +
            " |  __  |/ _ \\| __/ _ \\ | '_ ` _ \\ / _` | '_ \\ / _` |/ _` |/ _ \\ '__|\n" +
            " | |  | | (_) | ||  __/ | | | | | | (_| | | | | (_| | (_| |  __/ |   \n" +
            " |_|  |_|\\___/ \\__\\___|_|_| |_| |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_|   \n" +
            "                                                      __/ |          \n" +
            "                                                     |___/           ";

    public final static String message2 = "\n*Welcome to the HotelManager software developed by davidrue@.* \n*This is his final project for module326 which was taught by Mr. Kaeser.*\n*This application allows the user to see the interactions of owners, staff or customers with an hotel. *";
    public final static String whatwouldulike = "[ What would you like to do ]?";
    public final static String inputweird = "[ Try again please :) ]";
    public final static String hotel_description = " ** Hotel Belvoir **\n In Hotel Belvoir you feel right at home, with it's family style food and classic amenities\n you feel like you have been living here for years. It offers a perfect family get-away!\n";
    public final static String stars = "4.5 Stars\n";
    public static String getInput(){
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        scan = null;
        return text;
    }
}


