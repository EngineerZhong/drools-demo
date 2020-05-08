package com.puyuan.rules.test;


import com.puyuan.iotmanager.fact.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * 基础fact实例的规则引擎操作过程。
 * @author 大离弟弟咯。
 */
public class TestOneDrools {

    public static void main(String[] args){
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("One");
//        Person person = new Person();
//        person.setName("大离弟弟咯。");
//        person.setAge(30);
//        kieSession.insert(person);
        int count = kieSession.fireAllRules();
        System.out.println("总共执行了" + count + "条规则。");
        kieSession.dispose();
    }

}
