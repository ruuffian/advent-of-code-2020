import Day1.expenseReport;
import Day1.expenseReportTwo;

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
                    expenseReport report = new expenseReport();
                    Integer[] result = report.sum2020("Day1.1.txt");
                    if (result[0] == 0)
                        System.out.println("An error has occured!");
                    else
                        System.out.println(result[0] * result[1]);
                } else if (choice.toUpperCase().equals("TWO") || choice.toUpperCase().equals("2")) {
                    expenseReportTwo report = new expenseReportTwo();
                    Integer[] result = report.sumThree("Day1.1.txt");
                    if (result[0] == 0)
                        System.out.println("An error has occured!");
                    else
                        System.out.println(result[0] * result[1] * result[2]);
                } else {
                    System.out.println("Invalid entry!");
                }
                break;
            case "EXIT", "STOP", "TERMINATE":
                break;
        }
    }
}
