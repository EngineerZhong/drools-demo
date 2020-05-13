package com.puyuan.rules.test;

import com.ruleengine.hysc.fact.DroolsResult;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * 测试字符串插入
 * @author dalidididlo
 * @date 2020-05-11 10:08:53
 */
public class TestString {
    public static void main(String[] args){
        KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("string_demo");
        DroolsResult result = new DroolsResult();
        kieSession.setGlobal("res",result);
        kieSession.insert("Hello Drools");
        int count = kieSession.fireAllRules();
        System.out.println(String.format("共执行了%d条规则。",count));
        System.out.println(result.toString());
        kieSession.dispose();
    }
}
