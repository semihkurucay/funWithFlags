package com.semihkurucay.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Flags {
    
    public static Map<String, String> getFlags(){
        Map<String, String> flags = new HashMap<>();
        
        try{
            InputStream in = Flags.class.getResourceAsStream("/flag_names.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            
            String line;
            
            while((line = reader.readLine()) != null){
                if(!line.trim().isEmpty()){
                    String[] names = line.split(",");
                    flags.put(names[0], names[1]);
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "flag_names.txt okunurken hata ile karşılaşıldı.", "flag_names.txt Okunamadı", JOptionPane.ERROR_MESSAGE);
        }
        
        return flags;
    }
}
