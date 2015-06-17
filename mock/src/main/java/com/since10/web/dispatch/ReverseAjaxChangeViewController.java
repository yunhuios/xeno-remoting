package com.since10.web.dispatch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReverseAjaxChangeViewController {

	@RequestMapping("/reverse_ajax")
	public String change1() {
		return "/reverse_ajax.jsp";
	}

	@RequestMapping("/reverse_ajax/next")
	public String change2() {
		return change1();
	}

	@RequestMapping("/reverse_ajax/next/inner/change.do")
	public String change3() {
		return change1();
	}
}
