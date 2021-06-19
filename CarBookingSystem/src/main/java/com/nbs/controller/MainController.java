package com.nbs.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nbs.model.User;
import com.nbs.model.Vehicle;
import com.nbs.service.UserService;
import com.nbs.service.VehicleService;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/")
	public String home(@ModelAttribute("User") User user) {
		return "login";
	}
	@GetMapping("/welcome")
	public String showWelcome() {
		return "welcome";
	}

	@GetMapping("/welcomeuser")
	public String mapperWelcomeUserPage() {
		return "welcomeuser";
	}

	@GetMapping("/add-user")
	public String showUserRegistration(@ModelAttribute("user") User user/* , BindingResult bindingResult */) {
		return "add_user";
	}
	@PostMapping("/handle-add-user")
	public String handlerAddUser( @Valid @ModelAttribute("user") User user,BindingResult result, HttpServletRequest request, Map<String,String> map) {
		//session = request.getSession(false);
		//user1 = (User) session.getAttribute("user");
		/*if (user1.getType() == 1) {
			
				return "add_user";
			}
			*/
			System.out.println("sdf");
			if(result.hasErrors())
			{	
				return "add_user";
			}
			userService.saveUser(user);
			map.put("res", "data inserted succesfuly");
			return "add_user";
		/*} else {
			session.invalidate();//
			m.addAttribute("msg", "you dont have  privilege for this page");
			return "landing";
		}
	*/}
	@GetMapping("/list-all-users")
	public String showAllUserInfo(Map<String,List<User>> map)
	{	//--------------
		
		map.put("listUser",userService.getAllUserInfo());
		return "list_all_users";
		
	}
	
	
	@GetMapping("/deleteuser/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId,Map<String,List<User>> map)
	{//-------------
		userService.deleteUser(userId);	
		map.put("listUser",userService.getAllUserInfo());
		return "list_all_users";
	}
	@GetMapping("/updateuser/{userId}")
	public String mapperUpdateUser(@PathVariable("userId") int userId, HttpServletRequest request, Map<String ,User> map) {
		/*session = request.getSession(false);
		user1 = (User) session.getAttribute("user");
		if (user1.getType() == 1) {*/
		
			 User user = userService.getUserInfo(userId);		
			map.put("user", user);
			return "update_user";
	/*	} else {
			model.addAttribute("msg", "you dont have  privilege for this page");
			return "landing";
		}*/
	}
@PostMapping("/handle-update-user")
	public String handlerUpdateUser(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response,
			Map<String,String> map,Map<String,User> map1) throws IOException, ServletException {

		/*RequestDispatcher rd;
		session = request.getSession(false);
		user1 = (User) session.getAttribute("user");
		if (user1.getType() == 1) {
			String res = "";
		*/	userService.saveUser(user);
				user.setEmail("");
				user.setName("");
				user.setPassword("");
				map1.put("user", user);
				map.put("res", "details updated successfully");
				return "update_user";
				/*
				 * } else { throw new
				 * RuntimeException("you dont have  privilege for this page"); }
				 */
	}
@GetMapping("/add-vehicle")
public String showVehicleRegistration(@ModelAttribute("vehicle") Vehicle vehicle/* , BindingResult bindingResult */) {
	return "add_vehicle";
}
@PostMapping("/handle-add-vehicle")
public String handlerAddVehicle( @Valid @ModelAttribute("vehicle") Vehicle vehicle,BindingResult result, HttpServletRequest request, Map<String,String> map) {
	//session = request.getSession(false);
	//user1 = (User) session.getAttribute("user");
	/*if (user1.getType() == 1) {
		
			return "add_user";
		}
		*/
		System.out.println("sdf");
		if(result.hasErrors())
		{	
			return "add_vehicle";
		}
		vehicleService.saveVehicle(vehicle);
		map.put("res", "data inserted succesfuly");
		return "add_vehicle";
	/*} else {
		session.invalidate();//
		m.addAttribute("msg", "you dont have  privilege for this page");
		return "landing";
	}
*/}
@GetMapping("/list-all-vehicle")
public String showAllVehicleInfo(Map<String,List<Vehicle>> map)
{	//--------------
	
	map.put("listVehicle",vehicleService.getAllVehicleInfo());
	System.out.println("1111111111");
	return "list_all_vehicle";	
}
@GetMapping("/delete/{vehicleId}")
public String deleteVehicle(@PathVariable("vehicleId") Integer vehicleId,Map<String,List<Vehicle>> map)
{//-------------
	vehicleService.deleteVehicle(vehicleId);
	map.put("listVehicle",vehicleService.getAllVehicleInfo());
	return "list_all_vehicle";
}

@GetMapping("/update/{vehicleId}")
public String mapperUpdateVehicle(@PathVariable("vehicleId") int vehicleId, HttpServletRequest request, Map<String ,Vehicle> map) {
	/*session = request.getSession(false);
	user1 = (User) session.getAttribute("user");
	if (user1.getType() == 1) {*/
	
		 Vehicle vehicle = vehicleService.getVehicleInfo(vehicleId);
		map.put("vehicle", vehicle);
		return "update_vehicle";
/*	} else {
		model.addAttribute("msg", "you dont have  privilege for this page");
		return "landing";
	}*/
}
@PostMapping("/handle-update-vehicle")
public String handlerUpdateVehicle(@ModelAttribute Vehicle vehicle, HttpServletRequest request, HttpServletResponse response,
		Map<String,String> map,Map<String,Vehicle> map1) throws IOException, ServletException {

	/*RequestDispatcher rd;
	session = request.getSession(false);
	user1 = (User) session.getAttribute("user");
	if (user1.getType() == 1) {
		String res = "";
	*/	vehicleService.saveVehicle(vehicle);
		
			map1.put("vehicle", vehicle);
			map.put("res", "details updated successfully");
			return "update_vehicle";
			/*
			 * } else { throw new
			 * RuntimeException("you dont have  privilege for this page"); }
			 */
}
//handler for display all vehicle information to user only
	@GetMapping("/list-all-vehicle-user")
	public String handlerListAllVehicleUser(HttpServletRequest request, User user) {
		/*
		 * session = request.getSession(false); user = (User)
		 * session.getAttribute("user");
		 */
		request.setAttribute("listVehicle", vehicleService.getAllVehicleInfo());
		return "list_all_vehicle_user";
	}
	
	
}
