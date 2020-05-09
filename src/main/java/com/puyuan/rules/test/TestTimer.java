package com.puyuan.rules.test;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.TimedRuleExecutionOption;

/**
 * @author dalididilo
 * @date 2020-05-09 09:47:08
 * 规则定时器。
 */
public class TestTimer {


    public static void main(String[] args) throws InterruptedException {
        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
        KieSessionConfiguration configuration = KieServices.Factory.get().newKieSessionConfiguration();
        KieBaseConfiguration baseConfiguration = KieServices.Factory.get().newKieBaseConfiguration();
        configuration.setOption(TimedRuleExecutionOption.YES);

        KieBase base = container.newKieBase("rule13KB",baseConfiguration);
        KieSession session = base.newKieSession(configuration,null);
        session.fireAllRules();
        Thread.sleep(10000);
        session.dispose();
    }


}
