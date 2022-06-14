package DAY15;

public class my_atoi {
    // Appoach#1 implementation
    // first check if we found the sign , if sign occurs after the digit is found
    // then return 0 eg. 892+925
    // also check if the values are overflowing break
    public int myAtoi(String s) {
        s = s.trim();
        long intValue = 0;
        int sign = 0;
        boolean digitFound = false;
        for (char c : s.toCharArray()) {
            digitFound |= Character.isDigit(c);
            if (Character.isDigit(c))
                intValue = intValue * 10 + (c - '0');
            else if ((c != '-' && c != '+') || digitFound)
                break;
            else if (sign != 0)
                break;
            else if (c == '-')
                sign = -1;
            else
                sign = 1;
            if (intValue - 1 > Integer.MAX_VALUE)
                break;
        }
        if (sign < 0)
            return (int) Math.max(Integer.MIN_VALUE, intValue * -1);
        return (int) Math.min(Integer.MAX_VALUE, intValue);
    }
}
