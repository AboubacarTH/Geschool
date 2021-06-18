/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ATH
 */
public class FileManager {
    public FileManager(){
        
    }
    
    public String getServerAdress(){
        String server = "localhost";
        try {
            File file = new File("C:\\Geschool\\database\\database.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                server = reader.nextLine().trim();
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return server;
    }
    
    public void setDataBaseAdress(String adress){
        String value = "".equals(adress)? "localhost" : adress;
        try {
           // TODO code application logic here
                FileWriter dataBaseWriter = new FileWriter("C:\\Geschool\\database\\database.txt");
                dataBaseWriter.write(value);
                dataBaseWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
