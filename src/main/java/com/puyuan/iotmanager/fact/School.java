package com.puyuan.iotmanager.fact;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class School {

    private String className;
    private String classCount;

    private String[] classNameArray;

    private List classNameList;

    private Set memberSet;

    private Map<String,String> keyValues;
}
