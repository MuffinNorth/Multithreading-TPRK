package Laba;

import java.util.Random;

public class RandomGenerator implements Runnable{
    public final int MAX_ITERATION = 100000;
    private volatile int index;
    private volatile Buffer buffer;

    public RandomGenerator(Buffer b){
        this.buffer = b;
    }

    public int getIndex(){
        return index;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        for (index = 0; index < MAX_ITERATION; index++) {
            synchronized (buffer){
                buffer.append(rnd.nextInt(8));
                System.out.println("Поток 1 - генерирую число - " + buffer);
            }
        }
    }
}
