package com.puyuan.rules.test;

import com.puyuan.iotmanager.fact.Person;
import com.puyuan.iotmanager.fact.School;
import org.drools.core.reteoo.KieComponentFactory;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class TestContains {


    public static void main(String[] args){

        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("memberof");
        Person person = new Person();
        person.setName("大离弟弟咯。");
        person.setAge(25);
        person.setClassName("三年二班");
        School school = new School();
        school.setClassName("三年二班");
        school.setClassNameArray(new String[]{"三年一班","三年二班","三年三班"});
        kieSession.insert(person);
        kieSession.insert(school);
        int count = kieSession.fireAllRules();
        System.out.println(String.format("共执行了%d条规则。",count));
        kieSession.dispose();
    }

}
