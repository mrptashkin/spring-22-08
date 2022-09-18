package ru.otus.spring.control;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.Resource;
import ru.otus.spring.domain.Question;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionParserImpl implements QuestionParser {

    private final String resource;

    public QuestionParserImpl(String resource) {
        this.resource = resource;
    }

    @Override
    public List<Question> getQuestions(Resource resource) {
        List<Question> questionList = new ArrayList<>();
        try (InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream())) {
            questionList = new CsvToBeanBuilder<Question>(inputStreamReader).withType(Question.class).build().parse();
            Collections.shuffle(questionList);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        return questionList;
    }

    public String getResource() {
        return resource;
    }
}

