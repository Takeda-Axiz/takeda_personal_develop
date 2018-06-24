package jp.co.axiz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.form.InsertForm;
import jp.co.axiz.web.service.beforelogin.InsertService;

@Controller
public class InsertController {

	@Autowired
	private InsertService service;

	// menu -> insert
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String getInsert(@ModelAttribute("InsertForm") InsertForm form, Model model) {
		return "insert";
	}

	// insert -> insertResult
	@RequestMapping(value="/insertResult", method=RequestMethod.POST)
	public String postInsert(@ModelAttribute("InsertForm") InsertForm form, Model model) {
		String retJspVal = service.CallDao(form, model);

		return retJspVal;
	}
}
