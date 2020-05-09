package com.puyuan.rules.test;

import com.puyuan.iotmanager.fact.Person;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import java.util.ArrayList;

public class TestGlobal {

    public static void main(String[] args) {
        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = container.newKieSession("global_demo");
        kieSession.setGlobal("count",2017);
        Person person = new Person();
        person.setAge(2);
        person.setName("大离");
        kieSession.insert(person);
        kieSession.setGlobal("list",new ArrayList<>());
        kieSession.setGlobal("person",person);
        int count = kieSession.fireAllRules();
        System.out.println(kieSession.getGlobal("count"));
        System.out.println(kieSession.getGlobal("person"));
        System.out.println(String.format("总共执行 %d 条规则。",count));
        kieSession.dispose();
    }
}
