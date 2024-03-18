package com.example.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupForm {
	
	@NotBlank(message="아이디는 필수입력값입니다.")
	@Size(min =3, message="아이디는 3글자 이상입니다.")
	private String id;
	
	@NotBlank(message="비밀번호는 필수 입력값입니다.")
	@Size(min=8,  message="비밀번호는 8글자 이상입니다.")
	private String password;
	
	@NotBlank
	@Pattern(regexp="^[가-힇]{2,}$", message="이름은 한글 2글자 이상입니다.")
	private String name;
	
	@NotBlank(message="이메일은 필수 입력값입니다.")
	@Email(message="유효한 이메일 형식이 아닙니다.")
	private String email;
	
	@NotBlank(message="전화번호는 필수 입력값입니다.")
	@Pattern(regexp= "^\\d{2,3}-\\d{3,4}-\\d{4}$", message="유효한 전화번호 형식이 아닙니다.")
	//{2,3}= 등장횟수
	private String tel;
}
