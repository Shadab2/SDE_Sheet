package DAY1;

import java.util.*;

//tags: Implementation , Easy

public class pascals_triangle {

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

    public static void main(String[] args) {

    }
}
