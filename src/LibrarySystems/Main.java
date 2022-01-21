package LibrarySystems;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


// Developer Notes
// Line 33 - States File 'BookLibrary' where all Array Lists containing each user's books will be stored.
// Line 34 - Creates ArrayList BookInfo' where each user's book will be listed before adding to a general file.
// Line 51 - 63 - The program creates the BookLibrary file and prints an error if something goes wrong using a try-catch.
// Line 66 - 85 - Confirms Login: Depending on the users input, will either take you to the login or register page by initiating the login (Line 73 - 106) or register (Line 107 - 128).       (Incomplete)
// Line 149 - 167 - Main Menu: User is asked to tell the program which option they would like to take on. Then the option is initiated.                                                        (Incomplete)
// Line 170 - 194 - Get Book Details where the key details of the book are taken by the user and listed in an array list. An error is printed if any detail is entered in the wrong format.    ( Complete )
// Line 197 - 208 - Write To File: The details stored in the array list are copied over to the BookLibrary File. Error printed if problem occurs.                                              ( Complete )
// Line 211 - 224 - Read File: Contents of the file are printed out. Error Printed if contents can't be read.                                                                                  ( Complete )
// Line 227 - 235 - Delete File: Contents in the file are deleted. Error printed if file can't be deleted.                                                                                     (Incomplete)


// To-Do List (No particular order for completion)

//(1) Give the user an 'Are you sure' message when deleting a file.                                                                                                                            (Incomplete)
//(2) Allow the user to borrow books and give a deadline by with they have to be returned.                                                                                                     (Incomplete)
//(3) Allow the user to return a book.                                                                                                                                                         (Incomplete)
//(4) Break the loop when a user successfully logs in and continue with the program.                                                                                                           (Incomplete)
//(5) Complete the menu by adding the borrow, return, search and add/remove book functions.                                                                                                    (Incomplete)
//(6) Bullet-proof test the program and make sure there are no faults with any input formats.                                                                                                  (Incomplete)



public class Main {

    private static File BookLibrary = new File("BookLibrary.txt");
    private static ArrayList<String> BookInfo = new ArrayList<>();


    public static void main(String[] args) {

        CreateFile();
        ConfirmLogin();
        VerifyLogin();
        Register();
        Menu();
        GetBookDetails();
        WriteToFile();
        ReadFile();
        DeleteFile();
    }


    public static void CreateFile() {

        try {
            if (BookLibrary.createNewFile()) {
                System.out.println("File created: " + BookLibrary.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during the creation of the file");
            e.printStackTrace();
        }
    }


    public static void ConfirmLogin() {

        System.out.println("Would you like to login or register?");
        Scanner input = new Scanner(System.in);
        while (true) {
            String userInput = input.nextLine();
            if (userInput.equals("login")) {
                VerifyLogin();
                break;

            }
            if (userInput.equals("register")) {
                Register();
                break;

            } else {
                System.out.println("Error");
            }
        }
    }


    public static void VerifyLogin() {

        Scanner Login = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = Login.next();
        System.out.println("Enter your password: ");
        String password = Login.next();
        String filepath = "LoginFile.txt";

        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";

        try {

           Scanner x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            tempUsername = x.next();
            tempPassword = x.next();

            while (x.hasNext() || !found) {


                if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {

                    found = true;
                }
            }
            x.close();
            System.out.println(found);

        } catch (Exception e) {
            System.out.println("An error occurred while logging in");
        }
    }


    public static void Register() {

        Scanner register = new Scanner(System.in);
        System.out.println("Enter your name");
        String username = register.next();
        System.out.println("Please enter your password");
        String password = register.next();
        File file = new File("LoginFile.txt");
        String userName = (username);
        FileWriter writer = null;
        try {
            writer = new FileWriter("LoginFile.txt", true);
            BufferedWriter bw = new BufferedWriter(writer);
            writer.write(userName);
            writer.write("\n");
            writer.write(password);
            writer.write("\n");
            writer.close();
            System.out.println("Successfully registered to the library, hello " + username);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String Menu() {

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the book library, here are your options, please enter the number of the action you wish to take place");
            System.out.println(" (1) Add a new book to the library");
            System.out.println(" (2) Removing a book from the library");
            System.out.println(" (3) Searching for a book");
            System.out.println(" (4) Change a book's details");
            System.out.println(" (5) Loan a book");
            int menuChoice = input.nextInt();

            if (menuChoice == 1) {
                GetBookDetails();
            } else {
                System.out.println("Option entered is not valid, please try again");
            }
        }
    }


    public static void GetBookDetails() {

        try {
            Scanner scanner = new Scanner(System.in);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the Book Title");
            String BookTitle = bufferedReader.readLine();

            System.out.println("Enter the books ISBN");
            String ISBN = Integer.toString(scanner.nextInt());

            System.out.println("Enter the author of the book");
            String BookAuthor = bufferedReader.readLine();

            System.out.println("Enter the book genre");
            String BookGenre = scanner.nextLine();

            BookInfo.add(BookTitle);
            BookInfo.add(ISBN);
            BookInfo.add(BookAuthor);
            BookInfo.add(BookGenre);
        } catch (Exception e) {
            System.out.println("Error while taking book details");
        }
    }


    public static void WriteToFile() {

        try {
            FileWriter myWriter = new FileWriter(BookLibrary.getName(), true); //True means append to file contents, False means overwrite
            myWriter.write(String.valueOf(BookInfo));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println("An error occurred whilst writing to the file.");
            e.printStackTrace();
        }
    }


    public static void ReadFile(){

        try{
            Scanner myReader = new Scanner(BookLibrary);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }catch (FileNotFoundException e){
            System.out.println("An error occurred whilst trying to read the contents of the file");
            e.printStackTrace();
        }
    }


    public static void DeleteFile(){

        if (BookLibrary.delete()){
            System.out.println("Successfully deleted the file " + BookLibrary.getName());
        }else{
            System.out.println("Failed to delete the file.");
        }
    }
}

