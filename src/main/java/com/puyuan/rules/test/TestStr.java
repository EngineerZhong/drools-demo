package com.puyuan.rules.test;

import com.puyuan.iotmanager.fact.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class TestStr {
    public static void main(String[] args){
        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = container.newKieSession("str");
        Person person = new Person();
        person.setName("大离弟弟咯。");
        kieSession.insert(person);
        int count = kieSession.fireAllRules();
        System.out.println(String.format("共执行 %d 条规则",count));
        kieSession.dispose();
    }
}
