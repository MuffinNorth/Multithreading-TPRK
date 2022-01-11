package Laba;

import java.util.Arrays;

public class Buffer{
    public final int SIZE = 4;
    private int[] data = new int[SIZE];

    public int getIndex() {
        return index;
    }

    private int index = SIZE - 1;

    public Buffer(){ }

    public void append(int oct){
        if(index < 0)
            index = SIZE - 1;
        data[index] = oct;
        index--;
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
