package DAY15;

public class longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        int min = 201;
        for (String s : strs)
            min = Math.min(min, s.length());
        int index = 0;
        // index will tell how many characters are matched in every string
        while (index < min) {
            for (String s : strs)
                if (s.charAt(index) != strs[0].charAt(index))
                    return strs[0].substring(0, index);
            index++;
        }
        return strs[0].substring(0, index);

    }
}
