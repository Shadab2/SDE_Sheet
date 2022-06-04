package DAY13;

import java.util.Arrays;

public class stack_using_arrays<T> {
    private T[] stack;
    private int index;
    private int capacity;

    public stack_using_arrays() {
        capacity = 16;
        stack = (T[]) new Object[capacity];
        index = -1;
    }

    public void push(T item) {
        if (index == capacity) {
            T[] temp = (T[]) new Object[capacity * 2];
            for (int i = 0; i < capacity; i++)
                temp[i] = stack[i];
            stack = temp;
            capacity = capacity * 2;
        }
        stack[++index] = item;
    }

    public T pop() {
        if (index == -1)
            return null;
        T ret = stack[index--];
        stack[index + 1] = null;
        if (index == capacity / 4) {
            T[] temp = (T[]) new Object[capacity / 2];
            for (int i = 0; i <= index; i++)
                temp[i] = stack[i];
            stack = temp;
            capacity = capacity / 2;
        }
        return ret;
    }

    public T peek() {
        if (index == -1)
            return null;
        return stack[index];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public String toString() {
        if (index == -1)
            return "{}";
        String ret = "{";
        for (int i = 0; i < index - 1; i++)
            ret += stack[i] + ",";
        ret += stack[index - 1] + "}";
        return ret;
    }

    public static void main(String[] args) {
        stack_using_arrays<Integer> stack = new stack_using_arrays<>();
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(4);
        System.out.println(stack.pop());
        stack.pop();
        stack.push(11);

        System.out.println(stack.peek());
    }
}
