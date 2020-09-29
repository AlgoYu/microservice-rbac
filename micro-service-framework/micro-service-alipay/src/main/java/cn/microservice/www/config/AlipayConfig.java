package cn.microservice.www.config;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: MachineGeek
 * @Description: 支付宝初始化
 * @Date: 2020/9/29 9:13
 */
@Component
public class AlipayConfig implements ApplicationRunner {
    @Value("${alipay.appId}")
    private String appId;
    @Value("${alipay.merchantPrivateKey}")
    private String merchantPrivateKey;
    @Value("${alipay.alipayPublicKey}")
    private String alipayPublicKey;
    @Value("${alipay.notifyUrl}")
    private String notifyUrl;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipay.com";
        config.signType = "RSA2";

        config.appId = this.appId;

        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = this.merchantPrivateKey;

        //注：证书文件路径支持设置为文件系统中的路径或CLASS_PATH中的路径，优先从文件系统中加载，加载失败后会继续尝试从CLASS_PATH中加载
        //config.merchantCertPath = "<-- 请填写您的应用公钥证书文件路径，例如：/foo/appCertPublicKey_2019051064521003.crt -->";
        //config.alipayCertPath = "<-- 请填写您的支付宝公钥证书文件路径，例如：/foo/alipayCertPublicKey_RSA2.crt -->";
        //config.alipayRootCertPath = "<-- 请填写您的支付宝根证书文件路径，例如：/foo/alipayRootCert.crt -->";

        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        config.alipayPublicKey = this.alipayPublicKey;

        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = this.notifyUrl;

        //可设置AES密钥，调用AES加解密相关接口时需要（可选）
        //config.encryptKey = "<-- 请填写您的AES密钥，例如：aa4BtZ4tspm2wnXLb1ThQA== -->";

        // 1. 设置参数（全局只需设置一次）
        Factory.setOptions(config);
    }
}
