package com.java.hotelmanager.booking;

import com.java.hotelmanager.room.Room;
import com.java.hotelmanager.user.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Booking. Allows users to book rooms for a certain timespan.
 */
public class Booking {
    private Date start;
    private Date end;
    private Room room;
    private User user;

    public Booking(Date start, Date end, Room room, User user) {
        this.start = start;
        this.end = end;
        this.room = room;
        this.user = user;
    }

    public Booking setStart(Date start) {
        this.start = start;
        return this;
    }

    public Booking setEnd(Date end) {
        this.end = end;
        return this;
    }

    public Room getRoom() {
        return room;
    }

    public Booking setRoom(Room room) {
        this.room = room;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Booking setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    /**
     * Calculates the price for the entire stay.
     * @return
     */
    public double calcPrice(){
        double priceANight = this.room.getPricePerNight();
        long diff = end.getTime() - start.getTime();
        System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        return priceANight * diff;
    }



}
