package com.company.Menu;

import com.company.Useful.repository;

public class passwordVerification {
    public static int AdminCheck() {
        int resolution = 0;
        String usernameinput = repository.getInput("Please enter the admin username");
        if (usernameinput.equalsIgnoreCase("Margaret Gesner")) {
            String passwordinput = repository.getInput("Please enter the admin password");
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
