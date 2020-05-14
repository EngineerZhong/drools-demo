package com.puyuan.rules.test;

import com.ruleengine.hysc.fact.AlarmBean;
import com.ruleengine.hysc.fact.InsertValue;
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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dalididilo
 * @date 2020-05-14 15:56:10
 * 测试流程JBPM
 */
public class TestBusinessProgressServer {

    public static final String SERVER_URL = "http://192.168.1.190:8180/kie-server/services/rest/server";
    public static final String PASSWORD = "kieserver1!";
    public static final String USERNAME = "kieserver";
    public static final String KIE_CONTAINER_ID = "hysc_1.1.2";
    public static final String KIE_SESSION_ID = "jbpm_demo";


    public static void main(String[] args){
        // KisService 配置信息设置
        KieServicesConfiguration kieServicesConfiguration =
                KieServicesFactory.newRestConfiguration(SERVER_URL, USERNAME, PASSWORD, 30000L);
        kieServicesConfiguration.setMarshallingFormat(MarshallingFormat.JSON);

        // 创建规则服务客户端
        KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(kieServicesConfiguration);
        RuleServicesClient ruleServicesClient = kieServicesClient.getServicesClient(RuleServicesClient.class);

        // 规则输入条件

        // 命令定义，包含插入数据，执行规则
        KieCommands kieCommands = KieServices.Factory.get().getCommands();
        List<Command<?>> commands = new LinkedList<>();
        AlarmBean alarmBean = new AlarmBean();
        alarmBean.setUp(50);
        alarmBean.setLower(20);
        InsertValue insertValue = new InsertValue();
        insertValue.setCollectValue(11);
        commands.add(kieCommands.newInsert(alarmBean,"bean"));
        commands.add(kieCommands.newInsert(insertValue,"value"));
        commands.add(kieCommands.newStartProcess("alarm_jbpm"));
        commands.add(kieCommands.newGetObjects("value"));
        ServiceResponse<ExecutionResults> results = ruleServicesClient.executeCommandsWithResults(KIE_CONTAINER_ID,
                kieCommands.newBatchExecution(commands, KIE_SESSION_ID));

        // 返回值读取
//        ApplyInfo value = (ApplyInfo) results.getResult().getValue("applyInfo");
        List result = (ArrayList) results.getResult().getValue("value");
        System.out.println("#####服务器状态#####");
        System.out.println(results.getMsg());
        System.out.println(results.getType());
        System.out.println("#####数据结果######");
        System.out.println(((InsertValue)result.get(1)).getGrade());

    }


}
