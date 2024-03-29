package com.mysite.sbb.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFoundIdForm {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String email;
}
