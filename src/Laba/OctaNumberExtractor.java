package Laba;

public class OctaNumberExtractor implements Runnable{
    private volatile RandomGenerator generator;
    private volatile Buffer buffer;
    public OctaNumberExtractor(Buffer b, RandomGenerator g){
        this.buffer = b;
        this.generator = g;
    }

    @Override
    public void run() {
        while (generator.getIndex() < generator.MAX_ITERATION){
            StringBuilder builder = new StringBuilder();
            synchronized (buffer) {
                for (int i : buffer.getData()) {
                    builder.append(i);
                }
                System.out.println("Поток 2 - конвертирую в 10-ую сс - " + buffer + " - " + Integer.parseInt(builder.toString(), 8));
                buffer.clear();
                buffer.notify();
                try {
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
