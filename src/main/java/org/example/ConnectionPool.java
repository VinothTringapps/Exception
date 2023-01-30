package org.example;




import java.sql.*;
import java.util.*;
import java.util.logging.*;


public class ConnectionPool {
    private static  ConnectionPool t2=null;
    Logger l=Logger.getLogger("ConnectionPool");
    String databaseName;
    String userName;
    String userPassword;
    Connection con;
    private ConnectionPool(){

    }


    public static  ConnectionPool getInstance(){
        if(t2==null){
            t2 =new ConnectionPool();
        }
        return t2;
    }

    public void create(String name,String user,String password) {
        databaseName=name;
        userName=user;
        userPassword=password;
        try{
            con=DriverManager.getConnection(databaseName,userName,userPassword);
            l.info("Connected Successfully !");
        }
        catch (SQLException e){
            l.info("Sql Connection Interrupted");
        }


    }
    public void closeConnection() {
        try{
            con.close();
            l.info("Connection Closed !");
        }
        catch (SQLException e){
            l.info("Sql Close Interrupted");
        }

    }

    public static void main(String[] args)  {
        Logger l= Logger.getLogger("ConnectionPool");
        Scanner sc=new Scanner(System.in);

        while(true){
            l.info("1.Create Connection \t2.Close Connection");
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    l.info("\nEnter the Database Name :");
                    String databaseName = sc.nextLine();
                    String url = "jdbc:mysql://localhost:3306/" + databaseName;
                    l.info("\nEnter the User Name :");
                    String userName = sc.nextLine();
                    l.info("\nEnter the Password :");
                    String userPassword = sc.nextLine();
                    ConnectionPool c = ConnectionPool.getInstance();
                    c.create(url, userName, userPassword);
                }
                case 2 -> {
                    try {
                        ConnectionPool c = ConnectionPool.getInstance();
                        c.closeConnection();
                    } catch (Exception e) {
                        l.info("The Connection was not Close !");
                    }

                }
                default -> l.info("\n Enter the Correct Choice !");
            }
        }




    }
}