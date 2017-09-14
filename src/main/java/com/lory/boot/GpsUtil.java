package com.lory.boot;

import java.io.IOException;

/**
 * Created by l on 2017/9/13.
 */
public class GpsUtil {

    private static final String AMONG_LOCATION = ",";
    private static final String NEW_LOCATION = ";";
    private static final String BAIDU_API = "http://api.map.baidu.com/geoconv/v1/?coords=";
    private static final String POST_STRING = "&from=1&to=5&ak=";
    private static final String BAIDU_KEY = "3053f47ef937c0205f11c05a65dda83e";

    /**
     * Convert GPS to baidu map
     *
     * @return
     */
    public static String convertWGS84ToBD09(double[][] gps) throws IOException {
        String baiduUrl = prepareBaiduApiString(gps);
        System.out.println(baiduUrl);
        String response = null;

        response = HttpUtil.get(baiduUrl);

        return response;
    }

    private static String prepareBaiduApiString(double[][] gps) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gps.length; i++) {
            sb.append(gps[i][0]).append(AMONG_LOCATION);
            sb.append(gps[i][1]).append(NEW_LOCATION);
        }

        return BAIDU_API + sb.toString().substring(0, sb.toString().length() - 1) + POST_STRING + BAIDU_KEY;
    }
}

