package org.jadework.learn.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

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

public class BlackListNotifier implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event);
        if (event instanceof BlackListEvent){
            System.out.println(((BlackListEvent) event).getAddress());
        }
    }
}
