package com.java.hotelmanager.amenties;

/**
 * Amenity, for example "Bed" or "32-inch TV" or "Pool". Can be added to Hotel itself or rooms.
 */
public class Amenity {
    private String name;
    private String description;

    public Amenity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Amenity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Amenity setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Returns both title and description for an amenity
     * @return Title and description
     */
    public String getDetailInfo(){
        return (getName()+": \n" + "\t" + getDescription());
    }
}
