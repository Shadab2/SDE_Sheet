package DAY15;

public class int_to_roman {
    // Appraoch #1 implementation and using cache
    public String intToRoman(int num) {
        // 2d array to map values
        char values[][] = { { 'I', 'X', 'C', 'M' }, { 'V', 'L', 'D' } };
        StringBuilder roman = new StringBuilder("");
        String temp = String.valueOf(num);
        int index = temp.length() - 1;
        while (index >= 0) {
            int digit = num / (int) Math.pow(10, index);
            // take the current index value + current index + 1 value eg. 90 , XC
            if (digit == 9)
                roman.append(values[0][index]).append(values[0][index + 1]);
            // take upper and lower values
            else if (digit == 4)
                roman.append(values[0][index]).append(values[1][index]);
            else {
                if (digit >= 5) {
                    roman.append(values[1][index]);
                    digit -= 5;
                }
                for (int i = 0; i < digit; i++)
                    roman.append(values[0][index]);
            }
            num %= (int) Math.pow(10, index);
            index--;
        }
        return roman.toString();
    }

    // Approach #2 representation , hard coded
    public static String intToRoman1(int num) {
        String M[] = { "", "M", "MM", "MMM" };
        String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
}
