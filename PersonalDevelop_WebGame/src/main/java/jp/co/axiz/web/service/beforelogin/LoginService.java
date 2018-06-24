package jp.co.axiz.web.service.beforelogin;

import org.springframework.ui.Model;

import jp.co.axiz.web.form.LoginForm;

public interface LoginService {

	String CallDao(LoginForm form, Model model);
}
