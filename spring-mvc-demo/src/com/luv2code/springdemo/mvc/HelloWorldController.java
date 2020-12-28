package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//Controller method to process form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
	//New controller method to read form data/
	//add data to model
	@RequestMapping("/processFormTwo")
	public String letsShoutDude (HttpServletRequest request, Model model) {
		//Read the request parameter from HTML form
		
		String name = request.getParameter("studentName");
		
		//Convert the data to all caps
		 name = name.toUpperCase();
		 
		//Create the message
		String result = "Yo! " + name;
		 
		//Add message to model
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName
			, Model model) {
		
		//Convert the data to all caps
		theName = theName.toUpperCase();
		 
		//Create the message
		String result = "Yo!  version 3" + theName;
		 
		//Add message to model
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
}
