package DAY16;

import java.util.Arrays;

public class kmp_lps {
    void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    static void computeLPSArray(String pat, int M, int lps[]) {
        int pointer = 0;
        lps[0] = 0;
        int index = 1;
        while (index < M) {
            if (pat.charAt(index) == pat.charAt(pointer)) {
                pointer++;
                lps[index] = pointer;
                index++;
            } else if (pointer != 0)
                pointer = lps[pointer - 1];
            else
                index++;

        }
        System.out.println(Arrays.toString(lps));
    }

    // Driver program to test above function
    public static void main(String args[]) {
        String pattern = "AAACAAAA";
        int lps[] = new int[pattern.length()];
        computeLPSArray(pattern, pattern.length(), lps);
    }
}
// This code has been contributed by Amit Khandelwal.
