package Laba;

import java.util.Arrays;

public class Buffer{
    private final int SIZE = 4;
    private int[] data = new int[SIZE];
    private int index = SIZE - 1;

    public Buffer(){ }

    public void append(int oct){
        data[index] = oct;
        updateIndex();
    }

    private void updateIndex(){
        index--;
        if(index < 0)
            index = SIZE - 1;
    }

    public void clear(){
        index = SIZE - 1;
        Arrays.fill(data, 0);
    }

    public int[] getData(){
        return data;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
