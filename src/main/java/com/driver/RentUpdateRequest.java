package com.driver;

public class RentUpdateRequest {
	private double rent;

	public RentUpdateRequest() {
		// Default constructor needed for frameworks like Spring to instantiate the class.
	}

	public RentUpdateRequest(double rent) {
		this.rent = rent;
	}

	// Getter
	public double getRent() {
		return rent;
	}

	// Setter
	public void setRent(double rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "RentUpdateRequest{" +
				"rent=" + rent +
				'}';
	}
}