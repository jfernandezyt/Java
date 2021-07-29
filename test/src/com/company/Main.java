package com.company;

import java.util.*;

//class Node {
//    int data;
//    Node next;
//
//    Node(int d) {
//        data = d;
//        next = null;
//    }
//
//}

class Main {
    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        Map<String, Integer> magazineMap = new HashMap<>();
        Map<String, Integer> noteMap = new HashMap<>();

        for(String element: magazine){
            if(!magazineMap.containsKey(element)){
                magazineMap.put(element, 1);
            }else{
                magazineMap.put(element, magazineMap.get(element) + 1);
            }
        }

        for(String noteElement : note){
            if(!magazineMap.containsKey(noteElement)){
                System.out.println("No");
                return;
            }else{
                if(magazineMap.get(noteElement) < 1){
                    System.out.println("No");
                    return;
                }else{
                    magazineMap.put(noteElement, magazineMap.get(noteElement) - 1);
                }
            }
        }
        System.out.println("Yes");

    }

    //    public static Node removeDuplicates(Node head) {
//
//        try {
//            if (head != null) {
//                Node start = head;
//                int last = start.data;
//                while (start.next != null) {
//                    //System.out.println("start data: " + start.data);
//                    if (start.next.data != last) {
//                        start = start.next;
//                    } else {
//                        //System.out.println("last: " + last);
//                        Node temp = start.next;
//                        while (temp.next != null) {
//                            if (temp.next.data != last) {
//                                start.next = temp.next;
//                                break;
//                            }
//                            temp = temp.next;
//                            if (temp.next == null) {
//                                start.next = null;
//                                return head;
//                            }
//                        }
//                    }
//                    last = start.data;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return head;
//    }
//
//    public static Node insert(Node head, int data) {
//        Node p = new Node(data);
//        if (head == null)
//            head = p;
//        else if (head.next == null)
//            head.next = p;
//        else {
//            Node start = head;
//            while (start.next != null)
//                start = start.next;
//            start.next = p;
//
//        }
//        return head;
//    }
//
//    public static void display(Node head) {
//        Node start = head;
//        while (start != null) {
//            System.out.print(start.data + " ");
//            start = start.next;
//        }
//    }
//    public static void doStuff(Animal animal){
//        Animal animal1 = animal;
//        Animal animal2 = animal1;
//        Animal animal3 = animal2;
////        System.out.println("animal: " + animal.getName());
////        animal.setName("");
////        System.out.println("animal: " + animal.getName());
////        animal1.setName("animaldbjashbdas");
////        System.out.println("animal: " + animal.getName());
////        System.out.println("animal1: " + animal1.getName());
////        animal2.setName("");
////        System.out.println("animal: " + animal.getName());
////        System.out.println("animal1: " + animal1.getName());
////        System.out.println("animal2: " + animal2.getName());
////        animal3.setName("poop");
////        System.out.println("animal: " +animal.getName());
////        System.out.println("animal1: " +animal1.getName());
////        System.out.println("animal2: " +animal2.getName());
////        System.out.println("animal3: " +animal3.getName());
//        for (int i =0; i < 3; i++){
//            Animal temp = animal;
//            if(i == 0){
//                temp.setName("1");
//                System.out.println(animal1.getName());
//                System.out.println("temp     " +temp.getName());
//                animal = new Dog("poodle", 3, 60, 4, "medium", true, "wew", "black");
//            }else if(i == 1){
//                temp.setName("2");
//                System.out.println(animal1.getName());
//                System.out.println("temp        " +temp.getName());
//            }else if (i == 2){
//                temp.setName("3");
//                System.out.println(animal1.getName());
//                System.out.println("temp       " +temp.getName());
//            }
//        }
//
//    }
    private static String stringRepresentingDice(int[] values){
        String top = "┌───┐";
        String mid = "│ %s │";
        String bottom = "└───┘";
        String tempTop = "";
        String tempMid = "";
        String tempBottom = "";
        for(int i = 0; i < (values.length); i++){
            tempTop += top + " ";
            if(i ==0){
                tempMid = String.format(mid, values[i]) + " ";
            }else{
                tempMid += String.format(mid, values[i]) + " ";
            }
            tempBottom += bottom + " ";

        }
        return tempTop + "\n" + tempMid + "\n" + tempBottom;
//        String temp = "┌───┐   ┌───┐   ┌───┐   ┌───┐   ┌───┐\n";
//        temp += "│ %s │   │ %s │   │ %s │   │ %s │   │ %s │\n";
//        temp += "└───┘   └───┘   └───┘   └───┘   └───┘";
//        temp = String.format(temp, values[0], values[1], values[2], values[3], values[4]);
//        return temp;
    }
    public static void main(String args[]) {
        int[] array = new int[5];
        array[0] = 3;
        array[1] = 1;
        array[2] = 5;
        array[3] = 3;
        array[4] = 2;
        System.out.println(stringRepresentingDice(array));
    }
}