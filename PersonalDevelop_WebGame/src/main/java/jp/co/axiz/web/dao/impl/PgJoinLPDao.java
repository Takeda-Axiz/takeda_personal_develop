package jp.co.axiz.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.JoinLPDao;
import jp.co.axiz.web.entity.JoinLP;
import jp.co.axiz.web.entity.Login;

@Repository
public class PgJoinLPDao implements JoinLPDao {

	@Autowired
	HttpSession session;

	@Autowired
	NamedParameterJdbcTemplate jdbcTemp;

	private String SQLComm;
	private RowMapper<JoinLP> mapper = new BeanPropertyRowMapper<JoinLP>(JoinLP.class);
	private MapSqlParameterSource SQLParam = new MapSqlParameterSource();

	public List<JoinLP> joinScoreName() {
		// 変数宣言
		int i;
		List<JoinLP> list = new ArrayList<JoinLP>();
		Login login = (Login)session.getAttribute("user");
		List<String> rank = new ArrayList<String>();

		// 初期化
		SQLComm = "";

		// SQL文発行
		SQLComm += "SELECT"
				+ " ug.score,"
				+ " u.user_name"
				+ " FROM"
				+ " user_gameTbl ug"
				+ " LEFT OUTER JOIN"
				+ " userTbl u"
				+ " ON"
				+ " u.user_id = ug.user_id"
				+ " WHERE"
				+ " u.user_id = :user_id"
				+ " ORDER BY"
				+ " ug.score";

		SQLParam.addValue("user_id", Integer.parseInt(login.getUserId()));

		list = jdbcTemp.query(SQLComm, SQLParam, mapper);

		i = 0;
		for(JoinLP jLP : list) {
			switch(i) {
			case 0:
				rank.add("1st");
				break;
			case 1:
				rank.add("2nd");
				break;
			case 2:
				rank.add("3rd");
				break;
			default:
				rank.add("");
				break;
			}
			jLP.setRank(rank.get(i));
			i++;
		}

		return list;
	}
}
