package com.mysite.sbb;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;
import com.mysite.sbb.user.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class SbbApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;

    @Test
    void testJpa() {
        System.out.println("테스틥니다");

        Question q1 = new Question();
        q1.setSubject("sbb가 뭔가요?");
        q1.setContent("sbs는 또 뭔가요?");
        q1.setCreateDate(LocalDateTime.now());
        questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문");
        q2.setContent("id는 자동 생성인가요?");
        q2.setCreateDate(LocalDateTime.now());
        questionRepository.save(q2);
    }

    @Test
    void testJpaFindAll() {
        List<Question> all = questionRepository.findAll();
        assertEquals(1, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 뭔가요?", q.getSubject());
    }

    @Test
    void testJpaFindById() {
        Optional<Question> oq = this.questionRepository.findById(1);
        if (oq.isPresent()) {
            Question q = oq.get();
            assertEquals("sbb가 뭔가요?", q.getSubject());
        }
    }

    @Test
    void testJpaFindBySubject() {
        Question q = this.questionRepository.findBySubject("sbb가 뭔가요?");
        assertEquals(1, q.getId());
    }

    @Test
    void testJpaFindBySubjectAndContent() {
        Question q;
        q = this.questionRepository.findBySubjectAndContent("sbb가 뭔가요?", "sbs는 또 뭔가요?");
        assertEquals(1, q.getId());
    }

    @Test
    void testJpaFindBySubjectOrContent() {
        Question q;
        q = this.questionRepository.findBySubjectOrContent("sbb가 뭔가요?", "testest");
        assertEquals(1, q.getId());
    }

    @Test
    void testFindByIdLessThan() {
        Question q = this.questionRepository.findByIdLessThan(2);
        assertEquals(2, q.getId());
    }

    @Test
    void testFindByIdGreaterThanEqual() {
        Question q = this.questionRepository.findByIdGreaterThanEqual(2);
        assertEquals(1, q.getId());
    }

    @Test
    void testFindBySubjectLike() {
        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
        Question q = qList.get(0);
        assertEquals("sbb가 뭔가요?", q.getSubject());
    }

    @Test
    void testFindBySubjectIn() {
//        List<Question> qList = this.questionRepository.findBySubjectIn(["1","2","3","4","5"]);
//        Question q = qList.get(0);
//        assertEquals("sbb가 뭔가요?", q.getSubject());
    }

    @Test
    void testFindBySubjectOrderByCreateDateAsc() {
        Question q = this.questionRepository.findBySubjectOrderByCreateDateAsc("sbb가 뭔가요?");
        assertEquals("sbb가 뭔가요?", q.getSubject());
    }

    @Test
    void testJpaUpdate() {
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());

        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);
    }

    @Test
    void testJpaDelete() {
        assertEquals(2, this.questionRepository.count());

        //1번 row 존재 여부 체크
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        //1번 row 가져오기
        Question q = oq.get();
        //1번 row 삭제
        this.questionRepository.delete(q);

        //count 메서드로 행 개수 체크
        assertEquals(1, this.questionRepository.count());
    }

    @Test
    void testJpaAnswerInsert() {
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다.");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }

    @Test
    @Transactional
    void testJapAnswerSelect() {
        Optional<Answer> oa = this.answerRepository.findById(1);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(2, a.getQuestion().getId());
    }

    @Test
    @Transactional(readOnly = true)
    void testJapAnswerSelect2() {
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(2, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());

    }

    @Test
    void testInsertJap() {
        for (int i = 1; i <= 300; i++) {
            this.questionService.create("테스트 데이터[" + i + "]", "내용 없음");
        }
    }

    @Test
    void testPassword() {
        this.userService.create("gtt3d", "ewaer@a4w3er.com", "dkssud3gk34tpdy123");
    }


}


