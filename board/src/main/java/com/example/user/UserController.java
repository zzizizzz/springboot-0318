package com.example.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	@GetMapping("/signup")
	public String form(Model model) {
		//Model객체에 입력폼의 입력필드와 매핑되는 폼객페를 저장한다.
		model.addAttribute("userSignupForm", new UserSignupForm());
		return "register-form"; // src/main/resources/templates/register-form.html
		
	}
	@PostMapping("/signup")
	public String signup(@Valid @ModelAttribute("userSignupForm") UserSignupForm form, BindingResult errors) {
		// @Valid 유효성 체크이므로 반드시 필요
		
		//BindingResult객체에 오류가 있으면, 유효성 체크를 통과하지 못한 것임으로 회원가입으로 내부이동시킨다.
		if(errors.hasErrors()) {
			return "register-form";
		}
		return "redirect:/user/completed";
	}
	
	@GetMapping("/completed")
	public String completed() {
		return "completed";		//src/main/resources/templates/completed.html
	}
 	
}
