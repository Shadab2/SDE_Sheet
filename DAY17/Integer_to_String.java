package DAY17;

import java.util.Arrays;
import java.util.Scanner;

public class Integer_to_String {
    int digits[];
    private String[][] placeCache;
    private String[] tens;
    private String[] placeValues;

    public Integer_to_String(long num) {
        digits = new int[11];
        int i = 0;
        while (num != 0) {
            digits[i++] = (int) (num % 10);
            num /= 10;
        }
        placeCache = new String[][] {
                { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" },
                { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" }, };
        tens = new String[] { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "ninteen" };
        placeValues = new String[] { "", "", "", "hundred", "thousand", "lakhs", "crore", "one hundred crore" };
    };

    public String convert() {
        int tens = digits[0] + digits[1] * 10;
        String ans = convertTwoDig(tens);
        if (digits[2] != 0)
            ans = placeCache[0][digits[2]] + " hundred " + ans;
        for (int i = 3, place = 4; i < 10; i += 2, place++) {
            tens = digits[i] + digits[i + 1] * 10;
            if (tens != 0)
                ans = convertTwoDig(tens) + " " + placeValues[place] + " " + ans + " ";
        }
        return ans.trim();
    }

    private String convertTwoDig(int num) {
        if (num > 9 && num < 20)
            return tens[num % 10];
        String ret = placeCache[1][num / 10];
        if (ret.length() > 0 && placeCache[0][num % 10].length() > 0)
            ret += "-";
        return (ret + placeCache[0][num % 10]).trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a number or press -1 to exit ");
            long num = sc.nextLong();
            if (num == 0)
                System.out.println("zero");
            if (num < 0)
                break;
            Integer_to_String obj = new Integer_to_String(num);
            System.out.println(obj.convert());
        }

    }
}
