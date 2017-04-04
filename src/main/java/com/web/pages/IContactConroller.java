package com.web.pages;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.common.entity.Account;
import com.common.json.JsonResponse;


public interface IContactConroller {

	String showContactMessages(Model model, Account account, JsonResponse jsonResponse);
	
	String showContactForm(Model model, JsonResponse jsonResponse);
	
	String processContactForm(Account account, String name
													, String email, String message
													, RedirectAttributes redirectAttributes);
}
