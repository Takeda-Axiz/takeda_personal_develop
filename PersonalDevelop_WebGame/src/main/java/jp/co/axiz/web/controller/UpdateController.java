package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.form.UpdateForm;
import jp.co.axiz.web.service.afterlogin.UpdateService;

@Controller
public class UpdateController {

	@Autowired
	HttpSession session;

	@Autowired
	private UpdateService service;

	// menu or updateInput -> update
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String getUpdate(@ModelAttribute("UpdateForm") UpdateForm form, Model model) {
		return "update";
	}

	// update -> update or updateResult
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateConfirm(@ModelAttribute("UpdateForm") UpdateForm form, Model model) {
		String retJspVal = service.InputDao(form, model);

		return retJspVal;
	}
}
