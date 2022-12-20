package stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private final int INITIAL_CAPACITY = 10;
    private int top = -1;
    private T[] list = null;
    private int index;
    public Stack() {
        //Initial Capacity
        this(10);
    }
    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        int[][] ranges = new int[2][2];
        Arrays.sort(ranges, (o1, o2) -> Integer.compare(o1[0],o1[0]));
        if (capacity <= 0) {
            throw new IllegalArgumentException("Value Cannot be less or equal to 0.");
        }
        list = (T[])(new Object[capacity]);
    }

    public T push(T value) {
        if (top < list.length - 1) {
            list[++top] = value;
            return list[top];
        }else {
            //Increasing the size
            resize(list.length * 2);
            list[++top] = value;
            return list[top];
        }
    }

    public T pop() {
        if (top >= 0) {
            return list[top--];
        }else {
            throw new IllegalCallerException("Stack Underflow");
        }
    }

    private void resize(int newSize) {
        T[] newList = (T[])(new Object[newSize]);
        System.arraycopy(list, 0, newList, 0, list.length);
        list = newList;
    }

    @Override
    public Iterator<T> iterator() {
        index = 0;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return index <= top;
            }

            @Override
            public T next() {
                return list[index++];
            }
        };
    }
}
