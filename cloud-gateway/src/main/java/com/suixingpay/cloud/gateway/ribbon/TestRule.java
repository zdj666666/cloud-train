/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao 
 * @date: 2018年10月23日 下午5:57:33   
 * @Copyright ©2018 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.gateway.ribbon;

import java.util.List;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

/**
 * TODO
 * 
 * @author: renjinhao
 * @date: 2018年10月23日 下午5:57:33
 * @version: V1.0
 * @review: renjinhao/2018年10月23日 下午5:57:33
 */
public class TestRule implements IRule {

    private ILoadBalancer loadBalancer;

    /**
     * TODO
     * 
     * @param key
     * @return
     * @see com.netflix.loadbalancer.IRule#choose(java.lang.Object)
     */
    //在这里配置请求服务的算法
    @Override
    public Server choose(Object key) {
        List<Server> servers = loadBalancer.getAllServers();
        for(Server server:servers) {
            if(server.getPort()==2222) {
                return server;
            }
        }
        return null;
    }

    /**
     * TODO
     * 
     * @param lb
     * @see com.netflix.loadbalancer.IRule#setLoadBalancer(com.netflix.loadbalancer.ILoadBalancer)
     */
    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        loadBalancer = lb;
    }

    /**
     * TODO
     * 
     * @return
     * @see com.netflix.loadbalancer.IRule#getLoadBalancer()
     */
    @Override
    public ILoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

}
