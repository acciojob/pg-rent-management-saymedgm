package com.driver;

public class PGDetails {
	private int id;
	private String name;
	private double rent;
	private int rooms;

	public PGDetails() {
		// Default constructor needed for frameworks like Spring to instantiate the class.
	}

	public PGDetails(int id, String name, double rent, int rooms) {
		this.id = id;
		this.name = name;
		this.rent = rent;
		this.rooms = rooms;
	}

	// Getters
	public int getId() {
		return id;
	}

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
	public void setId(int id) {
		this.id = id;
	}

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
		return "PGDetails{" +
				"id=" + id +
				", name='" + name + '\'' +
				", rent=" + rent +
				", rooms=" + rooms +
				'}';
	}
}