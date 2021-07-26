package com.company;

public class LinkedList {
    private class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node first;
    private Node last;

    // addFirst
    // addLast
    // deleteFirst
    // deleteLast
    // contains
    // indexOf

    public void addFirst(int item) {
        Node node = new Node(item);
        if(isEmpty())
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
    }

    public void addLast(int item) {
        Node node = new Node(item);

        if(isEmpty()){
            first = last = node;
        }else{
            last.next = node;
            last = node;
        }
    }

    public void deleteFirst() {
        first = first.next;
    }

    public void deleteLast() {
        Node current = first;
        Node previous = null;

        if(first == last){
            first = last = null;
            return;
        }

        while (current != null) {
            if(current.next == null){
                previous.next = null;
                last = previous;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public boolean contains(int find) {
        Node current = first;

        while (current != null) {
            if (current.value == find) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf(int find) {
        Node current = first;
        int counter = 0;

        while (current != null) {
            if (current.value == find) {
                return counter;
            }
            current = current.next;
            counter++;
        }
        return -1;
    }

    private boolean isEmpty(){
        return first == null;
    }

}
