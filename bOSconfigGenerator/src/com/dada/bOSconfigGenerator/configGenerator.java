package com.dada.bOSconfigGenerator;

import org.json.JSONArray;
import org.json.JSONObject;

public class configGenerator {
    public static String HandleConfig(JSONObject inputConfig) throws Exception {
        String targetClockRate;
        String targetVoltage;

        try{
            targetClockRate = configFileReader.ConfigReader("hashrate");
            targetVoltage = configFileReader.ConfigReader("voltage");
        }
        catch (Exception e){
            throw e;
        }

        String text = "";
        //replace pools data
        var pools = inputConfig.getJSONArray("pools");

        StringBuilder sb = new StringBuilder();

        sb.append("{\"api-port\":\"4028\",\"pools\":[");

        for (int i = 0; i < pools.length(); i++) { //pools.length()
            JSONObject poolSet = pools.getJSONObject(i);
            var url = poolSet.get("url");

            String[] urlSplitted = url.toString().split("//");
            String newUrl = "";
            if (urlSplitted.length>1){
                newUrl = urlSplitted[0] + "\\/\\/" + urlSplitted[1];
            }
            else {
                newUrl = urlSplitted[0];
            }

            //newUrl = newUrl.replaceAll("//", "\\/\\/"); // This doesnt work.................

            var user = poolSet.get("user");
            var pass = poolSet.get("pass");
            int idNumber = i+1;

            sb.append("{\"_id\":\"" + idNumber + "\",\"url\":\"" + newUrl + "\",\"pass\":\"" + pass + "\",\"user\":\"" + user + "\"}");

            if (i!=pools.length()-1) {
                sb.append(",");
            }
        }

        sb.append("],\"bitmain-freq\":\"" +
                targetClockRate + "," + targetClockRate + ","+targetClockRate+
                ",,,\",\"no-pre-heat\":true,\"api-allow\":\"W:0\\/0\",\"bitmain-voltage\":\"" +
                targetVoltage + "," + targetVoltage + ","+targetVoltage +
                ",,,\",\"config-format-revision\":\"1\",\"api-listen\":true,\"bitmain-use-vil\":true,\"multi-version\":\"4\"}");

        return sb.toString();
    }
}
