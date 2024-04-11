package com.quiz.QuizService.services;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;
    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
       List<Quiz> quizzes = quizRepository.findAll();
     List<Quiz> newQuizList= quizzes.stream().map(quiz -> {
           quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
           return quiz;
     }).collect(Collectors.toList());
        return newQuizList ;
    }

    @Override
    public Quiz get(Long id) {
         Quiz quiz= quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found"));
         quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
         return quiz;
    }
}
