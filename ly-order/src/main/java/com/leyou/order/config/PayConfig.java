package com.leyou.order.config;

import com.github.wxpay.sdk.WXPayConfig;
import lombok.Data;

import java.io.InputStream;

/**
 * @author bystander
 * @date 2018/10/5
 */
@Data
public class PayConfig implements WXPayConfig {

    private String appID;  //公众账号ID

    private String mchID;  //商户号

    private String key;  //生成签名的密钥

    private int httpConnectTimeoutMs;   //连接超时时间

    private int httpReadTimeoutMs;  //读取超时时间

    private String notifyUrl;// 下单通知回调地址


    @Override
    public InputStream getCertStream() {
        return null;
    }
}
