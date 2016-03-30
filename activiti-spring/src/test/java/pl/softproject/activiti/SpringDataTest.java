/**
 * Copyright 2016-03-30 the original author or authors.
 */
package pl.softproject.activiti;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-data-context.xml")
public class SpringDataTest {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Test
    public void test() {
        System.out.println("!!");

        ProcessInstance process = runtimeService.startProcessInstanceByKey("myProcess_1");

        Map<String, Object> vars = runtimeService.getVariables(process.getId());

        System.out.println(vars);

    }

}


