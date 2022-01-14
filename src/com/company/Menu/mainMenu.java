package com.company.Menu;

import com.company.Useful.fileHandling;
import com.company.Useful.repository;

public class mainMenu {
    public static void choices(){
        boolean login = true;
        String choice = "";
        while (login) {
            choice = repository.getInput("Would you like to:" + "\nLog in as admin" + "\nCreate an account" + "\nLog into an existing account" + "\nExit"); //chose weather to log in ore create an account
            if (choice.equalsIgnoreCase("log in as admin")) {
                if (passwordVerification.AdminCheck() == 1) {
                    privateMenus.mainMenuAdmin();
                    break;
                } else {
                    System.out.println("You do not have admin permissions, please select another option" + "\n");
                    login = true;
                }
            } else if (choice.equalsIgnoreCase("Create an account")) {
                fileHandling.CreateUserFile();
                fileHandling.WriteToUserFile();
                break;
            } else if (choice.equalsIgnoreCase("log into an existing account")) {

            } else if (choice.equalsIgnoreCase("Exit")) {
                break;
            } else {
                System.out.println("Sorry this is not an option, please select one that is available");
            }
        }
    }
}

