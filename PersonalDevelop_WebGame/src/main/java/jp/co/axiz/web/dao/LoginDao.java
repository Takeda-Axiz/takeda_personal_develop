package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.Login;

public interface LoginDao {

	List<Login> findAll();

	List<Login> find(Login cond);

	Login findByNameAndPassword(String name, String password);

	int register(Login user);

	Login findByName(String name);

	Login findById(int id);

	int update(Login user);

	int delete(int id);
}
