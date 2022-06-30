package com.erminselimovic;

import java.sql.*;

public class DB {

    public static final String url = "jdbc:postgresql://localhost:5432/BudgetProject";
    public static final String userDB = "postgres";
    public static final String passwordDB = "Admin2904";

    public static Connection connection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, userDB, passwordDB);
        return connection;
    }

    /*public static void CreateDB() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "Admin2904");
            ;
            Statement statement = connection.createStatement();
            Class.forName("org.postgresql.Driver");

            String sql = "CREATE TABLE if not EXISTS person  " +
                    "(ID            INT     PRIMARY KEY     NOT NULL," +
                    " NAME          TEXT                    NOT NULL, " +
                    " AGE           INT                     NOT NULL)";
            statement.execute(sql);
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/


    public static boolean isEmailExist(String email) throws SQLException, ClassNotFoundException {

        Connection connection = DriverManager.getConnection(url, userDB, passwordDB);
        Statement statement = connection.createStatement();
        Class.forName("org.postgresql.Driver");

        String sql = "SELECT * FROM users WHERE email = '" + email + "'";

        ResultSet resultSet = statement.executeQuery(sql);

        boolean emailExist = false;
        while (resultSet.next()) {
            String emailDB = resultSet.getString("email");
            String userPassword = resultSet.getString("password");
            if (emailDB.equals(email)) {
                emailExist = true;
            }
        }
        statement.close();
        return emailExist;

    }

    public static boolean isPasswordForEmailCorrect(String email, String password) throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection(url, userDB, passwordDB);
        Statement statement = connection.createStatement();
        Class.forName("org.postgresql.Driver");

        String sql = "SELECT * FROM users WHERE email = '" + email + "'";

        ResultSet resultSet = statement.executeQuery(sql);

        boolean isPasswordTrue = false;
        while (resultSet.next()) {

            String userPassword = resultSet.getString("password");

            if (userPassword.equals(password)) {
                isPasswordTrue = true;
            }
        }
        statement.close();
        return isPasswordTrue;


    }
}