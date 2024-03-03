package com.mysite.sbb.visit;


import com.mysite.sbb.question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter //엔티티를 만들 때는 Setter 사용하지 않음. 부작용이 있을 수 있기 때문에 없애는 것이 좋음
@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime visitDate;
    private Integer questionID;
    private Integer visitCount;

    @ManyToOne(fetch = FetchType.LAZY) //default fetch type = eager -> 즉시 로딩
    private Question question;
}
