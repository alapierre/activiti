/**
 * Copyright 2016-03-23 the original author or authors.
 */
package pl.softproject.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class TestEngineVariable {

    private static ProcessEngine processEngine;

    @BeforeClass
    public static void init() {

        processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getRepositoryService().createDeployment().addClasspathResource("workflow-variables.bpmn").deploy();

    }

    @Test
    public void test() {

        Map<String, Object> vars = new HashMap<>();

        vars.put("isbn", "123445555");


        processEngine.getRuntimeService().startProcessInstanceByKey("helloWorld", vars);

    }

}
