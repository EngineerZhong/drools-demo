package com.puyuan.rules.test;


import com.puyuan.iotmanager.fact.Person;
import com.puyuan.iotmanager.fact.School;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 from将会遍历集合中的所有对象，并分别匹配它们每一个对象值。
 * @author dalididilo
 * @date 2020-05-11 10:35:44
 */
public class TestFrom {

    public static void main(String[] args){
        KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("from_demo");


        School school = new School();
        Person person = new Person();
        person.setName("大离弟弟咯。");
        person.setClassName("三年二班");
        Person person1 = new Person();
        person1.setName("大离弟弟咯001");
        person1.setClassName("三年三班");
        Person person2 = new Person();
        person2.setName("大离弟弟咯002");
        person2.setClassName("三年二班");
        List<Person> classMemberList = new ArrayList();
        classMemberList.add(person);
        classMemberList.add(person1);
        classMemberList.add(person2);
        school.setClassNameList(classMemberList);

        kieSession.insert(school);
        int count = kieSession.fireAllRules();
        System.out.println(String.format("共执行了%d条规则。",count));
        kieSession.dispose();
    }

}
