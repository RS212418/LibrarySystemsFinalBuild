package LibrarySystems;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static File BookLibrary = new File("BookLibrary.txt");
    private static File ConfirmLogin = new File ("ConfirmLogin.txt");
    private static ArrayList<String> BookInfo = new ArrayList<>();
    private static Scanner x;

    public static void main(String[] args) {
        CreateFile();
        ConfirmLogin();
        VerifyLogin();
        Register();
        Menu();
        GetBookDetails();
        //WriteToFile();
        //ReadFile();
        //DeleteFile();

    }
    public static void CreateFile() {

        try {
            if (BookLibrary.createNewFile()) {
                ConfirmLogin.createNewFile();
                System.out.println("File created: " + BookLibrary.getName());
                System.out.println("File created: " + ConfirmLogin.getName());
            }else{
                System.out.println("File already exists");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during the creation of the file");
            e.printStackTrace();
        }
    }
    public static void ConfirmLogin(){
        System.out.println("Would you like to login or register?");
        Scanner input = new Scanner(System.in);
        while (true) {
            String userInput = input.nextLine();
            if (userInput.equals("login")) {
                VerifyLogin();
                break;

            }if (userInput.equals("register")) {
                Register();
                break;

            }else {
                System.out.println("Error");
            }
        }
    }


    public static void VerifyLogin(){

        Scanner Login = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = Login.next();
        System.out.println("Enter your password: ");
        String password = Login.next();
        String filepath = "LoginFile.txt";

        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";

        try{
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found){
                tempUsername = x.next();
                tempPassword = x.next();

                if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {

                    found = true;
                }break;
            }
            x.close();
            System.out.println(found);

        }
        catch(Exception e){
            System.out.println("An error occurred while logging in");
        }
    }


    public static void Register() {
        Scanner register = new Scanner(System.in);
        System.out.println("Enter your name");
        String username = register.next();
        System.out.println("please enter your password");
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
            String BookGenre = scanner.next();

            BookInfo.add(BookTitle);
            BookInfo.add(ISBN);
            BookInfo.add(BookAuthor);
            BookInfo.add(BookGenre);
        } catch (Exception e) {
            System.out.println("Error while taking book details");
        }

    }



}
