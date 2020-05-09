package com.puyuan.rules.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author dalididilo
 * @date 2020-05-09 14:36:52
 *
 * function
 * import static
 * eval(function())、函数返回值与事实属性对比。
 */
public class TestFunction {

    public static void main(String[] args){
        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = container.newKieSession("function_demo");
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
