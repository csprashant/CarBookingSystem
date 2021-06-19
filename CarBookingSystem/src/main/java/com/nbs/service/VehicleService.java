package com.nbs.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nbs.model.User;
import com.nbs.model.Vehicle;
import com.nbs.repository.VehicleRepository;

@Service
public class VehicleService {
	private final VehicleRepository repository;
	
	public VehicleService(VehicleRepository vehicleRepository) {
		this.repository=vehicleRepository;
	}
	public void saveVehicle(Vehicle vehilce){
		vehilce.setUpdated(new Timestamp(new Date().getTime()));
		repository.save(vehilce);
	}
	public List<Vehicle> getAllVehicleInfo() {
		List<Vehicle> listVehicle=(List<Vehicle>)repository.findAll();
		return listVehicle;	
	}
	public Vehicle getVehicleInfo(Integer vehicleId)
	{	Optional<Vehicle> vehicle = repository.findById(vehicleId);
		return vehicle.get();
	}
	public void deleteVehicle(Integer vehicleId)
	{
		repository.deleteById(vehicleId);
	}

}
