package com.driver;

public class PGDetailsRequest {
    private String name;
    private double rent;
    private int rooms;

    public PGDetailsRequest() {
        // Default constructor needed for frameworks like Spring to instantiate the class.
    }

    public PGDetailsRequest(String name, double rent, int rooms) {
        this.name = name;
        this.rent = rent;
        this.rooms = rooms;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getRent() {
        return rent;
    }

    public int getRooms() {
        return rooms;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "PGDetailsRequest{" +
                "name='" + name + '\'' +
                ", rent=" + rent +
                ", rooms=" + rooms +
                '}';
    }
}