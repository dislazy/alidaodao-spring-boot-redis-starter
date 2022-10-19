package com.alidaodao.app.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jack
 * @since 2022-10-02
 */
public class IpUitls {


    private static final String UNKNOWN = "unknown";
    private static final String LOCALHOST = "127.0.0.1";
    private static final String SEPARATOR = ",";



    /**
     * 是否是ipv4
     *
     * @param ipAddress
     * @return
     */
    public static boolean isIpv4(String ipAddress) {
        String ip = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                + "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }

    /**
     * 获取本地ip
     *
     * @return
     */
    public static String getLocalIp() {
        String localip = null;
        String netip = null;
        try {
            Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            boolean finded = false;
            do {
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                Enumeration address = ni.getInetAddresses();
                while (address.hasMoreElements()) {
                    ip = (InetAddress) address.nextElement();

                    if ((!ip.isSiteLocalAddress()) && (!ip.isLoopbackAddress()) &&
                            (ip.getHostAddress().indexOf(":") == -1)) {
                        netip = ip.getHostAddress();
                        finded = true;
                        break;
                    }
                    if ((ip.isSiteLocalAddress()) &&
                            (!ip.isLoopbackAddress()) &&
                            (ip.getHostAddress().indexOf(":") == -1)) {
                        localip = ip.getHostAddress();
                    }
                }
                if (!netInterfaces.hasMoreElements()) {
                    break;
                }
            } while (!finded);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        if ((netip != null) && (!"".equals(netip))) {
            return netip;
        }
        return localip;
    }

    public static void main(String[] args) {
        String localIp = getLocalIp();
        System.out.println(isIpv4(localIp));
    }
}
