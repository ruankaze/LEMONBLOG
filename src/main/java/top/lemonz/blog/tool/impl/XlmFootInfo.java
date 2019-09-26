package top.lemonz.blog.tool.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import top.lemonz.blog.tool.IXlmToolKit;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description: 获得足迹/信息
 * path: DecoSearch-manage-com.rerise.tool.impl-XlmFootInfo
 * date: 2019/3/25 0025 15:26
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
public class XlmFootInfo {

    /**
     * kit
     */
    private static IXlmToolKit kit = new XlmToolKit();

    /**
     * 获得足迹/信息
     */
    public Map<String, String> getNzInfo(HttpServletRequest request) {

        /**
         * 信息存放
         */
        Map<String, String> map = new HashMap<>(16);

        // 获得用户代理对象
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));

        // 获得外网IP - 地区编号 - 地区名 - Json对象
        JSONObject jsonMap = findWip();

        // 1. 获得浏览器名及版本号
        String crBrowser = userAgent.getBrowser().getName() + " " + userAgent.getBrowserVersion().getVersion();
        // 2. 获得操作系统名
        String crOsname = userAgent.getOperatingSystem().getName();
        // 3. 获得操作系统版本号
        String crOsversion = getOsVersion(request.getHeader("User-Agent"));
        // 4. 获得内网IP
        String crNip = getNip();
        // 5. 获得外网IP
        String crWip = jsonMap.getString("cip");
        // 6. 获得地区编号
        String crAddnumber = jsonMap.getString("cid");
        // 7. 获得归属地及运营商
        String crAddress = kit.getIpOperator(crWip);

        map.put("crBrowser", crBrowser);
        map.put("crOsname", crOsname);
        map.put("crOsversion", crOsversion);
        map.put("crNip", crNip);
        map.put("crWip", crWip);
        map.put("crAddnumber", crAddnumber);
        map.put("crAddress", crAddress);

        return map;

    }

    /**
     * 获得内网IP
     *
     * @return
     */
    public static String getNip() {
        String host = "";
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return host;
    }

    /**
     * 获得系统版本号
     *
     * @param userAgent
     * @return
     */
    public static String getOsVersion(String userAgent) {
        String osVersion = "";
        if (kit.isStrNull(userAgent)) {
            return osVersion;
        }
        String[] strArr = userAgent.substring(userAgent.indexOf("(") + 1, userAgent.indexOf(")")).split(";");
        if (null == strArr || strArr.length == 0) {
            return osVersion;
        }
        osVersion = strArr[1];
        return osVersion.substring(1);
    }

    /**
     * 获得外网IP - 地区编号 - 地区名
     *
     * @return
     */
    public JSONObject findWip() {

        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://pv.sohu.com/cityjson?ie=utf-8");

        // 设置ContentType(注:如果只是传普通参数的话,ContentType不一定非要用application/json)
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            if (responseEntity != null) {
                // 去掉无关字符
                String eu = EntityUtils.toString(responseEntity);
                Integer one = eu.indexOf("{") - 1;
                Integer two = eu.length() - 1;
                return JSON.parseObject(eu.substring(one, two));
            }

            // 释放资源
            if (httpClient != null) {
                httpClient.close();
            }
            if (response != null) {
                response.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
