/**
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao
 * @date: 2018年10月22日 下午6:17:24
 * @Copyright 2018 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.demo.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suixingpay.cloud.demo.consumer.client.ProviderClient;

/**
 * @author: renjinhao
 * @date: 2018年10月22日 下午6:17:24
 * @version: V1.0
 * @review: renjinhao/2018年10月22日 下午6:17:24
 */
@RestController
@RequestMapping("/demo")
public class TestConsumerController {

    @Autowired
    private ProviderClient client;
    @Autowired
    private Environment env;

    @RequestMapping("/consumer")
    public String test1(String p1) {
        return env.getProperty("server.port") + ":" + client.test2(p1);
    }
}