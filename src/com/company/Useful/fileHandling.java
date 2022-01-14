package com.company.Useful;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.company.Objects.Book;

public class fileHandling {

    public static Book BookDetails() { //details of book
        Book bookDetails = new Book("" ,"","","");
            try {
                String bookTitle = repository.getInput("Enter the title of the book");
                String AuthorName = repository.getInput("Enter the name of the author");
                String Genre = repository.getInput("Enter the genre of book");
                String ISBN = repository.getInput("Enter the ISBN");
                bookDetails = new Book(bookTitle ,AuthorName,Genre,ISBN);
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("There has been an error, please re-enter the book details");
            }
            return bookDetails;
    }

    public static void add() { //adds to the book list
        int AmountAdding = Integer.parseInt(repository.getInput("How many books would you like to add"));
        for (int i = 0; i < AmountAdding; i++) {
            repository.bookList.add(BookDetails());
        }
    }

    public static void CreateBooksFile() {
        try {
            if (repository.bookShelf.createNewFile()) {
                System.out.println("File created: " + repository.bookShelf.getName());
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
            FileWriter myWriter = new FileWriter(repository.bookShelf.getName(), true); //True means append to file contents, False means overwrite
            for (int i = 0; i < repository.bookList.size(); i++) {
                myWriter.write(repository.bookList.get(i).toString());
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
            if (repository.userDetails.createNewFile()) {
                System.out.println("File created: " + repository.userDetails.getName());
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
            FileWriter myWriter = new FileWriter(repository.userDetails.getName(), true); //True means append to file contents, False means overwrite
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
                String userName = repository.getInput("Enter your email address");
                boolean passwordlength = true;
                while (passwordlength) {
                    password = repository.getInput("Enter your password. Please remember a password must be at least 6 characters long");
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
