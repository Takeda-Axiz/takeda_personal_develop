package jp.co.axiz.web.service.gameresult.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.JoinLPDao;
import jp.co.axiz.web.entity.JoinLP;
import jp.co.axiz.web.service.gameresult.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	HttpSession session;

	@Autowired
	JoinLPDao lpDao;

	@Override
	public String ReadScore(Model model){
		String retStr = "score";
		List<JoinLP> list;

		list = lpDao.joinScoreName();

		session.setAttribute("playlist", list);

		return retStr;
	}
}
