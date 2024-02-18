package com.mysite.sbb.question;

import com.mysite.sbb.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter //엔티티를 만들 때는 Setter 사용하지 않음. 부작용이 있을 수 있기 때문에 없애는 것이 좋음
@Entity
public class Question {
    @Id // Primary Key (pk)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 질문 번호
    @Column(length = 200)
    private String subject; // 제목
    @Column(columnDefinition = "TEXT")
    private String content; // 내용
    private LocalDateTime createDate; // 작성날짜

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) // fetch type = lazy -> 지연 로딩
    private List<Answer> answerList;

}