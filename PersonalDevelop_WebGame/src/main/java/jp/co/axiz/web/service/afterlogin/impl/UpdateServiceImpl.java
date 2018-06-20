package jp.co.axiz.web.service.afterlogin.impl;

import java.util.BitSet;

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
		String oldPass;
		String newName = form.getNameVal();
		String newPass = form.getPassVal();
		String rePass = form.getRePassVal();
		String retStr = "";
		String errmsg = null;
		BitSet cmnFlg = new BitSet(2);		// Name、Passwordの2つ
		Login loginUser = (Login) session.getAttribute("user");
		Login afterUser = new Login();
		Login chkLogin;

		oldPass = loginUser.getPassword();

		if (newName == null || newName.isEmpty()) {
			cmnFlg.set(0);
		} else {
			afterUser.setUserName(newName);
		}

		if (newPass == null || newPass.equals(oldPass)) {
			cmnFlg.set(1);
		} else {
			afterUser.setPassword(newPass);
		}

		if (cmnFlg.cardinality() == 2) {
			model.addAttribute("errmsg", "１項目以上変更してください");
			// update.jspに遷移
			retStr = "update";
		}else {

			if(cmnFlg.get(0)) {
				chkLogin = logindao.findByName(newName);
				if(chkLogin == null) {
					// Name変更
					System.out.println(newName);
					loginUser.setUserName(newName);
				}else {
					// エラーメッセージをセット
					errmsg = "このユーザはすでに存在しています";
				}
			}

			if(cmnFlg.get(1)) {
				// Pass変更
				if(rePass == null) {
					// エラーメッセージをセット
					errmsg = "パスワードが一致しません";

				}else if(newPass.equals(rePass)) {
					System.out.println(afterUser.getPassword());
					loginUser.setPassword(newPass);
				}else {
					// エラーメッセージをセット
					errmsg = "パスワードが一致しません";
				}
			}

			System.out.println(errmsg);
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
