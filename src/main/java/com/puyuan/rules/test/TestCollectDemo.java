package com.puyuan.rules.test;

import com.puyuan.iotmanager.fact.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * 测试集合收集列表。
 * @author dalididilo
 * @date 2020年05月11日10:46:18
 */
public class TestCollectDemo {

    public static void main(String[] args){
        KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("collect_demo");

        Person person = new Person();
        person.setName("大离弟弟咯。");
        person.setClassName("三年二班");
        Person person1 = new Person();
        person1.setName("大离弟弟咯001");
        person1.setClassName("三年三班");
        Person person2 = new Person();
        person2.setName("大离弟弟咯002");
        person2.setClassName("三年二班");
        kieSession.insert(person);
        kieSession.insert(person1);
        kieSession.insert(person2);
        int count = kieSession.fireAllRules();
        System.out.println(String.format("共执行了%d条规则。",count));
        kieSession.dispose();
    }

}
