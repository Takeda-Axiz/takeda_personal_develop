package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ScoreController {

	// menu -> score
	@RequestMapping(value="/score", method=RequestMethod.GET)
	public String index(Model model) {
		return "score";
	}

}
