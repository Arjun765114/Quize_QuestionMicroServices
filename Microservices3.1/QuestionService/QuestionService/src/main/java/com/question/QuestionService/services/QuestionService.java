package com.question.QuestionService.services;

import com.question.QuestionService.entities.Question;

import java.util.List;

public interface QuestionService {

    Question add(Question question);

    Question getQuestion(Long id);

    List<Question> getAll();

    List<Question> getQuestionsOfQuiz(Long quizId);

}
