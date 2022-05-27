package DAY10;

import java.util.*;

// tags : Implementation , Backtracking , Hard
public class nqueen {

    // Approach #1 brute force with every time checking diagonals and rows
    char arr[][];
    int n;
    // only check for upper column , upper left diagonals and upper right diagonals
    int dx[] = { -1, -1, -1 };
    int dy[] = { 0, -1, 1 };
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int N) {
        n = N;
        arr = new char[n][n];
        for (char i[] : arr)
            Arrays.fill(i, '.');
        solve(arr, 0);
        return ans;
    }

    public void solve(char arr[][], int start) {
        if (start == n) {
            List<String> list = new ArrayList<>();
            for (char c[] : arr)
                list.add(new String(c));
            ans.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (arr[start][i] == '.') {
                boolean valid = true;
                for (int move = 0; move < 3 && valid; move++)
                    valid &= validate(arr, start, i, move);
                if (!valid)
                    continue;
                arr[start][i] = 'Q';
                solve(arr, start + 1);
                arr[start][i] = '.';
            }
        }

    }

    public boolean validate(char arr[][], int i, int j, int mov) {
        if (i >= n || j >= n || i < 0 || j < 0)
            return true;
        if (arr[i][j] == 'Q')
            return false;
        return validate(arr, i + dx[mov], j + dy[mov], mov);
    }

    // Appraoch #2
    // if we can store boolean arrays to check whether a current column is taken or
    // not
    // to check whether upper right and left diagonal is taken or now , we will use
    // formuala for upper right diagonal (row+col)
    // formuala for upper left diagonal (n-1)+(col-row)
    boolean[] col, rightDiagonal, leftDiagonal;

    public List<List<String>> solveNQueens1(int N) {
        n = N;
        arr = new char[n][n];
        for (char i[] : arr)
            Arrays.fill(i, '.');
        col = new boolean[n];
        rightDiagonal = new boolean[2 * n - 1];
        leftDiagonal = new boolean[2 * n - 1];
        solve(arr, 0);
        return ans;
    }

    public void backtrack(char arr[][], int start) {
        if (start == n) {
            List<String> list = new ArrayList<>();
            for (char c[] : arr)
                list.add(new String(c));
            ans.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (arr[start][i] == '.') {
                boolean invalid = col[i] || rightDiagonal[start + i] || leftDiagonal[n - 1 - (i - start)];
                if (invalid)
                    continue;
                arr[start][i] = 'Q';
                col[i] = rightDiagonal[start + i] = leftDiagonal[n - 1 - (i - start)] = true;
                backtrack(arr, start + 1);
                col[i] = rightDiagonal[start + i] = leftDiagonal[n - 1 - (i - start)] = false;
                arr[start][i] = '.';
            }
        }

    }

}
