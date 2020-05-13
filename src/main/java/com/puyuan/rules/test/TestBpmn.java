package com.puyuan.rules.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class TestBpmn {


    public static void main(String[] args){
        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = container.newKieSession("hello_bpmn");
        kieSession.startProcess("hello_bpmn");
        kieSession.dispose();
    }


}
