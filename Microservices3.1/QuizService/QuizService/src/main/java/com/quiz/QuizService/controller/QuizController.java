package com.quiz.QuizService.controller;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    //Create
    @PostMapping
    public Quiz addQuiz( @RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    //GetAll Data
    @GetMapping("/getall")
    public List<Quiz> getAll(){
        return quizService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Quiz getQuiz( @PathVariable Long id){
        return quizService.get(id);
    }
}
