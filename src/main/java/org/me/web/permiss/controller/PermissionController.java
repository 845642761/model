package org.me.web.permiss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/system/permiss/")
public class PermissionController {
	
	@RequestMapping("add")
	public ModelAndView add() {
		return new ModelAndView("/system/permiss/add");
	}
}
