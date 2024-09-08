package com.projet.QuizApp;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "programming_questions")
    public class ProgrammingQuestion {


        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;

        private String question;


        private String optionA;


        private String optionB;


        private String optionC;


        private String optionD;


        private char answer;

    public static class UserEntity {
    }
}
