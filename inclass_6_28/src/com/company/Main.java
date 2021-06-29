package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Animal> list = new ArrayList<>();

        DayCare.addAnimal(new Dog("german shepard", 3, 25, 4, "Medium", true, "sheppy", "blackish-brownish"), list);
        DayCare.addAnimal(new Cat("spots", true, false, 4, "Medium", true, "spots", "blackish-brownish"), list);
        DayCare.addAnimal(new Dog("shihtzu", 2, 5, 4, "Small", true, "shorty", "white"), list);
        DayCare.addAnimal(new Dog("poodle", 1, 13, 4, "Medium", true, "poofy", "black"), list);
        DayCare.addAnimal(new Cat("solid", false, true, 4, "small", true, "harry", "orange"), list);

        DayCare.displayAnimal(list);
        DayCare.removeAnimal("shorty", list);
        DayCare.displayAnimal(list);
    }
}
