/**
 * Copyright 2016-03-25 the original author or authors.
 */
package pl.softproject.activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class TestActivitiRule {

    @Rule
    public ActivitiRule activitiRule = new ActivitiRule();

    private ProcessInstance startProcessInstance() {

        RuntimeService runtimeService = activitiRule.getRuntimeService();

        IdentityService identityService = activitiRule.getIdentityService();
        identityService.setAuthenticatedUserId("John Doe");

        Map<String, Object> vars = new HashMap<>();
        vars.put("isbn", "123445555");

        return runtimeService.startProcessInstanceByKey("helloWorld", vars);

    }

    private String createUser() {

        String userName = "tester";

        IdentityService identityService = activitiRule.getIdentityService();
        User user = identityService.newUser(userName);
        identityService.saveUser(user);

        return userName;

    }

    private void createGroupAndAddUser(String userName) {

        IdentityService identityService = activitiRule.getIdentityService();

        Group newGroup = identityService
                .newGroup("sales");
        newGroup.setName("Sales");

        identityService.saveGroup(newGroup);

        identityService.createMembership(userName, "sales");

    }

    @Test
    @Deployment(resources={"workflow-variables.bpmn"})
    public void test() {

        ProcessInstance processs = startProcessInstance();

        TaskService taskService = activitiRule.getTaskService();
        Task task = taskService.createTaskQuery()
                .taskCandidateGroup("sales")
                .singleResult();

        System.out.println(task);

        String userName = createUser();

        taskService.addCandidateUser(task.getId(), userName);

        task = taskService.createTaskQuery()
                .taskCandidateUser(userName)
                .singleResult();

        System.out.println("przydzielono do: " + task.getAssignee());

        taskService.claim(task.getId(), userName);

        task = taskService.createTaskQuery()
                .taskAssignee(userName)
                .singleResult();

        System.out.println("przydzielono do: " + task.getAssignee());

        taskService.complete(task.getId());

        System.out.println(processs.isEnded());

        HistoryService historyService =
                activitiRule.getHistoryService();

        HistoricProcessInstance historicProcessInstance =
                historyService
                        .createHistoricProcessInstanceQuery()
                        .processInstanceId(processs.getId())
                        .singleResult();

        System.out.println(historicProcessInstance.getStartTime());

        System.out.println(historicProcessInstance.getEndTime());

        System.out.println(historicProcessInstance.getStartUserId());

    }

    @Test
    @Deployment(resources={"workflow-variables.bpmn"})
    public void testAssignee() {

        ProcessInstance processs = startProcessInstance();
        String userName = createUser();
        createGroupAndAddUser(userName);

        TaskService taskService = activitiRule.getTaskService();

        Task task = taskService.createTaskQuery()
                .taskCandidateUser(userName)
                .singleResult();

        System.out.println(task);

    }

}
