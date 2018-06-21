package jp.co.axiz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.service.gameresult.ScoreService;

@Controller
public class ScoreController {

	@Autowired
	ScoreService scService;

	// menu -> score
	@RequestMapping(value="/score", method=RequestMethod.GET)
	public String index(Model model) {
		scService.ReadScore(model);

		return "score";
	}

}
