package com.mysite.sbb.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);

    Question findByContent(String content);

    Question findBySubjectAndContent(String subject, String content);

    Question findBySubjectOrContent(String subject, String content);

    Question findByIdLessThan(Integer id);

    Question findByIdGreaterThanEqual(Integer id);

    List<Question> findBySubjectLike(String subject);

    List<Question> findBySubjectIn(String[] subjects);

    Question findBySubjectOrderByCreateDateAsc(String subjects);
}
