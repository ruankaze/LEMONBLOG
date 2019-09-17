package top.lemonz.blog.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description: 测试
 * path: LEMONBLOG-top.lemonz.blog.controller-TestController
 * date: 2019/9/16 0016 17:55
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
public class TestController {

    public static void main(String[] args) throws IOException {
        ClassPathResource resource = new ClassPathResource("static/json/masterinfo.json");
        File filePath = resource.getFile();
        String input = FileUtils.readFileToString(filePath, "UTF-8");
        JSONObject jsonObject = JSON.parseObject(input);
        System.err.println(jsonObject);
    }

}
