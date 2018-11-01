/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao 
 * @date: 2018年10月22日 下午3:45:18   
 * @Copyright ©2018 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.demo.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author: renjinhao
 * @date: 2018年10月22日 下午3:45:18
 * @version: V1.0
 * @review: renjinhao/2018年10月22日 下午3:45:18
 */
@RestController
@RequestMapping("/demo")
public class TestProviderController {

    @Autowired
    private Environment env;

    @RequestMapping("/provider")
    public String test1(@RequestParam Integer p1) {
        System.out.println("收到请求，p1=" + p1);
        return env.getProperty("server.port");
    }

    @RequestMapping("/providers")
    public String test2(String p1) {
        System.out.println("我长得俊通过服务消费者来这里走了一下~");
        return "张的钧6666666";
    }


}
