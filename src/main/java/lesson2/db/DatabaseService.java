package lesson2.db;

import lesson2.beans.Responce;

import java.sql.*;

public class DatabaseService{
    private String URL = "jdbc:postgresql://localhost:8080/computer_db";
    private String dbUser = "postgres";
    private String dbPassword = "9966";

    public void showProductsPC() throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection(URL,dbUser,dbPassword);
        String query = "select pc.model,p.maker, pc.price from pc left join product p on p.model= pc.model;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Responce product = new Responce(
                    resultSet.getString("maker"),
                    resultSet.getString("model"),
                    resultSet.getDouble("price")
            );
            System.out.println(product);
        }

        preparedStatement.close();
        connection.close();
    }
}
