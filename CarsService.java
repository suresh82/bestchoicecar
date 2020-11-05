package com.wipro.bestcar.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.bestcar.dao.CarsRepo;
import com.wipro.bestcar.model.Cars;

@Service
public class CarsService implements CarsServiceImple {

	@Autowired
	CarsRepo carsRepoDao;

	@Override
	public List<Cars> findAllCarModels(String carBrand) {
		// TODO Auto-generated method stub

		return carsRepoDao.findByBrand(carBrand);
	}

	@Override
	public List<Cars> findCarsPriceGreaterThan(String Price) {
		// TODO Auto-generated method stub
		return carsRepoDao.findByPriceGreaterThan(Price);
	}

	@Override
	public List<Cars> findCarsPriceLessThan(String Price) {
		// TODO Auto-generated method stub
		return carsRepoDao.findByPriceLessThan(Price);
	}

}
