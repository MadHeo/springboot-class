package com.mysite.sbb.question;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Test {
    @Id // Primary Key (pk)
    private Integer id; // 질문 번호
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime updateDate; // 작성날짜
}
