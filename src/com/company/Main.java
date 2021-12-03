package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<String> bookList = new ArrayList<>();
    private static File bookShelf = new File("Library");

    public static void main(String[] args) {
        boolean choice = true; //main menu, where you can choose weather your entering a book ext
        while (choice) {
            String Menu = getInput("Would you like to:" + "\nEnter a book" + "\nSearch for a book");
            if (Menu.equalsIgnoreCase("enter a book")) {
                add();
                break;
            } else {
                System.out.println("Sorry, this is not an option");
            }
        }
        System.out.println(bookList);
    }

    public static String BookDetails() { //details of book
        try {
            String bookTitle = getInput("Enter the title of the book");
            String AuthorName = getInput("Enter the name of the author");
            String Genre = getInput("Enter the genre of book");
            int ISBN = Integer.parseInt(getInput("Enter the ISBN"));
            return (bookTitle + ", " + AuthorName + ", " + Genre + ", " + ISBN);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

    public static String getInput(String prompt) {   //instead of putting scanner line every time. pretty useful :)
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void add() { //adds to the book list
        int AmountAdding = Integer.parseInt(getInput("How many books would you like to add"));
        for (int i = 0; i < AmountAdding; i++) {
            bookList.add(BookDetails());
        }
    }
}
