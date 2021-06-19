package com.nbs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nbs.model.Vehicle;
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle,Integer>{

}
