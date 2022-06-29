package DAY17;

import java.util.*;

public class ml_amazon_question {
    String ans = "";

    public void solve(String a, String b, String c) {
        if (a.length() == 0 && b.length() == 0) {
            if (ans.length() == 0 || ans.compareTo(c) > 0)
                ans = c;
            return;
        }
        if (a.length() > 0) {
            char ct = a.charAt(0);
            solve(a.substring(1), b + ct, c);
        }
        if (b.length() > 0) {
            char ct = b.charAt(b.length() - 1);
            solve(a, b.substring(0, b.length() - 1), c + ct);
            return;
        }
    }

    public static void main(String[] args) {
        ml_amazon_question t = new ml_amazon_question();
        t.solve("dasigghskguiio", "", "");
        System.out.println(t.ans);
    }
}
