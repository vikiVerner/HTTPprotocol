package org.example;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    private static final String catURL = "https://http.cat/";
    public String getStatusImage(int code) {
        try{
            String result = "";
            URL url = new URL(catURL+code);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if(responseCode == 404){
                throw new IllegalArgumentException();
            }else{
                result = catURL+code;
            }
            return result;
        } catch (IOException e){
           throw new RuntimeException(e);
        }
    }
}
