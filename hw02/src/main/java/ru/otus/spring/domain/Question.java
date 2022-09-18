package ru.otus.spring.domain;

import java.util.List;

public interface Question {
    void determineAnswers();
    int getQuestionNumber();
    List<Answer> getAnswers();
    String getQuestionText();
}
