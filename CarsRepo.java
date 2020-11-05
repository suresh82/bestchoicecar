package com.wipro.bestcar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.bestcar.model.Cars;

public interface CarsRepo extends JpaRepository<Cars, Integer> {

	public List<Cars> findByBrand(String carBrand);
	public List<Cars> findByPriceGreaterThan(String Price);
	public List<Cars> findByPriceLessThan(String Price); 
}
