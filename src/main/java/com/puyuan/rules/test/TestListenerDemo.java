package com.puyuan.rules.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author dalididilo
 * @date 2020-05-14 10:01:08
 * 测试监听器
 * 三个操作内存对象方法的监听。
 */
public class TestListenerDemo {


    public static void main(String[] args){
        KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("test_listener_demo");
        kieSession.addEventListener(new RunTimeImpl());
        int count = kieSession.fireAllRules();
        System.out.println(String.format("总共执行 %d 条规则。",count));
        kieSession.dispose();
    }


}
