package com.json;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangchangling on 2017/8/24 0024
 */
public class JsonTest {

    @Test
    public void testString(){
        String jsonStr = "{\n" +
                "  \"code\": 200,\n" +
                "  \"msg\": \"{\\\"T097297873\\\":1}\"\n" +
                "}";
        net.sf.json.JSONObject resultJson = net.sf.json.JSONObject.fromObject(jsonStr);
        int code = resultJson.getInt("code");
        String msg = resultJson.getString("msg");
        System.out.println(code + "---->" + msg);
        Map map = new HashMap<String,String>();

        String productId = "123424";
        map.put("productId",productId);
        String ret = com.alibaba.fastjson.JSONObject.toJSONString(map);
        System.out.println(ret);
    }
    @Test public void testJsonString(){
        String addition = "20171031";
        String json = "{tntSellPackageId:" + 1 + ",addition:\"" + addition +"\"}";
        System.out.println(json);
    }
}
