package com.pams.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping(value = "/helloworld/string")
    @ResponseBody
    public String helloworldString() {
        return "helloworld";
    }
	
	@GetMapping(value = "/join/user")
    @ResponseBody
    public String joinUser() {
        return "Thank You";
    }
}
