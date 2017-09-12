package com.josh.dundermifflin.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.josh.dundermifflin.service.AuthService;

@Controller
public class AuthController {
	
	@Autowired
	@Qualifier("AuthServiceImpl")
	private AuthService authService;

	@RequestMapping(value="auth-user", method=RequestMethod.POST)
	public String authUser(String username, String password, HttpSession session, Model model) {
		String redirect = "index";
		String role = authService.authUser(username, password);
		if (role.length() > 0) {
			session.setAttribute("username", username);
			session.setAttribute("role", role);
		} else {
			return "redirect:/login.jsp?message=Incorrect username or password.";
		}
		return redirect;
	}
	
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String home() {
		System.out.println("At Home");
		return "home";
	}	
	
	
	@RequestMapping(value="auth", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="sessionTimeout", method=RequestMethod.GET)
	public String sessionTimeout() {
		return "login";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/login.jsp?message=You have successfully logged out.";
	}

}
