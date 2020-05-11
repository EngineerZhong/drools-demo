package com.puyuan.rules.test;

import com.puyuan.iotmanager.fact.Person;
import com.puyuan.iotmanager.fact.School;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


/**
 * @author dalididilo
 * @date 2020-05-09 15:42:47
 * 复合规则。
 * in
 * not in
 */
public class TestInOrNotIn {


    public static void main(String[] args){
        KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("inornotin");
        Person person = new Person();
        person.setClassName("二班");
        kieSession.insert(person);
        School school = new School();
        school.setClassName("二班");
        kieSession.insert(school);
//        Person person2 = new Person();
//        person.setClassName("八班");
//        kieSession.insert(person2);
        int count = kieSession.fireAllRules();
        System.out.println(String.format("总共执行 %d 条规则。",count));
        kieSession.dispose();
    }

}
