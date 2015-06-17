package com.since10.web.dispatch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexChangeViewController {

	@RequestMapping("/index")
	public String change1() {
		return "/index.jsp";
	}

	@RequestMapping("/index/next")
	public String change2() {
		return change1();
	}

	@RequestMapping("/index/next/inner/change.do")
	public String change3() {
		return change1();
	}
}
