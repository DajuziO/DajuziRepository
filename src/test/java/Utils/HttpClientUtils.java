package Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.util.HashMap;

public class HttpClientUtils {
    CloseableHttpClient httpclient;
    HttpGet httpGet;
    CloseableHttpResponse httpResponse;
    int responseCode;
    JSONObject responseBody;
    HashMap<String, String> responseHeads;

    //通过httpclient获取请求的反馈
    public void getResponse(String url) throws IOException {
        httpclient = HttpClients.createDefault();
        httpGet = new HttpGet(url);
        httpResponse = httpclient.execute(httpGet);
    }

    //以JSON格式获取到反馈的主体
    public JSONObject getBodyInJSON() throws IOException{
        HttpEntity entity;
        String entityToString;
        entity = httpResponse.getEntity();
        entityToString = EntityUtils.toString(entity);
        responseBody = JSON.parseObject(entityToString);
//        System.out.println("This is your response body" + responseBody);
        return responseBody;
    }

    //以哈希图的方式获取到反馈头部
    public HashMap<String, String> getHeaderInHash(){
        Header[] headers;
        headers = httpResponse.getAllHeaders();
        responseHeads = new HashMap<String, String>();
        for(Header header:headers){
            responseHeads.put(header.getName(), header.getValue());
        }
//        System.out.println("This is your response header" + responseHeads);
        return  responseHeads;
    }

    //获取反馈状态码
    public int getCodeInNumber(){
        responseCode = httpResponse.getStatusLine().getStatusCode();
//        System.out.println("This is your response code" + responseCode);
        return responseCode;
    }

}
