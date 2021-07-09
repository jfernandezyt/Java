package com.company;

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

}

class Main {

    public static Node removeDuplicates(Node head) {

        try {
            if (head != null) {
                Node start = head;
                int last = start.data;
                while (start.next != null) {
                    //System.out.println("start data: " + start.data);
                    if (start.next.data != last) {
                        start = start.next;
                    } else {
                        //System.out.println("last: " + last);
                        Node temp = start.next;
                        while (temp.next != null) {
                            if (temp.next.data != last) {
                                start.next = temp.next;
                                break;
                            }
                            temp = temp.next;
                            if (temp.next == null) {
                                start.next = null;
                                return head;
                            }
                        }
                    }
                    last = start.data;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return head;
    }

    public static Node insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            Node start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }
    public static void doStuff(Animal animal){
        Animal animal1 = animal;
        Animal animal2 = animal1;
        Animal animal3 = animal2;
        System.out.println("animal: " + animal.getName());
        animal.setName("");
        System.out.println("animal: " + animal.getName());
        animal1.setName("animaldbjashbdas");
        System.out.println("animal: " + animal.getName());
        System.out.println("animal1: " + animal1.getName());
        animal2.setName("");
        System.out.println("animal: " + animal.getName());
        System.out.println("animal1: " + animal1.getName());
        System.out.println("animal2: " + animal2.getName());
        animal3.setName("poop");
        System.out.println("animal: " +animal.getName());
        System.out.println("animal1: " +animal1.getName());
        System.out.println("animal2: " +animal2.getName());
        System.out.println("animal3: " +animal3.getName());

    }

    public static void main(String args[]) {
        //Scanner sc = new Scanner(System.in);
//        Node head = null;
//        int T = sc.nextInt();
//
//        Random random = new Random();
//        for()
//        while (T-- > 0) {
//            int ele = sc.nextInt();
//            head = insert(head, ele);
//        }
//        head = removeDuplicates(head);
//        display(head);

        doStuff(new Dog("german", 3, 60, 4, "large", true, "wew", "brown"));

    }
}