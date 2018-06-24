package jp.co.axiz.web.service.gameresult;

import org.springframework.ui.Model;

public interface GameService {

	String StartGame(Model model);

	String SetGameResult(Model model);

	String SetGameOver(Model model);
}
