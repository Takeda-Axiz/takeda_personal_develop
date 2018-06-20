package jp.co.axiz.web.service.afterlogin;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.form.DeleteForm;

@Service
public interface DeleteService {

	String CallDao(DeleteForm form, Model model);
}
