/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao 
 * @date: 2018年10月23日 上午10:20:57   
 * @Copyright ©2018 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.gateway.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * TODO
 * 
 * @author: renjinhao
 * @date: 2018年10月23日 上午10:20:57
 * @version: V1.0
 * @review: renjinhao/2018年10月23日 上午10:20:57
 */
//四种情况：熔断、超时、异常、
@Component
public class TestFallback implements FallbackProvider {

    /**
     * TODO
     * 
     * @return
     * @see org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider#getRoute()
     */
    @Override
    public String getRoute() {
        return "*";
    }

    /**
     * TODO
     * 
     * @return
     * @see org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider#fallbackResponse()
     */
    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            //这里是进行了提示
            @Override
            public InputStream getBody() throws IOException
            {//这里是进行了错误提示
                return new ByteArrayInputStream("网关处理异常".getBytes());

            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers=new HttpHeaders();
                headers.put(HttpHeaders.CONTENT_TYPE, Collections.singletonList("text/plain;charset=utf8"));
                return headers;
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 500;
            }

            @Override
            public String getStatusText() throws IOException {
                return "网关处理异常";
            }

            @Override
            public void close() {}
        };
    }

    /**
     * TODO
     * 
     * @param cause
     * @return
     * @see org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider#fallbackResponse(java.lang.Throwable)
     */
    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        cause.printStackTrace();

        return new ClientHttpResponse() {

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("网关处理异常".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers=new HttpHeaders();
                headers.put(HttpHeaders.CONTENT_TYPE, Collections.singletonList("text/plain;charset=utf8"));
                return headers;
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 500;
            }

            @Override
            public String getStatusText() throws IOException {
                return "网关处理异常";
            }

            @Override
            public void close() {}
        };
    }

}
