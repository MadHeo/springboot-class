package com.mysite.sbb.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginForm {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "아이디가 일치하지 않습니다.")
    private String username;

    @NotEmpty(message = "비밀번호가 일치하지 않습니다")
    private String password;
}

