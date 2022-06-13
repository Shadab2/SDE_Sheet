package DAY14;

import java.util.*;

public class stock_span {
    class StockSpanner {
        ArrayList<Integer> stock;
        ArrayDeque<Integer> stack;

        public StockSpanner() {
            stock = new ArrayList<>();
            stack = new ArrayDeque<>();
        }

        public int next(int price) {
            while (!stack.isEmpty() && stock.get(stack.peek()) <= price)
                stack.pop();
            int ret = stack.isEmpty() ? stock.size() + 1 : stock.size() - stack.peek();
            // please don't use add in deque it will work like poll
            stack.push(stock.size());
            stock.add(price);
            return ret;
        }
    }
}
