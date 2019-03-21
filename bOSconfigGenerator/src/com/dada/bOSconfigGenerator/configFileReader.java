package com.dada.bOSconfigGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class configFileReader {
    public static List IPsReader () throws Exception {
        List<String> ips = new ArrayList<>();
        File file = new File("IPList.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null){
            if (!st.startsWith(";") && !st.startsWith("//")){
                // System.out.println(st);
                ips.add(st);
            }
        }

        return ips;
    }
    public static String ConfigReader (String dataNeeded) throws Exception {
        File file = new File("Config.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null){
            if (st.startsWith(dataNeeded)){
                // System.out.println(st);
                return st.split("=")[1].trim();
            }
        }
        return "";
    }
}
