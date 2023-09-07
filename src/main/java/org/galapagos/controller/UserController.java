package org.galapagos.controller;

import org.galapagos.domain.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/user")
@Log4j
public class UserController {

	@GetMapping("/join")
	public String joinGet() {
		return "user/join";	// forward 처리
	}
	
	@PostMapping("/join")
	public String joinPost(UserDTO user, RedirectAttributes ra) {
		// DB에 INSERT 작업을 함
		log.info(user);
		
		ra.addFlashAttribute(user);
		
		// "redirect:이동할 url"
		return "redirect:/user/join_result";	// GET 요청
	}
	
	@GetMapping("/join_result")
	public String joinResult(UserDTO user) {
		return "user/join_result";
	}
	
}
