package Day6;

import Day4.PassportValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class Survey {
    private final List<Group> info = new ArrayList<>();

    public Survey(String a) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(Objects.requireNonNull(PassportValidator.class.getClassLoader().getResource(a)).getFile())).useDelimiter(Pattern.compile("^\\s*$", Pattern.MULTILINE));
        while (scanner.hasNext()) {
            String raw = scanner.next();
            Group input = new Group(clean(raw));
            info.add(input);
        }
    }

    public int anyoneYes() {
        int yes = 0;
        for (Group gr : info) {
            Set<Character> presentInGroup = new HashSet<>();
            for (char c : gr.group) {
                if (presentInGroup.add(c))
                    yes++;
            }
        }
        return yes;
    }

    public int everyoneYes() {
        int yes = 0;
        for (Group gr : info) {
            int i = 0;
            Map<Character, Integer> map = new HashMap<>();
            while (i < gr.group.length) {
                if (!map.containsKey(gr.group[i]))
                    map.put(gr.group[i], 1);
                else
                    map.replace(gr.group[i], map.get(gr.group[i]) + 1);
                i++;
            }
            for (Character c : map.keySet()) {
                if (map.get(c) == gr.size)
                    yes++;
            }
        }
        return yes;
    }

    private String clean(String a) {
        StringBuilder build = new StringBuilder(a);
        while (build.charAt(0) == '\r' || build.charAt(0) == '\n')
            build = new StringBuilder(build.substring(1));
        return build.toString();
    }
}
