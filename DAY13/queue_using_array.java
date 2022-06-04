package DAY13;

import java.util.Arrays;

public class queue_using_array<T> {
    private int front, rear;
    private int capacity;
    private int size;
    private T q[];

    // intialize rear with -1 and add item as (rear+1)%capacity
    public queue_using_array() {
        capacity = 4;
        rear = -1;
        q = (T[]) new Object[capacity];
    }

    private void resize(int factor) {
        T[] temp = (T[]) new Object[capacity * factor];
        for (int i = 0; i < capacity; i++, front++)
            temp[i] = q[front % capacity];
        front = 0;
        rear = capacity - 1;
        q = temp;
        capacity *= factor;
    }

    public void offer(T item) {
        if (size == capacity)
            resize(2);
        rear = (rear + 1) % capacity;
        q[rear] = item;
        size++;
    }

    public T poll() {
        if (size == 0)
            return null;
        T ret = q[front];
        front = (front + 1) % capacity;
        size--;
        return ret;
    }

    public String toString() {
        if (size == 0)
            return "{}";
        String ret = "{";
        for (int i = front; i < rear; i = (i + 1) % capacity)
            ret += q[i] + ",";
        ret += q[rear] + "}";
        return ret;
    }

    public static void main(String[] args) {
        queue_using_array<Integer> q = new queue_using_array<>();
        q.offer(4);
        q.offer(3);
        q.offer(50);

        q.offer(50);
        q.offer(50);
        q.offer(10);
        q.offer(10);
        q.offer(10);
        q.offer(10);
        for (int i = 0; i < 10; i++)
            System.out.println(q.poll());
        q.offer(11);
        System.out.println(q.poll());
    }
}
