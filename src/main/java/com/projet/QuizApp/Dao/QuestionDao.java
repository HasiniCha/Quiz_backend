package com.projet.QuizApp.Dao;

import com.projet.QuizApp.ProgrammingQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<ProgrammingQuestion, Long> {
    List<ProgrammingQuestion> findByListId(Long list_id);
    void deleteByListId(Long listId);
}
