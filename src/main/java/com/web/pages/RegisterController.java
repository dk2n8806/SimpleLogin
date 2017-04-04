
package com.web.pages.account.form;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.entity.Account;
import com.common.json.JsonResponse;
import com.core.service.AccountAuthenticationService;

@Controller
public class RegisterController {


	
	@Autowired private AccountAuthenticationService authenService;
	
	

	@RequestMapping(value="/register"
											, method=RequestMethod.GET)
	public String showRegisterForm(Model model
			) {
		Account account = new Account();
		model.addAttribute("newUser", account);
		return "pages/account/register";
	}
	
	

	
	@RequestMapping(value="/register"
											, method=RequestMethod.POST)
	@ResponseBody
	public JsonResponse processRegisterForm(Model model
																, @ModelAttribute("newUser") Account account
																, @RequestParam("password") String password
			) {

		synchronized (this) {
			JsonResponse jsonResponse = new JsonResponse();
			try {
				Account entity = authenService.register(account, password);
				Assert.notNull(entity, "Unable to create new a new account entity");
			
				jsonResponse.setState(true);
			} catch(DataIntegrityViolationException e) {
				jsonResponse.setState(false);
			} catch(Exception e) {
				jsonResponse.setState(false);
				e.printStackTrace();
			}
			return jsonResponse;
		}
	}
	
}
