package br.com.unitri.agenciaturismo.model.dao;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Hotel;
import br.com.unitri.agenciaturismo.model.UserRoles;

public interface UserRolesDao{

	void add(UserRoles userRoles);
	void update(UserRoles userRoles);
	void remove(UserRoles userRoles);
}
