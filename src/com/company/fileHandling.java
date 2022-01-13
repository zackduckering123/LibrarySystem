package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileHandling {
    private static ArrayList<String> bookList = new ArrayList<>();
    private static File bookShelf = new File("Library.txt");
    private static File userDetails = new File("logInDetails.txt");

    public static String BookDetails() { //details of book
        String bookDetails = "";
        while (bookDetails.equals("")) {
            try {
                String bookTitle = getInput("Enter the title of the book");
                String AuthorName = getInput("Enter the name of the author");
                String Genre = getInput("Enter the genre of book");
                int ISBN = Integer.parseInt(getInput("Enter the ISBN"));
                bookDetails = bookTitle + "- " + AuthorName + "- " + Genre + "- " + ISBN + ". " + "\n";
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("There has been an error, please re-enter the book details");
            }

        }

        return bookDetails;
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

    public static void CreateBooksFile() {
        try {
            if (bookShelf.createNewFile()) {
                System.out.println("File created: " + bookShelf.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void WriteToFile() {
        try {
            FileWriter myWriter = new FileWriter(bookShelf.getName(), true); //True means append to file contents, False means overwrite
            for (int i = 0; i < bookList.size(); i++) {
                myWriter.write(bookList.get(i));
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void CreateUserFile() {
        try {
            if (userDetails.createNewFile()) {
                System.out.println("File created: " + userDetails.getName());
            } else {
                System.out.println("File already exist. ");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void WriteToUserFile() {
        try {
            FileWriter myWriter = new FileWriter(userDetails.getName(), true); //True means append to file contents, False means overwrite
            myWriter.write(userDetailsArray());
            myWriter.close();
            System.out.println("Account created successfully");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String userDetailsArray() {
        String nameAndPassword = "";
        String password = "";
        while (nameAndPassword.equals("")) {
            try {
                String userName = getInput("Enter your email address");
                boolean passwordlength = true;
                while (passwordlength) {
                    password = getInput("Enter your password. Please remember a password must be at least 6 characters long");
                    if (password.length() < 6) {
                        System.out.println("Your password is not secure, please enter a new password"); //checks password length, if it's less than 6 characters it's not secure
                    } else {
                        break;
                    }
                }
                nameAndPassword = userName + "- " + password + "\n";
            }catch(Exception e){
                System.out.println(e);
                System.out.println("There has been an error, please re-enter your username and password");
            }

        }
        return nameAndPassword;

    }
}
