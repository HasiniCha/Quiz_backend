package com.projet.QuizApp.Controller;

import com.projet.QuizApp.ProgrammingQuestion;
import com.projet.QuizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:8080")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Get all questions
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/AllQuestions")
    public List<ProgrammingQuestion> getAllQuestions() {
        return questionService.getAllQuestions();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list/{list_id}")
    public List<ProgrammingQuestion> getQuestionsByListId(@PathVariable Long list_id) {
        return questionService.getQuestionsByListId(list_id);
    }
    // Get question by ID
    @GetMapping("/{id}")
    public ProgrammingQuestion getQuestionById(@PathVariable("id") Long id) {
        return questionService.getQuestionById(id);
    }

    // Post a new question
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public ProgrammingQuestion addQuestion(@RequestBody ProgrammingQuestion programmingQuestion) {
        System.out.println(programmingQuestion);
        return questionService.addQuestion(programmingQuestion);
    }

    // Get answer to a specific question
    @GetMapping("/answer/{id}")
    public String getAnswer(@PathVariable("id") Long id) {
        return questionService.getAnswer(id);
    }

    // Update an existing question
    @PutMapping("/update/{id}")
    public ProgrammingQuestion updateQuestion(@PathVariable("id") Long id, @RequestBody ProgrammingQuestion programmingQuestion) {
        return questionService.updateQuestion(id, programmingQuestion);
    }

    // Delete a question by ID
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(@PathVariable("id") Long id) {
        questionService.deleteQuestion(id);
    }
}
