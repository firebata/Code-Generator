package com.zlinks.common.helper;

import com.zlinks.common.constants.CommonConstant;
import com.zlinks.common.utils.MD5Utils;
import com.zlinks.common.utils.RSAUtils;
import org.apache.commons.lang3.StringUtils;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public enum SignVerifyHelper {
    INSTANCE;

    /**
     * MD5验证签名
     * @param inputSign sign 签名
     * @param params MD5加密的多个参数
     * @return
     *      true 验证通过
     *      false 验证失败
     */
    public boolean MD5SignVerify(String inputSign, Object... params) {
        boolean result = false;
        StringBuilder signBuilder = new StringBuilder();
        String at = CommonConstant.AT.getValue();

        for(Object object : params){
            if(object != null){
                signBuilder.append(at).append(object);
            }
        }

        String signTemp = signBuilder.toString();
        String signStr = MD5Utils.encript(signTemp).toUpperCase();

        if (StringUtils.isNotBlank(inputSign) && StringUtils.isNotBlank(signStr) && signStr.equals(inputSign)) {
            result = true;
        }
        return result;
    }

    /**
     * RSA签名验证
     * @param inputSign sign 签名
     * @param privateKey RSA私钥
     * @param params RSA加密的多个参数
     * @return
     * @throws Exception
     */
    public boolean RSASignVerify(String inputSign, String privateKey, Object... params) throws Exception {
        boolean result = false;
        StringBuilder signBuilder = new StringBuilder();
        String at = CommonConstant.AT.getValue();

        for(Object object : params){
            if(object != null){
                signBuilder.append(at).append(object);
            }
        }

        String signTemp = signBuilder.toString();

        RSAPrivateKey privateKeyObject = RSAUtils.getPrivateKey(privateKey);
        String signResult = RSAUtils.decryptByPrivateKey(inputSign, privateKeyObject);

        if (StringUtils.isNotBlank(signTemp) && StringUtils.isNotBlank(signResult) && signTemp.equals(signResult)) {
            result = true;
        }

        return result;
    }

}
