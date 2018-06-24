package jp.co.axiz.web.service.afterlogin.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.service.afterlogin.DeleteService;

@Service
public class DeleteServiceImpl implements DeleteService {

	@Autowired
	HttpSession session;

	@Autowired
	private LoginDao logindao;

	@Override
	public void DeleteDao(Model model) {
		// 変数宣言
		String delId = "";
		Login loginUser = (Login) session.getAttribute("user");

		delId = loginUser.getUserId();

		logindao.delete(Integer.parseInt(delId));

		session.removeAttribute("user");
	}
}
