package com.lory.boot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * Created by l on 2017/9/13.
 */
public class HttpUtil {

    public static String get(String httpUrl) throws IOException {
        URL url = new URL(httpUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("Content-Type", "application/json");
        BufferedReader in = null;
        if ("gzip".equals(con.getContentEncoding())) {
            in = new BufferedReader(new InputStreamReader( new GZIPInputStream(con.getInputStream())));
        } else {
            in = new BufferedReader(new InputStreamReader( con.getInputStream()));
        }
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return content.toString();
    }

}
