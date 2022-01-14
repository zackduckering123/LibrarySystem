package com.company.Useful;
import com.company.Objects.Book;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class repository {

    public static ArrayList<Book> bookList = new ArrayList<>();
    public static File bookShelf = new File("Library.txt");
    public static File userDetails = new File("logInDetails.txt");

    public static String getInput(String prompt) {   //instead of putting scanner line every time. pretty useful :)
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
