package Day4;

import java.util.HashMap;
import java.util.Map;

public class Passport {
    private Map<String, String> info = new HashMap<>();

    Passport(String a) { //Constructor
        int i = a.length() - 1;
        while (i >= 0) {
            StringBuilder key = new StringBuilder(), value = new StringBuilder(); //epic iterated key and value extraction
            for (i = a.length() - 1; i > 0; i--) {
                if (!("" + a.charAt(i)).equals(":")) {
                    value.append(a.charAt(i));
                } else if (("" + a.charAt(i)).equals(":")) {
                    key.append(a.charAt(i - 1)).append(a.charAt(i - 2)).append(a.charAt(i - 3));
                    info.putIfAbsent(key.reverse().toString(), value.reverse().toString()); //reverse because it loops right-to-left
                    key.setLength(0);
                    value.setLength(0);
                    i -= 3; //iterate
                }
            }
        }
    }

    public boolean isPresent(String a) { //checks if a key is present
        return info.containsKey(a);
    }

    public String retValue(String a) { //returns a key's value
        if (isPresent(a))
            return info.get(a);
        else
            return "np";
    }
}
