package DAY13;

// tags : Implementation 
import java.util.*;

public class implement_queue_using_stack {
    class MyQueue {
        private Deque<Integer> cache;
        private Deque<Integer> stack;

        public MyQueue() {
            cache = new ArrayDeque<>();
            stack = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            if (!cache.isEmpty())
                return cache.pop();
            while (!stack.isEmpty())
                cache.push(stack.pop());
            return cache.pop();
        }

        public int peek() {
            if (!cache.isEmpty())
                return cache.peek();
            while (!stack.isEmpty())
                cache.push(stack.pop());
            return cache.peek();
        }

        public boolean empty() {
            return cache.isEmpty() && stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        implement_queue_using_stack imp = new implement_queue_using_stack();
        implement_queue_using_stack.MyQueue mq = imp.new MyQueue();
        for (int i = 0; i < 10; i++)
            mq.push(i * i);
        for (int i = 0; i < 5; i++)
            System.out.println(mq.pop());

    }
}
