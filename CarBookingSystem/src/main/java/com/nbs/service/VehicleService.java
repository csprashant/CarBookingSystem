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
	/**
	 * save a new vehicle class object  
	 *@param vehilce  Vehicle class object 
	 */
	public void saveVehicle(Vehicle vehilce){
		vehilce.setUpdated(new Timestamp(new Date().getTime()));
		repository.save(vehilce);
	}

	/**
	 *  Returns all vehicle details
	 *@return retruns List<Vehicle> List of vehicles 
	 */
	public List<Vehicle> getAllVehicleInfo() {
		List<Vehicle> listVehicle=(List<Vehicle>)repository.findAll();
		return listVehicle;	
	}
	
	/**
	 	*Returns single vehicle class object
	 	*@param vehicleId a Integer value represents vehicleId 
	 */
	public Vehicle getVehicleInfo(Integer vehicleId)
	{	Optional<Vehicle> vehicle = repository.findById(vehicleId);
		return vehicle.get();
	}
	/**
		*Deletes single Vehicle
		*@param vehicleId  a Integer value represents vehicleId 
	 */
		public void deleteVehicle(Integer vehicleId)
	{
		repository.deleteById(vehicleId);
	}

}
