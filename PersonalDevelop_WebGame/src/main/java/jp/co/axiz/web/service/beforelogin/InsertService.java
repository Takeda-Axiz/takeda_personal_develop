package jp.co.axiz.web.service.beforelogin;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.form.InsertForm;

@Service
public interface InsertService {

	String CallDao(InsertForm form, Model model);
}
