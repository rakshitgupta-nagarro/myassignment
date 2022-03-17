package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.model.Book;
import com.nagarro.services.BookService;

@Controller
public class BookController {

	@RequestMapping("/allbooks")
	public String allBooks(Model model, HttpSession session) {
		String name = (String) session.getAttribute("name");
		if (name != null) {
			try {
				List<Book> list = BookService.getAllBooks();
				model.addAttribute("list", list);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return "bookdetails";
		} else {
			return "login";
		}
	}

	@RequestMapping(path = "/addbook", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute Book book, Model model, HttpSession session) {
		String name = (String) session.getAttribute("name");
		if (name != null) {
			BookService.createBook(book);
			try {
				List<Book> list = BookService.getAllBooks();
				model.addAttribute("list", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "bookdetails";
		} else {
			return "login";
		}
	}

	@RequestMapping(path = "/editbook")
	public String editEmployee(@RequestParam("id") int id1, Model model, HttpSession session) {
		String name = (String) session.getAttribute("name");
		session.setAttribute("editId", id1);
		if (name != null) {
			try {
				Book list = BookService.getBook(id1);
				model.addAttribute("e", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "bookedit";
		} else {
			return "login";
		}
	}

	@RequestMapping(path = "/afteredit", method = RequestMethod.POST)
	public String editHandleForm(@ModelAttribute Book book, Model model, HttpSession session) {
		String name = (String) session.getAttribute("name");
		int id = Integer.parseInt(session.getAttribute("editId").toString());
		book.setId(id);
		if (name != null) {
			BookService.updateBook(book);
			try {
				List<Book> list = BookService.getAllBooks();
				model.addAttribute("list", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:allbooks";
		} else {
			return "login";
		}
	}

	@RequestMapping(path = "/deletebook")
	public String deleteHandleForm(@RequestParam("id") int id2, Model model, HttpSession session) {
		String name = (String) session.getAttribute("name");
		if (name != null) {
			Book book = BookService.getBook(id2);
			BookService.deleteBook(book.getId());
			try {
				List<Book> list = BookService.getAllBooks();
				model.addAttribute("list", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:allbooks";
		} else {
			return "login";
		}

	}
}
