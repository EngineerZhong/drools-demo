package com.puyuan.rules.test;

import com.puyuan.iotmanager.fact.Address;
import com.puyuan.iotmanager.fact.ApplyInfo;
import com.puyuan.iotmanager.fact.XiaoMing;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestOneDrl {

    public static void main(final String[] args) {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
//        System.out.println(kc.verify().getMessages().toString());
        execute(kc);
    }

    private static void execute(KieContainer kc) {
        KieSession ksession = kc.newKieSession("ruleOne");

        XiaoMing xiaoMing=new XiaoMing();
        xiaoMing.setMoney(50);
        xiaoMing.setBottle(0);
        xiaoMing.setDrink(0);
        // 命令定义，包含插入数据，执行规则
//        KieCommands kieCommands = KieServices.Factory.get().getCommands();
//        List<Command<?>> commands = new LinkedList<>();
//        commands.add(kieCommands.newInsert(xiaoMing, "xiaoMing"));
//        ksession.execute(commands.get(0));
        ksession.insert(xiaoMing);
        ksession.fireAllRules();
        ksession.dispose();
//        List<String> list = new ArrayList<>();
//        ksession.setGlobal( "myGlobalList", list );
//        ksession.fireAllRules();
//        ksession.dispose();
    }
}
