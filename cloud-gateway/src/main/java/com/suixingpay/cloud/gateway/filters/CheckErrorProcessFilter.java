/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao 
 * @date: 2018年10月23日 上午11:08:02   
 * @Copyright ©2018 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.gateway.filters;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * TODO
 * 
 * @author: renjinhao
 * @date: 2018年10月23日 上午11:08:02
 * @version: V1.0
 * @review: renjinhao/2018年10月23日 上午11:08:02
 */
@Component
public class CheckErrorProcessFilter extends ZuulFilter {

    /**
     * TODO
     * 
     * @return
     * @see com.netflix.zuul.IZuulFilter#shouldFilter()
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * TODO
     * 
     * @return
     * @throws ZuulException
     * @see com.netflix.zuul.IZuulFilter#run()
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        Throwable t = context.getThrowable();
        ZuulException e = (ZuulException) t;
        Throwable rt = e.getCause();
        if (rt instanceof NumberFormatException) {
            HttpServletResponse res = context.getResponse();
            res.setCharacterEncoding("utf-8");
            res.setContentType("text/plain;charset=utf8");
            OutputStream os;
            try {
                os = res.getOutputStream();
                os.write("p2不是数字".getBytes());
                os.flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            }          
        }
        return null;
    }

    /**
     * TODO
     * 
     * @return
     * @see com.netflix.zuul.ZuulFilter#filterType()
     */
    @Override
    public String filterType() {
        return "error";
    }

    /**
     * TODO
     * 
     * @return
     * @see com.netflix.zuul.ZuulFilter#filterOrder()
     */
    @Override
    public int filterOrder() {
        return Integer.MIN_VALUE;
    }

}
