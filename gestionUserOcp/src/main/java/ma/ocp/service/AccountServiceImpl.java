package ma.ocp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ocp.dao.AppRoleRepository;
import ma.ocp.dao.AppUserRepository;
import ma.ocp.entities.AppRole;
import ma.ocp.entities.AppUser;
import ma.ocp.entities.TechnicienForm;
import ma.ocp.entities.UserForm;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	
	private AppUserRepository userRepository;
	private AppRoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public AccountServiceImpl(AppUserRepository userRepository, AppRoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	@Override
	public AppUser saveUser(UserForm user2) {
		AppUser user=userRepository.findByEmail(user2.getUsername());
		if(user!=null)  throw new RuntimeException("user already exixts");
		if(user2.getUsername().equals(""))  throw new RuntimeException("email vide");
		if(!user2.getPassword().equals(user2.getRepassword()) && user2.getPassword().equals(null))throw new RuntimeException("please confirme your password!!");
		
		AppUser appUser=new AppUser();
		appUser.setEmail(user2.getUsername());
		appUser.setActived(true);
		appUser.setPassword(bCryptPasswordEncoder.encode(user2.getPassword()));
		appUser.setNom(user2.getNom());
		appUser.setPrenom(user2.getPrenom());
		appUser.setTelephone(user2.getTelephone());
		appUser.setService(user2.getService());
		userRepository.save(appUser);
		addRoleToUser(user2.getUsername(),"USER");
		return appUser;
	}
	@Override
	public AppUser saveTechnicien(TechnicienForm user2){
		AppUser user=userRepository.findByEmail(user2.getUsername());
		if(user!=null)  throw new RuntimeException("user already exixts");
		if(!user2.getPassword().equals(user2.getRepassword()))throw new RuntimeException("please confirme your password!!");
		
		AppUser appUser=new AppUser();
		appUser.setEmail(user2.getUsername());
		appUser.setActived(true);
		appUser.setPassword(bCryptPasswordEncoder.encode(user2.getPassword()));
		appUser.setNom(user2.getNom());
		appUser.setPrenom(user2.getPrenom());
		appUser.setTelephone(user2.getTelephone());
        appUser.setSpecialite(user2.getSpecialite());
		userRepository.save(appUser);
		addRoleToUser(user2.getUsername(),"TECHNICIEN");
		return appUser;
	}
	@Override
	public AppRole saveRole(AppRole r) {
		
		return roleRepository.save(r);
	}
	@Override
	public AppUser loadUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}
	@Override
	public void addRoleToUser(String email, String roleName) {
		AppUser user=userRepository.findByEmail(email);
		AppRole role=roleRepository.findByRoleName(roleName);
		user.getRoles().add(role);
		

		
	}
	@Override
	public void deleteAllUser() {
		userRepository.deleteAll();
		
	}
	@Override
	public void deleteAllRolle() {
		roleRepository.deleteAll();
		
	}
	
	

}
