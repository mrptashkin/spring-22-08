package ru.otus.spring.control;

import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Question;

public class QuestionOutputImpl implements QuestionOutput {
    @Override
    public void outputQuestion(Question question) {
        System.out.println();
        System.out.printf("%d. %s\n", question.getQuestionNumber(), question.getQuestionText());
        for (Answer answer : question.getAnswers()) {
            System.out.print("\t");
            System.out.printf("%d. %s\n", answer.getAnswerNumber(), answer.getAnswerText());
        }
    }
}
