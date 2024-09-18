package com.projet.QuizApp.Repository;

import com.projet.QuizApp.QuestionList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionListRepository extends JpaRepository<QuestionList, Long> {

}