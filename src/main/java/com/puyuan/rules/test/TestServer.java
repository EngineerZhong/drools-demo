package com.puyuan.rules.test;

import com.puyuan.iotmanager.fact.Address;
import com.puyuan.iotmanager.fact.ApplyInfo;
import com.puyuan.iotmanager.fact.XiaoMing;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;

import java.util.LinkedList;
import java.util.List;


/**
 * kieServer 远端执行规则引擎案例。
 * @author dalididilo
 */
public class TestServer {

    public static final String SERVER_URL = "http://192.168.1.190:8180/kie-server/services/rest/server";
    public static final String PASSWORD = "kieserver1!";
    public static final String USERNAME = "kieserver";
    public static final String KIE_CONTAINER_ID = "iotmanager_1.0.1";
    public static final String KIE_SESSION_ID = "ksessionId";

    public static void main(String[] args){
        // KisService 配置信息设置
        KieServicesConfiguration kieServicesConfiguration =
                KieServicesFactory.newRestConfiguration(SERVER_URL, USERNAME, PASSWORD, 30000L);
        kieServicesConfiguration.setMarshallingFormat(MarshallingFormat.JSON);

        // 创建规则服务客户端
        KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(kieServicesConfiguration);
        RuleServicesClient ruleServicesClient = kieServicesClient.getServicesClient(RuleServicesClient.class);

        // 规则输入条件
        ApplyInfo applyInfo = new ApplyInfo();
        Address familyAddress = new Address();
        familyAddress.setProvince("福建省");
        applyInfo.setFamilyAddress(familyAddress);
        applyInfo.setAge(19);
        XiaoMing xiaoMing=new XiaoMing();
        xiaoMing.setMoney(50);

        // 命令定义，包含插入数据，执行规则
        KieCommands kieCommands = KieServices.Factory.get().getCommands();
        List<Command<?>> commands = new LinkedList<>();

//        commands.add(kieCommands.newInsert(applyInfo, "applyInfo"));
        commands.add(kieCommands.newInsert(xiaoMing, "m"));
        commands.add(kieCommands.newFireAllRules("ming"));
        ServiceResponse<ExecutionResults> results = ruleServicesClient.executeCommandsWithResults(KIE_CONTAINER_ID,
                kieCommands.newBatchExecution(commands, KIE_SESSION_ID));

        // 返回值读取
        ApplyInfo value = (ApplyInfo) results.getResult().getValue("applyInfo");
        System.out.println(value.getName());
    }

}
