package com.puyuan.rules.test;

import com.puyuan.iotmanager.fact.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class TestForAll {

    public static void main(String[] args){
        KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("forall_demo");

        Person person = new Person();
        person.setName("大离弟弟咯。");
        person.setAge(25);
        kieSession.insert(person);
        int count = kieSession.fireAllRules();
        System.out.println(String.format("共执行了%d条规则。",count));
        kieSession.dispose();
    }
}
