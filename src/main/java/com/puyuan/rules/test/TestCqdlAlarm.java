package com.puyuan.rules.test;
import com.ruleengine.hysc.fact.AlarmBean;
import com.ruleengine.hysc.fact.InsertValue;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class TestCqdlAlarm {

    public static void main(String[] args){
        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = container.newKieSession("alarm_demo");
        AlarmBean alarmBean = new AlarmBean();
        alarmBean.setType("001");
        alarmBean.setUp(50.0d);
        alarmBean.setLower(20.0d);
        InsertValue insertValue = new InsertValue();
        insertValue.setType("001");
        insertValue.setCollectValue(1.0d);
        kieSession.insert(alarmBean);
        kieSession.insert(insertValue);
        int count = kieSession.fireAllRules();
        System.out.println(String.format("总共执行 %d 条规则。",count));
        System.out.println(insertValue.toString());
        kieSession.dispose();
    }
}
