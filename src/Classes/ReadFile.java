/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Rolando Sorrentino
 */
public class ReadFile {
   
    /**
     * Sobreescribe el archivo de texto dentro del proyecto
     * @param txt (String que contiene la información del archivo de texto leído)
     */
    public void printTxt(String txt) {
        try {
            File file = new File("test\\config.txt");
            PrintWriter pw = new PrintWriter("test\\config.txt");
            pw.print(txt);
            JOptionPane.showMessageDialog(null, "Se ha cambiado la configuración!");
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e);
        }
    }
    
    /**
     * Agrega información al archivo de texto del proyecto
     * @param txt 
     */
    public void appendTxt(String txt) {
        try {
            File file = new File("test\\config.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            pw.append(txt);
            pw.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e);
        }
    }
       
    
    /**
     * Lee un archivo de texto línea por línea y lo convierte en un string
     * @param path (Dirección donde se encuentra el archivo de texto a leer)
     * @return String que contiene la información del archivo de texto
     */
    public String readTxt() {
        String line;
        String txt = "";
        File file = new File("test\\config.txt");
        ReadFile nfile = new ReadFile();
        try {
           if (!file.exists()) {
                file.createNewFile(); 
                
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                       if (line.contains("General") || line.contains("Lamborghini") || line.contains("Maserati")) {
                            txt += "~" + "\n";
                       
                        } else {
                            txt += line + "\n";
                       }
                    }
                    
                } 
                br.close();
                
                return txt; 
            }

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e);
        }
        return null;
    }
    
    public Config readConfig(String txt, Config config) {
        
        String[] configs = txt.split("~");
        
        String[] general = configs[0].split("\n");
        
        //General config
        config.setDayDuration(Integer.parseInt(general[1]));
        config.setDeliveryDays(Integer.parseInt(general[3]));
        
        //Lamborghini config
            
        return null;
    }
   
}
