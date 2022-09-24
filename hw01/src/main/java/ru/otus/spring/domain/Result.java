package ru.otus.spring.domain;

public class Result {
    private final StudentImpl student;
    private final boolean isTestPassed;

    public Result(StudentImpl student) {
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
            return string + "\n" +fail;
        }
    }
}
