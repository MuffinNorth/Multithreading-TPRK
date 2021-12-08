package Laba;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        Buffer dataBuffer = new Buffer();
        RandomGenerator generator = new RandomGenerator(dataBuffer);
        OctaNumberExtractor extractor = new OctaNumberExtractor(dataBuffer, generator);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(generator);
        executor.submit(extractor);
        executor.shutdown();
    }
}
