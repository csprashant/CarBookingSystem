package com.nbs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nbs.model.Reservation;
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

}
