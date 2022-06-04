package DAY13;

// tags : Implementation , Stack
public class valid_parenthesis {
    public boolean isValid(String s) {
        char stack[] = new char[s.length()];
        int pointer = 0;
        String brackets = "({[]})";
        for (char c : s.toCharArray()) {
            if (pointer > 0 && brackets.indexOf(c) > 2
                    && brackets.indexOf(c) == 5 - brackets.indexOf(stack[pointer - 1]))
                pointer--;
            else
                stack[pointer++] = c;
        }
        return pointer == 0;
    }
}
