package com.erminselimovic;


import java.util.regex.Pattern;

public class Validate {

    public static boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static boolean isFieldEmpty(String s) {
        return s.length() == 0;

    }

    public static boolean isPasswordValid(String password) {

        return password.length() > 5 && password.length() <= 8;
    }



}
