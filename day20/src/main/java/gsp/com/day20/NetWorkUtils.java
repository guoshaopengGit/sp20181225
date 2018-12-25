package gsp.com.day20;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
        * guo
        */
public class NetWorkUtils {

    /**
     * 请求网络图片
     *
     * @param mUrl 接口地址
     * @return bitmap
     */
    public static Bitmap getBitmpa(String mUrl) {
        try {

            URL url = new URL(mUrl);//封装url接口
            //打开了连接
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = urlConnection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            } else {
                Log.e("wzq", "responseCode---bitmap:" + responseCode);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getJson(String urlString) {
        try {

            URL url = new URL(urlString);//封装url接口
            //打开了连接
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp="";
                StringBuilder stringBuilder = new StringBuilder();
                while ((temp  =bufferedReader.readLine()) != null){
                    stringBuilder.append(temp);

                }
                return  stringBuilder.toString();


            } else {
                Log.e("wzq", "responseCode---json:" + responseCode);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "";

    }
}
