package com.projet.QuizApp.Service;

import com.projet.QuizApp.Dao.QuestionDao;
import com.projet.QuizApp.ProgrammingQuestion;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    // Retrieve all questions
    public List<ProgrammingQuestion> getAllQuestions() {
        return questionDao.findAll();
    }

    // Retrieve a specific question by ID
    public ProgrammingQuestion getQuestionById(Long id) {
        Optional<ProgrammingQuestion> question = questionDao.findById(id);
        return question.orElse(null);
    }
    public List<ProgrammingQuestion> getQuestionsByListId(Long list_id) {
        return questionDao.findByListId(list_id);
    }

    // Add a new question
    public ProgrammingQuestion addQuestion(ProgrammingQuestion programmingQuestion) {
        return questionDao.save(programmingQuestion);
    }

    // Retrieve the correct answer for a specific question by ID
    public String getAnswer(Long id) {
        Optional<ProgrammingQuestion> question = questionDao.findById(id);
        return question.map(q -> String.valueOf(q.getAnswer())).orElse("Question not found");
    }

    // Update an existing question
    public ProgrammingQuestion updateQuestion(Long id, ProgrammingQuestion updatedQuestion) {
        Optional<ProgrammingQuestion> existingQuestion = questionDao.findById(id);
        if (existingQuestion.isPresent()) {
            ProgrammingQuestion question = existingQuestion.get();
            question.setQuestion(updatedQuestion.getQuestion());
            question.setOptionA(updatedQuestion.getOptionA());
            question.setOptionB(updatedQuestion.getOptionB());
            question.setOptionC(updatedQuestion.getOptionC());
            question.setOptionD(updatedQuestion.getOptionD());
            question.setAnswer(updatedQuestion.getAnswer());
            return questionDao.save(question);
        } else {
            return null;
        }
    }

    // Delete a question by ID
    public void deleteQuestion(Long id) {
        questionDao.deleteById(id);
    }

    public void deleteQuestionsByListId(Long listId) {

        questionDao.deleteByListId(listId);
    }

}
