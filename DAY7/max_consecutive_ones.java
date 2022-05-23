package DAY7;

// tags : Easy 
public class max_consecutive_ones {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxCount = 0;
        for (int num : nums) {
            if (num != 0)
                count++;
            else
                count = 0;
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
