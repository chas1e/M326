package com.java.hotelmanager.hotel;

import com.java.hotelmanager.amenties.Amenity;
import com.java.hotelmanager.ressources.Statics;
import com.java.hotelmanager.room.Room;
import com.java.hotelmanager.user.User;

import java.util.ArrayList;

/**
 * Hardcoded Hotel. Has infos and contains all the users, rooms, amenities, and other useful stuff.
 */
public class Hotel {
   public static ArrayList<User> users = new ArrayList<User>();
   public static ArrayList<Room> rooms = new ArrayList<Room>();
   public static ArrayList<Amenity> amenities = new ArrayList<Amenity>();
   public static String description = Statics.hotel_description;
   public static String stars = Statics.stars;

   /**
    * Adds user to users if username isn't taken
    * @param u
    */
   public static void addUser(User u){
      if(checkUsername(u.getUsername())){
         users.add(u);
      }else{
         System.out.println("Username already taken");
      }
   }

   /**
    * Checks if username is taken
    * @param username
    * @return
    */
   public static boolean checkUsername(String username) {
   for(int i = 0; i < users.size(); i++){
      if(users.get(i).getUsername().equals(username)){
         return false;
      }
   }
   return true;
   }

   /**
    * Gets all users in a list
    */
   public static void getUsers(){
      for(int i = 0; i < users.size(); i++){
         System.out.println((i + 1) + "] " + users.get(i).getInfo());
      }
   }

   /**
    * Gets all rooms in a list
    */
   public static void getRooms(){
      for(int i = 0; i < rooms.size(); i++){
         System.out.println((i + 1) + "] " + rooms.get(i).getInfo());
      }
   }

   /**
    * Gets hotel info and describes the hotel.
    */
   public static void getInfo(){
      System.out.println(getDescription() + "\n Currently has: " + getStars());
   }

   public static void setUsers(ArrayList<User> users) {
      Hotel.users = users;
   }

   public static void setRooms(ArrayList<Room> rooms) {
      Hotel.rooms = rooms;
   }

   /**
    * gets all the amenities in the hotel.
    */
   public static void getAmenities() {
      for(int i = 0; i < amenities.size(); i++){
         System.out.println((i + 1) + "] " + amenities.get(i).getDetailInfo());
      }
   }

   public static void setAmenities(ArrayList<Amenity> amenities) {
      Hotel.amenities = amenities;
   }

   public static String getDescription() {
      return description;
   }

   public static void setDescription(String description) {
      Hotel.description = description;
   }

   public static String getStars() {
      return stars;
   }

   public static void setStars(String stars) {
      Hotel.stars = stars;
   }

   public static void addAmenity(Amenity a){
      amenities.add(a);
   }
}
