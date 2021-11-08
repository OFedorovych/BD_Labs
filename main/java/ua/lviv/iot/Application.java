package ua.lviv.iot;

import ua.lviv.iot.persistant.ConnectionManager;
import ua.lviv.iot.view.MyView;

import java.sql.*;
import java.util.Scanner;

public class Application {
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet rs = null;

    public static void main(String[] args){
        new MyView().showMenu();
    }


    public static void main2(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            System.out.println("Connection is set");

            readData();
            updateDataCatagories();
            readData();



        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver is not loaded");
        } catch (SQLException ex){
            System.out.println("SQLEx: " + ex.getMessage());
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            if (statement != null) try {
                statement.close();
            } catch (SQLException e) {
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    private static void readData() throws SQLException {
        rs = statement.executeQuery("SELECT * FROM TCategories ORDER BY ID");
        System.out.format("\nTable: Categories\n");
        System.out.format("%3s %-12s\n", "ID", "Name");
        while (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("Name");
            System.out.format("%3s %-12s\n", id, name);
        }
    }

    private static void updateDataCatagories() throws SQLException{
        Scanner input = new Scanner(System.in);
        System.out.print("Input catagory id you want to update: ");
        int catagory_id = input.nextInt();
        System.out.print("Input new name for catagory " + catagory_id + " : ");
        String catagory_new = input.next();

        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("UPDATE TCategories SET Name=? WHERE ID=?;");
        preparedStatement.setString(1, catagory_new);
        preparedStatement.setInt(2, catagory_id);
        int n = preparedStatement.executeUpdate();
        System.out.println("Count rows that updated: " + n);
    }
}