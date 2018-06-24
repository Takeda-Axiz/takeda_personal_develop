package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.PlayGame;

public interface PlayGameDao {

	void InsertScore(Long inputScore, String playGame);

	List<PlayGame> findAll();
}
