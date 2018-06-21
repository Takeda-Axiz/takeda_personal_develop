package jp.co.axiz.web.service.afterlogin.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.form.UpdateForm;
import jp.co.axiz.web.service.afterlogin.UpdateService;

@Service
public class UpdateServiceImpl implements UpdateService {

	@Autowired
	HttpSession session;

	@Autowired
	private LoginDao logindao;

	@Override
	public String InputDao(UpdateForm form, Model model) {
		// 変数宣言
		String oldName = "";
		String newName = form.getNameVal();
		String retStr = "";
		String errmsg = null;
		Boolean isChgName = true;
		Login loginUser = (Login) session.getAttribute("user");
		Login afterUser = new Login();
		Login chkLogin;

		oldName = loginUser.getUserName();

		if (newName == null || newName.isEmpty() || newName.equals(oldName)) {
			// 新しい名前が入力されていない
			isChgName = false;
		} else {
			afterUser.setUserName(newName);
		}

		if (isChgName == false) {
			model.addAttribute("errmsg", "変更してください");
			// update.jspに遷移
			retStr = "update";
		}else {
			chkLogin = logindao.findByName(newName);
			if(chkLogin == null) {
				// Name変更
				loginUser.setUserName(newName);
			}else {
				// エラーメッセージをセット
				errmsg = "このユーザはすでに存在しています";
			}

			if(errmsg == null) {
				logindao.update(loginUser);
				session.setAttribute("user", loginUser);
				retStr = "updateResult";
			}else {
				model.addAttribute("errmsg", errmsg);
				// update.jspに遷移
				retStr = "update";
			}
		}
		return retStr;
	}
}
