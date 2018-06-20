package jp.co.axiz.web.service.beforelogin.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.form.LoginForm;
import jp.co.axiz.web.service.beforelogin.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao logindao;

	@Autowired
	HttpSession session;

	@Override
	public String CallDao(LoginForm form, Model model) {
		// 変数宣言
		String inputName = "";
		String inputPass = "";
		String retStr = "";
		Login getLogin = null;

		inputName = form.getNameVal();
		inputPass = form.getPassVal();
		getLogin = logindao.findByNameAndPassword(inputName, inputPass);
		// 入力されたIDが存在するか確認
		if(getLogin == null) {
			// nullだった(adminIDが存在しない)場合
			// エラーメッセージを設定
			model.addAttribute("errmsg", "ユーザ名またはPASSが間違っています");
			// login.jspに遷移
			retStr = "login";
		}else {
			// nullではない(adminIDが存在している)場合
			// adminユーザーを記憶
			session.setAttribute("user", getLogin);
			// menu.jspに遷移
			retStr = "menu";
		}

		return retStr;
	}
}
