package com.puyuan.rules.test;

import com.ruleengine.hysc.fact.AlarmBean;
import com.ruleengine.hysc.fact.InsertValue;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author dalididilo
 * @date 2020-05-13 10:47:28
 */
public class TestXlsxDemo {

    public static void main(String[] args) throws FileNotFoundException {

        /**
         * 打印决策表对应的drl文件。
         */
        File file = new File("/Users/dalididilo/Downloads/puyuan-iot/src/main/resources/com/puyuan/rules/xlsx_demo/xslx_demo.xlsx");
        InputStream in = new FileInputStream(file);
        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String drl = compiler.compile(in, InputType.XLS);
        System.out.println(drl);

        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
        KieSession kieSession = container.newKieSession("xlsx_demo");
        AlarmBean alarmBean = new AlarmBean();
        alarmBean.setType("001");
        alarmBean.setUp(50.0d);
        alarmBean.setLower(20.0d);
        InsertValue insertValue = new InsertValue();
        insertValue.setType("001");
        insertValue.setCollectValue(56.0d);
        kieSession.insert(alarmBean);
        kieSession.insert(insertValue);
        int count = kieSession.fireAllRules();
        System.out.println(insertValue.getGrade());
        System.out.println(String.format("总共执行 %d 条规则。",count));
        kieSession.dispose();
    }

}
