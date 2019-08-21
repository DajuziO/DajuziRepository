package WebAutoTest.samples;

import Utils.HttpClientUtils;
import Utils.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

public class HttpClientTest {
    Log log = new Log(this.getClass());
    int responsecode; //返回状态码
    JSONObject responeBody;//返回的消息体
    String volus ;

    String url = "https://test.xcook.cn/xcook/invoice/contents?xcook_token=mf";

    @Test
    public void httpclentTest() throws IOException {
        HttpClientUtils client = new HttpClientUtils();
        /*发送请求*/
        client.getResponse(url);
        responsecode =   client.getCodeInNumber();
        responeBody = client.getBodyInJSON();
        System.out.println(responeBody);
        System.out.println(responsecode);
        String code = responeBody.get("code").toString();
        String datas = responeBody.get("datas").toString();
        JSONObject datasJ = JSON.parseObject(datas);
        System.out.println("datasJ:" + datasJ);
        System.out.println("code" + code);


    }
}
