package com.erminselimovic;

import java.util.Scanner;

public class MainMenu {


    public static int Start() {
        Scanner s = new Scanner(System.in);
        System.out.println("Molimo vas odaberite jednu opciju");
        System.out.println("1. Login\n" +
                "2. Registracija");
        System.out.print("Enter 1 or 2: ");
        int choise = s.nextInt();

        if (choise != 1 && choise != 2){

            while(choise != 1 && choise !=2){

                System.out.println("Molimo vas odaberite 1 ili 2");
                System.out.println("1. Login\n 2. Registracija");
                System.out.print("Enter 1 or 2: ");
                choise = s.nextInt();

            }
        }

        return choise;

    }
}
