package DAY3;

import java.util.*;

// tags : Implementation , Algorithms , Medium
public class majority_elementII {

    // the idea is to extend the majority voting algo for 2 elements as most 2
    // elements can have n/3 freq
    // we will calculate two most significant elements

    public List<Integer> majorityElement(int[] nums) {
        int f1 = 0, f2 = 0, m1 = 0, m2 = 1;
        for (int x : nums) {
            // important to check first for the elements
            // order of if else is very important
            if (x == m1)
                f1++;
            else if (x == m2)
                f2++;
            else if (f1 == 0) {
                f1++;
                m1 = x;
            } else if (f2 == 0) {
                f2++;
                m2 = x;
            } else {
                f1--;
                f2--;
            }
        }
        f1 = f2 = 0;
        // by this time check if two majority elements have freq greater than n/3 or not
        for (int x : nums) {
            if (x == m1)
                f1++;
            else if (x == m2)
                f2++;
        }
        List<Integer> ans = new ArrayList<>();
        if (f1 > nums.length / 3)
            ans.add(m1);
        if (f2 > nums.length / 3)
            ans.add(m2);
        return ans;

    }
}
