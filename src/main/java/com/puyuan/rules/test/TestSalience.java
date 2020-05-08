package com.puyuan.rules.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class TestSalience {


    public static void main(String[] args){
        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = container.newKieSession("salience");
        int count = kieSession.fireAllRules();
        System.out.println(String.format("总共执行 %d 条规则。",count));
        kieSession.dispose();
    }


}
