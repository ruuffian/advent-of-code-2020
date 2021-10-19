import Day1.*;
import Day2.*;
import Day3.*;
import Day4.*;
import Day5.*;
import Day6.*;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class mainUI {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("What day would you like to run?");
            String choice = keyboard.next().toUpperCase(Locale.ROOT);

            switch (choice) {
                case "1" -> {
                    System.out.println("part 1 or part 2?");
                    choice = keyboard.next();
                    if (choice.equals("1")) {
                        ExpenseReport report = new ExpenseReport();
                        Integer[] result = new Integer[0];
                        try {
                            result = report.sum2020("Day1.txt");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        if (result[0] == 0)
                            System.out.println("An error has occured!");
                        else
                            System.out.println(result[0] * result[1]);
                    } else if (choice.equals("2")) {
                        ExpenseReportTwo report = new ExpenseReportTwo();
                        Integer[] result = new Integer[0];
                        try {
                            result = report.sumThree("Day1.txt");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        if (result[0] == 0)
                            System.out.println("An error has occured!");
                        else
                            System.out.println(result[0] * result[1] * result[2]);
                    } else {
                        System.out.println("Invalid entry!");
                    }
                }
                case "2" -> {
                    System.out.println("part 1 or part 2?");
                    choice = keyboard.next();
                    if (choice.equals("1")) {
                        ValidPassword password = new ValidPassword();
                        try {
                            System.out.println("There are " + password.isValidPassword("Day2.txt") + " valid passwords.");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else if (choice.equals("2")) {
                        CorrectValidPassword password = new CorrectValidPassword();
                        try {
                            System.out.println("There are " + password.numberValid("Day2.txt") + " valid passwords.");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Invalid entry!");
                    }
                }
                case "3" -> {
                    System.out.println("part 1 or part 2?");
                    choice = keyboard.next();
                    if (choice.equals("1")) {
                        TobogganSlope slope = new TobogganSlope();
                        try {
                            System.out.println(slope.trees("Day3.txt"));
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    if (choice.equals("2")) {
                        MultipleSlopes slope = new MultipleSlopes();
                        try {
                            System.out.println(slope.multipleTrees("Day3.txt"));
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
                case "4" -> {
                    System.out.println("part 1 or part 2?");
                    choice = keyboard.next();
                    if (choice.equals("1")) {
                        PassportValidator valid = new PassportValidator();
                        try {
                            System.out.println(valid.totalValid("Day4.txt"));
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    if (choice.equals("2")) {
                        PassportValidator pass = new PassportValidator();
                        try {
                            System.out.println(pass.totalValidStrict("Day4.txt"));
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
                case "5" -> {
                    System.out.println("part 1 or part 2?");
                    choice = keyboard.next();
                    if (choice.equals("1")) {
                        BoardingPassCounter board = null;
                        try {
                            board = new BoardingPassCounter("Day5.txt");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        assert board != null;
                        System.out.println(board.maxSeatID());
                    }
                    if (choice.equals("2")) {
                        BoardingPassCounter board = null;
                        try {
                            board = new BoardingPassCounter("Day5.txt");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        assert board != null;
                        System.out.println(board.missingSeatID());
                    }
                }
                case "6" -> {
                    System.out.println("part 1 or part 2?");
                    choice = keyboard.next();
                    if (choice.equals("1")) {
                        Survey questions = null;
                        try {
                            questions = new Survey("Day6.txt");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        assert questions != null;
                        System.out.println(questions.uniqueQuestions());
                    }
                }
//                if (choice.equals("2")) {
//                    BoardingPassCounter board = new BoardingPassCounter("Day5.txt");
//                    System.out.println(board.missingSeatID());
//                }
                case "EXIT" -> System.exit(0);
            }
        }
    }
}
