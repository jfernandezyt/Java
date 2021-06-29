package com.company;

class Person {
    public String name;
    private String job;
    private int legs = 2;
    private int arms = 2;

    public Person() {

    }

    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getProfession() {
        return job;
    }

    public int getArms() {
        return arms;
    }

    public int getLegs() {
        return legs;
    }

    public String tellAJoke() {
        return "Why did the bike fall over ? It was two tired";
    }
}

class Adult extends Person {
    public Adult(String name, String job) {
        super(name, job);
    }

    public String getLimbs() {
        return name + " has " + getLegs() + " legs and " + getArms() + " arms";
    }
}

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("Joel", "Uber");
        Adult person2 = new Adult("Arnell", "CEO");

        System.out.println(person2.tellAJoke());
        System.out.println(person2.getProfession());
        System.out.println(person2.getLimbs());

        System.out.println(person1.getProfession());

    }
}
