package ru.otus.spring.domain;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentInitializer {

    public Student initializeStudent() {
        Student student = new Student();
        student.setNumberOfCorrectAnswers(0);
        Scanner scanner = new Scanner(System.in);
        String inputSurname;
        String inputName;

        do {
            System.out.println("Input  your surname:");
            inputSurname = scanner.nextLine();
        } while (checkStudent(inputSurname));
        student.setSurname(inputSurname);
        do {
            System.out.println("Input your name:");
            inputName = scanner.nextLine();
        } while (checkStudent(inputName));
        student.setName(inputName);
        return student;
    }


    public boolean checkStudent(String string) {
        String regex = "[A-Z][a-z]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        if (!matcher.matches()) {
            System.out.println("Enter the name in capital letter and without digits and special symbols");
        }
        return !matcher.matches();
    }

}
