package com.java.hotelmanager.room;

import com.java.hotelmanager.amenties.Amenity;
import com.java.hotelmanager.booking.Booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Room in hotel application
 */
public class Room {
    private int roomNumber;
    private double pricePerNight;
    private String description;
    private ArrayList<Booking> bookings;
    private ArrayList<Amenity> amenities;

    /**
     * Adds booking to room, checks if dates overlap
     * @param booking
     * @return
     */
    public boolean addBooking(Booking booking){
        for(int i = 0; i < bookings.size(); i++){
            if (isOverlapping(bookings.get(i).getStart(), bookings.get(i).getEnd(),
            booking.getStart(), booking.getEnd())){
               return false;
            }
        }
        bookings.add(booking);
        return true;
    }

    public void addAmenity(Amenity amenity){
        this.amenities.add(amenity);
    }
    public static boolean isOverlapping(Date start1, Date end1, Date start2, Date end2) {
        return start1.before(end2) && start2.before(end1);
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public Room setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
        return this;
    }

    public String getInfo(){
        return "[" + getRoomNumber() + "] Price/Night: " + getPricePerNight();
    }
    public String getDetailInfo(){ return "[" + getRoomNumber() + "] Price/Night: " + getPricePerNight()
            +"\n"+ getDescription() + "\n" + amenities; }

    public int getRoomNumber() {
        return roomNumber;
    }
    public void getAmenities() {
        for(int i = 0; i < amenities.size(); i++){
            System.out.println((i + 1) + "] " + amenities.get(i).getDetailInfo());
        }
    }

    public Room setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Room setDescription(String description) {
        this.description = description;
        return this;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public Room setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
        return this;
    }

    public Room setAmenity(ArrayList<Amenity> amenity) {
        this.amenities = amenity;
        return this;
    }
}
