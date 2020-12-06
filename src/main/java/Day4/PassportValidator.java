package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PassportValidator {
    private List<String> info = new ArrayList<>();
    static String[] baseStats = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid"};
    static String[] fourDigits = new String[]{"byr", "iyr", "eyr"};

    public int totalValid(String a) throws FileNotFoundException { //counts how many valid passports with loose rules
        List<Passport> passports = new ArrayList<>();
        format(a); //formats input file (very clever)
        for (String pass : info) {
            passports.add(new Passport(pass));
        }
        int value = 0;
        for (Passport pass : passports) {
            if (validator(pass))
                value++;
        }

        return value;
    }

    public int totalValidStrict(String a) throws FileNotFoundException { //counts valid passports with strict rules
        List<Passport> passports = new ArrayList<>();
        format(a); //formats input file
        for (String pass : info) {
            passports.add(new Passport(pass));
        }
        int value = 0;
        for (Passport pass : passports) {
            if (validatorStrict(pass))
                value++;
        }
        return value;
    }

    public void format(String a) throws FileNotFoundException { //very clever format algorithm :)))
        Scanner scanner = new Scanner(new File(Objects.requireNonNull(PassportValidator.class.getClassLoader().getResource(a)).getFile())).useDelimiter(Pattern.compile("^\\s*$", Pattern.MULTILINE));
        while (scanner.hasNext()) {
            String raw = scanner.next();
            StringBuilder input = new StringBuilder();
            for (int i = raw.length() - 1; i >= 0; i--) {
                if (!("" + raw.charAt(i)).equals("\n") && !("" + raw.charAt(i)).equals("\r") && !("" + raw.charAt(i)).equals(" ")) //so cool!
                    input.append(raw.charAt(i));
            }
            input.reverse();
            info.add(input.toString());
        }
    }

    public boolean validator(Passport pass) { //checks if a passport is valid based on loose rules
        for (int i = 0; i < baseStats.length - 1; i++) {
            if (!pass.isPresent(baseStats[i]))
                return false;
        }
        return true;
    }

    public boolean validatorStrict(Passport pass) { //checks if a passport is valid by strict rules
        for (int i = 0; i < baseStats.length - 1; i++) { //makes sure each info type is present
            if (!pass.isPresent(baseStats[i]))
                return false;
        }

        for (String digits : fourDigits) { //makes sure the three year values are 4 digits
            if (pass.retValue(digits).length() != 4)
                return false;
        }

        if (Integer.parseInt(pass.retValue("byr")) < 1920 || Integer.parseInt(pass.retValue("byr")) > 2002) //birth year range
            return false;
        if (Integer.parseInt(pass.retValue("iyr")) < 2010 || Integer.parseInt(pass.retValue("iyr")) > 2020) //issue year range
            return false;
        if (Integer.parseInt(pass.retValue("eyr")) < 2020 || Integer.parseInt(pass.retValue("eyr")) > 2030) //expirary year range
            return false;

        String full = pass.retValue("hgt"); //height
        String check = full.substring(full.length() - 1);
        if (!check.equals("m") && !check.equals("n")) //checks for units
            return false;
        String height = full.substring(0, full.length() - 2);
        if (check.equals("m") && (Integer.parseInt(height) < 150 || Integer.parseInt(height) > 193)) //centimeters range
            return false;
        if (check.equals("n") && (Integer.parseInt(height) < 59 || Integer.parseInt(height) > 76)) //inches range
            return false;

        String color = pass.retValue("hcl"); //haircolour
        String[] accepted = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "#"}; //possible characters
        if (!("" + color.charAt(0)).equals("#")) //makes sure it starts with a #
            return false;
        for (int i = 0; i < color.length(); i++) {
            int right = 0;
            for (String s : accepted) { //loops to make sure each character present matches 1 of the available character
                if (("" + color.charAt(i)).equals(s)) {
                    right++;
                    break;
                }
            }
            if (right != 1)
                return false;
        }

        String[] eyes = new String[]{"amb", "blu", "brn", "gry", "grn", "hzl", "oth"}; //eye colour
        String actual = pass.retValue("ecl");
        int right = 0;
        for (String eye : eyes) { //checks the eye color is a valid value
            if (actual.equals(eye))
                right++;
        }
        if (right != 1)
            return false;

        if (pass.retValue("pid").length() != 9) //checks the passport ID is 9 digits exactly
            return false;

        return true;
    }
}
