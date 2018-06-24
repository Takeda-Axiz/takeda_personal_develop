package jp.co.axiz.web.service.beforelogin.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.form.InsertForm;
import jp.co.axiz.web.service.beforelogin.InsertService;

@Service
public class InsertServiceImpl implements InsertService {

	@Autowired
	HttpSession session;

	@Autowired
	private LoginDao logindao;

	@Override
	public String CallDao(InsertForm form, Model model) {
		// 変数宣言
		String inputName = "";
		String inputPass = "";
		String inputRepass = "";
		String retStr = "";
		Boolean isMatchPass = false;
		Login getLogin = null;
		Login login = new Login();

		inputName = form.getNameVal();
		inputPass = form.getPassVal();
		inputRepass = form.getRePassVal();

		if (inputName == null || inputName.isEmpty()) {
			model.addAttribute("errmsg", "名前は必須です");
			// insert.jspに遷移
			retStr = "insert";
		}else if (inputPass == null || inputPass.isEmpty()) {
			model.addAttribute("errmsg", "PASSは必須です");
			// insert.jspに遷移
			retStr = "insert";
		}else if (inputRepass == null || inputRepass.isEmpty()) {
			model.addAttribute("errmsg", "PASS（再入力）は必須です");
			// insert.jspに遷移
			retStr = "insert";
		}else {
			isMatchPass = inputPass.equals(inputRepass);

			// パスワードが一致していることを確認
			if (isMatchPass) {
				// 一致している場合
				getLogin = logindao.findByName(inputName);
				if(getLogin == null) {
					login.setUserName(inputName);
					login.setPassword(inputPass);

					logindao.register(login);

					// insertResult.jspに遷移
					retStr = "insertResult";
				}else {
					// エラーメッセージをセット
					model.addAttribute("errmsg", "このユーザはすでに存在しています");
					// insert.jspに遷移
					retStr = "insert";
				}
			} else {
				// 一致しない場合
				// エラーメッセージをセット
				model.addAttribute("errmsg", "パスワードが一致しません");
				// insert.jspに遷移
				retStr = "insert";
			}
		}

		return retStr;
	}
}
