package com.ruleengine.hysc.fact;

import lombok.Data;

/**
 * @author dalididilo
 */
@Data
public class DroolsResult implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @org.kie.api.definition.type.Label(value = "标识符")
    private java.lang.String code;
    @org.kie.api.definition.type.Label(value = "结果")
    private java.lang.String info;

}