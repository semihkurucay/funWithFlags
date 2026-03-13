/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semihkurucay.main;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author semih
 */
public class Flags {
    
    public static Map<String, String> getFlags(){
        Map<String, String> flags = new HashMap<>();
        
        flags.put("bavaria", "Bavyera");
        flags.put("czech_republic", "Çekya");
        flags.put("liechtenstein", "Lihtenştayn");
        flags.put("moldova", "Moldova");
        flags.put("nepal", "Nepal");
        flags.put("romania", "Romanya");
        flags.put("saint_kitts_and_nevis", "Saint Kitts ve Nevis");
        flags.put("sheldon", "Sheldon");
        flags.put("slovakia", "Slovakya");
        flags.put("united_states", "Amerika Birleşik Devletleri");
        
        return flags;
    }
}
