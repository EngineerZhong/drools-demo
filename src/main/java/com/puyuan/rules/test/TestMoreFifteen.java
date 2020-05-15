package com.puyuan.rules.test;

import com.ruleengine.hysc.fact.AlarmBean;
import com.ruleengine.hysc.fact.InsertValue;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author dalididilo
 */
public class TestMoreFifteen {

//    public static void main(String[] args){
//        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
//        KieSession kieSession = container.newKieSession("morefifteenalarm_demo");
////        kieSession.setGlobal("alarmCount",new ArrayList<Integer>());
//        AlarmBean alarmBean = new AlarmBean();
//        alarmBean.setUp(50);
//        alarmBean.setLower(20);
//        kieSession.insert(alarmBean);
//
//        int count = 1;
//        while(count < 18){
//            count++;
//            InsertValue insertValue = new InsertValue();
//            double collectValue = new Random().nextDouble() * 100.0 + 1;
////            double collectValue = 25.0;
//            System.out.println("采集值" + collectValue);
//            insertValue.setCollectValue(collectValue);
//            kieSession.insert(insertValue);
//            kieSession.fireAllRules();
//        }
//        kieSession.getAgenda().getAgendaGroup("detail").setFocus();
//        kieSession.fireAllRules();
////        System.out.println("共执行"+ (count -1) +"条规则");
//        Collection<?> objects = kieSession.getObjects();
//        System.out.println(objects);
////        System.out.println("总条数：：：" + ((ArrayList)kieSession.getGlobal("count")).size());
////        System.out.println("告警条数：：：" + ((ArrayList)kieSession.getGlobal("alarmCount")).size());
////        System.out.println(String.format("总共执行 %d 条规则。",count));
//    }

    public static void main(String[] args){
        int count = 0;
        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = container.newKieSession("morefifteenalarm_demo");
        AlarmBean alarmBean = new AlarmBean();
        alarmBean.setUp(50);
        alarmBean.setLower(20);
        kieSession.insert(alarmBean);
        while(count < 20){
            count++;
            int i = 0;
            while(i < 100){
                i++;
                InsertValue insertValue = new InsertValue();
                double collectValue = new Random().nextDouble() * 100 + 1;
                insertValue.setCollectValue(collectValue);
                insertValue.setDeviceId(i + "_device");
                TestMoreFifteen.testRule(insertValue,kieSession);
            }
        }
        kieSession.getAgenda().getAgendaGroup("detail").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    public static void testRule(InsertValue insertValue, KieSession kieSession){
        kieSession.insert(insertValue);
        kieSession.fireAllRules();
    }

}
