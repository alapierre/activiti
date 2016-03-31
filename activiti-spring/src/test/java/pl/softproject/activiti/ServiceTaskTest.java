/**
 * Copyright 2016-03-31 the original author or authors.
 */
package pl.softproject.activiti;

import org.activiti.engine.RuntimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/activiti-spring.xml")
public class ServiceTaskTest {

    @Autowired
    RuntimeService runtimeService;

    @Test
    public void initProces() {

        runtimeService.startProcessInstanceByKey("myProcess_1");

    }

}
