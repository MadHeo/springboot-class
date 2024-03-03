package com.mysite.sbb.visit;

import ch.qos.logback.classic.ViewStatusMessagesServlet;
import com.mysite.sbb.answer.AnswerService;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionForm;
import com.mysite.sbb.question.QuestionService;
import com.mysite.sbb.user.SiteUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
@RequiredArgsConstructor
@Controller
public class VisitController {

    private final QuestionService questionService;
    private final VisitService visitService;
//    @PostMapping(value = "/visit/create{id}")
//    public void visitCreate(Model model, @PathVariable("id") Integer id) {
//        Question question = this.questionService.getQuestion(id);
//        visitService.
//    }
}
