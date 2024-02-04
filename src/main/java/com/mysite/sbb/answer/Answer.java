package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Integer id;
    private String content;
    private LocalDateTime createDate;
    @ManyToOne
=======
    private Integer id; // 답변 번호
    private String content; //답변 내용
    private LocalDateTime createDate;
    @ManyToOne(fetch = FetchType.LAZY) //default fetch type = eager -> 즉시 로딩
>>>>>>> 4f4b8c2 (3회차)
    private Question question;
}
