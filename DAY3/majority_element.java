package DAY3;

// tags : Implementation , Boyere-moore , Easy
public class majority_element {
    public int majorityElement(int[] nums) {
        int freq = 0, m = 0;
        for (int x : nums) {
            if (freq == 0) {
                freq++;
                m = x;
            } else if (x == m)
                freq++;
            else
                freq--;
        }
        return m;
    }
}
