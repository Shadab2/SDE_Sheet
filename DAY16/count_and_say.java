package DAY16;

public class count_and_say {
    // Approach #1 Implementation
    public String countAndSay(int n) {
        StringBuilder now = new StringBuilder("1");
        while (n-- > 1) {
            StringBuilder sb = new StringBuilder("");
            int count = 0;
            for (int i = 0; i < now.length(); i++) {
                if ((i > 0 && now.charAt(i) != now.charAt(i - 1))) {
                    sb.append(count).append(now.charAt(i - 1));
                    count = 1;
                } else
                    count++;
            }
            if (count > 0)
                sb.append(count).append(now.charAt(now.length() - 1));
            now = sb;
        }
        return now.toString();
    }
}
