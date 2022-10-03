package DAY1;

import java.util.*;

class next_permutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 2;
        while (i >= 0) {
            // find the first element which is greater than it's following element
            if (nums[i + 1] > nums[i]) {
                int j = n - 1;
                while (j > i && nums[j] <= nums[i])
                    j--;
                // nums[i] should be replaced by an immediate greater element so to assure next
                // permuatation
                swap(nums, i, j);
                break;
            }
            i--;
        }
        // as till ith element the order is maintained as in decreasing order , we
        // should simply
        // reverse it to get the next permuation
        while (++i < --n)
            swap(nums, i, n);
    }

    public void swap(int arr[], int i, int j) {
        int term = arr[i];
        arr[i] = arr[j];
        arr[j] = term;
    }

}

// -------------------------------------------------------------------------

class best_time_to_buy_and_sell_stock_1 {
    // try to buy on the lowest and sell at the highest
    public int maxProfit(int[] prices) {
        int minR = prices[0], maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minR);
            minR = Math.min(minR, prices[i]);
        }
        return maxProfit;
    }
}

// --------------------------------------------------------------------

class maximum_subarray {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            maxSoFar = Math.max(maxSoFar, sum);
            sum = Math.max(sum, 0);
        }
        return maxSoFar;
    }
}

// -----------------------------------------------------------------------

class pascals_triangle {

    // using extra space
    public List<List<Integer>> generate(int numRows) {
        int arr[][] = new int[numRows][numRows];
        List<List<Integer>> list = new ArrayList<>();
        arr[0][0] = 1;
        list.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                arr[i][j] = arr[i - 1][j];
                if (j > 0)
                    arr[i][j] += arr[i - 1][j - 1];
                l.add(arr[i][j]);
            }
            list.add(l);
        }
        return list;
    }

    // without using extra space
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;

    }
}

// ----------------------------------------------------------------

class Set_Matrix_Zeroes {

    // the idea is to use 0th row to check whether a particular column would be
    // filled with zero or not
    // the 0th column will decide accordingly for rows
    // we have to handle edge case arr[0][0] as it represents ambiguity

    public void setZeroes(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        boolean colZero = false;

        for (int i = 0; i < m; i++) {
            // check if 0th columns needs to be filled with zeroes or not
            colZero |= arr[i][0] == 0;
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 0)
                    arr[i][0] = arr[0][j] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                if (arr[0][j] == 0 || arr[i][0] == 0)
                    arr[i][j] = 0;
        }

        // if(arr[0][0]==0) means correspoding row should be filled with zeroes
        if (arr[0][0] == 0)
            for (int j = 0; j < n; j++)
                arr[0][j] = 0;

        // if colZero is true implying the first column should be filled with zero
        if (colZero)
            for (int i = 0; i < m; i++)
                arr[i][0] = 0;

    }
}

// -------------------------------------------------------------------------------------
