package com.zlinks.service.util;

import com.zlinks.common.constants.CommonConstant;
import com.zlinks.common.exception.BusinessException;
import com.zlinks.common.utils.HmacSHA256Utils;
import com.zlinks.common.utils.MD5Utils;
import com.zlinks.repository.constants.ResultCodeConstant;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangjh
 * @date 2017/10/25
 */
public enum SignatureUtils {

    INSTANCE;

    /**
     * 生成签名. 注意，若含有sign_type字段，必须和signType参数保持一致。
     *
     * @param data     待签名数据
     * @param key      API密钥
     * @param signType 签名方式
     * @return 签名
     */
    public static String generateSignature(final Map<String, String> data, String key, CommonConstant signType) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals(CommonConstant.FIELD_SIGN.getValue())) {
                continue;
            }
            // 参数值为空，则不参与签名
            if (data.get(k).trim().length() > 0) {
                sb.append(k).append(CommonConstant.EQUALS.getValue()).append(data.get(k).trim()).append("&");
            }

        }

        sb.append(keyStr).append(key);
        String paramStr = sb.toString();
        if (CommonConstant.MD5.equals(signType)) {
            return MD5Utils.encript(paramStr).toUpperCase();
        } else if (CommonConstant.HMACSHA256.equals(signType)) {
            return HmacSHA256Utils.INSTANCE.encript(paramStr, key);
        } else {
            throw new BusinessException(ResultCodeConstant.PARAM_IS_INVALID.getCode(),String.format("Invalid sign_type: %s", signType));
        }
    }

    static String keyStr = "key=";

}
