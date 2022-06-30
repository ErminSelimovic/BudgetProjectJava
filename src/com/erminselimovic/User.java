package com.erminselimovic;

import java.sql.SQLException;
import java.util.Scanner;

public class User {
    private String userNameAndLastName;
    private String email;
    private String password;


    public User(String userNameAndLastName, String email, String password) {
        this.userNameAndLastName = userNameAndLastName;
        this.email = email;
        this.password = password;
    }

    public String getUserNameAndLastName() {
        return userNameAndLastName;
    }

    public void setUserNameAndLastName(String userNameAndLastName) {
        this.userNameAndLastName = userNameAndLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void Login() throws SQLException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        System.out.println("Molim Vas unesite vaš email i password.");
        System.out.print("Email: ");
        String email = s.nextLine();
        System.out.print("Password: ");
        String password = s.nextLine();

        if (Validate.isEmailValid(email)) {
            if (DB.isEmailExist(email)) {
                System.out.println("Vaš email postoji u bazi");
                boolean passwordIsTrue = false;
                while (passwordIsTrue == false) {
                    System.out.print("Password je pogrešan\nUnesite ponovo password: ");
                    password = s.nextLine();
                    if (DB.isPasswordForEmailCorrect(email, password)) {
                        passwordIsTrue = true;
                    }
                }
                System.out.println("Uspješno ste logovani");
            } else {
                MainMenu.Start();
            }
        } else {
            System.out.println("Email nije validan!");
            MainMenu.Start();
        }


    }

    public static void Registration() {

    }

    public static void LoginPage() throws SQLException, ClassNotFoundException {
        Login();
    }

    public static void RegistrationPage() {
        System.out.println("Registracija");
    }
}
