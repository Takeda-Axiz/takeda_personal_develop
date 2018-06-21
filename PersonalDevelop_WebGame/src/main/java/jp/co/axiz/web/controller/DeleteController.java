package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.service.afterlogin.DeleteService;

@Controller
public class DeleteController {

	@Autowired
	HttpSession session;

	@Autowired
	private DeleteService service;

	// menu -> delete
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String getDelete(Model model) {
		return "delete";
	}

	// delete -> delete or deleteResult
	@RequestMapping(value="/deleteConfirm", method=RequestMethod.POST)
	public String deleteConfirm(Model model) {
		service.DeleteDao(model);

		return "deleteResult";
	}
}
