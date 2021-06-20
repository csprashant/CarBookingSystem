package com.nbs.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nbs.model.Reservation;
import com.nbs.model.User;
import com.nbs.model.Vehicle;
import com.nbs.repository.ReservationRepository;
import com.nbs.repository.UserRepository;
import com.nbs.repository.VehicleRepository;
import com.nbs.vo.ReservationnVo;

@Service
public class ReservationService {
	private ReservationRepository repository;
	private UserRepository userRepository;
	private VehicleRepository vehicleRepository;

	public ReservationService(ReservationRepository repository, UserRepository userRepository,
			VehicleRepository vehicleRepository) {
		this.repository = repository;
		this.userRepository = userRepository;
		this.vehicleRepository = vehicleRepository;
	}

	public boolean bookReservation(ReservationnVo rvo) throws Exception {
		Reservation reservation = new Reservation();
		reservation.setFromDate(new SimpleDateFormat("yyyy-MM-dd").parse(rvo.getFromDate()));
		reservation.setToDate(new SimpleDateFormat("yyyy-MM-dd").parse(rvo.getToDate()));
		reservation.setUpdated(new Timestamp(new Date().getTime()));
		reservation.setStatus(true);
		// loading existing user
		User user = userRepository.findById(Integer.valueOf(rvo.getUserId())).get();
		// loading existing Vehicle
		Vehicle vehicle = vehicleRepository.findById(Integer.valueOf(rvo.getVehicleId())).get();
		// adding user data to reservation
		reservation.setUser(user);
		// adding vehicle data to reservation
		reservation.setVehicle(vehicle);
		boolean res = false;
		try {
			repository.save(reservation);
			res = true;
		} catch (Exception ee) {
			ee.printStackTrace();
			res = false;
		}
		return res;
	
}
public List<ReservationnVo> fetchAllReservationDetails() {
	List<Reservation> listReservation = (List<Reservation>)repository.findAll();
	List<ReservationnVo> listVo = new ArrayList<ReservationnVo>();
	for (int i = 0; i < listReservation.size(); i++) {
		ReservationnVo reservationnvo = new ReservationnVo();
		reservationnvo.setId(listReservation.get(i).getId() + "");
		reservationnvo.setUserId(listReservation.get(i).getUser().getId() + "");
		reservationnvo.setUserName(listReservation.get(i).getUser().getName());
		reservationnvo.setVehicleId(listReservation.get(i).getVehicle().getId()+ "");
		reservationnvo.setVName(listReservation.get(i).getVehicle().getvName());
		reservationnvo.setVNumber(listReservation.get(i).getVehicle().getvNumber());
		reservationnvo.setFromDate((listReservation.get(i).getFromDate() + "").substring(0, 10));
		reservationnvo.setToDate((listReservation.get(i).getToDate() + "").substring(0, 10));
		reservationnvo.setStatus(listReservation.get(i).isStatus() + "");
		reservationnvo.setUpdated(listReservation.get(i).getUpdated() + "");
		reservationnvo.setCreated(listReservation.get(i).getCreated() + "");
		listVo.add(reservationnvo);
	}
	return listVo;
}
}