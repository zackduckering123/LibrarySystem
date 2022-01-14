package com.company.Menu;

import com.company.Main;
import com.company.Useful.fileHandling;
import com.company.Useful.repository;

public class privateMenus {
    public static void mainMenuAdmin(){ //admin can add remove and search books
        boolean choice = true; //main menu, where you can choose weather your entering a book ext
        while (choice) {
            String Menu = repository.getInput("Would you like to:" + "\nEnter a book" + "\nSearch for a book" + "\nExit");
            if (Menu.equalsIgnoreCase("enter a book")) {


               // fileHandling.add();
            }
            if (Menu.equalsIgnoreCase("Exit")) {
                fileHandling.CreateBooksFile();
                fileHandling.WriteToFile(); //call write to file method
                choice = false;
            } else {
                System.out.println("Sorry, this is not an option");
            }
        }
        System.out.println(repository.bookList);
    }
    public static void mainMenuGuest(){    //guest can search

    }
}
