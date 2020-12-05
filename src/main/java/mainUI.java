import Day1.ExpenseReport;
import Day1.ExpenseReportTwo;
import Day2.correctValidPassword;
import Day2.validPassword;
import Day3.MultipleSlopes;
import Day3.TobogganSlope;
import Day4.PassportValidator;
import Day5.BoardingPassCounter;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class mainUI {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What day would you like to run?");
        String choice = keyboard.next();

        switch (choice.toUpperCase()) {

            case "DAY1", "DAY 1", "DAY ONE", "1", "ONE":
                System.out.println("part 1 or part 2?");
                choice = keyboard.next();
                if (choice.toUpperCase().equals("ONE") || choice.toUpperCase().equals("1")) {
                    ExpenseReport report = new ExpenseReport();
                    Integer[] result = report.sum2020("Day1.txt");
                    if (result[0] == 0)
                        System.out.println("An error has occured!");
                    else
                        System.out.println(result[0] * result[1]);
                } else if (choice.toUpperCase().equals("TWO") || choice.toUpperCase().equals("2")) {
                    ExpenseReportTwo report = new ExpenseReportTwo();
                    Integer[] result = report.sumThree("Day1.txt");
                    if (result[0] == 0)
                        System.out.println("An error has occured!");
                    else
                        System.out.println(result[0] * result[1] * result[2]);
                } else {
                    System.out.println("Invalid entry!");
                }
                break;

            case "DAY2", "DAY 2", "DAY TWO", "2", "TWO":
                System.out.println("part 1 or part 2?");
                String choice2 = keyboard.next();
                if (choice2.toUpperCase().equals("1") || choice2.toUpperCase().equals("ONE")) {
                    validPassword password = new validPassword();
                    System.out.println("There are " + password.isValidPassword("Day2.txt") + " valid passwords.");
                } else if (choice2.toUpperCase().equals("2") || choice2.toUpperCase().equals("TWO")) {
                    correctValidPassword password = new correctValidPassword();
                    System.out.println("There are " + password.numberValid("Day2.txt") + " valid passwords.");
                } else {
                    System.out.println("Invalid entry!");
                }
                break;

            case "DAY3", "DAY 3", "DAY THREE", "3", "THREE":
                System.out.println("part 1 or part 2?");
                String choice3 = keyboard.next();
                if (choice3.toUpperCase().equals("1") || choice3.toUpperCase().equals("ONE")) {
                    TobogganSlope slope = new TobogganSlope();
                    System.out.println(slope.trees("Day3.txt"));
                }
                if (choice3.toUpperCase().equals("2") || choice3.toUpperCase().equals("TWO")) {
                    MultipleSlopes slope = new MultipleSlopes();
                    System.out.println(slope.multipleTrees("Day3.txt"));
                }
                break;

            case "DAY4", "DAY 4", "DAY FOUR", "4", "FOUR":
                System.out.println("part 1 or part 2?");
                String choice4 = keyboard.next();
                if (choice4.toUpperCase().equals("1") || choice4.toUpperCase().equals("ONE")) {
                    PassportValidator valid = new PassportValidator();
                    System.out.println(valid.totalValid("Day4.txt"));
                }
                if (choice4.toUpperCase().equals("2") || choice4.toUpperCase().equals("TWO")) {
                    PassportValidator pass = new PassportValidator();
                    System.out.println(pass.totalValidStrict("Day4.txt"));
                }
                break;

            case "DAY5", "DAY 5", "DAY FIVE", "5", "FIVE":
                System.out.println("part 1 or part 2?");
                String choice5 = keyboard.next();
                if (choice5.toUpperCase().equals("1") || choice5.toUpperCase().equals("ONE")) {
                    BoardingPassCounter board = new BoardingPassCounter("Day5.txt");
                    System.out.println(board.maxSeatID());
                }
                if (choice5.toUpperCase().equals("2") || choice5.toUpperCase().equals("TWO")) {
                    BoardingPassCounter board = new BoardingPassCounter("Day5.txt");
                    System.out.println(board.missingSeatID());
                }
                break;

            case "EXIT", "STOP", "TERMINATE":
                break;
        }
    }
}
