package com.selk.thyme;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/sub")
    public String sub() {
        return "pages/sub";
    }
}