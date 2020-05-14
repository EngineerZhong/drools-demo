package com.puyuan.rules.test;

import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;

/**
 * @author dalididilo
 */
public class RunTimeImpl implements RuleRuntimeEventListener {
    @Override
    public void objectInserted(ObjectInsertedEvent objectInsertedEvent) {
        System.out.println("输出Insert方法");
    }

    @Override
    public void objectUpdated(ObjectUpdatedEvent objectUpdatedEvent) {
        System.out.println("输出Update方法");
    }

    @Override
    public void objectDeleted(ObjectDeletedEvent objectDeletedEvent) {
        System.out.println("输出Delete方法");
    }
}
