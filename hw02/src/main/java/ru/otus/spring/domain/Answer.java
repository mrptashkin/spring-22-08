package ru.otus.spring.domain;

public class Answer {
    private final int questionNumber;
    private final int answerNumber;
    private final String answerText;
    private final boolean isAnswerTrue;

    public Answer(int questionNumber, int answerNumber, String answerText, boolean isAnswerTrue) {
        this.questionNumber = questionNumber;
        this.answerNumber = answerNumber;
        this.answerText = answerText;
        this.isAnswerTrue = isAnswerTrue;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public String getAnswerText() {
        return answerText;
    }

    public boolean isAnswerTrue() {
        return isAnswerTrue;
    }
}
