package top.lemonz.blog.controller;

import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;
import top.lemonz.blog.jpcap.NetUtil;

import java.io.IOException;
import java.net.InetAddress;
import java.util.*;

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

    // 重发间隔时间
    public static Integer TIME = 1;

    /**
     * 输入
     */
    public static Scanner SCANNER = new Scanner(System.in);

    /**
     * 存储IP-Mac键值对
     */
    public static Map<String, String> IPANDMACS = new HashMap<>();

    /**
     * 网卡（必选项）
     */
    public static JpcapSender SENDER;

    /**
     * 网络段（必填项）
     */
    public static String NETSEGMENT = "192.168.9";

    /**
     * 本机网关（必填项）
     */
    public static String MYGATEWAY = "192.168.9.1";

    /**
     * 本机IP
     */
    public static String MYIP;

    /**
     * 本机MAC
     */
    public static String MYMAC;

    /**
     * 是否初始化
     */
    public static Boolean BL = false;

    /**
     * 初始化静态代码块
     */
    static {
        try {
            if (BL) {
                // 扫描本机IP与MAC
                Map<String, String> locaIpAndMac = NetUtil.findLocaIpAndMac();
                // 存储本机IP
                MYIP = locaIpAndMac.get("ip");
                // 存储本机MAC
                MYMAC = locaIpAndMac.get("mac");
                // 扫描并存储网段下所有存活主机的IP与MAC
                IPANDMACS = findAllMacAddress(NETSEGMENT);
                // 选择并打开网卡
                SENDER = openDevice();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {


    }

    /**
     * 扫描并存储网段下所有存活主机的IP与MAC
     *
     * @throws Exception
     */
    private static Map<String, String> findAllMacAddress(String netsegment) throws Exception {
        // 存储 IP-MAC 键值对
        Map<String, String> maps = new HashMap(26);
        // start time
        Long l1 = System.currentTimeMillis();
        // 1. 初始化 1-255 个网络地址，当然也可以自己指定范围
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 255; i++) {
            list.add(netsegment + "." + i);
        }
        Iterator<String> iterator = list.iterator();
        // 2. 扫描当前局域网中所有存活的主机
        System.out.println("开始扫描当前局域网所有存活主机, 预计耗时: 60 秒.");
        while (iterator.hasNext()) {
            // ip（当前ip地址）
            String tarip = iterator.next();
            // mac（执行cmd命令获得MAC地址）
            String tarmac = NetUtil.getMacAddress(tarip);
            // 目标主机的MAC不存在，继续下一轮
            if (tarmac == null || tarmac.equals("")) {
                continue;
            }
            System.out.println("IP-> " + tarip + "   ,   " + "MAC-> " + tarmac);
            // 存储 ip-mac
            maps.put(tarip, tarmac);
        }
        // stop time
        Long l2 = System.currentTimeMillis();
        System.out.println("扫描完成, 一共 " + maps.size() + " 个主机存活, 实际耗时: " + ((l2 - l1) / 1000) + " 秒.");
        return maps;
    }

    /**
     * 选择并打开网卡
     *
     * @return
     */
    private static JpcapSender openDevice() throws IOException {
        // 枚举网卡
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        for (int i = 0; i < devices.length; i++) {
            System.out.println(i + "." + devices[i].description);
        }
        // 选择网卡
        System.out.print("\n选择一个网卡：");
        NetworkInterface device = devices[SCANNER.nextInt()];
        System.out.println("\n-------------------------------------------------\n");
        // 打开设备并返回
        return JpcapSender.openDevice(device);
    }

    /**
     * 转换Ip-Mac
     */
    private static ARPPacket convertIpAndMac() {

        return null;
    }

    /**
     * 构造ARP包请求
     */
    private static ARPPacket constractReqArps(byte[] sender_hardaddr, InetAddress sender_protoaddr, byte[] target_hardaddr, InetAddress target_protoaddr) {
        ARPPacket arp = new ARPPacket();
        arp.hardtype = ARPPacket.HARDTYPE_ETHER;
        arp.prototype = ARPPacket.PROTOTYPE_IP;
        arp.operation = ARPPacket.ARP_REPLY;
        arp.hlen = 6;
        arp.plen = 4;
        arp.sender_hardaddr = sender_hardaddr;
        arp.sender_protoaddr = sender_protoaddr.getAddress();
        arp.target_hardaddr = target_hardaddr;
        arp.target_protoaddr = target_protoaddr.getAddress();
        EthernetPacket ether = new EthernetPacket();
        ether.frametype = EthernetPacket.ETHERTYPE_ARP;
        ether.src_mac = sender_hardaddr;
        ether.dst_mac = target_hardaddr;
        arp.datalink = ether;
        return arp;
    }


}