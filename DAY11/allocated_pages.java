package DAY11;

public class allocated_pages {

    public int books(int[] A, int B) {
        int start = 0;
        long sum = 0;
        if (B > A.length) {
            return -1;
        }
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        int end = (int) sum;
        int result = Integer.MAX_VALUE;
        while (end >= start) {

            int mid = (end + start) / 2;

            if (isPossible(mid, A, B)) {
                result = Math.min(result, mid);
                end = mid - 1;

            } else {

                start = mid + 1;
            }

        }
        return result;
    }

    public boolean isPossible(int mid, int arr[], int m) {
        int student = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid) {
                return false;
            }
            if (sum + arr[i] > mid) {
                sum = arr[i];
                student++;
                if (student > m) {
                    return false;
                }
            } else {
                sum += arr[i];
            }
        }
        return true;
    }

}
