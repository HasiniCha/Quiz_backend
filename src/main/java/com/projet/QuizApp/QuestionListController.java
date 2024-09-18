package com.projet.QuizApp;


import com.projet.QuizApp.QuestionList;
import com.projet.QuizApp.Service.QuestionListService;
import com.projet.QuizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.projet.QuizApp.Service.QuestionService;
@RestController
@RequestMapping("/api/question-lists")
public class QuestionListController {
    private QuestionService questionService;

    @Autowired
    private QuestionListService questionListService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<QuestionList> getAllLists() {
        return questionListService.getAllLists();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<QuestionList> getListById(@PathVariable Long id) {
        Optional<QuestionList> questionList = questionListService.getListById(id);
        return questionList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public QuestionList createList(@RequestBody QuestionList questionList) {
        return questionListService.createList(questionList);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public ResponseEntity<QuestionList> updateList(@PathVariable Long id, @RequestBody QuestionList updatedList) {
        try {
            return ResponseEntity.ok(questionListService.updateList(id, updatedList));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable Long id) {
        questionListService.deleteList(id);

        return ResponseEntity.noContent().build();
    }
}
