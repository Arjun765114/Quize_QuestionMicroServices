package com.question.QuestionService.controller;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Que")
public class QuestionController {

    @Autowired
   private QuestionService questionService;

    @PostMapping("/")
    public Question addQuestion(@RequestBody Question question){
        return questionService.add(question);
    }

    @GetMapping("/getall")
    public List<Question> getAllQuestion(){
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public Question question(@PathVariable Long id){
        return questionService.getQuestion(id);
    }

    //getallquestion of Specific quiz
  @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
        return questionService.getQuestionsOfQuiz(quizId);
    }
}
