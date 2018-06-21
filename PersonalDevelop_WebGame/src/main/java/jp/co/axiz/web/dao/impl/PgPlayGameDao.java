package jp.co.axiz.web.dao.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.PlayGameDao;
import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.entity.PlayGame;

@Repository
public class PgPlayGameDao implements PlayGameDao {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemp;

	@Autowired
	HttpSession session;

	private String SQLComm;
	private RowMapper<PlayGame> mapper = new BeanPropertyRowMapper<PlayGame>(PlayGame.class);
	private MapSqlParameterSource SQLParam = new MapSqlParameterSource();

	@Override
	public void InsertScore(Long inputScore, String playGame) {
		// 変数宣言
		Login login;
		Integer gameId;
		String score = DurationFormatUtils.formatPeriod(0, inputScore, "HH:mm:ss");

		// 初期化
		login = (Login)session.getAttribute("user");
		gameId = findGameId(playGame);
		SQLComm = "";

		// SQL文記載
		SQLComm += "INSERT"
				+ " INTO"
				+ " user_gameTbl"
				+ " (user_id,"
				+ " game_id,"
				+ " score,"
				+ " date)"
				+ " VALUES"
				+ " (:user_id,"
				+ " :game_id,"
				+ " :score,"
				+ " :date)";

		SQLParam.addValue("user_id", Integer.parseInt(login.getUserId()));
		SQLParam.addValue("game_id", gameId);
		SQLParam.addValue("score", score);
		SQLParam.addValue("date", new Date());

		jdbcTemp.update(SQLComm, SQLParam);
	}

	private Integer findGameId(String playGame) {
		// 変数宣言
		List<PlayGame> list;
		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "SELECT"
				+ " game_id"
				+ " FROM"
				+ " gameTbl"
				+ " WHERE"
				+ " game_name = :game_name";

		SQLParam.addValue("game_name", playGame);

		list = jdbcTemp.query(SQLComm, SQLParam, mapper);

		if(list.isEmpty() || list.size() != 1) {
			return null;
		}else {
			return Integer.parseInt(list.get(0).getGameId());
		}
	}

	@Override
	public List<PlayGame> findAll() {
		// 変数宣言
		// 初期化
		SQLComm = "";

		// SQL文記載
		SQLComm += "SELECT"
				+ " play_cnt,"
				+ " user_id,"
				+ " game_id,"
				+ " score,"
				+ " date"
				+ " FROM"
				+ " user_gameTbl"
				+ " ORDER BY"
				+ " play_cnt";

		return jdbcTemp.query(SQLComm, mapper);
	}
}

