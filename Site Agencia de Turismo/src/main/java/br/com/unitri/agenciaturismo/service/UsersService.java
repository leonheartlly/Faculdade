package br.com.unitri.agenciaturismo.service;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Users;

public interface UsersService {

	List<Users> listAll();
	Users findByUsername(String username);
	
	void addUsers(Users users);
	void updateUsers(Users users);
	void removeUsers(Users users);
}
