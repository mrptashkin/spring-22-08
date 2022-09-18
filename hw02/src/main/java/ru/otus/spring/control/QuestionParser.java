package ru.otus.spring.control;

import org.springframework.core.io.Resource;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.QuestionImpl;

import java.io.FileNotFoundException;
import java.util.List;

public interface QuestionParser {

    List<Question> getQuestions(Resource resource) throws FileNotFoundException;
    void outputQuestion (Question question);
    String getResource();

}
