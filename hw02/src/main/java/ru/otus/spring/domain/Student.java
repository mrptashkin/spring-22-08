package ru.otus.spring.domain;

public class Student {
    private String name;

    private String surname;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNumberOfCorrectAnswers(int numberOfCorrectAnswers) {
        this.numberOfCorrectAnswers = numberOfCorrectAnswers;
    }

    private int numberOfCorrectAnswers;

    public int getNumberOfCorrectAnswers() {
        return numberOfCorrectAnswers;
    }

    public void increaseNumberOfCorrectAnswers() {
        numberOfCorrectAnswers++;
    }

    public String getFullName() {
        return surname + " " + name;
    }

    @Override
    public String toString() {
        return surname + " " + name + "\n\t Number of correct answers - " + numberOfCorrectAnswers;
    }


}
