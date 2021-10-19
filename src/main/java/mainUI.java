import Day1.*;
import Day2.*;
import Day3.*;
import Day4.*;
import Day5.*;
import Day6.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class mainUI {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What day would you like to run?");
        String choice = keyboard.next();

        switch (choice) {

            case "1":
                System.out.println("part 1 or part 2?");
                choice = keyboard.next();
                if (choice.equals("1")) {
                    ExpenseReport report = new ExpenseReport();
                    Integer[] result = report.sum2020("Day1.txt");
                    if (result[0] == 0)
                        System.out.println("An error has occured!");
                    else
                        System.out.println(result[0] * result[1]);
                } else if (choice.equals("2")) {
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

            case "2":
                System.out.println("part 1 or part 2?");
                choice = keyboard.next();
                if (choice.equals("1")) {
                    validPassword password = new validPassword();
                    System.out.println("There are " + password.isValidPassword("Day2.txt") + " valid passwords.");
                } else if (choice.equals("2")) {
                    CorrectValidPassword password = new CorrectValidPassword();
                    System.out.println("There are " + password.numberValid("Day2.txt") + " valid passwords.");
                } else {
                    System.out.println("Invalid entry!");
                }
                break;

            case "3":
                System.out.println("part 1 or part 2?");
                choice = keyboard.next();
                if (choice.equals("1")) {
                    TobogganSlope slope = new TobogganSlope();
                    System.out.println(slope.trees("Day3.txt"));
                }
                if (choice.equals("2")) {
                    MultipleSlopes slope = new MultipleSlopes();
                    System.out.println(slope.multipleTrees("Day3.txt"));
                }
                break;

            case "4":
                System.out.println("part 1 or part 2?");
                choice = keyboard.next();
                if (choice.equals("1")) {
                    PassportValidator valid = new PassportValidator();
                    System.out.println(valid.totalValid("Day4.txt"));
                }
                if (choice.equals("2")) {
                    PassportValidator pass = new PassportValidator();
                    System.out.println(pass.totalValidStrict("Day4.txt"));
                }
                break;

            case "5":
                System.out.println("part 1 or part 2?");
                choice = keyboard.next();
                if (choice.equals("1")) {
                    BoardingPassCounter board = new BoardingPassCounter("Day5.txt");
                    System.out.println(board.maxSeatID());
                }
                if (choice.equals("2")) {
                    BoardingPassCounter board = new BoardingPassCounter("Day5.txt");
                    System.out.println(board.missingSeatID());
                }
                break;

            case "6":
                System.out.println("part 1 or part 2?");
                choice = keyboard.next();
                if (choice.equals("1")) {
                    Survey questions = new Survey("Day6.txt");
                    System.out.println(questions.uniqueQuestions());
                }
//                if (choice.equals("2")) {
//                    BoardingPassCounter board = new BoardingPassCounter("Day5.txt");
//                    System.out.println(board.missingSeatID());
//                }
                break;
            case "EXIT":
                break;
        }
    }
}
