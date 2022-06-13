package DAY14;

import java.util.Arrays;
import java.util.Stack;

// Stack , Observation , Hard
public class maxmimum_of_minimum_of_every_windowsize {

    // Approach , any element who is the minimum in a certain range , for window
    // size of such range , we will take maximum
    // suppose [10,3,52,5,9] => 5 is minimum in [2,4] ie. no element in the array
    // having a range of 3 would be ans for this window as there would be some other
    // smaller value in that range already
    // so here the answer of window size 3 would be 5
    // lets add [10,3,52,5,9,13,20]
    // now 9 is also a minmum in the range of 3 , so we will take the maximum of
    // potential candidates for size[i], here max of(9,5)
    // also for every window size j such that j < i , we would be getting the ans as
    // the max of ans[i] and ans[j]
    // lets take the array of [10,3,52,5,6,9,13,20,1,4,3]
    // here , 4 is minimum of window size 2 but for window size 3 we have max of
    // minimum as 9 as 9 is alread a minumum of window size 3 , so for some window
    // of window size 2 9 will get selected and now we will have maximum of 9 and 4
    // , so 9
    static int[] maxOfMin(int[] arr, int n) {
        // Your code here
        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int maxWindow[] = new int[n];
        for (int i = 0; i < n; i++) {
            int size = right[i] - left[i] - 1;
            maxWindow[size - 1] = Math.max(maxWindow[size - 1], arr[i]);
        }
        // check if we already have maximum ans for higher window size , as any higher
        // value in higher window size will gets automatiaclly selected for lower window
        // size
        for (int i = n - 2; i >= 0; i--) {
            maxWindow[i] = Math.max(maxWindow[i + 1], maxWindow[i]);
        }
        return maxWindow;

    }

    public static void main(String[] args) {
        int arr[] = { 10, 3, 52, 5, 6, 9, 13, 20, 1, 4, 3 };
        System.out.println(Arrays.toString(maxOfMin(arr, arr.length)));
    }
}
