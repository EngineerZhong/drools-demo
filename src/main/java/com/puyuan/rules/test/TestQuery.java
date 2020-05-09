package com.puyuan.rules.test;

import com.puyuan.iotmanager.fact.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

/**
 * @author dalididilo
 * @date 2020-05-09 10:43:37
 *
 * query 查询语法。
 */
public class TestQuery {

//    public static void main(String[] args){
//        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
//        KieSession kieSession = container.newKieSession("query_demo");
//        Person person1 = new Person("大离弟弟咯1",26);
//        Person person2 = new Person("大离弟弟咯2",25);
//        Person person3 = new Person("大离弟弟咯3",30);
//        kieSession.insert(person1);
//        kieSession.insert(person2);
//        kieSession.insert(person3);
//        QueryResults queryResults = kieSession.getQueryResults("person age is 25");
//        for (QueryResultsRow queryResult : queryResults) {
//            Person p = (Person) queryResult.get("person");
//            System.out.println("输出服务查询条件的实体对象name为" + p.getName());
//        }
////        int count = kieSession.fireAllRules();
////        System.out.println(String.format("总共执行 %d 条规则。",count));
//        kieSession.dispose();
//    }


    public static void main(String[] args){
        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = container.newKieSession("query_demo");
        Person person1 = new Person("大离弟弟咯1",26);
        Person person2 = new Person("大离弟弟咯",25);
        Person person3 = new Person("大离弟弟咯2.5",25);
        Person person4 = new Person("大离弟弟咯3",30);
        kieSession.insert(person1);
        kieSession.insert(person2);
        kieSession.insert(person3);
        kieSession.insert(person4);
        Object[] objects = new Object[]{"大离弟弟咯"};
        QueryResults queryResults = kieSession.getQueryResults(
                "person age is 25 and name is 大离弟弟咯",objects);
        for (QueryResultsRow queryResult : queryResults) {
            Person p = (Person) queryResult.get("person");
            System.out.println("输出服务查询条件的实体对象name为" + p.getName());
        }
//        int count = kieSession.fireAllRules();
//        System.out.println(String.format("总共执行 %d 条规则。",count));
        kieSession.dispose();
    }
}
