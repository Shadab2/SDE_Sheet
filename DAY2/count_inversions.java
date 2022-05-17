package DAY2;

// tags : Sorting , Implementation , Medium
public class count_inversions {
    static long count = 0l;

    public static long getInversions(long arr[], int n) {
        // Write your code here.
        mergeSort(arr, 0, n - 1);
        return count;
    }

    public static void merge(long arr[], int l, int r, int mid) {
        int size1 = mid - l + 1;
        int size2 = r - mid;
        long[] arr1 = new long[size1], arr2 = new long[size2];
        for (int i = 0; i < size1; i++)
            arr1[i] = arr[l + i];
        for (int i = 0; i < size2; i++)
            arr2[i] = arr[mid + i + 1];
        int i = 0, j = 0, k = l;
        while (i < size1 && j < size2) {
            if (arr1[i] > arr2[j]) {
                arr[k++] = arr2[j++];
                // at this time we need to add all the remaining elements from arr1
                count += (size1 - i);
            } else
                arr[k++] = arr1[i++];
        }
        while (i < size1) {
            arr[k++] = arr1[i++];
        }
        while (j < size2) {
            arr[k++] = arr2[j++];
        }
    }

    public static void mergeSort(long arr[], int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) >> 1;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, r, mid);
    }

}
