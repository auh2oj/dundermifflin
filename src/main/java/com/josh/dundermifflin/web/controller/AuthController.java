package com.josh.dundermifflin.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
	
	@Autowired
	@Qualifier("AuthServiceImpl")
	//private AuthService authService;
	
	@RequestMapping(value="auth-user", method=RequestMethod.POST)
	public String authUser(String username, String password, HttpSession session, Model model) {
		String redirect = "index";
		return null;
	}

}
