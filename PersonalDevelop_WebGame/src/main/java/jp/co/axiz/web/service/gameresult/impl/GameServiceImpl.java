package jp.co.axiz.web.service.gameresult.impl;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.PlayGameDao;
import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.service.gameresult.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	HttpSession session;

	@Autowired
	PlayGameDao pgDao;

	@Override
	public String StartGame(Model model){
		String retStr = "game";
		StopWatch stopwatch = new StopWatch();

		stopwatch.start();

		session.setAttribute("watch", stopwatch);

		return retStr;
	}

	@Override
	public String SetGameResult(Model model) {
		// ストップウォッチを止める
		String outputStr = "";
		Boolean isExcpt = false;
		StopWatch stopwatch = (StopWatch)session.getAttribute("watch");

		try {
			stopwatch.stop();
		}catch(Exception e) {
			e.printStackTrace();
			isExcpt = true;
		}

		if(isExcpt == false) {
			// 変数宣言
			Long resultTime = null;
			Integer hourTime = null;
			Integer minuteTime = null;
			Integer secondTime = null;
			String loginUser = null;
			Login login = (Login)session.getAttribute("user");

			if(login != null) {
				loginUser = login.getUserName();
			}

			resultTime = stopwatch.getTime();

			secondTime = (int)(resultTime / 1000);

			if((secondTime / 60) >= 1) {
				minuteTime = (int)(secondTime / 60);

				if((minuteTime / 60) >= 1) {
					hourTime = (int)(minuteTime / 60);
				}
			}

			if(hourTime != null) {
				if(minuteTime < 10) {
					outputStr += 0;
					outputStr += hourTime;
				}else {
					outputStr += hourTime;
				}

				outputStr += ":";
			}

			if(minuteTime != null) {
				if(minuteTime < 10) {
					outputStr += 0;
					outputStr += minuteTime;
				}else {
					outputStr += minuteTime;
				}

				outputStr += ":";
			}else {
				outputStr += "00:";
			}

			if(secondTime < 10) {
				outputStr += 0;
				outputStr += secondTime;
			}else {
				outputStr += secondTime;
			}

			if(loginUser == null || loginUser.isEmpty()) {

			}else {
				pgDao.InsertScore(resultTime, "irairabou");
			}
		}else {
			outputStr = "--:--:--";
		}

		session.setAttribute("resultTime", outputStr);

		stopwatch.reset();

		return "gameResult";
	}

	@Override
	public String SetGameOver(Model model) {
		// ストップウォッチを止める
		String outputStr = "";
		StopWatch stopwatch = (StopWatch)session.getAttribute("watch");

		try {
			stopwatch.stop();
		}catch(Exception e) {
			e.printStackTrace();
		}

		outputStr = "--:--:--";

		session.setAttribute("resultTime", outputStr);

		model.addAttribute("missmsg", "壁にぶつかった場合、記録は残りません");

		stopwatch.reset();

		return "gameResult";
	}
}
