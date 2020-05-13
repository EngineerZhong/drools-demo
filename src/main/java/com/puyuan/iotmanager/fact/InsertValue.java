package com.puyuan.iotmanager.fact;

import lombok.Data;

/**
 * @author dalididilo
 */
@Data
public class InsertValue implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @org.kie.api.definition.type.Label("传感器类型")
    private String type;
    @org.kie.api.definition.type.Label("告警等级")
    private String grade;

    @org.kie.api.definition.type.Label("监测类型")
    private String watchType;

    @org.kie.api.definition.type.Label(value = "采集数值")
    private double collectValue;

}
