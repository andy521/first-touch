package org.jadework.learn.listener;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.ApplicationEvent;

/**
 * write Title here
 * <p>
 * write Description here
 * </p>
 *
 * @author Jade ZHANG E-mail:pioneer_zcy@163.com
 * @copyright 2015-2016 sh.lianjia.com.
 * @date 16/5/25
 */

public class BlackListEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String address;
    public String getAddress(){
        return address;
    }
    public BlackListEvent(String address){
        super(address);
        this.address = address;
    }
}
