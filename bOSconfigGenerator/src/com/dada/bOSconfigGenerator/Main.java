package com.dada.bOSconfigGenerator;

import org.json.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        String sourceFileName = "bmminer.conf"; //  Antminer original file location: /config/bmminer.conf
        String outputFileName = "cgminer.conf"; // Antminer new file location: /etc/cgminer.conf

        String loginUserName = configFileReader.ConfigReader("username"); //Amtminer SSH login
        String loginPassword = configFileReader.ConfigReader("password"); //Amtminer SSH login

        ConfigHandler.GenerateConfig(sourceFileName, outputFileName);
    }
}
