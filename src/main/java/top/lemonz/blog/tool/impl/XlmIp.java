package top.lemonz.blog.tool.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description: tool - 按ip查询归属地
 * path: DecoSearch-manage-com.rerise.tool.impl-XlmIP
 * date: 2019/3/25 0025 14:34
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
public class XlmIp {

    private final static String IPURL = "https://tool.lu/ip/ajax.html";

    /**
     * log4j 日志
     */
    private final static Logger log = LogManager.getLogger(XlmIp.class);

    public static String getDateByIp(String ip) {
        HttpURLConnection httpURLConnection = null;
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        String ipLocation = null;
        int responseCode = 0;
        try {
            //构建post请求
            URL url = new URL(IPURL);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            PrintWriter writer = new PrintWriter(httpURLConnection.getOutputStream());
            //发送数据
            writer.write("ip=" + ip);
            //刷新
            writer.flush();
            //关闭
            writer.close();
            //获取响应码,为200时，才是成功的。
            responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                String json = builder.toString();
                /**
                 * 得到json数据为：{"status":true,"message":"","text":{"ip":"123.125.71.100","l":2071807844,"location":"\u5317\u4eac\u5e02 \u5317\u4eac\u767e\u5ea6\u7f51\u8baf\u79d1\u6280\u6709\u9650\u516c\u53f8\u8054\u901a\u8282\u70b9(BGP)","tb_location":"   ","ipip_location":"\u4e2d\u56fd \u5317\u4eac \u5317\u4eac -","ip2region_location":"\u4e2d\u56fd \u5317\u4eac \u5317\u4eac\u5e02 \u8054\u901a"}}
                 * 分析json结构,其中的location的结果就是归属地信息
                 */
                if (json.length() > 0) {
                    JSONObject jsonObject = JSONObject.parseObject(json);
                    if (jsonObject != null) {
                        JSONObject textJson = JSONObject.parseObject(jsonObject.getString("text"));
                        if (textJson != null) {
                            ipLocation = textJson.getString("location");
                        }
                    }
                }
            } else if (responseCode == 500) {
                log.error("500错误");
            }
        } catch (SocketTimeoutException so) {
            log.error("网速不理想,连接超时");

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //返回ip归属地和运营商信息
        return ipLocation;
    }

}
