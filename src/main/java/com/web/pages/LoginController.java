package com.web.pages;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.entity.Account;

@Controller
public class LoginController {
	
	
	
	@RequestMapping(value="/login"
								, method=RequestMethod.GET)
	public String showLoginPage(Model model)
	{
		model.addAttribute("newUser", new Account());
		return "pages/login";
	}
}
