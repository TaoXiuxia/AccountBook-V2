package com.taoxiuxia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/borrowController")
public class BorrowController {
	@RequestMapping("/showBorrows")
	public String showBorrows(Model model) {
		return "pages/borrow";
	}
}
