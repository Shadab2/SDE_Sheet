package DAY2;

// tags : Impementation , 2D , Maths, Medium
class rotate_image {

    // Approach #1
    // try to rotate each cell individually , observation : let n me the size of the
    // matrix of 1 based indexing
    // x,y -> y,n-x -> n-x ,n-(n-x) -> n-(n-x),n-n-(n-x)
    // max 4 allocations at each rotate
    int n;

    public void rotate(int[][] matrix) {
        n = matrix.length;
        int start = 0, end = n - 1;
        while (start < end) {
            for (int i = start; i < end; i++)
                rotate(i, n - start - 1, 4, matrix[start][i], matrix);
            start++;
            end--;
        }
    }

    public void rotate(int x, int y, int t, int val, int[][] matrix) {
        if (t <= 0)
            return;
        rotate(y, n - x - 1, t - 1, matrix[x][y], matrix);
        matrix[x][y] = val;
    }

    // Approach #2
    // taking the transpose of the matrix and reverse it finally to get 90 deg
    // rotation
    public void rotate1(int[][] matrix) {
        int n = matrix.length;

        // transponse of a matrix
        for (int i = 0; i < n; i++) {
            // start of i+1 to avoid duplicacy
            for (int j = i + 1; j < n; j++)
                swap(matrix, i, j, j, i);
        }

        // reverse the matix;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++)
                swap(matrix, i, j, i, n - j - 1);
        }
    }

    public void swap(int matrix[][], int i, int j, int x, int y) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }
}