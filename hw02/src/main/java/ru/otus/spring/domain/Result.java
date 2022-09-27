package ru.otus.spring.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Result {
    private Student student;
    private boolean isTestPassed;


    public void checkResult(Student student) {
        this.student = student;
        int limit = 3;
        isTestPassed = student.getNumberOfCorrectAnswers() >= limit;
    }

    @Override
    public String toString() {
        String string = "Result of student:\n\t" + student;
        String success = "You passed this test";
        String fail = "You failed this test";
        if (isTestPassed) {
            return string + "\n" + success;
        } else {
            return string + "\n" + fail;
        }
    }


}
