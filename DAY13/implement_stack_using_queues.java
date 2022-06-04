package DAY13;

import java.util.*;

public class implement_stack_using_queues {
    // the idea is to maintain other queue which will
    class MyStack {
        private Deque<Integer> cache;
        private Deque<Integer> stack;
        private int top;

        public MyStack() {
            cache = new ArrayDeque<>();
            stack = new ArrayDeque<>();
            top = -1;
        }

        public void push(int x) {
            stack.add(x);
            top = x;
        }

        // we will pop every element of the stack other than the last element since that
        // element is actually the top element for the stack
        // update top meanwhile
        public int pop() {
            int x = top();
            while (stack.size() > 1) {
                top = stack.poll();
                cache.offer(top);
            }
            stack.poll();
            // swap the temp with stack
            Deque<Integer> temp = stack;
            stack = cache;
            cache = temp;
            return x;
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return stack.size() == 0;
        }
    }

}
