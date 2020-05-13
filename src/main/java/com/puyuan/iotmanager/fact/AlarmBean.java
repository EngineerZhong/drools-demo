package com.puyuan.iotmanager.fact;


import lombok.Data;

/**
 * @author dalididilo
 */
@Data
public class AlarmBean implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @org.kie.api.definition.type.Label("传感器类型")
    private String type;
    @org.kie.api.definition.type.Label("报警等级")
    private String grade;
    @org.kie.api.definition.type.Label("上限值")
    private double up;
    @org.kie.api.definition.type.Label("下限值")
    private double lower;
    @org.kie.api.definition.type.Label("通道")
    private String tunnel;
    @org.kie.api.definition.type.Label("通道段")
    private String tunnelStation;
    @org.kie.api.definition.type.Label("分区")
    private String position;
    @org.kie.api.definition.type.Label("装置")
    private String device;

    @org.kie.api.definition.type.Label("监测类型")
    private String watchType;

}
