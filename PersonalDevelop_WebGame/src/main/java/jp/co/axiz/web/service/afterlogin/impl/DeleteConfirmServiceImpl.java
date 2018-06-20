package jp.co.axiz.web.service.afterlogin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.form.DeleteForm;
import jp.co.axiz.web.service.afterlogin.DeleteConfirmService;

@Service
public class DeleteConfirmServiceImpl implements DeleteConfirmService {

	@Autowired
	private LoginDao logindao;

	@Override
	public void DeleteDao(DeleteForm form, Model model) {
		// 変数宣言
		String inputId = "";

		inputId = form.getIdVal();

		logindao.delete(Integer.parseInt(inputId));
	}
}




