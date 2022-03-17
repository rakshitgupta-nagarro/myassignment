package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.nagarro.model.Admin;
import com.nagarro.model.Book;
import com.nagarro.services.AdminService;
import com.nagarro.services.BookService;

@Controller
public class AdminController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(path = "/afterlogin", method = RequestMethod.POST)
	public String loginHandle(@ModelAttribute Admin admin, Model model, HttpServletRequest request) {
		String ee = admin.getEmail();
		Admin user;
		try {
			user = AdminService.getUser(ee);
			List<Book> list = BookService.getAllBooks();
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
			return "login";
		}
		request.getSession().setAttribute("name", user.getName());
		return "bookdetails";
	}

	@RequestMapping("/sessionlogout")
	public String logout(HttpSession httpsession, SessionStatus status) {
		status.setComplete();

		httpsession.invalidate();
		return "login";
	}
}
