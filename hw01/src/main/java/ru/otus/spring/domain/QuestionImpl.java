package ru.otus.spring.domain;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;

import java.util.ArrayList;
import java.util.List;

public class QuestionImpl implements Question {
    @CsvBindByName
    private int questionNumber;
    @CsvBindByName
    private String questionText;

    @CsvBindAndSplitByName(elementType = Integer.class, collectionType = ArrayList.class, splitOn = "\\|")
    private List<Integer> answersNumbers;
    @CsvBindAndSplitByName(elementType = String.class, collectionType = ArrayList.class, splitOn = "\\|")
    private List<String> answersText;
    @CsvBindAndSplitByName(elementType = Boolean.class, collectionType = ArrayList.class, splitOn = "\\|")
    private List<Boolean> isAnswerTrue;
    private List<Answer> answers;

    @Override
    public void determineAnswers() {
        answers = new ArrayList<>(answersNumbers.size());
        for (int i = 0; i < answersNumbers.size(); i++) {
            answers.add(new Answer(questionNumber, answersNumbers.get(i), answersText.get(i), isAnswerTrue.get(i)));
        }
    }

    @Override
    public int getQuestionNumber() {
        return questionNumber;
    }

    @Override
    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }
}
