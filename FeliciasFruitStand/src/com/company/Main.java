package com.company;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void displayProducts(List<Product> list){
        for (Product products: list ) {
            System.out.println(products);
        }
    }
    public static void displayProducts(List<Product> list, String type) {

        for (Product products : list) {
            switch (type) {
                case "Fruit":
                    if (products instanceof Fruit) {
                        System.out.println(products);
                    }
                    break;
                case "Meat":
                    if(products instanceof Meat){
                        System.out.println(products);
                    }
                    break;
                default:
                    break;
            }

        }
    }

    public static void displayProducts(List<Product> list, int i){
        System.out.println(list.get(i));
    }

    public static void main(String[] args) {
        List<Product> listOfProduct = new ArrayList<Product>();

        Fruit fruit1 = new Fruit("Strawberry",2.66,  false, 5, "red", true );
        Fruit fruit2 = new Fruit("Banana",3.69,  false, 10, "yellow", true);
        Fruit fruit3 = new Fruit("blueberries",1.75,  false, 15, "blue", true);

        Meat meat1 = new Meat("Moooooooo", 15, false, 7,"beef", "sirloin");
        Meat meat2 = new Meat("Gobble gobble gobble", 10.2, false, 12, "turkey", "whole");
        Meat meat3 = new Meat("bok bok", 7.89, false, 20, "chicken", "breast");

        listOfProduct.add(fruit1);
        listOfProduct.add(fruit2);
        listOfProduct.add(fruit3);
        listOfProduct.add(meat1);
        listOfProduct.add(meat2);
        listOfProduct.add(meat3);

        //displayProducts(listOfProduct);
        displayProducts(listOfProduct, "Meat");
        //displayProducts(listOfProduct, 4);

    }
}