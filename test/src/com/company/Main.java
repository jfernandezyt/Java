package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Main {
    public static void updateIndices(int first, int second, int third, int fourth, int fifth, int sixth, int seventh){
        if(third < 5 && seventh < 5){
            ++first;
            ++second;
            ++third;
            ++fourth;
            ++fifth;
            ++sixth;
            ++seventh;
        }else{
            first = 0;
            second = 1;
            third = 2;
            fourth = 1;
            fifth = 0;
            sixth = 1;
            seventh = 2;
        }
    }

    public static int sumAnHourglass(List<List<Integer>> arr, int first, int second, int third, int fourth, int fifth, int sixth, int seventh){
        for (int i = 0; i < arr.size(); i++){
            List<Integer> temp = arr.get(i);
            for (int j=0; j< temp.size(); j++){
            }
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        int firstIndex = 0;
        int secondIndex = 1;
        int thirdIndex = 2;
        int fourthIndex = 1;
        int fifthIndex = 0;
        int sixthIndex = 1;
        int seventhIndex = 2;
        for(int i = 0; i < 17; i++){
            if(i !=0){
                updateIndices(firstIndex, secondIndex, thirdIndex, fourthIndex, fifthIndex, sixthIndex, seventhIndex);
            }
        }


    }
}
