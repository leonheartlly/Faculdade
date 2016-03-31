package br.com.unitri.agenciaturismo.model.dao;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Users;

public interface UsersDao{

	
	List<Users> listAll();
	Users findByUsername(String username);
	
	void addUsers(Users users);
	void updateUsers(Users users);
	void removeUsers(Users users);

}
