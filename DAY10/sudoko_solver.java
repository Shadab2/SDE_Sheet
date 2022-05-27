package DAY10;

// tags: Implementation , Backtracking , Maths, Hard
public class sudoko_solver {

    // in every unfilled cell ,try with 1 with 9 and check for the next cell , if
    // the solution exists
    // backtrack and try for another number
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    public boolean solve(char[][] board, int index) {
        if (index == 81)
            return true;
        int row = index / 9, col = index % 9;
        if (board[row][col] != '.')
            return solve(board, index + 1);
        for (char num = '1'; num <= '9'; num++) {
            if (canNotBePlaced(board, row, col, num))
                continue;
            board[row][col] = num;
            if (solve(board, index + 1))
                return true;
            board[row][col] = '.';
        }
        return false;
    }

    // way to check whether a cell filled with char num will satisfy the sudoko
    // constraints
    public boolean canNotBePlaced(char board[][], int i, int j, char num) {
        int innerSquareRow = (i / 3) * 3, innerSquareCol = (j / 3) * 3;
        for (int index = 0; index < 9; index++) {
            if (board[i][index] == num || board[index][j] == num)
                return true;
            // try for small squares
            if (board[innerSquareRow + index / 3][innerSquareCol + index % 3] == num)
                return true;
        }
        return false;
    }
}
