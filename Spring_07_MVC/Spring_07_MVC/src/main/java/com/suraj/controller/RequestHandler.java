package com.suraj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.suraj.model.Book;

@Controller
public class RequestHandler
{	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView checkLogin(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		ModelAndView model = new ModelAndView("/welcome");
		model.addObject("username", username);
		model.addObject("heading", "Adding a book");
		return model;
	}
	
	@RequestMapping(value = {"/login", "/"})
	public String logout()
	{
		return "login";
	}

	
	@RequestMapping(value = "/submitBook", method = RequestMethod.POST)
	public String submitBook(@ModelAttribute Book bk, Model model)
	{
		model.addAttribute("book", bk);
		model.addAttribute("heading", "Book Successfully Inserted!!");
		return "submitBook";
	}
}
