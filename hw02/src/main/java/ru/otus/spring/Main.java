package ru.otus.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.config.TestConfig;
import ru.otus.spring.control.QuestionParser;
import ru.otus.spring.service.TestRunner;

import java.io.FileNotFoundException;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        QuestionParser questionParser = context.getBean(QuestionParser.class);
        TestRunner testRunner = new TestRunner(context, questionParser);
        testRunner.run();
    }
}
