package com.mysite.sbb.user;

import com.mysite.sbb.question.QuestionForm;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }

        try {
            userService.create(userCreateForm.getUsername(), userCreateForm.getPassword1(),
                    userCreateForm.getEmail());

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }
    @GetMapping("/foundId")
    public String foundId() {
        return "found_id_form";
    }

    @GetMapping("/foundId/found")
    public String foundIdGet(@Valid UserFoundIdForm userFoundIdForm) {
        return "found_id_form";
    }

//    @PostMapping("/login")
//    public String login(@Valid UserLoginForm userLoginForm, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "login_form";
//        }
//
//        boolean isLoginSuccess = this.userService.isLogin(
//                userLoginForm.getUsername(), userLoginForm.getPassword()
//        );
//        if (isLoginSuccess) {
//            return "redirect:/";
//        } else {
//            bindingResult.reject("로그인 실패");
//            return "login_form";
//        }
//    }

}
