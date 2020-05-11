package com.puyuan.rules.test;


import com.puyuan.iotmanager.fact.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author dalididilo
 * @date 2020-05-11 09:52:24
 *
 * exists Person()
 * not (exists Person())
 */
public class TestExists {


    public static void main(String[] args){
        KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("exist_demo");

        Person person = new Person();
//        kieSession.insert(person);

        int count = kieSession.fireAllRules();

        System.out.println(String.format("共执行了%d条规则。",count));
        kieSession.dispose();
    }


}
