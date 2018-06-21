package jp.co.axiz.web.service.afterlogin;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface DeleteService {

	void DeleteDao(Model model);
}
