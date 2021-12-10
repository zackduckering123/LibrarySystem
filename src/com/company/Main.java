package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<String> bookList = new ArrayList<>();
    private static File bookShelf = new File("Library.txt");
    private static File userDetails = new File("logInDetails.txt");

    public static void main(String[] args) {
    boolean login = true;
        String choice = "";
        while (login){
            choice = getInput("Would you like to:" + "\nLog in as admin" + "\nCreate an account" + "\nLog into an existing account" + "\nExit"); //chose weather to log in ore create an account
            if (choice.equalsIgnoreCase("log in as admin")){
                if (AdminCheck() == 1){
                    mainMenuAdmin();
                    break;
                }
                else {
                    System.out.println("You do not have admin permissions, please select another option" + "\n");
                    login = true;
                }
            } else if (choice.equalsIgnoreCase("Create an account")){
                CreateUserFile();
                WriteToUserFile();
            } else if (choice.equalsIgnoreCase("log into an existing account")){

            }else if (choice.equalsIgnoreCase("Exit")){
                break;
            }else {
                System.out.println("Sorry this is not an option, please select one that is available");
            }
        }
    }
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



public static void mainMenuAdmin(){ //admin can add remove and search books
        boolean choice = true; //main menu, where you can choose weather your entering a book ext
        while (choice) {
            String Menu = getInput("Would you like to:" + "\nEnter a book" + "\nSearch for a book" + "\nExit");
            if (Menu.equalsIgnoreCase("enter a book")) {
                add();
            }
            if (Menu.equalsIgnoreCase("Exit")) {
                CreateBooksFile();
                WriteToFile(); //call write to file method
                choice = false;
            } else {
                System.out.println("Sorry, this is not an option");
            }
        }
        System.out.println(bookList);
    }
    public static void mainMenuGuest(){    //guest can search

    }
    public static int AdminCheck() {
        int resolution = 0;
        String usernameinput = getInput("Please enter the admin username");
        if (usernameinput.equalsIgnoreCase("Margaret Gesner")) {
            String passwordinput = getInput("Please enter the admin password");
            if (passwordinput.equals("MikeWazowski")){
                resolution = 1;
            }else {
                System.out.println("This is the incorrect password!");
            }
        } else {
            System.out.println("this is the incorrect username");
        }
        return resolution;
    }
}