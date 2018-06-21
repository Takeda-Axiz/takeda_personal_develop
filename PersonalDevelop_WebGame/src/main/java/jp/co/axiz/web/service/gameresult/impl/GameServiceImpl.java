package jp.co.axiz.web.service.gameresult.impl;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.service.gameresult.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	HttpSession session;

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
		// 変数宣言
		Long resultTime = null;
		Integer hourTime = null;
		Integer minuteTime = null;
		Integer secondTime = null;
		String outputStr = "";
		String retStr = "gameResult";

		StopWatch stopwatch = (StopWatch)session.getAttribute("watch");

		stopwatch.stop();

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
			outputStr += ".";
			outputStr += resultTime % 1000;
		}else {
			outputStr += secondTime;
		}

		session.setAttribute("resultTime", outputStr);

		stopwatch.reset();

		return retStr;
	}
}
