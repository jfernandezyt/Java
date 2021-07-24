package com.company;
import java.util.*;

public class Main {
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

    public static void main(String[] args) {
//        Magazine test cases:
//        Arrays.asList("two", "times", "three", "is", "not", "four");
//        Arrays.asList("ive", "got", "a", "lovely", "bunch", "of", "coconuts");

//        Note test cases:
//        Arrays.asList("two", "times", "two", "is", "four");
//        Arrays.asList("ive", "got", "some", "coconuts");
        List<String> magazine = new ArrayList<>(Arrays.asList("give", "me", "one", "grand", "today", "night"));
        List<String> note = new ArrayList<>(Arrays.asList("give","one", "grand", "today"));

        checkMagazine(magazine, note);
    }
}
