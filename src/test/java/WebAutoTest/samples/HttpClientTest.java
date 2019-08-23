package WebAutoTest.samples;

import Utils.HttpClientUtils;
import Utils.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HttpClientTest {
    Log log = new Log(this.getClass());
    int responsecode; //返回状态码
    JSONObject responeBody;//返回的消息体
    String volus ;

    String geturl = "https://test.xcook.cn/xcook/invoice/contents?xcook_token=mf";
    String posturl = "";

    /**
     * get请求接口测试
     * @throws IOException
     */
    @Test(enabled = true, invocationCount = 10,threadPoolSize=1)
    public void gethttpclentTest() throws IOException {
        HttpClientUtils client = new HttpClientUtils();
        /**
         * 返回消息体：
         * {"code":400,"datas":{"error":"token数据为空"}}
         */
        /*发送请求*/
        client.getResponse(geturl);
        responsecode =   client.getCodeInNumber();//获取返回的请求code
        responeBody = client.getBodyInJSON();//获取返回的请求消息体，json类型
        System.out.println(responeBody);
        System.out.println(responsecode);
        String code = responeBody.get("code").toString();//将返回的消息体里面的code对应的volues取出来，转换为String类型
        String datas = responeBody.get("datas").toString();
        JSONObject datasJ = JSON.parseObject(datas);//将datas转换为json类型，便于下次的取数
        System.out.println("datasJ:" + datasJ);
        System.out.println("code" + code);
    }

    /**
     * post接口请求测试
     */
    @Test
    public void posthttpclientTest() throws IOException {
        HttpClientUtils client = new HttpClientUtils();
//用NameValuePair的list来添加请求主体参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("xcook_token", "mf"));
        params.add(new BasicNameValuePair("phoneNum", "1861196136"));
//用哈希图准备请求头部信息
        HashMap<String, String> hashHead = new HashMap<String, String>();
        hashHead.put("Content-Type", "application/x-www-form-urlencoded");
//传参发送post请求并接收反馈
        client.sendPost(posturl, params, hashHead);
        responeBody = client.getBodyInJSON();
        responsecode = client.getCodeInNumber();
        System.out.println(responeBody);
//        city = jParser.getCity(responeBody);
    }
}
