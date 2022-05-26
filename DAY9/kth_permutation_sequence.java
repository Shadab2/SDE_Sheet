package DAY9;

import java.util.*;

// tags : Maths, Permutation , Hard

public class kth_permutation_sequence {
    // observation : if we have 123456 , every digits in the sequence will have
    // (n-1)! permuation staring with that number in order
    // eg [123] => will have 2! permuation starting with 1 eg [123][132] , so we can
    // effectively know the exact block
    // for current permuation , suppose k = 5 , we can surely know that it can be
    // starting with 1 or 2
    // it must start with 3 and we will extend this idea recursively
    int fact[] = new int[10];
    {
        fact[0] = 1;
        for (int i = 1; i <= 9; i++)
            fact[i] = i * fact[i - 1];
    }

    public String getPermutation(int n, int k) {
        if (n == 1)
            return "1";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        return solve(n, k, list);

    }

    public String solve(int n, int k, ArrayList<Integer> list) {
        if (n == 0)
            return "";
        int nextBlock = k / fact[n - 1];
        if (k % fact[n - 1] == 0)
            nextBlock--;
        String soFar = String.valueOf(list.get(nextBlock));
        list.remove(list.get(nextBlock));
        return soFar + solve(n - 1, k - nextBlock * fact[n - 1], list);
    }

}
