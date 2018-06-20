package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.form.DeleteForm;
import jp.co.axiz.web.service.afterlogin.DeleteConfirmService;
import jp.co.axiz.web.service.afterlogin.DeleteService;

@Controller
public class DeleteController {

	@Autowired
	HttpSession session;

	@Autowired
	private DeleteService service;

	@Autowired
	private DeleteConfirmService confirmService;

	// menu -> delete
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String getDelete(@ModelAttribute("DeleteForm") DeleteForm form, Model model) {
		return "delete";
	}

	// delete -> delete or deleteConfirm
	@RequestMapping(value="/deleteConfirm", method=RequestMethod.POST)
	public String deleteConfirm(@ModelAttribute("DeleteForm") DeleteForm form, Model model) {
		String retJspVal = service.CallDao(form, model);

		return retJspVal;
	}

	// deleteConfirm -> deleteResult
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String postDelete(@ModelAttribute("DeleteForm") DeleteForm form, Model model) {
		confirmService.DeleteDao(form, model);

		return "deleteResult";
	}
}
