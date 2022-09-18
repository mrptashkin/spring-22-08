package ru.otus.spring.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.spring.control.QuestionParser;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.Result;
import ru.otus.spring.domain.StudentImpl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class TestRunner {
    public static void run(AnnotationConfigApplicationContext context, QuestionParser questionParser) throws FileNotFoundException {
        List<Question> questionsList = questionParser.getQuestions(context.getResource(questionParser.getResource()));
        StudentImpl student = new StudentImpl();
        testStudent(student, questionsList, questionParser);
        Result result = new Result(student);
        System.out.println(result);
    }

    private static void testStudent(StudentImpl student, List<Question> questionsList, QuestionParser questionParser) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n-------Run Test for %s-------\n", student.getFullName());
        for (Question question : questionsList) {
            questionParser.outputQuestion(question);
            int numberOfAnswers = question.getAnswers().size();
            int currentAnswer;
            while (true) {
                currentAnswer = scanner.nextInt();
                if (currentAnswer <= 0 || currentAnswer > numberOfAnswers) {
                    System.out.printf("You input incorrect number of answer! Try again! input values between %d and %d\n", 1, numberOfAnswers);
                } else break;
            }
            if (question.getAnswers().get(currentAnswer - 1).isAnswerTrue()) {
                student.increaseNumberOfCorrectAnswers();
            }
        }
        System.out.println("\n-------End of test-------\n");
    }
}
