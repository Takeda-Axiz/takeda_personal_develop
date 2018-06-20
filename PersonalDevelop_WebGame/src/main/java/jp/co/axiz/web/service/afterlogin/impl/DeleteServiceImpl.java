package jp.co.axiz.web.service.afterlogin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.form.DeleteForm;
import jp.co.axiz.web.service.afterlogin.DeleteService;

@Service
public class DeleteServiceImpl implements DeleteService {

	@Autowired
	private LoginDao logindao;

	@Override
	public String CallDao(DeleteForm form, Model model) {
		// 変数宣言
		String inputId = "";
		String retStr = "deleteConfirm";
		Login login;

		inputId = form.getIdVal();

		if (inputId == null || inputId.isEmpty()) {
			model.addAttribute("errmsg", "必須項目を入力してください");
			// delete.jspに遷移
			retStr = "delete";
		}else {
			login = logindao.findById(Integer.parseInt(inputId));

			if (login == null) {
				model.addAttribute("errmsg", "入力されたデータは存在しません");
				// delete.jspに遷移
				retStr = "delete";
			}else {
				model.addAttribute("deleteUser", login);
			}
		}

		return retStr;
	}
}
