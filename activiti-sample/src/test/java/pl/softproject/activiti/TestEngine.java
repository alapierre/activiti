/**
 * Copyright 2016-03-23 the original author or authors.
 */
package pl.softproject.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class TestEngine {

    @Test
    public void test() {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        processEngine.getRepositoryService().createDeployment().addClasspathResource("workflow.bpmn").deploy();

        processEngine.getRuntimeService().startProcessInstanceByKey("helloWorld");

    }

}
