package br.com.unitri.agenciaturismo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.Users;
import br.com.unitri.agenciaturismo.model.dao.UsersDao;
import br.com.unitri.agenciaturismo.service.UsersService;

@Service
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class UsersServiceImpl implements UsersService{

	@Autowired
	UsersDao usersDao;
	
	public List<Users> listAll() {
		return usersDao.listAll();
	}

	public Users findByUsername(String username) {
		return usersDao.findByUsername(username);
	}


	public void addUsers(Users users) {
		usersDao.addUsers(users);
	}

	public void updateUsers(Users users) {
		usersDao.updateUsers(users);
	}

	public void removeUsers(Users users) {
		usersDao.removeUsers(users);
	}

}
