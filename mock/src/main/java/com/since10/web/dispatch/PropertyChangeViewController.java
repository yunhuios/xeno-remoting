package com.since10.web.dispatch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PropertyChangeViewController {

	@RequestMapping("/property")
	public String change1() {
		return "/property.jsp";
	}

	@RequestMapping("/property/next")
	public String change2() {
		return change1();
	}

	@RequestMapping("/property/next/inner/change.do")
	public String change3() {
		return change1();
	}
}
