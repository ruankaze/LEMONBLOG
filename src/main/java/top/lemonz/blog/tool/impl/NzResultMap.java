package top.lemonz.blog.tool.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.lemonz.blog.tool.IXlmToolKit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description: nz result map
 * path: DecoSearch-manage-com.rerise.tool.impl-NzResultMap
 * date: 2019/8/28 0028 16:34
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
public class NzResultMap {

    /**
     * kit
     */
    @Autowired
    private static IXlmToolKit kit;

    public static String build(String code, String msg, Object result) {
        Map<String, Object> map = new HashMap(2);
        map.put("code", code);
        map.put("msg", msg);
        map.put("result", result);
        return kit.parseJackson(map);
    }

    public static String aslayui(Integer count, List<?> list) {
        Map<String, Object> map = new HashMap(4);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", list);
        return kit.parseJackson(map);
    }

}
