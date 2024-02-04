package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/answer")
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;

//    @PostMapping("/create/{id}")
//    public String createAnswer(Model model, @PathVariable("id") Integer id,
//                               @RequestParam(value = "content") String content) {
//
//        Question question = this.questionService.getQuestion(id);
//        answerService.create(question, content);
//        return String.format("redirect:/question/detail/%s", id);
//    }

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id,
                               @Valid AnswerForm answerForm, BindingResult bindingResult) {

        Question question = this.questionService.getQuestion(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }
        answerService.create(question, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }
}