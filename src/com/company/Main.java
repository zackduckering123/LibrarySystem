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
                fileHandling.CreateUserFile();
                fileHandling.WriteToUserFile();
                break;
            } else if (choice.equalsIgnoreCase("log into an existing account")){

            }else if (choice.equalsIgnoreCase("Exit")){
                break;
            }else {
                System.out.println("Sorry this is not an option, please select one that is available");
            }
        }
    }
    public static String getInput(String prompt) {   //instead of putting scanner line every time. pretty useful :)
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

public static void mainMenuAdmin(){ //admin can add remove and search books
        boolean choice = true; //main menu, where you can choose weather your entering a book ext
        while (choice) {
            String Menu = getInput("Would you like to:" + "\nEnter a book" + "\nSearch for a book" + "\nExit");
            if (Menu.equalsIgnoreCase("enter a book")) {
                fileHandling.add();
            }
            if (Menu.equalsIgnoreCase("Exit")) {
                fileHandling.CreateBooksFile();
                fileHandling.WriteToFile(); //call write to file method
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