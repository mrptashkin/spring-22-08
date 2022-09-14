package ru.otus.spring.control;

import org.springframework.core.io.Resource;
import ru.otus.spring.domain.Question;

import java.io.FileNotFoundException;
import java.util.List;

public interface QuestionParser {

    List<Question> getQuestions(Resource resource) throws FileNotFoundException;
    String getResource();

}
