package com.taoxiuxia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frameController")
public class FrameController {
	private Logger logger=LoggerFactory.getLogger(FrameController.class);
	
	/**
	 * frame页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/showframe")
	public String frame(Model model) {
		return "pages/frame";
	}
	
	@RequestMapping("/head")
	public String head(Model model) {
		return "pages/head";
	}
	
	@RequestMapping("/menu")
	public String menu(Model model) {
		return "pages/menu";
	}
}
