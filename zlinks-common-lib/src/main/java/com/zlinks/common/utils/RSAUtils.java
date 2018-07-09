package com.zlinks.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;

/**
 * RAS加密工具类
 */
public class RSAUtils {

    private static  Logger logger = LoggerFactory.getLogger(RSAUtils.class);

    /**
     * 生成公钥和私钥
     *
     * @throws NoSuchAlgorithmException
     */
    public static HashMap<String, Object> getKeys() throws NoSuchAlgorithmException {
        HashMap<String, Object> map = new HashMap<String, Object>();
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        map.put("public", publicKey);
        map.put("private", privateKey);
        return map;
    }

    /**
     * 使用模和指数生成RSA公钥
     * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
     * /None/NoPadding】
     *
     * @param modulus  模
     * @param exponent 指数
     * @return
     */
    public static RSAPublicKey getPublicKey(String modulus, String exponent) {
        try {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 使用密钥字符串生成RSA公钥
     * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
     * /None/NoPadding】
     *
     * @param publicKey 模
     * @return
     */
    public static RSAPublicKey getPublicKey(String publicKey) {
        try {
            byte[] keyBytes = Base64Utils.decode(publicKey);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPublicKey) keyFactory.generatePublic(spec);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 使用模和指数生成RSA私钥
     * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
     * /None/NoPadding】
     *
     * @param modulus  模
     * @param exponent 指数
     * @return
     */
    public static RSAPrivateKey getPrivateKey(String modulus, String exponent) {
        try {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 使用密钥字符串生成RSA私钥
     * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
     * /None/NoPadding】
     *
     * @param privateKey
     * @return
     */
    public static RSAPrivateKey getPrivateKey(String privateKey) {
        try {
            byte[] keyBytes = Base64Utils.decode(privateKey);
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) keyFactory.generatePrivate(spec);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 公钥加密
     *
     * @param data
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String data, RSAPublicKey publicKey)
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        // 模长  
        int key_len = publicKey.getModulus().bitLength() / 8;
        // 加密数据长度 <= 模长-11  
        String[] datas = splitString(data, key_len - 11);
        String mi = "";
        //如果明文长度大于模长-11则要分组加密  
        for (String s : datas) {
            mi += bcd2Str(cipher.doFinal(s.getBytes()));
        }
        return mi;
    }

    /**
     * 私钥解密
     *
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String data, RSAPrivateKey privateKey)
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        //模长  
        int key_len = privateKey.getModulus().bitLength() / 8;
        byte[] bytes = data.getBytes();
        byte[] bcd = ASCII_To_BCD(bytes, bytes.length);
        //如果密文长度大于模长则要分组解密  
        String ming = "";
        byte[][] arrays = splitArray(bcd, key_len);
        for (byte[] arr : arrays) {
            ming += new String(cipher.doFinal(arr));
        }
        return ming;
    }

    /**
     * ASCII码转BCD码
     */
    public static byte[] ASCII_To_BCD(byte[] ascii, int asc_len) {
        byte[] bcd = new byte[asc_len / 2];
        int j = 0;
        for (int i = 0; i < (asc_len + 1) / 2; i++) {
            bcd[i] = asc_to_bcd(ascii[j++]);
            bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));
        }
        return bcd;
    }

    public static byte asc_to_bcd(byte asc) {
        byte bcd;

        if ((asc >= '0') && (asc <= '9')) {
            bcd = (byte) (asc - '0');
        } else if ((asc >= 'A') && (asc <= 'F')) {
            bcd = (byte) (asc - 'A' + 10);
        } else if ((asc >= 'a') && (asc <= 'f')) {
            bcd = (byte) (asc - 'a' + 10);
        } else {
            bcd = (byte) (asc - 48);
        }

        return bcd;
    }

    /**
     * BCD转字符串
     */
    public static String bcd2Str(byte[] bytes) {
        char temp[] = new char[bytes.length * 2], val;

        for (int i = 0; i < bytes.length; i++) {
            val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
            temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');

            val = (char) (bytes[i] & 0x0f);
            temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
        }
        return new String(temp);
    }

    /**
     * 拆分字符串
     */
    public static String[] splitString(String string, int len) {
        int x = string.length() / len;
        int y = string.length() % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        String[] strings = new String[x + z];
        String str = "";
        for (int i = 0; i < x + z; i++) {
            if (i == x + z - 1 && y != 0) {
                str = string.substring(i * len, i * len + y);
            } else {
                str = string.substring(i * len, i * len + len);
            }
            strings[i] = str;
        }
        return strings;
    }

    /**
     * 拆分数组
     */
    public static byte[][] splitArray(byte[] data, int len) {
        int x = data.length / len;
        int y = data.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        byte[][] arrays = new byte[x + z][];
        byte[] arr;
        for (int i = 0; i < x + z; i++) {
            arr = new byte[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(data, i * len, arr, 0, y);
            } else {
                System.arraycopy(data, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }

//    public static void main(String[] args) throws Exception {
//       // TODO Auto-generated method stub
//        HashMap<String, Object> map = RSAUtils.getKeys();
//        //生成公钥和私钥
//        RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
//        RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");
//
///*        //模
//        String modulus = publicKey.getModulus().toString();
//        //公钥指数
//        String public_exponent = publicKey.getPublicExponent().toString();
//        //私钥指数
//        String private_exponent = privateKey.getPrivateExponent().toString();*/
//
//        //使用模和指数生成公钥和私钥
//
//        String publicKeyString = Base64Utils.encode(publicKey.getEncoded());
//        String privateKeyString = Base64Utils.encode(privateKey.getEncoded());
//        System.out.println("publicKey:");
//        System.out.println(publicKeyString);
//        System.out.println("privateKey:");
//        System.out.println(privateKeyString);
//
//
//        publicKeyString ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCl0ccH0E37jvrQ9Lug/Hz1b/TliEGR/ScwBJNhnpe0AA0LK7PtvE676sNPs825hC8y9EY6rKL2M/sRvUWfr70PRmEIiQ9ZvFrIXwPnhm7hPlcBeoma8BpPMA0tbBDtbdAehz7Nj4aWy+Iv0FR8BFmL+V2bSgV5TgoYAgC5K3JCgQIDAQAB";
//        privateKeyString="MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKXRxwfQTfuO+tD0u6D8fPVv9OWIQZH9JzAEk2Gel7QADQsrs+28Trvqw0+zzbmELzL0RjqsovYz+xG9RZ+vvQ9GYQiJD1m8WshfA+eGbuE+VwF6iZrwGk8wDS1sEO1t0B6HPs2PhpbL4i/QVHwEWYv5XZtKBXlOChgCALkrckKBAgMBAAECgYEAnK2Ohg+I37zFuVLFRuPLno1etNL+QdcVhAWOzJpxdR7nNDrjFCrtqhm02kZmiHghsN+mzCH7CO8suCJC+xOuaotM+ihVunJYvWFJFYE8xoKTpED2ljeEhj/tEsMVtHgxWVqrdus06aLYFvEPM7U3711U7j0sQ5KHezibjA6TrwECQQDs14XyLhLR5rq3Xse0DzsRtA6uGkeBCWmbqYTQ3kXiaGVWuCnGtJMuAxuwrDBvnzb7bK0WuotOzUq6MtZ4kS35AkEAszuI81Glmlq4gCVaQHarOHv13zEiyqZYcIqKhp/pjM2hfikz2uU1m3MwEL/OjCnZ34vHcmbbSGYA224FcxD6yQJAeSiP9yImsoYsAl5UHwKjnxzTXbFH3vTnt5/yt77dVUM+hCxWArahjCo+4hRT+uYiBGDF8xie50MR9UrIeIkcUQJBAKjVsSk7xRrE0L3t8bl9z8ZyhucLWzG4RuEksF8mrhNz9OdqGq3dcoUPmbx9Yi0Ik3MQMf3jRDdL1wzc9AczfHkCQQCb1884iNwqnBJVkedcyL+E9bLEhYSDZJDAAYBl2RdlNCI5mWb2x0jkSzSAqZXRCCwiP1H7dFnT3plSM/IPPoIJ";
//        RSAPublicKey pubKey = RSAUtils.getPublicKey(publicKeyString);
//        RSAPrivateKey priKey = RSAUtils.getPrivateKey(privateKeyString);
//
//        //明文
//        String ming = "123456789";
//
//        //加密后的密文
//        String mi = RSAUtils.encryptByPublicKey(ming, pubKey);
//        System.err.println("加密后的密文:"+mi);
//        //解密后的明文
//        ming = RSAUtils.decryptByPrivateKey(mi, priKey);
//        System.err.println("解密后的明文:"+ming);
//
//
//    }


    /**
     * 签名算法
     */
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    /**
     * RSA签名
     *
     * @param content    待签名数据
     * @param privateKey 商户私钥
     * @param encode     字符集编码
     * @return 签名值
     */
    public static String sign(String content, String privateKey, String encode) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64Utils.decode(privateKey));

            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update(content.getBytes(encode));

            byte[] signed = signature.sign();

            return Base64Utils.encode(signed);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    public static String sign(String content, String privateKey) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64Utils.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update(content.getBytes());
            byte[] signed = signature.sign();
            return Base64Utils.encode(signed);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * RSA验签名检查
     *
     * @param content   待签名数据
     * @param sign      签名值
     * @param publicKey 分配给开发商公钥
     * @param encode    字符集编码
     * @return 布尔值
     */
    public static boolean doCheck(String content, String sign, String publicKey, String encode) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64Utils.decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));


            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update(content.getBytes(encode));

            boolean bverify = signature.verify(Base64Utils.decode(sign));
            return bverify;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return false;
    }

    public static boolean doCheckGoogleReceipt(String content, String sign, String publicKey) {
        boolean result = true;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64Utils.decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));


            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);//SIGN_ALGORITHMS

            signature.initVerify(pubKey);
            signature.update(content.getBytes());

            byte[] bt = org.apache.commons.codec.binary.Base64.decodeBase64(sign);
            boolean bverify = signature.verify(bt);
            result = bverify;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = false;
        }

        return result;
    }
}  