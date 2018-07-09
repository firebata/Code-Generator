package com.zlinks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjh
 * @date 2017/11/8 10:08
 */
public class HttpRequestTest {


    private static Logger logger = LoggerFactory.getLogger(HttpRequestTest.class.getName());
//
//    public static void main(String[] args) throws Exception {
//
//        final String url = "https://api.zlinks.com.tw/v2/dhh/users/login";
//        Map<String, String> header = getHeaderMap();
//        for (int i = 0; i < 500; i++) {
//            Thread thread = new Thread(() -> {
//                try {
//                    Map<String, String> param = new HashMap<>();
//                    param.put("account", UUID.randomUUID().toString().substring(20));
//                    param.put("openType", "DEVICE");
//                    SSLClient.post(url, header, param, null);
//                } catch (Exception e) {
//                    logger.error(e.getMessage(), e);
//                }
//            });
//            thread.start();
//            thread.setName(String.valueOf(i));
//
//        }
//    }

    private static Map<String, String> getHeaderMap() {
        Map<String, String> header = new HashMap<>();
        header.put("sign", "sss");
        header.put("adId", "sdwerwe");
        header.put("gameId", "1");
        header.put("packageId", "1");
        header.put("versionId", "1");
        header.put("areaId", "886852");
        header.put("devUniqueId", "1122");
        header.put("os", "1");
        header.put("channelId", "1");
        header.put("model", "huawei mate9");
        header.put("Content-type", "application/json");
        return header;
    }

}
