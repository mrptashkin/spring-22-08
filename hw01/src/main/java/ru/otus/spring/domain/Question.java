package ru.otus.spring.domain;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;

import java.util.ArrayList;
import java.util.List;

public class Question {
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


    @Override
    public String toString() {

        return "\nВопрос:\n" + questionText + '\n' + "Ответы:\n" + answersText + "\n";
    }

}
