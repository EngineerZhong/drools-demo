package com.puyuan.rules.test;

import com.puyuan.iotmanager.fact.School;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.*;

public class TestCollectionList {


    public static void main(String[] args){
        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = container.newKieSession("collection");
        School school = new School();
        List list = new ArrayList();
        list.add("三年一班");
        list.add("三年二班");
        list.add("三年三班");
        Set set = new TreeSet();
        set.add("大离弟弟咯。");
        set.add("罗永浩");
        Map<String,String> map = new HashMap<>();
        map.put("二班","大离弟弟咯");
        map.put("三班","罗永浩。");
        school.setKeyValues(map);
        school.setMemberSet(set);
        school.setClassNameList(list);
        kieSession.insert(school);
        int count = kieSession.fireAllRules();
        System.out.println(String.format("总共执行 %d 条规则。",count));
        kieSession.dispose();


    }

}
