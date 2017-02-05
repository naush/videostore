package main.data;

import main.rental.Rental;

import java.util.ArrayList;
import java.util.List;

public class Statement
{
	private Customer customer;
	private List<Rental> rentals = new ArrayList<>();

	public void addRental (Rental rental) {
		rentals.add(rental);
	}
	
	public String getName () {
		return customer.getName();
	}

	public void addCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Rental> getRentals() {
		return rentals;
	}
}