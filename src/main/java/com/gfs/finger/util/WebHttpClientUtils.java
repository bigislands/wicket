package com.gfs.finger.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class WebHttpClientUtils {

    public static byte[] call(String url,byte[] data){
        CloseableHttpClient httpClient = createHttpClient();
        byte[] result = null;
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new ByteArrayEntity(data));
        httpPost.setHeader("Content-type", "application/octet-stream;charset=UTF-8");
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                HttpEntity entity = httpResponse.getEntity();
                if(entity !=null){
                    result = EntityUtils.toByteArray(entity);
                    int contentLength = (int) entity.getContentLength();
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(contentLength);
//                if(contentLength<=0) {
//                    throw new IOException("No response");
//                }
//                int total = 0;
//                int len;
//                byte[] respBuffer = new byte[contentLength];
//                result = new byte[contentLength];
//                while ((len = entity.getContent().read(respBuffer))!= -1){
//                    for(int i=0;i<len;i++){
//                       result[total+i] = respBuffer[i];
//                    }
//                    total = total + len;
//                }
//                System.out.println(entity.getContent().read(respBuffer,0,contentLength));
//                if(total != respBuffer.length){
//                    throw new IOException("读取错误");
//                }
                }
                close(httpResponse);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    private static CloseableHttpClient createHttpClient(){
        RequestConfig.Builder defaultConfig = RequestConfig.custom();
        defaultConfig.setConnectTimeout(300 * 1000);
        defaultConfig.setSocketTimeout(300 * 1000);
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().setDefaultRequestConfig(defaultConfig.build()).build();
        return closeableHttpClient;
    }

    private static void close(Closeable e) {
        try {
            e.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
