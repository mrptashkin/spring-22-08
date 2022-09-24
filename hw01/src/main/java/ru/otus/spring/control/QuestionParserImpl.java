package ru.otus.spring.control;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.Resource;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.QuestionImpl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class QuestionParserImpl implements QuestionParser {

    private final String resource;

    public QuestionParserImpl(String resource) {
        this.resource = resource;
    }

    @Override
    public void outputQuestion(Question question) {
        System.out.println();
        System.out.printf("%d. %s\n", question.getQuestionNumber(), question.getQuestionText());
        for (Answer answer : question.getAnswers()) {
            System.out.print("\t");
            System.out.printf("%d. %s\n", answer.getAnswerNumber(), answer.getAnswerText());
        }
    }
    @Override
    public List<Question> getQuestions(Resource resource) {
        List<Question> questionList;
        questionList = new CsvToBeanBuilder<Question>(readQuestions(resource)).withType(QuestionImpl.class).build().parse();
        for (Question question : questionList) {
            question.determineAnswers();
        }
        return questionList;
    }

    public InputStreamReader readQuestions(Resource resource) {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(resource.getInputStream());
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        return inputStreamReader;
    }


    public String getResource() {
        return resource;
    }
}

