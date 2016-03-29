/**
 * Copyright 2016-03-29 the original author or authors.
 */
package pl.softproject.activiti;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/activiti-spring.xml")
public class SpringTest {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    private ProcessInstance startProcessInstance() {

        //identityService.setAuthenticatedUserId("John Doe");

        Map<String, Object> vars = new HashMap<>();
        vars.put("isbn", "123445555");

        return runtimeService.startProcessInstanceByKey("helloWorld", vars);

    }

    @Test
    public void test() {

        startProcessInstance();

    }
}
