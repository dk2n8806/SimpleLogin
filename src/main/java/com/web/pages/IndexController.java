package com.web.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.admin.config.anno.ActiveUserPrincipal;
import com.common.entity.Account;

@Controller
public class IndexController {


	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showPage(@ActiveUserPrincipal Account account) {
		if(account != null) 
			return "redirect:/user/contacts";
		return "pages/index";
	}
}
