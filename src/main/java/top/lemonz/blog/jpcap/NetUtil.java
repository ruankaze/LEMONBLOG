package top.lemonz.blog.jpcap;

import java.io.InputStream;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 代码来自：https://www.oschina.net/code/snippet_1170650_53378
 */
public class NetUtil {

    /**
     * 执行单条指令
     *
     * @param cmd 命令
     * @return 执行结果
     * @throws Exception
     */
    public static String command(String cmd) throws Exception {
        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
        InputStream in = process.getInputStream();
        StringBuilder result = new StringBuilder();
        byte[] data = new byte[256];
        while (in.read(data) != -1) {
            String encoding = System.getProperty("sun.jnu.encoding");
            result.append(new String(data, encoding));
        }
        return result.toString();
    }


    /**
     * 获取mac地址
     *
     * @param ip
     * @return
     * @throws Exception
     */
    public static String getMacAddress(String ip) throws Exception {
        String result = command("arp -a " + ip);
        String regExp = "([0-9A-Fa-f]{2})([-:][0-9A-Fa-f]{2}){5}";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(result);
        StringBuilder mac = new StringBuilder();
        while (matcher.find()) {
            String temp = matcher.group();
            mac.append(temp);
        }
        return mac.toString();
    }

    /**
     * mac地址转byte数组的方法
     */
    public static byte[] stomac(String s) {
        byte[] mac = new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        String[] s1 = s.split("-");
        for (int x = 0; x < s1.length; x++) {
            mac[x] = (byte) ((Integer.parseInt(s1[x], 16)) & 0xff);
        }
        return mac;
    }

    /**
     * 获得本机IP与MAC（只限于本机）
     *
     * @return
     */
    public static Map<String, String> findLocaIpAndMac() throws Exception {
        // 获得本地地址对象
        InetAddress ias = InetAddress.getLocalHost();
        // 获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
        byte[] mac = java.net.NetworkInterface.getByInetAddress(ias).getHardwareAddress();
        // 下面代码是把mac地址拼装成String
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mac.length; i++) {
            if (i != 0) {
                sb.append("-");
            }
            // mac[i] & 0xFF 是为了把byte转化为正整数
            String s = Integer.toHexString(mac[i] & 0xFF);
            sb.append(s.length() == 1 ? 0 + s : s);
        }
        return new HashMap(2) {{
            put("ip", ias.getHostAddress());
            put("mac", sb.toString().toUpperCase());
        }};
    }

}
