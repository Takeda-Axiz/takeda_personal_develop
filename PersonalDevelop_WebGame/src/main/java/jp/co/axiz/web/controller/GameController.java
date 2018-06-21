package jp.co.axiz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.form.GameResultForm;
import jp.co.axiz.web.service.gameresult.GameService;

@Controller
public class GameController {

	@Autowired
	private GameService gService;

	// menu -> game
	@RequestMapping(value="/game", method=RequestMethod.GET)
	public String game(Model model) {
		String retJspVal = gService.StartGame(model);

		return retJspVal;
	}

	// game -> gameResult
	@RequestMapping(value="/gameResult", method=RequestMethod.POST)
	public String gameResult(@ModelAttribute("GameResultForm") GameResultForm form, Model model) {
		String retJspVal = gService.SetGameResult(model);

		return retJspVal;
	}

	// game -> gameResult(debug用)
	@RequestMapping(value="/gameResult", method=RequestMethod.GET)
	public String debug(@ModelAttribute("GameResultForm") GameResultForm form, Model model) {
		return gameResult(form, model);
	}
}
