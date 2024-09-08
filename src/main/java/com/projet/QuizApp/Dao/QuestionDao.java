package com.projet.QuizApp.Dao;

import com.projet.QuizApp.ProgrammingQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<ProgrammingQuestion, Long> {
    // Additional query methods (if needed) can be defined here
}
