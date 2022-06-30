package com.erminselimovic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        switch (MainMenu.Start()){
            case 1:
                User.LoginPage();
                break;
            case 2:
                User.RegistrationPage();
                break;
            default:
                MainMenu.Start();
                break;
        }

    }

}