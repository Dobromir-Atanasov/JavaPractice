package com.dada.bOSconfigGenerator;

import org.json.JSONObject;

public class ConfigHandler {
    public static void GenerateConfig (String sourceFile, String outputFile)throws Exception{
        try {
            JSONObject input = FileReader.ReadFileData(sourceFile);
            String result = configGenerator.HandleConfig(input);
            Write.WriteFile(result, outputFile);
        }
        catch (Exception e){
            throw e;
        }
    }
}
