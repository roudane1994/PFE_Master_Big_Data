package ma.ocp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.ocp.dao.AppUserRepository;
import ma.ocp.entities.AppUser;
import ma.ocp.entities.TechnicienForm;
import ma.ocp.entities.UserForm;
import ma.ocp.service.AccountService;



@RestController
public class UserController {
	
	@Autowired
	AccountService accountService;
	@Autowired
	AppUserRepository appUserRep;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/registerUser")
	public AppUser register(@RequestBody UserForm user) {
		
		return accountService.saveUser(user);
	}
	
	@PostMapping("/registerTechnicien")
	public AppUser registerTechnicien(@RequestBody TechnicienForm user) {
		
		return accountService.saveTechnicien(user);
	}
	@GetMapping(path ="/trouveEmail/{email}")
	public AppUser findUser(@PathVariable(name ="email")String email) {
		
		return appUserRep.findByEmail(email);
	}
	
	@GetMapping(path ="/verifieePassword/{emailUser}/{password}")
	public boolean verifieePassword(@PathVariable(name ="emailUser")String emailUser,@PathVariable(name ="password")String password) {
		
		AppUser user=appUserRep.findByEmail(emailUser);
		
		return bCryptPasswordEncoder.matches(password, user.getPassword());
	}
	
	@GetMapping(path ="/changePassword/{emailUser}/{newPassword}")
	public void changePassword(@PathVariable(name ="emailUser")String emailUser,@PathVariable(name ="newPassword")String password) {
		
		AppUser user=appUserRep.findByEmail(emailUser);
		user.setPassword(bCryptPasswordEncoder.encode(password));
		appUserRep.save(user);
	}
	
	

}


