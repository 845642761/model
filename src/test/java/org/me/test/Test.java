package org.me.test;

import org.me.core.exception.ServiceExecption;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class Test {

	@RequestMapping("/errorTest")
	public void test() {
		throw new ServiceExecption("测试！");
	}
}
