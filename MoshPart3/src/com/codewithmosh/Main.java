package com.codewithmosh;

import com.codewithmosh.executors.FlightService;
import com.codewithmosh.executors.LongTask;
import com.codewithmosh.executors.Quote;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        LocalTime start = LocalTime.now();
        FlightService flightService = new FlightService();

        List<CompletableFuture> list = flightService.getQuotes()
                                            .map((future) -> future.thenAccept(System.out::println))
                                            .collect(Collectors.toList());

        CompletableFuture
                .allOf(list.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    LocalTime end = LocalTime.now();
                    Duration duration = Duration.between(start, end);
                    long temp = duration.toMillis();

                    System.out.println("Calls were retrieved in a total time of " + temp + "ms !");

                });


    }
}
