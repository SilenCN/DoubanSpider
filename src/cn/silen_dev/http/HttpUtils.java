package cn.silen_dev.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
    public static String getHtml(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(3000);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        StringBuilder result=new StringBuilder();
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line=null;
            while ((line=reader.readLine())!=null){
                result.append(line);
                result.append("\n");
            }
        }
        connection.disconnect();
        return result.toString();
    }
}
