package com.company;

import java.util.List;

public class DayCare {

    public static void addAnimal(Animal animal, List<Animal> list){
        list.add(animal);
    }
    public static void displayAnimal(List<Animal> list){
        for (Animal animal: list ) {
            if(animal instanceof Dog){
                System.out.println("This is a Dog !");
                animal.speak();
            }else if(animal instanceof Cat){
                System.out.println("This is a Cat !");
                animal.speak();

            }
        }
    }

    public static void removeAnimal(String name, List<Animal> list){
        for (Animal animal: list) {
            if(animal.getName().equals(name)){
                list.remove(animal);
                break;
            }
        }
    }
}
