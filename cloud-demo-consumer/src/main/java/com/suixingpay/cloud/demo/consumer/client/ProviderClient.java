/**
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao
 * @date: 2018年10月22日 下午6:11:32
 * @Copyright 2018 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.demo.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.suixingpay.cloud.demo.consumer.client.ProviderClient.FallbackConfiguration;
import com.suixingpay.cloud.demo.consumer.client.ProviderClient.TestFallback;

/**
 *
 * @author: renjinhao
 * @date: 2018年10月22日 下午6:11:32
 * @version: V1.0
 * @review: renjinhao/2018年10月22日 下午6:11:32
 */
@FeignClient(name = "cloud-demo-providerzdj", fallback = TestFallback.class, configuration = FallbackConfiguration.class)
@RequestMapping("/demo")
public interface ProviderClient {

    @RequestMapping("/provider")
    public String test1(@RequestParam("p1") Integer p1);

    @RequestMapping("/providers")
    public String test2(@RequestParam("p1") String p1);

    public static class TestFallback implements ProviderClient {

        @Override
        public String test1(Integer p1) {
            return "这里调用的是第一个测试方法！！";
        }

        @Override
        public String test2(String p1) {

            return "这里调用的是第二个测试方法！！！";
        }
    }

    public static class FallbackConfiguration {

        @Bean
        public TestFallback fallbackFactory() {

            return new TestFallback();
        }
    }
}