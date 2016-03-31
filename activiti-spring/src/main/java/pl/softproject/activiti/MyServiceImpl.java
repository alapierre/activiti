/**
 * Copyright 2016-03-31 the original author or authors.
 */
package pl.softproject.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class MyServiceImpl implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("wywołanie metody w klasie serwisowej");
    }
}
