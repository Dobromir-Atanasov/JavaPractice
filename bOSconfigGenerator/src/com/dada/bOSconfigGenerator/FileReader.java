package com.dada.bOSconfigGenerator;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {
    public static JSONObject ReadFileData(String fileName){
        BufferedReader br = null;
        java.io.FileReader fr = null;
        StringBuilder sb = new StringBuilder();

        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new java.io.FileReader(fileName);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                sb.append(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }


            JSONObject obj = new JSONObject(sb.toString());
            return obj;
        }
    }
}
