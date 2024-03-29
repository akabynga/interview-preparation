package com.akabynga.multithreading.countdownlatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class BrokenWorkerDemo {
    public static void main(String[] args) throws InterruptedException {
        List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(5);
        List<Thread> workers = Stream
                .generate(() -> new Thread(new BrokenWorker(outputScraper, countDownLatch)))
                .limit(5)
                .toList();

        workers.forEach(Thread::start);
        boolean completed = countDownLatch.await(3L, TimeUnit.SECONDS);
        System.out.println(completed);
        System.out.println(outputScraper);
    }
}
