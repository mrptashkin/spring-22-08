package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.control.QuestionParser;
import ru.otus.spring.service.TestRunner;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionParser questionParser = context.getBean(QuestionParser.class);
        TestRunner.run(context,questionParser);
    }
}
