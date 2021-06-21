package com.nbs.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nbs.model.User;
import com.nbs.model.Vehicle;
import com.nbs.service.ReservationService;
import com.nbs.service.UserService;
import com.nbs.service.VehicleService;
import com.nbs.vo.ReservationnVo;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private ReservationService reservationService;
	HttpSession session = null;
	User user1 = null;

	@GetMapping("/")
	public String home(@ModelAttribute("User") User user) {

		return "login";
	}
	
	@GetMapping("/welcome")
	public String showWelcome(HttpServletRequest request, Map<String, Object> m) {

		if (valid(request))
			return "welcome";
		else {
			session.invalidate();
			m.put("msg", "you dont have  privilege for this page");
			return "landing";
		}
	}

	@GetMapping("/welcomeuser")
	public String mapperWelcomeUserPage() {
		return "welcomeuser";
	}

	@PostMapping("/handle-login")
	public String handleLogin(@ModelAttribute("User") User user, BindingResult result, HttpServletRequest request)
			throws Exception {

		if (user.getEmail().length() == 0 || user.getPassword().length() == 0) {
			return "login";
		} else {
			User user1 = userService.login(user.getEmail(), user.getPassword());
			if (user1 != null) {
				session = request.getSession();
				session.setAttribute("user", user1);
				if (user1.getType() == 1) {
					return "welcome";
				} else {
					return "welcomeuser";
				}
			} else {
				request.setAttribute("msg", "you have enter wrong credentials ");
				return "landing";
			}
		}

	}

	@GetMapping("/add-user")
	public String showUserRegistration(@ModelAttribute("user") User user, HttpServletRequest request,
			Map<String, Object> map/* , BindingResult bindingResult */) {

		if (valid(request))
			return "add_user";
		else {
			map.put("msg", "you dont have  privilege for this page");
			session.invalidate();
			return "landing";
		}
	}

	@PostMapping("/handle-add-user")
	public String handlerAddUser(@Valid @ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request, Map<String, String> map) {
		if (result.hasErrors()) {
			return "add_user";
		}

		if (valid(request)) {
			userService.saveUser(user);
			map.put("res", "data inserted succesfuly");
			return "add_user";
		} else {
			session.invalidate();
			map.put("msg", "you dont have  privilege for this page");
			return "landing";
		}
	}

	@GetMapping("/list-all-users")
	public String showAllUserInfo(Map<String, Object> map, HttpServletRequest request) {
		if (valid(request)) {
			map.put("listUser", userService.getAllUserInfo());
			return "list_all_users";
		} else {
			session.invalidate();
			map.put("msg", "you dont have  privilege for this page");
			return "landing";
		}
	}

	@GetMapping("/deleteuser/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId, Map<String, Object> map,
			HttpServletRequest request) {
		if (valid(request)) {
			userService.deleteUser(userId);
			map.put("listUser", userService.getAllUserInfo());
			return "list_all_users";
		} else {
			session.invalidate();
			map.put("msg", "you dont have  privilege for this page");
			return "landing";
		}
	}

	@GetMapping("/updateuser/{userId}")
	public String mapperUpdateUser(@PathVariable("userId") int userId, HttpServletRequest request,
			Map<String, Object> map) {
		if (valid(request)) {
			User user = userService.getUserInfo(userId);
			map.put("user", user);
			return "update_user";
		} else {
			map.put("msg", "you dont have  privilege for this page");
			return "landing";
		}
	}

	@PostMapping("/handle-update-user")
	public String handlerUpdateUser(@Valid @ModelAttribute User user,BindingResult result, HttpServletRequest request,
			Map<String, Object> map) {
		if (valid(request)) {
			userService.saveUser(user);
			map.put("res", "details updated successfully");
			user.setEmail("");
			user.setName("");
			user.setPassword("");
			return "update_user";
		} else {
			session.invalidate();
			map.put("msg", "you dont have  privilege for this page");
			return "landing";
		}
	}

	@GetMapping("/add-vehicle")
	public String showVehicleRegistration(@ModelAttribute("vehicle") Vehicle vehicle, HttpServletRequest request,
			Map<String, Object> map) {

		if (valid(request))
			return "add_vehicle";
		else {
			map.put("msg", "you dont have  privilege for this page");
			session.invalidate();
			return "landing";
		}
	}

//==============
	@PostMapping("/handle-add-vehicle")
	public String handlerAddVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult result,
			HttpServletRequest request, Map<String, String> map) {
		if (result.hasErrors()) {
			return "add_vehicle";
		}
		if (valid(request)) {
			vehicleService.saveVehicle(vehicle);
			map.put("res", "data inserted succesfuly");
			return "add_vehicle";
		} else {
			session.invalidate();
			map.put("msg", "you dont have  privilege for this page");
			return "landing";
		}
	}

	@GetMapping("/list-all-vehicle")
	public String showAllVehicleInfo(Map<String, Object> map,HttpServletRequest request) { // --------------
		if (valid(request)) {
			map.put("listVehicle", vehicleService.getAllVehicleInfo());
			return "list_all_vehicle";
		} else {
			session.invalidate();
			map.put("msg", "you dont have  privilege for this page");
			return "landing";
		}
	}

	@GetMapping("/delete/{vehicleId}")
	public String deleteVehicle(@PathVariable("vehicleId") Integer vehicleId, Map<String, Object> map,HttpServletRequest request) {// -------------
		if(valid(request))
			{vehicleService.deleteVehicle(vehicleId);
		map.put("listVehicle", vehicleService.getAllVehicleInfo());
		return "list_all_vehicle";
			}
		 else {
				session.invalidate();
				map.put("msg", "you dont have  privilege for this page");
				return "landing";
			}
	}
	@GetMapping("/update/{vehicleId}")
	public String mapperUpdateVehicle(@PathVariable("vehicleId") int vehicleId, HttpServletRequest request,Map<String, Object> map) {
		if(valid(request)) {
		Vehicle vehicle = vehicleService.getVehicleInfo(vehicleId);
		map.put("vehicle", vehicle);
		return "update_vehicle";}
		else {
			session.invalidate();
			map.put("msg", "you dont have  privilege for this page");
			return "landing";
		}
	}
	@PostMapping("/handle-update-vehicle")
	public String handlerUpdateVehicle(@Valid @ModelAttribute Vehicle vehicle,BindingResult result, HttpServletRequest request, Map<String, Object> map) {
		if(valid(request)){
		 vehicleService.saveVehicle(vehicle);
		map.put("res", "details updated successfully");
		vehicle.setvName("");
		vehicle.setvColor("");
		vehicle.setvNumber(null);
		return "update_vehicle";}
		else {
			session.invalidate();
			map.put("msg", "you dont have  privilege for this page");
			return "landing";
		}
		
	}

//handler for display all vehicle information to user only
	@GetMapping("/list-all-vehicle-user")
	public String handlerListAllVehicleUser(HttpServletRequest request, User user,Map<String,Object> map) {
		  session = request.getSession(false);
		  user = (User)session.getAttribute("user");
		 if(user!=null) {
			 request.setAttribute("listVehicle", vehicleService.getAllVehicleInfo());
			 return "list_all_vehicle_user";
		 }
		 else {
				session.invalidate();
				map.put("msg", "you dont have  privilege for this page");
				return "landing";
		 }
	}
	// mapper for creating reservation by user
		@GetMapping("/reservation/{vehicleId}")
		public String mappercreateReservation(@PathVariable("vehicleId") int vehicleId, HttpServletRequest request,
				User user, Model model) throws ServletException, IOException {
			session = request.getSession(false);
			user = (User) session.getAttribute("user");
			model.addAttribute("vehivleID", vehicleId);
			model.addAttribute("userID", user.getId());
			model.addAttribute("userName", user.getName());
			return "create_reservation";
		}
		// handler for creating reservation by user
		@PostMapping(value = "/handle-create-reservation")
		public String handlerCreateReservation(@ModelAttribute ReservationnVo reservationnVo, Model model)
				throws Exception {
			
			if(new SimpleDateFormat("yyyy-MM-dd").parse(reservationnVo.getFromDate()).compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(reservationnVo.getToDate())) < 0)
			{
				boolean res = false;
				try {
					res = reservationService.bookReservation(reservationnVo)	;
					res = true;
				} catch (Exception e) {
					e.printStackTrace();
					res = false;
				}
				if (res = true) {
					model.addAttribute("msg", "Reservation created successfully");
					return "create_reservation";
				} else {
					model.addAttribute("msg", "Reservation failed");
					return "landing";
				}
			}
			else
			{model.addAttribute("msg", "from date must be before to date");
			return "welcomeuser";
			}

		}
		
		// mapper for creating reservation by user
				@GetMapping("/reservation-admin/{vehicleId}")
				public String mappercreateReservationByAdmin(@PathVariable("vehicleId") int vehicleId, HttpServletRequest request,
						User user, Model model) throws ServletException, IOException {
					session = request.getSession(false);
					user = (User) session.getAttribute("user");
					model.addAttribute("vehivleID", vehicleId);
		
					return "create_reservation_admin";
				}

				// handler for creating reservation by user
				@PostMapping( "/handle-create-reservation-admin")
				public String handlerCreateReservationByadmin(@ModelAttribute ReservationnVo reservationnVo, Model model)
						throws Exception {

					if(new SimpleDateFormat("yyyy-MM-dd").parse(reservationnVo.getFromDate()).compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(reservationnVo.getToDate())) < 0)
					{
						boolean res = false;
						try {
							System.out.println(reservationnVo.getFromDate());
							res = reservationService.bookReservation(reservationnVo);
							res = true;
						} catch (Exception e) {
							e.printStackTrace();
							res = false;
						}
						if (res = true) {
							model.addAttribute("msg", "Reservation created successfully");
							return "create_reservation_admin";
						} else {
							
							model.addAttribute("msg", "Reservation failed");
							return "landing";
						}

					}
					else
					{
						model.addAttribute("msg", "Error :  From date must be before to date");
						
						
						return "welcome";
					}
				}
		
		// mapper for return jsp page of reservation history
		@GetMapping("/list-reservation-history")
		public String mapperListReservatinHistory(HttpServletRequest request, User user, Model model) {
	
			if (valid(request)) {
				request.setAttribute("listreservation", reservationService.fetchAllReservationDetails());
				return "reservation_history";
			} else {
				model.addAttribute("msg", "you dont have  privilege for this page");
				return "landing";
			}
		}
		

	@GetMapping("/logout")
	public String logout(@ModelAttribute("User") User user, HttpServletRequest request) throws Exception {
		session = request.getSession(false);
		session.invalidate();
		return "login";
	}

	public boolean valid(HttpServletRequest request) {
		session = request.getSession(false);
		User user1 = (User) session.getAttribute("user");
		if (user1.getType() == 1)
			return true;
		else
			return false;
	}

	@ExceptionHandler(value = NullPointerException.class)
	public String customException(Model m) {
		m.addAttribute("msg", "you dont have  privilege for this page");
		return "landing";
	}

}
