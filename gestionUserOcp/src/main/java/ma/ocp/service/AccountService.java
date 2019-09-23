package ma.ocp.service;

import ma.ocp.entities.AppRole;
import ma.ocp.entities.AppUser;
import ma.ocp.entities.TechnicienForm;
import ma.ocp.entities.UserForm;

public interface AccountService {
	
	public AppUser saveUser(UserForm user);
	public AppUser saveTechnicien(TechnicienForm user);
	public AppRole saveRole(AppRole r);
	public AppUser loadUserByEmail(String email);
	public void addRoleToUser(String username,String role);
	
	public void deleteAllUser();
	public void deleteAllRolle();

}
