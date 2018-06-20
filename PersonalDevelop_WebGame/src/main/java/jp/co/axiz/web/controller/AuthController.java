package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.form.LoginForm;
import jp.co.axiz.web.service.beforelogin.LoginService;

@Controller
public class AuthController {

	@Autowired
	HttpSession session;

	@Autowired
	private LoginService service;

	// index -> login
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLogin(@ModelAttribute("LoginForm") LoginForm form, Model model) {
		return "login";
	}

	// login -> menu or login
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String postLogin(@ModelAttribute("LoginForm") LoginForm form, Model model) {
		String retJspVal = service.CallDao(form, model);

		return retJspVal;
	}

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(@ModelAttribute("LoginForm") LoginForm form, Model model) {
		session.invalidate();

		return "index";
	}
}
