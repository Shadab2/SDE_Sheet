package DAY1;

//tags : Implementation , 2D , Medium ;

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

    public static void main(String[] args) {

    }
}