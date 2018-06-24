package jp.co.axiz.web.service.afterlogin;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.form.UpdateForm;

@Service
public interface UpdateService {

	String InputDao(UpdateForm form, Model model);
}
