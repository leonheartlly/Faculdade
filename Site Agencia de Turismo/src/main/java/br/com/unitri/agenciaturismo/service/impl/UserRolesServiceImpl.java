package br.com.unitri.agenciaturismo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.UserRoles;
import br.com.unitri.agenciaturismo.model.dao.UserRolesDao;
import br.com.unitri.agenciaturismo.service.UserRolesService;

@Service
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class UserRolesServiceImpl implements UserRolesService{

	@Autowired
	UserRolesDao dao;
	
	public void add(UserRoles userRoles) {
		dao.add(userRoles);
	}

	public void update(UserRoles userRoles) {
		dao.update(userRoles);
	}

	public void remove(UserRoles userRoles) {
		dao.remove(userRoles);
	}

}
