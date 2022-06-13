package DAY14;

public class min_stack {

    // Approach #1
    // use LinkedList type implementation and just add min property to the nodes and
    // update it on push elements to the stack
    class MinStack {
        StackNode top;

        public MinStack() {
            top = new StackNode(0, Integer.MAX_VALUE, null);
        }

        public void push(int val) {
            StackNode next = new StackNode(val, Math.min(val, top.min), top);
            next.next = top;
            top = next;
        }

        public void pop() {
            top = top.next;
        }

        public int top() {
            return top.value;
        }

        public int getMin() {
            return top.min;
        }
    }

    class StackNode {
        int value, min;
        StackNode next;

        public StackNode(int value, int min, StackNode next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }
}
