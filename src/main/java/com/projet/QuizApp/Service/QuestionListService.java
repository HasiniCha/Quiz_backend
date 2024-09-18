package com.projet.QuizApp.Service;

import com.projet.QuizApp.QuestionList;
import com.projet.QuizApp.Repository.QuestionListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionListService {

    @Autowired
    private QuestionListRepository questionListRepository;

    public List<QuestionList> getAllLists() {
        return questionListRepository.findAll();
    }

    public Optional<QuestionList> getListById(Long id) {
        return questionListRepository.findById(id);
    }

    public QuestionList createList(QuestionList questionList) {
        return questionListRepository.save(questionList);
    }

    public void deleteList(Long id) {
        questionListRepository.deleteById(id);
    }

    public QuestionList updateList(Long id, QuestionList updatedList) {
        return questionListRepository.findById(id)
                .map(list -> {
                    list.setName(updatedList.getName());
                    list.setQuestions(updatedList.getQuestions());
                    return questionListRepository.save(list);
                }).orElseThrow(() -> new RuntimeException("List not found with id " + id));
    }
}
