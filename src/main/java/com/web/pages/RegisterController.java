
package com.web.pages;


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
		return "pages/register";
	}
	
	

	
	@RequestMapping(value="/register"
											, method=RequestMethod.POST)
	public String processRegisterForm(Model model
																, @ModelAttribute("newUser") Account account
																, @RequestParam("password") String password
			) {
		synchronized (this) {
			try {
				Account entity = authenService.register(account, password);
				Assert.notNull(entity, "Unable to create new a new account entity");
				return "redirect:/user/contacts";
			} catch(DataIntegrityViolationException e) {
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
			return "pages/register";
		}
	}
	
}
