package com.dada.bOSconfigGenerator;

import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Write {
    public static void WriteFile (String outputConfig, String outputFileName){

        try {
            File newTextFile = new File(outputFileName);

            FileWriter fw = new FileWriter(newTextFile);
            fw.write(outputConfig.toString());
            fw.close();

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
    }
}
