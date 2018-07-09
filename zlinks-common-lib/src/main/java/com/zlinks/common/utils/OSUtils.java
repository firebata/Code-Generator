package com.zlinks.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author zhangjh
 * @date 2017/11/2 18:43
 */
public class OSUtils {

    private static  Logger logger = LoggerFactory.getLogger(OSUtils.class);

    /**
     * 获取unix网卡的mac地址.
     * 非windows的系统默认调用本方法获取.如果有特殊系统请继续扩充新的取mac地址方法.
     *
     * @return mac地址
     */
    public static String getMACAddress() {
        String mac;
        Properties props = System.getProperties(); //获得系统属性集
        String osName = props.getProperty("os.name"); //操作系统名称
        if (osName.contains("Mac OS")) {
            mac = getMacMACAddress();
        } else if (osName.contains("Windows")) {
            mac = getWindowsMACAddress();
        } else {
            mac = getUnixAddress();
        }
        if (StringUtils.isBlank(mac)) {
            mac = getIpAddress();
        }
        return mac;
    }

    private static String getUnixAddress() {
        String mac = null;
        BufferedReader bufferedReader = null;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("ifconfig eth0");// linux下的命令，一般取eth0作为本地主网卡 显示信息中包含有mac地址信息
            bufferedReader = new BufferedReader(new InputStreamReader(process
                    .getInputStream()));
            String line = null;
            int index = -1;
            while ((line = bufferedReader.readLine()) != null) {
                index = line.toLowerCase().indexOf("hwaddr");// 寻找标示字符串[hwaddr]
                if (index >= 0) {// 找到了
                    mac = line.substring(index + "hwaddr".length() + 1).trim();//  取出mac地址并去除2边空格
                    break;
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        return mac;
    }

    private static String getMacMACAddress() {
        String mac = "localhosts";
        try {
            Enumeration<NetworkInterface> ie = NetworkInterface.getNetworkInterfaces();
            while (ie.hasMoreElements()) {
                NetworkInterface i = ie.nextElement();
                if ("en0".equals(i.getName())) {
                    mac = formatAddress(i.getHardwareAddress());
                    break;
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return mac;

    }

    private static String formatAddress(byte[] address) {
        if (address == null) {
            return null;
        }

        StringBuilder ret = new StringBuilder(address.length * 2);
        for (byte b : address) {
            if (ret.length() > 0) {
                ret.append('-');
            }

            String bs = Integer.toHexString(b & 0x000000FF).toUpperCase();
            if (bs.length() < 2) {
                ret.append('0');
            }
            ret.append(bs);
        }

        return ret.toString();
    }

    /**
     * 获取widnows网卡的mac地址.
     *
     * @return mac地址
     */
    public static String getWindowsMACAddress() {
        String mac = null;
        BufferedReader bufferedReader = null;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("ipconfig /all");// windows下的命令，显示信息中包含有mac地址信息
            bufferedReader = new BufferedReader(new InputStreamReader(process
                    .getInputStream()));
            String line = null;
            int index = -1;
            while ((line = bufferedReader.readLine()) != null) {
                index = line.toLowerCase().indexOf("physical address");// 寻找标示字符串[physical address]
                if (index >= 0) {// 找到了
                    index = line.indexOf(":");// 寻找":"的位置
                    if (index >= 0) {
                        mac = line.substring(index + 1).trim();//  取出mac地址并去除2边空格
                    }
                    break;
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e1) {
                logger.error(e1.getMessage(), e1);
            }
        }

        return mac;
    }

    /**
     * 获取hostanme
     *
     * @return
     */
    public static String getIpAddress() {

        String ipAddress = "";
        Enumeration allNetInterfaces;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                Enumeration addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    ip = (InetAddress) addresses.nextElement();
                    if (ip != null && ip instanceof Inet4Address) {
                        ipAddress = ip.getHostAddress();
                    }

                }
            }
        } catch (SocketException e) {
            logger.error(e.getMessage(), e);
        }


        return ipAddress;
    }

}
