package com.test.unit.dao;

import java.util.List;

import com.test.unit.entity.Rent;

public interface RentDAO {
	
	public void save(Rent rent);

	public List<Rent> getDelayedRentals();

}
