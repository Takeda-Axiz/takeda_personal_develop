package jp.co.axiz.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.entity.Login;

@Repository
public class PgLoginDao implements LoginDao {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemp;

	private String SQLComm;
	private RowMapper<Login> mapper = new BeanPropertyRowMapper<Login>(Login.class);
	private MapSqlParameterSource SQLParam = new MapSqlParameterSource();

	public List<Login> findAll() {
		// 変数宣言
		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "SELECT"
				+ " user_id,"
				+ " user_name,"
				+ " password"
				+ " FROM"
				+ " userTbl"
				+ " ORDER BY"
				+ " user_id";

		return jdbcTemp.query(SQLComm, mapper);
	}

	public List<Login> find(Login cond) {
		// 変数宣言
		Boolean hasUserId;
		Boolean hasUserName;
		Boolean hasPassword;
		int refAry;

		ArrayList<String> whereCond = new ArrayList<>();
		ArrayList<Object> param = new ArrayList<>();

		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "SELECT"
				+ " user_id,"
				+ " user_name,"
				+ " password"
				+ " FROM"
				+ " userTbl"
				+ " WHERE ";

		hasUserId = cond.getUserId() != null;
		if (hasUserId) {
			whereCond.add("user_id = :user_id");
			param.add(cond.getUserId());
		}

		hasUserName = (cond.getUserName() != null && !cond.getUserName().isEmpty());
		if (hasUserName) {
			whereCond.add("user_name = :user_name");
			param.add(cond.getUserName());
		}

		hasPassword = (cond.getPassword() != null && !cond.getPassword().isEmpty());
		if (hasPassword) {
			whereCond.add("password = :password");
			param.add(cond.getPassword());
		}

		if (whereCond.isEmpty()) {
			return findAll();
		}

		String whereString = String.join(" AND ", whereCond.toArray(new String[]{}));

		// SQL文記載
		SQLComm += whereString;
		SQLComm += " ORDER BY"
				+  " user_id";

		refAry = 0;

		if(hasUserId) {
			SQLParam.addValue("user_id", param.get(refAry));
			refAry++;
		}

		if(hasUserName) {
			SQLParam.addValue("user_name", param.get(refAry));
			refAry++;
		}

		if(hasPassword) {
			SQLParam.addValue("password", param.get(refAry));
			refAry++;
		}

		return jdbcTemp.query(SQLComm, SQLParam, mapper);
	}

	@Override
	public Login findByNameAndPassword(String name, String password) {
		// 変数宣言
		List<Login> list;

		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "SELECT"
				+ " user_id,"
				+ " user_name,"
				+ " password"
				+ " FROM"
				+ " userTbl"
				+ " WHERE"
				+ " user_name = :user_name"
				+ " AND"
				+ " password = :password";

		SQLParam.addValue("user_name", name);
		SQLParam.addValue("password", password);
		list = jdbcTemp.query(SQLComm, SQLParam, mapper);

		if(list.isEmpty() || list.size() != 1) {
			return null;
		}else {
			return list.get(0);
		}
	}

	@Override
	public int register(Login user) {
		// 変数宣言
		int result;
		List<Login> list;

		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "INSERT"
				+ " INTO"
				+ " userTbl"
				+ " (user_name,"
				+ " password)"
				+ " VALUES"
				+ " (:user_name,"
				+ " :password)";

		SQLParam.addValue("user_name", user.getUserName());
		SQLParam.addValue("password", user.getPassword());

		result = jdbcTemp.update(SQLComm, SQLParam);

		list = find(user);
		if(list.isEmpty() || list.size() != 1) {
			return 0;
		}else {
			user.setUserId(list.get(0).getUserId());
			return result;
		}
	}

	@Override
	public Login findByName(String name) {
		// 変数宣言
		List<Login> list;

		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "SELECT"
				+ " user_id,"
				+ " user_name,"
				+ " password"
				+ " FROM"
				+ " userTbl"
				+ " WHERE"
				+ " user_name = :user_name";

		SQLParam.addValue("user_name", name);
		list = jdbcTemp.query(SQLComm, SQLParam, mapper);

		if(list.isEmpty() || list.size() != 1) {
			return null;
		}else {
			return list.get(0);
		}
	}

	@Override
	public Login findById(int id) {
		// 変数宣言
		List<Login> list;

		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "SELECT"
				+ " user_id,"
				+ " user_name,"
				+ " password"
				+ " FROM"
				+ " userTbl"
				+ " WHERE"
				+ " user_id = :user_id";

		SQLParam.addValue("user_id", id);
		list = jdbcTemp.query(SQLComm, SQLParam, mapper);

		if(list.isEmpty() || list.size() != 1) {
			return null;
		}else {
			return list.get(0);
		}
	}

	@Override
	public int update(Login user) {
		// 変数宣言
		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "UPDATE"
				+ " userTbl"
				+ " SET"
				+ " user_name = :user_name,"
				+ " password = :password"
				+ " WHERE"
				+ " user_id = :user_id";

		SQLParam.addValue("user_id", Integer.parseInt(user.getUserId()));
		SQLParam.addValue("user_name", user.getUserName());
		SQLParam.addValue("password", user.getPassword());

		return jdbcTemp.update(SQLComm, SQLParam);
	}

	@Override
	public int delete(int id) {
		// 変数宣言
		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "DELETE"
				+ " FROM"
				+ " userTbl"
				+ " WHERE"
				+ " user_id = :user_id";

		SQLParam.addValue("user_id", id);

		return jdbcTemp.update(SQLComm, SQLParam);
	}
}
