package com.mysite.sbb.visit;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class VisitService {
    private final VisitRepository visitRepository;
    public void visit(Question question, Visit visit, Integer id){
        visit.setVisitDate(LocalDateTime.now());
        visit.setQuestion(question);
        visit.setQuestionID(id);
        this.visitRepository.save(visit);
    }

    }
