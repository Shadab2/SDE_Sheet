package DAY15;

public class Rabin_Karp {
    public static int rabinSearch(String text, String pattern, int Radix) {
        int hashValueOfPattern = 0;
        int hashValueOfCurrentText = 0;
        int hashMultiplier = 1;
        int prime = 1999;
        int m = text.length(), n = pattern.length();
        // calculate the hash for pattern and the first window of text
        for (int i = 0; i < n; i++) {
            if (i > 0)
                hashMultiplier = (hashMultiplier * Radix) % prime;
            hashValueOfPattern = (Radix * hashValueOfPattern + (pattern.charAt(i) - 96)) % prime;
            hashValueOfCurrentText = ((Radix * hashValueOfCurrentText) + (text.charAt(i) - 96)) % prime;

        }
        for (int i = 0; i <= m - n; i++) {
            int j = 0;
            if (hashValueOfCurrentText == hashValueOfPattern) {
                while (j < n) {
                    if (pattern.charAt(j) != text.charAt(i + j))
                        break;
                    j++;
                }
                if (j == n)
                    return i;
            }
            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if (i < m - n) {
                hashValueOfCurrentText = (Radix * (hashValueOfCurrentText - (hashMultiplier * (text.charAt(i) - 96)))
                        + text.charAt(i + n) - 96) % prime;
                if (hashValueOfCurrentText < 0)
                    hashValueOfCurrentText += prime;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        String pattern = "ghijklo", text = "ababcdghijklopll";
        System.out.println(rabinSearch(text, pattern, 26));
    }
}