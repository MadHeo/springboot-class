package com.mysite.sbb.question;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {
    //    private final QuestionRepository questionRepository;
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
//        List<Question> questionList = this.questionRepository.findAll();
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);

        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);

        return "question_detail";
    }

    @GetMapping(value = "/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

//    @PostMapping(value = "/create")
//    public String questionCreate(@RequestParam(value = "subject") String subject, @RequestParam(value = "content") String content) {
//        // TODO 질문을 저장한다.
//        this.questionService.create(subject, content);
//
//        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
//    }

    @PostMapping(value = "/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }

        // TODO 질문을 저장한다.
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());

        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }
}