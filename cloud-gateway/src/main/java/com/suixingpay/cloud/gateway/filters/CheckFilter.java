/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao 
 * @date: 2018年10月23日 上午10:17:53   
 * @Copyright ©2018 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.gateway.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author: renjinhao
 * @date: 2018年10月23日 上午10:17:53
 * @version: V1.0
 * @review: renjinhao/2018年10月23日 上午10:17:53
 */
@Component
public class CheckFilter extends ZuulFilter {

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
        HttpServletRequest req = context.getRequest();
        String p2 = req.getParameter("p2");
        Integer.valueOf(p2);
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
        return "pre";
    }

    /**
     * TODO
     * 
     * @return
     * @see com.netflix.zuul.ZuulFilter#filterOrder()
     */
    @Override
    public int filterOrder() {
        return 0;
    }

}
