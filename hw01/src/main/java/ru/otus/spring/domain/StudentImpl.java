package ru.otus.spring.domain;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentImpl implements Student {
    private final String name;

    private final String surname;

    private int numberOfCorrectAnswers;

    public int getNumberOfCorrectAnswers() {
        return numberOfCorrectAnswers;
    }

    public void increaseNumberOfCorrectAnswers() {
        numberOfCorrectAnswers++;
    }


    public StudentImpl() {
        numberOfCorrectAnswers = 0;
        Scanner scanner = new Scanner(System.in);
        String inputSurname;
        String inputName;

        do {
            System.out.println("Input  your surname:");
            inputSurname = scanner.nextLine();
        } while (checkStudent(inputSurname));
        surname = inputSurname;
        do {
            System.out.println("Input your name:");
            inputName = scanner.nextLine();
        } while (checkStudent(inputName));
        name = inputName;
    }

    @Override
    public String toString() {
        return surname + " " + name + "\n\t Number of correct answers - " + numberOfCorrectAnswers;
    }

    @Override
    public String getFullName() {
        return surname + " " + name;
    }

    @Override
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
