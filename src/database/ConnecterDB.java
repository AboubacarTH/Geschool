    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import dialog.DataBaseConnection;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author wankoye
 */
public class ConnecterDB {
    private Connection connection = null;
    private static FileManager fileManager = null;
    private String url = null;
    private String user = null;
    private String password = null;
    
    public ConnecterDB() {
        fileManager = new FileManager();
        url = "jdbc:mysql://"+ fileManager.getServerAdress() +"/geschool";
        user = "geschool";
        password = "geschool";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
            //this.connection=DriverManager.getConnection("jdbc:mysql://"+ fileManager.getServerAdress() +"/sms?user=root&password=ath@database$2021$");
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "connexion non etablie" +e.getMessage());
            JFrame f = new JFrame();
            DataBaseConnection data = new DataBaseConnection(f, true);
            data.setVisible(true);
            System.exit(0);
        }
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }
    public FileManager getFileManager(){
        return fileManager;
    }
}
