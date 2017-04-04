package com.web.pages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.admin.config.anno.ActiveUserPrincipal;
import com.common.entity.Account;
import com.common.entity.ContactMessage;
import com.common.entity.MessageStatus;
import com.common.json.JsonResponse;
import com.core.service.ContactMessageService;
import com.core.service.EmailService;


@Controller
public class ContactController implements IContactConroller {


	private final String FORM_SUCCESS =  "redirect:/user/contacts";
	private final String FORM_FAIL = "redirect:/user/contact-form";
	@Autowired private ContactMessageService messageService;
	@Autowired private EmailService emailService;
	

	@RequestMapping(value="/user/contacts", method=RequestMethod.GET)
	@Override
	public String showContactMessages(Model model
																, @ActiveUserPrincipal Account account
																, @ModelAttribute("message") JsonResponse jsonResponse) 
	{
		MessageStatus status = null;
		Pageable pageable = new PageRequest(0, 10);
		List<ContactMessage> messages = messageService.getByAccount(account, status, pageable);
		model.addAttribute("messages", messages);
		if(jsonResponse != null) 
			model.addAttribute("jsonMessage", jsonResponse);
		return "pages/contacts";
	}

	
	
	
	
	

	@RequestMapping(value="/user/contact-form", method=RequestMethod.GET)
	@Override
	public String showContactForm(Model model, JsonResponse jsonResponse) 
	{
		if(jsonResponse != null) 
			model.addAttribute("jsonMessage", jsonResponse);
		return "pages/contactForm";
	}

	
	
	
	
	
	@RequestMapping(value="/user/send-contact", method=RequestMethod.POST)
	@Override
	public String processContactForm(@ActiveUserPrincipal Account account
																		, @RequestParam String name
																		, @RequestParam String email
																		, @RequestParam String message
																		, final RedirectAttributes redirectAttributes
			) 
	{
		ContactMessage contactMsg = null;
		JsonResponse jsonResponse = null;;
		try {
			contactMsg = messageService.save(new ContactMessage(account, name, email, message));
			if(contactMsg != null) { 
				jsonResponse = new JsonResponse(true, "Successfuly sent your message");
				return FORM_SUCCESS;
			}
			else {
				jsonResponse = new JsonResponse(false, "Failed sending your message");
			}
		} catch(IllegalArgumentException e) {
			jsonResponse = new JsonResponse(false, e.getMessage());
		}
		redirectAttributes.addFlashAttribute("message", jsonResponse);
		return FORM_FAIL;
	}
	
	
	

	

}
