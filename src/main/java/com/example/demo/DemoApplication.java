//package com.example.demo;
//
//import com.puyuan.iotmanager.fact.Address;
//import com.puyuan.iotmanager.fact.ApplyInfo;
//import org.kie.api.KieServices;
//import org.kie.api.command.Command;
//import org.kie.api.command.KieCommands;
//import org.kie.api.runtime.ExecutionResults;
//import org.kie.server.api.marshalling.MarshallingFormat;
//import org.kie.server.api.model.ServiceResponse;
//import org.kie.server.client.KieServicesClient;
//import org.kie.server.client.KieServicesConfiguration;
//import org.kie.server.client.KieServicesFactory;
//import org.kie.server.client.RuleServicesClient;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import javax.annotation.PostConstruct;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * @author dalididilo
// */
//@SpringBootApplication
//public class DemoApplication {
//	public static final String SERVER_URL = "http://192.168.1.190:8180/kie-server/services/rest/server";
//	public static final String PASSWORD = "admin";
//	public static final String USERNAME = "admin";
//	public static final String KIE_CONTAINER_ID = "iotManager_1.0.0-SNAPSHOT";
//
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}
//
//
//	@PostConstruct
//	public void test(){
//		// KisService 配置信息设置
//		KieServicesConfiguration kieServicesConfiguration =
//				KieServicesFactory.newRestConfiguration(SERVER_URL, USERNAME, PASSWORD, 10000L);
//		kieServicesConfiguration.setMarshallingFormat(MarshallingFormat.JSON);
//
//		// 创建规则服务客户端
//		KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(kieServicesConfiguration);
//		RuleServicesClient ruleServicesClient = kieServicesClient.getServicesClient(RuleServicesClient.class);
//
//		// 规则输入条件
//		ApplyInfo applyInfo = new ApplyInfo();
//		Address familyAddress = new Address();
//		familyAddress.setProvince("福建省");
//		applyInfo.setFamilyAddress(familyAddress);
//
//		// 命令定义，包含插入数据，执行规则
//		KieCommands kieCommands = KieServices.Factory.get().getCommands();
//		List<Command<?>> commands = new LinkedList<>();
//		commands.add(kieCommands.newInsert(applyInfo, "applyInfo"));
//		commands.add(kieCommands.newFireAllRules());
//		ServiceResponse<ExecutionResults> results = ruleServicesClient.executeCommandsWithResults(KIE_CONTAINER_ID,
//				kieCommands.newBatchExecution(commands, "KIE-SESSION"));
//
//		// 返回值读取
//		ApplyInfo value = (ApplyInfo) results.getResult().getValue("applyInfo");
//		System.out.println(value);
//	}
//
//}
