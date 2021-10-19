package Day6;

import java.util.Arrays;

public class Group {
    public int size;
    public char[] group;

    public Group(String a) {
        build(a);
    }

    private void build(String a) {
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            switch (a.charAt(i)) {
                case '\r':
                    break;
                case '\n':
                    size++;
                    break;
                default:
                    input.append(a.charAt(i));
                    break;
            }
        }
        char[] tmp = input.toString().toCharArray();
        Arrays.sort(tmp);
        this.group = tmp;
    }
}
